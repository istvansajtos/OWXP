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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class CustomBookmarksEntrySoap implements Serializable {
	public static CustomBookmarksEntrySoap toSoapModel(
		CustomBookmarksEntry model) {
		CustomBookmarksEntrySoap soapModel = new CustomBookmarksEntrySoap();

		soapModel.setId(model.getId());

		return soapModel;
	}

	public static CustomBookmarksEntrySoap[] toSoapModels(
		CustomBookmarksEntry[] models) {
		CustomBookmarksEntrySoap[] soapModels = new CustomBookmarksEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CustomBookmarksEntrySoap[][] toSoapModels(
		CustomBookmarksEntry[][] models) {
		CustomBookmarksEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CustomBookmarksEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new CustomBookmarksEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CustomBookmarksEntrySoap[] toSoapModels(
		List<CustomBookmarksEntry> models) {
		List<CustomBookmarksEntrySoap> soapModels = new ArrayList<CustomBookmarksEntrySoap>(models.size());

		for (CustomBookmarksEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CustomBookmarksEntrySoap[soapModels.size()]);
	}

	public CustomBookmarksEntrySoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	private long _id;
}