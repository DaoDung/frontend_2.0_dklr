package dklr.application;

import com.fds.vr.business.action.VRApplicantProfileAction;
import com.fds.vr.business.action.VRCOPReportRepositoryAction;
import com.fds.vr.business.action.VRHistoryProfileAction;
import com.fds.vr.business.action.VRIssueAction;
import com.fds.vr.business.action.VRProductionPlantAction;
import com.fds.vr.business.action.VRTrackchangesAction;
import com.fds.vr.business.action.VRVehicleTypeCertificateAction;
import com.fds.vr.business.action.impl.VRApplicantProfileActionImpl;
import com.fds.vr.business.action.impl.VRCOPReportRepositoryActionImpl;
import com.fds.vr.business.action.impl.VRHistoryProfileActionImpl;
import com.fds.vr.business.action.impl.VRIssueActionImpl;
import com.fds.vr.business.action.impl.VRProductionPlantActionImpl;
import com.fds.vr.business.action.impl.VRTrackchangesActionImpl;
import com.fds.vr.business.action.impl.VRVehicleTypeCertificateActionImpl;
import com.fds.vr.business.model.VRApplicantProfile;
import com.fds.vr.business.model.VRCOPReportRepository;
import com.fds.vr.business.model.VRES;
import com.fds.vr.business.model.VRInspectionStandard;
import com.fds.vr.business.model.VRIssue;
import com.fds.vr.business.model.VRProductionPlant;
import com.fds.vr.business.model.VRTechnicalSpec_LKXCG;
import com.fds.vr.business.model.VRTechnicalSpec_LKXMY;
import com.fds.vr.business.model.VRTechnicalSpec_XCG;
import com.fds.vr.business.model.VRTechnicalSpec_XCH;
import com.fds.vr.business.model.VRTechnicalSpec_XCN;
import com.fds.vr.business.model.VRTechnicalSpec_XDD;
import com.fds.vr.business.model.VRTechnicalSpec_XMY;
import com.fds.vr.business.model.VRVehicleSpecification;
import com.fds.vr.business.model.VRVehicleTypeCertificate;
import com.fds.vr.business.model.impl.VRApplicantProfileModelImpl;
import com.fds.vr.business.model.impl.VRInspectionStandardModelImpl;
import com.fds.vr.business.model.impl.VRProductionPlantModelImpl;
import com.fds.vr.business.model.impl.VRTechnicalSpec_LKXCGModelImpl;
import com.fds.vr.business.model.impl.VRVehicleSpecificationModelImpl;
import com.fds.vr.business.model.impl.VRVehicleTypeCertificateModelImpl;
import com.fds.vr.business.service.VRApplicantProfileLocalServiceUtil;
import com.fds.vr.business.service.VRCOPProdEquipmentLocalServiceUtil;
import com.fds.vr.business.service.VRCOPProductTypeLocalServiceUtil;
import com.fds.vr.business.service.VRCOPProductionPlantEmployeeLocalServiceUtil;
import com.fds.vr.business.service.VRCOPProductionPlantEquipmentLocalServiceUtil;
import com.fds.vr.business.service.VRCOPReportAttachLocalServiceUtil;
import com.fds.vr.business.service.VRCOPReportRepositoryLocalServiceUtil;
import com.fds.vr.business.service.VRInspectionStandardLocalServiceUtil;
import com.fds.vr.business.service.VRIssueLocalServiceUtil;
import com.fds.vr.business.service.VRTechnicalSpec_LKXCGLocalServiceUtil;
import com.fds.vr.business.service.VRTechnicalSpec_LKXMYLocalServiceUtil;
import com.fds.vr.business.service.VRTechnicalSpec_XCGLocalServiceUtil;
import com.fds.vr.business.service.VRTechnicalSpec_XCHLocalServiceUtil;
import com.fds.vr.business.service.VRTechnicalSpec_XCNLocalServiceUtil;
import com.fds.vr.business.service.VRTechnicalSpec_XDDLocalServiceUtil;
import com.fds.vr.business.service.VRTechnicalSpec_XMYLocalServiceUtil;
import com.fds.vr.business.service.VRVehicleSpecificationLocalServiceUtil;
import com.fds.vr.business.service.VRVehicleTypeCertificateLocalServiceUtil;
import com.fds.vr.service.util.BusinessUtil;
import com.fds.vr.service.util.FileUploadUtils;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.StringPool;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.opencps.auth.api.BackendAuth;
import org.opencps.auth.api.BackendAuthImpl;
import org.opencps.auth.api.exception.UnauthenticationException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import dklr.context.provider.CompanyContextProvider;
import dklr.context.provider.LocaleContextProvider;
import dklr.context.provider.ServiceContextProvider;
import dklr.context.provider.UserContextProvider;

