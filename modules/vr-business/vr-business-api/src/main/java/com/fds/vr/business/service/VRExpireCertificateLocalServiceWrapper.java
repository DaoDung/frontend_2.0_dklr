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
 * Provides a wrapper for {@link VRExpireCertificateLocalService}.
 *
 * @author LamTV
 * @see VRExpireCertificateLocalService
 * @generated
 */
@ProviderType
public class VRExpireCertificateLocalServiceWrapper
	implements VRExpireCertificateLocalService,
		ServiceWrapper<VRExpireCertificateLocalService> {
	public VRExpireCertificateLocalServiceWrapper(
		VRExpireCertificateLocalService vrExpireCertificateLocalService) {
		_vrExpireCertificateLocalService = vrExpireCertificateLocalService;
	}

	/**
	* Adds the vr expire certificate to the database. Also notifies the appropriate model listeners.
	*
	* @param vrExpireCertificate the vr expire certificate
	* @return the vr expire certificate that was added
	*/
	@Override
	public com.fds.vr.business.model.VRExpireCertificate addVRExpireCertificate(
		com.fds.vr.business.model.VRExpireCertificate vrExpireCertificate) {
		return _vrExpireCertificateLocalService.addVRExpireCertificate(vrExpireCertificate);
	}

	/**
	* Creates a new vr expire certificate with the primary key. Does not add the vr expire certificate to the database.
	*
	* @param id the primary key for the new vr expire certificate
	* @return the new vr expire certificate
	*/
	@Override
	public com.fds.vr.business.model.VRExpireCertificate createVRExpireCertificate(
		long id) {
		return _vrExpireCertificateLocalService.createVRExpireCertificate(id);
	}

	/**
	* Deletes the vr expire certificate from the database. Also notifies the appropriate model listeners.
	*
	* @param vrExpireCertificate the vr expire certificate
	* @return the vr expire certificate that was removed
	*/
	@Override
	public com.fds.vr.business.model.VRExpireCertificate deleteVRExpireCertificate(
		com.fds.vr.business.model.VRExpireCertificate vrExpireCertificate) {
		return _vrExpireCertificateLocalService.deleteVRExpireCertificate(vrExpireCertificate);
	}

	/**
	* Deletes the vr expire certificate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the vr expire certificate
	* @return the vr expire certificate that was removed
	* @throws PortalException if a vr expire certificate with the primary key could not be found
	*/
	@Override
	public com.fds.vr.business.model.VRExpireCertificate deleteVRExpireCertificate(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return _vrExpireCertificateLocalService.deleteVRExpireCertificate(id);
	}

	@Override
	public com.fds.vr.business.model.VRExpireCertificate fetchVRExpireCertificate(
		long id) {
		return _vrExpireCertificateLocalService.fetchVRExpireCertificate(id);
	}

	/**
	* Returns the vr expire certificate with the primary key.
	*
	* @param id the primary key of the vr expire certificate
	* @return the vr expire certificate
	* @throws PortalException if a vr expire certificate with the primary key could not be found
	*/
	@Override
	public com.fds.vr.business.model.VRExpireCertificate getVRExpireCertificate(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return _vrExpireCertificateLocalService.getVRExpireCertificate(id);
	}

	/**
	* Updates the vr expire certificate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vrExpireCertificate the vr expire certificate
	* @return the vr expire certificate that was updated
	*/
	@Override
	public com.fds.vr.business.model.VRExpireCertificate updateVRExpireCertificate(
		com.fds.vr.business.model.VRExpireCertificate vrExpireCertificate) {
		return _vrExpireCertificateLocalService.updateVRExpireCertificate(vrExpireCertificate);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _vrExpireCertificateLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _vrExpireCertificateLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _vrExpireCertificateLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _vrExpireCertificateLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _vrExpireCertificateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of vr expire certificates.
	*
	* @return the number of vr expire certificates
	*/
	@Override
	public int getVRExpireCertificatesCount() {
		return _vrExpireCertificateLocalService.getVRExpireCertificatesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _vrExpireCertificateLocalService.getOSGiServiceIdentifier();
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
		return _vrExpireCertificateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fds.vr.business.model.impl.VRExpireCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vrExpireCertificateLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fds.vr.business.model.impl.VRExpireCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vrExpireCertificateLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns a range of all the vr expire certificates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fds.vr.business.model.impl.VRExpireCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vr expire certificates
	* @param end the upper bound of the range of vr expire certificates (not inclusive)
	* @return the range of vr expire certificates
	*/
	@Override
	public java.util.List<com.fds.vr.business.model.VRExpireCertificate> getVRExpireCertificates(
		int start, int end) {
		return _vrExpireCertificateLocalService.getVRExpireCertificates(start,
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
		return _vrExpireCertificateLocalService.dynamicQueryCount(dynamicQuery);
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
		return _vrExpireCertificateLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public VRExpireCertificateLocalService getWrappedService() {
		return _vrExpireCertificateLocalService;
	}

	@Override
	public void setWrappedService(
		VRExpireCertificateLocalService vrExpireCertificateLocalService) {
		_vrExpireCertificateLocalService = vrExpireCertificateLocalService;
	}

	private VRExpireCertificateLocalService _vrExpireCertificateLocalService;
}