package org.opencps.dossiermgt.action.impl;

import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.opencps.dossiermgt.action.PaymentFileActions;
import org.opencps.dossiermgt.action.util.ConstantsUtils;
import org.opencps.dossiermgt.constants.DossierTerm;
import org.opencps.dossiermgt.constants.PaymentFileTerm;
import org.opencps.dossiermgt.model.Dossier;
import org.opencps.dossiermgt.model.DossierSync;
import org.opencps.dossiermgt.model.PaymentFile;
import org.opencps.dossiermgt.service.DossierLocalServiceUtil;
import org.opencps.dossiermgt.service.DossierSyncLocalServiceUtil;
import org.opencps.dossiermgt.service.PaymentFileLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

public class PaymentFileActionsImpl implements PaymentFileActions {

	Log _log = LogFactoryUtil.getLog(ServiceInfoActionsImpl.class);

	/**
	 * Get all PaymentFile of DossierId
	 * 
	 * @param dossierId
	 * @return JSONObject
	 */
	@Override
	public JSONObject getByDossierId(long dossierId, long companyId, long groupId, Sort[] sorts, int start, int end,
			ServiceContext serviceContext) {
		JSONObject result = JSONFactoryUtil.createJSONObject();

		Hits hits = null;

		SearchContext searchContext = new SearchContext();
		searchContext.setCompanyId(companyId);

		LinkedHashMap<String, Object> params = new LinkedHashMap<String, Object>();
		params.put(Field.GROUP_ID, String.valueOf(groupId));
		params.put(DossierTerm.DOSSIER_ID, String.valueOf(dossierId));

		try {

			hits = PaymentFileLocalServiceUtil.searchLucene(params, sorts, start, end, searchContext);

			result.put("data", hits.toList());

			long total = PaymentFileLocalServiceUtil.countLucene(params, searchContext);

			result.put("total", total);

		} catch (Exception e) {
			_log.error(e);
		}

		return result;
	}

	/**
	 * Create PaymentFile of DossierId
	 * 
	 * @param form
	 *            params
	 * @return PaymentFile
	 */
	@Override
	public PaymentFile createPaymentFile(long userId, long groupId, long dossierId, String referenceUid,
			String paymentFee, long paymentAmount, String paymentNote, String epaymentProfile, String bankInfo,
			int paymentStatus, String paymentMethod, String paymentFormData, ServiceContext serviceContext)
			throws PortalException {
		//_log.info("boom boom");
		if (Validator.isNull(referenceUid)) {
			referenceUid = PortalUUIDUtil.generate();
		}

		try {

			PaymentFile result = PaymentFileLocalServiceUtil.createPaymentFiles(userId, groupId, dossierId,
					referenceUid, paymentFee, paymentAmount, paymentNote, epaymentProfile, bankInfo, paymentStatus,
					paymentMethod, paymentFormData, serviceContext);

			return result;

		} catch (PortalException e) {
			_log.debug(e);
			//_log.error(e);
//			e.printStackTrace();
			throw new PortalException();
		}

	}

	/**
	 * Get detail PaymentFile of DossierId and referenceUid
	 * 
	 * @param dossierId
	 * @param referenceUid
	 * @return List<Document>
	 */
	@Override
	public List<Document> getPaymentFileDetail(long dossierId, String referenceUid, long companyId, long groupId,
			Sort[] sorts, int start, int end, ServiceContext serviceContext) {

		List<Document> result = null;

		Hits hits = null;

		SearchContext searchContext = new SearchContext();
		searchContext.setCompanyId(companyId);

		LinkedHashMap<String, Object> params = new LinkedHashMap<String, Object>();
		params.put(Field.GROUP_ID, String.valueOf(groupId));
		params.put(DossierTerm.DOSSIER_ID, String.valueOf(dossierId));
		params.put(PaymentFileTerm.REFERENCE_UID, referenceUid);

		try {

			hits = PaymentFileLocalServiceUtil.searchLucene(params, sorts, start, end, searchContext);

			result = hits.toList();

		} catch (Exception e) {
			_log.error(e);
		}

		return result;
	}

	/**
	 * Get info EpaymentProfile of DossierId and referenceUid
	 * 
	 * @param dossierId
	 * @param referenceUid
	 * @return PaymentFile
	 */
	@Override
	public PaymentFile getEpaymentProfile(long dossierId, String referenceUid) {

		return PaymentFileLocalServiceUtil.getEpaymentProfile(dossierId, referenceUid);
	}

	@Override
	public PaymentFile getPaymentFile(long dossierId, String referenceUid) {

		return PaymentFileLocalServiceUtil.getPaymentFile(dossierId, referenceUid);
	}

	/**
	 * Update info EpaymentProfile of DossierId and referenceUid
	 * 
	 * @param form
	 *            params
	 * @return PaymentFile
	 */
	@Override
	public PaymentFile updateEProfile(long dossierId, String referenceUid, String strInput,
			ServiceContext serviceContext) throws PortalException {

		return PaymentFileLocalServiceUtil.updateEProfile(dossierId, referenceUid, strInput, serviceContext);
	}

	/**
	 * Update Payment File Confirm of DossierId and referenceUid
	 * 
	 * @param form
	 *            params
	 * @return PaymentFile
	 */
	@Override
	public PaymentFile updateFileConfirm(long groupId, long id, String referenceUid, String confirmNote,
			String paymentMethod, String confirmPayload, ServiceContext serviceContext)
			throws SystemException, PortalException {

		return PaymentFileLocalServiceUtil.updateFileConfirm(groupId, id, referenceUid, confirmNote, paymentMethod,
				confirmPayload, serviceContext);
	}

