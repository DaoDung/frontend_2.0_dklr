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

package org.opencps.usermgt.service;

import aQute.bnd.annotation.ProviderType;

import backend.auth.api.exception.NotFoundException;
import backend.auth.api.exception.UnauthenticationException;
import backend.auth.api.exception.UnauthorizationException;

import com.liferay.exportimport.kernel.lar.PortletDataContext;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.opencps.usermgt.model.OfficeSite;

import java.io.Serializable;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Provides the local service interface for OfficeSite. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author khoavu
 * @see OfficeSiteLocalServiceUtil
 * @see org.opencps.usermgt.service.base.OfficeSiteLocalServiceBaseImpl
 * @see org.opencps.usermgt.service.impl.OfficeSiteLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface OfficeSiteLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OfficeSiteLocalServiceUtil} to access the office site local service. Add custom service methods to {@link org.opencps.usermgt.service.impl.OfficeSiteLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public Hits luceneSearchEngine(
		LinkedHashMap<java.lang.String, java.lang.Object> params, Sort[] sorts,
		int start, int end, SearchContext searchContext)
		throws ParseException, SearchException;

	/**
	* Returns the number of office sites.
	*
	* @return the number of office sites
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getOfficeSitesCount();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.OfficeSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.OfficeSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* Returns a range of all the office sites.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.OfficeSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of office sites
	* @param end the upper bound of the range of office sites (not inclusive)
	* @return the range of office sites
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OfficeSite> getOfficeSites(int start, int end);

	/**
	* Returns all the office sites matching the UUID and company.
	*
	* @param uuid the UUID of the office sites
	* @param companyId the primary key of the company
	* @return the matching office sites, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OfficeSite> getOfficeSitesByUuidAndCompanyId(
		java.lang.String uuid, long companyId);

	/**
	* Returns a range of office sites matching the UUID and company.
	*
	* @param uuid the UUID of the office sites
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of office sites
	* @param end the upper bound of the range of office sites (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching office sites, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OfficeSite> getOfficeSitesByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		OrderByComparator<OfficeSite> orderByComparator);

	public long countLuceneSearchEngine(
		LinkedHashMap<java.lang.String, java.lang.Object> params,
		SearchContext searchContext) throws ParseException, SearchException;

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);

	@Indexable(type = IndexableType.REINDEX)
	public OfficeSite addOfficeSite(long userId, long groupId,
		java.lang.String name, java.lang.String enName,
		java.lang.String govAgencyCode, java.lang.String address,
		java.lang.String telNo, java.lang.String faxNo, java.lang.String email,
		java.lang.String website, long logoFileEntryId, long siteGroupId,
		long adminUserId, java.lang.String preferences,
		ServiceContext serviceContext)
		throws UnauthenticationException, UnauthorizationException,
			NoSuchUserException;

	/**
	* Adds the office site to the database. Also notifies the appropriate model listeners.
	*
	* @param officeSite the office site
	* @return the office site that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public OfficeSite addOfficeSite(OfficeSite officeSite);

	/**
	* Creates a new office site with the primary key. Does not add the office site to the database.
	*
	* @param officeSiteId the primary key for the new office site
	* @return the new office site
	*/
	public OfficeSite createOfficeSite(long officeSiteId);

	/**
	* Deletes the office site with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param officeSiteId the primary key of the office site
	* @return the office site that was removed
	* @throws PortalException if a office site with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public OfficeSite deleteOfficeSite(long officeSiteId)
		throws PortalException;

	@Indexable(type = IndexableType.DELETE)
	public OfficeSite deleteOfficeSite(long officeSiteId,
		ServiceContext serviceContext)
		throws NotFoundException, UnauthenticationException,
			UnauthorizationException;

	/**
	* Deletes the office site from the database. Also notifies the appropriate model listeners.
	*
	* @param officeSite the office site
	* @return the office site that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public OfficeSite deleteOfficeSite(OfficeSite officeSite);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public OfficeSite fetchF_groupId_siteGroupId(long groupId, long siteGroupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public OfficeSite fetchOfficeSite(long officeSiteId);

	/**
	* Returns the office site matching the UUID and group.
	*
	* @param uuid the office site's UUID
	* @param groupId the primary key of the group
	* @return the matching office site, or <code>null</code> if a matching office site could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public OfficeSite fetchOfficeSiteByUuidAndGroupId(java.lang.String uuid,
		long groupId);

	/**
	* Returns the office site with the primary key.
	*
	* @param officeSiteId the primary key of the office site
	* @return the office site
	* @throws PortalException if a office site with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public OfficeSite getOfficeSite(long officeSiteId)
		throws PortalException;

	/**
	* Returns the office site matching the UUID and group.
	*
	* @param uuid the office site's UUID
	* @param groupId the primary key of the group
	* @return the matching office site
	* @throws PortalException if a matching office site could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public OfficeSite getOfficeSiteByUuidAndGroupId(java.lang.String uuid,
		long groupId) throws PortalException;

	@Indexable(type = IndexableType.REINDEX)
	public OfficeSite updateOfficeSite(long userId, long officeSiteId,
		java.lang.String name, java.lang.String enName,
		java.lang.String govAgencyCode, java.lang.String address,
		java.lang.String telNo, java.lang.String faxNo, java.lang.String email,
		java.lang.String website, long logoFileEntryId, long siteGroupId,
		long adminUserId, java.lang.String preferences,
		ServiceContext serviceContext)
		throws NotFoundException, UnauthenticationException,
			UnauthorizationException, NoSuchUserException;

	/**
	* Updates the office site in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param officeSite the office site
	* @return the office site that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public OfficeSite updateOfficeSite(OfficeSite officeSite);
}