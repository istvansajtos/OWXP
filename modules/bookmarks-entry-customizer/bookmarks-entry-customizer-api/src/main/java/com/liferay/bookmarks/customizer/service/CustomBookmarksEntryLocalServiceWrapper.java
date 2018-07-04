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

package com.liferay.bookmarks.customizer.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CustomBookmarksEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CustomBookmarksEntryLocalService
 * @generated
 */
@ProviderType
public class CustomBookmarksEntryLocalServiceWrapper
	implements CustomBookmarksEntryLocalService,
		ServiceWrapper<CustomBookmarksEntryLocalService> {
	public CustomBookmarksEntryLocalServiceWrapper(
		CustomBookmarksEntryLocalService customBookmarksEntryLocalService) {
		_customBookmarksEntryLocalService = customBookmarksEntryLocalService;
	}

	/**
	* Adds the custom bookmarks entry to the database. Also notifies the appropriate model listeners.
	*
	* @param customBookmarksEntry the custom bookmarks entry
	* @return the custom bookmarks entry that was added
	*/
	@Override
	public com.liferay.bookmarks.customizer.model.CustomBookmarksEntry addCustomBookmarksEntry(
		com.liferay.bookmarks.customizer.model.CustomBookmarksEntry customBookmarksEntry) {
		return _customBookmarksEntryLocalService.addCustomBookmarksEntry(customBookmarksEntry);
	}

	/**
	* Creates a new custom bookmarks entry with the primary key. Does not add the custom bookmarks entry to the database.
	*
	* @param id the primary key for the new custom bookmarks entry
	* @return the new custom bookmarks entry
	*/
	@Override
	public com.liferay.bookmarks.customizer.model.CustomBookmarksEntry createCustomBookmarksEntry(
		long id) {
		return _customBookmarksEntryLocalService.createCustomBookmarksEntry(id);
	}

	/**
	* Deletes the custom bookmarks entry from the database. Also notifies the appropriate model listeners.
	*
	* @param customBookmarksEntry the custom bookmarks entry
	* @return the custom bookmarks entry that was removed
	*/
	@Override
	public com.liferay.bookmarks.customizer.model.CustomBookmarksEntry deleteCustomBookmarksEntry(
		com.liferay.bookmarks.customizer.model.CustomBookmarksEntry customBookmarksEntry) {
		return _customBookmarksEntryLocalService.deleteCustomBookmarksEntry(customBookmarksEntry);
	}

	/**
	* Deletes the custom bookmarks entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the custom bookmarks entry
	* @return the custom bookmarks entry that was removed
	* @throws PortalException if a custom bookmarks entry with the primary key could not be found
	*/
	@Override
	public com.liferay.bookmarks.customizer.model.CustomBookmarksEntry deleteCustomBookmarksEntry(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return _customBookmarksEntryLocalService.deleteCustomBookmarksEntry(id);
	}

	@Override
	public com.liferay.bookmarks.customizer.model.CustomBookmarksEntry fetchCustomBookmarksEntry(
		long id) {
		return _customBookmarksEntryLocalService.fetchCustomBookmarksEntry(id);
	}

	/**
	* Returns the custom bookmarks entry with the primary key.
	*
	* @param id the primary key of the custom bookmarks entry
	* @return the custom bookmarks entry
	* @throws PortalException if a custom bookmarks entry with the primary key could not be found
	*/
	@Override
	public com.liferay.bookmarks.customizer.model.CustomBookmarksEntry getCustomBookmarksEntry(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return _customBookmarksEntryLocalService.getCustomBookmarksEntry(id);
	}

	/**
	* Updates the custom bookmarks entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param customBookmarksEntry the custom bookmarks entry
	* @return the custom bookmarks entry that was updated
	*/
	@Override
	public com.liferay.bookmarks.customizer.model.CustomBookmarksEntry updateCustomBookmarksEntry(
		com.liferay.bookmarks.customizer.model.CustomBookmarksEntry customBookmarksEntry) {
		return _customBookmarksEntryLocalService.updateCustomBookmarksEntry(customBookmarksEntry);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _customBookmarksEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _customBookmarksEntryLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _customBookmarksEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _customBookmarksEntryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _customBookmarksEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of custom bookmarks entries.
	*
	* @return the number of custom bookmarks entries
	*/
	@Override
	public int getCustomBookmarksEntriesCount() {
		return _customBookmarksEntryLocalService.getCustomBookmarksEntriesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _customBookmarksEntryLocalService.getOSGiServiceIdentifier();
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
		return _customBookmarksEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.bookmarks.customizer.model.impl.CustomBookmarksEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _customBookmarksEntryLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.bookmarks.customizer.model.impl.CustomBookmarksEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _customBookmarksEntryLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns a range of all the custom bookmarks entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.bookmarks.customizer.model.impl.CustomBookmarksEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of custom bookmarks entries
	* @param end the upper bound of the range of custom bookmarks entries (not inclusive)
	* @return the range of custom bookmarks entries
	*/
	@Override
	public java.util.List<com.liferay.bookmarks.customizer.model.CustomBookmarksEntry> getCustomBookmarksEntries(
		int start, int end) {
		return _customBookmarksEntryLocalService.getCustomBookmarksEntries(start,
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
		return _customBookmarksEntryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _customBookmarksEntryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public CustomBookmarksEntryLocalService getWrappedService() {
		return _customBookmarksEntryLocalService;
	}

	@Override
	public void setWrappedService(
		CustomBookmarksEntryLocalService customBookmarksEntryLocalService) {
		_customBookmarksEntryLocalService = customBookmarksEntryLocalService;
	}

	private CustomBookmarksEntryLocalService _customBookmarksEntryLocalService;
}