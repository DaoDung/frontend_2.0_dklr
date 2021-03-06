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

package org.opencps.usermgt.model;

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
 * The base model interface for the EmployeeJobPos service. Represents a row in the &quot;opencps_employee_jobpos&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.opencps.usermgt.model.impl.EmployeeJobPosModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.opencps.usermgt.model.impl.EmployeeJobPosImpl}.
 * </p>
 *
 * @author khoavu
 * @see EmployeeJobPos
 * @see org.opencps.usermgt.model.impl.EmployeeJobPosImpl
 * @see org.opencps.usermgt.model.impl.EmployeeJobPosModelImpl
 * @generated
 */
@ProviderType
public interface EmployeeJobPosModel extends BaseModel<EmployeeJobPos>,
	GroupedModel, ShardedModel, StagedAuditedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a employee job pos model instance should use the {@link EmployeeJobPos} interface instead.
	 */

	/**
	 * Returns the primary key of this employee job pos.
	 *
	 * @return the primary key of this employee job pos
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this employee job pos.
	 *
	 * @param primaryKey the primary key of this employee job pos
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this employee job pos.
	 *
	 * @return the uuid of this employee job pos
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this employee job pos.
	 *
	 * @param uuid the uuid of this employee job pos
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the employee job pos ID of this employee job pos.
	 *
	 * @return the employee job pos ID of this employee job pos
	 */
	public long getEmployeeJobPosId();

	/**
	 * Sets the employee job pos ID of this employee job pos.
	 *
	 * @param employeeJobPosId the employee job pos ID of this employee job pos
	 */
	public void setEmployeeJobPosId(long employeeJobPosId);

	/**
	 * Returns the company ID of this employee job pos.
	 *
	 * @return the company ID of this employee job pos
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this employee job pos.
	 *
	 * @param companyId the company ID of this employee job pos
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this employee job pos.
	 *
	 * @return the group ID of this employee job pos
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this employee job pos.
	 *
	 * @param groupId the group ID of this employee job pos
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this employee job pos.
	 *
	 * @return the user ID of this employee job pos
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this employee job pos.
	 *
	 * @param userId the user ID of this employee job pos
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this employee job pos.
	 *
	 * @return the user uuid of this employee job pos
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this employee job pos.
	 *
	 * @param userUuid the user uuid of this employee job pos
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this employee job pos.
	 *
	 * @return the user name of this employee job pos
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this employee job pos.
	 *
	 * @param userName the user name of this employee job pos
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this employee job pos.
	 *
	 * @return the create date of this employee job pos
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this employee job pos.
	 *
	 * @param createDate the create date of this employee job pos
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this employee job pos.
	 *
	 * @return the modified date of this employee job pos
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this employee job pos.
	 *
	 * @param modifiedDate the modified date of this employee job pos
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the employee ID of this employee job pos.
	 *
	 * @return the employee ID of this employee job pos
	 */
	public long getEmployeeId();

	/**
	 * Sets the employee ID of this employee job pos.
	 *
	 * @param employeeId the employee ID of this employee job pos
	 */
	public void setEmployeeId(long employeeId);

	/**
	 * Returns the job post ID of this employee job pos.
	 *
	 * @return the job post ID of this employee job pos
	 */
	public long getJobPostId();

	/**
	 * Sets the job post ID of this employee job pos.
	 *
	 * @param jobPostId the job post ID of this employee job pos
	 */
	public void setJobPostId(long jobPostId);

	/**
	 * Returns the working unit ID of this employee job pos.
	 *
	 * @return the working unit ID of this employee job pos
	 */
	public long getWorkingUnitId();

	/**
	 * Sets the working unit ID of this employee job pos.
	 *
	 * @param workingUnitId the working unit ID of this employee job pos
	 */
	public void setWorkingUnitId(long workingUnitId);

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
	public int compareTo(EmployeeJobPos employeeJobPos);

	@Override
	public int hashCode();

	@Override
	public CacheModel<EmployeeJobPos> toCacheModel();

	@Override
	public EmployeeJobPos toEscapedModel();

	@Override
	public EmployeeJobPos toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}