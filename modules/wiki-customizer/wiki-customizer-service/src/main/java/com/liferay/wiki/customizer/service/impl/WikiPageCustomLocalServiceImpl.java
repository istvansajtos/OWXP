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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.comment.CommentManagerUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portletfilerepository.PortletFileRepositoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.social.SocialActivityManagerUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.social.kernel.model.SocialActivityConstants;
import com.liferay.trash.kernel.exception.TrashEntryException;
import com.liferay.trash.kernel.model.TrashEntry;
import com.liferay.trash.kernel.util.TrashUtil;
import com.liferay.wiki.customizer.service.base.WikiPageCustomLocalServiceBaseImpl;
import com.liferay.wiki.model.WikiPage;
import com.liferay.wiki.model.WikiPageResource;
import com.liferay.wiki.service.WikiPageLocalServiceUtil;
import com.liferay.wiki.service.persistence.WikiPagePersistence;
import com.liferay.wiki.service.persistence.WikiPageResourcePersistence;
import com.liferay.wiki.util.comparator.PageVersionComparator;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the wiki page custom local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.wiki.customizer.service.WikiPageCustomLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WikiPageCustomLocalServiceBaseImpl
 * @see com.liferay.wiki.customizer.service.WikiPageCustomLocalServiceUtil
 */
@ProviderType
public class WikiPageCustomLocalServiceImpl
	extends WikiPageCustomLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.wiki.customizer.service.WikiPageCustomLocalServiceUtil} to access the wiki page custom local service.
	 */
	protected void moveDependentChildPagesToRoot(
			long parentNodeId, String parentTitle)
		throws PortalException {

		List<WikiPage> childPages = wikiPagePersistence.findByN_H_P(
			parentNodeId, true, parentTitle);

		for (WikiPage childPage : childPages) {
			childPage.setParentTitle(null);

			wikiPagePersistence.update(childPage);
		}
	}

	@Override
	public WikiPage movePageToTrash(long userId, WikiPage page)
		throws PortalException {

		System.out.println(">>> In WikiPageCustomLocalServiceImpl#movePageToTrash()");
		if (page.isInTrash()) {
			throw new TrashEntryException();
		}

		// Page

		int oldStatus = page.getStatus();
		String oldTitle = page.getTitle();

		if (oldStatus == WorkflowConstants.STATUS_PENDING) {
			page.setStatus(WorkflowConstants.STATUS_DRAFT);

			wikiPagePersistence.update(page);
		}

		List<WikiPage> pageVersions = wikiPagePersistence.findByR_N_H(
			page.getResourcePrimKey(), page.getNodeId(), false);

		pageVersions = ListUtil.sort(pageVersions, new PageVersionComparator());

		List<ObjectValuePair<Long, Integer>> pageVersionStatusOVPs =
			new ArrayList<>();

		if ((pageVersions != null) && !pageVersions.isEmpty()) {
			pageVersionStatusOVPs = getPageVersionStatuses(pageVersions);
		}

		page = WikiPageLocalServiceUtil.updateStatus(
			userId, page, WorkflowConstants.STATUS_IN_TRASH,
			new ServiceContext(), new HashMap<String, Serializable>());

		// Trash

		WikiPageResource pageResource =
			wikiPageResourcePersistence.fetchByPrimaryKey(
				page.getResourcePrimKey());

		UnicodeProperties typeSettingsProperties = new UnicodeProperties();

		typeSettingsProperties.put("title", page.getTitle());

		TrashEntry trashEntry = trashEntryLocalService.addTrashEntry(
			userId, page.getGroupId(), WikiPage.class.getName(),
			page.getResourcePrimKey(), page.getUuid(), null, oldStatus,
			pageVersionStatusOVPs, typeSettingsProperties);

		String trashTitle = TrashUtil.getTrashTitle(trashEntry.getEntryId());

		for (WikiPage pageVersion : pageVersions) {
			pageVersion.setTitle(trashTitle);
			pageVersion.setStatus(WorkflowConstants.STATUS_IN_TRASH);

			wikiPagePersistence.update(pageVersion);
		}

		pageResource.setTitle(trashTitle);

		wikiPageResourcePersistence.update(pageResource);

		page.setTitle(trashTitle);

		wikiPagePersistence.update(page);

		// Child pages

		/*moveDependentChildPagesToTrash(
			page.getNodeId(), oldTitle, trashTitle, trashEntry.getEntryId(),
			true);*/
		moveDependentChildPagesToRoot(page.getNodeId(), oldTitle);

		// Asset

		assetEntryLocalService.updateVisible(
			WikiPage.class.getName(), page.getResourcePrimKey(), false);

		// Attachments

		for (FileEntry fileEntry : page.getAttachmentsFileEntries()) {
			PortletFileRepositoryUtil.movePortletFileEntryToTrash(
				userId, fileEntry.getFileEntryId());
		}

		// Comment

		CommentManagerUtil.moveDiscussionToTrash(
			WikiPage.class.getName(), page.getResourcePrimKey());

		// Social

		JSONObject extraDataJSONObject = JSONFactoryUtil.createJSONObject();

		extraDataJSONObject.put(
			"title", TrashUtil.getOriginalTitle(page.getTitle()));
		extraDataJSONObject.put("version", page.getVersion());

		SocialActivityManagerUtil.addActivity(
			userId, page, SocialActivityConstants.TYPE_MOVE_TO_TRASH,
			extraDataJSONObject.toString(), 0);

		// Indexer

		Indexer<WikiPage> indexer = IndexerRegistryUtil.nullSafeGetIndexer(
			WikiPage.class);

		indexer.reindex(page);

		// Workflow

		if (oldStatus == WorkflowConstants.STATUS_PENDING) {
			workflowInstanceLinkLocalService.deleteWorkflowInstanceLink(
				page.getCompanyId(), page.getGroupId(),
				WikiPage.class.getName(), page.getPageId());
		}

		return page;
	}

	protected List<ObjectValuePair<Long, Integer>> getPageVersionStatuses(
		List<WikiPage> pages) {

		List<ObjectValuePair<Long, Integer>> pageVersionStatusOVPs =
			new ArrayList<>(pages.size());

		for (WikiPage page : pages) {
			int status = page.getStatus();

			if (status == WorkflowConstants.STATUS_PENDING) {
				status = WorkflowConstants.STATUS_DRAFT;
			}

			ObjectValuePair<Long, Integer> pageVersionStatusOVP =
				new ObjectValuePair<>(page.getPageId(), status);

			pageVersionStatusOVPs.add(pageVersionStatusOVP);
		}

		return pageVersionStatusOVPs;
	}

	/*@BeanReference(type = WikiPageLocalService.class)
	protected WikiPageLocalService wikiPageLocalService;*/
/*	@BeanReference(type = WikiPagePersistence.class)
	protected WikiPagePersistence wikiPagePersistence;
	@BeanReference(type = WikiPageResourcePersistence.class)
	protected WikiPageResourcePersistence wikiPageResourcePersistence;
*/

}