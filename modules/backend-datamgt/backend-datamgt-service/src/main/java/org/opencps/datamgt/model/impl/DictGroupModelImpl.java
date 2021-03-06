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

package org.opencps.datamgt.model.impl;

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

import org.opencps.datamgt.model.DictGroup;
import org.opencps.datamgt.model.DictGroupModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the DictGroup service. Represents a row in the &quot;opencps_dictgroup&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link DictGroupModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DictGroupImpl}.
 * </p>
 *
 * @author khoavu
 * @see DictGroupImpl
 * @see DictGroup
 * @see DictGroupModel
 * @generated
 */
@ProviderType
public class DictGroupModelImpl extends BaseModelImpl<DictGroup>
	implements DictGroupModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dict group model instance should use the {@link DictGroup} interface instead.
	 */
	public static final String TABLE_NAME = "opencps_dictgroup";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "dictGroupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "dictCollectionId", Types.BIGINT },
			{ "groupCode", Types.VARCHAR },
			{ "groupName", Types.VARCHAR },
			{ "groupNameEN", Types.VARCHAR },
			{ "groupDescription", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dictGroupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("dictCollectionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("groupName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("groupNameEN", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("groupDescription", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table opencps_dictgroup (uuid_ VARCHAR(75) null,dictGroupId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,dictCollectionId LONG,groupCode VARCHAR(75) null,groupName VARCHAR(75) null,groupNameEN VARCHAR(75) null,groupDescription VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table opencps_dictgroup";
	public static final String ORDER_BY_JPQL = " ORDER BY dictGroup.dictGroupId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY opencps_dictgroup.dictGroupId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.datamgt.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.org.opencps.datamgt.model.DictGroup"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.datamgt.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.org.opencps.datamgt.model.DictGroup"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(org.opencps.backend.datamgt.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.opencps.datamgt.model.DictGroup"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long DICTCOLLECTIONID_COLUMN_BITMASK = 2L;
	public static final long GROUPCODE_COLUMN_BITMASK = 4L;
	public static final long GROUPID_COLUMN_BITMASK = 8L;
	public static final long MODIFIEDDATE_COLUMN_BITMASK = 16L;
	public static final long UUID_COLUMN_BITMASK = 32L;
	public static final long DICTGROUPID_COLUMN_BITMASK = 64L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(org.opencps.backend.datamgt.service.util.ServiceProps.get(
				"lock.expiration.time.org.opencps.datamgt.model.DictGroup"));

	public DictGroupModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _dictGroupId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDictGroupId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dictGroupId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DictGroup.class;
	}

	@Override
	public String getModelClassName() {
		return DictGroup.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("dictGroupId", getDictGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dictCollectionId", getDictCollectionId());
		attributes.put("groupCode", getGroupCode());
		attributes.put("groupName", getGroupName());
		attributes.put("groupNameEN", getGroupNameEN());
		attributes.put("groupDescription", getGroupDescription());

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

		Long dictGroupId = (Long)attributes.get("dictGroupId");

		if (dictGroupId != null) {
			setDictGroupId(dictGroupId);
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

		Long dictCollectionId = (Long)attributes.get("dictCollectionId");

		if (dictCollectionId != null) {
			setDictCollectionId(dictCollectionId);
		}

		String groupCode = (String)attributes.get("groupCode");

		if (groupCode != null) {
			setGroupCode(groupCode);
		}

		String groupName = (String)attributes.get("groupName");

		if (groupName != null) {
			setGroupName(groupName);
		}

		String groupNameEN = (String)attributes.get("groupNameEN");

		if (groupNameEN != null) {
			setGroupNameEN(groupNameEN);
		}

		String groupDescription = (String)attributes.get("groupDescription");

		if (groupDescription != null) {
			setGroupDescription(groupDescription);
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
	public long getDictGroupId() {
		return _dictGroupId;
	}

	@Override
	public void setDictGroupId(long dictGroupId) {
		_columnBitmask = -1L;

		_dictGroupId = dictGroupId;
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

		_columnBitmask |= MODIFIEDDATE_COLUMN_BITMASK;

		if (_originalModifiedDate == null) {
			_originalModifiedDate = _modifiedDate;
		}

		_modifiedDate = modifiedDate;
	}

	public Date getOriginalModifiedDate() {
		return _originalModifiedDate;
	}

	@Override
	public long getDictCollectionId() {
		return _dictCollectionId;
	}

	@Override
	public void setDictCollectionId(long dictCollectionId) {
		_columnBitmask |= DICTCOLLECTIONID_COLUMN_BITMASK;

		if (!_setOriginalDictCollectionId) {
			_setOriginalDictCollectionId = true;

			_originalDictCollectionId = _dictCollectionId;
		}

		_dictCollectionId = dictCollectionId;
	}

	public long getOriginalDictCollectionId() {
		return _originalDictCollectionId;
	}

	@Override
	public String getGroupCode() {
		if (_groupCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _groupCode;
		}
	}

	@Override
	public void setGroupCode(String groupCode) {
		_columnBitmask |= GROUPCODE_COLUMN_BITMASK;

		if (_originalGroupCode == null) {
			_originalGroupCode = _groupCode;
		}

		_groupCode = groupCode;
	}

	public String getOriginalGroupCode() {
		return GetterUtil.getString(_originalGroupCode);
	}

	@Override
	public String getGroupName() {
		if (_groupName == null) {
			return StringPool.BLANK;
		}
		else {
			return _groupName;
		}
	}

	@Override
	public void setGroupName(String groupName) {
		_groupName = groupName;
	}

	@Override
	public String getGroupNameEN() {
		if (_groupNameEN == null) {
			return StringPool.BLANK;
		}
		else {
			return _groupNameEN;
		}
	}

	@Override
	public void setGroupNameEN(String groupNameEN) {
		_groupNameEN = groupNameEN;
	}

	@Override
	public String getGroupDescription() {
		if (_groupDescription == null) {
			return StringPool.BLANK;
		}
		else {
			return _groupDescription;
		}
	}

	@Override
	public void setGroupDescription(String groupDescription) {
		_groupDescription = groupDescription;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				DictGroup.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			DictGroup.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DictGroup toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (DictGroup)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DictGroupImpl dictGroupImpl = new DictGroupImpl();

		dictGroupImpl.setUuid(getUuid());
		dictGroupImpl.setDictGroupId(getDictGroupId());
		dictGroupImpl.setCompanyId(getCompanyId());
		dictGroupImpl.setGroupId(getGroupId());
		dictGroupImpl.setUserId(getUserId());
		dictGroupImpl.setUserName(getUserName());
		dictGroupImpl.setCreateDate(getCreateDate());
		dictGroupImpl.setModifiedDate(getModifiedDate());
		dictGroupImpl.setDictCollectionId(getDictCollectionId());
		dictGroupImpl.setGroupCode(getGroupCode());
		dictGroupImpl.setGroupName(getGroupName());
		dictGroupImpl.setGroupNameEN(getGroupNameEN());
		dictGroupImpl.setGroupDescription(getGroupDescription());

		dictGroupImpl.resetOriginalValues();

		return dictGroupImpl;
	}

	@Override
	public int compareTo(DictGroup dictGroup) {
		int value = 0;

		if (getDictGroupId() < dictGroup.getDictGroupId()) {
			value = -1;
		}
		else if (getDictGroupId() > dictGroup.getDictGroupId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof DictGroup)) {
			return false;
		}

		DictGroup dictGroup = (DictGroup)obj;

		long primaryKey = dictGroup.getPrimaryKey();

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
		DictGroupModelImpl dictGroupModelImpl = this;

		dictGroupModelImpl._originalUuid = dictGroupModelImpl._uuid;

		dictGroupModelImpl._originalCompanyId = dictGroupModelImpl._companyId;

		dictGroupModelImpl._setOriginalCompanyId = false;

		dictGroupModelImpl._originalGroupId = dictGroupModelImpl._groupId;

		dictGroupModelImpl._setOriginalGroupId = false;

		dictGroupModelImpl._originalModifiedDate = dictGroupModelImpl._modifiedDate;

		dictGroupModelImpl._setModifiedDate = false;

		dictGroupModelImpl._originalDictCollectionId = dictGroupModelImpl._dictCollectionId;

		dictGroupModelImpl._setOriginalDictCollectionId = false;

		dictGroupModelImpl._originalGroupCode = dictGroupModelImpl._groupCode;

		dictGroupModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DictGroup> toCacheModel() {
		DictGroupCacheModel dictGroupCacheModel = new DictGroupCacheModel();

		dictGroupCacheModel.uuid = getUuid();

		String uuid = dictGroupCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			dictGroupCacheModel.uuid = null;
		}

		dictGroupCacheModel.dictGroupId = getDictGroupId();

		dictGroupCacheModel.companyId = getCompanyId();

		dictGroupCacheModel.groupId = getGroupId();

		dictGroupCacheModel.userId = getUserId();

		dictGroupCacheModel.userName = getUserName();

		String userName = dictGroupCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			dictGroupCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			dictGroupCacheModel.createDate = createDate.getTime();
		}
		else {
			dictGroupCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			dictGroupCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			dictGroupCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		dictGroupCacheModel.dictCollectionId = getDictCollectionId();

		dictGroupCacheModel.groupCode = getGroupCode();

		String groupCode = dictGroupCacheModel.groupCode;

		if ((groupCode != null) && (groupCode.length() == 0)) {
			dictGroupCacheModel.groupCode = null;
		}

		dictGroupCacheModel.groupName = getGroupName();

		String groupName = dictGroupCacheModel.groupName;

		if ((groupName != null) && (groupName.length() == 0)) {
			dictGroupCacheModel.groupName = null;
		}

		dictGroupCacheModel.groupNameEN = getGroupNameEN();

		String groupNameEN = dictGroupCacheModel.groupNameEN;

		if ((groupNameEN != null) && (groupNameEN.length() == 0)) {
			dictGroupCacheModel.groupNameEN = null;
		}

		dictGroupCacheModel.groupDescription = getGroupDescription();

		String groupDescription = dictGroupCacheModel.groupDescription;

		if ((groupDescription != null) && (groupDescription.length() == 0)) {
			dictGroupCacheModel.groupDescription = null;
		}

		return dictGroupCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", dictGroupId=");
		sb.append(getDictGroupId());
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
		sb.append(", dictCollectionId=");
		sb.append(getDictCollectionId());
		sb.append(", groupCode=");
		sb.append(getGroupCode());
		sb.append(", groupName=");
		sb.append(getGroupName());
		sb.append(", groupNameEN=");
		sb.append(getGroupNameEN());
		sb.append(", groupDescription=");
		sb.append(getGroupDescription());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("org.opencps.datamgt.model.DictGroup");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dictGroupId</column-name><column-value><![CDATA[");
		sb.append(getDictGroupId());
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
			"<column><column-name>dictCollectionId</column-name><column-value><![CDATA[");
		sb.append(getDictCollectionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupCode</column-name><column-value><![CDATA[");
		sb.append(getGroupCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupName</column-name><column-value><![CDATA[");
		sb.append(getGroupName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupNameEN</column-name><column-value><![CDATA[");
		sb.append(getGroupNameEN());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupDescription</column-name><column-value><![CDATA[");
		sb.append(getGroupDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = DictGroup.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			DictGroup.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _dictGroupId;
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
	private Date _originalModifiedDate;
	private boolean _setModifiedDate;
	private long _dictCollectionId;
	private long _originalDictCollectionId;
	private boolean _setOriginalDictCollectionId;
	private String _groupCode;
	private String _originalGroupCode;
	private String _groupName;
	private String _groupNameEN;
	private String _groupDescription;
	private long _columnBitmask;
	private DictGroup _escapedModel;
}