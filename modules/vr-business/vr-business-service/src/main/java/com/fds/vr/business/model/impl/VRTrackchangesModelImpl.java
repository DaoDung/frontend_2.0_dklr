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

import com.fds.vr.business.model.VRTrackchanges;
import com.fds.vr.business.model.VRTrackchangesModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
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
 * The base model implementation for the VRTrackchanges service. Represents a row in the &quot;vr_trackchanges&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link VRTrackchangesModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VRTrackchangesImpl}.
 * </p>
 *
 * @author LamTV
 * @see VRTrackchangesImpl
 * @see VRTrackchanges
 * @see VRTrackchangesModel
 * @generated
 */
@ProviderType
public class VRTrackchangesModelImpl extends BaseModelImpl<VRTrackchanges>
	implements VRTrackchangesModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a vr trackchanges model instance should use the {@link VRTrackchanges} interface instead.
	 */
	public static final String TABLE_NAME = "vr_trackchanges";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", Types.BIGINT },
			{ "applicantCode", Types.VARCHAR },
			{ "productionPlantCode", Types.VARCHAR },
			{ "contentType", Types.VARCHAR },
			{ "contentFileTemplate", Types.VARCHAR },
			{ "previousContentFileEntryId", Types.BIGINT },
			{ "currentContentFileEntryId", Types.BIGINT },
			{ "nextContentFileEntryId", Types.BIGINT },
			{ "dossierId", Types.BIGINT },
			{ "dossierIdCTN", Types.VARCHAR },
			{ "dossierNo", Types.VARCHAR },
			{ "modifyUserId", Types.BIGINT },
			{ "createdDate", Types.TIMESTAMP },
			{ "modifyDate", Types.TIMESTAMP },
			{ "syncDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("applicantCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("productionPlantCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("contentType", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("contentFileTemplate", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("previousContentFileEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("currentContentFileEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("nextContentFileEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("dossierId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("dossierIdCTN", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dossierNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("modifyUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createdDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifyDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("syncDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table vr_trackchanges (id LONG not null primary key,applicantCode VARCHAR(75) null,productionPlantCode VARCHAR(75) null,contentType VARCHAR(75) null,contentFileTemplate VARCHAR(75) null,previousContentFileEntryId LONG,currentContentFileEntryId LONG,nextContentFileEntryId LONG,dossierId LONG,dossierIdCTN VARCHAR(75) null,dossierNo VARCHAR(75) null,modifyUserId LONG,createdDate DATE null,modifyDate DATE null,syncDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table vr_trackchanges";
	public static final String ORDER_BY_JPQL = " ORDER BY vrTrackchanges.modifyDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY vr_trackchanges.modifyDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.fds.vr.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.fds.vr.business.model.VRTrackchanges"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.fds.vr.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.fds.vr.business.model.VRTrackchanges"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.fds.vr.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.fds.vr.business.model.VRTrackchanges"),
			true);
	public static final long APPLICANTCODE_COLUMN_BITMASK = 1L;
	public static final long CONTENTFILETEMPLATE_COLUMN_BITMASK = 2L;
	public static final long CONTENTTYPE_COLUMN_BITMASK = 4L;
	public static final long DOSSIERID_COLUMN_BITMASK = 8L;
	public static final long DOSSIERIDCTN_COLUMN_BITMASK = 16L;
	public static final long PRODUCTIONPLANTCODE_COLUMN_BITMASK = 32L;
	public static final long MODIFYDATE_COLUMN_BITMASK = 64L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.fds.vr.service.util.ServiceProps.get(
				"lock.expiration.time.com.fds.vr.business.model.VRTrackchanges"));

	public VRTrackchangesModelImpl() {
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
		return VRTrackchanges.class;
	}

	@Override
	public String getModelClassName() {
		return VRTrackchanges.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("applicantCode", getApplicantCode());
		attributes.put("productionPlantCode", getProductionPlantCode());
		attributes.put("contentType", getContentType());
		attributes.put("contentFileTemplate", getContentFileTemplate());
		attributes.put("previousContentFileEntryId",
			getPreviousContentFileEntryId());
		attributes.put("currentContentFileEntryId",
			getCurrentContentFileEntryId());
		attributes.put("nextContentFileEntryId", getNextContentFileEntryId());
		attributes.put("dossierId", getDossierId());
		attributes.put("dossierIdCTN", getDossierIdCTN());
		attributes.put("dossierNo", getDossierNo());
		attributes.put("modifyUserId", getModifyUserId());
		attributes.put("createdDate", getCreatedDate());
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

		String applicantCode = (String)attributes.get("applicantCode");

		if (applicantCode != null) {
			setApplicantCode(applicantCode);
		}

		String productionPlantCode = (String)attributes.get(
				"productionPlantCode");

		if (productionPlantCode != null) {
			setProductionPlantCode(productionPlantCode);
		}

		String contentType = (String)attributes.get("contentType");

		if (contentType != null) {
			setContentType(contentType);
		}

		String contentFileTemplate = (String)attributes.get(
				"contentFileTemplate");

		if (contentFileTemplate != null) {
			setContentFileTemplate(contentFileTemplate);
		}

		Long previousContentFileEntryId = (Long)attributes.get(
				"previousContentFileEntryId");

		if (previousContentFileEntryId != null) {
			setPreviousContentFileEntryId(previousContentFileEntryId);
		}

		Long currentContentFileEntryId = (Long)attributes.get(
				"currentContentFileEntryId");

		if (currentContentFileEntryId != null) {
			setCurrentContentFileEntryId(currentContentFileEntryId);
		}

		Long nextContentFileEntryId = (Long)attributes.get(
				"nextContentFileEntryId");

		if (nextContentFileEntryId != null) {
			setNextContentFileEntryId(nextContentFileEntryId);
		}

		Long dossierId = (Long)attributes.get("dossierId");

		if (dossierId != null) {
			setDossierId(dossierId);
		}

		String dossierIdCTN = (String)attributes.get("dossierIdCTN");

		if (dossierIdCTN != null) {
			setDossierIdCTN(dossierIdCTN);
		}

		String dossierNo = (String)attributes.get("dossierNo");

		if (dossierNo != null) {
			setDossierNo(dossierNo);
		}

		Long modifyUserId = (Long)attributes.get("modifyUserId");

		if (modifyUserId != null) {
			setModifyUserId(modifyUserId);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
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
	public String getApplicantCode() {
		if (_applicantCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _applicantCode;
		}
	}

	@Override
	public void setApplicantCode(String applicantCode) {
		_columnBitmask |= APPLICANTCODE_COLUMN_BITMASK;

		if (_originalApplicantCode == null) {
			_originalApplicantCode = _applicantCode;
		}

		_applicantCode = applicantCode;
	}

	public String getOriginalApplicantCode() {
		return GetterUtil.getString(_originalApplicantCode);
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
		_columnBitmask |= PRODUCTIONPLANTCODE_COLUMN_BITMASK;

		if (_originalProductionPlantCode == null) {
			_originalProductionPlantCode = _productionPlantCode;
		}

		_productionPlantCode = productionPlantCode;
	}

	public String getOriginalProductionPlantCode() {
		return GetterUtil.getString(_originalProductionPlantCode);
	}

	@Override
	public String getContentType() {
		if (_contentType == null) {
			return StringPool.BLANK;
		}
		else {
			return _contentType;
		}
	}

	@Override
	public void setContentType(String contentType) {
		_columnBitmask |= CONTENTTYPE_COLUMN_BITMASK;

		if (_originalContentType == null) {
			_originalContentType = _contentType;
		}

		_contentType = contentType;
	}

	public String getOriginalContentType() {
		return GetterUtil.getString(_originalContentType);
	}

	@Override
	public String getContentFileTemplate() {
		if (_contentFileTemplate == null) {
			return StringPool.BLANK;
		}
		else {
			return _contentFileTemplate;
		}
	}

	@Override
	public void setContentFileTemplate(String contentFileTemplate) {
		_columnBitmask |= CONTENTFILETEMPLATE_COLUMN_BITMASK;

		if (_originalContentFileTemplate == null) {
			_originalContentFileTemplate = _contentFileTemplate;
		}

		_contentFileTemplate = contentFileTemplate;
	}

	public String getOriginalContentFileTemplate() {
		return GetterUtil.getString(_originalContentFileTemplate);
	}

	@Override
	public long getPreviousContentFileEntryId() {
		return _previousContentFileEntryId;
	}

	@Override
	public void setPreviousContentFileEntryId(long previousContentFileEntryId) {
		_previousContentFileEntryId = previousContentFileEntryId;
	}

	@Override
	public long getCurrentContentFileEntryId() {
		return _currentContentFileEntryId;
	}

	@Override
	public void setCurrentContentFileEntryId(long currentContentFileEntryId) {
		_currentContentFileEntryId = currentContentFileEntryId;
	}

	@Override
	public long getNextContentFileEntryId() {
		return _nextContentFileEntryId;
	}

	@Override
	public void setNextContentFileEntryId(long nextContentFileEntryId) {
		_nextContentFileEntryId = nextContentFileEntryId;
	}

	@Override
	public long getDossierId() {
		return _dossierId;
	}

	@Override
	public void setDossierId(long dossierId) {
		_columnBitmask |= DOSSIERID_COLUMN_BITMASK;

		if (!_setOriginalDossierId) {
			_setOriginalDossierId = true;

			_originalDossierId = _dossierId;
		}

		_dossierId = dossierId;
	}

	public long getOriginalDossierId() {
		return _originalDossierId;
	}

	@Override
	public String getDossierIdCTN() {
		if (_dossierIdCTN == null) {
			return StringPool.BLANK;
		}
		else {
			return _dossierIdCTN;
		}
	}

	@Override
	public void setDossierIdCTN(String dossierIdCTN) {
		_columnBitmask |= DOSSIERIDCTN_COLUMN_BITMASK;

		if (_originalDossierIdCTN == null) {
			_originalDossierIdCTN = _dossierIdCTN;
		}

		_dossierIdCTN = dossierIdCTN;
	}

	public String getOriginalDossierIdCTN() {
		return GetterUtil.getString(_originalDossierIdCTN);
	}

	@Override
	public String getDossierNo() {
		if (_dossierNo == null) {
			return StringPool.BLANK;
		}
		else {
			return _dossierNo;
		}
	}

	@Override
	public void setDossierNo(String dossierNo) {
		_dossierNo = dossierNo;
	}

	@Override
	public long getModifyUserId() {
		return _modifyUserId;
	}

	@Override
	public void setModifyUserId(long modifyUserId) {
		_modifyUserId = modifyUserId;
	}

	@Override
	public String getModifyUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getModifyUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setModifyUserUuid(String modifyUserUuid) {
	}

	@Override
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
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
			VRTrackchanges.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public VRTrackchanges toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (VRTrackchanges)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		VRTrackchangesImpl vrTrackchangesImpl = new VRTrackchangesImpl();

		vrTrackchangesImpl.setId(getId());
		vrTrackchangesImpl.setApplicantCode(getApplicantCode());
		vrTrackchangesImpl.setProductionPlantCode(getProductionPlantCode());
		vrTrackchangesImpl.setContentType(getContentType());
		vrTrackchangesImpl.setContentFileTemplate(getContentFileTemplate());
		vrTrackchangesImpl.setPreviousContentFileEntryId(getPreviousContentFileEntryId());
		vrTrackchangesImpl.setCurrentContentFileEntryId(getCurrentContentFileEntryId());
		vrTrackchangesImpl.setNextContentFileEntryId(getNextContentFileEntryId());
		vrTrackchangesImpl.setDossierId(getDossierId());
		vrTrackchangesImpl.setDossierIdCTN(getDossierIdCTN());
		vrTrackchangesImpl.setDossierNo(getDossierNo());
		vrTrackchangesImpl.setModifyUserId(getModifyUserId());
		vrTrackchangesImpl.setCreatedDate(getCreatedDate());
		vrTrackchangesImpl.setModifyDate(getModifyDate());
		vrTrackchangesImpl.setSyncDate(getSyncDate());

		vrTrackchangesImpl.resetOriginalValues();

		return vrTrackchangesImpl;
	}

	@Override
	public int compareTo(VRTrackchanges vrTrackchanges) {
		int value = 0;

		value = DateUtil.compareTo(getModifyDate(),
				vrTrackchanges.getModifyDate());

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

		if (!(obj instanceof VRTrackchanges)) {
			return false;
		}

		VRTrackchanges vrTrackchanges = (VRTrackchanges)obj;

		long primaryKey = vrTrackchanges.getPrimaryKey();

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
		VRTrackchangesModelImpl vrTrackchangesModelImpl = this;

		vrTrackchangesModelImpl._originalApplicantCode = vrTrackchangesModelImpl._applicantCode;

		vrTrackchangesModelImpl._originalProductionPlantCode = vrTrackchangesModelImpl._productionPlantCode;

		vrTrackchangesModelImpl._originalContentType = vrTrackchangesModelImpl._contentType;

		vrTrackchangesModelImpl._originalContentFileTemplate = vrTrackchangesModelImpl._contentFileTemplate;

		vrTrackchangesModelImpl._originalDossierId = vrTrackchangesModelImpl._dossierId;

		vrTrackchangesModelImpl._setOriginalDossierId = false;

		vrTrackchangesModelImpl._originalDossierIdCTN = vrTrackchangesModelImpl._dossierIdCTN;

		vrTrackchangesModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<VRTrackchanges> toCacheModel() {
		VRTrackchangesCacheModel vrTrackchangesCacheModel = new VRTrackchangesCacheModel();

		vrTrackchangesCacheModel.id = getId();

		vrTrackchangesCacheModel.applicantCode = getApplicantCode();

		String applicantCode = vrTrackchangesCacheModel.applicantCode;

		if ((applicantCode != null) && (applicantCode.length() == 0)) {
			vrTrackchangesCacheModel.applicantCode = null;
		}

		vrTrackchangesCacheModel.productionPlantCode = getProductionPlantCode();

		String productionPlantCode = vrTrackchangesCacheModel.productionPlantCode;

		if ((productionPlantCode != null) &&
				(productionPlantCode.length() == 0)) {
			vrTrackchangesCacheModel.productionPlantCode = null;
		}

		vrTrackchangesCacheModel.contentType = getContentType();

		String contentType = vrTrackchangesCacheModel.contentType;

		if ((contentType != null) && (contentType.length() == 0)) {
			vrTrackchangesCacheModel.contentType = null;
		}

		vrTrackchangesCacheModel.contentFileTemplate = getContentFileTemplate();

		String contentFileTemplate = vrTrackchangesCacheModel.contentFileTemplate;

		if ((contentFileTemplate != null) &&
				(contentFileTemplate.length() == 0)) {
			vrTrackchangesCacheModel.contentFileTemplate = null;
		}

		vrTrackchangesCacheModel.previousContentFileEntryId = getPreviousContentFileEntryId();

		vrTrackchangesCacheModel.currentContentFileEntryId = getCurrentContentFileEntryId();

		vrTrackchangesCacheModel.nextContentFileEntryId = getNextContentFileEntryId();

		vrTrackchangesCacheModel.dossierId = getDossierId();

		vrTrackchangesCacheModel.dossierIdCTN = getDossierIdCTN();

		String dossierIdCTN = vrTrackchangesCacheModel.dossierIdCTN;

		if ((dossierIdCTN != null) && (dossierIdCTN.length() == 0)) {
			vrTrackchangesCacheModel.dossierIdCTN = null;
		}

		vrTrackchangesCacheModel.dossierNo = getDossierNo();

		String dossierNo = vrTrackchangesCacheModel.dossierNo;

		if ((dossierNo != null) && (dossierNo.length() == 0)) {
			vrTrackchangesCacheModel.dossierNo = null;
		}

		vrTrackchangesCacheModel.modifyUserId = getModifyUserId();

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			vrTrackchangesCacheModel.createdDate = createdDate.getTime();
		}
		else {
			vrTrackchangesCacheModel.createdDate = Long.MIN_VALUE;
		}

		Date modifyDate = getModifyDate();

		if (modifyDate != null) {
			vrTrackchangesCacheModel.modifyDate = modifyDate.getTime();
		}
		else {
			vrTrackchangesCacheModel.modifyDate = Long.MIN_VALUE;
		}

		Date syncDate = getSyncDate();

		if (syncDate != null) {
			vrTrackchangesCacheModel.syncDate = syncDate.getTime();
		}
		else {
			vrTrackchangesCacheModel.syncDate = Long.MIN_VALUE;
		}

		return vrTrackchangesCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", applicantCode=");
		sb.append(getApplicantCode());
		sb.append(", productionPlantCode=");
		sb.append(getProductionPlantCode());
		sb.append(", contentType=");
		sb.append(getContentType());
		sb.append(", contentFileTemplate=");
		sb.append(getContentFileTemplate());
		sb.append(", previousContentFileEntryId=");
		sb.append(getPreviousContentFileEntryId());
		sb.append(", currentContentFileEntryId=");
		sb.append(getCurrentContentFileEntryId());
		sb.append(", nextContentFileEntryId=");
		sb.append(getNextContentFileEntryId());
		sb.append(", dossierId=");
		sb.append(getDossierId());
		sb.append(", dossierIdCTN=");
		sb.append(getDossierIdCTN());
		sb.append(", dossierNo=");
		sb.append(getDossierNo());
		sb.append(", modifyUserId=");
		sb.append(getModifyUserId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifyDate=");
		sb.append(getModifyDate());
		sb.append(", syncDate=");
		sb.append(getSyncDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("com.fds.vr.business.model.VRTrackchanges");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicantCode</column-name><column-value><![CDATA[");
		sb.append(getApplicantCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productionPlantCode</column-name><column-value><![CDATA[");
		sb.append(getProductionPlantCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contentType</column-name><column-value><![CDATA[");
		sb.append(getContentType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contentFileTemplate</column-name><column-value><![CDATA[");
		sb.append(getContentFileTemplate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>previousContentFileEntryId</column-name><column-value><![CDATA[");
		sb.append(getPreviousContentFileEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentContentFileEntryId</column-name><column-value><![CDATA[");
		sb.append(getCurrentContentFileEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nextContentFileEntryId</column-name><column-value><![CDATA[");
		sb.append(getNextContentFileEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierId</column-name><column-value><![CDATA[");
		sb.append(getDossierId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierIdCTN</column-name><column-value><![CDATA[");
		sb.append(getDossierIdCTN());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierNo</column-name><column-value><![CDATA[");
		sb.append(getDossierNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifyUserId</column-name><column-value><![CDATA[");
		sb.append(getModifyUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
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

	private static final ClassLoader _classLoader = VRTrackchanges.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			VRTrackchanges.class
		};
	private long _id;
	private String _applicantCode;
	private String _originalApplicantCode;
	private String _productionPlantCode;
	private String _originalProductionPlantCode;
	private String _contentType;
	private String _originalContentType;
	private String _contentFileTemplate;
	private String _originalContentFileTemplate;
	private long _previousContentFileEntryId;
	private long _currentContentFileEntryId;
	private long _nextContentFileEntryId;
	private long _dossierId;
	private long _originalDossierId;
	private boolean _setOriginalDossierId;
	private String _dossierIdCTN;
	private String _originalDossierIdCTN;
	private String _dossierNo;
	private long _modifyUserId;
	private Date _createdDate;
	private Date _modifyDate;
	private Date _syncDate;
	private long _columnBitmask;
	private VRTrackchanges _escapedModel;
}