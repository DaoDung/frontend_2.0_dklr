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

package org.opencps.communication.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import org.opencps.communication.exception.NoSuchNotificationQueueException;
import org.opencps.communication.model.NotificationQueue;
import org.opencps.communication.model.impl.NotificationQueueImpl;
import org.opencps.communication.model.impl.NotificationQueueModelImpl;
import org.opencps.communication.service.persistence.NotificationQueuePersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the notification queue service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see NotificationQueuePersistence
 * @see org.opencps.communication.service.persistence.NotificationQueueUtil
 * @generated
 */
@ProviderType
public class NotificationQueuePersistenceImpl extends BasePersistenceImpl<NotificationQueue>
	implements NotificationQueuePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link NotificationQueueUtil} to access the notification queue persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = NotificationQueueImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NotificationQueueModelImpl.ENTITY_CACHE_ENABLED,
			NotificationQueueModelImpl.FINDER_CACHE_ENABLED,
			NotificationQueueImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NotificationQueueModelImpl.ENTITY_CACHE_ENABLED,
			NotificationQueueModelImpl.FINDER_CACHE_ENABLED,
			NotificationQueueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NotificationQueueModelImpl.ENTITY_CACHE_ENABLED,
			NotificationQueueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public NotificationQueuePersistenceImpl() {
		setModelClass(NotificationQueue.class);
	}

	/**
	 * Caches the notification queue in the entity cache if it is enabled.
	 *
	 * @param notificationQueue the notification queue
	 */
	@Override
	public void cacheResult(NotificationQueue notificationQueue) {
		entityCache.putResult(NotificationQueueModelImpl.ENTITY_CACHE_ENABLED,
			NotificationQueueImpl.class, notificationQueue.getPrimaryKey(),
			notificationQueue);

		notificationQueue.resetOriginalValues();
	}

	/**
	 * Caches the notification queues in the entity cache if it is enabled.
	 *
	 * @param notificationQueues the notification queues
	 */
	@Override
	public void cacheResult(List<NotificationQueue> notificationQueues) {
		for (NotificationQueue notificationQueue : notificationQueues) {
			if (entityCache.getResult(
						NotificationQueueModelImpl.ENTITY_CACHE_ENABLED,
						NotificationQueueImpl.class,
						notificationQueue.getPrimaryKey()) == null) {
				cacheResult(notificationQueue);
			}
			else {
				notificationQueue.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all notification queues.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(NotificationQueueImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the notification queue.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(NotificationQueue notificationQueue) {
		entityCache.removeResult(NotificationQueueModelImpl.ENTITY_CACHE_ENABLED,
			NotificationQueueImpl.class, notificationQueue.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<NotificationQueue> notificationQueues) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (NotificationQueue notificationQueue : notificationQueues) {
			entityCache.removeResult(NotificationQueueModelImpl.ENTITY_CACHE_ENABLED,
				NotificationQueueImpl.class, notificationQueue.getPrimaryKey());
		}
	}

	/**
	 * Creates a new notification queue with the primary key. Does not add the notification queue to the database.
	 *
	 * @param notificationQueueId the primary key for the new notification queue
	 * @return the new notification queue
	 */
	@Override
	public NotificationQueue create(long notificationQueueId) {
		NotificationQueue notificationQueue = new NotificationQueueImpl();

		notificationQueue.setNew(true);
		notificationQueue.setPrimaryKey(notificationQueueId);

		notificationQueue.setCompanyId(companyProvider.getCompanyId());

		return notificationQueue;
	}

	/**
	 * Removes the notification queue with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param notificationQueueId the primary key of the notification queue
	 * @return the notification queue that was removed
	 * @throws NoSuchNotificationQueueException if a notification queue with the primary key could not be found
	 */
	@Override
	public NotificationQueue remove(long notificationQueueId)
		throws NoSuchNotificationQueueException {
		return remove((Serializable)notificationQueueId);
	}

	/**
	 * Removes the notification queue with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the notification queue
	 * @return the notification queue that was removed
	 * @throws NoSuchNotificationQueueException if a notification queue with the primary key could not be found
	 */
	@Override
	public NotificationQueue remove(Serializable primaryKey)
		throws NoSuchNotificationQueueException {
		Session session = null;

		try {
			session = openSession();

			NotificationQueue notificationQueue = (NotificationQueue)session.get(NotificationQueueImpl.class,
					primaryKey);

			if (notificationQueue == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNotificationQueueException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(notificationQueue);
		}
		catch (NoSuchNotificationQueueException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected NotificationQueue removeImpl(NotificationQueue notificationQueue) {
		notificationQueue = toUnwrappedModel(notificationQueue);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(notificationQueue)) {
				notificationQueue = (NotificationQueue)session.get(NotificationQueueImpl.class,
						notificationQueue.getPrimaryKeyObj());
			}

			if (notificationQueue != null) {
				session.delete(notificationQueue);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (notificationQueue != null) {
			clearCache(notificationQueue);
		}

		return notificationQueue;
	}

	@Override
	public NotificationQueue updateImpl(NotificationQueue notificationQueue) {
		notificationQueue = toUnwrappedModel(notificationQueue);

		boolean isNew = notificationQueue.isNew();

		NotificationQueueModelImpl notificationQueueModelImpl = (NotificationQueueModelImpl)notificationQueue;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (notificationQueue.getCreateDate() == null)) {
			if (serviceContext == null) {
				notificationQueue.setCreateDate(now);
			}
			else {
				notificationQueue.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!notificationQueueModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				notificationQueue.setModifiedDate(now);
			}
			else {
				notificationQueue.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (notificationQueue.isNew()) {
				session.save(notificationQueue);

				notificationQueue.setNew(false);
			}
			else {
				notificationQueue = (NotificationQueue)session.merge(notificationQueue);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(NotificationQueueModelImpl.ENTITY_CACHE_ENABLED,
			NotificationQueueImpl.class, notificationQueue.getPrimaryKey(),
			notificationQueue, false);

		notificationQueue.resetOriginalValues();

		return notificationQueue;
	}

	protected NotificationQueue toUnwrappedModel(
		NotificationQueue notificationQueue) {
		if (notificationQueue instanceof NotificationQueueImpl) {
			return notificationQueue;
		}

		NotificationQueueImpl notificationQueueImpl = new NotificationQueueImpl();

		notificationQueueImpl.setNew(notificationQueue.isNew());
		notificationQueueImpl.setPrimaryKey(notificationQueue.getPrimaryKey());

		notificationQueueImpl.setNotificationQueueId(notificationQueue.getNotificationQueueId());
		notificationQueueImpl.setGroupId(notificationQueue.getGroupId());
		notificationQueueImpl.setCompanyId(notificationQueue.getCompanyId());
		notificationQueueImpl.setUserId(notificationQueue.getUserId());
		notificationQueueImpl.setUserName(notificationQueue.getUserName());
		notificationQueueImpl.setCreateDate(notificationQueue.getCreateDate());
		notificationQueueImpl.setModifiedDate(notificationQueue.getModifiedDate());
		notificationQueueImpl.setNotificationType(notificationQueue.getNotificationType());
		notificationQueueImpl.setClassName(notificationQueue.getClassName());
		notificationQueueImpl.setClassPK(notificationQueue.getClassPK());
		notificationQueueImpl.setPayload(notificationQueue.getPayload());
		notificationQueueImpl.setFromUsername(notificationQueue.getFromUsername());
		notificationQueueImpl.setToUsername(notificationQueue.getToUsername());
		notificationQueueImpl.setToUserId(notificationQueue.getToUserId());
		notificationQueueImpl.setToEmail(notificationQueue.getToEmail());
		notificationQueueImpl.setToTelNo(notificationQueue.getToTelNo());
		notificationQueueImpl.setPublicationDate(notificationQueue.getPublicationDate());
		notificationQueueImpl.setExpireDate(notificationQueue.getExpireDate());

		return notificationQueueImpl;
	}

	/**
	 * Returns the notification queue with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the notification queue
	 * @return the notification queue
	 * @throws NoSuchNotificationQueueException if a notification queue with the primary key could not be found
	 */
	@Override
	public NotificationQueue findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNotificationQueueException {
		NotificationQueue notificationQueue = fetchByPrimaryKey(primaryKey);

		if (notificationQueue == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNotificationQueueException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return notificationQueue;
	}

	/**
	 * Returns the notification queue with the primary key or throws a {@link NoSuchNotificationQueueException} if it could not be found.
	 *
	 * @param notificationQueueId the primary key of the notification queue
	 * @return the notification queue
	 * @throws NoSuchNotificationQueueException if a notification queue with the primary key could not be found
	 */
	@Override
	public NotificationQueue findByPrimaryKey(long notificationQueueId)
		throws NoSuchNotificationQueueException {
		return findByPrimaryKey((Serializable)notificationQueueId);
	}

	/**
	 * Returns the notification queue with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the notification queue
	 * @return the notification queue, or <code>null</code> if a notification queue with the primary key could not be found
	 */
	@Override
	public NotificationQueue fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(NotificationQueueModelImpl.ENTITY_CACHE_ENABLED,
				NotificationQueueImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		NotificationQueue notificationQueue = (NotificationQueue)serializable;

		if (notificationQueue == null) {
			Session session = null;

			try {
				session = openSession();

				notificationQueue = (NotificationQueue)session.get(NotificationQueueImpl.class,
						primaryKey);

				if (notificationQueue != null) {
					cacheResult(notificationQueue);
				}
				else {
					entityCache.putResult(NotificationQueueModelImpl.ENTITY_CACHE_ENABLED,
						NotificationQueueImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(NotificationQueueModelImpl.ENTITY_CACHE_ENABLED,
					NotificationQueueImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return notificationQueue;
	}

	/**
	 * Returns the notification queue with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param notificationQueueId the primary key of the notification queue
	 * @return the notification queue, or <code>null</code> if a notification queue with the primary key could not be found
	 */
	@Override
	public NotificationQueue fetchByPrimaryKey(long notificationQueueId) {
		return fetchByPrimaryKey((Serializable)notificationQueueId);
	}

	@Override
	public Map<Serializable, NotificationQueue> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, NotificationQueue> map = new HashMap<Serializable, NotificationQueue>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			NotificationQueue notificationQueue = fetchByPrimaryKey(primaryKey);

			if (notificationQueue != null) {
				map.put(primaryKey, notificationQueue);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(NotificationQueueModelImpl.ENTITY_CACHE_ENABLED,
					NotificationQueueImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (NotificationQueue)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_NOTIFICATIONQUEUE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (NotificationQueue notificationQueue : (List<NotificationQueue>)q.list()) {
				map.put(notificationQueue.getPrimaryKeyObj(), notificationQueue);

				cacheResult(notificationQueue);

				uncachedPrimaryKeys.remove(notificationQueue.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(NotificationQueueModelImpl.ENTITY_CACHE_ENABLED,
					NotificationQueueImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the notification queues.
	 *
	 * @return the notification queues
	 */
	@Override
	public List<NotificationQueue> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<NotificationQueue> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<NotificationQueue> findAll(int start, int end,
		OrderByComparator<NotificationQueue> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<NotificationQueue> findAll(int start, int end,
		OrderByComparator<NotificationQueue> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<NotificationQueue> list = null;

		if (retrieveFromCache) {
			list = (List<NotificationQueue>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_NOTIFICATIONQUEUE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_NOTIFICATIONQUEUE;

				if (pagination) {
					sql = sql.concat(NotificationQueueModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<NotificationQueue>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<NotificationQueue>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the notification queues from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (NotificationQueue notificationQueue : findAll()) {
			remove(notificationQueue);
		}
	}

	/**
	 * Returns the number of notification queues.
	 *
	 * @return the number of notification queues
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_NOTIFICATIONQUEUE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return NotificationQueueModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the notification queue persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(NotificationQueueImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_NOTIFICATIONQUEUE = "SELECT notificationQueue FROM NotificationQueue notificationQueue";
	private static final String _SQL_SELECT_NOTIFICATIONQUEUE_WHERE_PKS_IN = "SELECT notificationQueue FROM NotificationQueue notificationQueue WHERE notificationQueueId IN (";
	private static final String _SQL_COUNT_NOTIFICATIONQUEUE = "SELECT COUNT(notificationQueue) FROM NotificationQueue notificationQueue";
	private static final String _ORDER_BY_ENTITY_ALIAS = "notificationQueue.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No NotificationQueue exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(NotificationQueuePersistenceImpl.class);
}