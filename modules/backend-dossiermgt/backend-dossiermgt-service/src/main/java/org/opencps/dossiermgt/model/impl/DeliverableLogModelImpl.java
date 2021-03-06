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

import org.opencps.dossiermgt.model.DeliverableLog;
import org.opencps.dossiermgt.model.DeliverableLogModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the DeliverableLog service. Represents a row in the &quot;opencps_deliverablelog&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link DeliverableLogModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DeliverableLogImpl}.
 * </p>
 *
 * @author huymq
 * @see DeliverableLogImpl
 * @see DeliverableLog
 * @see DeliverableLogModel
 * @generated
 */
@ProviderType
public class DeliverableLogModelImpl extends BaseModelImpl<DeliverableLog>
	implements DeliverableLogModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a deliverable log model instance should use the {@link DeliverableLog} interface instead.
	 */
	public static final String TABLE_NAME = "opencps_deliverablelog";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "deliverableLogId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "deliverableId", Types.VARCHAR },
			{ "dossierUid", Types.VARCHAR },
			{ "author", Types.VARCHAR },
			{ "content", Types.VARCHAR },
			{ "deliverableAction", Types.INTEGER },
			{ "actionDate", Types.TIMESTAMP },
			{ "payload", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("deliverableLogId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("deliverableId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dossierUid", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("author", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("content", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("deliverableAction", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("actionDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("payload", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table opencps_deliverablelog (uuid_ VARCHAR(75) null,deliverableLogId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,deliverableId VARCHAR(75) null,dossierUid VARCHAR(75) null,author VARCHAR(75) null,content VARCHAR(75) null,deliverableAction INTEGER,actionDate DATE null,payload VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table opencps_deliverablelog";
	public static final String ORDER_BY_JPQL = " ORDER BY deliverableLog.deliverableLogId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY opencps_deliverablelog.deliverableLogId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.org.opencps.dossiermgt.model.DeliverableLog"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.org.opencps.dossiermgt.model.DeliverableLog"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.opencps.dossiermgt.model.DeliverableLog"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long GROUPID_COLUMN_BITMASK = 2L;
	public static final long UUID_COLUMN_BITMASK = 4L;
	public static final long DELIVERABLELOGID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"lock.expiration.time.org.opencps.dossiermgt.model.DeliverableLog"));

	public DeliverableLogModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _deliverableLogId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDeliverableLogId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _deliverableLogId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DeliverableLog.class;
	}

	@Override
	public String getModelClassName() {
		return DeliverableLog.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("deliverableLogId", getDeliverableLogId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("deliverableId", getDeliverableId());
		attributes.put("dossierUid", getDossierUid());
		attributes.put("author", getAuthor());
		attributes.put("content", getContent());
		attributes.put("deliverableAction", getDeliverableAction());
		attributes.put("actionDate", getActionDate());
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

		Long deliverableLogId = (Long)attributes.get("deliverableLogId");

		if (deliverableLogId != null) {
			setDeliverableLogId(deliverableLogId);
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

		String deliverableId = (String)attributes.get("deliverableId");

		if (deliverableId != null) {
			setDeliverableId(deliverableId);
		}

		String dossierUid = (String)attributes.get("dossierUid");

		if (dossierUid != null) {
			setDossierUid(dossierUid);
		}

		String author = (String)attributes.get("author");

		if (author != null) {
			setAuthor(author);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		Integer deliverableAction = (Integer)attributes.get("deliverableAction");

		if (deliverableAction != null) {
			setDeliverableAction(deliverableAction);
		}

		Date actionDate = (Date)attributes.get("actionDate");

		if (actionDate != null) {
			setActionDate(actionDate);
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
	public long getDeliverableLogId() {
		return _deliverableLogId;
	}

	@Override
	public void setDeliverableLogId(long deliverableLogId) {
		_deliverableLogId = deliverableLogId;
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
	public String getDeliverableId() {
		if (_deliverableId == null) {
			return StringPool.BLANK;
		}
		else {
			return _deliverableId;
		}
	}

	@Override
	public void setDeliverableId(String deliverableId) {
		_deliverableId = deliverableId;
	}

	@Override
	public String getDossierUid() {
		if (_dossierUid == null) {
			return StringPool.BLANK;
		}
		else {
			return _dossierUid;
		}
	}

	@Override
	public void setDossierUid(String dossierUid) {
		_dossierUid = dossierUid;
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
	public int getDeliverableAction() {
		return _deliverableAction;
	}

	@Override
	public void setDeliverableAction(int deliverableAction) {
		_deliverableAction = deliverableAction;
	}

	@Override
	public Date getActionDate() {
		return _actionDate;
	}

	@Override
	public void setActionDate(Date actionDate) {
		_actionDate = actionDate;
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
				DeliverableLog.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			DeliverableLog.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DeliverableLog toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (DeliverableLog)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DeliverableLogImpl deliverableLogImpl = new DeliverableLogImpl();

		deliverableLogImpl.setUuid(getUuid());
		deliverableLogImpl.setDeliverableLogId(getDeliverableLogId());
		deliverableLogImpl.setCompanyId(getCompanyId());
		deliverableLogImpl.setGroupId(getGroupId());
		deliverableLogImpl.setUserId(getUserId());
		deliverableLogImpl.setUserName(getUserName());
		deliverableLogImpl.setCreateDate(getCreateDate());
		deliverableLogImpl.setModifiedDate(getModifiedDate());
		deliverableLogImpl.setDeliverableId(getDeliverableId());
		deliverableLogImpl.setDossierUid(getDossierUid());
		deliverableLogImpl.setAuthor(getAuthor());
		deliverableLogImpl.setContent(getContent());
		deliverableLogImpl.setDeliverableAction(getDeliverableAction());
		deliverableLogImpl.setActionDate(getActionDate());
		deliverableLogImpl.setPayload(getPayload());

		deliverableLogImpl.resetOriginalValues();

		return deliverableLogImpl;
	}

	@Override
	public int compareTo(DeliverableLog deliverableLog) {
		long primaryKey = deliverableLog.getPrimaryKey();

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

		if (!(obj instanceof DeliverableLog)) {
			return false;
		}

		DeliverableLog deliverableLog = (DeliverableLog)obj;

		long primaryKey = deliverableLog.getPrimaryKey();

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
		DeliverableLogModelImpl deliverableLogModelImpl = this;

		deliverableLogModelImpl._originalUuid = deliverableLogModelImpl._uuid;

		deliverableLogModelImpl._originalCompanyId = deliverableLogModelImpl._companyId;

		deliverableLogModelImpl._setOriginalCompanyId = false;

		deliverableLogModelImpl._originalGroupId = deliverableLogModelImpl._groupId;

		deliverableLogModelImpl._setOriginalGroupId = false;

		deliverableLogModelImpl._setModifiedDate = false;

		deliverableLogModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DeliverableLog> toCacheModel() {
		DeliverableLogCacheModel deliverableLogCacheModel = new DeliverableLogCacheModel();

		deliverableLogCacheModel.uuid = getUuid();

		String uuid = deliverableLogCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			deliverableLogCacheModel.uuid = null;
		}

		deliverableLogCacheModel.deliverableLogId = getDeliverableLogId();

		deliverableLogCacheModel.companyId = getCompanyId();

		deliverableLogCacheModel.groupId = getGroupId();

		deliverableLogCacheModel.userId = getUserId();

		deliverableLogCacheModel.userName = getUserName();

		String userName = deliverableLogCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			deliverableLogCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			deliverableLogCacheModel.createDate = createDate.getTime();
		}
		else {
			deliverableLogCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			deliverableLogCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			deliverableLogCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		deliverableLogCacheModel.deliverableId = getDeliverableId();

		String deliverableId = deliverableLogCacheModel.deliverableId;

		if ((deliverableId != null) && (deliverableId.length() == 0)) {
			deliverableLogCacheModel.deliverableId = null;
		}

		deliverableLogCacheModel.dossierUid = getDossierUid();

		String dossierUid = deliverableLogCacheModel.dossierUid;

		if ((dossierUid != null) && (dossierUid.length() == 0)) {
			deliverableLogCacheModel.dossierUid = null;
		}

		deliverableLogCacheModel.author = getAuthor();

		String author = deliverableLogCacheModel.author;

		if ((author != null) && (author.length() == 0)) {
			deliverableLogCacheModel.author = null;
		}

		deliverableLogCacheModel.content = getContent();

		String content = deliverableLogCacheModel.content;

		if ((content != null) && (content.length() == 0)) {
			deliverableLogCacheModel.content = null;
		}

		deliverableLogCacheModel.deliverableAction = getDeliverableAction();

		Date actionDate = getActionDate();

		if (actionDate != null) {
			deliverableLogCacheModel.actionDate = actionDate.getTime();
		}
		else {
			deliverableLogCacheModel.actionDate = Long.MIN_VALUE;
		}

		deliverableLogCacheModel.payload = getPayload();

		String payload = deliverableLogCacheModel.payload;

		if ((payload != null) && (payload.length() == 0)) {
			deliverableLogCacheModel.payload = null;
		}

		return deliverableLogCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", deliverableLogId=");
		sb.append(getDeliverableLogId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", deliverableId=");
		sb.append(getDeliverableId());
		sb.append(", dossierUid=");
		sb.append(getDossierUid());
		sb.append(", author=");
		sb.append(getAuthor());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", deliverableAction=");
		sb.append(getDeliverableAction());
		sb.append(", actionDate=");
		sb.append(getActionDate());
		sb.append(", payload=");
		sb.append(getPayload());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("org.opencps.dossiermgt.model.DeliverableLog");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deliverableLogId</column-name><column-value><![CDATA[");
		sb.append(getDeliverableLogId());
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
			"<column><column-name>deliverableId</column-name><column-value><![CDATA[");
		sb.append(getDeliverableId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierUid</column-name><column-value><![CDATA[");
		sb.append(getDossierUid());
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
			"<column><column-name>deliverableAction</column-name><column-value><![CDATA[");
		sb.append(getDeliverableAction());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>actionDate</column-name><column-value><![CDATA[");
		sb.append(getActionDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>payload</column-name><column-value><![CDATA[");
		sb.append(getPayload());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = DeliverableLog.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			DeliverableLog.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _deliverableLogId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _deliverableId;
	private String _dossierUid;
	private String _author;
	private String _content;
	private int _deliverableAction;
	private Date _actionDate;
	private String _payload;
	private long _columnBitmask;
	private DeliverableLog _escapedModel;
}