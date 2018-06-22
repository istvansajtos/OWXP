package com.liferay.bookmarks.customizer.service.persistence.impl;

import java.util.List;

import com.liferay.bookmarks.customizer.service.persistence.CustomBookmarksEntryFinder;
import com.liferay.bookmarks.model.BookmarksEntry;
import com.liferay.bookmarks.service.BookmarksEntryLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;

public class CustomBookmarksEntryFinderImpl 
	extends CustomBookmarksEntryFinderBaseImpl
	implements CustomBookmarksEntryFinder {

	public List<BookmarksEntry> findByC_U_U(
		long companyId, long userId, String url) {

		Session session = null;

		try {
			session = openSession();

			DynamicQuery bookmarksEntryQuery = 
				BookmarksEntryLocalServiceUtil.dynamicQuery();

			bookmarksEntryQuery.add(RestrictionsFactoryUtil.eq("companyId", companyId))
					.add(RestrictionsFactoryUtil.eq("userId", userId))
					.add(RestrictionsFactoryUtil.eq("url", url));

			List<BookmarksEntry> entries = BookmarksEntryLocalServiceUtil.dynamicQuery(bookmarksEntryQuery);

			return entries;
		}
		catch (Exception e) {
			try {
				throw new SystemException(e);
			}
			catch (SystemException se) {
				se.printStackTrace();
			}
		}
		finally {
			closeSession(session);
		}

		return null;
	}
}
