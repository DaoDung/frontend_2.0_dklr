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
 * The base model interface for the Employee service. Represents a row in the &quot;opencps_employee&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.opencps.usermgt.model.impl.EmployeeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.opencps.usermgt.model.impl.EmployeeImpl}.
 * </p>
 *
 * @author khoavu
 * @see Employee
 * @see org.opencps.usermgt.model.impl.EmployeeImpl
 * @see org.opencps.usermgt.model.impl.EmployeeModelImpl
 * @generated
 */
@ProviderType
public interface EmployeeModel extends BaseModel<Employee>, GroupedModel,
	ShardedModel, StagedAuditedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a employee model instance should use the {@link Employee} interface instead.
	 */

	/**
	 * Returns the primary key of this employee.
	 *
	 * @return the primary key of this employee
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this employee.
	 *
	 * @param primaryKey the primary key of this employee
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this employee.
	 *
	 * @return the uuid of this employee
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this employee.
	 *
	 * @param uuid the uuid of this employee
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the employee ID of this employee.
	 *
	 * @return the employee ID of this employee
	 */
	public long getEmployeeId();

	/**
	 * Sets the employee ID of this employee.
	 *
	 * @param employeeId the employee ID of this employee
	 */
	public void setEmployeeId(long employeeId);

	/**
	 * Returns the company ID of this employee.
	 *
	 * @return the company ID of this employee
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this employee.
	 *
	 * @param companyId the company ID of this employee
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this employee.
	 *
	 * @return the group ID of this employee
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this employee.
	 *
	 * @param groupId the group ID of this employee
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this employee.
	 *
	 * @return the user ID of this employee
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this employee.
	 *
	 * @param userId the user ID of this employee
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this employee.
	 *
	 * @return the user uuid of this employee
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this employee.
	 *
	 * @param userUuid the user uuid of this employee
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this employee.
	 *
	 * @return the user name of this employee
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this employee.
	 *
	 * @param userName the user name of this employee
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this employee.
	 *
	 * @return the create date of this employee
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this employee.
	 *
	 * @param createDate the create date of this employee
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this employee.
	 *
	 * @return the modified date of this employee
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this employee.
	 *
	 * @param modifiedDate the modified date of this employee
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the employee no of this employee.
	 *
	 * @return the employee no of this employee
	 */
	@AutoEscape
	public String getEmployeeNo();

	/**
	 * Sets the employee no of this employee.
	 *
	 * @param employeeNo the employee no of this employee
	 */
	public void setEmployeeNo(String employeeNo);

	/**
	 * Returns the full name of this employee.
	 *
	 * @return the full name of this employee
	 */
	@AutoEscape
	public String getFullName();

	/**
	 * Sets the full name of this employee.
	 *
	 * @param fullName the full name of this employee
	 */
	public void setFullName(String fullName);

	/**
	 * Returns the title of this employee.
	 *
	 * @return the title of this employee
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this employee.
	 *
	 * @param title the title of this employee
	 */
	public void setTitle(String title);

	/**
	 * Returns the gender of this employee.
	 *
	 * @return the gender of this employee
	 */
	public int getGender();

	/**
	 * Sets the gender of this employee.
	 *
	 * @param gender the gender of this employee
	 */
	public void setGender(int gender);

	/**
	 * Returns the birthdate of this employee.
	 *
	 * @return the birthdate of this employee
	 */
	public Date getBirthdate();

	/**
	 * Sets the birthdate of this employee.
	 *
	 * @param birthdate the birthdate of this employee
	 */
	public void setBirthdate(Date birthdate);

	/**
	 * Returns the tel no of this employee.
	 *
	 * @return the tel no of this employee
	 */
	@AutoEscape
	public String getTelNo();

	/**
	 * Sets the tel no of this employee.
	 *
	 * @param telNo the tel no of this employee
	 */
	public void setTelNo(String telNo);

	/**
	 * Returns the mobile of this employee.
	 *
	 * @return the mobile of this employee
	 */
	@AutoEscape
	public String getMobile();

	/**
	 * Sets the mobile of this employee.
	 *
	 * @param mobile the mobile of this employee
	 */
	public void setMobile(String mobile);

	/**
	 * Returns the email of this employee.
	 *
	 * @return the email of this employee
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this employee.
	 *
	 * @param email the email of this employee
	 */
	public void setEmail(String email);

	/**
	 * Returns the working status of this employee.
	 *
	 * @return the working status of this employee
	 */
	public int getWorkingStatus();

	/**
	 * Sets the working status of this employee.
	 *
	 * @param workingStatus the working status of this employee
	 */
	public void setWorkingStatus(int workingStatus);

	/**
	 * Returns the mapping user ID of this employee.
	 *
	 * @return the mapping user ID of this employee
	 */
	public long getMappingUserId();

	/**
	 * Sets the mapping user ID of this employee.
	 *
	 * @param mappingUserId the mapping user ID of this employee
	 */
	public void setMappingUserId(long mappingUserId);

	/**
	 * Returns the mapping user uuid of this employee.
	 *
	 * @return the mapping user uuid of this employee
	 */
	public String getMappingUserUuid();

	/**
	 * Sets the mapping user uuid of this employee.
	 *
	 * @param mappingUserUuid the mapping user uuid of this employee
	 */
	public void setMappingUserUuid(String mappingUserUuid);

	/**
	 * Returns the main job post ID of this employee.
	 *
	 * @return the main job post ID of this employee
	 */
	public long getMainJobPostId();

	/**
	 * Sets the main job post ID of this employee.
	 *
	 * @param mainJobPostId the main job post ID of this employee
	 */
	public void setMainJobPostId(long mainJobPostId);

	/**
	 * Returns the photo file entry ID of this employee.
	 *
	 * @return the photo file entry ID of this employee
	 */
	public long getPhotoFileEntryId();

	/**
	 * Sets the photo file entry ID of this employee.
	 *
	 * @param photoFileEntryId the photo file entry ID of this employee
	 */
	public void setPhotoFileEntryId(long photoFileEntryId);

	/**
	 * Returns the recruit date of this employee.
	 *
	 * @return the recruit date of this employee
	 */
	public Date getRecruitDate();

	/**
	 * Sets the recruit date of this employee.
	 *
	 * @param recruitDate the recruit date of this employee
	 */
	public void setRecruitDate(Date recruitDate);

	/**
	 * Returns the leave date of this employee.
	 *
	 * @return the leave date of this employee
	 */
	public Date getLeaveDate();

	/**
	 * Sets the leave date of this employee.
	 *
	 * @param leaveDate the leave date of this employee
	 */
	public void setLeaveDate(Date leaveDate);

	/**
	 * Returns the file cert ID of this employee.
	 *
	 * @return the file cert ID of this employee
	 */
	public long getFileCertId();

	/**
	 * Sets the file cert ID of this employee.
	 *
	 * @param fileCertId the file cert ID of this employee
	 */
	public void setFileCertId(long fileCertId);

	/**
	 * Returns the file sign ID of this employee.
	 *
	 * @return the file sign ID of this employee
	 */
	public long getFileSignId();

	/**
	 * Sets the file sign ID of this employee.
	 *
	 * @param fileSignId the file sign ID of this employee
	 */
	public void setFileSignId(long fileSignId);

	/**
	 * Returns the file cert path of this employee.
	 *
	 * @return the file cert path of this employee
	 */
	@AutoEscape
	public String getFileCertPath();

	/**
	 * Sets the file cert path of this employee.
	 *
	 * @param fileCertPath the file cert path of this employee
	 */
	public void setFileCertPath(String fileCertPath);

	/**
	 * Returns the file sign path of this employee.
	 *
	 * @return the file sign path of this employee
	 */
	@AutoEscape
	public String getFileSignPath();

	/**
	 * Sets the file sign path of this employee.
	 *
	 * @param fileSignPath the file sign path of this employee
	 */
	public void setFileSignPath(String fileSignPath);

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
	public int compareTo(Employee employee);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Employee> toCacheModel();

	@Override
	public Employee toEscapedModel();

	@Override
	public Employee toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}