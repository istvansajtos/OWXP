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

package com.liferay.wiki.customizer.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link WikiPageCustomLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see WikiPageCustomLocalService
 * @generated
 */
@ProviderType
public class WikiPageCustomLocalServiceWrapper
	implements WikiPageCustomLocalService,
		ServiceWrapper<WikiPageCustomLocalService> {
	public WikiPageCustomLocalServiceWrapper(
		WikiPageCustomLocalService wikiPageCustomLocalService) {
		_wikiPageCustomLocalService = wikiPageCustomLocalService;
	}

	@Override
	public com.liferay.wiki.model.WikiPage movePageToTrash(long userId,
		com.liferay.wiki.model.WikiPage page)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wikiPageCustomLocalService.movePageToTrash(userId, page);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _wikiPageCustomLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public WikiPageCustomLocalService getWrappedService() {
		return _wikiPageCustomLocalService;
	}

	@Override
	public void setWrappedService(
		WikiPageCustomLocalService wikiPageCustomLocalService) {
		_wikiPageCustomLocalService = wikiPageCustomLocalService;
	}

	private WikiPageCustomLocalService _wikiPageCustomLocalService;
}