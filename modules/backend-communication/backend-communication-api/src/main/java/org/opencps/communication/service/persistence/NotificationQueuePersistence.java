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

package org.opencps.communication.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.opencps.communication.exception.NoSuchNotificationQueueException;
import org.opencps.communication.model.NotificationQueue;

/**
 * The persistence interface for the notification queue service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see org.opencps.communication.service.persistence.impl.NotificationQueuePersistenceImpl
 * @see NotificationQueueUtil
 * @generated
 */
@ProviderType
public interface NotificationQueuePersistence extends BasePersistence<NotificationQueue> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NotificationQueueUtil} to access the notification queue persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the notification queue in the entity cache if it is enabled.
	*
	* @param notificationQueue the notification queue
	*/
	public void cacheResult(NotificationQueue notificationQueue);

	/**
	* Caches the notification queues in the entity cache if it is enabled.
	*
	* @param notificationQueues the notification queues
	*/
	public void cacheResult(
		java.util.List<NotificationQueue> notificationQueues);

	/**
	* Creates a new notification queue with the primary key. Does not add the notification queue to the database.
	*
	* @param notificationQueueId the primary key for the new notification queue
	* @return the new notification queue
	*/
	public NotificationQueue create(long notificationQueueId);

	/**
	* Removes the notification queue with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param notificationQueueId the primary key of the notification queue
	* @return the notification queue that was removed
	* @throws NoSuchNotificationQueueException if a notification queue with the primary key could not be found
	*/
	public NotificationQueue remove(long notificationQueueId)
		throws NoSuchNotificationQueueException;

	public NotificationQueue updateImpl(NotificationQueue notificationQueue);

	/**
	* Returns the notification queue with the primary key or throws a {@link NoSuchNotificationQueueException} if it could not be found.
	*
	* @param notificationQueueId the primary key of the notification queue
	* @return the notification queue
	* @throws NoSuchNotificationQueueException if a notification queue with the primary key could not be found
	*/
	public NotificationQueue findByPrimaryKey(long notificationQueueId)
		throws NoSuchNotificationQueueException;

	/**
	* Returns the notification queue with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param notificationQueueId the primary key of the notification queue
	* @return the notification queue, or <code>null</code> if a notification queue with the primary key could not be found
	*/
	public NotificationQueue fetchByPrimaryKey(long notificationQueueId);

	@Override
	public java.util.Map<java.io.Serializable, NotificationQueue> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the notification queues.
	*
	* @return the notification queues
	*/
	public java.util.List<NotificationQueue> findAll();

	/**
	* Returns a range of all the notification queues.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of notification queues
	* @param end the upper bound of the range of notification queues (not inclusive)
	* @return the range of notification queues
	*/
	public java.util.List<NotificationQueue> findAll(int start, int end);

	/**
	* Returns an ordered range of all the notification queues.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of notification queues
	* @param end the upper bound of the range of notification queues (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of notification queues
	*/
	public java.util.List<NotificationQueue> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationQueue> orderByComparator);

	/**
	* Returns an ordered range of all the notification queues.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of notification queues
	* @param end the upper bound of the range of notification queues (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of notification queues
	*/
	public java.util.List<NotificationQueue> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationQueue> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the notification queues from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of notification queues.
	*
	* @return the number of notification queues
	*/
	public int countAll();
}