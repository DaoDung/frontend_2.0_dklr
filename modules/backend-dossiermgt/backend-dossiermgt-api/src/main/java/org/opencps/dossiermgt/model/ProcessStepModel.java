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
 * The base model interface for the ProcessStep service. Represents a row in the &quot;opencps_processstep&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.opencps.dossiermgt.model.impl.ProcessStepModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.opencps.dossiermgt.model.impl.ProcessStepImpl}.
 * </p>
 *
 * @author huymq
 * @see ProcessStep
 * @see org.opencps.dossiermgt.model.impl.ProcessStepImpl
 * @see org.opencps.dossiermgt.model.impl.ProcessStepModelImpl
 * @generated
 */
@ProviderType
public interface ProcessStepModel extends BaseModel<ProcessStep>, GroupedModel,
	ShardedModel, StagedAuditedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a process step model instance should use the {@link ProcessStep} interface instead.
	 */

	/**
	 * Returns the primary key of this process step.
	 *
	 * @return the primary key of this process step
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this process step.
	 *
	 * @param primaryKey the primary key of this process step
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this process step.
	 *
	 * @return the uuid of this process step
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this process step.
	 *
	 * @param uuid the uuid of this process step
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the process step ID of this process step.
	 *
	 * @return the process step ID of this process step
	 */
	public long getProcessStepId();

	/**
	 * Sets the process step ID of this process step.
	 *
	 * @param processStepId the process step ID of this process step
	 */
	public void setProcessStepId(long processStepId);

	/**
	 * Returns the company ID of this process step.
	 *
	 * @return the company ID of this process step
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this process step.
	 *
	 * @param companyId the company ID of this process step
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this process step.
	 *
	 * @return the group ID of this process step
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this process step.
	 *
	 * @param groupId the group ID of this process step
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this process step.
	 *
	 * @return the user ID of this process step
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this process step.
	 *
	 * @param userId the user ID of this process step
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this process step.
	 *
	 * @return the user uuid of this process step
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this process step.
	 *
	 * @param userUuid the user uuid of this process step
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this process step.
	 *
	 * @return the user name of this process step
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this process step.
	 *
	 * @param userName the user name of this process step
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this process step.
	 *
	 * @return the create date of this process step
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this process step.
	 *
	 * @param createDate the create date of this process step
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this process step.
	 *
	 * @return the modified date of this process step
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this process step.
	 *
	 * @param modifiedDate the modified date of this process step
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the step code of this process step.
	 *
	 * @return the step code of this process step
	 */
	@AutoEscape
	public String getStepCode();

	/**
	 * Sets the step code of this process step.
	 *
	 * @param stepCode the step code of this process step
	 */
	public void setStepCode(String stepCode);

	/**
	 * Returns the service process ID of this process step.
	 *
	 * @return the service process ID of this process step
	 */
	public long getServiceProcessId();

	/**
	 * Sets the service process ID of this process step.
	 *
	 * @param serviceProcessId the service process ID of this process step
	 */
	public void setServiceProcessId(long serviceProcessId);

	/**
	 * Returns the step name of this process step.
	 *
	 * @return the step name of this process step
	 */
	@AutoEscape
	public String getStepName();

	/**
	 * Sets the step name of this process step.
	 *
	 * @param stepName the step name of this process step
	 */
	public void setStepName(String stepName);

	/**
	 * Returns the sequence no of this process step.
	 *
	 * @return the sequence no of this process step
	 */
	@AutoEscape
	public String getSequenceNo();

	/**
	 * Sets the sequence no of this process step.
	 *
	 * @param sequenceNo the sequence no of this process step
	 */
	public void setSequenceNo(String sequenceNo);

	/**
	 * Returns the dossier status of this process step.
	 *
	 * @return the dossier status of this process step
	 */
	@AutoEscape
	public String getDossierStatus();

	/**
	 * Sets the dossier status of this process step.
	 *
	 * @param dossierStatus the dossier status of this process step
	 */
	public void setDossierStatus(String dossierStatus);

	/**
	 * Returns the dossier sub status of this process step.
	 *
	 * @return the dossier sub status of this process step
	 */
	@AutoEscape
	public String getDossierSubStatus();

	/**
	 * Sets the dossier sub status of this process step.
	 *
	 * @param dossierSubStatus the dossier sub status of this process step
	 */
	public void setDossierSubStatus(String dossierSubStatus);

	/**
	 * Returns the duration count of this process step.
	 *
	 * @return the duration count of this process step
	 */
	public int getDurationCount();

	/**
	 * Sets the duration count of this process step.
	 *
	 * @param durationCount the duration count of this process step
	 */
	public void setDurationCount(int durationCount);

	/**
	 * Returns the custom process url of this process step.
	 *
	 * @return the custom process url of this process step
	 */
	@AutoEscape
	public String getCustomProcessUrl();

	/**
	 * Sets the custom process url of this process step.
	 *
	 * @param customProcessUrl the custom process url of this process step
	 */
	public void setCustomProcessUrl(String customProcessUrl);

	/**
	 * Returns the step instruction of this process step.
	 *
	 * @return the step instruction of this process step
	 */
	@AutoEscape
	public String getStepInstruction();

	/**
	 * Sets the step instruction of this process step.
	 *
	 * @param stepInstruction the step instruction of this process step
	 */
	public void setStepInstruction(String stepInstruction);

	/**
	 * Returns the brief note of this process step.
	 *
	 * @return the brief note of this process step
	 */
	@AutoEscape
	public String getBriefNote();

	/**
	 * Sets the brief note of this process step.
	 *
	 * @param briefNote the brief note of this process step
	 */
	public void setBriefNote(String briefNote);

	/**
	 * Returns the editable of this process step.
	 *
	 * @return the editable of this process step
	 */
	public boolean getEditable();

	/**
	 * Returns <code>true</code> if this process step is editable.
	 *
	 * @return <code>true</code> if this process step is editable; <code>false</code> otherwise
	 */
	public boolean isEditable();

	/**
	 * Sets whether this process step is editable.
	 *
	 * @param editable the editable of this process step
	 */
	public void setEditable(boolean editable);

	/**
	 * Returns the restrict dossier of this process step.
	 *
	 * @return the restrict dossier of this process step
	 */
	@AutoEscape
	public String getRestrictDossier();

	/**
	 * Sets the restrict dossier of this process step.
	 *
	 * @param restrictDossier the restrict dossier of this process step
	 */
	public void setRestrictDossier(String restrictDossier);

	/**
	 * Returns the lock state of this process step.
	 *
	 * @return the lock state of this process step
	 */
	@AutoEscape
	public String getLockState();

	/**
	 * Sets the lock state of this process step.
	 *
	 * @param lockState the lock state of this process step
	 */
	public void setLockState(String lockState);

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
	public int compareTo(ProcessStep processStep);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ProcessStep> toCacheModel();

	@Override
	public ProcessStep toEscapedModel();

	@Override
	public ProcessStep toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}