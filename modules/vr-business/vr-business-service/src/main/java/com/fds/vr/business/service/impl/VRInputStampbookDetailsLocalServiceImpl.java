/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.fds.vr.business.service.impl;

import aQute.bnd.annotation.ProviderType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.exception.PortalException;
import com.fds.vr.business.model.VRInputStampbookDetails;
import com.fds.vr.business.service.base.VRInputStampbookDetailsLocalServiceBaseImpl;

/**
 * The implementation of the vr input stampbook details local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.fds.vr.business.service.VRInputStampbookDetailsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author khoavd
 * @see VRInputStampbookDetailsLocalServiceBaseImpl
 * @see com.fds.vr.business.service.VRInputStampbookDetailsLocalServiceUtil
 */
@ProviderType
public class VRInputStampbookDetailsLocalServiceImpl
	extends VRInputStampbookDetailsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.fds.vr.business.service.VRInputStampbookDetailsLocalServiceUtil} to access the vr input stampbook details local service.
	 */
	
	public VRInputStampbookDetails updateInputStampbookDetails(long id, long mtCore, String stampSerialNo, 
			Long sequenceNo, Long dossierId, Long certificateId, String certificateNumber,
			Date certificateDate, Long vehicleRecordId, String frameNo, String boxNo, String vinNo,
			String engineNo, Long copies, Long markupFulfill, String replacedSerialNo,
			String remark, Long inputSheetId, Long bookId, String purchaserId, Long corporationId,
			Long issuingStatus, Long clearingStatus, Long stampStatus, Date issuingDate, Date printingDate,
			Date noticeofLostDate, Date noticeofCancelDate, Date noticeofReturnDate, Date clearingDate, Long clearingAdvancePaymentID)
		throws PortalException, SystemException {
		
		VRInputStampbookDetails inputStampbookDetails = null;
		
		if(id > 0) {
			inputStampbookDetails = vrInputStampbookDetailsPersistence.findByPrimaryKey(id);
		} else {
			id = counterLocalService.increment(VRInputStampbookDetails.class.getName());
			inputStampbookDetails = vrInputStampbookDetailsPersistence.create(id);
		}
		
		inputStampbookDetails.setModifyDate(new Date());
		inputStampbookDetails.setMtCore(mtCore);
		
		if(Validator.isNotNull(remark))
			inputStampbookDetails.setStampSerialNo(stampSerialNo);
		
		if(Validator.isNotNull(remark))
			inputStampbookDetails.setSequenceNo(sequenceNo);
		
		if(Validator.isNotNull(remark))
			inputStampbookDetails.setDossierId(dossierId);
		
		if(Validator.isNotNull(remark))
			inputStampbookDetails.setCertificateId(certificateId);
		
		if(Validator.isNotNull(remark))
			inputStampbookDetails.setCertificateNumber(certificateNumber);
		
		if(Validator.isNotNull(remark))
			inputStampbookDetails.setCertificateDate(certificateDate);
		
		if(Validator.isNotNull(remark))
			inputStampbookDetails.setVehicleRecordId(vehicleRecordId);
		
		if(Validator.isNotNull(remark))
			inputStampbookDetails.setFrameNo(frameNo);
		
		if(Validator.isNotNull(boxNo))
			inputStampbookDetails.setBoxNo(boxNo);
		
		if(Validator.isNotNull(vinNo))
			inputStampbookDetails.setVinNo(vinNo);
		
		if(Validator.isNotNull(engineNo))
			inputStampbookDetails.setEngineNo(engineNo);
		
		if(Validator.isNotNull(copies))
			inputStampbookDetails.setCopies(copies);
		
		if(Validator.isNotNull(markupFulfill))
			inputStampbookDetails.setMarkupFulfill(markupFulfill);
		
		if(Validator.isNotNull(replacedSerialNo))
			inputStampbookDetails.setReplacedSerialNo(replacedSerialNo);
		
		if(Validator.isNotNull(remark))
			inputStampbookDetails.setRemark(remark);
		
		if(Validator.isNotNull(inputSheetId))
			inputStampbookDetails.setInputSheetId(inputSheetId);
		
		if(Validator.isNotNull(bookId))
			inputStampbookDetails.setBookId(bookId);
		
		if(Validator.isNotNull(purchaserId))
			inputStampbookDetails.setPurchaserId(purchaserId);
		
		if(Validator.isNotNull(corporationId))
			inputStampbookDetails.setCorporationId(corporationId);
		
		if(Validator.isNotNull(issuingStatus))
			inputStampbookDetails.setIssuingStatus(issuingStatus);
		
		if(Validator.isNotNull(clearingStatus))
			inputStampbookDetails.setClearingStatus(clearingStatus);
		
		if(Validator.isNotNull(stampStatus))
			inputStampbookDetails.setStampStatus(stampStatus);
		
		if(Validator.isNotNull(issuingDate))
			inputStampbookDetails.setIssuingDate(issuingDate);
		
		if(Validator.isNotNull(printingDate))
			inputStampbookDetails.setPrintingDate(printingDate);
		
		if(Validator.isNotNull(noticeofLostDate))
			inputStampbookDetails.setNoticeofLostDate(noticeofLostDate);
		
		if(Validator.isNotNull(noticeofCancelDate))
			inputStampbookDetails.setNoticeofCancelDate(noticeofCancelDate);
		
		if(Validator.isNotNull(noticeofReturnDate))
			inputStampbookDetails.setNoticeofReturnDate(noticeofReturnDate);
		
		if(Validator.isNotNull(clearingDate))
			inputStampbookDetails.setClearingDate(clearingDate);
		
		if(Validator.isNotNull(clearingAdvancePaymentID))
			inputStampbookDetails.setClearingAdvancePaymentID(clearingAdvancePaymentID);
		
		return vrInputStampbookDetailsPersistence.update(inputStampbookDetails);
		
	}
	
	public List<VRInputStampbookDetails> findByInputSheetId(long mtCore, long inputSheetId) throws PortalException, SystemException {
		try {
			return vrInputStampbookDetailsPersistence.findByInputSheetId(mtCore, inputSheetId);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRInputStampbookDetails>();
		
	}


	public List<VRInputStampbookDetails> findByInputSheetIdAndBookId(long mtCore, long inputSheetId, long bookId) throws PortalException, SystemException {
		try {
			return vrInputStampbookDetailsPersistence.findByInputSheetIdAndBookId(mtCore, inputSheetId, bookId);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRInputStampbookDetails>();
		
	}
	
	public List<VRInputStampbookDetails> findBycorporationId(long mtCore, long corporationId) throws PortalException, SystemException {
		try {
			return vrInputStampbookDetailsPersistence.findBycorporationId(mtCore, corporationId);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRInputStampbookDetails>();
		
	}
	
	public List<VRInputStampbookDetails> findBydossierId(long mtCore, long dossierId) throws PortalException, SystemException {
		try {
			return vrInputStampbookDetailsPersistence.findBydossierId(mtCore, dossierId);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRInputStampbookDetails>();
		
	}
	
	public List<VRInputStampbookDetails> findBycertificateId(long mtCore, long certificateId) throws PortalException, SystemException {
		try {
			return vrInputStampbookDetailsPersistence.findBycertificateId(mtCore, certificateId);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRInputStampbookDetails>();
		
	}
	
	public List<VRInputStampbookDetails> findBycertificateNumber(long mtCore, String certificateNumber) throws PortalException, SystemException {
		try {
			return vrInputStampbookDetailsPersistence.findBycertificateNumber(mtCore, certificateNumber);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRInputStampbookDetails>();
		
	}
	
	public List<VRInputStampbookDetails> findByvehicleRecordId(long mtCore, long vehicleRecordId) throws PortalException, SystemException {
		try {
			return vrInputStampbookDetailsPersistence.findByvehicleRecordId(mtCore, vehicleRecordId);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRInputStampbookDetails>();
		
	}

	
	private Log _log = LogFactoryUtil.getLog(VRInputStampbookDetailsLocalServiceBaseImpl.class);
}