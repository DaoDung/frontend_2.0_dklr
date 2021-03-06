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

package com.fds.vr.business.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the VRMigrateTask service. Represents a row in the &quot;vr_migrate_task&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.fds.vr.business.model.impl.VRMigrateTaskModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.fds.vr.business.model.impl.VRMigrateTaskImpl}.
 * </p>
 *
 * @author LamTV
 * @see VRMigrateTask
 * @see com.fds.vr.business.model.impl.VRMigrateTaskImpl
 * @see com.fds.vr.business.model.impl.VRMigrateTaskModelImpl
 * @generated
 */
@ProviderType
public interface VRMigrateTaskModel extends BaseModel<VRMigrateTask> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a vr migrate task model instance should use the {@link VRMigrateTask} interface instead.
	 */

	/**
	 * Returns the primary key of this vr migrate task.
	 *
	 * @return the primary key of this vr migrate task
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this vr migrate task.
	 *
	 * @param primaryKey the primary key of this vr migrate task
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the task_id of this vr migrate task.
	 *
	 * @return the task_id of this vr migrate task
	 */
	public long getTask_id();

	/**
	 * Sets the task_id of this vr migrate task.
	 *
	 * @param task_id the task_id of this vr migrate task
	 */
	public void setTask_id(long task_id);

	/**
	 * Returns the task_name of this vr migrate task.
	 *
	 * @return the task_name of this vr migrate task
	 */
	@AutoEscape
	public String getTask_name();

	/**
	 * Sets the task_name of this vr migrate task.
	 *
	 * @param task_name the task_name of this vr migrate task
	 */
	public void setTask_name(String task_name);

	/**
	 * Returns the task migration ID of this vr migrate task.
	 *
	 * @return the task migration ID of this vr migrate task
	 */
	public int getTaskMigrationID();

	/**
	 * Sets the task migration ID of this vr migrate task.
	 *
	 * @param taskMigrationID the task migration ID of this vr migrate task
	 */
	public void setTaskMigrationID(int taskMigrationID);

	/**
	 * Returns the source_config of this vr migrate task.
	 *
	 * @return the source_config of this vr migrate task
	 */
	@AutoEscape
	public String getSource_config();

	/**
	 * Sets the source_config of this vr migrate task.
	 *
	 * @param source_config the source_config of this vr migrate task
	 */
	public void setSource_config(String source_config);

	/**
	 * Returns the target_config of this vr migrate task.
	 *
	 * @return the target_config of this vr migrate task
	 */
	@AutoEscape
	public String getTarget_config();

	/**
	 * Sets the target_config of this vr migrate task.
	 *
	 * @param target_config the target_config of this vr migrate task
	 */
	public void setTarget_config(String target_config);

	/**
	 * Returns the remarks of this vr migrate task.
	 *
	 * @return the remarks of this vr migrate task
	 */
	@AutoEscape
	public String getRemarks();

	/**
	 * Sets the remarks of this vr migrate task.
	 *
	 * @param remarks the remarks of this vr migrate task
	 */
	public void setRemarks(String remarks);

	/**
	 * Returns the status of this vr migrate task.
	 *
	 * @return the status of this vr migrate task
	 */
	public int getStatus();

	/**
	 * Sets the status of this vr migrate task.
	 *
	 * @param status the status of this vr migrate task
	 */
	public void setStatus(int status);

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
	public int compareTo(VRMigrateTask vrMigrateTask);

	@Override
	public int hashCode();

	@Override
	public CacheModel<VRMigrateTask> toCacheModel();

	@Override
	public VRMigrateTask toEscapedModel();

	@Override
	public VRMigrateTask toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}