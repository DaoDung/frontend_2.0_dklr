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
 * The base model interface for the DossierStatistic service. Represents a row in the &quot;opencps_dossierstatistic&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.opencps.dossiermgt.model.impl.DossierStatisticModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.opencps.dossiermgt.model.impl.DossierStatisticImpl}.
 * </p>
 *
 * @author huymq
 * @see DossierStatistic
 * @see org.opencps.dossiermgt.model.impl.DossierStatisticImpl
 * @see org.opencps.dossiermgt.model.impl.DossierStatisticModelImpl
 * @generated
 */
@ProviderType
public interface DossierStatisticModel extends BaseModel<DossierStatistic>,
	GroupedModel, ShardedModel, StagedAuditedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a dossier statistic model instance should use the {@link DossierStatistic} interface instead.
	 */

	/**
	 * Returns the primary key of this dossier statistic.
	 *
	 * @return the primary key of this dossier statistic
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this dossier statistic.
	 *
	 * @param primaryKey the primary key of this dossier statistic
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this dossier statistic.
	 *
	 * @return the uuid of this dossier statistic
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this dossier statistic.
	 *
	 * @param uuid the uuid of this dossier statistic
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the dossier statistic ID of this dossier statistic.
	 *
	 * @return the dossier statistic ID of this dossier statistic
	 */
	public long getDossierStatisticId();

	/**
	 * Sets the dossier statistic ID of this dossier statistic.
	 *
	 * @param dossierStatisticId the dossier statistic ID of this dossier statistic
	 */
	public void setDossierStatisticId(long dossierStatisticId);

	/**
	 * Returns the company ID of this dossier statistic.
	 *
	 * @return the company ID of this dossier statistic
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this dossier statistic.
	 *
	 * @param companyId the company ID of this dossier statistic
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this dossier statistic.
	 *
	 * @return the group ID of this dossier statistic
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this dossier statistic.
	 *
	 * @param groupId the group ID of this dossier statistic
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this dossier statistic.
	 *
	 * @return the user ID of this dossier statistic
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this dossier statistic.
	 *
	 * @param userId the user ID of this dossier statistic
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this dossier statistic.
	 *
	 * @return the user uuid of this dossier statistic
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this dossier statistic.
	 *
	 * @param userUuid the user uuid of this dossier statistic
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this dossier statistic.
	 *
	 * @return the user name of this dossier statistic
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this dossier statistic.
	 *
	 * @param userName the user name of this dossier statistic
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this dossier statistic.
	 *
	 * @return the create date of this dossier statistic
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this dossier statistic.
	 *
	 * @param createDate the create date of this dossier statistic
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this dossier statistic.
	 *
	 * @return the modified date of this dossier statistic
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this dossier statistic.
	 *
	 * @param modifiedDate the modified date of this dossier statistic
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the month of this dossier statistic.
	 *
	 * @return the month of this dossier statistic
	 */
	public int getMonth();

	/**
	 * Sets the month of this dossier statistic.
	 *
	 * @param month the month of this dossier statistic
	 */
	public void setMonth(int month);

	/**
	 * Returns the year of this dossier statistic.
	 *
	 * @return the year of this dossier statistic
	 */
	public int getYear();

	/**
	 * Sets the year of this dossier statistic.
	 *
	 * @param year the year of this dossier statistic
	 */
	public void setYear(int year);

	/**
	 * Returns the remaining count of this dossier statistic.
	 *
	 * @return the remaining count of this dossier statistic
	 */
	public int getRemainingCount();

	/**
	 * Sets the remaining count of this dossier statistic.
	 *
	 * @param remainingCount the remaining count of this dossier statistic
	 */
	public void setRemainingCount(int remainingCount);

	/**
	 * Returns the received count of this dossier statistic.
	 *
	 * @return the received count of this dossier statistic
	 */
	public int getReceivedCount();

	/**
	 * Sets the received count of this dossier statistic.
	 *
	 * @param receivedCount the received count of this dossier statistic
	 */
	public void setReceivedCount(int receivedCount);

	/**
	 * Returns the online count of this dossier statistic.
	 *
	 * @return the online count of this dossier statistic
	 */
	public int getOnlineCount();

	/**
	 * Sets the online count of this dossier statistic.
	 *
	 * @param onlineCount the online count of this dossier statistic
	 */
	public void setOnlineCount(int onlineCount);

	/**
	 * Returns the undue count of this dossier statistic.
	 *
	 * @return the undue count of this dossier statistic
	 */
	public int getUndueCount();

	/**
	 * Sets the undue count of this dossier statistic.
	 *
	 * @param undueCount the undue count of this dossier statistic
	 */
	public void setUndueCount(int undueCount);

	/**
	 * Returns the overdue count of this dossier statistic.
	 *
	 * @return the overdue count of this dossier statistic
	 */
	public int getOverdueCount();

	/**
	 * Sets the overdue count of this dossier statistic.
	 *
	 * @param overdueCount the overdue count of this dossier statistic
	 */
	public void setOverdueCount(int overdueCount);

	/**
	 * Returns the ontime count of this dossier statistic.
	 *
	 * @return the ontime count of this dossier statistic
	 */
	public int getOntimeCount();

	/**
	 * Sets the ontime count of this dossier statistic.
	 *
	 * @param ontimeCount the ontime count of this dossier statistic
	 */
	public void setOntimeCount(int ontimeCount);

	/**
	 * Returns the overtime count of this dossier statistic.
	 *
	 * @return the overtime count of this dossier statistic
	 */
	public int getOvertimeCount();

	/**
	 * Sets the overtime count of this dossier statistic.
	 *
	 * @param overtimeCount the overtime count of this dossier statistic
	 */
	public void setOvertimeCount(int overtimeCount);

	/**
	 * Returns the gov agency code of this dossier statistic.
	 *
	 * @return the gov agency code of this dossier statistic
	 */
	@AutoEscape
	public String getGovAgencyCode();

	/**
	 * Sets the gov agency code of this dossier statistic.
	 *
	 * @param govAgencyCode the gov agency code of this dossier statistic
	 */
	public void setGovAgencyCode(String govAgencyCode);

	/**
	 * Returns the gov agency name of this dossier statistic.
	 *
	 * @return the gov agency name of this dossier statistic
	 */
	@AutoEscape
	public String getGovAgencyName();

	/**
	 * Sets the gov agency name of this dossier statistic.
	 *
	 * @param govAgencyName the gov agency name of this dossier statistic
	 */
	public void setGovAgencyName(String govAgencyName);

	/**
	 * Returns the domain code of this dossier statistic.
	 *
	 * @return the domain code of this dossier statistic
	 */
	@AutoEscape
	public String getDomainCode();

	/**
	 * Sets the domain code of this dossier statistic.
	 *
	 * @param domainCode the domain code of this dossier statistic
	 */
	public void setDomainCode(String domainCode);

	/**
	 * Returns the domain name of this dossier statistic.
	 *
	 * @return the domain name of this dossier statistic
	 */
	@AutoEscape
	public String getDomainName();

	/**
	 * Sets the domain name of this dossier statistic.
	 *
	 * @param domainName the domain name of this dossier statistic
	 */
	public void setDomainName(String domainName);

	/**
	 * Returns the administration level of this dossier statistic.
	 *
	 * @return the administration level of this dossier statistic
	 */
	public int getAdministrationLevel();

	/**
	 * Sets the administration level of this dossier statistic.
	 *
	 * @param administrationLevel the administration level of this dossier statistic
	 */
	public void setAdministrationLevel(int administrationLevel);

	/**
	 * Returns the reporting of this dossier statistic.
	 *
	 * @return the reporting of this dossier statistic
	 */
	public boolean getReporting();

	/**
	 * Returns <code>true</code> if this dossier statistic is reporting.
	 *
	 * @return <code>true</code> if this dossier statistic is reporting; <code>false</code> otherwise
	 */
	public boolean isReporting();

	/**
	 * Sets whether this dossier statistic is reporting.
	 *
	 * @param reporting the reporting of this dossier statistic
	 */
	public void setReporting(boolean reporting);

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
	public int compareTo(DossierStatistic dossierStatistic);

	@Override
	public int hashCode();

	@Override
	public CacheModel<DossierStatistic> toCacheModel();

	@Override
	public DossierStatistic toEscapedModel();

	@Override
	public DossierStatistic toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}