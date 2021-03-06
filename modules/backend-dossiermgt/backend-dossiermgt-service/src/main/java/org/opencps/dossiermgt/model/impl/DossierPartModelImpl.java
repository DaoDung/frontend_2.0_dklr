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

package org.opencps.dossiermgt.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import org.opencps.dossiermgt.model.DossierPart;
import org.opencps.dossiermgt.model.DossierPartModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the DossierPart service. Represents a row in the &quot;opencps_dossierpart&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link DossierPartModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DossierPartImpl}.
 * </p>
 *
 * @author huymq
 * @see DossierPartImpl
 * @see DossierPart
 * @see DossierPartModel
 * @generated
 */
@ProviderType
public class DossierPartModelImpl extends BaseModelImpl<DossierPart>
	implements DossierPartModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dossier part model instance should use the {@link DossierPart} interface instead.
	 */
	public static final String TABLE_NAME = "opencps_dossierpart";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "dossierPartId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "templateNo", Types.VARCHAR },
			{ "partNo", Types.VARCHAR },
			{ "partName", Types.VARCHAR },
			{ "partTip", Types.VARCHAR },
			{ "partType", Types.INTEGER },
			{ "multiple", Types.BOOLEAN },
			{ "formScript", Types.VARCHAR },
			{ "formReport", Types.VARCHAR },
			{ "sampleData", Types.VARCHAR },
			{ "required", Types.BOOLEAN },
			{ "fileTemplateNo", Types.VARCHAR },
			{ "eSign", Types.BOOLEAN },
			{ "deliverableType", Types.VARCHAR },
			{ "deliverableAction", Types.INTEGER }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dossierPartId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("templateNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("partNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("partName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("partTip", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("partType", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("multiple", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("formScript", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("formReport", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("sampleData", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("required", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("fileTemplateNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("eSign", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("deliverableType", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("deliverableAction", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE = "create table opencps_dossierpart (uuid_ VARCHAR(75) null,dossierPartId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,templateNo VARCHAR(75) null,partNo VARCHAR(75) null,partName VARCHAR(75) null,partTip VARCHAR(75) null,partType INTEGER,multiple BOOLEAN,formScript VARCHAR(75) null,formReport VARCHAR(75) null,sampleData VARCHAR(75) null,required BOOLEAN,fileTemplateNo VARCHAR(75) null,eSign BOOLEAN,deliverableType VARCHAR(75) null,deliverableAction INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table opencps_dossierpart";
	public static final String ORDER_BY_JPQL = " ORDER BY dossierPart.dossierPartId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY opencps_dossierpart.dossierPartId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.org.opencps.dossiermgt.model.DossierPart"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.org.opencps.dossiermgt.model.DossierPart"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.opencps.dossiermgt.model.DossierPart"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long ESIGN_COLUMN_BITMASK = 2L;
	public static final long FILETEMPLATENO_COLUMN_BITMASK = 4L;
	public static final long GROUPID_COLUMN_BITMASK = 8L;
	public static final long PARTNO_COLUMN_BITMASK = 16L;
	public static final long PARTTYPE_COLUMN_BITMASK = 32L;
	public static final long TEMPLATENO_COLUMN_BITMASK = 64L;
	public static final long UUID_COLUMN_BITMASK = 128L;
	public static final long DOSSIERPARTID_COLUMN_BITMASK = 256L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"lock.expiration.time.org.opencps.dossiermgt.model.DossierPart"));

	public DossierPartModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _dossierPartId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDossierPartId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dossierPartId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DossierPart.class;
	}

	@Override
	public String getModelClassName() {
		return DossierPart.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("dossierPartId", getDossierPartId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("templateNo", getTemplateNo());
		attributes.put("partNo", getPartNo());
		attributes.put("partName", getPartName());
		attributes.put("partTip", getPartTip());
		attributes.put("partType", getPartType());
		attributes.put("multiple", getMultiple());
		attributes.put("formScript", getFormScript());
		attributes.put("formReport", getFormReport());
		attributes.put("sampleData", getSampleData());
		attributes.put("required", getRequired());
		attributes.put("fileTemplateNo", getFileTemplateNo());
		attributes.put("eSign", getESign());
		attributes.put("deliverableType", getDeliverableType());
		attributes.put("deliverableAction", getDeliverableAction());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long dossierPartId = (Long)attributes.get("dossierPartId");

		if (dossierPartId != null) {
			setDossierPartId(dossierPartId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String templateNo = (String)attributes.get("templateNo");

		if (templateNo != null) {
			setTemplateNo(templateNo);
		}

		String partNo = (String)attributes.get("partNo");

		if (partNo != null) {
			setPartNo(partNo);
		}

		String partName = (String)attributes.get("partName");

		if (partName != null) {
			setPartName(partName);
		}

		String partTip = (String)attributes.get("partTip");

		if (partTip != null) {
			setPartTip(partTip);
		}

		Integer partType = (Integer)attributes.get("partType");

		if (partType != null) {
			setPartType(partType);
		}

		Boolean multiple = (Boolean)attributes.get("multiple");

		if (multiple != null) {
			setMultiple(multiple);
		}

		String formScript = (String)attributes.get("formScript");

		if (formScript != null) {
			setFormScript(formScript);
		}

		String formReport = (String)attributes.get("formReport");

		if (formReport != null) {
			setFormReport(formReport);
		}

		String sampleData = (String)attributes.get("sampleData");

		if (sampleData != null) {
			setSampleData(sampleData);
		}

		Boolean required = (Boolean)attributes.get("required");

		if (required != null) {
			setRequired(required);
		}

		String fileTemplateNo = (String)attributes.get("fileTemplateNo");

		if (fileTemplateNo != null) {
			setFileTemplateNo(fileTemplateNo);
		}

		Boolean eSign = (Boolean)attributes.get("eSign");

		if (eSign != null) {
			setESign(eSign);
		}

		String deliverableType = (String)attributes.get("deliverableType");

		if (deliverableType != null) {
			setDeliverableType(deliverableType);
		}

		Integer deliverableAction = (Integer)attributes.get("deliverableAction");

		if (deliverableAction != null) {
			setDeliverableAction(deliverableAction);
		}
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getDossierPartId() {
		return _dossierPartId;
	}

	@Override
	public void setDossierPartId(long dossierPartId) {
		_dossierPartId = dossierPartId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getTemplateNo() {
		if (_templateNo == null) {
			return StringPool.BLANK;
		}
		else {
			return _templateNo;
		}
	}

	@Override
	public void setTemplateNo(String templateNo) {
		_columnBitmask |= TEMPLATENO_COLUMN_BITMASK;

		if (_originalTemplateNo == null) {
			_originalTemplateNo = _templateNo;
		}

		_templateNo = templateNo;
	}

	public String getOriginalTemplateNo() {
		return GetterUtil.getString(_originalTemplateNo);
	}

	@Override
	public String getPartNo() {
		if (_partNo == null) {
			return StringPool.BLANK;
		}
		else {
			return _partNo;
		}
	}

	@Override
	public void setPartNo(String partNo) {
		_columnBitmask |= PARTNO_COLUMN_BITMASK;

		if (_originalPartNo == null) {
			_originalPartNo = _partNo;
		}

		_partNo = partNo;
	}

	public String getOriginalPartNo() {
		return GetterUtil.getString(_originalPartNo);
	}

	@Override
	public String getPartName() {
		if (_partName == null) {
			return StringPool.BLANK;
		}
		else {
			return _partName;
		}
	}

	@Override
	public void setPartName(String partName) {
		_partName = partName;
	}

	@Override
	public String getPartTip() {
		if (_partTip == null) {
			return StringPool.BLANK;
		}
		else {
			return _partTip;
		}
	}

	@Override
	public void setPartTip(String partTip) {
		_partTip = partTip;
	}

	@Override
	public int getPartType() {
		return _partType;
	}

	@Override
	public void setPartType(int partType) {
		_columnBitmask |= PARTTYPE_COLUMN_BITMASK;

		if (!_setOriginalPartType) {
			_setOriginalPartType = true;

			_originalPartType = _partType;
		}

		_partType = partType;
	}

	public int getOriginalPartType() {
		return _originalPartType;
	}

	@Override
	public boolean getMultiple() {
		return _multiple;
	}

	@Override
	public boolean isMultiple() {
		return _multiple;
	}

	@Override
	public void setMultiple(boolean multiple) {
		_multiple = multiple;
	}

	@Override
	public String getFormScript() {
		if (_formScript == null) {
			return StringPool.BLANK;
		}
		else {
			return _formScript;
		}
	}

	@Override
	public void setFormScript(String formScript) {
		_formScript = formScript;
	}

	@Override
	public String getFormReport() {
		if (_formReport == null) {
			return StringPool.BLANK;
		}
		else {
			return _formReport;
		}
	}

	@Override
	public void setFormReport(String formReport) {
		_formReport = formReport;
	}

	@Override
	public String getSampleData() {
		if (_sampleData == null) {
			return StringPool.BLANK;
		}
		else {
			return _sampleData;
		}
	}

	@Override
	public void setSampleData(String sampleData) {
		_sampleData = sampleData;
	}

	@Override
	public boolean getRequired() {
		return _required;
	}

	@Override
	public boolean isRequired() {
		return _required;
	}

	@Override
	public void setRequired(boolean required) {
		_required = required;
	}

	@Override
	public String getFileTemplateNo() {
		if (_fileTemplateNo == null) {
			return StringPool.BLANK;
		}
		else {
			return _fileTemplateNo;
		}
	}

	@Override
	public void setFileTemplateNo(String fileTemplateNo) {
		_columnBitmask |= FILETEMPLATENO_COLUMN_BITMASK;

		if (_originalFileTemplateNo == null) {
			_originalFileTemplateNo = _fileTemplateNo;
		}

		_fileTemplateNo = fileTemplateNo;
	}

	public String getOriginalFileTemplateNo() {
		return GetterUtil.getString(_originalFileTemplateNo);
	}

	@Override
	public boolean getESign() {
		return _eSign;
	}

	@Override
	public boolean isESign() {
		return _eSign;
	}

	@Override
	public void setESign(boolean eSign) {
		_columnBitmask |= ESIGN_COLUMN_BITMASK;

		if (!_setOriginalESign) {
			_setOriginalESign = true;

			_originalESign = _eSign;
		}

		_eSign = eSign;
	}

	public boolean getOriginalESign() {
		return _originalESign;
	}

	@Override
	public String getDeliverableType() {
		if (_deliverableType == null) {
			return StringPool.BLANK;
		}
		else {
			return _deliverableType;
		}
	}

	@Override
	public void setDeliverableType(String deliverableType) {
		_deliverableType = deliverableType;
	}

	@Override
	public int getDeliverableAction() {
		return _deliverableAction;
	}

	@Override
	public void setDeliverableAction(int deliverableAction) {
		_deliverableAction = deliverableAction;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				DossierPart.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			DossierPart.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DossierPart toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (DossierPart)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DossierPartImpl dossierPartImpl = new DossierPartImpl();

		dossierPartImpl.setUuid(getUuid());
		dossierPartImpl.setDossierPartId(getDossierPartId());
		dossierPartImpl.setGroupId(getGroupId());
		dossierPartImpl.setCompanyId(getCompanyId());
		dossierPartImpl.setUserId(getUserId());
		dossierPartImpl.setUserName(getUserName());
		dossierPartImpl.setCreateDate(getCreateDate());
		dossierPartImpl.setModifiedDate(getModifiedDate());
		dossierPartImpl.setTemplateNo(getTemplateNo());
		dossierPartImpl.setPartNo(getPartNo());
		dossierPartImpl.setPartName(getPartName());
		dossierPartImpl.setPartTip(getPartTip());
		dossierPartImpl.setPartType(getPartType());
		dossierPartImpl.setMultiple(getMultiple());
		dossierPartImpl.setFormScript(getFormScript());
		dossierPartImpl.setFormReport(getFormReport());
		dossierPartImpl.setSampleData(getSampleData());
		dossierPartImpl.setRequired(getRequired());
		dossierPartImpl.setFileTemplateNo(getFileTemplateNo());
		dossierPartImpl.setESign(getESign());
		dossierPartImpl.setDeliverableType(getDeliverableType());
		dossierPartImpl.setDeliverableAction(getDeliverableAction());

		dossierPartImpl.resetOriginalValues();

		return dossierPartImpl;
	}

	@Override
	public int compareTo(DossierPart dossierPart) {
		long primaryKey = dossierPart.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DossierPart)) {
			return false;
		}

		DossierPart dossierPart = (DossierPart)obj;

		long primaryKey = dossierPart.getPrimaryKey();

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
		DossierPartModelImpl dossierPartModelImpl = this;

		dossierPartModelImpl._originalUuid = dossierPartModelImpl._uuid;

		dossierPartModelImpl._originalGroupId = dossierPartModelImpl._groupId;

		dossierPartModelImpl._setOriginalGroupId = false;

		dossierPartModelImpl._originalCompanyId = dossierPartModelImpl._companyId;

		dossierPartModelImpl._setOriginalCompanyId = false;

		dossierPartModelImpl._setModifiedDate = false;

		dossierPartModelImpl._originalTemplateNo = dossierPartModelImpl._templateNo;

		dossierPartModelImpl._originalPartNo = dossierPartModelImpl._partNo;

		dossierPartModelImpl._originalPartType = dossierPartModelImpl._partType;

		dossierPartModelImpl._setOriginalPartType = false;

		dossierPartModelImpl._originalFileTemplateNo = dossierPartModelImpl._fileTemplateNo;

		dossierPartModelImpl._originalESign = dossierPartModelImpl._eSign;

		dossierPartModelImpl._setOriginalESign = false;

		dossierPartModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DossierPart> toCacheModel() {
		DossierPartCacheModel dossierPartCacheModel = new DossierPartCacheModel();

		dossierPartCacheModel.uuid = getUuid();

		String uuid = dossierPartCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			dossierPartCacheModel.uuid = null;
		}

		dossierPartCacheModel.dossierPartId = getDossierPartId();

		dossierPartCacheModel.groupId = getGroupId();

		dossierPartCacheModel.companyId = getCompanyId();

		dossierPartCacheModel.userId = getUserId();

		dossierPartCacheModel.userName = getUserName();

		String userName = dossierPartCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			dossierPartCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			dossierPartCacheModel.createDate = createDate.getTime();
		}
		else {
			dossierPartCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			dossierPartCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			dossierPartCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		dossierPartCacheModel.templateNo = getTemplateNo();

		String templateNo = dossierPartCacheModel.templateNo;

		if ((templateNo != null) && (templateNo.length() == 0)) {
			dossierPartCacheModel.templateNo = null;
		}

		dossierPartCacheModel.partNo = getPartNo();

		String partNo = dossierPartCacheModel.partNo;

		if ((partNo != null) && (partNo.length() == 0)) {
			dossierPartCacheModel.partNo = null;
		}

		dossierPartCacheModel.partName = getPartName();

		String partName = dossierPartCacheModel.partName;

		if ((partName != null) && (partName.length() == 0)) {
			dossierPartCacheModel.partName = null;
		}

		dossierPartCacheModel.partTip = getPartTip();

		String partTip = dossierPartCacheModel.partTip;

		if ((partTip != null) && (partTip.length() == 0)) {
			dossierPartCacheModel.partTip = null;
		}

		dossierPartCacheModel.partType = getPartType();

		dossierPartCacheModel.multiple = getMultiple();

		dossierPartCacheModel.formScript = getFormScript();

		String formScript = dossierPartCacheModel.formScript;

		if ((formScript != null) && (formScript.length() == 0)) {
			dossierPartCacheModel.formScript = null;
		}

		dossierPartCacheModel.formReport = getFormReport();

		String formReport = dossierPartCacheModel.formReport;

		if ((formReport != null) && (formReport.length() == 0)) {
			dossierPartCacheModel.formReport = null;
		}

		dossierPartCacheModel.sampleData = getSampleData();

		String sampleData = dossierPartCacheModel.sampleData;

		if ((sampleData != null) && (sampleData.length() == 0)) {
			dossierPartCacheModel.sampleData = null;
		}

		dossierPartCacheModel.required = getRequired();

		dossierPartCacheModel.fileTemplateNo = getFileTemplateNo();

		String fileTemplateNo = dossierPartCacheModel.fileTemplateNo;

		if ((fileTemplateNo != null) && (fileTemplateNo.length() == 0)) {
			dossierPartCacheModel.fileTemplateNo = null;
		}

		dossierPartCacheModel.eSign = getESign();

		dossierPartCacheModel.deliverableType = getDeliverableType();

		String deliverableType = dossierPartCacheModel.deliverableType;

		if ((deliverableType != null) && (deliverableType.length() == 0)) {
			dossierPartCacheModel.deliverableType = null;
		}

		dossierPartCacheModel.deliverableAction = getDeliverableAction();

		return dossierPartCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", dossierPartId=");
		sb.append(getDossierPartId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", templateNo=");
		sb.append(getTemplateNo());
		sb.append(", partNo=");
		sb.append(getPartNo());
		sb.append(", partName=");
		sb.append(getPartName());
		sb.append(", partTip=");
		sb.append(getPartTip());
		sb.append(", partType=");
		sb.append(getPartType());
		sb.append(", multiple=");
		sb.append(getMultiple());
		sb.append(", formScript=");
		sb.append(getFormScript());
		sb.append(", formReport=");
		sb.append(getFormReport());
		sb.append(", sampleData=");
		sb.append(getSampleData());
		sb.append(", required=");
		sb.append(getRequired());
		sb.append(", fileTemplateNo=");
		sb.append(getFileTemplateNo());
		sb.append(", eSign=");
		sb.append(getESign());
		sb.append(", deliverableType=");
		sb.append(getDeliverableType());
		sb.append(", deliverableAction=");
		sb.append(getDeliverableAction());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(70);

		sb.append("<model><model-name>");
		sb.append("org.opencps.dossiermgt.model.DossierPart");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierPartId</column-name><column-value><![CDATA[");
		sb.append(getDossierPartId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>templateNo</column-name><column-value><![CDATA[");
		sb.append(getTemplateNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>partNo</column-name><column-value><![CDATA[");
		sb.append(getPartNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>partName</column-name><column-value><![CDATA[");
		sb.append(getPartName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>partTip</column-name><column-value><![CDATA[");
		sb.append(getPartTip());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>partType</column-name><column-value><![CDATA[");
		sb.append(getPartType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>multiple</column-name><column-value><![CDATA[");
		sb.append(getMultiple());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>formScript</column-name><column-value><![CDATA[");
		sb.append(getFormScript());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>formReport</column-name><column-value><![CDATA[");
		sb.append(getFormReport());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sampleData</column-name><column-value><![CDATA[");
		sb.append(getSampleData());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>required</column-name><column-value><![CDATA[");
		sb.append(getRequired());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileTemplateNo</column-name><column-value><![CDATA[");
		sb.append(getFileTemplateNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eSign</column-name><column-value><![CDATA[");
		sb.append(getESign());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deliverableType</column-name><column-value><![CDATA[");
		sb.append(getDeliverableType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deliverableAction</column-name><column-value><![CDATA[");
		sb.append(getDeliverableAction());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = DossierPart.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			DossierPart.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _dossierPartId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _templateNo;
	private String _originalTemplateNo;
	private String _partNo;
	private String _originalPartNo;
	private String _partName;
	private String _partTip;
	private int _partType;
	private int _originalPartType;
	private boolean _setOriginalPartType;
	private boolean _multiple;
	private String _formScript;
	private String _formReport;
	private String _sampleData;
	private boolean _required;
	private String _fileTemplateNo;
	private String _originalFileTemplateNo;
	private boolean _eSign;
	private boolean _originalESign;
	private boolean _setOriginalESign;
	private String _deliverableType;
	private int _deliverableAction;
	private long _columnBitmask;
	private DossierPart _escapedModel;
}