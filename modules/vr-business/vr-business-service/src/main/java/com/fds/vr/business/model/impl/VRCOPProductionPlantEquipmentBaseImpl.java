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

package com.fds.vr.business.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.fds.vr.business.model.VRCOPProductionPlantEquipment;
import com.fds.vr.business.service.VRCOPProductionPlantEquipmentLocalServiceUtil;

/**
 * The extended model base implementation for the VRCOPProductionPlantEquipment service. Represents a row in the &quot;vr_copproductionplantequipment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VRCOPProductionPlantEquipmentImpl}.
 * </p>
 *
 * @author LamTV
 * @see VRCOPProductionPlantEquipmentImpl
 * @see VRCOPProductionPlantEquipment
 * @generated
 */
@ProviderType
public abstract class VRCOPProductionPlantEquipmentBaseImpl
	extends VRCOPProductionPlantEquipmentModelImpl
	implements VRCOPProductionPlantEquipment {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a vrcop production plant equipment model instance should use the {@link VRCOPProductionPlantEquipment} interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			VRCOPProductionPlantEquipmentLocalServiceUtil.addVRCOPProductionPlantEquipment(this);
		}
		else {
			VRCOPProductionPlantEquipmentLocalServiceUtil.updateVRCOPProductionPlantEquipment(this);
		}
	}
}