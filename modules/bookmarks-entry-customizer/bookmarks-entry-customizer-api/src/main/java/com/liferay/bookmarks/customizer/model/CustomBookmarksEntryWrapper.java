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

package com.liferay.bookmarks.customizer.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link CustomBookmarksEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomBookmarksEntry
 * @generated
 */
@ProviderType
public class CustomBookmarksEntryWrapper implements CustomBookmarksEntry,
	ModelWrapper<CustomBookmarksEntry> {
	public CustomBookmarksEntryWrapper(
		CustomBookmarksEntry customBookmarksEntry) {
		_customBookmarksEntry = customBookmarksEntry;
	}

	@Override
	public Class<?> getModelClass() {
		return CustomBookmarksEntry.class;
	}

	@Override
	public String getModelClassName() {
		return CustomBookmarksEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}
	}

	@Override
	public CustomBookmarksEntry toEscapedModel() {
		return new CustomBookmarksEntryWrapper(_customBookmarksEntry.toEscapedModel());
	}

	@Override
	public CustomBookmarksEntry toUnescapedModel() {
		return new CustomBookmarksEntryWrapper(_customBookmarksEntry.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _customBookmarksEntry.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _customBookmarksEntry.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _customBookmarksEntry.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _customBookmarksEntry.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<CustomBookmarksEntry> toCacheModel() {
		return _customBookmarksEntry.toCacheModel();
	}

	@Override
	public int compareTo(CustomBookmarksEntry customBookmarksEntry) {
		return _customBookmarksEntry.compareTo(customBookmarksEntry);
	}

	@Override
	public int hashCode() {
		return _customBookmarksEntry.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _customBookmarksEntry.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new CustomBookmarksEntryWrapper((CustomBookmarksEntry)_customBookmarksEntry.clone());
	}

	@Override
	public java.lang.String toString() {
		return _customBookmarksEntry.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _customBookmarksEntry.toXmlString();
	}

	/**
	* Returns the ID of this custom bookmarks entry.
	*
	* @return the ID of this custom bookmarks entry
	*/
	@Override
	public long getId() {
		return _customBookmarksEntry.getId();
	}

	/**
	* Returns the primary key of this custom bookmarks entry.
	*
	* @return the primary key of this custom bookmarks entry
	*/
	@Override
	public long getPrimaryKey() {
		return _customBookmarksEntry.getPrimaryKey();
	}

	@Override
	public void persist() {
		_customBookmarksEntry.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_customBookmarksEntry.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_customBookmarksEntry.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_customBookmarksEntry.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_customBookmarksEntry.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this custom bookmarks entry.
	*
	* @param id the ID of this custom bookmarks entry
	*/
	@Override
	public void setId(long id) {
		_customBookmarksEntry.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_customBookmarksEntry.setNew(n);
	}

	/**
	* Sets the primary key of this custom bookmarks entry.
	*
	* @param primaryKey the primary key of this custom bookmarks entry
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_customBookmarksEntry.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_customBookmarksEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CustomBookmarksEntryWrapper)) {
			return false;
		}

		CustomBookmarksEntryWrapper customBookmarksEntryWrapper = (CustomBookmarksEntryWrapper)obj;

		if (Objects.equals(_customBookmarksEntry,
					customBookmarksEntryWrapper._customBookmarksEntry)) {
			return true;
		}

		return false;
	}

	@Override
	public CustomBookmarksEntry getWrappedModel() {
		return _customBookmarksEntry;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _customBookmarksEntry.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _customBookmarksEntry.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_customBookmarksEntry.resetOriginalValues();
	}

	private final CustomBookmarksEntry _customBookmarksEntry;
}