/**
 * @author BinhTH
 */
@Component(immediate = true, property = { "jaxrs.application=true" }, service = Application.class)
public class DklrApplication extends Application {

	public static final String CLASS_NAME = VRES.class.getName();
	public static final Log _log = LogFactoryUtil.getLog(DklrApplication.class);

	public Set<Object> getSingletons() {
		Set<Object> singletons = new HashSet<Object>();

		// add service provider
		singletons.add(_serviceContextProvider);
		singletons.add(_companyContextProvider);
		singletons.add(_localeContextProvider);
		singletons.add(_userContextProvider);

		return singletons;
	}

	@GET
	@Produces("text/plain")
	public String working() {
		return "ping!";
	}

	@POST
	@Path("/_search")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public String getData(@Context HttpServletRequest request, @Context HttpHeaders header, @Context Company company,
			@Context Locale locale, @Context User user, @Context ServiceContext serviceContext, String body) {

		JSONObject result = JSONFactoryUtil.createJSONObject();
		result.put("total", 0);
		result.put("data", JSONFactoryUtil.createJSONArray());

		try {

			JSONObject bodyRoot = JSONFactoryUtil.createJSONObject(body);
			// String indice = bodyRoot.getString("indice");
			JSONObject queryObject = bodyRoot.getJSONObject("query");

			result = ElasticQueryWrapUtil.POST_search(queryObject.toJSONString(), CLASS_NAME, company.getCompanyId());
			// System.out.println("DklrApplication.bodyObject()" + result);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return result.toJSONString();
	};

	@POST
	@Path("/indexing/applicant")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response indexingApplicantProfile(@Context HttpServletRequest request, @Context HttpHeaders header,
			@Context Company company, @Context Locale locale, @Context User user,
			@Context ServiceContext serviceContext) {
		try {
			List<VRApplicantProfile> vrApplicantProfiles = VRApplicantProfileLocalServiceUtil
					.getVRApplicantProfiles(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			if (vrApplicantProfiles != null && !vrApplicantProfiles.isEmpty()) {
				vrApplicantProfiles.parallelStream().forEach(vrApplicantProfile -> {
					VRApplicantProfileAction action = new VRApplicantProfileActionImpl();
					action.indexing(vrApplicantProfile, company);
				});
			}

			return Response.status(200).entity("done").build();
		} catch (Exception e) {
			_log.error(e);
			return Response.status(500).entity("Indexing failed!").build();
		}
	}

	@POST
	@Path("/indexing/vehicletypecertificate")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response indexingVehicleType(@Context HttpServletRequest request, @Context HttpHeaders header,
			@Context Company company, @Context Locale locale, @Context User user,
			@Context ServiceContext serviceContext) {
		try {
			List<VRVehicleTypeCertificate> vrVehicleTypeCertificates = VRVehicleTypeCertificateLocalServiceUtil
					.getVRVehicleTypeCertificates(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			if (vrVehicleTypeCertificates != null && !vrVehicleTypeCertificates.isEmpty()) {
				vrVehicleTypeCertificates.parallelStream().forEach(vrVehicleTypeCertificate -> {
					VRVehicleTypeCertificateAction action = new VRVehicleTypeCertificateActionImpl();
					action.indexing(vrVehicleTypeCertificate, company);
				});
			}
			return Response.status(200).entity("done").build();
		} catch (Exception e) {
			_log.error(e);
			return Response.status(500).entity("Indexing failed").build();
		}
	}

	@POST
	@Path("/indexing/cop")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response indexingCOP(@Context HttpServletRequest request, @Context HttpHeaders header,
			@Context Company company, @Context Locale locale, @Context User user,
			@Context ServiceContext serviceContext) {
		try {
			List<VRCOPReportRepository> vrcopReportRepositories = VRCOPReportRepositoryLocalServiceUtil
					.getVRCOPReportRepositories(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			if (vrcopReportRepositories != null && !vrcopReportRepositories.isEmpty()) {
				vrcopReportRepositories.parallelStream().forEach(vrcopReportRepository -> {
					VRCOPReportRepositoryAction action = new VRCOPReportRepositoryActionImpl();
					action.indexing(vrcopReportRepository, company);
				});
			}
			return Response.status(200).entity("done").build();
		} catch (Exception e) {
			_log.error(e);
			return Response.status(500).entity("Indexing failed!").build();
		}
	}

	@POST
	@Path("/post")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response processData(@Context HttpServletRequest request, @Context HttpHeaders header,
			@Context Company company, @Context Locale locale, @Context User user,
			@Context ServiceContext serviceContext, String body) throws UnauthenticationException {

		JSONObject result = JSONFactoryUtil.createJSONObject();
		JSONObject status = JSONFactoryUtil.createJSONObject();
		status.put("code", 500);
		status.put("msg", "error");

		BackendAuth auth = new BackendAuthImpl();
		if (!auth.isAuth(serviceContext)) {
			throw new UnauthenticationException();
		}

		JSONObject data = JSONFactoryUtil.createJSONObject();
		try {

			JSONObject bodyRoot = JSONFactoryUtil.createJSONObject(body);
			String indice = bodyRoot.getString("indice");
			String postStatus = "draft";
			postStatus = bodyRoot.getString("postStatus");
			JSONObject bodyObject = bodyRoot.getJSONObject("body");
			JSONArray key = bodyObject.names();
			JSONObject valueObject = JSONFactoryUtil.createJSONObject();
			JSONObject esData = JSONFactoryUtil.createJSONObject();
			esData.put(Field.MODIFIED_DATE + "_es", new Date().getTime());
			switch (indice) {
			case "vr_COPReportRepository":
				VRCOPReportRepository vrcopReportRepository = null;
				for (int i = 0; i < key.length(); ++i) {
					String keys = key.getString(i);
					if (keys.toLowerCase().equalsIgnoreCase("vr_copreportrepository")) {
						valueObject = bodyObject.getJSONObject(keys);
						esData.put("dossierId", String.valueOf(valueObject.getLong("dossierId")));
						esData.put("dossierIdCTN", valueObject.getString("dossierIdCTN"));
						esData.put("dossierNo", valueObject.getString("dossierNo"));
						esData.put("type_es", keys.toLowerCase());
						vrcopReportRepository = VRCOPReportRepositoryLocalServiceUtil.adminProcessData(valueObject,
								valueObject.getLong("dossierId"));
						esData.put("id", String.valueOf(vrcopReportRepository.getId()));
						break;
					}
				}
				if (vrcopReportRepository != null) {
					for (int i = 0; i < key.length(); ++i) {
						String keys = key.getString(i);
						if (keys.toLowerCase().equalsIgnoreCase("vr_copproductionplantemployee")) {
							JSONArray arrayData = bodyObject.getJSONArray(keys);
							int lenght = VRCOPProductionPlantEmployeeLocalServiceUtil.adminProcessData(arrayData,
									vrcopReportRepository.getMtCore(), vrcopReportRepository.getId(),
									vrcopReportRepository.getDossierId(), vrcopReportRepository.getDossierIdCTN(),
									vrcopReportRepository.getDossierNo());
							if (lenght < arrayData.length() - 1) {
								bodyObject.remove("vr_ProductionPlantEmployee");
							}
						} else if (keys.toLowerCase().equalsIgnoreCase("vr_copproductionplantequipment")) {
							JSONArray arrayData = bodyObject.getJSONArray(keys);
							int lenght = VRCOPProductionPlantEquipmentLocalServiceUtil.adminProcessData(arrayData,
									vrcopReportRepository.getMtCore(), vrcopReportRepository.getId(),
									vrcopReportRepository.getDossierId(), vrcopReportRepository.getDossierIdCTN(),
									vrcopReportRepository.getDossierNo());
							if (lenght < arrayData.length() - 1) {
								bodyObject.remove("vr_ProductionPlantEquipment");
							}
						} else if (keys.toLowerCase().equalsIgnoreCase("vr_copproductionplantprodequipment")) {
							JSONArray arrayData = bodyObject.getJSONArray(keys);
							int lenght = VRCOPProdEquipmentLocalServiceUtil.adminProcessData(arrayData,
									vrcopReportRepository.getMtCore(), vrcopReportRepository.getId(),
									vrcopReportRepository.getDossierId(), vrcopReportRepository.getDossierIdCTN(),
									vrcopReportRepository.getDossierNo());
							if (lenght < arrayData.length() - 1) {
								bodyObject.remove("vr_ProductionPlantProdEquipment");
							}
						} else if (keys.toLowerCase().equalsIgnoreCase("vr_copproducttype")) {
							JSONArray arrayData = bodyObject.getJSONArray(keys);
							int lenght = VRCOPProductTypeLocalServiceUtil.adminProcessData(arrayData,
									vrcopReportRepository.getMtCore(), vrcopReportRepository.getId(),
									vrcopReportRepository.getDossierId(), vrcopReportRepository.getDossierIdCTN(),
									vrcopReportRepository.getDossierNo());
							if (lenght < arrayData.length() - 1) {
								bodyObject.remove("vr_ProductType");
							}
						} else if (keys.toLowerCase().equalsIgnoreCase("vr_copproductline")) {
							// TODO chua co
							// JSONArray value = bodyObject.getJSONArray(keys);
						} else if (keys.toLowerCase().equalsIgnoreCase("vr_copreport_attach")) {
							JSONArray arrayData = bodyObject.getJSONArray(keys);
							int lenght = VRCOPReportAttachLocalServiceUtil.adminProcessData(arrayData,
									vrcopReportRepository.getMtCore(), vrcopReportRepository.getId(),
									vrcopReportRepository.getDossierId(), vrcopReportRepository.getDossierIdCTN(),
									vrcopReportRepository.getDossierNo());
							if (lenght < arrayData.length() - 1) {
								bodyObject.remove("vr_COPReport_attach");
							}
						}
					}
				} else {
					_log.error("Dungnv: Them that bai vrcopReportRepository");
				}
				if (vrcopReportRepository != null) {
					VRCOPReportRepositoryAction vrcopReportRepositoryAction = new VRCOPReportRepositoryActionImpl();
					vrcopReportRepositoryAction.indexing(vrcopReportRepository, company);
					status.put("code", 200);
					status.put("msg", "success");
					result.put("status", status);
					result.put("data", bodyObject);
					return Response.status(200).entity(result.toJSONString()).build();
				}

			case "vr_ApplicantProfile":
				JSONObject respData_Applicatnt = JSONFactoryUtil.createJSONObject();
				for (int i = 0; i < key.length(); ++i) {
					String keys = key.getString(i);
					if (keys.toLowerCase().equalsIgnoreCase("vr_ApplicantProfile")) {
						valueObject = bodyObject.getJSONObject(keys);
						esData.put("applicantCode", valueObject.getString("applicantCode"));
						// esData.put("registrationId", valueObject.getString("registrationId"));
						esData.put("type_es", keys.toLowerCase());
						VRApplicantProfileAction vrApplicantProfileAction = new VRApplicantProfileActionImpl();
						VRApplicantProfile vrApplicantProfile = vrApplicantProfileAction.adminProcessData(valueObject,
								valueObject.getLong("mtCore"), valueObject.getString("applicantCode"), postStatus,
								serviceContext);
						esData.put("id", String.valueOf(vrApplicantProfile.getId()));
						JSONObject jVRApplicantProfile = BusinessUtil.object2Json_originValue(vrApplicantProfile,
								VRApplicantProfileModelImpl.class, StringPool.BLANK);
						respData_Applicatnt.put("vr_ApplicantProfile", jVRApplicantProfile);
						if (postStatus.equalsIgnoreCase("draft")) {
							status.put("code", 200);
							status.put("msg", "success");
							result.put("status", status);
							result.put("data", respData_Applicatnt);
							return Response.status(200).entity(result.toJSONString()).build();
						}
					}
				}

				if (postStatus.equalsIgnoreCase("draft")) {
					for (int i = 0; i < key.length(); ++i) {
						String keys = key.getString(i);
						if (keys.toLowerCase().equalsIgnoreCase("vr_ProductionPlant")) {
							JSONArray arrayData = bodyObject.getJSONArray(keys);
							if (arrayData.length() > 0) {
								JSONObject obj = arrayData.getJSONObject(0);
								if (obj.length() > 0) {
									VRProductionPlantAction vrProductionPlantAction = new VRProductionPlantActionImpl();
									VRProductionPlant vrProductionPlant = vrProductionPlantAction.adminProcessData(obj,
											obj.getLong("mtCore"), obj.getLong("applicantProfileId"),
											obj.getString("productionPlantCode"));

									JSONObject jVRProductionPlant = BusinessUtil.object2Json_originValue(
											vrProductionPlant, VRProductionPlantModelImpl.class, StringPool.BLANK);
									respData_Applicatnt.put("vr_ProductionPlant", jVRProductionPlant);
									result.put("status", status);
									result.put("data", respData_Applicatnt);
									return Response.status(200).entity(result.toJSONString()).build();
								}
							}
						}
					}
				} else if (postStatus.equalsIgnoreCase("send")) {
					for (int i = 0; i < key.length(); ++i) {
						String keys = key.getString(i);
						if (keys.toLowerCase().equalsIgnoreCase("vr_ProductionPlant")) {
							JSONArray arrayData = bodyObject.getJSONArray(keys);
							if (arrayData.length() > 0) {
								VRProductionPlantAction vrProductionPlantAction = new VRProductionPlantActionImpl();
								List<VRProductionPlant> vrProductionPlants = vrProductionPlantAction
										.adminProcessData(arrayData);
								if (vrProductionPlants != null && !vrProductionPlants.isEmpty()) {
									JSONArray array = JSONFactoryUtil.createJSONArray();
									for (VRProductionPlant vrProductionPlant : vrProductionPlants) {
										JSONObject obj = BusinessUtil.object2Json_originValue(vrProductionPlant,
												VRProductionPlantModelImpl.class, StringPool.BLANK);
										array.put(obj);
									}
									if (array.length() > 0) {
										respData_Applicatnt.put("vr_ProductionPlant", array);
									}
								}
							}
						}
					}
					VRTrackchangesAction vrTrackchangesAction = new VRTrackchangesActionImpl();
					FileEntry fileEntry = FileUploadUtils.uploadFileJSON(respData_Applicatnt, serviceContext);

					JSONObject jsonTrackchanges = vrTrackchangesAction.findByApplicantCode(
							respData_Applicatnt.getJSONObject("vr_ApplicantProfile").getString("applicantCode"),
							serviceContext);
					if (jsonTrackchanges != null && jsonTrackchanges.length() > 0) {
						vrTrackchangesAction.updateVRTrackchanges(jsonTrackchanges.getLong("id"),
								respData_Applicatnt.getJSONObject("vr_ApplicantProfile").getString("applicantCode"),
								null, 0L, null, null, "PROFILE", null,
								fileEntry != null ? fileEntry.getFileEntryId() : 0, null, serviceContext);
					} else {
						vrTrackchangesAction.updateVRTrackchanges(0L,
								respData_Applicatnt.getJSONObject("vr_ApplicantProfile").getString("applicantCode"),
								null, 0L, null, null, "PROFILE", null,
								fileEntry != null ? fileEntry.getFileEntryId() : 0, null, serviceContext);
					}
					VRHistoryProfileAction vrHistoryProfileAction = new VRHistoryProfileActionImpl();
					vrHistoryProfileAction.updateVRHistoryProfile(0L,
							respData_Applicatnt.getJSONObject("vr_ApplicantProfile").getString("applicantCode"), null,
							0L, null, null, "PROFILE", null, fileEntry != null ? fileEntry.getFileEntryId() : 0, 0,
							null, serviceContext);
				}
				esData.put("data", respData_Applicatnt);
				esData.put(Field.COMPANY_ID, String.valueOf(company.getCompanyId()));
				int deletex_Applicant = ElasticQueryWrapUtil.DELETE("applicantCode",
						valueObject.getString("applicantCode"), company.getCompanyId(), indice.toLowerCase());
				if (deletex_Applicant == 0) {
					ElasticQueryWrapUtil.POST(esData.toJSONString(), CLASS_NAME, company.getCompanyId());
				}
				status.put("code", 200);
				status.put("msg", "success");
				result.put("status", status);
				result.put("data", respData_Applicatnt);
				return Response.status(200).entity(result.toJSONString()).build();

			case "vr_VehicleTypeCertificate":
				long vehicleTypeCertificateId = 0;
				VRVehicleTypeCertificate vrVehicleTypeCertificate = null;
				JSONObject respData_Vehicle = JSONFactoryUtil.createJSONObject();
				for (int i = 0; i < key.length(); ++i) {
					String keys = key.getString(i);
					if (keys.toLowerCase().equalsIgnoreCase("vr_VehicleTypeCertificate")) {
						valueObject = bodyObject.getJSONObject(keys);
						esData.put("dossierId", String.valueOf(valueObject.getLong("dossierId")));
						esData.put("dossierIdCTN", valueObject.getString("dossierIdCTN"));
						esData.put("dossierNo", valueObject.getString("dossierNo"));
						esData.put("type_es", keys.toLowerCase());
						vrVehicleTypeCertificate = VRVehicleTypeCertificateLocalServiceUtil.adminProcessData(
								valueObject, valueObject.getLong("dossierId"), valueObject.getLong("mtCore"));
						esData.put("id", String.valueOf(vrVehicleTypeCertificate.getId()));
						vehicleTypeCertificateId = vrVehicleTypeCertificate.getId();
						JSONObject jVRVehicleTypeCertificate = BusinessUtil.object2Json_originValue(
								vrVehicleTypeCertificate, VRVehicleTypeCertificateModelImpl.class, StringPool.BLANK);
						respData_Vehicle.put("vr_VehicleTypeCertificate", jVRVehicleTypeCertificate);
						break;
					}
				}
				for (int i = 0; i < key.length(); ++i) {
					String keys = key.getString(i);
					if (keys.toLowerCase().equalsIgnoreCase("vr_VehicleSpecification")) {
						JSONArray arrayData = bodyObject.getJSONArray(keys);
						if (vehicleTypeCertificateId > 0) {
							List<VRVehicleSpecification> vrVehicleSpecifications = VRVehicleSpecificationLocalServiceUtil
									.adminProcessData(arrayData, valueObject.getLong("dossierId"),
											vehicleTypeCertificateId);
							if (vrVehicleSpecifications != null && !vrVehicleSpecifications.isEmpty()) {
								JSONArray array = JSONFactoryUtil.createJSONArray();
								vrVehicleSpecifications.forEach(vrVehicleSpecification -> {
									try {
										JSONObject obj = BusinessUtil.object2Json_originValue(vrVehicleSpecification,
												VRVehicleSpecificationModelImpl.class, StringPool.BLANK);
										array.put(obj);
									} catch (Exception e) {
									}
								});
								respData_Vehicle.put("vr_VehicleSpecification", array);
							}
						}
					} else if (keys.toLowerCase().equalsIgnoreCase("vr_InspectionStandard")) {
						JSONArray arrayData = bodyObject.getJSONArray(keys);
						if (vehicleTypeCertificateId > 0) {
							List<VRInspectionStandard> vrInspectionStandards = VRInspectionStandardLocalServiceUtil
									.adminProcessData(arrayData, valueObject.getLong("dossierId"),
											vehicleTypeCertificateId);
							if (vrInspectionStandards != null && !vrInspectionStandards.isEmpty()) {
								JSONArray array = JSONFactoryUtil.createJSONArray();
								vrInspectionStandards.forEach(vrInspectionStandard -> {
									try {
										JSONObject obj = BusinessUtil.object2Json_originValue(vrInspectionStandard,
												VRInspectionStandardModelImpl.class, StringPool.BLANK);
										array.put(obj);
									} catch (Exception e) {
									}
								});
								respData_Vehicle.put("vr_InspectionStandard", array);
							}
						}
					} else if (keys.toLowerCase().equalsIgnoreCase("vr_technicalspec_lkxcg")) {
						JSONArray arrayData = bodyObject.getJSONArray(keys);
						if (vehicleTypeCertificateId > 0) {
							List<VRTechnicalSpec_LKXCG> vrTechnicalSpec_LKXCGs = VRTechnicalSpec_LKXCGLocalServiceUtil
									.adminProcessData(arrayData, valueObject.getLong("dossierId"),
											valueObject.getLong("mtCore"), vehicleTypeCertificateId);
							JSONArray array = JSONFactoryUtil.createJSONArray();
							vrTechnicalSpec_LKXCGs.forEach(vrTechnicalSpec_LKXCG -> {
								try {
									JSONObject obj = BusinessUtil.object2Json_originValue(vrTechnicalSpec_LKXCG,
											VRTechnicalSpec_LKXCGModelImpl.class, StringPool.BLANK);
									array.put(obj);
								} catch (Exception e) {
								}
							});
							respData_Vehicle.put("vr_Technicalspec_LKXCG", array);
						}
					} else if (keys.toLowerCase().equalsIgnoreCase("vr_technicalspec_xcg")) {
						JSONArray arrayData = bodyObject.getJSONArray(keys);
						if (vehicleTypeCertificateId > 0) {
							List<VRTechnicalSpec_XCG> vrTechnicalSpec_XCGs = VRTechnicalSpec_XCGLocalServiceUtil
									.adminProcessData(arrayData, valueObject.getLong("dossierId"),
											valueObject.getLong("mtCore"), vehicleTypeCertificateId);
							if (vrTechnicalSpec_XCGs.size() >= arrayData.length()) {
								respData_Vehicle.put("vr_Technicalspec_XCG", arrayData);
							}
						}
					} else if (keys.toLowerCase().equalsIgnoreCase("vr_technicalspec_lkxmy")) {
						JSONArray arrayData = bodyObject.getJSONArray(keys);
						if (vehicleTypeCertificateId > 0) {
							List<VRTechnicalSpec_LKXMY> vrTechnicalSpec_LKXMYs = VRTechnicalSpec_LKXMYLocalServiceUtil
									.adminProcessData(arrayData, valueObject.getLong("dossierId"),
											valueObject.getLong("mtCore"), vehicleTypeCertificateId);
							if (vrTechnicalSpec_LKXMYs.size() >= arrayData.length()) {
								respData_Vehicle.put("vr_Technicalspec_LKXMY", arrayData);
							}
						}
					} else if (keys.toLowerCase().equalsIgnoreCase("vr_technicalspec_xmy")) {
						JSONArray arrayData = bodyObject.getJSONArray(keys);
						if (vehicleTypeCertificateId > 0) {
							List<VRTechnicalSpec_XMY> vrTechnicalSpec_XMYs = VRTechnicalSpec_XMYLocalServiceUtil
									.adminProcessData(arrayData, valueObject.getLong("dossierId"),
											valueObject.getLong("mtCore"), vehicleTypeCertificateId);
							if (vrTechnicalSpec_XMYs.size() >= arrayData.length()) {
								respData_Vehicle.put("vr_Technicalspec_XMY", arrayData);
							}
						}
					} else if (keys.toLowerCase().equalsIgnoreCase("vr_technicalspec_xchbb")) {
						JSONArray arrayData = bodyObject.getJSONArray(keys);
						if (vehicleTypeCertificateId > 0) {
							List<VRTechnicalSpec_XCH> vrTechnicalSpec_XCHs = VRTechnicalSpec_XCHLocalServiceUtil
									.adminProcessData(arrayData, valueObject.getLong("dossierId"),
											valueObject.getLong("mtCore"), vehicleTypeCertificateId);
							if (vrTechnicalSpec_XCHs.size() >= arrayData.length()) {
								respData_Vehicle.put("vr_Technicalspec_XCHBB", arrayData);
							}
						}
					} else if (keys.toLowerCase().equalsIgnoreCase("vr_technicalspec_xcnbb")) {
						JSONArray arrayData = bodyObject.getJSONArray(keys);
						if (vehicleTypeCertificateId > 0) {
							List<VRTechnicalSpec_XCN> vrTechnicalSpec_XCNs = VRTechnicalSpec_XCNLocalServiceUtil
									.adminProcessData(arrayData, valueObject.getLong("dossierId"),
											valueObject.getLong("mtCore"), vehicleTypeCertificateId);
							if (vrTechnicalSpec_XCNs.size() >= arrayData.length()) {
								respData_Vehicle.put("vr_Technicalspec_XCNBB", arrayData);
							}
						}
					} else if (keys.toLowerCase().equalsIgnoreCase("vr_technicalspec_xdd")) {
						JSONArray arrayData = bodyObject.getJSONArray(keys);
						if (vehicleTypeCertificateId > 0) {
							List<VRTechnicalSpec_XDD> vrTechnicalSpec_XDDs = VRTechnicalSpec_XDDLocalServiceUtil
									.adminProcessData(arrayData, valueObject.getLong("dossierId"),
											valueObject.getLong("mtCore"), vehicleTypeCertificateId);
							if (vrTechnicalSpec_XDDs.size() >= arrayData.length()) {
								respData_Vehicle.put("vr_Technicalspec_XDD", arrayData);
							}
						}
					}
				}
				if (vrVehicleTypeCertificate != null) {
					VRVehicleTypeCertificateAction vrVehicleTypeCertificateAction = new VRVehicleTypeCertificateActionImpl();
					vrVehicleTypeCertificateAction.indexing(vrVehicleTypeCertificate, company);
					status.put("code", 200);
					status.put("msg", "success");
					result.put("status", status);
					result.put("data", respData_Vehicle);
				}
				return Response.status(200).entity(result.toJSONString()).build();

			case "vr_Issue":
				JSONObject respData_Issue = JSONFactoryUtil.createJSONObject();
				VRIssue vrIssue = null;
				for (int i = 0; i < key.length(); ++i) {
					String keys = key.getString(i);
					if (keys.toLowerCase().equalsIgnoreCase("vr_Issue")) {
						valueObject = bodyObject.getJSONObject(keys);
						esData.put("dossierId", String.valueOf(valueObject.getLong("dossierId")));
						esData.put("dossierIdCTN", valueObject.getString("dossierIdCTN"));
						esData.put("dossierNo", valueObject.getString("dossierNo"));
						esData.put("type_es", keys.toLowerCase());
						respData_Issue = VRIssueLocalServiceUtil.adminProcess(valueObject, valueObject.getLong("dossierId"),
								valueObject.getLong("mtCore"));
						vrIssue = VRIssueLocalServiceUtil.findByMT_DID(valueObject.getLong("mtCore"), valueObject.getLong("dossierId"));
						esData.put("id", String.valueOf(vrIssue.getId()));
						break;
					}
				}
				if (vrIssue != null) {
					VRIssueAction action = new VRIssueActionImpl();
					action.indexing(vrIssue, company);
					status.put("code", 200);
					status.put("msg", "success");
					result.put("status", status);
					result.put("data", respData_Issue);
				}
				return Response.status(200).entity(result.toJSONString()).build();
				
			default:
				break;
			}
		} catch (Exception e) {
			_log.error(e);
			Response.status(500).entity("Can't post data!").build();
		}
		result.put("status", status);
		result.put("data", data);
		return Response.status(200).entity(result.toJSONString()).build();
	};

	@Reference
	private CompanyContextProvider _companyContextProvider;

	@Reference
	private LocaleContextProvider _localeContextProvider;

	@Reference
	private UserContextProvider _userContextProvider;

	@Reference
	private ServiceContextProvider _serviceContextProvider;

}