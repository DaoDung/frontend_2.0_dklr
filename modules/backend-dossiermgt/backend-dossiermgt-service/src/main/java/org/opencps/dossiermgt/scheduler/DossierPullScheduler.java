package org.opencps.dossiermgt.scheduler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.HttpMethod;

import org.opencps.auth.utils.APIDateTimeUtils;
import org.opencps.dossiermgt.action.DossierActions;
import org.opencps.dossiermgt.action.PaymentFileActions;
import org.opencps.dossiermgt.action.impl.DossierActionsImpl;
import org.opencps.dossiermgt.action.impl.PaymentFileActionsImpl;
import org.opencps.dossiermgt.action.util.DossierMgtUtils;
import org.opencps.dossiermgt.action.util.MultipartUtility;
import org.opencps.dossiermgt.model.Dossier;
import org.opencps.dossiermgt.model.DossierAction;
import org.opencps.dossiermgt.model.DossierFile;
import org.opencps.dossiermgt.model.DossierPart;
import org.opencps.dossiermgt.model.DossierRequestUD;
import org.opencps.dossiermgt.model.PaymentFile;
import org.opencps.dossiermgt.model.ProcessAction;
import org.opencps.dossiermgt.model.ProcessOption;
import org.opencps.dossiermgt.model.ServiceConfig;
import org.opencps.dossiermgt.model.ServiceProcess;
import org.opencps.dossiermgt.service.DossierActionLocalServiceUtil;
import org.opencps.dossiermgt.service.DossierFileLocalServiceUtil;
import org.opencps.dossiermgt.service.DossierLocalServiceUtil;
import org.opencps.dossiermgt.service.DossierPartLocalServiceUtil;
import org.opencps.dossiermgt.service.DossierRequestUDLocalServiceUtil;
import org.opencps.dossiermgt.service.PaymentFileLocalServiceUtil;
import org.opencps.dossiermgt.service.ProcessActionLocalServiceUtil;
import org.opencps.dossiermgt.service.ProcessOptionLocalServiceUtil;
import org.opencps.dossiermgt.service.ServiceConfigLocalServiceUtil;
import org.opencps.dossiermgt.service.ServiceProcessLocalServiceUtil;
import org.opencps.dossiermgt.vr.utils.VRBusinessUtils;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import com.fds.vr.service.util.FileUploadUtils;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseSchedulerEntryMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.TimeUnit;
import com.liferay.portal.kernel.scheduler.TriggerFactory;
import com.liferay.portal.kernel.scheduler.TriggerFactoryUtil;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.HttpMethods;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

@Component(immediate = true, service = DossierPullScheduler.class)
public class DossierPullScheduler extends BaseSchedulerEntryMessageListener {
	//private final String serectKey = "OPENCPSV2";
	private static final int BUFFER_SIZE = 4096;
	private static volatile boolean isRunningPull = false;

	@Override
	protected void doReceive(Message message) throws Exception {

		if (!isRunningPull) {
			isRunningPull = true;
		} else {
			return;
		}
		_log.info("OpenCPS PULL DOSSIERS IS STARTING : " + APIDateTimeUtils.convertDateToString(new Date()));

		Company company = CompanyLocalServiceUtil.getCompanyByMx(PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));

		User systemUser = UserLocalServiceUtil.getUserByEmailAddress(company.getCompanyId(),
				RESTFulConfiguration.SERVER_USER);

		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setCompanyId(company.getCompanyId());
		serviceContext.setUserId(systemUser.getUserId());

