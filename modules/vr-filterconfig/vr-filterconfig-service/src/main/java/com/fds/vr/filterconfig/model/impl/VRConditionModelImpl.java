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

package com.fds.vr.filterconfig.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.fds.vr.filterconfig.model.VRCondition;
import com.fds.vr.filterconfig.model.VRConditionModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
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
 * The base model implementation for the VRCondition service. Represents a row in the &quot;vr_condition&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link VRConditionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VRConditionImpl}.
 * </p>
 *
 * @author NhanHoang
 * @see VRConditionImpl
 * @see VRCondition
 * @see VRConditionModel
 * @generated
 */
@ProviderType
public class VRConditionModelImpl extends BaseModelImpl<VRCondition>
	implements VRConditionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a vr condition model instance should use the {@link VRCondition} interface instead.
	 */
	public static final String TABLE_NAME = "vr_condition";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", Types.BIGINT },
			{ "filterModuleCode", Types.VARCHAR },
			{ "filterTableField", Types.VARCHAR },
			{ "filterTableName", Types.VARCHAR },
			{ "specificationCode", Types.VARCHAR },
			{ "specificationDisplayName", Types.VARCHAR },
			{ "specificationDataCollectionID", Types.VARCHAR },
			{ "sequenceNo", Types.BIGINT },
			{ "specificationBasicUnit", Types.VARCHAR },
			{ "specificationStandard", Types.VARCHAR },
			{ "specificationGroup", Types.VARCHAR },
			{ "modifyDate", Types.TIMESTAMP },
			{ "syncDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("filterModuleCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("filterTableField", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("filterTableName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("specificationCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("specificationDisplayName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("specificationDataCollectionID", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("sequenceNo", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("specificationBasicUnit", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("specificationStandard", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("specificationGroup", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("modifyDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("syncDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table vr_condition (id LONG not null primary key,filterModuleCode VARCHAR(75) null,filterTableField VARCHAR(75) null,filterTableName VARCHAR(75) null,specificationCode VARCHAR(75) null,specificationDisplayName VARCHAR(75) null,specificationDataCollectionID VARCHAR(75) null,sequenceNo LONG,specificationBasicUnit VARCHAR(75) null,specificationStandard VARCHAR(75) null,specificationGroup VARCHAR(75) null,modifyDate DATE null,syncDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table vr_condition";
	public static final String ORDER_BY_JPQL = " ORDER BY vrCondition.id DESC";
	public static final String ORDER_BY_SQL = " ORDER BY vr_condition.id DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(vr.filterconfig.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.fds.vr.filterconfig.model.VRCondition"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(vr.filterconfig.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.fds.vr.filterconfig.model.VRCondition"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(vr.filterconfig.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.fds.vr.filterconfig.model.VRCondition"),
			true);
	public static final long FILTERMODULECODE_COLUMN_BITMASK = 1L;
	public static final long SPECIFICATIONCODE_COLUMN_BITMASK = 2L;
	public static final long ID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(vr.filterconfig.service.util.ServiceProps.get(
				"lock.expiration.time.com.fds.vr.filterconfig.model.VRCondition"));

	public VRConditionModelImpl() {
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
		return VRCondition.class;
	}

	@Override
	public String getModelClassName() {
		return VRCondition.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("filterModuleCode", getFilterModuleCode());
		attributes.put("filterTableField", getFilterTableField());
		attributes.put("filterTableName", getFilterTableName());
		attributes.put("specificationCode", getSpecificationCode());
		attributes.put("specificationDisplayName", getSpecificationDisplayName());
		attributes.put("specificationDataCollectionID",
			getSpecificationDataCollectionID());
		attributes.put("sequenceNo", getSequenceNo());
		attributes.put("specificationBasicUnit", getSpecificationBasicUnit());
		attributes.put("specificationStandard", getSpecificationStandard());
		attributes.put("specificationGroup", getSpecificationGroup());
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

		String filterModuleCode = (String)attributes.get("filterModuleCode");

		if (filterModuleCode != null) {
			setFilterModuleCode(filterModuleCode);
		}

		String filterTableField = (String)attributes.get("filterTableField");

		if (filterTableField != null) {
			setFilterTableField(filterTableField);
		}

		String filterTableName = (String)attributes.get("filterTableName");

		if (filterTableName != null) {
			setFilterTableName(filterTableName);
		}

		String specificationCode = (String)attributes.get("specificationCode");

		if (specificationCode != null) {
			setSpecificationCode(specificationCode);
		}

		String specificationDisplayName = (String)attributes.get(
				"specificationDisplayName");

		if (specificationDisplayName != null) {
			setSpecificationDisplayName(specificationDisplayName);
		}

		String specificationDataCollectionID = (String)attributes.get(
				"specificationDataCollectionID");

		if (specificationDataCollectionID != null) {
			setSpecificationDataCollectionID(specificationDataCollectionID);
		}

		Long sequenceNo = (Long)attributes.get("sequenceNo");

		if (sequenceNo != null) {
			setSequenceNo(sequenceNo);
		}

		String specificationBasicUnit = (String)attributes.get(
				"specificationBasicUnit");

		if (specificationBasicUnit != null) {
			setSpecificationBasicUnit(specificationBasicUnit);
		}

		String specificationStandard = (String)attributes.get(
				"specificationStandard");

		if (specificationStandard != null) {
			setSpecificationStandard(specificationStandard);
		}

		String specificationGroup = (String)attributes.get("specificationGroup");

		if (specificationGroup != null) {
			setSpecificationGroup(specificationGroup);
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
		_columnBitmask = -1L;

		_id = id;
	}

	@Override
	public String getFilterModuleCode() {
		if (_filterModuleCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _filterModuleCode;
		}
	}

	@Override
	public void setFilterModuleCode(String filterModuleCode) {
		_columnBitmask |= FILTERMODULECODE_COLUMN_BITMASK;

		if (_originalFilterModuleCode == null) {
			_originalFilterModuleCode = _filterModuleCode;
		}

		_filterModuleCode = filterModuleCode;
	}

	public String getOriginalFilterModuleCode() {
		return GetterUtil.getString(_originalFilterModuleCode);
	}

	@Override
	public String getFilterTableField() {
		if (_filterTableField == null) {
			return StringPool.BLANK;
		}
		else {
			return _filterTableField;
		}
	}

	@Override
	public void setFilterTableField(String filterTableField) {
		_filterTableField = filterTableField;
	}

	@Override
	public String getFilterTableName() {
		if (_filterTableName == null) {
			return StringPool.BLANK;
		}
		else {
			return _filterTableName;
		}
	}

	@Override
	public void setFilterTableName(String filterTableName) {
		_filterTableName = filterTableName;
	}

	@Override
	public String getSpecificationCode() {
		if (_specificationCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _specificationCode;
		}
	}

	@Override
	public void setSpecificationCode(String specificationCode) {
		_columnBitmask |= SPECIFICATIONCODE_COLUMN_BITMASK;

		if (_originalSpecificationCode == null) {
			_originalSpecificationCode = _specificationCode;
		}

		_specificationCode = specificationCode;
	}

	public String getOriginalSpecificationCode() {
		return GetterUtil.getString(_originalSpecificationCode);
	}

	@Override
	public String getSpecificationDisplayName() {
		if (_specificationDisplayName == null) {
			return StringPool.BLANK;
		}
		else {
			return _specificationDisplayName;
		}
	}

	@Override
	public void setSpecificationDisplayName(String specificationDisplayName) {
		_specificationDisplayName = specificationDisplayName;
	}

	@Override
	public String getSpecificationDataCollectionID() {
		if (_specificationDataCollectionID == null) {
			return StringPool.BLANK;
		}
		else {
			return _specificationDataCollectionID;
		}
	}

	@Override
	public void setSpecificationDataCollectionID(
		String specificationDataCollectionID) {
		_specificationDataCollectionID = specificationDataCollectionID;
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
	public String getSpecificationBasicUnit() {
		if (_specificationBasicUnit == null) {
			return StringPool.BLANK;
		}
		else {
			return _specificationBasicUnit;
		}
	}

	@Override
	public void setSpecificationBasicUnit(String specificationBasicUnit) {
		_specificationBasicUnit = specificationBasicUnit;
	}

	@Override
	public String getSpecificationStandard() {
		if (_specificationStandard == null) {
			return StringPool.BLANK;
		}
		else {
			return _specificationStandard;
		}
	}

	@Override
	public void setSpecificationStandard(String specificationStandard) {
		_specificationStandard = specificationStandard;
	}

	@Override
	public String getSpecificationGroup() {
		if (_specificationGroup == null) {
			return StringPool.BLANK;
		}
		else {
			return _specificationGroup;
		}
	}

	@Override
	public void setSpecificationGroup(String specificationGroup) {
		_specificationGroup = specificationGroup;
	}

	@Override
	public Date getModifyDate() {
		return _modifyDate;
	}

	@Override
	public void setModifyDate(Date modifyDate) {
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
			VRCondition.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public VRCondition toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (VRCondition)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		VRConditionImpl vrConditionImpl = new VRConditionImpl();

		vrConditionImpl.setId(getId());
		vrConditionImpl.setFilterModuleCode(getFilterModuleCode());
		vrConditionImpl.setFilterTableField(getFilterTableField());
		vrConditionImpl.setFilterTableName(getFilterTableName());
		vrConditionImpl.setSpecificationCode(getSpecificationCode());
		vrConditionImpl.setSpecificationDisplayName(getSpecificationDisplayName());
		vrConditionImpl.setSpecificationDataCollectionID(getSpecificationDataCollectionID());
		vrConditionImpl.setSequenceNo(getSequenceNo());
		vrConditionImpl.setSpecificationBasicUnit(getSpecificationBasicUnit());
		vrConditionImpl.setSpecificationStandard(getSpecificationStandard());
		vrConditionImpl.setSpecificationGroup(getSpecificationGroup());
		vrConditionImpl.setModifyDate(getModifyDate());
		vrConditionImpl.setSyncDate(getSyncDate());

		vrConditionImpl.resetOriginalValues();

		return vrConditionImpl;
	}

	@Override
	public int compareTo(VRCondition vrCondition) {
		int value = 0;

		if (getId() < vrCondition.getId()) {
			value = -1;
		}
		else if (getId() > vrCondition.getId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof VRCondition)) {
			return false;
		}

		VRCondition vrCondition = (VRCondition)obj;

		long primaryKey = vrCondition.getPrimaryKey();

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
		VRConditionModelImpl vrConditionModelImpl = this;

		vrConditionModelImpl._originalFilterModuleCode = vrConditionModelImpl._filterModuleCode;

		vrConditionModelImpl._originalSpecificationCode = vrConditionModelImpl._specificationCode;

		vrConditionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<VRCondition> toCacheModel() {
		VRConditionCacheModel vrConditionCacheModel = new VRConditionCacheModel();

		vrConditionCacheModel.id = getId();

		vrConditionCacheModel.filterModuleCode = getFilterModuleCode();

		String filterModuleCode = vrConditionCacheModel.filterModuleCode;

		if ((filterModuleCode != null) && (filterModuleCode.length() == 0)) {
			vrConditionCacheModel.filterModuleCode = null;
		}

		vrConditionCacheModel.filterTableField = getFilterTableField();

		String filterTableField = vrConditionCacheModel.filterTableField;

		if ((filterTableField != null) && (filterTableField.length() == 0)) {
			vrConditionCacheModel.filterTableField = null;
		}

		vrConditionCacheModel.filterTableName = getFilterTableName();

		String filterTableName = vrConditionCacheModel.filterTableName;

		if ((filterTableName != null) && (filterTableName.length() == 0)) {
			vrConditionCacheModel.filterTableName = null;
		}

		vrConditionCacheModel.specificationCode = getSpecificationCode();

		String specificationCode = vrConditionCacheModel.specificationCode;

		if ((specificationCode != null) && (specificationCode.length() == 0)) {
			vrConditionCacheModel.specificationCode = null;
		}

		vrConditionCacheModel.specificationDisplayName = getSpecificationDisplayName();

		String specificationDisplayName = vrConditionCacheModel.specificationDisplayName;

		if ((specificationDisplayName != null) &&
				(specificationDisplayName.length() == 0)) {
			vrConditionCacheModel.specificationDisplayName = null;
		}

		vrConditionCacheModel.specificationDataCollectionID = getSpecificationDataCollectionID();

		String specificationDataCollectionID = vrConditionCacheModel.specificationDataCollectionID;

		if ((specificationDataCollectionID != null) &&
				(specificationDataCollectionID.length() == 0)) {
			vrConditionCacheModel.specificationDataCollectionID = null;
		}

		vrConditionCacheModel.sequenceNo = getSequenceNo();

		vrConditionCacheModel.specificationBasicUnit = getSpecificationBasicUnit();

		String specificationBasicUnit = vrConditionCacheModel.specificationBasicUnit;

		if ((specificationBasicUnit != null) &&
				(specificationBasicUnit.length() == 0)) {
			vrConditionCacheModel.specificationBasicUnit = null;
		}

		vrConditionCacheModel.specificationStandard = getSpecificationStandard();

		String specificationStandard = vrConditionCacheModel.specificationStandard;

		if ((specificationStandard != null) &&
				(specificationStandard.length() == 0)) {
			vrConditionCacheModel.specificationStandard = null;
		}

		vrConditionCacheModel.specificationGroup = getSpecificationGroup();

		String specificationGroup = vrConditionCacheModel.specificationGroup;

		if ((specificationGroup != null) && (specificationGroup.length() == 0)) {
			vrConditionCacheModel.specificationGroup = null;
		}

		Date modifyDate = getModifyDate();

		if (modifyDate != null) {
			vrConditionCacheModel.modifyDate = modifyDate.getTime();
		}
		else {
			vrConditionCacheModel.modifyDate = Long.MIN_VALUE;
		}

		Date syncDate = getSyncDate();

		if (syncDate != null) {
			vrConditionCacheModel.syncDate = syncDate.getTime();
		}
		else {
			vrConditionCacheModel.syncDate = Long.MIN_VALUE;
		}

		return vrConditionCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", filterModuleCode=");
		sb.append(getFilterModuleCode());
		sb.append(", filterTableField=");
		sb.append(getFilterTableField());
		sb.append(", filterTableName=");
		sb.append(getFilterTableName());
		sb.append(", specificationCode=");
		sb.append(getSpecificationCode());
		sb.append(", specificationDisplayName=");
		sb.append(getSpecificationDisplayName());
		sb.append(", specificationDataCollectionID=");
		sb.append(getSpecificationDataCollectionID());
		sb.append(", sequenceNo=");
		sb.append(getSequenceNo());
		sb.append(", specificationBasicUnit=");
		sb.append(getSpecificationBasicUnit());
		sb.append(", specificationStandard=");
		sb.append(getSpecificationStandard());
		sb.append(", specificationGroup=");
		sb.append(getSpecificationGroup());
		sb.append(", modifyDate=");
		sb.append(getModifyDate());
		sb.append(", syncDate=");
		sb.append(getSyncDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.fds.vr.filterconfig.model.VRCondition");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>filterModuleCode</column-name><column-value><![CDATA[");
		sb.append(getFilterModuleCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>filterTableField</column-name><column-value><![CDATA[");
		sb.append(getFilterTableField());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>filterTableName</column-name><column-value><![CDATA[");
		sb.append(getFilterTableName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>specificationCode</column-name><column-value><![CDATA[");
		sb.append(getSpecificationCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>specificationDisplayName</column-name><column-value><![CDATA[");
		sb.append(getSpecificationDisplayName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>specificationDataCollectionID</column-name><column-value><![CDATA[");
		sb.append(getSpecificationDataCollectionID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sequenceNo</column-name><column-value><![CDATA[");
		sb.append(getSequenceNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>specificationBasicUnit</column-name><column-value><![CDATA[");
		sb.append(getSpecificationBasicUnit());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>specificationStandard</column-name><column-value><![CDATA[");
		sb.append(getSpecificationStandard());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>specificationGroup</column-name><column-value><![CDATA[");
		sb.append(getSpecificationGroup());
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

	private static final ClassLoader _classLoader = VRCondition.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			VRCondition.class
		};
	private long _id;
	private String _filterModuleCode;
	private String _originalFilterModuleCode;
	private String _filterTableField;
	private String _filterTableName;
	private String _specificationCode;
	private String _originalSpecificationCode;
	private String _specificationDisplayName;
	private String _specificationDataCollectionID;
	private long _sequenceNo;
	private String _specificationBasicUnit;
	private String _specificationStandard;
	private String _specificationGroup;
	private Date _modifyDate;
	private Date _syncDate;
	private long _columnBitmask;
	private VRCondition _escapedModel;
}