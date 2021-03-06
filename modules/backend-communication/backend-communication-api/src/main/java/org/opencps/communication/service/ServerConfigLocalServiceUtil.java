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

package org.opencps.communication.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for ServerConfig. This utility wraps
 * {@link org.opencps.communication.service.impl.ServerConfigLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author khoavd
 * @see ServerConfigLocalService
 * @see org.opencps.communication.service.base.ServerConfigLocalServiceBaseImpl
 * @see org.opencps.communication.service.impl.ServerConfigLocalServiceImpl
 * @generated
 */
@ProviderType
public class ServerConfigLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.opencps.communication.service.impl.ServerConfigLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of server configs.
	*
	* @return the number of server configs
	*/
	public static int getServerConfigsCount() {
		return getService().getServerConfigsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.communication.model.impl.ServerConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.communication.model.impl.ServerConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	public static java.util.List<org.opencps.communication.model.ServerConfig> getByProtocol(
		long groupId, java.lang.String protocol) {
		return getService().getByProtocol(groupId, protocol);
	}

	public static java.util.List<org.opencps.communication.model.ServerConfig> getGroupId(
		long groupId) {
		return getService().getGroupId(groupId);
	}

	/**
	* Returns a range of all the server configs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.communication.model.impl.ServerConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of server configs
	* @param end the upper bound of the range of server configs (not inclusive)
	* @return the range of server configs
	*/
	public static java.util.List<org.opencps.communication.model.ServerConfig> getServerConfigs(
		int start, int end) {
		return getService().getServerConfigs(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	/**
	* Adds the server config to the database. Also notifies the appropriate model listeners.
	*
	* @param serverConfig the server config
	* @return the server config that was added
	*/
	public static org.opencps.communication.model.ServerConfig addServerConfig(
		org.opencps.communication.model.ServerConfig serverConfig) {
		return getService().addServerConfig(serverConfig);
	}

	/**
	* Creates a new server config with the primary key. Does not add the server config to the database.
	*
	* @param serverConfigId the primary key for the new server config
	* @return the new server config
	*/
	public static org.opencps.communication.model.ServerConfig createServerConfig(
		long serverConfigId) {
		return getService().createServerConfig(serverConfigId);
	}

	/**
	* Deletes the server config with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param serverConfigId the primary key of the server config
	* @return the server config that was removed
	* @throws PortalException if a server config with the primary key could not be found
	*/
	public static org.opencps.communication.model.ServerConfig deleteServerConfig(
		long serverConfigId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteServerConfig(serverConfigId);
	}

	/**
	* Deletes the server config from the database. Also notifies the appropriate model listeners.
	*
	* @param serverConfig the server config
	* @return the server config that was removed
	*/
	public static org.opencps.communication.model.ServerConfig deleteServerConfig(
		org.opencps.communication.model.ServerConfig serverConfig) {
		return getService().deleteServerConfig(serverConfig);
	}

	public static org.opencps.communication.model.ServerConfig fetchServerConfig(
		long serverConfigId) {
		return getService().fetchServerConfig(serverConfigId);
	}

	public static org.opencps.communication.model.ServerConfig getByCode(
		java.lang.String serverNo) {
		return getService().getByCode(serverNo);
	}

	/**
	* Returns the server config with the primary key.
	*
	* @param serverConfigId the primary key of the server config
	* @return the server config
	* @throws PortalException if a server config with the primary key could not be found
	*/
	public static org.opencps.communication.model.ServerConfig getServerConfig(
		long serverConfigId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getServerConfig(serverConfigId);
	}

	public static org.opencps.communication.model.ServerConfig updateLastSync(
		long serverConfigId, java.util.Date lastSync,
		com.liferay.portal.kernel.service.ServiceContext context)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().updateLastSync(serverConfigId, lastSync, context);
	}

	public static org.opencps.communication.model.ServerConfig updateServerConfig(
		long groupId, long serverConfigId, java.lang.String serverNo,
		java.lang.String serverName, java.lang.String protocol,
		java.lang.String configs, java.util.Date lastSync,
		com.liferay.portal.kernel.service.ServiceContext context)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateServerConfig(groupId, serverConfigId, serverNo,
			serverName, protocol, configs, lastSync, context);
	}

	/**
	* Updates the server config in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param serverConfig the server config
	* @return the server config that was updated
	*/
	public static org.opencps.communication.model.ServerConfig updateServerConfig(
		org.opencps.communication.model.ServerConfig serverConfig) {
		return getService().updateServerConfig(serverConfig);
	}

	public static ServerConfigLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ServerConfigLocalService, ServerConfigLocalService> _serviceTracker =
		ServiceTrackerFactory.open(ServerConfigLocalService.class);
}