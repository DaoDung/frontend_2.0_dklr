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

import java.util.Date;

/**
 * The base model interface for the VRCertificateProgress service. Represents a row in the &quot;vr_certificate_progress&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.fds.vr.business.model.impl.VRCertificateProgressModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.fds.vr.business.model.impl.VRCertificateProgressImpl}.
 * </p>
 *
 * @author LamTV
 * @see VRCertificateProgress
 * @see com.fds.vr.business.model.impl.VRCertificateProgressImpl
 * @see com.fds.vr.business.model.impl.VRCertificateProgressModelImpl
 * @generated
 */
@ProviderType
public interface VRCertificateProgressModel extends BaseModel<VRCertificateProgress> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a vr certificate progress model instance should use the {@link VRCertificateProgress} interface instead.
	 */

	/**
	 * Returns the primary key of this vr certificate progress.
	 *
	 * @return the primary key of this vr certificate progress
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this vr certificate progress.
	 *
	 * @param primaryKey the primary key of this vr certificate progress
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this vr certificate progress.
	 *
	 * @return the ID of this vr certificate progress
	 */
	public long getId();

	/**
	 * Sets the ID of this vr certificate progress.
	 *
	 * @param id the ID of this vr certificate progress
	 */
	public void setId(long id);

	/**
	 * Returns the vehicle certificate ID of this vr certificate progress.
	 *
	 * @return the vehicle certificate ID of this vr certificate progress
	 */
	public long getVehicleCertificateId();

	/**
	 * Sets the vehicle certificate ID of this vr certificate progress.
	 *
	 * @param vehicleCertificateId the vehicle certificate ID of this vr certificate progress
	 */
	public void setVehicleCertificateId(long vehicleCertificateId);

	/**
	 * Returns the corporation ID of this vr certificate progress.
	 *
	 * @return the corporation ID of this vr certificate progress
	 */
	@AutoEscape
	public String getCorporationId();

	/**
	 * Sets the corporation ID of this vr certificate progress.
	 *
	 * @param corporationId the corporation ID of this vr certificate progress
	 */
	public void setCorporationId(String corporationId);

	/**
	 * Returns the inspector ID of this vr certificate progress.
	 *
	 * @return the inspector ID of this vr certificate progress
	 */
	public long getInspectorId();

	/**
	 * Sets the inspector ID of this vr certificate progress.
	 *
	 * @param inspectorId the inspector ID of this vr certificate progress
	 */
	public void setInspectorId(long inspectorId);

	/**
	 * Returns the action code of this vr certificate progress.
	 *
	 * @return the action code of this vr certificate progress
	 */
	@AutoEscape
	public String getActionCode();

	/**
	 * Sets the action code of this vr certificate progress.
	 *
	 * @param actionCode the action code of this vr certificate progress
	 */
	public void setActionCode(String actionCode);

	/**
	 * Returns the progress time of this vr certificate progress.
	 *
	 * @return the progress time of this vr certificate progress
	 */
	public Date getProgressTime();

	/**
	 * Sets the progress time of this vr certificate progress.
	 *
	 * @param progressTime the progress time of this vr certificate progress
	 */
	public void setProgressTime(Date progressTime);

	/**
	 * Returns the remarks of this vr certificate progress.
	 *
	 * @return the remarks of this vr certificate progress
	 */
	@AutoEscape
	public String getRemarks();

	/**
	 * Sets the remarks of this vr certificate progress.
	 *
	 * @param remarks the remarks of this vr certificate progress
	 */
	public void setRemarks(String remarks);

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
	public int compareTo(VRCertificateProgress vrCertificateProgress);

	@Override
	public int hashCode();

	@Override
	public CacheModel<VRCertificateProgress> toCacheModel();

	@Override
	public VRCertificateProgress toEscapedModel();

	@Override
	public VRCertificateProgress toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}