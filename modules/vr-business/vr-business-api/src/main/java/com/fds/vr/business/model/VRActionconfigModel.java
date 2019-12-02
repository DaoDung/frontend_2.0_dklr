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
 * The base model interface for the VRActionconfig service. Represents a row in the &quot;vr_actionconfig&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.fds.vr.business.model.impl.VRActionconfigModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.fds.vr.business.model.impl.VRActionconfigImpl}.
 * </p>
 *
 * @author LamTV
 * @see VRActionconfig
 * @see com.fds.vr.business.model.impl.VRActionconfigImpl
 * @see com.fds.vr.business.model.impl.VRActionconfigModelImpl
 * @generated
 */
@ProviderType
public interface VRActionconfigModel extends BaseModel<VRActionconfig> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a vr actionconfig model instance should use the {@link VRActionconfig} interface instead.
	 */

	/**
	 * Returns the primary key of this vr actionconfig.
	 *
	 * @return the primary key of this vr actionconfig
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this vr actionconfig.
	 *
	 * @param primaryKey the primary key of this vr actionconfig
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this vr actionconfig.
	 *
	 * @return the ID of this vr actionconfig
	 */
	public long getId();

	/**
	 * Sets the ID of this vr actionconfig.
	 *
	 * @param id the ID of this vr actionconfig
	 */
	public void setId(long id);

	/**
	 * Returns the action code of this vr actionconfig.
	 *
	 * @return the action code of this vr actionconfig
	 */
	@AutoEscape
	public String getActionCode();

	/**
	 * Sets the action code of this vr actionconfig.
	 *
	 * @param actionCode the action code of this vr actionconfig
	 */
	public void setActionCode(String actionCode);

	/**
	 * Returns the process no of this vr actionconfig.
	 *
	 * @return the process no of this vr actionconfig
	 */
	@AutoEscape
	public String getProcessNo();

	/**
	 * Sets the process no of this vr actionconfig.
	 *
	 * @param processNo the process no of this vr actionconfig
	 */
	public void setProcessNo(String processNo);

	/**
	 * Returns the status of this vr actionconfig.
	 *
	 * @return the status of this vr actionconfig
	 */
	public int getStatus();

	/**
	 * Sets the status of this vr actionconfig.
	 *
	 * @param status the status of this vr actionconfig
	 */
	public void setStatus(int status);

	/**
	 * Returns the vehicle class of this vr actionconfig.
	 *
	 * @return the vehicle class of this vr actionconfig
	 */
	@AutoEscape
	public String getVehicleClass();

	/**
	 * Sets the vehicle class of this vr actionconfig.
	 *
	 * @param vehicleClass the vehicle class of this vr actionconfig
	 */
	public void setVehicleClass(String vehicleClass);

	/**
	 * Returns the file template no of this vr actionconfig.
	 *
	 * @return the file template no of this vr actionconfig
	 */
	@AutoEscape
	public String getFileTemplateNo();

	/**
	 * Sets the file template no of this vr actionconfig.
	 *
	 * @param fileTemplateNo the file template no of this vr actionconfig
	 */
	public void setFileTemplateNo(String fileTemplateNo);

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
	public int compareTo(VRActionconfig vrActionconfig);

	@Override
	public int hashCode();

	@Override
	public CacheModel<VRActionconfig> toCacheModel();

	@Override
	public VRActionconfig toEscapedModel();

	@Override
	public VRActionconfig toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}