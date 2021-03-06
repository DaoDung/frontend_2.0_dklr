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

package org.opencps.dossiermgt.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RegistrationLogLocalService}.
 *
 * @author huymq
 * @see RegistrationLogLocalService
 * @generated
 */
@ProviderType
public class RegistrationLogLocalServiceWrapper
	implements RegistrationLogLocalService,
		ServiceWrapper<RegistrationLogLocalService> {
	public RegistrationLogLocalServiceWrapper(
		RegistrationLogLocalService registrationLogLocalService) {
		_registrationLogLocalService = registrationLogLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _registrationLogLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _registrationLogLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _registrationLogLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _registrationLogLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _registrationLogLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _registrationLogLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.search.Hits searchLucene(
		java.util.LinkedHashMap<java.lang.String, java.lang.Object> params,
		com.liferay.portal.kernel.search.Sort[] sorts, int start, int end,
		com.liferay.portal.kernel.search.SearchContext searchContext)
		throws com.liferay.portal.kernel.search.ParseException,
			com.liferay.portal.kernel.search.SearchException {
		return _registrationLogLocalService.searchLucene(params, sorts, start,
			end, searchContext);
	}

	/**
	* Returns the number of registration logs.
	*
	* @return the number of registration logs
	*/
	@Override
	public int getRegistrationLogsCount() {
		return _registrationLogLocalService.getRegistrationLogsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _registrationLogLocalService.getOSGiServiceIdentifier();
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
		return _registrationLogLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.RegistrationLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _registrationLogLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.RegistrationLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _registrationLogLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	@Override
	public java.util.List<org.opencps.dossiermgt.model.RegistrationLog> getRegistrationLogbyRegId(
		long groupId, long registrationId) {
		return _registrationLogLocalService.getRegistrationLogbyRegId(groupId,
			registrationId);
	}

	/**
	* Returns a range of all the registration logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.RegistrationLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of registration logs
	* @param end the upper bound of the range of registration logs (not inclusive)
	* @return the range of registration logs
	*/
	@Override
	public java.util.List<org.opencps.dossiermgt.model.RegistrationLog> getRegistrationLogs(
		int start, int end) {
		return _registrationLogLocalService.getRegistrationLogs(start, end);
	}

	/**
	* Returns all the registration logs matching the UUID and company.
	*
	* @param uuid the UUID of the registration logs
	* @param companyId the primary key of the company
	* @return the matching registration logs, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<org.opencps.dossiermgt.model.RegistrationLog> getRegistrationLogsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _registrationLogLocalService.getRegistrationLogsByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns a range of registration logs matching the UUID and company.
	*
	* @param uuid the UUID of the registration logs
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of registration logs
	* @param end the upper bound of the range of registration logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching registration logs, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<org.opencps.dossiermgt.model.RegistrationLog> getRegistrationLogsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<org.opencps.dossiermgt.model.RegistrationLog> orderByComparator) {
		return _registrationLogLocalService.getRegistrationLogsByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	@Override
	public long countLucense(
		java.util.LinkedHashMap<java.lang.String, java.lang.Object> params,
		com.liferay.portal.kernel.search.Sort[] sorts, int start, int end,
		com.liferay.portal.kernel.search.SearchContext searchContext)
		throws com.liferay.portal.kernel.search.ParseException,
			com.liferay.portal.kernel.search.SearchException {
		return _registrationLogLocalService.countLucense(params, sorts, start,
			end, searchContext);
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
		return _registrationLogLocalService.dynamicQueryCount(dynamicQuery);
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
		return _registrationLogLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.opencps.dossiermgt.model.RegistrationLog addLog(
		java.lang.String author, long groupId, long userId,
		long registrationId, java.lang.String content, java.lang.String payload) {
		return _registrationLogLocalService.addLog(author, groupId, userId,
			registrationId, content, payload);
	}

	/**
	* Adds the registration log to the database. Also notifies the appropriate model listeners.
	*
	* @param registrationLog the registration log
	* @return the registration log that was added
	*/
	@Override
	public org.opencps.dossiermgt.model.RegistrationLog addRegistrationLog(
		org.opencps.dossiermgt.model.RegistrationLog registrationLog) {
		return _registrationLogLocalService.addRegistrationLog(registrationLog);
	}

	/**
	* Creates a new registration log with the primary key. Does not add the registration log to the database.
	*
	* @param registrationLogId the primary key for the new registration log
	* @return the new registration log
	*/
	@Override
	public org.opencps.dossiermgt.model.RegistrationLog createRegistrationLog(
		long registrationLogId) {
		return _registrationLogLocalService.createRegistrationLog(registrationLogId);
	}

	/**
	* Deletes the registration log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param registrationLogId the primary key of the registration log
	* @return the registration log that was removed
	* @throws PortalException if a registration log with the primary key could not be found
	*/
	@Override
	public org.opencps.dossiermgt.model.RegistrationLog deleteRegistrationLog(
		long registrationLogId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _registrationLogLocalService.deleteRegistrationLog(registrationLogId);
	}

	/**
	* Deletes the registration log from the database. Also notifies the appropriate model listeners.
	*
	* @param registrationLog the registration log
	* @return the registration log that was removed
	*/
	@Override
	public org.opencps.dossiermgt.model.RegistrationLog deleteRegistrationLog(
		org.opencps.dossiermgt.model.RegistrationLog registrationLog) {
		return _registrationLogLocalService.deleteRegistrationLog(registrationLog);
	}

	@Override
	public org.opencps.dossiermgt.model.RegistrationLog fetchRegistrationLog(
		long registrationLogId) {
		return _registrationLogLocalService.fetchRegistrationLog(registrationLogId);
	}

	/**
	* Returns the registration log matching the UUID and group.
	*
	* @param uuid the registration log's UUID
	* @param groupId the primary key of the group
	* @return the matching registration log, or <code>null</code> if a matching registration log could not be found
	*/
	@Override
	public org.opencps.dossiermgt.model.RegistrationLog fetchRegistrationLogByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _registrationLogLocalService.fetchRegistrationLogByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the registration log with the primary key.
	*
	* @param registrationLogId the primary key of the registration log
	* @return the registration log
	* @throws PortalException if a registration log with the primary key could not be found
	*/
	@Override
	public org.opencps.dossiermgt.model.RegistrationLog getRegistrationLog(
		long registrationLogId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _registrationLogLocalService.getRegistrationLog(registrationLogId);
	}

	/**
	* Returns the registration log matching the UUID and group.
	*
	* @param uuid the registration log's UUID
	* @param groupId the primary key of the group
	* @return the matching registration log
	* @throws PortalException if a matching registration log could not be found
	*/
	@Override
	public org.opencps.dossiermgt.model.RegistrationLog getRegistrationLogByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _registrationLogLocalService.getRegistrationLogByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Updates the registration log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param registrationLog the registration log
	* @return the registration log that was updated
	*/
	@Override
	public org.opencps.dossiermgt.model.RegistrationLog updateRegistrationLog(
		org.opencps.dossiermgt.model.RegistrationLog registrationLog) {
		return _registrationLogLocalService.updateRegistrationLog(registrationLog);
	}

	@Override
	public RegistrationLogLocalService getWrappedService() {
		return _registrationLogLocalService;
	}

	@Override
	public void setWrappedService(
		RegistrationLogLocalService registrationLogLocalService) {
		_registrationLogLocalService = registrationLogLocalService;
	}

	private RegistrationLogLocalService _registrationLogLocalService;
}