		try {

			List<Dossier> dossierList = DossierLocalServiceUtil.getBySubmitting(true);

			if (dossierList != null && dossierList.size() > 0) {
				_log.info("dossierList : " + dossierList.size());
				for (Dossier dossier : dossierList) {
					pullDossier(company, dossier, systemUser);
				}
			}

		} catch (Exception e) {
		}
		isRunningPull = false;
		_log.info("OpenCPS PULL DOSSIERS IS DONE : " + APIDateTimeUtils.convertDateToString(new Date()));
	}

	private void pullDossier(Company company, Dossier dossier, User systemUser) throws PortalException {

		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setCompanyId(company.getCompanyId());
		serviceContext.setUserId(dossier.getUserId());

		long dossierId = dossier.getDossierId();
		long sourceGroupId = dossier.getGroupId();
		String referenceUid = dossier.getReferenceUid();
		String serverno = dossier.getServerNo();
		String serviceCode = dossier.getServiceCode();
		String govAgencyCode = dossier.getGovAgencyCode();
		String dossierTemplateNo = dossier.getDossierTemplateNo();

		List<ServiceProcess> processes = ServiceProcessLocalServiceUtil.getByServerNo(serverno);
		//List<ServiceProcess> syncProcesses = new ArrayList<ServiceProcess>();
		DossierActions actions = new DossierActionsImpl();

		long desGroupId = 0;
		long serviceProcessId = 0;
		ProcessOption option = null;
		for (ServiceProcess process : processes) {
			desGroupId = process.getGroupId();
			try {
				ServiceConfig config = ServiceConfigLocalServiceUtil.getBySICodeAndGAC(desGroupId, serviceCode,
						govAgencyCode);

				if (Validator.isNotNull(config)) {
					option = ProcessOptionLocalServiceUtil.getByDTPLNoAndServiceCF(desGroupId, dossierTemplateNo,
							config.getServiceConfigId());
					if (Validator.isNotNull(option)) {
						serviceProcessId = option.getServiceProcessId();
						break;
					}
				}
			} catch (Exception e) {
				_log.info("NOProcess");
			}

		}

		if (desGroupId > 0 && serviceProcessId > 0 && option != null) {

			Dossier desDossier = DossierLocalServiceUtil.getByRef(desGroupId, referenceUid);
			long userId = systemUser.getUserId();
			_log.info("userId: " + userId + "====desGroupId====="+desGroupId+"======serviceProcessId====="+serviceProcessId);

			if (Validator.isNull(desDossier)) {
				// Create DOSSIER
				_log.info("CREATE DOSSIER PULL");
				desDossier = DossierLocalServiceUtil.updateDossier(desGroupId, 0l, referenceUid, dossier.getCounter(),
						serviceCode, dossier.getServiceName(), govAgencyCode, dossier.getGovAgencyName(),
						dossier.getApplicantName(), dossier.getApplicantIdType(), dossier.getApplicantIdNo(),
						dossier.getApplicantIdDate(), dossier.getAddress(), dossier.getCityCode(),
						dossier.getCityName(), dossier.getDistrictCode(), dossier.getDistrictName(),
						dossier.getWardCode(), dossier.getWardName(), dossier.getContactName(),
						dossier.getContactTelNo(), dossier.getContactEmail(), dossierTemplateNo,
						dossier.getDossierNote(), dossier.getSubmissionNote(), dossier.getApplicantNote(),
						dossier.getBriefNote(), dossier.getDossierNo(), false, dossier.getCorrecttingDate(),
						dossier.getDossierStatus(), dossier.getDossierStatusText(), dossier.getDossierSubStatus(),
						dossier.getDossierSubStatusText(), 0l, 0l, dossier.getViaPostal(), dossier.getPostalAddress(),
						dossier.getPostalCityCode(), dossier.getPostalCityName(), dossier.getPostalTelNo(),
						dossier.getPassword(), dossier.getNotification(), dossier.getOnline(), dossier.getServerNo(),
						dossier.getSubmitDate() != null ? dossier.getSubmitDate() : new Date(), serviceContext);

				// get the list of payment file need to sync
				List<JSONObject> lsPaymentsFileSync = new ArrayList<>();
				getPaymentFiles(sourceGroupId, dossierId, lsPaymentsFileSync);

				// Do Pull paymentFile to client
				pullPaymentFile(sourceGroupId, dossierId, desDossier.getGroupId(), desDossier.getDossierId(),
						lsPaymentsFileSync, serviceContext);

				//long desDossierId = desDossier.getPrimaryKey();
				// doAction in this case is an Applicant object
				String applicantNote = dossier.getApplicantNote();
				String applicantName = dossier.getApplicantName();

				// Process doAction (with autoEvent = SUBMIT)
				try {

					ProcessAction processAction = ProcessActionLocalServiceUtil
							.fetchBySPI_PRESC_AEV(serviceProcessId, StringPool.BLANK, "SUBMIT");

					if (processAction != null && processAction.getProcessActionId() > 0 ) {
						_log.info("========serviceProcessId=======" + serviceProcessId + "=======GETPROCESSACTION************" + processAction.getActionName());
						actions.doAction(desGroupId, desDossier, option, processAction,
								processAction.getActionCode(), applicantName, applicantNote,
								processAction.getAssignUserId(), systemUser.getUserId(), StringPool.BLANK,
								StringPool.BLANK, serviceContext);
						//
						// TODO add sync DOSSIERFILE and PAYMENTFILE
						// get the list of file of source dossier need to sync
						List<DossierFile> dossierFileList = DossierFileLocalServiceUtil.getByDossierIdAndIsNew(dossierId, true);
						//getDossierFiles(sourceGroupId, dossierId, lsFileSync);
						if (dossierFileList != null && dossierFileList.size() > 0) {
							for (DossierFile dossierFile : dossierFileList) {
								dossierFile.setIsNew(false);
								dossierFile = DossierFileLocalServiceUtil.updateDossierFile(dossierFile);
								
								//Add by Dungnv - Add trackchanges and history
//								serviceContext.setScopeGroupId(dossier.getGroupId());
//								String partNo = dossierFile.getDossierPartNo();
//								
//								VRBusinessUtils.updateVRTrackchangesAndVRHistoryProfileForDossier(dossierFile.getFormDataDossierFile(), partNo, 
//										dossierFile.getDossierTemplateNo(), dossierId, dossier.getCompanyId(), 
//										dossierFile.getFileEntryId(), serviceContext);
							}
							_log.info("START pull dossier File1: ");
							pullDossierFiles(userId, desDossier.getGroupId(), desDossier.getDossierId(),
									dossierFileList, dossier, referenceUid, desDossier.getDossierActionId(),
									serviceContext);
						}
					}
					
				} catch (Exception e) {
					_log.error(e);
					_log.info("SyncDossierUnsuccessfully=========" + desDossier.getReferenceUid());
				}

			} else {
				_log.info("UPDATE_____IN_CASE_HAS_DES_DOSSIER___________");
				Date cancellingDate = dossier.getCancellingDate();
				Date correctingDate = dossier.getCorrecttingDate();
				Date endorsementDate = dossier.getEndorsementDate();
				_log.info("CANCELLING DATE: "+cancellingDate);

				if (Validator.isNotNull(cancellingDate)) {
					// Update cancellingDate
					_log.info("UPDATE____CANCELLING_DATE");
					desDossier.setCancellingDate(cancellingDate);
				}

				if (Validator.isNotNull(correctingDate)) {
					_log.info("UPDATE____CORRECTTING_DATE");
					// Update correctingDate
					desDossier.setCorrecttingDate(correctingDate);
				}

				if (Validator.isNotNull(endorsementDate)) {
					_log.info("UPDATE____ENDOSEMENT_DATE");
					// Update correctingDate
					desDossier.setEndorsementDate(endorsementDate);
				}
	
				// Update dossier
				DossierLocalServiceUtil.updateDossier(desDossier);

				// the resubmit case
				if (dossier.getSubmitting()) {
					// Check autoEvent
					ProcessAction processAction = null;
					DossierAction dossierAction = null;

					try {
						dossierAction = DossierActionLocalServiceUtil
								.getDossierAction(desDossier.getDossierActionId());

						processAction = ProcessActionLocalServiceUtil.fetchBySPI_PRESC_AEV(
								serviceProcessId, dossierAction.getStepCode(), "SUBMIT");
					} catch (Exception e) {
						_log.error(e);
					}

					// get the list of payment file need to sync
					List<JSONObject> lsPaymentsFileSync = new ArrayList<>();
					getPaymentFiles(sourceGroupId, dossierId, lsPaymentsFileSync);

					// Do Pull paymentFile to client
					pullPaymentFile(sourceGroupId, dossierId, desDossier.getGroupId(), desDossier.getDossierId(),
							lsPaymentsFileSync, serviceContext);
					
					serviceContext.setCompanyId(desDossier.getCompanyId());
					serviceContext.setScopeGroupId(desDossier.getGroupId());
					
					synDossierRequest(dossierId, desDossier.getDossierId(), serviceContext);

					if (Validator.isNotNull(processAction) && Validator.isNull(cancellingDate)) {
						// doAction in this case is an Applicant object
						String applicantNote = dossier.getApplicantNote();
						String applicantName = dossier.getApplicantName();
//						String actionNote = StringPool.BLANK;
//						if (dossierAction != null) {
//							actionNote = dossierAction.getActionNote();
//						}

						actions.doAction(desGroupId, desDossier, option, processAction,
								processAction.getActionCode(), applicantName, applicantNote,
								processAction.getAssignUserId(), systemUser.getUserId(), StringPool.BLANK,
								StringPool.BLANK, serviceContext);

						// TODO add sync DOSSIERFILE and PAYMENTFILE
						// get the list of file of source dossier need to sync
						List<DossierFile> dossierFileList = DossierFileLocalServiceUtil.getByDossierIdAndIsNew(dossierId, true);
						//getDossierFiles(sourceGroupId, dossierId, lsFileSync);
						if (dossierFileList != null && dossierFileList.size() > 0) {
							for (DossierFile dossierFile : dossierFileList) {
								dossierFile.setIsNew(false);
								dossierFile = DossierFileLocalServiceUtil.updateDossierFile(dossierFile);
								
								//Add by Dungnv - Add trackchanges and history
//								serviceContext.setScopeGroupId(dossier.getGroupId());
//								String partNo = dossierFile.getDossierPartNo();
//								
//								VRBusinessUtils.updateVRTrackchangesAndVRHistoryProfileForDossier(dossierFile.getFormDataDossierFile(), partNo, 
//										dossierFile.getDossierTemplateNo(), dossierId, dossier.getCompanyId(), 
//										dossierFile.getFileEntryId(), serviceContext);
							}
							_log.info("START pull dossier File1: ");
							pullDossierFiles(userId, desDossier.getGroupId(), desDossier.getDossierId(), dossierFileList,
									dossier, referenceUid, desDossier.getDossierActionId(), serviceContext);
						}

					} else {
						desDossier.setSubmitting(true);
					}
				}
			}

		}

		// ResetDossier
		resetDossier(sourceGroupId, referenceUid, true, serviceContext);

	}

	private void synDossierRequest(long srcDossierId, long desDossierId, ServiceContext context) {

		try {
			
			_log.info("****RUN SYN DOSSIER REQUEST****" +  srcDossierId );
			
			List<DossierRequestUD> dossierRequests = DossierRequestUDLocalServiceUtil.getDossierRequest(srcDossierId, 1);
			_log.info("****RUN SYN DOSSIER REQUEST**** 1" +dossierRequests.size() + " " + srcDossierId );

			for (DossierRequestUD dr : dossierRequests) {

				dr.setIsNew(0);

				DossierRequestUDLocalServiceUtil.updateDossierRequestUD(dr);
				
				context.setUserId(dr.getUserId());
				
				DossierRequestUDLocalServiceUtil.updateDossierRequest(0, desDossierId, dr.getReferenceUid(),
						dr.getRequestType(), dr.getComment(), 0, dr.getStatusReg(), context);

			}

		} catch (Exception e) {
			_log.error(e);
		}
	}

	private void getPaymentFiles(long srcGroupId, long srcDossierId, List<JSONObject> lsPaymentsFileSync) {

		try {

			InvokeREST rest = new InvokeREST();

			HashMap<String, String> properties = new HashMap<String, String>();
			properties.put("Content-Type", "application/x-www-form-urlencoded");

			String path = "dossiers/" + srcDossierId + "/payments";

			ServiceContext serviceContext = new ServiceContext();

			JSONObject resDossierFile = rest.callAPI(srcGroupId, HttpMethods.GET, "application/json",
					RESTFulConfiguration.SERVER_PATH_BASE, path, RESTFulConfiguration.SERVER_USER,
					RESTFulConfiguration.SERVER_PASS, properties, serviceContext);

			if (GetterUtil.getInteger(resDossierFile.get(RESTFulConfiguration.STATUS)) != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException(
						"Failed : HTTP error code : " + resDossierFile.get(RESTFulConfiguration.STATUS));
			} else {

				JSONObject jsData = JSONFactoryUtil
						.createJSONObject(resDossierFile.getString(RESTFulConfiguration.MESSAGE));

				JSONArray array = JSONFactoryUtil.createJSONArray(jsData.getString("data"));

				for (int i = 0; i < array.length(); i++) {
					JSONObject object = array.getJSONObject(i);

					if (GetterUtil.getInteger(object.get("isNew")) == 1) {
						lsPaymentsFileSync.add(object);
					}

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void pullPaymentFile(long srcGroupId, long srcDossierId, long groupId, long dossierId,
			List<JSONObject> syncPaymentFiles, ServiceContext context) throws PortalException {
		for (JSONObject object : syncPaymentFiles) {
			// Add paymentFile to CLIENT

			PaymentFileActions actions = new PaymentFileActionsImpl();

			// check paymentFile is exist
			PaymentFile paymentFile = PaymentFileLocalServiceUtil.fectPaymentFile(dossierId,
					object.getString("referenceUid"));

			if (Validator.isNull(paymentFile)) {
				paymentFile = actions.createPaymentFile(context.getUserId(), groupId, dossierId,
						object.getString("referenceUid"), object.getString("paymentFee"),
						object.getLong("paymentAmount"), object.getString("paymentNote"),
						object.getString("epaymentProfile"), object.getString("bankInfo"),
						object.getInt("paymentStatus"), object.getString("paymentMethod"),
						object.getString("paymentFormData"), context);
			}
			//
			// paymentFile.setPaymentStatus(object.getInt("paymentStatus"));
			paymentFile.setPaymentMethod(object.getString("paymentMethod"));

			PaymentFileLocalServiceUtil.updatePaymentFile(paymentFile);

			// Add fileConfirmId
			if (object.getLong("confirmFileEntryId") != 0) {
				// Download confirmFile form SERVER
				try {

					String fileRef = object.getString("referenceUid");

					// Get file from SERVER
					String path = "dossiers/" + srcDossierId + "/payments/" + fileRef + "/confirmfile";

					URL url = new URL(RESTFulConfiguration.SERVER_PATH_BASE + path);

					HttpURLConnection conn = (HttpURLConnection) url.openConnection();

					String authString = RESTFulConfiguration.SERVER_USER + ":" + RESTFulConfiguration.SERVER_PASS;

					String authStringEnc = new String(Base64.getEncoder().encodeToString(authString.getBytes()));

					conn.setRequestProperty("Authorization", "Basic " + authStringEnc);

					conn.setRequestMethod(HttpMethods.GET);
					conn.setDoInput(true);
					conn.setDoOutput(true);
					conn.setRequestProperty("Accept", "application/json");
					conn.setRequestProperty("groupId", String.valueOf(srcGroupId));

					int responseCode = conn.getResponseCode();

					if (responseCode != 200) {
						if (responseCode != 204) {
							throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
						}

					} else {

						InputStream is = conn.getInputStream();

						String raw = conn.getHeaderField("Content-Disposition");
						// raw = "attachment; filename=abc.jpg"
						File tempFile = null;

						if (raw != null && raw.indexOf("=") != -1) {
							String fileName = raw.split("=")[1];

							fileName = StringUtil.replace(fileName, "\"", StringPool.BLANK);

							tempFile = File.createTempFile(String.valueOf(System.currentTimeMillis()),
									StringPool.PERIOD + fileName);

						} else {
							tempFile = File.createTempFile(String.valueOf(System.currentTimeMillis()),
									StringPool.PERIOD + "tmp");
						}

						FileOutputStream outStream = new FileOutputStream(tempFile);

						int bytesRead = -1;
						byte[] buffer = new byte[BUFFER_SIZE];
						while ((bytesRead = is.read(buffer)) != -1) {
							outStream.write(buffer, 0, bytesRead);
						}

						outStream.close();
						is.close();

						String requestURL = RESTFulConfiguration.CLIENT_PATH_BASE + "dossiers/" + dossierId
								+ "/payments/" + fileRef + "/confirm";

						String clientAuthString = new String(Base64.getEncoder().encodeToString(
								(RESTFulConfiguration.CLIENT_USER + StringPool.COLON + RESTFulConfiguration.CLIENT_PASS)
										.getBytes()));

						pullPaymentFile(requestURL, "UTF-8", groupId, dossierId, clientAuthString, tempFile,
								StringPool.BLANK, object.getString("paymentMethod"), object.getString("confirmPayload"),
								context);

					}

					conn.disconnect();

				} catch (MalformedURLException e) {

					e.printStackTrace();
				} catch (IOException e) {

					e.printStackTrace();

				}

				// Add conformFile to CLIENT
			} else {
				try {
					String fileRef = object.getString("referenceUid");

					// Get file from SERVER
					String path = "dossiers/" + srcDossierId + "/payments/" + fileRef + "/confirm/noattachment";

					URL url = new URL(RESTFulConfiguration.SERVER_PATH_BASE + path);

					HttpURLConnection conn = (HttpURLConnection) url.openConnection();

					String authString = RESTFulConfiguration.SERVER_USER + ":" + RESTFulConfiguration.SERVER_PASS;

					String authStringEnc = new String(Base64.getEncoder().encodeToString(authString.getBytes()));

					conn.setRequestProperty("Authorization", "Basic " + authStringEnc);

					conn.setRequestMethod(HttpMethods.PUT);
					conn.setDoInput(true);
					conn.setDoOutput(true);
					conn.setRequestProperty("Accept", "application/json");
					conn.setRequestProperty("groupId", String.valueOf(srcGroupId));

					int responseCode = conn.getResponseCode();

					if (responseCode != 200) {
						if (responseCode != 204) {
							throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
						}

					} else {

						_log.info("PULL PAYMENT FILE" + dossierId + "fileReference" + fileRef);

						String requestURL = "dossiers/" + dossierId + "/payments/" + fileRef + "/confirm/noattachment";

						/*
						 * String clientAuthString = new
						 * String(Base64.getEncoder().encodeToString(
						 * (RESTFulConfiguration.CLIENT_USER + StringPool.COLON
						 * + RESTFulConfiguration.CLIENT_PASS) .getBytes()));
						 */

						InvokeREST callRest = new InvokeREST();

						HashMap<String, String> properties = new HashMap<String, String>();

						Map<String, Object> params = new HashMap<String, Object>();

						params.put("confirmNote", StringPool.BLANK);
						params.put("paymentMethod", object.getString("paymentMethod"));
						params.put("confirmPayload", object.getString("confirmPayload"));
						params.put("isSync", StringPool.FALSE);

						callRest.callPostAPI(groupId, HttpMethod.PUT, "application/json",
								RESTFulConfiguration.CLIENT_PATH_BASE, requestURL, RESTFulConfiguration.CLIENT_USER,
								RESTFulConfiguration.CLIENT_PASS, properties, params, context);

						/*
						 * pullPaymentFileNoAttach(requestURL, "UTF-8", groupId,
						 * dossierId, clientAuthString, StringPool.BLANK,
						 * object.getString("paymentMethod"),
						 * object.getString("confirmPayload"), context);
						 */

					}

					conn.disconnect();

				} catch (MalformedURLException e) {

					e.printStackTrace();
				} catch (IOException e) {

					e.printStackTrace();

				}

			}

		}
	}

	private void resetDossier(long groupId, String refId, boolean isServer, ServiceContext serviceContext) {

		// RESET submitting
		DossierActions actions = new DossierActionsImpl();
		try {
			Dossier dossier = DossierMgtUtils.getDossier(refId, groupId);

			actions.resetDossier(groupId, dossier.getDossierId(), dossier.getReferenceUid(), serviceContext);

		} catch (Exception e) {
			_log.error(e);
			_log.info("Can't reset DOSSIER has groupId=" + groupId + " and ref=" + refId
					+ (isServer ? "in SERVER" : " in CLIENT"));
		}

	}

	private void pullDossierFiles(long userId, long desGroupId, long desDossierId, List<DossierFile> dossierFileList,
			Dossier dossier, String dossierRef, long dossierActionId, ServiceContext serviceContext)
			throws PortalException {

		for (DossierFile dossierFile : dossierFileList) {
			String fileRef = dossierFile.getReferenceUid();

			if (dossierFile.getRemoved()) {
				// remove file in CLIENT
				_log.info("referenceUid" + fileRef);
				_log.info("dossierId" + desDossierId);
				_log.info("srcDossierId" + dossier.getDossierId());
				DossierFile file = DossierFileLocalServiceUtil.getDossierFileByReferenceUid(desDossierId, fileRef);
				if (file != null) {
					file.setRemoved(true);
					DossierFileLocalServiceUtil.updateDossierFile(file);
				}
			} else {
				try {
					_log.info("START update dossier File not Removed: " + false);
					//DossierFile srcDossierFile = DossierFileLocalServiceUtil.getDossierFileByReferenceUid(srcDossierId,
					//		fileRef);
					//srcDossierFile.setIsNew(false);
					//DossierFileLocalServiceUtil.updateDossierFile(srcDossierFile);

					// Get file from SERVER
					_log.info("dossier.getDossierId(): " + dossier.getDossierId() + " ==== fileRef: " + fileRef);
					String path = "dossiers/" + dossier.getDossierId() + "/files/" + fileRef;

					URL url = new URL(RESTFulConfiguration.SERVER_PATH_BASE + path);

					HttpURLConnection conn = (HttpURLConnection) url.openConnection();

					String authString = RESTFulConfiguration.SERVER_USER + ":" + RESTFulConfiguration.SERVER_PASS;

					String authStringEnc = new String(Base64.getEncoder().encodeToString(authString.getBytes()));

					conn.setRequestProperty("Authorization", "Basic " + authStringEnc);

					conn.setRequestMethod(HttpMethods.GET);
					conn.setDoInput(true);
					conn.setDoOutput(true);
					conn.setRequestProperty("Accept", "application/json");
					conn.setRequestProperty("groupId", String.valueOf(dossier.getGroupId()));

					int responseCode = conn.getResponseCode();
					_log.info("responseCode: " + responseCode);

					if (responseCode != 200) {

						if (responseCode != 204) {
							throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
						} else {
							// Sync FormData
							_log.info("Sync FormData START ERROR:****** ");
							String dossierTemplateNo = dossierFile.getDossierTemplateNo();
							//Edit by Dungnv: dossierTemplateNo -> dossierFile.getFileTemplateNo()
							DossierPart part = DossierPartLocalServiceUtil.getByFileTemplateNo(desGroupId,
									dossierFile.getFileTemplateNo());
							if (part != null) {
								//Add by Dungnv
						        long formDataFileEntryId = dossierFile.getFormDataDossierFile();
						        pullFormData(desGroupId, fileRef, dossierTemplateNo, desDossierId, formDataFileEntryId, part,
										dossierActionId, serviceContext);
						        //Comment by Dungnv
								//String formData = dossierFile.getFormData();
								//_log.info("formData: " + formData);
								//pullFormData(desGroupId, fileRef, dossierTemplateNo, desDossierId, formData, part,
								//		dossierActionId, serviceContext);
							}
						}
					} else {

						_log.info("Sync FormData START NOTTTT ERROR:****** ");
						_log.info("dossierId: " + desDossierId);
						_log.info("ReferenceUid fileRef: " + fileRef);
						DLFileEntry fileEntry = DLFileEntryLocalServiceUtil
								.fetchDLFileEntry(dossierFile.getFileEntryId());
						DossierFile file = DossierFileLocalServiceUtil.getDossierFileByReferenceUid(desDossierId,
								fileRef);

						if (Validator.isNull(file)) {

							_log.info("dossierFile NULL:****** ");
							InputStream is = conn.getInputStream();

							File tempFile = File.createTempFile(String.valueOf(System.currentTimeMillis()),
									StringPool.PERIOD + fileEntry.getExtension());

							FileOutputStream outStream = new FileOutputStream(tempFile);

							int bytesRead = -1;
							byte[] buffer = new byte[BUFFER_SIZE];
							while ((bytesRead = is.read(buffer)) != -1) {
								outStream.write(buffer, 0, bytesRead);
							}

							outStream.close();
							is.close();

							String requestURL = RESTFulConfiguration.CLIENT_PATH_BASE + "dossiers/" + desDossierId
									+ "/files";

							String clientAuthString = new String(
									Base64.getEncoder().encodeToString((RESTFulConfiguration.CLIENT_USER
											+ StringPool.COLON + RESTFulConfiguration.CLIENT_PASS).getBytes()));

							//Add by Dungnv
					        String formData = StringPool.BLANK;
					    	File formDataFile = FileUploadUtils.getFile(dossierFile.getFormDataDossierFile());
							if (formDataFile != null) {
								formData = FileUploadUtils.fileToString(formDataFile);
							}
							if (formData.isEmpty()) {
								formData = dossierFile.getFormData();
							}
					        pullDossierFile(requestURL, "UTF-8", desGroupId, desDossierId, clientAuthString, tempFile,
									dossierFile.getDossierTemplateNo(), dossierFile.getDossierPartNo(),
									dossierFile.getFileTemplateNo(), dossierFile.getDisplayName(),
									formData, dossierRef, fileRef, dossierFile.getFormDataDossierFile(), serviceContext);
					        //Comment by Dungnv
							//pullDossierFile(requestURL, "UTF-8", desGroupId, desDossierId, clientAuthString, tempFile,
							//		dossierFile.getDossierTemplateNo(), dossierFile.getDossierPartNo(),
							//		dossierFile.getFileTemplateNo(), dossierFile.getDisplayName(),
							//		dossierFile.getFormData(), dossierRef, fileRef, serviceContext);
						} else {
							// Sync FormData
							_log.info("Sync FormData START ERROR:****** ");
							String dossierTemplateNo = dossierFile.getDossierTemplateNo();
							//Edit by Dungnv: dossierTemplateNo -> dossierFile.getFileTemplateNo()
							DossierPart part = DossierPartLocalServiceUtil.getByFileTemplateNo(desGroupId,
									dossierFile.getFileTemplateNo());
							if (part != null) {
								//Add by Dungnv
						        long formDataFileEntryId = dossierFile.getFormDataDossierFile();
						        pullFormData(desGroupId, fileRef, dossierTemplateNo, desDossierId, formDataFileEntryId, part,
										dossierActionId, serviceContext);
						        //Comment by Dungnv
								//String formData = dossierFile.getFormData();
								//_log.info("formData: " + formData);
								//pullFormData(desGroupId, fileRef, dossierTemplateNo, desDossierId, formData, part,
								//		dossierActionId, serviceContext);
							}

							// TODO: Write file upload sync
							InputStream is = conn.getInputStream();

							File tempFile = File.createTempFile(String.valueOf(System.currentTimeMillis()),
									StringPool.PERIOD + fileEntry.getExtension());

							FileOutputStream outStream = new FileOutputStream(tempFile);

							int bytesRead = -1;
							byte[] buffer = new byte[BUFFER_SIZE];
							while ((bytesRead = is.read(buffer)) != -1) {
								outStream.write(buffer, 0, bytesRead);
							}

							outStream.close();
							is.close();
							// Update file entry
							_log.info("START UPDATE FILE ENTRY");
							DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil
									.fetchDLFileEntry(file.getFileEntryId());

							DLAppLocalServiceUtil.updateFileEntry(userId, dlFileEntry.getFileEntryId(),
									dlFileEntry.getTitle(), dlFileEntry.getMimeType(), dlFileEntry.getTitle(),
									dlFileEntry.getDescription(), StringPool.BLANK, true, tempFile, serviceContext);
							_log.info("END UPDATE FILE ENTRY");
						}

					}
					conn.disconnect();

				} catch (MalformedURLException e) {
					_log.error(e);
				} catch (IOException e1) {
					_log.error(e1);

				}
			}
			
			//Add by Dungnv - Add trackchanges and history
			serviceContext.setScopeGroupId(desGroupId);
			String partNo = dossierFile.getDossierPartNo();
			
			VRBusinessUtils.updateVRTrackchangesAndVRHistoryProfileForDossier(dossierFile.getFormDataDossierFile(), partNo, 
					dossierFile.getDossierTemplateNo(), desDossierId, dossier.getCompanyId(), 
					dossierFile.getFileEntryId(), serviceContext);
		}

	}

	private void pullPaymentFile(String requestURL, String charset, long desGroupId, long dossierId,
			String authStringEnc, File file, String confirmNote, String paymentMethod, String confirmPayload,
			ServiceContext serviceContext) {

		try {
			MultipartUtility multipart = new MultipartUtility(requestURL, charset, desGroupId, authStringEnc,
					HttpMethod.PUT);
			// TODO; check logic here, if ref fileId in SERVER equal CLIENT

			multipart.addFilePart("file", file);
			multipart.addFormField("confirmNote", confirmNote);
			multipart.addFormField("paymentMethod", paymentMethod);
			multipart.addFormField("confirmPayload", confirmPayload);

			multipart.finish();
			//JSONObject object = JSONFactoryUtil.createJSONObject();
//			List<String> response = multipart.finish();

			// resetDossier(desGroupId, dossierRef, false, serviceContext);

		} catch (Exception e) {
			_log.error(e);
		}

	}

//	private void pullPaymentFileNoAttach(String requestURL, String charset, long desGroupId, long dossierId,
//			String authStringEnc, String confirmNote, String paymentMethod, String confirmPayload,
//			ServiceContext serviceContext) {
//
//		try {
//
//			MultipartUtility multipart = new MultipartUtility(requestURL, charset, desGroupId, authStringEnc,
//					HttpMethod.PUT);
//			// TODO; check logic here, if ref fileId in SERVER equal CLIENT
//
//			multipart.addFormField("confirmNote", confirmNote);
//			multipart.addFormField("paymentMethod", paymentMethod);
//			multipart.addFormField("confirmPayload", confirmPayload);
//
//			JSONObject object = JSONFactoryUtil.createJSONObject();
//
//			List<String> response = multipart.finish();
//
//			// resetDossier(desGroupId, dossierRef, false, serviceContext);
//
//		} catch (Exception e) {
//			_log.error(e);
//		}
//
//	}

	private void pullDossierFile(String requestURL, String charset, long desGroupId, long dossierId,
			String authStringEnc, File file, String dossierTemplateNo, String dossierPartNo, String fileTemplateNo,
			String displayName, String formData, String dossierRef, String fileRef, long formDataDossierFile, ServiceContext serviceContext) {

		_log.info("START update FORMDATA*****");
		try {
			MultipartUtility multipart = new MultipartUtility(requestURL, charset, desGroupId, authStringEnc);
			// TODO; check logic here, if ref fileId in SERVER equal CLIENT

			multipart.addFilePart("file", file);
			multipart.addFormField("referenceUid", fileRef);
			multipart.addFormField("dossierTemplateNo", dossierTemplateNo);
			multipart.addFormField("dossierPartNo", dossierPartNo);
			multipart.addFormField("fileTemplateNo", fileTemplateNo);
			multipart.addFormField("displayName", displayName);
			multipart.addFormField("fileType", StringPool.BLANK);
			multipart.addFormField("isSync", StringPool.BLANK);
			multipart.addFormField("formData", formData);
			multipart.addFormField("formDataDossierFile", String.valueOf(formDataDossierFile));

			_log.info("START update FORMDATA*****referenceUid"+fileRef);
			_log.info("START update FORMDATA*****dossierTemplateNo"+dossierTemplateNo);
			_log.info("START update FORMDATA*****dossierPartNo"+dossierPartNo);
			_log.info("START update FORMDATA*****fileTemplateNo"+fileTemplateNo);
			_log.info("START update FORMDATA*****displayName"+displayName);
			_log.info("START update FORMDATA*****formData"+formData);
			_log.info("START update FORMDATA*****formDataDossierFile"+formDataDossierFile);
			
			multipart.finish();
			resetDossier(desGroupId, dossierRef, false, serviceContext);

		} catch (Exception e) {
			_log.error(e);
		}

	}

//	private void pullPaymentFiles(long srcGroupId, long desDossierId) throws PortalException {
//		// get all paymentFile need to sync
//
//		//
//	}

//	Comment by Dungnv
//	private void pullFormData(long desGroupId, String fileRef, String dossierTemplateNo, long dossierId,
//			String formData, DossierPart part, long dossierActionId, ServiceContext serviceContext) {
//		try {
//			DossierFile dossierFile = DossierFileLocalServiceUtil.getDossierFileByReferenceUid(dossierId, fileRef);
//			if (Validator.isNull(dossierFile)) {
//				// create dossierFile
//				dossierFile = DossierFileLocalServiceUtil.addDossierFile(desGroupId, dossierId,
//						PortalUUIDUtil.generate(), dossierTemplateNo, part.getPartNo(), part.getFileTemplateNo(),
//						part.getPartName(), StringPool.BLANK, 0, null, StringPool.BLANK, StringPool.FALSE,
//						dossierActionId, serviceContext);
//			}
//
//			dossierFile.setFormData(formData);
//
//			DossierFileLocalServiceUtil.updateDossierFile(dossierFile);
//
//		} catch (Exception e) {
//			_log.error(e);
//		}
//	}

	//Add by Dungnv
	private void pullFormData(long desGroupId, String fileRef, String dossierTemplateNo, long dossierId,
			long formDataDossierFile, DossierPart part, long dossierActionId, ServiceContext serviceContext) {
		try {
			DossierFile dossierFile = DossierFileLocalServiceUtil.getDossierFileByReferenceUid(dossierId, fileRef);
			if (Validator.isNull(dossierFile)) {
				// create dossierFile
				dossierFile = DossierFileLocalServiceUtil.addDossierFile(desGroupId, dossierId,
						fileRef, dossierTemplateNo, part.getPartNo(), part.getFileTemplateNo(),
						part.getPartName(), StringPool.BLANK, 0, null, StringPool.BLANK, StringPool.FALSE,
						dossierActionId, serviceContext);
			}

			dossierFile.setFormDataDossierFile(formDataDossierFile);

			DossierFileLocalServiceUtil.updateDossierFile(dossierFile);

		} catch (Exception e) {
			_log.error(e);
		}
	}

	
//	private void updateFormData(long desGroupId, List<String> response, long dossierId, String formData,
//			ServiceContext serviceContext) throws PortalException {
//
//		StringBuilder sb = new StringBuilder();
//
//		for (String line : response) {
//			sb.append(line);
//		}
//
//		JSONObject jsDossierFile = JSONFactoryUtil.createJSONObject(sb.toString());
//
//		String fileRef = jsDossierFile.getString("referenceUid");
//
//		// Update formData
//
//		DossierFile dossierFile = DossierFileLocalServiceUtil.getDossierFileByReferenceUid(dossierId, fileRef);
//
//		if (Validator.isNotNull(dossierFile)) {
//			dossierFile.setFormData(formData);
//
//			DossierFileLocalServiceUtil.updateDossierFile(dossierFile);
//		}
//		// DossierFileLocalServiceUtil.updateFormData(desGroupId, dossierId,
//		// fileRef, formData, serviceContext);
//
//	}

	public void pullRequestDossiers(long dossierId, long desDossierId) {
		// TODO need update use API not use LocalService

		try {
			List<DossierRequestUD> lsDossierRequest = DossierRequestUDLocalServiceUtil.getDossierRequest(dossierId, 1);

			ServiceContext context = new ServiceContext();

			context.setUserId(0);
			context.setScopeGroupId(55301);

			for (DossierRequestUD dr : lsDossierRequest) {
				// update to client

				DossierRequestUDLocalServiceUtil.updateDossierRequest(0, desDossierId, dr.getReferenceUid(),
						dr.getRequestType(), dr.getComment(), 0, dr.getStatusReg(), context);
			}

		} catch (Exception e) {

		}
	}

	@Activate
	@Modified
	protected void activate() {
		schedulerEntryImpl.setTrigger(TriggerFactoryUtil.createTrigger(getEventListenerClass(), getEventListenerClass(),
				10, TimeUnit.SECOND));
		_schedulerEngineHelper.register(this, schedulerEntryImpl, DestinationNames.SCHEDULER_DISPATCH);
	}

	@Deactivate
	protected void deactivate() {
		_schedulerEngineHelper.unregister(this);
	}

	@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
	protected void setModuleServiceLifecycle(ModuleServiceLifecycle moduleServiceLifecycle) {
	}

	@Reference(unbind = "-")
	protected void setSchedulerEngineHelper(SchedulerEngineHelper schedulerEngineHelper) {

		_schedulerEngineHelper = schedulerEngineHelper;
	}

	@Reference(unbind = "-")
	protected void setTriggerFactory(TriggerFactory triggerFactory) {
	}

	private SchedulerEngineHelper _schedulerEngineHelper;

	private Log _log = LogFactoryUtil.getLog(DossierPullScheduler.class);
}
