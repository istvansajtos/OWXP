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

package com.liferay.wiki.customizer.service.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.wiki.customizer.service.base.WikiPageCustomServiceBaseImpl;
import com.liferay.wiki.model.WikiPage;
import com.liferay.wiki.service.WikiPageLocalServiceUtil;
import com.liferay.wiki.service.permission.WikiPagePermissionChecker;

/**
 * The implementation of the wiki page custom remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.wiki.customizer.service.WikiPageCustomService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WikiPageCustomServiceBaseImpl
 * @see com.liferay.wiki.customizer.service.WikiPageCustomServiceUtil
 */
@ProviderType
public class WikiPageCustomServiceImpl extends WikiPageCustomServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.wiki.customizer.service.WikiPageCustomServiceUtil} to access the wiki page custom remote service.
	 */
	@Override
	public WikiPage movePageToTrash(long nodeId, String title)
		throws PortalException {

		System.out.println("...wiki_done...");
		WikiPage page = WikiPageLocalServiceUtil.fetchPage(
			nodeId, title);

		if (page == null) {
			return null;
		}

		WikiPagePermissionChecker.check(
			getPermissionChecker(), page, ActionKeys.DELETE);

		return wikiPageCustomLocalService.movePageToTrash(getUserId(), page);
	}

	@Override
	public WikiPage movePageToTrash(long nodeId, String title, double version)
		throws PortalException {

		System.out.println("...wiki_done...");
		WikiPage page = WikiPageLocalServiceUtil.fetchPage(nodeId, title, version);

		WikiPagePermissionChecker.check(
			getPermissionChecker(), page, ActionKeys.DELETE);

		return wikiPageCustomLocalService.movePageToTrash(getUserId(), page);
	}

//	@BeanReference(type = WikiPageLocalService.class)
//	protected WikiPageLocalService wikiPageLocalService;
}