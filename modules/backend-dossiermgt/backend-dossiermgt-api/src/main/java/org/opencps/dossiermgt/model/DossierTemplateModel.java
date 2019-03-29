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
 * The base model interface for the DossierTemplate service. Represents a row in the &quot;opencps_dossiertemplate&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.opencps.dossiermgt.model.impl.DossierTemplateModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.opencps.dossiermgt.model.impl.DossierTemplateImpl}.
 * </p>
 *
 * @author huymq
 * @see DossierTemplate
 * @see org.opencps.dossiermgt.model.impl.DossierTemplateImpl
 * @see org.opencps.dossiermgt.model.impl.DossierTemplateModelImpl
 * @generated
 */
@ProviderType
public interface DossierTemplateModel extends BaseModel<DossierTemplate>,
	GroupedModel, ShardedModel, StagedAuditedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a dossier template model instance should use the {@link DossierTemplate} interface instead.
	 */

	/**
	 * Returns the primary key of this dossier template.
	 *
	 * @return the primary key of this dossier template
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this dossier template.
	 *
	 * @param primaryKey the primary key of this dossier template
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this dossier template.
	 *
	 * @return the uuid of this dossier template
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this dossier template.
	 *
	 * @param uuid the uuid of this dossier template
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the dossier template ID of this dossier template.
	 *
	 * @return the dossier template ID of this dossier template
	 */
	public long getDossierTemplateId();

	/**
	 * Sets the dossier template ID of this dossier template.
	 *
	 * @param dossierTemplateId the dossier template ID of this dossier template
	 */
	public void setDossierTemplateId(long dossierTemplateId);

	/**
	 * Returns the group ID of this dossier template.
	 *
	 * @return the group ID of this dossier template
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this dossier template.
	 *
	 * @param groupId the group ID of this dossier template
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this dossier template.
	 *
	 * @return the company ID of this dossier template
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this dossier template.
	 *
	 * @param companyId the company ID of this dossier template
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this dossier template.
	 *
	 * @return the user ID of this dossier template
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this dossier template.
	 *
	 * @param userId the user ID of this dossier template
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this dossier template.
	 *
	 * @return the user uuid of this dossier template
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this dossier template.
	 *
	 * @param userUuid the user uuid of this dossier template
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this dossier template.
	 *
	 * @return the user name of this dossier template
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this dossier template.
	 *
	 * @param userName the user name of this dossier template
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this dossier template.
	 *
	 * @return the create date of this dossier template
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this dossier template.
	 *
	 * @param createDate the create date of this dossier template
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this dossier template.
	 *
	 * @return the modified date of this dossier template
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this dossier template.
	 *
	 * @param modifiedDate the modified date of this dossier template
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the template name of this dossier template.
	 *
	 * @return the template name of this dossier template
	 */
	@AutoEscape
	public String getTemplateName();

	/**
	 * Sets the template name of this dossier template.
	 *
	 * @param templateName the template name of this dossier template
	 */
	public void setTemplateName(String templateName);

	/**
	 * Returns the description of this dossier template.
	 *
	 * @return the description of this dossier template
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this dossier template.
	 *
	 * @param description the description of this dossier template
	 */
	public void setDescription(String description);

	/**
	 * Returns the template no of this dossier template.
	 *
	 * @return the template no of this dossier template
	 */
	@AutoEscape
	public String getTemplateNo();

	/**
	 * Sets the template no of this dossier template.
	 *
	 * @param templateNo the template no of this dossier template
	 */
	public void setTemplateNo(String templateNo);

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
	public int compareTo(DossierTemplate dossierTemplate);

	@Override
	public int hashCode();

	@Override
	public CacheModel<DossierTemplate> toCacheModel();

	@Override
	public DossierTemplate toEscapedModel();

	@Override
	public DossierTemplate toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}