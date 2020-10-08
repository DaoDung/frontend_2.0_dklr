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

package org.opencps.communication.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import org.opencps.communication.model.ServerConfig;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ServerConfig in entity cache.
 *
 * @author khoavd
 * @see ServerConfig
 * @generated
 */
@ProviderType
public class ServerConfigCacheModel implements CacheModel<ServerConfig>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ServerConfigCacheModel)) {
			return false;
		}

		ServerConfigCacheModel serverConfigCacheModel = (ServerConfigCacheModel)obj;

		if (serverConfigId == serverConfigCacheModel.serverConfigId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, serverConfigId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{serverConfigId=");
		sb.append(serverConfigId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", serverNo=");
		sb.append(serverNo);
		sb.append(", serverName=");
		sb.append(serverName);
		sb.append(", protocol=");
		sb.append(protocol);
		sb.append(", configs=");
		sb.append(configs);
		sb.append(", lastSync=");
		sb.append(lastSync);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ServerConfig toEntityModel() {
		ServerConfigImpl serverConfigImpl = new ServerConfigImpl();

		serverConfigImpl.setServerConfigId(serverConfigId);
		serverConfigImpl.setGroupId(groupId);
		serverConfigImpl.setCompanyId(companyId);
		serverConfigImpl.setUserId(userId);

		if (userName == null) {
			serverConfigImpl.setUserName(StringPool.BLANK);
		}
		else {
			serverConfigImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			serverConfigImpl.setCreateDate(null);
		}
		else {
			serverConfigImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			serverConfigImpl.setModifiedDate(null);
		}
		else {
			serverConfigImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (serverNo == null) {
			serverConfigImpl.setServerNo(StringPool.BLANK);
		}
		else {
			serverConfigImpl.setServerNo(serverNo);
		}

		if (serverName == null) {
			serverConfigImpl.setServerName(StringPool.BLANK);
		}
		else {
			serverConfigImpl.setServerName(serverName);
		}

		if (protocol == null) {
			serverConfigImpl.setProtocol(StringPool.BLANK);
		}
		else {
			serverConfigImpl.setProtocol(protocol);
		}

		if (configs == null) {
			serverConfigImpl.setConfigs(StringPool.BLANK);
		}
		else {
			serverConfigImpl.setConfigs(configs);
		}

		if (lastSync == Long.MIN_VALUE) {
			serverConfigImpl.setLastSync(null);
		}
		else {
			serverConfigImpl.setLastSync(new Date(lastSync));
		}

		serverConfigImpl.resetOriginalValues();

		return serverConfigImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		serverConfigId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		serverNo = objectInput.readUTF();
		serverName = objectInput.readUTF();
		protocol = objectInput.readUTF();
		configs = objectInput.readUTF();
		lastSync = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(serverConfigId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (serverNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(serverNo);
		}

		if (serverName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(serverName);
		}

		if (protocol == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(protocol);
		}

		if (configs == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(configs);
		}

		objectOutput.writeLong(lastSync);
	}

	public long serverConfigId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String serverNo;
	public String serverName;
	public String protocol;
	public String configs;
	public long lastSync;
}