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

package com.fds.vr.business.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link VRCOPProductClassificationLocalService}.
 *
 * @author LamTV
 * @see VRCOPProductClassificationLocalService
 * @generated
 */
@ProviderType
public class VRCOPProductClassificationLocalServiceWrapper
	implements VRCOPProductClassificationLocalService,
		ServiceWrapper<VRCOPProductClassificationLocalService> {
	public VRCOPProductClassificationLocalServiceWrapper(
		VRCOPProductClassificationLocalService vrcopProductClassificationLocalService) {
		_vrcopProductClassificationLocalService = vrcopProductClassificationLocalService;
	}

	/**
	* Adds the vrcop product classification to the database. Also notifies the appropriate model listeners.
	*
	* @param vrcopProductClassification the vrcop product classification
	* @return the vrcop product classification that was added
	*/
	@Override
	public com.fds.vr.business.model.VRCOPProductClassification addVRCOPProductClassification(
		com.fds.vr.business.model.VRCOPProductClassification vrcopProductClassification) {
		return _vrcopProductClassificationLocalService.addVRCOPProductClassification(vrcopProductClassification);
	}

	/**
	* Creates a new vrcop product classification with the primary key. Does not add the vrcop product classification to the database.
	*
	* @param id the primary key for the new vrcop product classification
	* @return the new vrcop product classification
	*/
	@Override
	public com.fds.vr.business.model.VRCOPProductClassification createVRCOPProductClassification(
		long id) {
		return _vrcopProductClassificationLocalService.createVRCOPProductClassification(id);
	}

	/**
	* Deletes the vrcop product classification from the database. Also notifies the appropriate model listeners.
	*
	* @param vrcopProductClassification the vrcop product classification
	* @return the vrcop product classification that was removed
	*/
	@Override
	public com.fds.vr.business.model.VRCOPProductClassification deleteVRCOPProductClassification(
		com.fds.vr.business.model.VRCOPProductClassification vrcopProductClassification) {
		return _vrcopProductClassificationLocalService.deleteVRCOPProductClassification(vrcopProductClassification);
	}

	/**
	* Deletes the vrcop product classification with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the vrcop product classification
	* @return the vrcop product classification that was removed
	* @throws PortalException if a vrcop product classification with the primary key could not be found
	*/
	@Override
	public com.fds.vr.business.model.VRCOPProductClassification deleteVRCOPProductClassification(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return _vrcopProductClassificationLocalService.deleteVRCOPProductClassification(id);
	}

	@Override
	public com.fds.vr.business.model.VRCOPProductClassification fetchVRCOPProductClassification(
		long id) {
		return _vrcopProductClassificationLocalService.fetchVRCOPProductClassification(id);
	}

	/**
	* Returns the vrcop product classification with the primary key.
	*
	* @param id the primary key of the vrcop product classification
	* @return the vrcop product classification
	* @throws PortalException if a vrcop product classification with the primary key could not be found
	*/
	@Override
	public com.fds.vr.business.model.VRCOPProductClassification getVRCOPProductClassification(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return _vrcopProductClassificationLocalService.getVRCOPProductClassification(id);
	}

	@Override
	public com.fds.vr.business.model.VRCOPProductClassification updateCOPProductClassification(
		java.util.LinkedHashMap<java.lang.String, java.lang.String> mapValues) {
		return _vrcopProductClassificationLocalService.updateCOPProductClassification(mapValues);
	}

	/**
	* Updates the vrcop product classification in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vrcopProductClassification the vrcop product classification
	* @return the vrcop product classification that was updated
	*/
	@Override
	public com.fds.vr.business.model.VRCOPProductClassification updateVRCOPProductClassification(
		com.fds.vr.business.model.VRCOPProductClassification vrcopProductClassification) {
		return _vrcopProductClassificationLocalService.updateVRCOPProductClassification(vrcopProductClassification);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _vrcopProductClassificationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _vrcopProductClassificationLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _vrcopProductClassificationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _vrcopProductClassificationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _vrcopProductClassificationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of vrcop product classifications.
	*
	* @return the number of vrcop product classifications
	*/
	@Override
	public int getVRCOPProductClassificationsCount() {
		return _vrcopProductClassificationLocalService.getVRCOPProductClassificationsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _vrcopProductClassificationLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _vrcopProductClassificationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fds.vr.business.model.impl.VRCOPProductClassificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _vrcopProductClassificationLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fds.vr.business.model.impl.VRCOPProductClassificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _vrcopProductClassificationLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.fds.vr.business.model.VRCOPProductClassification> findBycopReportNo(
		long mtCore, java.lang.String copReportNo)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vrcopProductClassificationLocalService.findBycopReportNo(mtCore,
			copReportNo);
	}

	@Override
	public java.util.List<com.fds.vr.business.model.VRCOPProductClassification> findBycopReportRepositoryID(
		long mtCore, long copReportRepositoryID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vrcopProductClassificationLocalService.findBycopReportRepositoryID(mtCore,
			copReportRepositoryID);
	}

	/**
	* Returns a range of all the vrcop product classifications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fds.vr.business.model.impl.VRCOPProductClassificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vrcop product classifications
	* @param end the upper bound of the range of vrcop product classifications (not inclusive)
	* @return the range of vrcop product classifications
	*/
	@Override
	public java.util.List<com.fds.vr.business.model.VRCOPProductClassification> getVRCOPProductClassifications(
		int start, int end) {
		return _vrcopProductClassificationLocalService.getVRCOPProductClassifications(start,
			end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _vrcopProductClassificationLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _vrcopProductClassificationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public VRCOPProductClassificationLocalService getWrappedService() {
		return _vrcopProductClassificationLocalService;
	}

	@Override
	public void setWrappedService(
		VRCOPProductClassificationLocalService vrcopProductClassificationLocalService) {
		_vrcopProductClassificationLocalService = vrcopProductClassificationLocalService;
	}

	private VRCOPProductClassificationLocalService _vrcopProductClassificationLocalService;
}