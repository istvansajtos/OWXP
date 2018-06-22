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

package com.liferay.bookmarks.customizer.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.bookmarks.customizer.model.CustomBookmarksEntry;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the custom bookmarks entry service. This utility wraps {@link com.liferay.bookmarks.customizer.service.persistence.impl.CustomBookmarksEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomBookmarksEntryPersistence
 * @see com.liferay.bookmarks.customizer.service.persistence.impl.CustomBookmarksEntryPersistenceImpl
 * @generated
 */
@ProviderType
public class CustomBookmarksEntryUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(CustomBookmarksEntry customBookmarksEntry) {
		getPersistence().clearCache(customBookmarksEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CustomBookmarksEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CustomBookmarksEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CustomBookmarksEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CustomBookmarksEntry> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CustomBookmarksEntry update(
		CustomBookmarksEntry customBookmarksEntry) {
		return getPersistence().update(customBookmarksEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CustomBookmarksEntry update(
		CustomBookmarksEntry customBookmarksEntry, ServiceContext serviceContext) {
		return getPersistence().update(customBookmarksEntry, serviceContext);
	}

	/**
	* Caches the custom bookmarks entry in the entity cache if it is enabled.
	*
	* @param customBookmarksEntry the custom bookmarks entry
	*/
	public static void cacheResult(CustomBookmarksEntry customBookmarksEntry) {
		getPersistence().cacheResult(customBookmarksEntry);
	}

	/**
	* Caches the custom bookmarks entries in the entity cache if it is enabled.
	*
	* @param customBookmarksEntries the custom bookmarks entries
	*/
	public static void cacheResult(
		List<CustomBookmarksEntry> customBookmarksEntries) {
		getPersistence().cacheResult(customBookmarksEntries);
	}

	/**
	* Creates a new custom bookmarks entry with the primary key. Does not add the custom bookmarks entry to the database.
	*
	* @param id the primary key for the new custom bookmarks entry
	* @return the new custom bookmarks entry
	*/
	public static CustomBookmarksEntry create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the custom bookmarks entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the custom bookmarks entry
	* @return the custom bookmarks entry that was removed
	* @throws NoSuchCustomBookmarksEntryException if a custom bookmarks entry with the primary key could not be found
	*/
	public static CustomBookmarksEntry remove(long id)
		throws com.liferay.bookmarks.customizer.exception.NoSuchCustomBookmarksEntryException {
		return getPersistence().remove(id);
	}

	public static CustomBookmarksEntry updateImpl(
		CustomBookmarksEntry customBookmarksEntry) {
		return getPersistence().updateImpl(customBookmarksEntry);
	}

	/**
	* Returns the custom bookmarks entry with the primary key or throws a {@link NoSuchCustomBookmarksEntryException} if it could not be found.
	*
	* @param id the primary key of the custom bookmarks entry
	* @return the custom bookmarks entry
	* @throws NoSuchCustomBookmarksEntryException if a custom bookmarks entry with the primary key could not be found
	*/
	public static CustomBookmarksEntry findByPrimaryKey(long id)
		throws com.liferay.bookmarks.customizer.exception.NoSuchCustomBookmarksEntryException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the custom bookmarks entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the custom bookmarks entry
	* @return the custom bookmarks entry, or <code>null</code> if a custom bookmarks entry with the primary key could not be found
	*/
	public static CustomBookmarksEntry fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, CustomBookmarksEntry> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the custom bookmarks entries.
	*
	* @return the custom bookmarks entries
	*/
	public static List<CustomBookmarksEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the custom bookmarks entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CustomBookmarksEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of custom bookmarks entries
	* @param end the upper bound of the range of custom bookmarks entries (not inclusive)
	* @return the range of custom bookmarks entries
	*/
	public static List<CustomBookmarksEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the custom bookmarks entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CustomBookmarksEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of custom bookmarks entries
	* @param end the upper bound of the range of custom bookmarks entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of custom bookmarks entries
	*/
	public static List<CustomBookmarksEntry> findAll(int start, int end,
		OrderByComparator<CustomBookmarksEntry> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the custom bookmarks entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CustomBookmarksEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of custom bookmarks entries
	* @param end the upper bound of the range of custom bookmarks entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of custom bookmarks entries
	*/
	public static List<CustomBookmarksEntry> findAll(int start, int end,
		OrderByComparator<CustomBookmarksEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the custom bookmarks entries from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of custom bookmarks entries.
	*
	* @return the number of custom bookmarks entries
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static CustomBookmarksEntryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CustomBookmarksEntryPersistence, CustomBookmarksEntryPersistence> _serviceTracker =
		ServiceTrackerFactory.open(CustomBookmarksEntryPersistence.class);
}