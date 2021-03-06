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

import com.fds.vr.business.model.VRInventory;
import com.fds.vr.business.model.VRInventoryModel;

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
 * The base model implementation for the VRInventory service. Represents a row in the &quot;vr_inventory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link VRInventoryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VRInventoryImpl}.
 * </p>
 *
 * @author LamTV
 * @see VRInventoryImpl
 * @see VRInventory
 * @see VRInventoryModel
 * @generated
 */
@ProviderType
public class VRInventoryModelImpl extends BaseModelImpl<VRInventory>
	implements VRInventoryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a vr inventory model instance should use the {@link VRInventory} interface instead.
	 */
	public static final String TABLE_NAME = "vr_inventory";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", Types.BIGINT },
			{ "mtCore", Types.BIGINT },
			{ "yearofPeriod", Types.BIGINT },
			{ "previousPeriod", Types.VARCHAR },
			{ "previousPeriodCode", Types.VARCHAR },
			{ "bookId", Types.BIGINT },
			{ "vehicleClass", Types.VARCHAR },
			{ "stampType", Types.VARCHAR },
			{ "stampShortNo", Types.VARCHAR },
			{ "serialStartNo", Types.BIGINT },
			{ "serialEndNo", Types.BIGINT },
			{ "totalQuantities", Types.BIGINT },
			{ "totalInUse", Types.BIGINT },
			{ "totalNotUsed", Types.BIGINT },
			{ "remark", Types.VARCHAR },
			{ "corporationId", Types.BIGINT },
			{ "checkType", Types.BIGINT },
			{ "checkStatus", Types.BIGINT },
			{ "modifyDate", Types.TIMESTAMP },
			{ "syncDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("mtCore", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("yearofPeriod", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("previousPeriod", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("previousPeriodCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("bookId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("vehicleClass", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("stampType", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("stampShortNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("serialStartNo", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("serialEndNo", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("totalQuantities", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("totalInUse", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("totalNotUsed", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("remark", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("corporationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("checkType", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("checkStatus", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("modifyDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("syncDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table vr_inventory (id LONG not null primary key,mtCore LONG,yearofPeriod LONG,previousPeriod VARCHAR(75) null,previousPeriodCode VARCHAR(75) null,bookId LONG,vehicleClass VARCHAR(75) null,stampType VARCHAR(75) null,stampShortNo VARCHAR(75) null,serialStartNo LONG,serialEndNo LONG,totalQuantities LONG,totalInUse LONG,totalNotUsed LONG,remark VARCHAR(75) null,corporationId LONG,checkType LONG,checkStatus LONG,modifyDate DATE null,syncDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table vr_inventory";
	public static final String ORDER_BY_JPQL = " ORDER BY vrInventory.modifyDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY vr_inventory.modifyDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.fds.vr.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.fds.vr.business.model.VRInventory"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.fds.vr.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.fds.vr.business.model.VRInventory"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.fds.vr.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.fds.vr.business.model.VRInventory"),
			true);
	public static final long BOOKID_COLUMN_BITMASK = 1L;
	public static final long CHECKSTATUS_COLUMN_BITMASK = 2L;
	public static final long CHECKTYPE_COLUMN_BITMASK = 4L;
	public static final long CORPORATIONID_COLUMN_BITMASK = 8L;
	public static final long MTCORE_COLUMN_BITMASK = 16L;
	public static final long VEHICLECLASS_COLUMN_BITMASK = 32L;
	public static final long YEAROFPERIOD_COLUMN_BITMASK = 64L;
	public static final long MODIFYDATE_COLUMN_BITMASK = 128L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.fds.vr.service.util.ServiceProps.get(
				"lock.expiration.time.com.fds.vr.business.model.VRInventory"));

	public VRInventoryModelImpl() {
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
		return VRInventory.class;
	}

	@Override
	public String getModelClassName() {
		return VRInventory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("mtCore", getMtCore());
		attributes.put("yearofPeriod", getYearofPeriod());
		attributes.put("previousPeriod", getPreviousPeriod());
		attributes.put("previousPeriodCode", getPreviousPeriodCode());
		attributes.put("bookId", getBookId());
		attributes.put("vehicleClass", getVehicleClass());
		attributes.put("stampType", getStampType());
		attributes.put("stampShortNo", getStampShortNo());
		attributes.put("serialStartNo", getSerialStartNo());
		attributes.put("serialEndNo", getSerialEndNo());
		attributes.put("totalQuantities", getTotalQuantities());
		attributes.put("totalInUse", getTotalInUse());
		attributes.put("totalNotUsed", getTotalNotUsed());
		attributes.put("remark", getRemark());
		attributes.put("corporationId", getCorporationId());
		attributes.put("checkType", getCheckType());
		attributes.put("checkStatus", getCheckStatus());
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

		Long yearofPeriod = (Long)attributes.get("yearofPeriod");

		if (yearofPeriod != null) {
			setYearofPeriod(yearofPeriod);
		}

		String previousPeriod = (String)attributes.get("previousPeriod");

		if (previousPeriod != null) {
			setPreviousPeriod(previousPeriod);
		}

		String previousPeriodCode = (String)attributes.get("previousPeriodCode");

		if (previousPeriodCode != null) {
			setPreviousPeriodCode(previousPeriodCode);
		}

		Long bookId = (Long)attributes.get("bookId");

		if (bookId != null) {
			setBookId(bookId);
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

		Long totalQuantities = (Long)attributes.get("totalQuantities");

		if (totalQuantities != null) {
			setTotalQuantities(totalQuantities);
		}

		Long totalInUse = (Long)attributes.get("totalInUse");

		if (totalInUse != null) {
			setTotalInUse(totalInUse);
		}

		Long totalNotUsed = (Long)attributes.get("totalNotUsed");

		if (totalNotUsed != null) {
			setTotalNotUsed(totalNotUsed);
		}

		String remark = (String)attributes.get("remark");

		if (remark != null) {
			setRemark(remark);
		}

		Long corporationId = (Long)attributes.get("corporationId");

		if (corporationId != null) {
			setCorporationId(corporationId);
		}

		Long checkType = (Long)attributes.get("checkType");

		if (checkType != null) {
			setCheckType(checkType);
		}

		Long checkStatus = (Long)attributes.get("checkStatus");

		if (checkStatus != null) {
			setCheckStatus(checkStatus);
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
	public long getYearofPeriod() {
		return _yearofPeriod;
	}

	@Override
	public void setYearofPeriod(long yearofPeriod) {
		_columnBitmask |= YEAROFPERIOD_COLUMN_BITMASK;

		if (!_setOriginalYearofPeriod) {
			_setOriginalYearofPeriod = true;

			_originalYearofPeriod = _yearofPeriod;
		}

		_yearofPeriod = yearofPeriod;
	}

	public long getOriginalYearofPeriod() {
		return _originalYearofPeriod;
	}

	@Override
	public String getPreviousPeriod() {
		if (_previousPeriod == null) {
			return StringPool.BLANK;
		}
		else {
			return _previousPeriod;
		}
	}

	@Override
	public void setPreviousPeriod(String previousPeriod) {
		_previousPeriod = previousPeriod;
	}

	@Override
	public String getPreviousPeriodCode() {
		if (_previousPeriodCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _previousPeriodCode;
		}
	}

	@Override
	public void setPreviousPeriodCode(String previousPeriodCode) {
		_previousPeriodCode = previousPeriodCode;
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
		_columnBitmask |= VEHICLECLASS_COLUMN_BITMASK;

		if (_originalVehicleClass == null) {
			_originalVehicleClass = _vehicleClass;
		}

		_vehicleClass = vehicleClass;
	}

	public String getOriginalVehicleClass() {
		return GetterUtil.getString(_originalVehicleClass);
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
		_stampType = stampType;
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
	public long getTotalQuantities() {
		return _totalQuantities;
	}

	@Override
	public void setTotalQuantities(long totalQuantities) {
		_totalQuantities = totalQuantities;
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
	public long getCorporationId() {
		return _corporationId;
	}

	@Override
	public void setCorporationId(long corporationId) {
		_columnBitmask |= CORPORATIONID_COLUMN_BITMASK;

		if (!_setOriginalCorporationId) {
			_setOriginalCorporationId = true;

			_originalCorporationId = _corporationId;
		}

		_corporationId = corporationId;
	}

	public long getOriginalCorporationId() {
		return _originalCorporationId;
	}

	@Override
	public long getCheckType() {
		return _checkType;
	}

	@Override
	public void setCheckType(long checkType) {
		_columnBitmask |= CHECKTYPE_COLUMN_BITMASK;

		if (!_setOriginalCheckType) {
			_setOriginalCheckType = true;

			_originalCheckType = _checkType;
		}

		_checkType = checkType;
	}

	public long getOriginalCheckType() {
		return _originalCheckType;
	}

	@Override
	public long getCheckStatus() {
		return _checkStatus;
	}

	@Override
	public void setCheckStatus(long checkStatus) {
		_columnBitmask |= CHECKSTATUS_COLUMN_BITMASK;

		if (!_setOriginalCheckStatus) {
			_setOriginalCheckStatus = true;

			_originalCheckStatus = _checkStatus;
		}

		_checkStatus = checkStatus;
	}

	public long getOriginalCheckStatus() {
		return _originalCheckStatus;
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
			VRInventory.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public VRInventory toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (VRInventory)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		VRInventoryImpl vrInventoryImpl = new VRInventoryImpl();

		vrInventoryImpl.setId(getId());
		vrInventoryImpl.setMtCore(getMtCore());
		vrInventoryImpl.setYearofPeriod(getYearofPeriod());
		vrInventoryImpl.setPreviousPeriod(getPreviousPeriod());
		vrInventoryImpl.setPreviousPeriodCode(getPreviousPeriodCode());
		vrInventoryImpl.setBookId(getBookId());
		vrInventoryImpl.setVehicleClass(getVehicleClass());
		vrInventoryImpl.setStampType(getStampType());
		vrInventoryImpl.setStampShortNo(getStampShortNo());
		vrInventoryImpl.setSerialStartNo(getSerialStartNo());
		vrInventoryImpl.setSerialEndNo(getSerialEndNo());
		vrInventoryImpl.setTotalQuantities(getTotalQuantities());
		vrInventoryImpl.setTotalInUse(getTotalInUse());
		vrInventoryImpl.setTotalNotUsed(getTotalNotUsed());
		vrInventoryImpl.setRemark(getRemark());
		vrInventoryImpl.setCorporationId(getCorporationId());
		vrInventoryImpl.setCheckType(getCheckType());
		vrInventoryImpl.setCheckStatus(getCheckStatus());
		vrInventoryImpl.setModifyDate(getModifyDate());
		vrInventoryImpl.setSyncDate(getSyncDate());

		vrInventoryImpl.resetOriginalValues();

		return vrInventoryImpl;
	}

	@Override
	public int compareTo(VRInventory vrInventory) {
		int value = 0;

		value = DateUtil.compareTo(getModifyDate(), vrInventory.getModifyDate());

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

		if (!(obj instanceof VRInventory)) {
			return false;
		}

		VRInventory vrInventory = (VRInventory)obj;

		long primaryKey = vrInventory.getPrimaryKey();

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
		VRInventoryModelImpl vrInventoryModelImpl = this;

		vrInventoryModelImpl._originalMtCore = vrInventoryModelImpl._mtCore;

		vrInventoryModelImpl._setOriginalMtCore = false;

		vrInventoryModelImpl._originalYearofPeriod = vrInventoryModelImpl._yearofPeriod;

		vrInventoryModelImpl._setOriginalYearofPeriod = false;

		vrInventoryModelImpl._originalBookId = vrInventoryModelImpl._bookId;

		vrInventoryModelImpl._setOriginalBookId = false;

		vrInventoryModelImpl._originalVehicleClass = vrInventoryModelImpl._vehicleClass;

		vrInventoryModelImpl._originalCorporationId = vrInventoryModelImpl._corporationId;

		vrInventoryModelImpl._setOriginalCorporationId = false;

		vrInventoryModelImpl._originalCheckType = vrInventoryModelImpl._checkType;

		vrInventoryModelImpl._setOriginalCheckType = false;

		vrInventoryModelImpl._originalCheckStatus = vrInventoryModelImpl._checkStatus;

		vrInventoryModelImpl._setOriginalCheckStatus = false;

		vrInventoryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<VRInventory> toCacheModel() {
		VRInventoryCacheModel vrInventoryCacheModel = new VRInventoryCacheModel();

		vrInventoryCacheModel.id = getId();

		vrInventoryCacheModel.mtCore = getMtCore();

		vrInventoryCacheModel.yearofPeriod = getYearofPeriod();

		vrInventoryCacheModel.previousPeriod = getPreviousPeriod();

		String previousPeriod = vrInventoryCacheModel.previousPeriod;

		if ((previousPeriod != null) && (previousPeriod.length() == 0)) {
			vrInventoryCacheModel.previousPeriod = null;
		}

		vrInventoryCacheModel.previousPeriodCode = getPreviousPeriodCode();

		String previousPeriodCode = vrInventoryCacheModel.previousPeriodCode;

		if ((previousPeriodCode != null) && (previousPeriodCode.length() == 0)) {
			vrInventoryCacheModel.previousPeriodCode = null;
		}

		vrInventoryCacheModel.bookId = getBookId();

		vrInventoryCacheModel.vehicleClass = getVehicleClass();

		String vehicleClass = vrInventoryCacheModel.vehicleClass;

		if ((vehicleClass != null) && (vehicleClass.length() == 0)) {
			vrInventoryCacheModel.vehicleClass = null;
		}

		vrInventoryCacheModel.stampType = getStampType();

		String stampType = vrInventoryCacheModel.stampType;

		if ((stampType != null) && (stampType.length() == 0)) {
			vrInventoryCacheModel.stampType = null;
		}

		vrInventoryCacheModel.stampShortNo = getStampShortNo();

		String stampShortNo = vrInventoryCacheModel.stampShortNo;

		if ((stampShortNo != null) && (stampShortNo.length() == 0)) {
			vrInventoryCacheModel.stampShortNo = null;
		}

		vrInventoryCacheModel.serialStartNo = getSerialStartNo();

		vrInventoryCacheModel.serialEndNo = getSerialEndNo();

		vrInventoryCacheModel.totalQuantities = getTotalQuantities();

		vrInventoryCacheModel.totalInUse = getTotalInUse();

		vrInventoryCacheModel.totalNotUsed = getTotalNotUsed();

		vrInventoryCacheModel.remark = getRemark();

		String remark = vrInventoryCacheModel.remark;

		if ((remark != null) && (remark.length() == 0)) {
			vrInventoryCacheModel.remark = null;
		}

		vrInventoryCacheModel.corporationId = getCorporationId();

		vrInventoryCacheModel.checkType = getCheckType();

		vrInventoryCacheModel.checkStatus = getCheckStatus();

		Date modifyDate = getModifyDate();

		if (modifyDate != null) {
			vrInventoryCacheModel.modifyDate = modifyDate.getTime();
		}
		else {
			vrInventoryCacheModel.modifyDate = Long.MIN_VALUE;
		}

		Date syncDate = getSyncDate();

		if (syncDate != null) {
			vrInventoryCacheModel.syncDate = syncDate.getTime();
		}
		else {
			vrInventoryCacheModel.syncDate = Long.MIN_VALUE;
		}

		return vrInventoryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", mtCore=");
		sb.append(getMtCore());
		sb.append(", yearofPeriod=");
		sb.append(getYearofPeriod());
		sb.append(", previousPeriod=");
		sb.append(getPreviousPeriod());
		sb.append(", previousPeriodCode=");
		sb.append(getPreviousPeriodCode());
		sb.append(", bookId=");
		sb.append(getBookId());
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
		sb.append(", totalQuantities=");
		sb.append(getTotalQuantities());
		sb.append(", totalInUse=");
		sb.append(getTotalInUse());
		sb.append(", totalNotUsed=");
		sb.append(getTotalNotUsed());
		sb.append(", remark=");
		sb.append(getRemark());
		sb.append(", corporationId=");
		sb.append(getCorporationId());
		sb.append(", checkType=");
		sb.append(getCheckType());
		sb.append(", checkStatus=");
		sb.append(getCheckStatus());
		sb.append(", modifyDate=");
		sb.append(getModifyDate());
		sb.append(", syncDate=");
		sb.append(getSyncDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(64);

		sb.append("<model><model-name>");
		sb.append("com.fds.vr.business.model.VRInventory");
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
			"<column><column-name>yearofPeriod</column-name><column-value><![CDATA[");
		sb.append(getYearofPeriod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>previousPeriod</column-name><column-value><![CDATA[");
		sb.append(getPreviousPeriod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>previousPeriodCode</column-name><column-value><![CDATA[");
		sb.append(getPreviousPeriodCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bookId</column-name><column-value><![CDATA[");
		sb.append(getBookId());
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
			"<column><column-name>totalQuantities</column-name><column-value><![CDATA[");
		sb.append(getTotalQuantities());
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
			"<column><column-name>remark</column-name><column-value><![CDATA[");
		sb.append(getRemark());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>corporationId</column-name><column-value><![CDATA[");
		sb.append(getCorporationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>checkType</column-name><column-value><![CDATA[");
		sb.append(getCheckType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>checkStatus</column-name><column-value><![CDATA[");
		sb.append(getCheckStatus());
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

	private static final ClassLoader _classLoader = VRInventory.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			VRInventory.class
		};
	private long _id;
	private long _mtCore;
	private long _originalMtCore;
	private boolean _setOriginalMtCore;
	private long _yearofPeriod;
	private long _originalYearofPeriod;
	private boolean _setOriginalYearofPeriod;
	private String _previousPeriod;
	private String _previousPeriodCode;
	private long _bookId;
	private long _originalBookId;
	private boolean _setOriginalBookId;
	private String _vehicleClass;
	private String _originalVehicleClass;
	private String _stampType;
	private String _stampShortNo;
	private long _serialStartNo;
	private long _serialEndNo;
	private long _totalQuantities;
	private long _totalInUse;
	private long _totalNotUsed;
	private String _remark;
	private long _corporationId;
	private long _originalCorporationId;
	private boolean _setOriginalCorporationId;
	private long _checkType;
	private long _originalCheckType;
	private boolean _setOriginalCheckType;
	private long _checkStatus;
	private long _originalCheckStatus;
	private boolean _setOriginalCheckStatus;
	private Date _modifyDate;
	private Date _syncDate;
	private long _columnBitmask;
	private VRInventory _escapedModel;
}