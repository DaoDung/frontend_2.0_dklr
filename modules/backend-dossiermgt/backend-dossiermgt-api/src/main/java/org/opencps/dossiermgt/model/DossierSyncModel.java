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

package org.opencps.dossiermgt.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the DossierSync service. Represents a row in the &quot;opencps_dossiersync&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.opencps.dossiermgt.model.impl.DossierSyncModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.opencps.dossiermgt.model.impl.DossierSyncImpl}.
 * </p>
 *
 * @author huymq
 * @see DossierSync
 * @see org.opencps.dossiermgt.model.impl.DossierSyncImpl
 * @see org.opencps.dossiermgt.model.impl.DossierSyncModelImpl
 * @generated
 */
@ProviderType
public interface DossierSyncModel extends BaseModel<DossierSync>, GroupedModel,
	ShardedModel, StagedAuditedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a dossier sync model instance should use the {@link DossierSync} interface instead.
	 */

	/**
	 * Returns the primary key of this dossier sync.
	 *
	 * @return the primary key of this dossier sync
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this dossier sync.
	 *
	 * @param primaryKey the primary key of this dossier sync
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this dossier sync.
	 *
	 * @return the uuid of this dossier sync
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this dossier sync.
	 *
	 * @param uuid the uuid of this dossier sync
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the dossier sync ID of this dossier sync.
	 *
	 * @return the dossier sync ID of this dossier sync
	 */
	public long getDossierSyncId();

	/**
	 * Sets the dossier sync ID of this dossier sync.
	 *
	 * @param dossierSyncId the dossier sync ID of this dossier sync
	 */
	public void setDossierSyncId(long dossierSyncId);

	/**
	 * Returns the company ID of this dossier sync.
	 *
	 * @return the company ID of this dossier sync
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this dossier sync.
	 *
	 * @param companyId the company ID of this dossier sync
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this dossier sync.
	 *
	 * @return the group ID of this dossier sync
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this dossier sync.
	 *
	 * @param groupId the group ID of this dossier sync
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this dossier sync.
	 *
	 * @return the user ID of this dossier sync
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this dossier sync.
	 *
	 * @param userId the user ID of this dossier sync
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this dossier sync.
	 *
	 * @return the user uuid of this dossier sync
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this dossier sync.
	 *
	 * @param userUuid the user uuid of this dossier sync
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this dossier sync.
	 *
	 * @return the user name of this dossier sync
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this dossier sync.
	 *
	 * @param userName the user name of this dossier sync
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this dossier sync.
	 *
	 * @return the create date of this dossier sync
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this dossier sync.
	 *
	 * @param createDate the create date of this dossier sync
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this dossier sync.
	 *
	 * @return the modified date of this dossier sync
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this dossier sync.
	 *
	 * @param modifiedDate the modified date of this dossier sync
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the dossier ID of this dossier sync.
	 *
	 * @return the dossier ID of this dossier sync
	 */
	public long getDossierId();

	/**
	 * Sets the dossier ID of this dossier sync.
	 *
	 * @param dossierId the dossier ID of this dossier sync
	 */
	public void setDossierId(long dossierId);

	/**
	 * Returns the dossier reference uid of this dossier sync.
	 *
	 * @return the dossier reference uid of this dossier sync
	 */
	@AutoEscape
	public String getDossierReferenceUid();

	/**
	 * Sets the dossier reference uid of this dossier sync.
	 *
	 * @param dossierReferenceUid the dossier reference uid of this dossier sync
	 */
	public void setDossierReferenceUid(String dossierReferenceUid);

	/**
	 * Returns the create dossier of this dossier sync.
	 *
	 * @return the create dossier of this dossier sync
	 */
	public boolean getCreateDossier();

	/**
	 * Returns <code>true</code> if this dossier sync is create dossier.
	 *
	 * @return <code>true</code> if this dossier sync is create dossier; <code>false</code> otherwise
	 */
	public boolean isCreateDossier();

	/**
	 * Sets whether this dossier sync is create dossier.
	 *
	 * @param createDossier the create dossier of this dossier sync
	 */
	public void setCreateDossier(boolean createDossier);

	/**
	 * Returns the method of this dossier sync.
	 *
	 * @return the method of this dossier sync
	 */
	public int getMethod();

	/**
	 * Sets the method of this dossier sync.
	 *
	 * @param method the method of this dossier sync
	 */
	public void setMethod(int method);

	/**
	 * Returns the class pk of this dossier sync.
	 *
	 * @return the class pk of this dossier sync
	 */
	public long getClassPK();

	/**
	 * Sets the class pk of this dossier sync.
	 *
	 * @param classPK the class pk of this dossier sync
	 */
	public void setClassPK(long classPK);

	/**
	 * Returns the file reference uid of this dossier sync.
	 *
	 * @return the file reference uid of this dossier sync
	 */
	@AutoEscape
	public String getFileReferenceUid();

	/**
	 * Sets the file reference uid of this dossier sync.
	 *
	 * @param fileReferenceUid the file reference uid of this dossier sync
	 */
	public void setFileReferenceUid(String fileReferenceUid);

	/**
	 * Returns the server no of this dossier sync.
	 *
	 * @return the server no of this dossier sync
	 */
	@AutoEscape
	public String getServerNo();

	/**
	 * Sets the server no of this dossier sync.
	 *
	 * @param serverNo the server no of this dossier sync
	 */
	public void setServerNo(String serverNo);

	/**
	 * Returns the payload of this dossier sync.
	 *
	 * @return the payload of this dossier sync
	 */
	@AutoEscape
	public String getPayload();

	/**
	 * Sets the payload of this dossier sync.
	 *
	 * @param payload the payload of this dossier sync
	 */
	public void setPayload(String payload);

	/**
	 * Returns the retry of this dossier sync.
	 *
	 * @return the retry of this dossier sync
	 */
	public int getRetry();

	/**
	 * Sets the retry of this dossier sync.
	 *
	 * @param retry the retry of this dossier sync
	 */
	public void setRetry(int retry);

	/**
	 * Returns the state of this dossier sync.
	 *
	 * @return the state of this dossier sync
	 */
	public int getState();

	/**
	 * Sets the state of this dossier sync.
	 *
	 * @param state the state of this dossier sync
	 */
	public void setState(int state);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(DossierSync dossierSync);

	@Override
	public int hashCode();

	@Override
	public CacheModel<DossierSync> toCacheModel();

	@Override
	public DossierSync toEscapedModel();

	@Override
	public DossierSync toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}