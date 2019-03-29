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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import org.opencps.dossiermgt.model.RegistrationLog;
import org.opencps.dossiermgt.model.RegistrationLogModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the RegistrationLog service. Represents a row in the &quot;opencps_registrationlog&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link RegistrationLogModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RegistrationLogImpl}.
 * </p>
 *
 * @author huymq
 * @see RegistrationLogImpl
 * @see RegistrationLog
 * @see RegistrationLogModel
 * @generated
 */
@ProviderType
public class RegistrationLogModelImpl extends BaseModelImpl<RegistrationLog>
	implements RegistrationLogModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a registration log model instance should use the {@link RegistrationLog} interface instead.
	 */
	public static final String TABLE_NAME = "opencps_registrationlog";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "registrationLogId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "registrationId", Types.BIGINT },
			{ "author", Types.VARCHAR },
			{ "content", Types.VARCHAR },
			{ "payload", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("registrationLogId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("registrationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("author", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("content", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("payload", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table opencps_registrationlog (uuid_ VARCHAR(75) null,registrationLogId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,registrationId LONG,author VARCHAR(75) null,content VARCHAR(75) null,payload VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table opencps_registrationlog";
	public static final String ORDER_BY_JPQL = " ORDER BY registrationLog.createDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY opencps_registrationlog.createDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.org.opencps.dossiermgt.model.RegistrationLog"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.org.opencps.dossiermgt.model.RegistrationLog"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.opencps.dossiermgt.model.RegistrationLog"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long GROUPID_COLUMN_BITMASK = 2L;
	public static final long REGISTRATIONID_COLUMN_BITMASK = 4L;
	public static final long UUID_COLUMN_BITMASK = 8L;
	public static final long CREATEDATE_COLUMN_BITMASK = 16L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"lock.expiration.time.org.opencps.dossiermgt.model.RegistrationLog"));

	public RegistrationLogModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _registrationLogId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRegistrationLogId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _registrationLogId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return RegistrationLog.class;
	}

	@Override
	public String getModelClassName() {
		return RegistrationLog.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("registrationLogId", getRegistrationLogId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("registrationId", getRegistrationId());
		attributes.put("author", getAuthor());
		attributes.put("content", getContent());
		attributes.put("payload", getPayload());

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

		Long registrationLogId = (Long)attributes.get("registrationLogId");

		if (registrationLogId != null) {
			setRegistrationLogId(registrationLogId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long registrationId = (Long)attributes.get("registrationId");

		if (registrationId != null) {
			setRegistrationId(registrationId);
		}

		String author = (String)attributes.get("author");

		if (author != null) {
			setAuthor(author);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		String payload = (String)attributes.get("payload");

		if (payload != null) {
			setPayload(payload);
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
	public long getRegistrationLogId() {
		return _registrationLogId;
	}

	@Override
	public void setRegistrationLogId(long registrationLogId) {
		_registrationLogId = registrationLogId;
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
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

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
	public long getRegistrationId() {
		return _registrationId;
	}

	@Override
	public void setRegistrationId(long registrationId) {
		_columnBitmask |= REGISTRATIONID_COLUMN_BITMASK;

		if (!_setOriginalRegistrationId) {
			_setOriginalRegistrationId = true;

			_originalRegistrationId = _registrationId;
		}

		_registrationId = registrationId;
	}

	public long getOriginalRegistrationId() {
		return _originalRegistrationId;
	}

	@Override
	public String getAuthor() {
		if (_author == null) {
			return StringPool.BLANK;
		}
		else {
			return _author;
		}
	}

	@Override
	public void setAuthor(String author) {
		_author = author;
	}

	@Override
	public String getContent() {
		if (_content == null) {
			return StringPool.BLANK;
		}
		else {
			return _content;
		}
	}

	@Override
	public void setContent(String content) {
		_content = content;
	}

	@Override
	public String getPayload() {
		if (_payload == null) {
			return StringPool.BLANK;
		}
		else {
			return _payload;
		}
	}

	@Override
	public void setPayload(String payload) {
		_payload = payload;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				RegistrationLog.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			RegistrationLog.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public RegistrationLog toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (RegistrationLog)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		RegistrationLogImpl registrationLogImpl = new RegistrationLogImpl();

		registrationLogImpl.setUuid(getUuid());
		registrationLogImpl.setRegistrationLogId(getRegistrationLogId());
		registrationLogImpl.setCompanyId(getCompanyId());
		registrationLogImpl.setGroupId(getGroupId());
		registrationLogImpl.setUserId(getUserId());
		registrationLogImpl.setCreateDate(getCreateDate());
		registrationLogImpl.setModifiedDate(getModifiedDate());
		registrationLogImpl.setRegistrationId(getRegistrationId());
		registrationLogImpl.setAuthor(getAuthor());
		registrationLogImpl.setContent(getContent());
		registrationLogImpl.setPayload(getPayload());

		registrationLogImpl.resetOriginalValues();

		return registrationLogImpl;
	}

	@Override
	public int compareTo(RegistrationLog registrationLog) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				registrationLog.getCreateDate());

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

		if (!(obj instanceof RegistrationLog)) {
			return false;
		}

		RegistrationLog registrationLog = (RegistrationLog)obj;

		long primaryKey = registrationLog.getPrimaryKey();

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
		RegistrationLogModelImpl registrationLogModelImpl = this;

		registrationLogModelImpl._originalUuid = registrationLogModelImpl._uuid;

		registrationLogModelImpl._originalCompanyId = registrationLogModelImpl._companyId;

		registrationLogModelImpl._setOriginalCompanyId = false;

		registrationLogModelImpl._originalGroupId = registrationLogModelImpl._groupId;

		registrationLogModelImpl._setOriginalGroupId = false;

		registrationLogModelImpl._setModifiedDate = false;

		registrationLogModelImpl._originalRegistrationId = registrationLogModelImpl._registrationId;

		registrationLogModelImpl._setOriginalRegistrationId = false;

		registrationLogModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<RegistrationLog> toCacheModel() {
		RegistrationLogCacheModel registrationLogCacheModel = new RegistrationLogCacheModel();

		registrationLogCacheModel.uuid = getUuid();

		String uuid = registrationLogCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			registrationLogCacheModel.uuid = null;
		}

		registrationLogCacheModel.registrationLogId = getRegistrationLogId();

		registrationLogCacheModel.companyId = getCompanyId();

		registrationLogCacheModel.groupId = getGroupId();

		registrationLogCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			registrationLogCacheModel.createDate = createDate.getTime();
		}
		else {
			registrationLogCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			registrationLogCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			registrationLogCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		registrationLogCacheModel.registrationId = getRegistrationId();

		registrationLogCacheModel.author = getAuthor();

		String author = registrationLogCacheModel.author;

		if ((author != null) && (author.length() == 0)) {
			registrationLogCacheModel.author = null;
		}

		registrationLogCacheModel.content = getContent();

		String content = registrationLogCacheModel.content;

		if ((content != null) && (content.length() == 0)) {
			registrationLogCacheModel.content = null;
		}

		registrationLogCacheModel.payload = getPayload();

		String payload = registrationLogCacheModel.payload;

		if ((payload != null) && (payload.length() == 0)) {
			registrationLogCacheModel.payload = null;
		}

		return registrationLogCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", registrationLogId=");
		sb.append(getRegistrationLogId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", registrationId=");
		sb.append(getRegistrationId());
		sb.append(", author=");
		sb.append(getAuthor());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", payload=");
		sb.append(getPayload());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("org.opencps.dossiermgt.model.RegistrationLog");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>registrationLogId</column-name><column-value><![CDATA[");
		sb.append(getRegistrationLogId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
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
			"<column><column-name>registrationId</column-name><column-value><![CDATA[");
		sb.append(getRegistrationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>author</column-name><column-value><![CDATA[");
		sb.append(getAuthor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>payload</column-name><column-value><![CDATA[");
		sb.append(getPayload());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = RegistrationLog.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			RegistrationLog.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _registrationLogId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _registrationId;
	private long _originalRegistrationId;
	private boolean _setOriginalRegistrationId;
	private String _author;
	private String _content;
	private String _payload;
	private long _columnBitmask;
	private RegistrationLog _escapedModel;
}