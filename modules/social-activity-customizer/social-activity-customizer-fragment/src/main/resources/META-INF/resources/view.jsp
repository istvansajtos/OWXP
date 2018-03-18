<%--
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
--%>

<%@page import="com.liferay.social.activity.customizer.activities.query.helper.CustomSocialActivitiesQueryHelper" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@page import="com.liferay.petra.string.StringPool" %>

<%@ include file="/init.jsp" %>

<%
CustomSocialActivitiesQueryHelper customSocialActivitiesQueryHelper = (CustomSocialActivitiesQueryHelper)request.getAttribute(SocialActivitiesWebKeys.SOCIAL_ACTIVITIES_QUERY_HELPER);

socialActivitiesDisplayContext = new DefaultSocialActivitiesDisplayContext(socialActivitiesRequestHelper, customSocialActivitiesQueryHelper);

String activityType = ParamUtil.getString(request, "activityType");
long[] types = null;

if (activityType != null && !activityType.equals("ALL")) {
	types = new long[]{2};

	customSocialActivitiesQueryHelper.setTypes(types);
}
%>

<c:if test="<%= socialActivitiesDisplayContext.isTabsVisible() %>">
	<liferay-ui:tabs
		names="<%= socialActivitiesDisplayContext.getTabsNames() %>"
		type="tabs nav-tabs-default"
		url="<%= socialActivitiesDisplayContext.getTabsURL() %>"
		value="<%= socialActivitiesDisplayContext.getSelectedTabName() %>"
	/>
</c:if>

<liferay-ui:social-activities
	activitySets="<%= socialActivitiesDisplayContext.getSocialActivitySets() %>"
	feedDisplayStyle="<%= socialActivitiesDisplayContext.getRSSDisplayStyle() %>"
	feedEnabled="<%= socialActivitiesDisplayContext.isRSSEnabled() %>"
	feedResourceURL="<%= socialActivitiesDisplayContext.getRSSResourceURL() %>"
	feedTitle="<%= socialActivitiesDisplayContext.getTaglibFeedTitle() %>"
	feedType="<%= socialActivitiesDisplayContext.getRSSFeedType() %>"
	feedURLMessage="<%= socialActivitiesDisplayContext.getTaglibFeedTitle() %>"
/>