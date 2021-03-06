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

package com.fds.vr.business.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.fds.vr.business.model.VROutputSheetDetails;
import com.fds.vr.business.model.VROutputSheetDetailsModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the VROutputSheetDetails service. Represents a row in the &quot;vr_outputsheetdetails&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link VROutputSheetDetailsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VROutputSheetDetailsImpl}.
 * </p>
 *
 * @author LamTV
 * @see VROutputSheetDetailsImpl
 * @see VROutputSheetDetails
 * @see VROutputSheetDetailsModel
 * @generated
 */
@ProviderType
public class VROutputSheetDetailsModelImpl extends BaseModelImpl<VROutputSheetDetails>
	implements VROutputSheetDetailsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a vr output sheet details model instance should use the {@link VROutputSheetDetails} interface instead.
	 */
	public static final String TABLE_NAME = "vr_outputsheetdetails";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", Types.BIGINT },
			{ "mtCore", Types.BIGINT },
			{ "inputSheetId", Types.BIGINT },
			{ "outputSheetId", Types.BIGINT },
			{ "bookId", Types.BIGINT },
			{ "issueVehicleCertificateId", Types.BIGINT },
			{ "certificateId", Types.BIGINT },
			{ "certificateNumber", Types.VARCHAR },
			{ "certificateDate", Types.TIMESTAMP },
			{ "vehicleClass", Types.VARCHAR },
			{ "stampType", Types.VARCHAR },
			{ "stampShortNo", Types.VARCHAR },
			{ "serialStartNo", Types.BIGINT },
			{ "serialEndNo", Types.BIGINT },
			{ "subTotalInDocument", Types.BIGINT },
			{ "subTotalQuantities", Types.BIGINT },
			{ "unitPrice", Types.BIGINT },
			{ "totalAmount", Types.BIGINT },
			{ "totalInUse", Types.BIGINT },
			{ "totalNotUsed", Types.BIGINT },
			{ "totalLost", Types.BIGINT },
			{ "totalCancelled", Types.BIGINT },
			{ "totalReturned", Types.BIGINT },
			{ "remark", Types.VARCHAR },
			{ "modifyDate", Types.TIMESTAMP },
			{ "syncDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("mtCore", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("inputSheetId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("outputSheetId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("bookId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("issueVehicleCertificateId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("certificateId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("certificateNumber", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("certificateDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("vehicleClass", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("stampType", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("stampShortNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("serialStartNo", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("serialEndNo", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("subTotalInDocument", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("subTotalQuantities", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("unitPrice", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("totalAmount", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("totalInUse", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("totalNotUsed", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("totalLost", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("totalCancelled", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("totalReturned", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("remark", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("modifyDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("syncDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table vr_outputsheetdetails (id LONG not null primary key,mtCore LONG,inputSheetId LONG,outputSheetId LONG,bookId LONG,issueVehicleCertificateId LONG,certificateId LONG,certificateNumber VARCHAR(75) null,certificateDate DATE null,vehicleClass VARCHAR(75) null,stampType VARCHAR(75) null,stampShortNo VARCHAR(75) null,serialStartNo LONG,serialEndNo LONG,subTotalInDocument LONG,subTotalQuantities LONG,unitPrice LONG,totalAmount LONG,totalInUse LONG,totalNotUsed LONG,totalLost LONG,totalCancelled LONG,totalReturned LONG,remark VARCHAR(75) null,modifyDate DATE null,syncDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table vr_outputsheetdetails";
	public static final String ORDER_BY_JPQL = " ORDER BY vrOutputSheetDetails.modifyDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY vr_outputsheetdetails.modifyDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.fds.vr.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.fds.vr.business.model.VROutputSheetDetails"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.fds.vr.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.fds.vr.business.model.VROutputSheetDetails"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.fds.vr.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.fds.vr.business.model.VROutputSheetDetails"),
			true);
	public static final long BOOKID_COLUMN_BITMASK = 1L;
	public static final long CERTIFICATEID_COLUMN_BITMASK = 2L;
	public static final long CERTIFICATENUMBER_COLUMN_BITMASK = 4L;
	public static final long INPUTSHEETID_COLUMN_BITMASK = 8L;
	public static final long ISSUEVEHICLECERTIFICATEID_COLUMN_BITMASK = 16L;
	public static final long MTCORE_COLUMN_BITMASK = 32L;
	public static final long OUTPUTSHEETID_COLUMN_BITMASK = 64L;
	public static final long STAMPTYPE_COLUMN_BITMASK = 128L;
	public static final long MODIFYDATE_COLUMN_BITMASK = 256L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.fds.vr.service.util.ServiceProps.get(
				"lock.expiration.time.com.fds.vr.business.model.VROutputSheetDetails"));

	public VROutputSheetDetailsModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return VROutputSheetDetails.class;
	}

	@Override
	public String getModelClassName() {
		return VROutputSheetDetails.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("mtCore", getMtCore());
		attributes.put("inputSheetId", getInputSheetId());
		attributes.put("outputSheetId", getOutputSheetId());
		attributes.put("bookId", getBookId());
		attributes.put("issueVehicleCertificateId",
			getIssueVehicleCertificateId());
		attributes.put("certificateId", getCertificateId());
		attributes.put("certificateNumber", getCertificateNumber());
		attributes.put("certificateDate", getCertificateDate());
		attributes.put("vehicleClass", getVehicleClass());
		attributes.put("stampType", getStampType());
		attributes.put("stampShortNo", getStampShortNo());
		attributes.put("serialStartNo", getSerialStartNo());
		attributes.put("serialEndNo", getSerialEndNo());
		attributes.put("subTotalInDocument", getSubTotalInDocument());
		attributes.put("subTotalQuantities", getSubTotalQuantities());
		attributes.put("unitPrice", getUnitPrice());
		attributes.put("totalAmount", getTotalAmount());
		attributes.put("totalInUse", getTotalInUse());
		attributes.put("totalNotUsed", getTotalNotUsed());
		attributes.put("totalLost", getTotalLost());
		attributes.put("totalCancelled", getTotalCancelled());
		attributes.put("totalReturned", getTotalReturned());
		attributes.put("remark", getRemark());
		attributes.put("modifyDate", getModifyDate());
		attributes.put("syncDate", getSyncDate());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long mtCore = (Long)attributes.get("mtCore");

		if (mtCore != null) {
			setMtCore(mtCore);
		}

		Long inputSheetId = (Long)attributes.get("inputSheetId");

		if (inputSheetId != null) {
			setInputSheetId(inputSheetId);
		}

		Long outputSheetId = (Long)attributes.get("outputSheetId");

		if (outputSheetId != null) {
			setOutputSheetId(outputSheetId);
		}

		Long bookId = (Long)attributes.get("bookId");

		if (bookId != null) {
			setBookId(bookId);
		}

		Long issueVehicleCertificateId = (Long)attributes.get(
				"issueVehicleCertificateId");

		if (issueVehicleCertificateId != null) {
			setIssueVehicleCertificateId(issueVehicleCertificateId);
		}

		Long certificateId = (Long)attributes.get("certificateId");

		if (certificateId != null) {
			setCertificateId(certificateId);
		}

		String certificateNumber = (String)attributes.get("certificateNumber");

		if (certificateNumber != null) {
			setCertificateNumber(certificateNumber);
		}

		Date certificateDate = (Date)attributes.get("certificateDate");

		if (certificateDate != null) {
			setCertificateDate(certificateDate);
		}

		String vehicleClass = (String)attributes.get("vehicleClass");

		if (vehicleClass != null) {
			setVehicleClass(vehicleClass);
		}

		String stampType = (String)attributes.get("stampType");

		if (stampType != null) {
			setStampType(stampType);
		}

		String stampShortNo = (String)attributes.get("stampShortNo");

		if (stampShortNo != null) {
			setStampShortNo(stampShortNo);
		}

		Long serialStartNo = (Long)attributes.get("serialStartNo");

		if (serialStartNo != null) {
			setSerialStartNo(serialStartNo);
		}

		Long serialEndNo = (Long)attributes.get("serialEndNo");

		if (serialEndNo != null) {
			setSerialEndNo(serialEndNo);
		}

		Long subTotalInDocument = (Long)attributes.get("subTotalInDocument");

		if (subTotalInDocument != null) {
			setSubTotalInDocument(subTotalInDocument);
		}

		Long subTotalQuantities = (Long)attributes.get("subTotalQuantities");

		if (subTotalQuantities != null) {
			setSubTotalQuantities(subTotalQuantities);
		}

		Long unitPrice = (Long)attributes.get("unitPrice");

		if (unitPrice != null) {
			setUnitPrice(unitPrice);
		}

		Long totalAmount = (Long)attributes.get("totalAmount");

		if (totalAmount != null) {
			setTotalAmount(totalAmount);
		}

		Long totalInUse = (Long)attributes.get("totalInUse");

		if (totalInUse != null) {
			setTotalInUse(totalInUse);
		}

		Long totalNotUsed = (Long)attributes.get("totalNotUsed");

		if (totalNotUsed != null) {
			setTotalNotUsed(totalNotUsed);
		}

		Long totalLost = (Long)attributes.get("totalLost");

		if (totalLost != null) {
			setTotalLost(totalLost);
		}

		Long totalCancelled = (Long)attributes.get("totalCancelled");

		if (totalCancelled != null) {
			setTotalCancelled(totalCancelled);
		}

		Long totalReturned = (Long)attributes.get("totalReturned");

		if (totalReturned != null) {
			setTotalReturned(totalReturned);
		}

		String remark = (String)attributes.get("remark");

		if (remark != null) {
			setRemark(remark);
		}

		Date modifyDate = (Date)attributes.get("modifyDate");

		if (modifyDate != null) {
			setModifyDate(modifyDate);
		}

		Date syncDate = (Date)attributes.get("syncDate");

		if (syncDate != null) {
			setSyncDate(syncDate);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;
	}

	@Override
	public long getMtCore() {
		return _mtCore;
	}

	@Override
	public void setMtCore(long mtCore) {
		_columnBitmask |= MTCORE_COLUMN_BITMASK;

		if (!_setOriginalMtCore) {
			_setOriginalMtCore = true;

			_originalMtCore = _mtCore;
		}

		_mtCore = mtCore;
	}

	public long getOriginalMtCore() {
		return _originalMtCore;
	}

	@Override
	public long getInputSheetId() {
		return _inputSheetId;
	}

	@Override
	public void setInputSheetId(long inputSheetId) {
		_columnBitmask |= INPUTSHEETID_COLUMN_BITMASK;

		if (!_setOriginalInputSheetId) {
			_setOriginalInputSheetId = true;

			_originalInputSheetId = _inputSheetId;
		}

		_inputSheetId = inputSheetId;
	}

	public long getOriginalInputSheetId() {
		return _originalInputSheetId;
	}

	@Override
	public long getOutputSheetId() {
		return _outputSheetId;
	}

	@Override
	public void setOutputSheetId(long outputSheetId) {
		_columnBitmask |= OUTPUTSHEETID_COLUMN_BITMASK;

		if (!_setOriginalOutputSheetId) {
			_setOriginalOutputSheetId = true;

			_originalOutputSheetId = _outputSheetId;
		}

		_outputSheetId = outputSheetId;
	}

	public long getOriginalOutputSheetId() {
		return _originalOutputSheetId;
	}

	@Override
	public long getBookId() {
		return _bookId;
	}

	@Override
	public void setBookId(long bookId) {
		_columnBitmask |= BOOKID_COLUMN_BITMASK;

		if (!_setOriginalBookId) {
			_setOriginalBookId = true;

			_originalBookId = _bookId;
		}

		_bookId = bookId;
	}

	public long getOriginalBookId() {
		return _originalBookId;
	}

	@Override
	public long getIssueVehicleCertificateId() {
		return _issueVehicleCertificateId;
	}

	@Override
	public void setIssueVehicleCertificateId(long issueVehicleCertificateId) {
		_columnBitmask |= ISSUEVEHICLECERTIFICATEID_COLUMN_BITMASK;

		if (!_setOriginalIssueVehicleCertificateId) {
			_setOriginalIssueVehicleCertificateId = true;

			_originalIssueVehicleCertificateId = _issueVehicleCertificateId;
		}

		_issueVehicleCertificateId = issueVehicleCertificateId;
	}

	public long getOriginalIssueVehicleCertificateId() {
		return _originalIssueVehicleCertificateId;
	}

	@Override
	public long getCertificateId() {
		return _certificateId;
	}

	@Override
	public void setCertificateId(long certificateId) {
		_columnBitmask |= CERTIFICATEID_COLUMN_BITMASK;

		if (!_setOriginalCertificateId) {
			_setOriginalCertificateId = true;

			_originalCertificateId = _certificateId;
		}

		_certificateId = certificateId;
	}

	public long getOriginalCertificateId() {
		return _originalCertificateId;
	}

	@Override
	public String getCertificateNumber() {
		if (_certificateNumber == null) {
			return StringPool.BLANK;
		}
		else {
			return _certificateNumber;
		}
	}

	@Override
	public void setCertificateNumber(String certificateNumber) {
		_columnBitmask |= CERTIFICATENUMBER_COLUMN_BITMASK;

		if (_originalCertificateNumber == null) {
			_originalCertificateNumber = _certificateNumber;
		}

		_certificateNumber = certificateNumber;
	}

	public String getOriginalCertificateNumber() {
		return GetterUtil.getString(_originalCertificateNumber);
	}

	@Override
	public Date getCertificateDate() {
		return _certificateDate;
	}

	@Override
	public void setCertificateDate(Date certificateDate) {
		_certificateDate = certificateDate;
	}

	@Override
	public String getVehicleClass() {
		if (_vehicleClass == null) {
			return StringPool.BLANK;
		}
		else {
			return _vehicleClass;
		}
	}

	@Override
	public void setVehicleClass(String vehicleClass) {
		_vehicleClass = vehicleClass;
	}

	@Override
	public String getStampType() {
		if (_stampType == null) {
			return StringPool.BLANK;
		}
		else {
			return _stampType;
		}
	}

	@Override
	public void setStampType(String stampType) {
		_columnBitmask |= STAMPTYPE_COLUMN_BITMASK;

		if (_originalStampType == null) {
			_originalStampType = _stampType;
		}

		_stampType = stampType;
	}

	public String getOriginalStampType() {
		return GetterUtil.getString(_originalStampType);
	}

	@Override
	public String getStampShortNo() {
		if (_stampShortNo == null) {
			return StringPool.BLANK;
		}
		else {
			return _stampShortNo;
		}
	}

	@Override
	public void setStampShortNo(String stampShortNo) {
		_stampShortNo = stampShortNo;
	}

	@Override
	public long getSerialStartNo() {
		return _serialStartNo;
	}

	@Override
	public void setSerialStartNo(long serialStartNo) {
		_serialStartNo = serialStartNo;
	}

	@Override
	public long getSerialEndNo() {
		return _serialEndNo;
	}

	@Override
	public void setSerialEndNo(long serialEndNo) {
		_serialEndNo = serialEndNo;
	}

	@Override
	public long getSubTotalInDocument() {
		return _subTotalInDocument;
	}

	@Override
	public void setSubTotalInDocument(long subTotalInDocument) {
		_subTotalInDocument = subTotalInDocument;
	}

	@Override
	public long getSubTotalQuantities() {
		return _subTotalQuantities;
	}

	@Override
	public void setSubTotalQuantities(long subTotalQuantities) {
		_subTotalQuantities = subTotalQuantities;
	}

	@Override
	public long getUnitPrice() {
		return _unitPrice;
	}

	@Override
	public void setUnitPrice(long unitPrice) {
		_unitPrice = unitPrice;
	}

	@Override
	public long getTotalAmount() {
		return _totalAmount;
	}

	@Override
	public void setTotalAmount(long totalAmount) {
		_totalAmount = totalAmount;
	}

	@Override
	public long getTotalInUse() {
		return _totalInUse;
	}

	@Override
	public void setTotalInUse(long totalInUse) {
		_totalInUse = totalInUse;
	}

	@Override
	public long getTotalNotUsed() {
		return _totalNotUsed;
	}

	@Override
	public void setTotalNotUsed(long totalNotUsed) {
		_totalNotUsed = totalNotUsed;
	}

	@Override
	public long getTotalLost() {
		return _totalLost;
	}

	@Override
	public void setTotalLost(long totalLost) {
		_totalLost = totalLost;
	}

	@Override
	public long getTotalCancelled() {
		return _totalCancelled;
	}

	@Override
	public void setTotalCancelled(long totalCancelled) {
		_totalCancelled = totalCancelled;
	}

	@Override
	public long getTotalReturned() {
		return _totalReturned;
	}

	@Override
	public void setTotalReturned(long totalReturned) {
		_totalReturned = totalReturned;
	}

	@Override
	public String getRemark() {
		if (_remark == null) {
			return StringPool.BLANK;
		}
		else {
			return _remark;
		}
	}

	@Override
	public void setRemark(String remark) {
		_remark = remark;
	}

	@Override
	public Date getModifyDate() {
		return _modifyDate;
	}

	@Override
	public void setModifyDate(Date modifyDate) {
		_columnBitmask = -1L;

		_modifyDate = modifyDate;
	}

	@Override
	public Date getSyncDate() {
		return _syncDate;
	}

	@Override
	public void setSyncDate(Date syncDate) {
		_syncDate = syncDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			VROutputSheetDetails.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public VROutputSheetDetails toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (VROutputSheetDetails)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		VROutputSheetDetailsImpl vrOutputSheetDetailsImpl = new VROutputSheetDetailsImpl();

		vrOutputSheetDetailsImpl.setId(getId());
		vrOutputSheetDetailsImpl.setMtCore(getMtCore());
		vrOutputSheetDetailsImpl.setInputSheetId(getInputSheetId());
		vrOutputSheetDetailsImpl.setOutputSheetId(getOutputSheetId());
		vrOutputSheetDetailsImpl.setBookId(getBookId());
		vrOutputSheetDetailsImpl.setIssueVehicleCertificateId(getIssueVehicleCertificateId());
		vrOutputSheetDetailsImpl.setCertificateId(getCertificateId());
		vrOutputSheetDetailsImpl.setCertificateNumber(getCertificateNumber());
		vrOutputSheetDetailsImpl.setCertificateDate(getCertificateDate());
		vrOutputSheetDetailsImpl.setVehicleClass(getVehicleClass());
		vrOutputSheetDetailsImpl.setStampType(getStampType());
		vrOutputSheetDetailsImpl.setStampShortNo(getStampShortNo());
		vrOutputSheetDetailsImpl.setSerialStartNo(getSerialStartNo());
		vrOutputSheetDetailsImpl.setSerialEndNo(getSerialEndNo());
		vrOutputSheetDetailsImpl.setSubTotalInDocument(getSubTotalInDocument());
		vrOutputSheetDetailsImpl.setSubTotalQuantities(getSubTotalQuantities());
		vrOutputSheetDetailsImpl.setUnitPrice(getUnitPrice());
		vrOutputSheetDetailsImpl.setTotalAmount(getTotalAmount());
		vrOutputSheetDetailsImpl.setTotalInUse(getTotalInUse());
		vrOutputSheetDetailsImpl.setTotalNotUsed(getTotalNotUsed());
		vrOutputSheetDetailsImpl.setTotalLost(getTotalLost());
		vrOutputSheetDetailsImpl.setTotalCancelled(getTotalCancelled());
		vrOutputSheetDetailsImpl.setTotalReturned(getTotalReturned());
		vrOutputSheetDetailsImpl.setRemark(getRemark());
		vrOutputSheetDetailsImpl.setModifyDate(getModifyDate());
		vrOutputSheetDetailsImpl.setSyncDate(getSyncDate());

		vrOutputSheetDetailsImpl.resetOriginalValues();

		return vrOutputSheetDetailsImpl;
	}

	@Override
	public int compareTo(VROutputSheetDetails vrOutputSheetDetails) {
		int value = 0;

		value = DateUtil.compareTo(getModifyDate(),
				vrOutputSheetDetails.getModifyDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VROutputSheetDetails)) {
			return false;
		}

		VROutputSheetDetails vrOutputSheetDetails = (VROutputSheetDetails)obj;

		long primaryKey = vrOutputSheetDetails.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		VROutputSheetDetailsModelImpl vrOutputSheetDetailsModelImpl = this;

		vrOutputSheetDetailsModelImpl._originalMtCore = vrOutputSheetDetailsModelImpl._mtCore;

		vrOutputSheetDetailsModelImpl._setOriginalMtCore = false;

		vrOutputSheetDetailsModelImpl._originalInputSheetId = vrOutputSheetDetailsModelImpl._inputSheetId;

		vrOutputSheetDetailsModelImpl._setOriginalInputSheetId = false;

		vrOutputSheetDetailsModelImpl._originalOutputSheetId = vrOutputSheetDetailsModelImpl._outputSheetId;

		vrOutputSheetDetailsModelImpl._setOriginalOutputSheetId = false;

		vrOutputSheetDetailsModelImpl._originalBookId = vrOutputSheetDetailsModelImpl._bookId;

		vrOutputSheetDetailsModelImpl._setOriginalBookId = false;

		vrOutputSheetDetailsModelImpl._originalIssueVehicleCertificateId = vrOutputSheetDetailsModelImpl._issueVehicleCertificateId;

		vrOutputSheetDetailsModelImpl._setOriginalIssueVehicleCertificateId = false;

		vrOutputSheetDetailsModelImpl._originalCertificateId = vrOutputSheetDetailsModelImpl._certificateId;

		vrOutputSheetDetailsModelImpl._setOriginalCertificateId = false;

		vrOutputSheetDetailsModelImpl._originalCertificateNumber = vrOutputSheetDetailsModelImpl._certificateNumber;

		vrOutputSheetDetailsModelImpl._originalStampType = vrOutputSheetDetailsModelImpl._stampType;

		vrOutputSheetDetailsModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<VROutputSheetDetails> toCacheModel() {
		VROutputSheetDetailsCacheModel vrOutputSheetDetailsCacheModel = new VROutputSheetDetailsCacheModel();

		vrOutputSheetDetailsCacheModel.id = getId();

		vrOutputSheetDetailsCacheModel.mtCore = getMtCore();

		vrOutputSheetDetailsCacheModel.inputSheetId = getInputSheetId();

		vrOutputSheetDetailsCacheModel.outputSheetId = getOutputSheetId();

		vrOutputSheetDetailsCacheModel.bookId = getBookId();

		vrOutputSheetDetailsCacheModel.issueVehicleCertificateId = getIssueVehicleCertificateId();

		vrOutputSheetDetailsCacheModel.certificateId = getCertificateId();

		vrOutputSheetDetailsCacheModel.certificateNumber = getCertificateNumber();

		String certificateNumber = vrOutputSheetDetailsCacheModel.certificateNumber;

		if ((certificateNumber != null) && (certificateNumber.length() == 0)) {
			vrOutputSheetDetailsCacheModel.certificateNumber = null;
		}

		Date certificateDate = getCertificateDate();

		if (certificateDate != null) {
			vrOutputSheetDetailsCacheModel.certificateDate = certificateDate.getTime();
		}
		else {
			vrOutputSheetDetailsCacheModel.certificateDate = Long.MIN_VALUE;
		}

		vrOutputSheetDetailsCacheModel.vehicleClass = getVehicleClass();

		String vehicleClass = vrOutputSheetDetailsCacheModel.vehicleClass;

		if ((vehicleClass != null) && (vehicleClass.length() == 0)) {
			vrOutputSheetDetailsCacheModel.vehicleClass = null;
		}

		vrOutputSheetDetailsCacheModel.stampType = getStampType();

		String stampType = vrOutputSheetDetailsCacheModel.stampType;

		if ((stampType != null) && (stampType.length() == 0)) {
			vrOutputSheetDetailsCacheModel.stampType = null;
		}

		vrOutputSheetDetailsCacheModel.stampShortNo = getStampShortNo();

		String stampShortNo = vrOutputSheetDetailsCacheModel.stampShortNo;

		if ((stampShortNo != null) && (stampShortNo.length() == 0)) {
			vrOutputSheetDetailsCacheModel.stampShortNo = null;
		}

		vrOutputSheetDetailsCacheModel.serialStartNo = getSerialStartNo();

		vrOutputSheetDetailsCacheModel.serialEndNo = getSerialEndNo();

		vrOutputSheetDetailsCacheModel.subTotalInDocument = getSubTotalInDocument();

		vrOutputSheetDetailsCacheModel.subTotalQuantities = getSubTotalQuantities();

		vrOutputSheetDetailsCacheModel.unitPrice = getUnitPrice();

		vrOutputSheetDetailsCacheModel.totalAmount = getTotalAmount();

		vrOutputSheetDetailsCacheModel.totalInUse = getTotalInUse();

		vrOutputSheetDetailsCacheModel.totalNotUsed = getTotalNotUsed();

		vrOutputSheetDetailsCacheModel.totalLost = getTotalLost();

		vrOutputSheetDetailsCacheModel.totalCancelled = getTotalCancelled();

		vrOutputSheetDetailsCacheModel.totalReturned = getTotalReturned();

		vrOutputSheetDetailsCacheModel.remark = getRemark();

		String remark = vrOutputSheetDetailsCacheModel.remark;

		if ((remark != null) && (remark.length() == 0)) {
			vrOutputSheetDetailsCacheModel.remark = null;
		}

		Date modifyDate = getModifyDate();

		if (modifyDate != null) {
			vrOutputSheetDetailsCacheModel.modifyDate = modifyDate.getTime();
		}
		else {
			vrOutputSheetDetailsCacheModel.modifyDate = Long.MIN_VALUE;
		}

		Date syncDate = getSyncDate();

		if (syncDate != null) {
			vrOutputSheetDetailsCacheModel.syncDate = syncDate.getTime();
		}
		else {
			vrOutputSheetDetailsCacheModel.syncDate = Long.MIN_VALUE;
		}

		return vrOutputSheetDetailsCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(53);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", mtCore=");
		sb.append(getMtCore());
		sb.append(", inputSheetId=");
		sb.append(getInputSheetId());
		sb.append(", outputSheetId=");
		sb.append(getOutputSheetId());
		sb.append(", bookId=");
		sb.append(getBookId());
		sb.append(", issueVehicleCertificateId=");
		sb.append(getIssueVehicleCertificateId());
		sb.append(", certificateId=");
		sb.append(getCertificateId());
		sb.append(", certificateNumber=");
		sb.append(getCertificateNumber());
		sb.append(", certificateDate=");
		sb.append(getCertificateDate());
		sb.append(", vehicleClass=");
		sb.append(getVehicleClass());
		sb.append(", stampType=");
		sb.append(getStampType());
		sb.append(", stampShortNo=");
		sb.append(getStampShortNo());
		sb.append(", serialStartNo=");
		sb.append(getSerialStartNo());
		sb.append(", serialEndNo=");
		sb.append(getSerialEndNo());
		sb.append(", subTotalInDocument=");
		sb.append(getSubTotalInDocument());
		sb.append(", subTotalQuantities=");
		sb.append(getSubTotalQuantities());
		sb.append(", unitPrice=");
		sb.append(getUnitPrice());
		sb.append(", totalAmount=");
		sb.append(getTotalAmount());
		sb.append(", totalInUse=");
		sb.append(getTotalInUse());
		sb.append(", totalNotUsed=");
		sb.append(getTotalNotUsed());
		sb.append(", totalLost=");
		sb.append(getTotalLost());
		sb.append(", totalCancelled=");
		sb.append(getTotalCancelled());
		sb.append(", totalReturned=");
		sb.append(getTotalReturned());
		sb.append(", remark=");
		sb.append(getRemark());
		sb.append(", modifyDate=");
		sb.append(getModifyDate());
		sb.append(", syncDate=");
		sb.append(getSyncDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(82);

		sb.append("<model><model-name>");
		sb.append("com.fds.vr.business.model.VROutputSheetDetails");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mtCore</column-name><column-value><![CDATA[");
		sb.append(getMtCore());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inputSheetId</column-name><column-value><![CDATA[");
		sb.append(getInputSheetId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>outputSheetId</column-name><column-value><![CDATA[");
		sb.append(getOutputSheetId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bookId</column-name><column-value><![CDATA[");
		sb.append(getBookId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>issueVehicleCertificateId</column-name><column-value><![CDATA[");
		sb.append(getIssueVehicleCertificateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>certificateId</column-name><column-value><![CDATA[");
		sb.append(getCertificateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>certificateNumber</column-name><column-value><![CDATA[");
		sb.append(getCertificateNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>certificateDate</column-name><column-value><![CDATA[");
		sb.append(getCertificateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>vehicleClass</column-name><column-value><![CDATA[");
		sb.append(getVehicleClass());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stampType</column-name><column-value><![CDATA[");
		sb.append(getStampType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stampShortNo</column-name><column-value><![CDATA[");
		sb.append(getStampShortNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serialStartNo</column-name><column-value><![CDATA[");
		sb.append(getSerialStartNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serialEndNo</column-name><column-value><![CDATA[");
		sb.append(getSerialEndNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subTotalInDocument</column-name><column-value><![CDATA[");
		sb.append(getSubTotalInDocument());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subTotalQuantities</column-name><column-value><![CDATA[");
		sb.append(getSubTotalQuantities());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>unitPrice</column-name><column-value><![CDATA[");
		sb.append(getUnitPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalAmount</column-name><column-value><![CDATA[");
		sb.append(getTotalAmount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalInUse</column-name><column-value><![CDATA[");
		sb.append(getTotalInUse());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalNotUsed</column-name><column-value><![CDATA[");
		sb.append(getTotalNotUsed());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalLost</column-name><column-value><![CDATA[");
		sb.append(getTotalLost());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalCancelled</column-name><column-value><![CDATA[");
		sb.append(getTotalCancelled());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalReturned</column-name><column-value><![CDATA[");
		sb.append(getTotalReturned());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>remark</column-name><column-value><![CDATA[");
		sb.append(getRemark());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifyDate</column-name><column-value><![CDATA[");
		sb.append(getModifyDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>syncDate</column-name><column-value><![CDATA[");
		sb.append(getSyncDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = VROutputSheetDetails.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			VROutputSheetDetails.class
		};
	private long _id;
	private long _mtCore;
	private long _originalMtCore;
	private boolean _setOriginalMtCore;
	private long _inputSheetId;
	private long _originalInputSheetId;
	private boolean _setOriginalInputSheetId;
	private long _outputSheetId;
	private long _originalOutputSheetId;
	private boolean _setOriginalOutputSheetId;
	private long _bookId;
	private long _originalBookId;
	private boolean _setOriginalBookId;
	private long _issueVehicleCertificateId;
	private long _originalIssueVehicleCertificateId;
	private boolean _setOriginalIssueVehicleCertificateId;
	private long _certificateId;
	private long _originalCertificateId;
	private boolean _setOriginalCertificateId;
	private String _certificateNumber;
	private String _originalCertificateNumber;
	private Date _certificateDate;
	private String _vehicleClass;
	private String _stampType;
	private String _originalStampType;
	private String _stampShortNo;
	private long _serialStartNo;
	private long _serialEndNo;
	private long _subTotalInDocument;
	private long _subTotalQuantities;
	private long _unitPrice;
	private long _totalAmount;
	private long _totalInUse;
	private long _totalNotUsed;
	private long _totalLost;
	private long _totalCancelled;
	private long _totalReturned;
	private String _remark;
	private Date _modifyDate;
	private Date _syncDate;
	private long _columnBitmask;
	private VROutputSheetDetails _escapedModel;
}