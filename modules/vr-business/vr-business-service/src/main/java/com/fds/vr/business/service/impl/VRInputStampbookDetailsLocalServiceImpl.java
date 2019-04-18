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
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
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
	
	public List<VRInputStampbookDetails> findBycorporationId(long mtCore, String corporationId) throws PortalException, SystemException {
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