	/**
	 * Update Payment File Confirm of DossierId and referenceUid
	 * 
	 * @param form
	 *            params
	 * @return PaymentFile
	 */
	@Override
	public PaymentFile updateFileConfirm(long groupId, long id, String referenceUid, String confirmNote,
			String paymentMethod, String confirmPayload, String sourceFileName, long fileSize, InputStream inputStream,
			ServiceContext serviceContext) throws SystemException, PortalException {

		return PaymentFileLocalServiceUtil.updateFileConfirm(groupId, id, referenceUid, confirmNote, paymentMethod,
				confirmPayload, sourceFileName, fileSize, inputStream, serviceContext);
	}

	/**
	 * Update Payment File Approval of DossierId and referenceUid
	 * 
	 * @param form
	 *            params
	 * @return PaymentFile
	 */
	@Override
	public PaymentFile updateFileApproval(long groupId, long id, String referenceUid, String approveDatetime,
			String accountUserName, String govAgencyTaxNo, String invoiceTemplateNo, String invoiceIssueNo,
			String invoiceNo, String sourceFileName, long fileSize, InputStream inputStream,
			ServiceContext serviceContext) throws SystemException, PortalException, java.text.ParseException {

		return PaymentFileLocalServiceUtil.updateFileApproval(groupId, id, referenceUid, approveDatetime,
				accountUserName, govAgencyTaxNo, invoiceTemplateNo, invoiceIssueNo, invoiceNo, sourceFileName, fileSize,
				inputStream, serviceContext);
	}

	@Override
	public PaymentFile updateFileApproval(long groupId, long id, String referenceUid, String approveDatetime,
			String accountUserName, String govAgencyTaxNo, String invoiceTemplateNo, String invoiceIssueNo,
			String invoiceNo, boolean isSync, ServiceContext serviceContext)
			throws SystemException, PortalException, java.text.ParseException {

		PaymentFile paymentFile = PaymentFileLocalServiceUtil.updateFileApproval(groupId, id, referenceUid,
				approveDatetime, accountUserName, govAgencyTaxNo, invoiceTemplateNo, invoiceIssueNo, invoiceNo,
				serviceContext);

		if (!isSync) {
			// Add PaymentFileSync
			Dossier dossier = DossierLocalServiceUtil.getDossier(paymentFile.getDossierId());
			// TODO review serverNo on this
			//Comment by Dungnv
	//		DossierSyncLocalServiceUtil.updateDossierSync(groupId, serviceContext.getUserId(), paymentFile.getDossierId(),
	//				dossier.getReferenceUid(), false, 3, paymentFile.getPrimaryKey(), paymentFile.getReferenceUid(),
	//				StringPool.BLANK);
			//Add by Dungnv - Khong ro logic dung khong?
			DossierSync dossierSync = null;
			List<DossierSync> dossierSyncs = DossierSyncLocalServiceUtil.fetchByGroupDossierId(groupId, paymentFile.getDossierId(), -1, -1);
			if(Validator.isNotNull(dossierSyncs) && !dossierSyncs.isEmpty()) {
				for(DossierSync sync : dossierSyncs) {
					dossierSync = sync;
				}
			}
			if(Validator.isNotNull(dossierSync)) {
				JSONObject jPaymentStatus = JSONFactoryUtil.createJSONObject();
				JSONArray array = JSONFactoryUtil.createJSONArray();
				jPaymentStatus.put("groupId", groupId);
				jPaymentStatus.put("userId", serviceContext.getUserId());
				jPaymentStatus.put("dossierId", paymentFile.getDossierId());
				jPaymentStatus.put("dossierReferenceUid", dossier.getReferenceUid());
				jPaymentStatus.put("createDossier", false);
				jPaymentStatus.put("method", 3);
				jPaymentStatus.put("classPK", paymentFile.getPrimaryKey());
				jPaymentStatus.put("fileReferenceUid", paymentFile.getReferenceUid());
				jPaymentStatus.put("serverNo", "DKLR_CTN");
				array.put(jPaymentStatus);
				if(array.length() > 0) {
					JSONObject payload = JSONFactoryUtil.createJSONObject();
					payload.put(ConstantsUtils.PAYLOAD_SYNC_PAYMENTSTATUS, array);
					dossierSync.setState(2);
					dossierSync.setPayload(payload.toJSONString());
					DossierSyncLocalServiceUtil.updateDossierSync(dossierSync);
					return paymentFile;
				}
			}
			//return null;
		}
		return paymentFile;

		
	}

	// 8,9
	/**
	 * Download file Confirm by referenceUid
	 * 
	 * @throws PortalException
	 */
	@Override
	public PaymentFile getPaymentFileByReferenceUid(Long id, String referenceUid) throws PortalException {
		return PaymentFileLocalServiceUtil.getPaymentFileByReferenceUid(id, referenceUid);
	}

	/**
	 * Get all Payment File
	 * 
	 * @param
	 * @return PaymentFile
	 */
	@Override
	public JSONObject getPaymentFiles(long userId, long companyId, long groupId, LinkedHashMap<String, Object> params,
			Sort[] sorts, int start, int end, ServiceContext serviceContext) {
		JSONObject result = JSONFactoryUtil.createJSONObject();

		Hits hits = null;

		SearchContext searchContext = new SearchContext();
		searchContext.setCompanyId(companyId);

		try {

			hits = PaymentFileLocalServiceUtil.searchLucene(params, sorts, start, end, searchContext);

			result.put("data", hits.toList());

			long total = PaymentFileLocalServiceUtil.countLucene(params, searchContext);

			result.put("total", total);

		} catch (Exception e) {
			_log.error(e);
		}

		return result;
	}

	@Override
	public List<PaymentFile> getPaymentFiles(long dossierId) {
		return PaymentFileLocalServiceUtil.getByDossierId(dossierId);
	}

}
