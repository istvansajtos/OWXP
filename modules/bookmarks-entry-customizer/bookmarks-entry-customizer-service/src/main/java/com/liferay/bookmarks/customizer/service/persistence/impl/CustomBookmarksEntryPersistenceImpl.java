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

import aQute.bnd.annotation.ProviderType;

import com.liferay.bookmarks.customizer.exception.NoSuchCustomBookmarksEntryException;
import com.liferay.bookmarks.customizer.model.CustomBookmarksEntry;
import com.liferay.bookmarks.customizer.model.impl.CustomBookmarksEntryImpl;
import com.liferay.bookmarks.customizer.model.impl.CustomBookmarksEntryModelImpl;
import com.liferay.bookmarks.customizer.service.persistence.CustomBookmarksEntryPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the custom bookmarks entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomBookmarksEntryPersistence
 * @see com.liferay.bookmarks.customizer.service.persistence.CustomBookmarksEntryUtil
 * @generated
 */
@ProviderType
public class CustomBookmarksEntryPersistenceImpl extends BasePersistenceImpl<CustomBookmarksEntry>
	implements CustomBookmarksEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CustomBookmarksEntryUtil} to access the custom bookmarks entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CustomBookmarksEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CustomBookmarksEntryModelImpl.ENTITY_CACHE_ENABLED,
			CustomBookmarksEntryModelImpl.FINDER_CACHE_ENABLED,
			CustomBookmarksEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CustomBookmarksEntryModelImpl.ENTITY_CACHE_ENABLED,
			CustomBookmarksEntryModelImpl.FINDER_CACHE_ENABLED,
			CustomBookmarksEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CustomBookmarksEntryModelImpl.ENTITY_CACHE_ENABLED,
			CustomBookmarksEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public CustomBookmarksEntryPersistenceImpl() {
		setModelClass(CustomBookmarksEntry.class);
	}

	/**
	 * Caches the custom bookmarks entry in the entity cache if it is enabled.
	 *
	 * @param customBookmarksEntry the custom bookmarks entry
	 */
	@Override
	public void cacheResult(CustomBookmarksEntry customBookmarksEntry) {
		entityCache.putResult(CustomBookmarksEntryModelImpl.ENTITY_CACHE_ENABLED,
			CustomBookmarksEntryImpl.class,
			customBookmarksEntry.getPrimaryKey(), customBookmarksEntry);

		customBookmarksEntry.resetOriginalValues();
	}

	/**
	 * Caches the custom bookmarks entries in the entity cache if it is enabled.
	 *
	 * @param customBookmarksEntries the custom bookmarks entries
	 */
	@Override
	public void cacheResult(List<CustomBookmarksEntry> customBookmarksEntries) {
		for (CustomBookmarksEntry customBookmarksEntry : customBookmarksEntries) {
			if (entityCache.getResult(
						CustomBookmarksEntryModelImpl.ENTITY_CACHE_ENABLED,
						CustomBookmarksEntryImpl.class,
						customBookmarksEntry.getPrimaryKey()) == null) {
				cacheResult(customBookmarksEntry);
			}
			else {
				customBookmarksEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all custom bookmarks entries.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CustomBookmarksEntryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the custom bookmarks entry.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CustomBookmarksEntry customBookmarksEntry) {
		entityCache.removeResult(CustomBookmarksEntryModelImpl.ENTITY_CACHE_ENABLED,
			CustomBookmarksEntryImpl.class, customBookmarksEntry.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CustomBookmarksEntry> customBookmarksEntries) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CustomBookmarksEntry customBookmarksEntry : customBookmarksEntries) {
			entityCache.removeResult(CustomBookmarksEntryModelImpl.ENTITY_CACHE_ENABLED,
				CustomBookmarksEntryImpl.class,
				customBookmarksEntry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new custom bookmarks entry with the primary key. Does not add the custom bookmarks entry to the database.
	 *
	 * @param id the primary key for the new custom bookmarks entry
	 * @return the new custom bookmarks entry
	 */
	@Override
	public CustomBookmarksEntry create(long id) {
		CustomBookmarksEntry customBookmarksEntry = new CustomBookmarksEntryImpl();

		customBookmarksEntry.setNew(true);
		customBookmarksEntry.setPrimaryKey(id);

		return customBookmarksEntry;
	}

	/**
	 * Removes the custom bookmarks entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the custom bookmarks entry
	 * @return the custom bookmarks entry that was removed
	 * @throws NoSuchCustomBookmarksEntryException if a custom bookmarks entry with the primary key could not be found
	 */
	@Override
	public CustomBookmarksEntry remove(long id)
		throws NoSuchCustomBookmarksEntryException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the custom bookmarks entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the custom bookmarks entry
	 * @return the custom bookmarks entry that was removed
	 * @throws NoSuchCustomBookmarksEntryException if a custom bookmarks entry with the primary key could not be found
	 */
	@Override
	public CustomBookmarksEntry remove(Serializable primaryKey)
		throws NoSuchCustomBookmarksEntryException {
		Session session = null;

		try {
			session = openSession();

			CustomBookmarksEntry customBookmarksEntry = (CustomBookmarksEntry)session.get(CustomBookmarksEntryImpl.class,
					primaryKey);

			if (customBookmarksEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCustomBookmarksEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(customBookmarksEntry);
		}
		catch (NoSuchCustomBookmarksEntryException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected CustomBookmarksEntry removeImpl(
		CustomBookmarksEntry customBookmarksEntry) {
		customBookmarksEntry = toUnwrappedModel(customBookmarksEntry);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(customBookmarksEntry)) {
				customBookmarksEntry = (CustomBookmarksEntry)session.get(CustomBookmarksEntryImpl.class,
						customBookmarksEntry.getPrimaryKeyObj());
			}

			if (customBookmarksEntry != null) {
				session.delete(customBookmarksEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (customBookmarksEntry != null) {
			clearCache(customBookmarksEntry);
		}

		return customBookmarksEntry;
	}

	@Override
	public CustomBookmarksEntry updateImpl(
		CustomBookmarksEntry customBookmarksEntry) {
		customBookmarksEntry = toUnwrappedModel(customBookmarksEntry);

		boolean isNew = customBookmarksEntry.isNew();

		Session session = null;

		try {
			session = openSession();

			if (customBookmarksEntry.isNew()) {
				session.save(customBookmarksEntry);

				customBookmarksEntry.setNew(false);
			}
			else {
				customBookmarksEntry = (CustomBookmarksEntry)session.merge(customBookmarksEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(CustomBookmarksEntryModelImpl.ENTITY_CACHE_ENABLED,
			CustomBookmarksEntryImpl.class,
			customBookmarksEntry.getPrimaryKey(), customBookmarksEntry, false);

		customBookmarksEntry.resetOriginalValues();

		return customBookmarksEntry;
	}

	protected CustomBookmarksEntry toUnwrappedModel(
		CustomBookmarksEntry customBookmarksEntry) {
		if (customBookmarksEntry instanceof CustomBookmarksEntryImpl) {
			return customBookmarksEntry;
		}

		CustomBookmarksEntryImpl customBookmarksEntryImpl = new CustomBookmarksEntryImpl();

		customBookmarksEntryImpl.setNew(customBookmarksEntry.isNew());
		customBookmarksEntryImpl.setPrimaryKey(customBookmarksEntry.getPrimaryKey());

		customBookmarksEntryImpl.setId(customBookmarksEntry.getId());

		return customBookmarksEntryImpl;
	}

	/**
	 * Returns the custom bookmarks entry with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the custom bookmarks entry
	 * @return the custom bookmarks entry
	 * @throws NoSuchCustomBookmarksEntryException if a custom bookmarks entry with the primary key could not be found
	 */
	@Override
	public CustomBookmarksEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCustomBookmarksEntryException {
		CustomBookmarksEntry customBookmarksEntry = fetchByPrimaryKey(primaryKey);

		if (customBookmarksEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCustomBookmarksEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return customBookmarksEntry;
	}

	/**
	 * Returns the custom bookmarks entry with the primary key or throws a {@link NoSuchCustomBookmarksEntryException} if it could not be found.
	 *
	 * @param id the primary key of the custom bookmarks entry
	 * @return the custom bookmarks entry
	 * @throws NoSuchCustomBookmarksEntryException if a custom bookmarks entry with the primary key could not be found
	 */
	@Override
	public CustomBookmarksEntry findByPrimaryKey(long id)
		throws NoSuchCustomBookmarksEntryException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the custom bookmarks entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the custom bookmarks entry
	 * @return the custom bookmarks entry, or <code>null</code> if a custom bookmarks entry with the primary key could not be found
	 */
	@Override
	public CustomBookmarksEntry fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(CustomBookmarksEntryModelImpl.ENTITY_CACHE_ENABLED,
				CustomBookmarksEntryImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		CustomBookmarksEntry customBookmarksEntry = (CustomBookmarksEntry)serializable;

		if (customBookmarksEntry == null) {
			Session session = null;

			try {
				session = openSession();

				customBookmarksEntry = (CustomBookmarksEntry)session.get(CustomBookmarksEntryImpl.class,
						primaryKey);

				if (customBookmarksEntry != null) {
					cacheResult(customBookmarksEntry);
				}
				else {
					entityCache.putResult(CustomBookmarksEntryModelImpl.ENTITY_CACHE_ENABLED,
						CustomBookmarksEntryImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CustomBookmarksEntryModelImpl.ENTITY_CACHE_ENABLED,
					CustomBookmarksEntryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return customBookmarksEntry;
	}

	/**
	 * Returns the custom bookmarks entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the custom bookmarks entry
	 * @return the custom bookmarks entry, or <code>null</code> if a custom bookmarks entry with the primary key could not be found
	 */
	@Override
	public CustomBookmarksEntry fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, CustomBookmarksEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CustomBookmarksEntry> map = new HashMap<Serializable, CustomBookmarksEntry>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CustomBookmarksEntry customBookmarksEntry = fetchByPrimaryKey(primaryKey);

			if (customBookmarksEntry != null) {
				map.put(primaryKey, customBookmarksEntry);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(CustomBookmarksEntryModelImpl.ENTITY_CACHE_ENABLED,
					CustomBookmarksEntryImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (CustomBookmarksEntry)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CUSTOMBOOKMARKSENTRY_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (CustomBookmarksEntry customBookmarksEntry : (List<CustomBookmarksEntry>)q.list()) {
				map.put(customBookmarksEntry.getPrimaryKeyObj(),
					customBookmarksEntry);

				cacheResult(customBookmarksEntry);

				uncachedPrimaryKeys.remove(customBookmarksEntry.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CustomBookmarksEntryModelImpl.ENTITY_CACHE_ENABLED,
					CustomBookmarksEntryImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the custom bookmarks entries.
	 *
	 * @return the custom bookmarks entries
	 */
	@Override
	public List<CustomBookmarksEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<CustomBookmarksEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<CustomBookmarksEntry> findAll(int start, int end,
		OrderByComparator<CustomBookmarksEntry> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<CustomBookmarksEntry> findAll(int start, int end,
		OrderByComparator<CustomBookmarksEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<CustomBookmarksEntry> list = null;

		if (retrieveFromCache) {
			list = (List<CustomBookmarksEntry>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CUSTOMBOOKMARKSENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CUSTOMBOOKMARKSENTRY;

				if (pagination) {
					sql = sql.concat(CustomBookmarksEntryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CustomBookmarksEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CustomBookmarksEntry>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the custom bookmarks entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CustomBookmarksEntry customBookmarksEntry : findAll()) {
			remove(customBookmarksEntry);
		}
	}

	/**
	 * Returns the number of custom bookmarks entries.
	 *
	 * @return the number of custom bookmarks entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CUSTOMBOOKMARKSENTRY);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CustomBookmarksEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the custom bookmarks entry persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(CustomBookmarksEntryImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CUSTOMBOOKMARKSENTRY = "SELECT customBookmarksEntry FROM CustomBookmarksEntry customBookmarksEntry";
	private static final String _SQL_SELECT_CUSTOMBOOKMARKSENTRY_WHERE_PKS_IN = "SELECT customBookmarksEntry FROM CustomBookmarksEntry customBookmarksEntry WHERE id_ IN (";
	private static final String _SQL_COUNT_CUSTOMBOOKMARKSENTRY = "SELECT COUNT(customBookmarksEntry) FROM CustomBookmarksEntry customBookmarksEntry";
	private static final String _ORDER_BY_ENTITY_ALIAS = "customBookmarksEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CustomBookmarksEntry exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(CustomBookmarksEntryPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
}