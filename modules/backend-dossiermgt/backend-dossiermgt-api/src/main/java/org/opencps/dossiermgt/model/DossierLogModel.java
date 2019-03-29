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
 * The base model interface for the DossierLog service. Represents a row in the &quot;opencps_dossierlog&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.opencps.dossiermgt.model.impl.DossierLogModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.opencps.dossiermgt.model.impl.DossierLogImpl}.
 * </p>
 *
 * @author huymq
 * @see DossierLog
 * @see org.opencps.dossiermgt.model.impl.DossierLogImpl
 * @see org.opencps.dossiermgt.model.impl.DossierLogModelImpl
 * @generated
 */
@ProviderType
public interface DossierLogModel extends BaseModel<DossierLog>, GroupedModel,
	ShardedModel, StagedAuditedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a dossier log model instance should use the {@link DossierLog} interface instead.
	 */

	/**
	 * Returns the primary key of this dossier log.
	 *
	 * @return the primary key of this dossier log
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this dossier log.
	 *
	 * @param primaryKey the primary key of this dossier log
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this dossier log.
	 *
	 * @return the uuid of this dossier log
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this dossier log.
	 *
	 * @param uuid the uuid of this dossier log
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the dossier log ID of this dossier log.
	 *
	 * @return the dossier log ID of this dossier log
	 */
	public long getDossierLogId();

	/**
	 * Sets the dossier log ID of this dossier log.
	 *
	 * @param dossierLogId the dossier log ID of this dossier log
	 */
	public void setDossierLogId(long dossierLogId);

	/**
	 * Returns the group ID of this dossier log.
	 *
	 * @return the group ID of this dossier log
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this dossier log.
	 *
	 * @param groupId the group ID of this dossier log
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this dossier log.
	 *
	 * @return the company ID of this dossier log
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this dossier log.
	 *
	 * @param companyId the company ID of this dossier log
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this dossier log.
	 *
	 * @return the user ID of this dossier log
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this dossier log.
	 *
	 * @param userId the user ID of this dossier log
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this dossier log.
	 *
	 * @return the user uuid of this dossier log
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this dossier log.
	 *
	 * @param userUuid the user uuid of this dossier log
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this dossier log.
	 *
	 * @return the user name of this dossier log
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this dossier log.
	 *
	 * @param userName the user name of this dossier log
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this dossier log.
	 *
	 * @return the create date of this dossier log
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this dossier log.
	 *
	 * @param createDate the create date of this dossier log
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this dossier log.
	 *
	 * @return the modified date of this dossier log
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this dossier log.
	 *
	 * @param modifiedDate the modified date of this dossier log
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the dossier ID of this dossier log.
	 *
	 * @return the dossier ID of this dossier log
	 */
	public long getDossierId();

	/**
	 * Sets the dossier ID of this dossier log.
	 *
	 * @param dossierId the dossier ID of this dossier log
	 */
	public void setDossierId(long dossierId);

	/**
	 * Returns the author of this dossier log.
	 *
	 * @return the author of this dossier log
	 */
	@AutoEscape
	public String getAuthor();

	/**
	 * Sets the author of this dossier log.
	 *
	 * @param author the author of this dossier log
	 */
	public void setAuthor(String author);

	/**
	 * Returns the content of this dossier log.
	 *
	 * @return the content of this dossier log
	 */
	@AutoEscape
	public String getContent();

	/**
	 * Sets the content of this dossier log.
	 *
	 * @param content the content of this dossier log
	 */
	public void setContent(String content);

	/**
	 * Returns the notification type of this dossier log.
	 *
	 * @return the notification type of this dossier log
	 */
	@AutoEscape
	public String getNotificationType();

	/**
	 * Sets the notification type of this dossier log.
	 *
	 * @param notificationType the notification type of this dossier log
	 */
	public void setNotificationType(String notificationType);

	/**
	 * Returns the payload of this dossier log.
	 *
	 * @return the payload of this dossier log
	 */
	@AutoEscape
	public String getPayload();

	/**
	 * Sets the payload of this dossier log.
	 *
	 * @param payload the payload of this dossier log
	 */
	public void setPayload(String payload);

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
	public int compareTo(DossierLog dossierLog);

	@Override
	public int hashCode();

	@Override
	public CacheModel<DossierLog> toCacheModel();

	@Override
	public DossierLog toEscapedModel();

	@Override
	public DossierLog toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}