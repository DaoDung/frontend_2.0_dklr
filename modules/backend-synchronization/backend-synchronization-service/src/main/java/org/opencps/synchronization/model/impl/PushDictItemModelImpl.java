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

package org.opencps.synchronization.model.impl;

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

import org.opencps.synchronization.model.PushDictItem;
import org.opencps.synchronization.model.PushDictItemModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the PushDictItem service. Represents a row in the &quot;opencps_pushdictitem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link PushDictItemModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PushDictItemImpl}.
 * </p>
 *
 * @author trungdk
 * @see PushDictItemImpl
 * @see PushDictItem
 * @see PushDictItemModel
 * @generated
 */
@ProviderType
public class PushDictItemModelImpl extends BaseModelImpl<PushDictItem>
	implements PushDictItemModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a push dict item model instance should use the {@link PushDictItem} interface instead.
	 */
	public static final String TABLE_NAME = "opencps_pushdictitem";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "pushDictItemId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "serverNo", Types.VARCHAR },
			{ "collectionCode", Types.VARCHAR },
			{ "itemCode", Types.VARCHAR },
			{ "itemName", Types.VARCHAR },
			{ "itemNameEN", Types.VARCHAR },
			{ "itemDescription", Types.VARCHAR },
			{ "parentItemCode", Types.VARCHAR },
			{ "sibling", Types.VARCHAR },
			{ "method", Types.VARCHAR },
			{ "metaData", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("pushDictItemId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("serverNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("collectionCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("itemCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("itemName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("itemNameEN", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("itemDescription", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("parentItemCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("sibling", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("method", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("metaData", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table opencps_pushdictitem (uuid_ VARCHAR(75) null,pushDictItemId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,serverNo VARCHAR(75) null,collectionCode VARCHAR(75) null,itemCode VARCHAR(75) null,itemName VARCHAR(75) null,itemNameEN VARCHAR(75) null,itemDescription VARCHAR(75) null,parentItemCode VARCHAR(75) null,sibling VARCHAR(75) null,method VARCHAR(75) null,metaData VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table opencps_pushdictitem";
	public static final String ORDER_BY_JPQL = " ORDER BY pushDictItem.modifiedDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY opencps_pushdictitem.modifiedDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(backend.synchronization.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.org.opencps.synchronization.model.PushDictItem"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(backend.synchronization.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.org.opencps.synchronization.model.PushDictItem"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(backend.synchronization.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.opencps.synchronization.model.PushDictItem"),
			true);
	public static final long COLLECTIONCODE_COLUMN_BITMASK = 1L;
	public static final long COMPANYID_COLUMN_BITMASK = 2L;
	public static final long GROUPID_COLUMN_BITMASK = 4L;
	public static final long ITEMCODE_COLUMN_BITMASK = 8L;
	public static final long METHOD_COLUMN_BITMASK = 16L;
	public static final long SERVERNO_COLUMN_BITMASK = 32L;
	public static final long UUID_COLUMN_BITMASK = 64L;
	public static final long MODIFIEDDATE_COLUMN_BITMASK = 128L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(backend.synchronization.service.util.ServiceProps.get(
				"lock.expiration.time.org.opencps.synchronization.model.PushDictItem"));

	public PushDictItemModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _pushDictItemId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPushDictItemId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _pushDictItemId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return PushDictItem.class;
	}

	@Override
	public String getModelClassName() {
		return PushDictItem.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("pushDictItemId", getPushDictItemId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("serverNo", getServerNo());
		attributes.put("collectionCode", getCollectionCode());
		attributes.put("itemCode", getItemCode());
		attributes.put("itemName", getItemName());
		attributes.put("itemNameEN", getItemNameEN());
		attributes.put("itemDescription", getItemDescription());
		attributes.put("parentItemCode", getParentItemCode());
		attributes.put("sibling", getSibling());
		attributes.put("method", getMethod());
		attributes.put("metaData", getMetaData());

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

		Long pushDictItemId = (Long)attributes.get("pushDictItemId");

		if (pushDictItemId != null) {
			setPushDictItemId(pushDictItemId);
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

		String serverNo = (String)attributes.get("serverNo");

		if (serverNo != null) {
			setServerNo(serverNo);
		}

		String collectionCode = (String)attributes.get("collectionCode");

		if (collectionCode != null) {
			setCollectionCode(collectionCode);
		}

		String itemCode = (String)attributes.get("itemCode");

		if (itemCode != null) {
			setItemCode(itemCode);
		}

		String itemName = (String)attributes.get("itemName");

		if (itemName != null) {
			setItemName(itemName);
		}

		String itemNameEN = (String)attributes.get("itemNameEN");

		if (itemNameEN != null) {
			setItemNameEN(itemNameEN);
		}

		String itemDescription = (String)attributes.get("itemDescription");

		if (itemDescription != null) {
			setItemDescription(itemDescription);
		}

		String parentItemCode = (String)attributes.get("parentItemCode");

		if (parentItemCode != null) {
			setParentItemCode(parentItemCode);
		}

		String sibling = (String)attributes.get("sibling");

		if (sibling != null) {
			setSibling(sibling);
		}

		String method = (String)attributes.get("method");

		if (method != null) {
			setMethod(method);
		}

		String metaData = (String)attributes.get("metaData");

		if (metaData != null) {
			setMetaData(metaData);
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
	public long getPushDictItemId() {
		return _pushDictItemId;
	}

	@Override
	public void setPushDictItemId(long pushDictItemId) {
		_pushDictItemId = pushDictItemId;
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

		_columnBitmask = -1L;

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getServerNo() {
		if (_serverNo == null) {
			return StringPool.BLANK;
		}
		else {
			return _serverNo;
		}
	}

	@Override
	public void setServerNo(String serverNo) {
		_columnBitmask |= SERVERNO_COLUMN_BITMASK;

		if (_originalServerNo == null) {
			_originalServerNo = _serverNo;
		}

		_serverNo = serverNo;
	}

	public String getOriginalServerNo() {
		return GetterUtil.getString(_originalServerNo);
	}

	@Override
	public String getCollectionCode() {
		if (_collectionCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _collectionCode;
		}
	}

	@Override
	public void setCollectionCode(String collectionCode) {
		_columnBitmask |= COLLECTIONCODE_COLUMN_BITMASK;

		if (_originalCollectionCode == null) {
			_originalCollectionCode = _collectionCode;
		}

		_collectionCode = collectionCode;
	}

	public String getOriginalCollectionCode() {
		return GetterUtil.getString(_originalCollectionCode);
	}

	@Override
	public String getItemCode() {
		if (_itemCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _itemCode;
		}
	}

	@Override
	public void setItemCode(String itemCode) {
		_columnBitmask |= ITEMCODE_COLUMN_BITMASK;

		if (_originalItemCode == null) {
			_originalItemCode = _itemCode;
		}

		_itemCode = itemCode;
	}

	public String getOriginalItemCode() {
		return GetterUtil.getString(_originalItemCode);
	}

	@Override
	public String getItemName() {
		if (_itemName == null) {
			return StringPool.BLANK;
		}
		else {
			return _itemName;
		}
	}

	@Override
	public void setItemName(String itemName) {
		_itemName = itemName;
	}

	@Override
	public String getItemNameEN() {
		if (_itemNameEN == null) {
			return StringPool.BLANK;
		}
		else {
			return _itemNameEN;
		}
	}

	@Override
	public void setItemNameEN(String itemNameEN) {
		_itemNameEN = itemNameEN;
	}

	@Override
	public String getItemDescription() {
		if (_itemDescription == null) {
			return StringPool.BLANK;
		}
		else {
			return _itemDescription;
		}
	}

	@Override
	public void setItemDescription(String itemDescription) {
		_itemDescription = itemDescription;
	}

	@Override
	public String getParentItemCode() {
		if (_parentItemCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _parentItemCode;
		}
	}

	@Override
	public void setParentItemCode(String parentItemCode) {
		_parentItemCode = parentItemCode;
	}

	@Override
	public String getSibling() {
		if (_sibling == null) {
			return StringPool.BLANK;
		}
		else {
			return _sibling;
		}
	}

	@Override
	public void setSibling(String sibling) {
		_sibling = sibling;
	}

	@Override
	public String getMethod() {
		if (_method == null) {
			return StringPool.BLANK;
		}
		else {
			return _method;
		}
	}

	@Override
	public void setMethod(String method) {
		_columnBitmask |= METHOD_COLUMN_BITMASK;

		if (_originalMethod == null) {
			_originalMethod = _method;
		}

		_method = method;
	}

	public String getOriginalMethod() {
		return GetterUtil.getString(_originalMethod);
	}

	@Override
	public String getMetaData() {
		if (_metaData == null) {
			return StringPool.BLANK;
		}
		else {
			return _metaData;
		}
	}

	@Override
	public void setMetaData(String metaData) {
		_metaData = metaData;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				PushDictItem.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			PushDictItem.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public PushDictItem toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (PushDictItem)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		PushDictItemImpl pushDictItemImpl = new PushDictItemImpl();

		pushDictItemImpl.setUuid(getUuid());
		pushDictItemImpl.setPushDictItemId(getPushDictItemId());
		pushDictItemImpl.setGroupId(getGroupId());
		pushDictItemImpl.setCompanyId(getCompanyId());
		pushDictItemImpl.setUserId(getUserId());
		pushDictItemImpl.setUserName(getUserName());
		pushDictItemImpl.setCreateDate(getCreateDate());
		pushDictItemImpl.setModifiedDate(getModifiedDate());
		pushDictItemImpl.setServerNo(getServerNo());
		pushDictItemImpl.setCollectionCode(getCollectionCode());
		pushDictItemImpl.setItemCode(getItemCode());
		pushDictItemImpl.setItemName(getItemName());
		pushDictItemImpl.setItemNameEN(getItemNameEN());
		pushDictItemImpl.setItemDescription(getItemDescription());
		pushDictItemImpl.setParentItemCode(getParentItemCode());
		pushDictItemImpl.setSibling(getSibling());
		pushDictItemImpl.setMethod(getMethod());
		pushDictItemImpl.setMetaData(getMetaData());

		pushDictItemImpl.resetOriginalValues();

		return pushDictItemImpl;
	}

	@Override
	public int compareTo(PushDictItem pushDictItem) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				pushDictItem.getModifiedDate());

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

		if (!(obj instanceof PushDictItem)) {
			return false;
		}

		PushDictItem pushDictItem = (PushDictItem)obj;

		long primaryKey = pushDictItem.getPrimaryKey();

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
		PushDictItemModelImpl pushDictItemModelImpl = this;

		pushDictItemModelImpl._originalUuid = pushDictItemModelImpl._uuid;

		pushDictItemModelImpl._originalGroupId = pushDictItemModelImpl._groupId;

		pushDictItemModelImpl._setOriginalGroupId = false;

		pushDictItemModelImpl._originalCompanyId = pushDictItemModelImpl._companyId;

		pushDictItemModelImpl._setOriginalCompanyId = false;

		pushDictItemModelImpl._setModifiedDate = false;

		pushDictItemModelImpl._originalServerNo = pushDictItemModelImpl._serverNo;

		pushDictItemModelImpl._originalCollectionCode = pushDictItemModelImpl._collectionCode;

		pushDictItemModelImpl._originalItemCode = pushDictItemModelImpl._itemCode;

		pushDictItemModelImpl._originalMethod = pushDictItemModelImpl._method;

		pushDictItemModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<PushDictItem> toCacheModel() {
		PushDictItemCacheModel pushDictItemCacheModel = new PushDictItemCacheModel();

		pushDictItemCacheModel.uuid = getUuid();

		String uuid = pushDictItemCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			pushDictItemCacheModel.uuid = null;
		}

		pushDictItemCacheModel.pushDictItemId = getPushDictItemId();

		pushDictItemCacheModel.groupId = getGroupId();

		pushDictItemCacheModel.companyId = getCompanyId();

		pushDictItemCacheModel.userId = getUserId();

		pushDictItemCacheModel.userName = getUserName();

		String userName = pushDictItemCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			pushDictItemCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			pushDictItemCacheModel.createDate = createDate.getTime();
		}
		else {
			pushDictItemCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			pushDictItemCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			pushDictItemCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		pushDictItemCacheModel.serverNo = getServerNo();

		String serverNo = pushDictItemCacheModel.serverNo;

		if ((serverNo != null) && (serverNo.length() == 0)) {
			pushDictItemCacheModel.serverNo = null;
		}

		pushDictItemCacheModel.collectionCode = getCollectionCode();

		String collectionCode = pushDictItemCacheModel.collectionCode;

		if ((collectionCode != null) && (collectionCode.length() == 0)) {
			pushDictItemCacheModel.collectionCode = null;
		}

		pushDictItemCacheModel.itemCode = getItemCode();

		String itemCode = pushDictItemCacheModel.itemCode;

		if ((itemCode != null) && (itemCode.length() == 0)) {
			pushDictItemCacheModel.itemCode = null;
		}

		pushDictItemCacheModel.itemName = getItemName();

		String itemName = pushDictItemCacheModel.itemName;

		if ((itemName != null) && (itemName.length() == 0)) {
			pushDictItemCacheModel.itemName = null;
		}

		pushDictItemCacheModel.itemNameEN = getItemNameEN();

		String itemNameEN = pushDictItemCacheModel.itemNameEN;

		if ((itemNameEN != null) && (itemNameEN.length() == 0)) {
			pushDictItemCacheModel.itemNameEN = null;
		}

		pushDictItemCacheModel.itemDescription = getItemDescription();

		String itemDescription = pushDictItemCacheModel.itemDescription;

		if ((itemDescription != null) && (itemDescription.length() == 0)) {
			pushDictItemCacheModel.itemDescription = null;
		}

		pushDictItemCacheModel.parentItemCode = getParentItemCode();

		String parentItemCode = pushDictItemCacheModel.parentItemCode;

		if ((parentItemCode != null) && (parentItemCode.length() == 0)) {
			pushDictItemCacheModel.parentItemCode = null;
		}

		pushDictItemCacheModel.sibling = getSibling();

		String sibling = pushDictItemCacheModel.sibling;

		if ((sibling != null) && (sibling.length() == 0)) {
			pushDictItemCacheModel.sibling = null;
		}

		pushDictItemCacheModel.method = getMethod();

		String method = pushDictItemCacheModel.method;

		if ((method != null) && (method.length() == 0)) {
			pushDictItemCacheModel.method = null;
		}

		pushDictItemCacheModel.metaData = getMetaData();

		String metaData = pushDictItemCacheModel.metaData;

		if ((metaData != null) && (metaData.length() == 0)) {
			pushDictItemCacheModel.metaData = null;
		}

		return pushDictItemCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", pushDictItemId=");
		sb.append(getPushDictItemId());
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
		sb.append(", serverNo=");
		sb.append(getServerNo());
		sb.append(", collectionCode=");
		sb.append(getCollectionCode());
		sb.append(", itemCode=");
		sb.append(getItemCode());
		sb.append(", itemName=");
		sb.append(getItemName());
		sb.append(", itemNameEN=");
		sb.append(getItemNameEN());
		sb.append(", itemDescription=");
		sb.append(getItemDescription());
		sb.append(", parentItemCode=");
		sb.append(getParentItemCode());
		sb.append(", sibling=");
		sb.append(getSibling());
		sb.append(", method=");
		sb.append(getMethod());
		sb.append(", metaData=");
		sb.append(getMetaData());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("org.opencps.synchronization.model.PushDictItem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pushDictItemId</column-name><column-value><![CDATA[");
		sb.append(getPushDictItemId());
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
			"<column><column-name>serverNo</column-name><column-value><![CDATA[");
		sb.append(getServerNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionCode</column-name><column-value><![CDATA[");
		sb.append(getCollectionCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemCode</column-name><column-value><![CDATA[");
		sb.append(getItemCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemName</column-name><column-value><![CDATA[");
		sb.append(getItemName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemNameEN</column-name><column-value><![CDATA[");
		sb.append(getItemNameEN());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemDescription</column-name><column-value><![CDATA[");
		sb.append(getItemDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentItemCode</column-name><column-value><![CDATA[");
		sb.append(getParentItemCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sibling</column-name><column-value><![CDATA[");
		sb.append(getSibling());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>method</column-name><column-value><![CDATA[");
		sb.append(getMethod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>metaData</column-name><column-value><![CDATA[");
		sb.append(getMetaData());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = PushDictItem.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			PushDictItem.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _pushDictItemId;
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
	private String _serverNo;
	private String _originalServerNo;
	private String _collectionCode;
	private String _originalCollectionCode;
	private String _itemCode;
	private String _originalItemCode;
	private String _itemName;
	private String _itemNameEN;
	private String _itemDescription;
	private String _parentItemCode;
	private String _sibling;
	private String _method;
	private String _originalMethod;
	private String _metaData;
	private long _columnBitmask;
	private PushDictItem _escapedModel;
}