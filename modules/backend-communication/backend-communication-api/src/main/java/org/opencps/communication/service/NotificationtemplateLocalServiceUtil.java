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
 * Provides the local service utility for Notificationtemplate. This utility wraps
 * {@link org.opencps.communication.service.impl.NotificationtemplateLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author khoavd
 * @see NotificationtemplateLocalService
 * @see org.opencps.communication.service.base.NotificationtemplateLocalServiceBaseImpl
 * @see org.opencps.communication.service.impl.NotificationtemplateLocalServiceImpl
 * @generated
 */
@ProviderType
public class NotificationtemplateLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.opencps.communication.service.impl.NotificationtemplateLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static boolean initTemplate(long groupId) {
		return getService().initTemplate(groupId);
	}

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

	public static com.liferay.portal.kernel.search.Hits luceneSearchEngine(
		java.util.LinkedHashMap<java.lang.String, java.lang.Object> params,
		com.liferay.portal.kernel.search.Sort[] sorts, int start, int end,
		com.liferay.portal.kernel.search.SearchContext searchContext)
		throws com.liferay.portal.kernel.search.ParseException,
			com.liferay.portal.kernel.search.SearchException {
		return getService()
				   .luceneSearchEngine(params, sorts, start, end, searchContext);
	}

	/**
	* Returns the number of notificationtemplates.
	*
	* @return the number of notificationtemplates
	*/
	public static int getNotificationtemplatesCount() {
		return getService().getNotificationtemplatesCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.communication.model.impl.NotificationtemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.communication.model.impl.NotificationtemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<org.opencps.communication.model.Notificationtemplate> findByF_NotificationtemplateByGroup(
		long groupId) {
		return getService().findByF_NotificationtemplateByGroup(groupId);
	}

	/**
	* Returns a range of all the notificationtemplates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.communication.model.impl.NotificationtemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of notificationtemplates
	* @param end the upper bound of the range of notificationtemplates (not inclusive)
	* @return the range of notificationtemplates
	*/
	public static java.util.List<org.opencps.communication.model.Notificationtemplate> getNotificationtemplates(
		int start, int end) {
		return getService().getNotificationtemplates(start, end);
	}

	public static long countLuceneSearchEngine(
		java.util.LinkedHashMap<java.lang.String, java.lang.Object> params,
		com.liferay.portal.kernel.search.SearchContext searchContext)
		throws com.liferay.portal.kernel.search.ParseException,
			com.liferay.portal.kernel.search.SearchException {
		return getService().countLuceneSearchEngine(params, searchContext);
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

	public static org.opencps.communication.model.Notificationtemplate addNotificationTemplate(
		long userId, long groupId, java.lang.String notificationType,
		java.lang.String emailSubject, java.lang.String emailBody,
		java.lang.String textMessage, boolean sendSMS, boolean sendEmail,
		java.lang.String userUrlPattern, java.lang.String guestUrlPattern,
		java.lang.String interval, boolean grouping,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws backend.auth.api.exception.UnauthenticationException,
			backend.auth.api.exception.UnauthorizationException,
			com.liferay.asset.kernel.exception.DuplicateCategoryException,
			com.liferay.portal.kernel.exception.NoSuchUserException {
		return getService()
				   .addNotificationTemplate(userId, groupId, notificationType,
			emailSubject, emailBody, textMessage, sendSMS, sendEmail,
			userUrlPattern, guestUrlPattern, interval, grouping, serviceContext);
	}

	/**
	* Adds the notificationtemplate to the database. Also notifies the appropriate model listeners.
	*
	* @param notificationtemplate the notificationtemplate
	* @return the notificationtemplate that was added
	*/
	public static org.opencps.communication.model.Notificationtemplate addNotificationtemplate(
		org.opencps.communication.model.Notificationtemplate notificationtemplate) {
		return getService().addNotificationtemplate(notificationtemplate);
	}

	/**
	* Creates a new notificationtemplate with the primary key. Does not add the notificationtemplate to the database.
	*
	* @param notificationTemplateId the primary key for the new notificationtemplate
	* @return the new notificationtemplate
	*/
	public static org.opencps.communication.model.Notificationtemplate createNotificationtemplate(
		long notificationTemplateId) {
		return getService().createNotificationtemplate(notificationTemplateId);
	}

	/**
	* @param dictCollectionId
	* @param serviceContext
	* @return
	*/
	public static org.opencps.communication.model.Notificationtemplate deleteNotificationTemplate(
		long notificationTemplateId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws backend.auth.api.exception.NotFoundException,
			backend.auth.api.exception.UnauthenticationException,
			backend.auth.api.exception.UnauthorizationException {
		return getService()
				   .deleteNotificationTemplate(notificationTemplateId,
			serviceContext);
	}

	/**
	* Deletes the notificationtemplate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param notificationTemplateId the primary key of the notificationtemplate
	* @return the notificationtemplate that was removed
	* @throws PortalException if a notificationtemplate with the primary key could not be found
	*/
	public static org.opencps.communication.model.Notificationtemplate deleteNotificationtemplate(
		long notificationTemplateId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteNotificationtemplate(notificationTemplateId);
	}

	/**
	* Deletes the notificationtemplate from the database. Also notifies the appropriate model listeners.
	*
	* @param notificationtemplate the notificationtemplate
	* @return the notificationtemplate that was removed
	*/
	public static org.opencps.communication.model.Notificationtemplate deleteNotificationtemplate(
		org.opencps.communication.model.Notificationtemplate notificationtemplate) {
		return getService().deleteNotificationtemplate(notificationtemplate);
	}

	public static org.opencps.communication.model.Notificationtemplate fetchByF_NotificationtemplateByType(
		long groupId, java.lang.String notificationType) {
		return getService()
				   .fetchByF_NotificationtemplateByType(groupId,
			notificationType);
	}

	public static org.opencps.communication.model.Notificationtemplate fetchNotificationtemplate(
		long notificationTemplateId) {
		return getService().fetchNotificationtemplate(notificationTemplateId);
	}

	/**
	* Returns the notificationtemplate with the primary key.
	*
	* @param notificationTemplateId the primary key of the notificationtemplate
	* @return the notificationtemplate
	* @throws PortalException if a notificationtemplate with the primary key could not be found
	*/
	public static org.opencps.communication.model.Notificationtemplate getNotificationtemplate(
		long notificationTemplateId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getNotificationtemplate(notificationTemplateId);
	}

	public static org.opencps.communication.model.Notificationtemplate updateNotificationTemplate(
		long userId, long notificationTemplateId,
		java.lang.String notificationType, java.lang.String emailSubject,
		java.lang.String emailBody, java.lang.String textMessage,
		boolean sendSMS, boolean sendEmail, int expireDuration,
		java.lang.String userUrlPattern, java.lang.String guestUrlPattern,
		java.lang.String interval, boolean grouping,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws backend.auth.api.exception.NotFoundException,
			backend.auth.api.exception.UnauthenticationException,
			backend.auth.api.exception.UnauthorizationException,
			com.liferay.portal.kernel.exception.NoSuchUserException {
		return getService()
				   .updateNotificationTemplate(userId, notificationTemplateId,
			notificationType, emailSubject, emailBody, textMessage, sendSMS,
			sendEmail, expireDuration, userUrlPattern, guestUrlPattern,
			interval, grouping, serviceContext);
	}

	/**
	* Updates the notificationtemplate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param notificationtemplate the notificationtemplate
	* @return the notificationtemplate that was updated
	*/
	public static org.opencps.communication.model.Notificationtemplate updateNotificationtemplate(
		org.opencps.communication.model.Notificationtemplate notificationtemplate) {
		return getService().updateNotificationtemplate(notificationtemplate);
	}

	public static NotificationtemplateLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<NotificationtemplateLocalService, NotificationtemplateLocalService> _serviceTracker =
		ServiceTrackerFactory.open(NotificationtemplateLocalService.class);
}