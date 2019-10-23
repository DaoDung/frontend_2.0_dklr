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

import com.fds.vr.business.model.VRProductType;
import com.fds.vr.business.model.VRProductTypeModel;

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
 * The base model implementation for the VRProductType service. Represents a row in the &quot;vr_producttype&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link VRProductTypeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VRProductTypeImpl}.
 * </p>
 *
 * @author LamTV
 * @see VRProductTypeImpl
 * @see VRProductType
 * @see VRProductTypeModel
 * @generated
 */
@ProviderType
public class VRProductTypeModelImpl extends BaseModelImpl<VRProductType>
	implements VRProductTypeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a vr product type model instance should use the {@link VRProductType} interface instead.
	 */
	public static final String TABLE_NAME = "vr_producttype";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", Types.BIGINT },
			{ "mtCore", Types.BIGINT },
			{ "productPlantID", Types.BIGINT },
			{ "sequenceNo", Types.BIGINT },
			{ "vehicleClass", Types.VARCHAR },
			{ "vehicleTypeCode", Types.VARCHAR },
			{ "vehicleTypeDescription", Types.VARCHAR },
			{ "productClassificationCode", Types.VARCHAR },
			{ "productClassificationDescription", Types.VARCHAR },
			{ "trademark", Types.VARCHAR },
			{ "trademarkName", Types.VARCHAR },
			{ "commercialName", Types.VARCHAR },
			{ "modelCode", Types.VARCHAR },
			{ "designSymbolNo", Types.VARCHAR },
			{ "modifyDate", Types.TIMESTAMP },
			{ "syncDate", Types.TIMESTAMP },
			{ "productionPlantId", Types.BIGINT },
			{ "productionPlantCode", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("mtCore", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("productPlantID", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("sequenceNo", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("vehicleClass", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("vehicleTypeCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("vehicleTypeDescription", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("productClassificationCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("productClassificationDescription", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("trademark", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("trademarkName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("commercialName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("modelCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("designSymbolNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("modifyDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("syncDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("productionPlantId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("productionPlantCode", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table vr_producttype (id LONG not null primary key,mtCore LONG,productPlantID LONG,sequenceNo LONG,vehicleClass VARCHAR(75) null,vehicleTypeCode VARCHAR(75) null,vehicleTypeDescription VARCHAR(75) null,productClassificationCode VARCHAR(75) null,productClassificationDescription VARCHAR(75) null,trademark VARCHAR(75) null,trademarkName VARCHAR(75) null,commercialName VARCHAR(75) null,modelCode VARCHAR(75) null,designSymbolNo VARCHAR(75) null,modifyDate DATE null,syncDate DATE null,productionPlantId LONG,productionPlantCode VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table vr_producttype";
	public static final String ORDER_BY_JPQL = " ORDER BY vrProductType.modifyDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY vr_producttype.modifyDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.fds.vr.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.fds.vr.business.model.VRProductType"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.fds.vr.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.fds.vr.business.model.VRProductType"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.fds.vr.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.fds.vr.business.model.VRProductType"),
			true);
	public static final long MTCORE_COLUMN_BITMASK = 1L;
	public static final long PRODUCTPLANTID_COLUMN_BITMASK = 2L;
	public static final long MODIFYDATE_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.fds.vr.service.util.ServiceProps.get(
				"lock.expiration.time.com.fds.vr.business.model.VRProductType"));

	public VRProductTypeModelImpl() {
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
		return VRProductType.class;
	}

	@Override
	public String getModelClassName() {
		return VRProductType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("mtCore", getMtCore());
		attributes.put("productPlantID", getProductPlantID());
		attributes.put("sequenceNo", getSequenceNo());
		attributes.put("vehicleClass", getVehicleClass());
		attributes.put("vehicleTypeCode", getVehicleTypeCode());
		attributes.put("vehicleTypeDescription", getVehicleTypeDescription());
		attributes.put("productClassificationCode",
			getProductClassificationCode());
		attributes.put("productClassificationDescription",
			getProductClassificationDescription());
		attributes.put("trademark", getTrademark());
		attributes.put("trademarkName", getTrademarkName());
		attributes.put("commercialName", getCommercialName());
		attributes.put("modelCode", getModelCode());
		attributes.put("designSymbolNo", getDesignSymbolNo());
		attributes.put("modifyDate", getModifyDate());
		attributes.put("syncDate", getSyncDate());
		attributes.put("productionPlantId", getProductionPlantId());
		attributes.put("productionPlantCode", getProductionPlantCode());

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

		Long productPlantID = (Long)attributes.get("productPlantID");

		if (productPlantID != null) {
			setProductPlantID(productPlantID);
		}

		Long sequenceNo = (Long)attributes.get("sequenceNo");

		if (sequenceNo != null) {
			setSequenceNo(sequenceNo);
		}

		String vehicleClass = (String)attributes.get("vehicleClass");

		if (vehicleClass != null) {
			setVehicleClass(vehicleClass);
		}

		String vehicleTypeCode = (String)attributes.get("vehicleTypeCode");

		if (vehicleTypeCode != null) {
			setVehicleTypeCode(vehicleTypeCode);
		}

		String vehicleTypeDescription = (String)attributes.get(
				"vehicleTypeDescription");

		if (vehicleTypeDescription != null) {
			setVehicleTypeDescription(vehicleTypeDescription);
		}

		String productClassificationCode = (String)attributes.get(
				"productClassificationCode");

		if (productClassificationCode != null) {
			setProductClassificationCode(productClassificationCode);
		}

		String productClassificationDescription = (String)attributes.get(
				"productClassificationDescription");

		if (productClassificationDescription != null) {
			setProductClassificationDescription(productClassificationDescription);
		}

		String trademark = (String)attributes.get("trademark");

		if (trademark != null) {
			setTrademark(trademark);
		}

		String trademarkName = (String)attributes.get("trademarkName");

		if (trademarkName != null) {
			setTrademarkName(trademarkName);
		}

		String commercialName = (String)attributes.get("commercialName");

		if (commercialName != null) {
			setCommercialName(commercialName);
		}

		String modelCode = (String)attributes.get("modelCode");

		if (modelCode != null) {
			setModelCode(modelCode);
		}

		String designSymbolNo = (String)attributes.get("designSymbolNo");

		if (designSymbolNo != null) {
			setDesignSymbolNo(designSymbolNo);
		}

		Date modifyDate = (Date)attributes.get("modifyDate");

		if (modifyDate != null) {
			setModifyDate(modifyDate);
		}

		Date syncDate = (Date)attributes.get("syncDate");

		if (syncDate != null) {
			setSyncDate(syncDate);
		}

		Long productionPlantId = (Long)attributes.get("productionPlantId");

		if (productionPlantId != null) {
			setProductionPlantId(productionPlantId);
		}

		String productionPlantCode = (String)attributes.get(
				"productionPlantCode");

		if (productionPlantCode != null) {
			setProductionPlantCode(productionPlantCode);
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
	public long getProductPlantID() {
		return _productPlantID;
	}

	@Override
	public void setProductPlantID(long productPlantID) {
		_columnBitmask |= PRODUCTPLANTID_COLUMN_BITMASK;

		if (!_setOriginalProductPlantID) {
			_setOriginalProductPlantID = true;

			_originalProductPlantID = _productPlantID;
		}

		_productPlantID = productPlantID;
	}

	public long getOriginalProductPlantID() {
		return _originalProductPlantID;
	}

	@Override
	public long getSequenceNo() {
		return _sequenceNo;
	}

	@Override
	public void setSequenceNo(long sequenceNo) {
		_sequenceNo = sequenceNo;
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
	public String getVehicleTypeCode() {
		if (_vehicleTypeCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _vehicleTypeCode;
		}
	}

	@Override
	public void setVehicleTypeCode(String vehicleTypeCode) {
		_vehicleTypeCode = vehicleTypeCode;
	}

	@Override
	public String getVehicleTypeDescription() {
		if (_vehicleTypeDescription == null) {
			return StringPool.BLANK;
		}
		else {
			return _vehicleTypeDescription;
		}
	}

	@Override
	public void setVehicleTypeDescription(String vehicleTypeDescription) {
		_vehicleTypeDescription = vehicleTypeDescription;
	}

	@Override
	public String getProductClassificationCode() {
		if (_productClassificationCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _productClassificationCode;
		}
	}

	@Override
	public void setProductClassificationCode(String productClassificationCode) {
		_productClassificationCode = productClassificationCode;
	}

	@Override
	public String getProductClassificationDescription() {
		if (_productClassificationDescription == null) {
			return StringPool.BLANK;
		}
		else {
			return _productClassificationDescription;
		}
	}

	@Override
	public void setProductClassificationDescription(
		String productClassificationDescription) {
		_productClassificationDescription = productClassificationDescription;
	}

	@Override
	public String getTrademark() {
		if (_trademark == null) {
			return StringPool.BLANK;
		}
		else {
			return _trademark;
		}
	}

	@Override
	public void setTrademark(String trademark) {
		_trademark = trademark;
	}

	@Override
	public String getTrademarkName() {
		if (_trademarkName == null) {
			return StringPool.BLANK;
		}
		else {
			return _trademarkName;
		}
	}

	@Override
	public void setTrademarkName(String trademarkName) {
		_trademarkName = trademarkName;
	}

	@Override
	public String getCommercialName() {
		if (_commercialName == null) {
			return StringPool.BLANK;
		}
		else {
			return _commercialName;
		}
	}

	@Override
	public void setCommercialName(String commercialName) {
		_commercialName = commercialName;
	}

	@Override
	public String getModelCode() {
		if (_modelCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _modelCode;
		}
	}

	@Override
	public void setModelCode(String modelCode) {
		_modelCode = modelCode;
	}

	@Override
	public String getDesignSymbolNo() {
		if (_designSymbolNo == null) {
			return StringPool.BLANK;
		}
		else {
			return _designSymbolNo;
		}
	}

	@Override
	public void setDesignSymbolNo(String designSymbolNo) {
		_designSymbolNo = designSymbolNo;
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

	@Override
	public long getProductionPlantId() {
		return _productionPlantId;
	}

	@Override
	public void setProductionPlantId(long productionPlantId) {
		_productionPlantId = productionPlantId;
	}

	@Override
	public String getProductionPlantCode() {
		if (_productionPlantCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _productionPlantCode;
		}
	}

	@Override
	public void setProductionPlantCode(String productionPlantCode) {
		_productionPlantCode = productionPlantCode;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			VRProductType.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public VRProductType toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (VRProductType)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		VRProductTypeImpl vrProductTypeImpl = new VRProductTypeImpl();

		vrProductTypeImpl.setId(getId());
		vrProductTypeImpl.setMtCore(getMtCore());
		vrProductTypeImpl.setProductPlantID(getProductPlantID());
		vrProductTypeImpl.setSequenceNo(getSequenceNo());
		vrProductTypeImpl.setVehicleClass(getVehicleClass());
		vrProductTypeImpl.setVehicleTypeCode(getVehicleTypeCode());
		vrProductTypeImpl.setVehicleTypeDescription(getVehicleTypeDescription());
		vrProductTypeImpl.setProductClassificationCode(getProductClassificationCode());
		vrProductTypeImpl.setProductClassificationDescription(getProductClassificationDescription());
		vrProductTypeImpl.setTrademark(getTrademark());
		vrProductTypeImpl.setTrademarkName(getTrademarkName());
		vrProductTypeImpl.setCommercialName(getCommercialName());
		vrProductTypeImpl.setModelCode(getModelCode());
		vrProductTypeImpl.setDesignSymbolNo(getDesignSymbolNo());
		vrProductTypeImpl.setModifyDate(getModifyDate());
		vrProductTypeImpl.setSyncDate(getSyncDate());
		vrProductTypeImpl.setProductionPlantId(getProductionPlantId());
		vrProductTypeImpl.setProductionPlantCode(getProductionPlantCode());

		vrProductTypeImpl.resetOriginalValues();

		return vrProductTypeImpl;
	}

	@Override
	public int compareTo(VRProductType vrProductType) {
		int value = 0;

		value = DateUtil.compareTo(getModifyDate(),
				vrProductType.getModifyDate());

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

		if (!(obj instanceof VRProductType)) {
			return false;
		}

		VRProductType vrProductType = (VRProductType)obj;

		long primaryKey = vrProductType.getPrimaryKey();

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
		VRProductTypeModelImpl vrProductTypeModelImpl = this;

		vrProductTypeModelImpl._originalMtCore = vrProductTypeModelImpl._mtCore;

		vrProductTypeModelImpl._setOriginalMtCore = false;

		vrProductTypeModelImpl._originalProductPlantID = vrProductTypeModelImpl._productPlantID;

		vrProductTypeModelImpl._setOriginalProductPlantID = false;

		vrProductTypeModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<VRProductType> toCacheModel() {
		VRProductTypeCacheModel vrProductTypeCacheModel = new VRProductTypeCacheModel();

		vrProductTypeCacheModel.id = getId();

		vrProductTypeCacheModel.mtCore = getMtCore();

		vrProductTypeCacheModel.productPlantID = getProductPlantID();

		vrProductTypeCacheModel.sequenceNo = getSequenceNo();

		vrProductTypeCacheModel.vehicleClass = getVehicleClass();

		String vehicleClass = vrProductTypeCacheModel.vehicleClass;

		if ((vehicleClass != null) && (vehicleClass.length() == 0)) {
			vrProductTypeCacheModel.vehicleClass = null;
		}

		vrProductTypeCacheModel.vehicleTypeCode = getVehicleTypeCode();

		String vehicleTypeCode = vrProductTypeCacheModel.vehicleTypeCode;

		if ((vehicleTypeCode != null) && (vehicleTypeCode.length() == 0)) {
			vrProductTypeCacheModel.vehicleTypeCode = null;
		}

		vrProductTypeCacheModel.vehicleTypeDescription = getVehicleTypeDescription();

		String vehicleTypeDescription = vrProductTypeCacheModel.vehicleTypeDescription;

		if ((vehicleTypeDescription != null) &&
				(vehicleTypeDescription.length() == 0)) {
			vrProductTypeCacheModel.vehicleTypeDescription = null;
		}

		vrProductTypeCacheModel.productClassificationCode = getProductClassificationCode();

		String productClassificationCode = vrProductTypeCacheModel.productClassificationCode;

		if ((productClassificationCode != null) &&
				(productClassificationCode.length() == 0)) {
			vrProductTypeCacheModel.productClassificationCode = null;
		}

		vrProductTypeCacheModel.productClassificationDescription = getProductClassificationDescription();

		String productClassificationDescription = vrProductTypeCacheModel.productClassificationDescription;

		if ((productClassificationDescription != null) &&
				(productClassificationDescription.length() == 0)) {
			vrProductTypeCacheModel.productClassificationDescription = null;
		}

		vrProductTypeCacheModel.trademark = getTrademark();

		String trademark = vrProductTypeCacheModel.trademark;

		if ((trademark != null) && (trademark.length() == 0)) {
			vrProductTypeCacheModel.trademark = null;
		}

		vrProductTypeCacheModel.trademarkName = getTrademarkName();

		String trademarkName = vrProductTypeCacheModel.trademarkName;

		if ((trademarkName != null) && (trademarkName.length() == 0)) {
			vrProductTypeCacheModel.trademarkName = null;
		}

		vrProductTypeCacheModel.commercialName = getCommercialName();

		String commercialName = vrProductTypeCacheModel.commercialName;

		if ((commercialName != null) && (commercialName.length() == 0)) {
			vrProductTypeCacheModel.commercialName = null;
		}

		vrProductTypeCacheModel.modelCode = getModelCode();

		String modelCode = vrProductTypeCacheModel.modelCode;

		if ((modelCode != null) && (modelCode.length() == 0)) {
			vrProductTypeCacheModel.modelCode = null;
		}

		vrProductTypeCacheModel.designSymbolNo = getDesignSymbolNo();

		String designSymbolNo = vrProductTypeCacheModel.designSymbolNo;

		if ((designSymbolNo != null) && (designSymbolNo.length() == 0)) {
			vrProductTypeCacheModel.designSymbolNo = null;
		}

		Date modifyDate = getModifyDate();

		if (modifyDate != null) {
			vrProductTypeCacheModel.modifyDate = modifyDate.getTime();
		}
		else {
			vrProductTypeCacheModel.modifyDate = Long.MIN_VALUE;
		}

		Date syncDate = getSyncDate();

		if (syncDate != null) {
			vrProductTypeCacheModel.syncDate = syncDate.getTime();
		}
		else {
			vrProductTypeCacheModel.syncDate = Long.MIN_VALUE;
		}

		vrProductTypeCacheModel.productionPlantId = getProductionPlantId();

		vrProductTypeCacheModel.productionPlantCode = getProductionPlantCode();

		String productionPlantCode = vrProductTypeCacheModel.productionPlantCode;

		if ((productionPlantCode != null) &&
				(productionPlantCode.length() == 0)) {
			vrProductTypeCacheModel.productionPlantCode = null;
		}

		return vrProductTypeCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", mtCore=");
		sb.append(getMtCore());
		sb.append(", productPlantID=");
		sb.append(getProductPlantID());
		sb.append(", sequenceNo=");
		sb.append(getSequenceNo());
		sb.append(", vehicleClass=");
		sb.append(getVehicleClass());
		sb.append(", vehicleTypeCode=");
		sb.append(getVehicleTypeCode());
		sb.append(", vehicleTypeDescription=");
		sb.append(getVehicleTypeDescription());
		sb.append(", productClassificationCode=");
		sb.append(getProductClassificationCode());
		sb.append(", productClassificationDescription=");
		sb.append(getProductClassificationDescription());
		sb.append(", trademark=");
		sb.append(getTrademark());
		sb.append(", trademarkName=");
		sb.append(getTrademarkName());
		sb.append(", commercialName=");
		sb.append(getCommercialName());
		sb.append(", modelCode=");
		sb.append(getModelCode());
		sb.append(", designSymbolNo=");
		sb.append(getDesignSymbolNo());
		sb.append(", modifyDate=");
		sb.append(getModifyDate());
		sb.append(", syncDate=");
		sb.append(getSyncDate());
		sb.append(", productionPlantId=");
		sb.append(getProductionPlantId());
		sb.append(", productionPlantCode=");
		sb.append(getProductionPlantCode());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("com.fds.vr.business.model.VRProductType");
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
			"<column><column-name>productPlantID</column-name><column-value><![CDATA[");
		sb.append(getProductPlantID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sequenceNo</column-name><column-value><![CDATA[");
		sb.append(getSequenceNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>vehicleClass</column-name><column-value><![CDATA[");
		sb.append(getVehicleClass());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>vehicleTypeCode</column-name><column-value><![CDATA[");
		sb.append(getVehicleTypeCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>vehicleTypeDescription</column-name><column-value><![CDATA[");
		sb.append(getVehicleTypeDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productClassificationCode</column-name><column-value><![CDATA[");
		sb.append(getProductClassificationCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productClassificationDescription</column-name><column-value><![CDATA[");
		sb.append(getProductClassificationDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trademark</column-name><column-value><![CDATA[");
		sb.append(getTrademark());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trademarkName</column-name><column-value><![CDATA[");
		sb.append(getTrademarkName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>commercialName</column-name><column-value><![CDATA[");
		sb.append(getCommercialName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modelCode</column-name><column-value><![CDATA[");
		sb.append(getModelCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>designSymbolNo</column-name><column-value><![CDATA[");
		sb.append(getDesignSymbolNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifyDate</column-name><column-value><![CDATA[");
		sb.append(getModifyDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>syncDate</column-name><column-value><![CDATA[");
		sb.append(getSyncDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productionPlantId</column-name><column-value><![CDATA[");
		sb.append(getProductionPlantId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productionPlantCode</column-name><column-value><![CDATA[");
		sb.append(getProductionPlantCode());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = VRProductType.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			VRProductType.class
		};
	private long _id;
	private long _mtCore;
	private long _originalMtCore;
	private boolean _setOriginalMtCore;
	private long _productPlantID;
	private long _originalProductPlantID;
	private boolean _setOriginalProductPlantID;
	private long _sequenceNo;
	private String _vehicleClass;
	private String _vehicleTypeCode;
	private String _vehicleTypeDescription;
	private String _productClassificationCode;
	private String _productClassificationDescription;
	private String _trademark;
	private String _trademarkName;
	private String _commercialName;
	private String _modelCode;
	private String _designSymbolNo;
	private Date _modifyDate;
	private Date _syncDate;
	private long _productionPlantId;
	private String _productionPlantCode;
	private long _columnBitmask;
	private VRProductType _escapedModel;
}