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

import com.liferay.bookmarks.customizer.exception.NoSuchCustomBookmarksEntryException;
import com.liferay.bookmarks.customizer.model.CustomBookmarksEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the custom bookmarks entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.bookmarks.customizer.service.persistence.impl.CustomBookmarksEntryPersistenceImpl
 * @see CustomBookmarksEntryUtil
 * @generated
 */
@ProviderType
public interface CustomBookmarksEntryPersistence extends BasePersistence<CustomBookmarksEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CustomBookmarksEntryUtil} to access the custom bookmarks entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the custom bookmarks entry in the entity cache if it is enabled.
	*
	* @param customBookmarksEntry the custom bookmarks entry
	*/
	public void cacheResult(CustomBookmarksEntry customBookmarksEntry);

	/**
	* Caches the custom bookmarks entries in the entity cache if it is enabled.
	*
	* @param customBookmarksEntries the custom bookmarks entries
	*/
	public void cacheResult(
		java.util.List<CustomBookmarksEntry> customBookmarksEntries);

	/**
	* Creates a new custom bookmarks entry with the primary key. Does not add the custom bookmarks entry to the database.
	*
	* @param id the primary key for the new custom bookmarks entry
	* @return the new custom bookmarks entry
	*/
	public CustomBookmarksEntry create(long id);

	/**
	* Removes the custom bookmarks entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the custom bookmarks entry
	* @return the custom bookmarks entry that was removed
	* @throws NoSuchCustomBookmarksEntryException if a custom bookmarks entry with the primary key could not be found
	*/
	public CustomBookmarksEntry remove(long id)
		throws NoSuchCustomBookmarksEntryException;

	public CustomBookmarksEntry updateImpl(
		CustomBookmarksEntry customBookmarksEntry);

	/**
	* Returns the custom bookmarks entry with the primary key or throws a {@link NoSuchCustomBookmarksEntryException} if it could not be found.
	*
	* @param id the primary key of the custom bookmarks entry
	* @return the custom bookmarks entry
	* @throws NoSuchCustomBookmarksEntryException if a custom bookmarks entry with the primary key could not be found
	*/
	public CustomBookmarksEntry findByPrimaryKey(long id)
		throws NoSuchCustomBookmarksEntryException;

	/**
	* Returns the custom bookmarks entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the custom bookmarks entry
	* @return the custom bookmarks entry, or <code>null</code> if a custom bookmarks entry with the primary key could not be found
	*/
	public CustomBookmarksEntry fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, CustomBookmarksEntry> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the custom bookmarks entries.
	*
	* @return the custom bookmarks entries
	*/
	public java.util.List<CustomBookmarksEntry> findAll();

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
	public java.util.List<CustomBookmarksEntry> findAll(int start, int end);

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
	public java.util.List<CustomBookmarksEntry> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomBookmarksEntry> orderByComparator);

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
	public java.util.List<CustomBookmarksEntry> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomBookmarksEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the custom bookmarks entries from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of custom bookmarks entries.
	*
	* @return the number of custom bookmarks entries
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}