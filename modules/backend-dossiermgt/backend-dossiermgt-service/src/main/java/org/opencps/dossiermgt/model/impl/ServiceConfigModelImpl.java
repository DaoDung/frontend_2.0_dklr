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

import org.opencps.dossiermgt.model.ServiceConfig;
import org.opencps.dossiermgt.model.ServiceConfigModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ServiceConfig service. Represents a row in the &quot;opencps_serviceconfig&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link ServiceConfigModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ServiceConfigImpl}.
 * </p>
 *
 * @author huymq
 * @see ServiceConfigImpl
 * @see ServiceConfig
 * @see ServiceConfigModel
 * @generated
 */
@ProviderType
public class ServiceConfigModelImpl extends BaseModelImpl<ServiceConfig>
	implements ServiceConfigModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a service config model instance should use the {@link ServiceConfig} interface instead.
	 */
	public static final String TABLE_NAME = "opencps_serviceconfig";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "serviceConfigId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "serviceInfoId", Types.BIGINT },
			{ "govAgencyCode", Types.VARCHAR },
			{ "govAgencyName", Types.VARCHAR },
			{ "serviceInstruction", Types.VARCHAR },
			{ "serviceLevel", Types.INTEGER },
			{ "serviceUrl", Types.VARCHAR },
			{ "forCitizen", Types.BOOLEAN },
			{ "forBusiness", Types.BOOLEAN },
			{ "postService", Types.BOOLEAN },
			{ "registration", Types.BOOLEAN }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("serviceConfigId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("serviceInfoId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("govAgencyCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("govAgencyName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("serviceInstruction", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("serviceLevel", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("serviceUrl", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("forCitizen", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("forBusiness", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("postService", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("registration", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE = "create table opencps_serviceconfig (uuid_ VARCHAR(75) null,serviceConfigId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,serviceInfoId LONG,govAgencyCode VARCHAR(75) null,govAgencyName VARCHAR(75) null,serviceInstruction VARCHAR(75) null,serviceLevel INTEGER,serviceUrl VARCHAR(75) null,forCitizen BOOLEAN,forBusiness BOOLEAN,postService BOOLEAN,registration BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table opencps_serviceconfig";
	public static final String ORDER_BY_JPQL = " ORDER BY serviceConfig.serviceConfigId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY opencps_serviceconfig.serviceConfigId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.org.opencps.dossiermgt.model.ServiceConfig"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.org.opencps.dossiermgt.model.ServiceConfig"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.opencps.dossiermgt.model.ServiceConfig"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long GOVAGENCYCODE_COLUMN_BITMASK = 2L;
	public static final long GROUPID_COLUMN_BITMASK = 4L;
	public static final long SERVICEINFOID_COLUMN_BITMASK = 8L;
	public static final long UUID_COLUMN_BITMASK = 16L;
	public static final long SERVICECONFIGID_COLUMN_BITMASK = 32L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"lock.expiration.time.org.opencps.dossiermgt.model.ServiceConfig"));

	public ServiceConfigModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _serviceConfigId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setServiceConfigId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _serviceConfigId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ServiceConfig.class;
	}

	@Override
	public String getModelClassName() {
		return ServiceConfig.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("serviceConfigId", getServiceConfigId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("serviceInfoId", getServiceInfoId());
		attributes.put("govAgencyCode", getGovAgencyCode());
		attributes.put("govAgencyName", getGovAgencyName());
		attributes.put("serviceInstruction", getServiceInstruction());
		attributes.put("serviceLevel", getServiceLevel());
		attributes.put("serviceUrl", getServiceUrl());
		attributes.put("forCitizen", getForCitizen());
		attributes.put("forBusiness", getForBusiness());
		attributes.put("postService", getPostService());
		attributes.put("registration", getRegistration());

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

		Long serviceConfigId = (Long)attributes.get("serviceConfigId");

		if (serviceConfigId != null) {
			setServiceConfigId(serviceConfigId);
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

		Long serviceInfoId = (Long)attributes.get("serviceInfoId");

		if (serviceInfoId != null) {
			setServiceInfoId(serviceInfoId);
		}

		String govAgencyCode = (String)attributes.get("govAgencyCode");

		if (govAgencyCode != null) {
			setGovAgencyCode(govAgencyCode);
		}

		String govAgencyName = (String)attributes.get("govAgencyName");

		if (govAgencyName != null) {
			setGovAgencyName(govAgencyName);
		}

		String serviceInstruction = (String)attributes.get("serviceInstruction");

		if (serviceInstruction != null) {
			setServiceInstruction(serviceInstruction);
		}

		Integer serviceLevel = (Integer)attributes.get("serviceLevel");

		if (serviceLevel != null) {
			setServiceLevel(serviceLevel);
		}

		String serviceUrl = (String)attributes.get("serviceUrl");

		if (serviceUrl != null) {
			setServiceUrl(serviceUrl);
		}

		Boolean forCitizen = (Boolean)attributes.get("forCitizen");

		if (forCitizen != null) {
			setForCitizen(forCitizen);
		}

		Boolean forBusiness = (Boolean)attributes.get("forBusiness");

		if (forBusiness != null) {
			setForBusiness(forBusiness);
		}

		Boolean postService = (Boolean)attributes.get("postService");

		if (postService != null) {
			setPostService(postService);
		}

		Boolean registration = (Boolean)attributes.get("registration");

		if (registration != null) {
			setRegistration(registration);
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
	public long getServiceConfigId() {
		return _serviceConfigId;
	}

	@Override
	public void setServiceConfigId(long serviceConfigId) {
		_serviceConfigId = serviceConfigId;
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
	public long getServiceInfoId() {
		return _serviceInfoId;
	}

	@Override
	public void setServiceInfoId(long serviceInfoId) {
		_columnBitmask |= SERVICEINFOID_COLUMN_BITMASK;

		if (!_setOriginalServiceInfoId) {
			_setOriginalServiceInfoId = true;

			_originalServiceInfoId = _serviceInfoId;
		}

		_serviceInfoId = serviceInfoId;
	}

	public long getOriginalServiceInfoId() {
		return _originalServiceInfoId;
	}

	@Override
	public String getGovAgencyCode() {
		if (_govAgencyCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _govAgencyCode;
		}
	}

	@Override
	public void setGovAgencyCode(String govAgencyCode) {
		_columnBitmask |= GOVAGENCYCODE_COLUMN_BITMASK;

		if (_originalGovAgencyCode == null) {
			_originalGovAgencyCode = _govAgencyCode;
		}

		_govAgencyCode = govAgencyCode;
	}

	public String getOriginalGovAgencyCode() {
		return GetterUtil.getString(_originalGovAgencyCode);
	}

	@Override
	public String getGovAgencyName() {
		if (_govAgencyName == null) {
			return StringPool.BLANK;
		}
		else {
			return _govAgencyName;
		}
	}

	@Override
	public void setGovAgencyName(String govAgencyName) {
		_govAgencyName = govAgencyName;
	}

	@Override
	public String getServiceInstruction() {
		if (_serviceInstruction == null) {
			return StringPool.BLANK;
		}
		else {
			return _serviceInstruction;
		}
	}

	@Override
	public void setServiceInstruction(String serviceInstruction) {
		_serviceInstruction = serviceInstruction;
	}

	@Override
	public int getServiceLevel() {
		return _serviceLevel;
	}

	@Override
	public void setServiceLevel(int serviceLevel) {
		_serviceLevel = serviceLevel;
	}

	@Override
	public String getServiceUrl() {
		if (_serviceUrl == null) {
			return StringPool.BLANK;
		}
		else {
			return _serviceUrl;
		}
	}

	@Override
	public void setServiceUrl(String serviceUrl) {
		_serviceUrl = serviceUrl;
	}

	@Override
	public boolean getForCitizen() {
		return _forCitizen;
	}

	@Override
	public boolean isForCitizen() {
		return _forCitizen;
	}

	@Override
	public void setForCitizen(boolean forCitizen) {
		_forCitizen = forCitizen;
	}

	@Override
	public boolean getForBusiness() {
		return _forBusiness;
	}

	@Override
	public boolean isForBusiness() {
		return _forBusiness;
	}

	@Override
	public void setForBusiness(boolean forBusiness) {
		_forBusiness = forBusiness;
	}

	@Override
	public boolean getPostService() {
		return _postService;
	}

	@Override
	public boolean isPostService() {
		return _postService;
	}

	@Override
	public void setPostService(boolean postService) {
		_postService = postService;
	}

	@Override
	public boolean getRegistration() {
		return _registration;
	}

	@Override
	public boolean isRegistration() {
		return _registration;
	}

	@Override
	public void setRegistration(boolean registration) {
		_registration = registration;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				ServiceConfig.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ServiceConfig.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ServiceConfig toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ServiceConfig)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ServiceConfigImpl serviceConfigImpl = new ServiceConfigImpl();

		serviceConfigImpl.setUuid(getUuid());
		serviceConfigImpl.setServiceConfigId(getServiceConfigId());
		serviceConfigImpl.setGroupId(getGroupId());
		serviceConfigImpl.setCompanyId(getCompanyId());
		serviceConfigImpl.setUserId(getUserId());
		serviceConfigImpl.setUserName(getUserName());
		serviceConfigImpl.setCreateDate(getCreateDate());
		serviceConfigImpl.setModifiedDate(getModifiedDate());
		serviceConfigImpl.setServiceInfoId(getServiceInfoId());
		serviceConfigImpl.setGovAgencyCode(getGovAgencyCode());
		serviceConfigImpl.setGovAgencyName(getGovAgencyName());
		serviceConfigImpl.setServiceInstruction(getServiceInstruction());
		serviceConfigImpl.setServiceLevel(getServiceLevel());
		serviceConfigImpl.setServiceUrl(getServiceUrl());
		serviceConfigImpl.setForCitizen(getForCitizen());
		serviceConfigImpl.setForBusiness(getForBusiness());
		serviceConfigImpl.setPostService(getPostService());
		serviceConfigImpl.setRegistration(getRegistration());

		serviceConfigImpl.resetOriginalValues();

		return serviceConfigImpl;
	}

	@Override
	public int compareTo(ServiceConfig serviceConfig) {
		long primaryKey = serviceConfig.getPrimaryKey();

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

		if (!(obj instanceof ServiceConfig)) {
			return false;
		}

		ServiceConfig serviceConfig = (ServiceConfig)obj;

		long primaryKey = serviceConfig.getPrimaryKey();

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
		ServiceConfigModelImpl serviceConfigModelImpl = this;

		serviceConfigModelImpl._originalUuid = serviceConfigModelImpl._uuid;

		serviceConfigModelImpl._originalGroupId = serviceConfigModelImpl._groupId;

		serviceConfigModelImpl._setOriginalGroupId = false;

		serviceConfigModelImpl._originalCompanyId = serviceConfigModelImpl._companyId;

		serviceConfigModelImpl._setOriginalCompanyId = false;

		serviceConfigModelImpl._setModifiedDate = false;

		serviceConfigModelImpl._originalServiceInfoId = serviceConfigModelImpl._serviceInfoId;

		serviceConfigModelImpl._setOriginalServiceInfoId = false;

		serviceConfigModelImpl._originalGovAgencyCode = serviceConfigModelImpl._govAgencyCode;

		serviceConfigModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ServiceConfig> toCacheModel() {
		ServiceConfigCacheModel serviceConfigCacheModel = new ServiceConfigCacheModel();

		serviceConfigCacheModel.uuid = getUuid();

		String uuid = serviceConfigCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			serviceConfigCacheModel.uuid = null;
		}

		serviceConfigCacheModel.serviceConfigId = getServiceConfigId();

		serviceConfigCacheModel.groupId = getGroupId();

		serviceConfigCacheModel.companyId = getCompanyId();

		serviceConfigCacheModel.userId = getUserId();

		serviceConfigCacheModel.userName = getUserName();

		String userName = serviceConfigCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			serviceConfigCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			serviceConfigCacheModel.createDate = createDate.getTime();
		}
		else {
			serviceConfigCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			serviceConfigCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			serviceConfigCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		serviceConfigCacheModel.serviceInfoId = getServiceInfoId();

		serviceConfigCacheModel.govAgencyCode = getGovAgencyCode();

		String govAgencyCode = serviceConfigCacheModel.govAgencyCode;

		if ((govAgencyCode != null) && (govAgencyCode.length() == 0)) {
			serviceConfigCacheModel.govAgencyCode = null;
		}

		serviceConfigCacheModel.govAgencyName = getGovAgencyName();

		String govAgencyName = serviceConfigCacheModel.govAgencyName;

		if ((govAgencyName != null) && (govAgencyName.length() == 0)) {
			serviceConfigCacheModel.govAgencyName = null;
		}

		serviceConfigCacheModel.serviceInstruction = getServiceInstruction();

		String serviceInstruction = serviceConfigCacheModel.serviceInstruction;

		if ((serviceInstruction != null) && (serviceInstruction.length() == 0)) {
			serviceConfigCacheModel.serviceInstruction = null;
		}

		serviceConfigCacheModel.serviceLevel = getServiceLevel();

		serviceConfigCacheModel.serviceUrl = getServiceUrl();

		String serviceUrl = serviceConfigCacheModel.serviceUrl;

		if ((serviceUrl != null) && (serviceUrl.length() == 0)) {
			serviceConfigCacheModel.serviceUrl = null;
		}

		serviceConfigCacheModel.forCitizen = getForCitizen();

		serviceConfigCacheModel.forBusiness = getForBusiness();

		serviceConfigCacheModel.postService = getPostService();

		serviceConfigCacheModel.registration = getRegistration();

		return serviceConfigCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", serviceConfigId=");
		sb.append(getServiceConfigId());
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
		sb.append(", serviceInfoId=");
		sb.append(getServiceInfoId());
		sb.append(", govAgencyCode=");
		sb.append(getGovAgencyCode());
		sb.append(", govAgencyName=");
		sb.append(getGovAgencyName());
		sb.append(", serviceInstruction=");
		sb.append(getServiceInstruction());
		sb.append(", serviceLevel=");
		sb.append(getServiceLevel());
		sb.append(", serviceUrl=");
		sb.append(getServiceUrl());
		sb.append(", forCitizen=");
		sb.append(getForCitizen());
		sb.append(", forBusiness=");
		sb.append(getForBusiness());
		sb.append(", postService=");
		sb.append(getPostService());
		sb.append(", registration=");
		sb.append(getRegistration());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("org.opencps.dossiermgt.model.ServiceConfig");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceConfigId</column-name><column-value><![CDATA[");
		sb.append(getServiceConfigId());
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
			"<column><column-name>serviceInfoId</column-name><column-value><![CDATA[");
		sb.append(getServiceInfoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>govAgencyCode</column-name><column-value><![CDATA[");
		sb.append(getGovAgencyCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>govAgencyName</column-name><column-value><![CDATA[");
		sb.append(getGovAgencyName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceInstruction</column-name><column-value><![CDATA[");
		sb.append(getServiceInstruction());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceLevel</column-name><column-value><![CDATA[");
		sb.append(getServiceLevel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceUrl</column-name><column-value><![CDATA[");
		sb.append(getServiceUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>forCitizen</column-name><column-value><![CDATA[");
		sb.append(getForCitizen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>forBusiness</column-name><column-value><![CDATA[");
		sb.append(getForBusiness());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>postService</column-name><column-value><![CDATA[");
		sb.append(getPostService());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>registration</column-name><column-value><![CDATA[");
		sb.append(getRegistration());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = ServiceConfig.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			ServiceConfig.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _serviceConfigId;
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
	private long _serviceInfoId;
	private long _originalServiceInfoId;
	private boolean _setOriginalServiceInfoId;
	private String _govAgencyCode;
	private String _originalGovAgencyCode;
	private String _govAgencyName;
	private String _serviceInstruction;
	private int _serviceLevel;
	private String _serviceUrl;
	private boolean _forCitizen;
	private boolean _forBusiness;
	private boolean _postService;
	private boolean _registration;
	private long _columnBitmask;
	private ServiceConfig _escapedModel;
}