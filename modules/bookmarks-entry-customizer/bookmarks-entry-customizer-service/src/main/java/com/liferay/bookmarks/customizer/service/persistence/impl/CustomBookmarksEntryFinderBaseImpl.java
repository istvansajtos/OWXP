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

package com.liferay.bookmarks.customizer.service.persistence.impl;

import com.liferay.bookmarks.customizer.model.CustomBookmarksEntry;
import com.liferay.bookmarks.customizer.service.persistence.CustomBookmarksEntryPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import java.util.Set;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CustomBookmarksEntryFinderBaseImpl extends BasePersistenceImpl<CustomBookmarksEntry> {
	@Override
	public Set<String> getBadColumnNames() {
		return getCustomBookmarksEntryPersistence().getBadColumnNames();
	}

	/**
	 * Returns the custom bookmarks entry persistence.
	 *
	 * @return the custom bookmarks entry persistence
	 */
	public CustomBookmarksEntryPersistence getCustomBookmarksEntryPersistence() {
		return customBookmarksEntryPersistence;
	}

	/**
	 * Sets the custom bookmarks entry persistence.
	 *
	 * @param customBookmarksEntryPersistence the custom bookmarks entry persistence
	 */
	public void setCustomBookmarksEntryPersistence(
		CustomBookmarksEntryPersistence customBookmarksEntryPersistence) {
		this.customBookmarksEntryPersistence = customBookmarksEntryPersistence;
	}

	@BeanReference(type = CustomBookmarksEntryPersistence.class)
	protected CustomBookmarksEntryPersistence customBookmarksEntryPersistence;
}