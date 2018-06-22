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

package com.liferay.bookmarks.customizer.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.bookmarks.customizer.model.CustomBookmarksEntry;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CustomBookmarksEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CustomBookmarksEntry
 * @generated
 */
@ProviderType
public class CustomBookmarksEntryCacheModel implements CacheModel<CustomBookmarksEntry>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CustomBookmarksEntryCacheModel)) {
			return false;
		}

		CustomBookmarksEntryCacheModel customBookmarksEntryCacheModel = (CustomBookmarksEntryCacheModel)obj;

		if (id == customBookmarksEntryCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(3);

		sb.append("{id=");
		sb.append(id);

		return sb.toString();
	}

	@Override
	public CustomBookmarksEntry toEntityModel() {
		CustomBookmarksEntryImpl customBookmarksEntryImpl = new CustomBookmarksEntryImpl();

		customBookmarksEntryImpl.setId(id);

		customBookmarksEntryImpl.resetOriginalValues();

		return customBookmarksEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
	}

	public long id;
}