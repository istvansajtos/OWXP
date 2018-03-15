<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */
--%>

<%@ include file="/init.jsp" %>

<%@ page import="com.liferay.portal.kernel.model.UserNotificationDeliveryConstants" %><%@
page import="com.liferay.portal.kernel.portlet.PortalPreferences" %><%@
page import="com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil" %><%@
page import="com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil" %>

<%
_resetUserNoticationEventsCount(themeDisplay.getUserId());

int archivedUserNotificationEventsCount = UserNotificationEventLocalServiceUtil.getArchivedUserNotificationEventsCount(themeDisplay.getUserId(), UserNotificationDeliveryConstants.TYPE_WEBSITE, false, false);

String navigation = ParamUtil.getString(request, "navigation", "all");

boolean actionRequired = ParamUtil.getBoolean(request, "actionRequired");

String orderByCol = "date";
String orderByType = ParamUtil.getString(request, "orderByType", "desc");

SearchContainer notificationsSearchContainer = new SearchContainer(renderRequest, currentURLObj, null, actionRequired ? "you-do-not-have-any-requests" : "you-do-not-have-any-notifications");

String searchContainerId = "userNotificationEvents";

if (actionRequired) {
	searchContainerId = "actionableUserNotificationEvents";
}

notificationsSearchContainer.setId(searchContainerId);

NotificationsUtil.populateResults(themeDisplay.getUserId(), actionRequired, navigation, orderByType, notificationsSearchContainer);

PortletURL navigationURL = PortletURLUtil.clone(currentURLObj, renderResponse);

navigationURL.setParameter(SearchContainer.DEFAULT_CUR_PARAM, "0");
%>

<aui:nav-bar markupView="lexicon">
	<aui:nav cssClass="navbar-nav">
		<liferay-portlet:renderURL var="viewNotificationsURL">
			<liferay-portlet:param name="actionRequired" value="<%= StringPool.FALSE %>" />
		</liferay-portlet:renderURL>

		<aui:nav-item
			href="<%= viewNotificationsURL %>"
			label="notifications-list"
			selected="<%= !actionRequired %>"
		/>

		<liferay-portlet:renderURL var="viewRequestsURL">
			<liferay-portlet:param name="actionRequired" value="<%= StringPool.TRUE %>" />
		</liferay-portlet:renderURL>

		<aui:nav-item
			href="<%= viewRequestsURL %>"
			label="requests-list"
			selected="<%= actionRequired %>"
		/>
	</aui:nav>
</aui:nav-bar>

<liferay-frontend:management-bar
	disabled="<%= NotificationsUtil.getAllNotificationsCount(themeDisplay.getUserId(), actionRequired) == 0 %>"
	includeCheckBox="<%= true %>"
	searchContainerId="<%= searchContainerId %>"
>
	<liferay-frontend:management-bar-buttons>
		<liferay-frontend:management-bar-display-buttons
			displayViews='<%= new String[] {"descriptive"} %>'
			portletURL="<%= currentURLObj %>"
			selectedDisplayStyle="descriptive"
		/>

		<c:if test="<%= !actionRequired && (archivedUserNotificationEventsCount != 0) %>">
			<portlet:actionURL name="/notifications/markAllAsRead" var="markAllAsRead" />

			<liferay-ui:icon
				iconCssClass="icon-remove"
				label="<%= true %>"
				message="Mark all as read"
				url="<%= markAllAsRead %>"
			/>
		</c:if>
	</liferay-frontend:management-bar-buttons>

	<liferay-frontend:management-bar-filters>

		<%
		String[] navigationKeys = {"all"};

		if (!actionRequired) {
			navigationKeys = new String[] {"all", "unread", "read"};
		}
		%>

		<liferay-frontend:management-bar-navigation
			navigationKeys="<%= navigationKeys %>"
			portletURL="<%= PortletURLUtil.clone(navigationURL, renderResponse) %>"
		/>

		<liferay-frontend:management-bar-sort
			orderByCol="<%= orderByCol %>"
			orderByType="<%= orderByType %>"
			orderColumns='<%= new String[] {"date"} %>'
			portletURL="<%= PortletURLUtil.clone(navigationURL, renderResponse) %>"
		/>
	</liferay-frontend:management-bar-filters>

	<liferay-frontend:management-bar-action-buttons>
		<c:if test="<%= !actionRequired %>">
			<liferay-frontend:management-bar-button href='<%= "javascript:" + renderResponse.getNamespace() + "markNotificationsAsRead();" %>' icon="envelope-open" label="mark-as-read" />
			<liferay-frontend:management-bar-button href='<%= "javascript:" + renderResponse.getNamespace() + "markNotificationsAsUnread();" %>' icon="envelope-closed" label="mark-as-unread" />
		</c:if>

		<liferay-frontend:management-bar-button href='<%= "javascript:" + renderResponse.getNamespace() + "deleteAllNotifications();" %>' icon="times" label="delete" />
	</liferay-frontend:management-bar-action-buttons>
</liferay-frontend:management-bar>

<div class="container-fluid-1280 main-content-body">
	<aui:form action="<%= currentURL %>" method="get" name="fm">
		<div class="user-notifications">
			<liferay-ui:search-container
				rowChecker="<%= new EmptyOnClickRowChecker(renderResponse) %>"
				searchContainer="<%= notificationsSearchContainer %>"
			>
				<liferay-ui:search-container-row
					className="com.liferay.portal.kernel.model.UserNotificationEvent"
					keyProperty="userNotificationEventId"
					modelVar="userNotificationEvent"
				>
					<%@ include file="/notifications/user_notification_entry.jspf" %>
				</liferay-ui:search-container-row>

				<liferay-ui:search-iterator displayStyle="descriptive" markupView="lexicon" />
			</liferay-ui:search-container>
		</div>
	</aui:form>
</div>

<aui:script>
	function <portlet:namespace />deleteAllNotifications() {
		var form = AUI.$(document.<portlet:namespace />fm);

		form.attr('method', 'post');

		submitForm(form, '<portlet:actionURL name="deleteAllNotifications"><portlet:param name="redirect" value="<%= currentURL %>" /></portlet:actionURL>');
	}

	function <portlet:namespace />markNotificationsAsRead() {
		var form = AUI.$(document.<portlet:namespace />fm);

		form.attr('method', 'post');

		submitForm(form, '<portlet:actionURL name="markNotificationsAsRead"><portlet:param name="redirect" value="<%= currentURL %>" /></portlet:actionURL>');
	}

	function <portlet:namespace />markNotificationsAsUnread() {
		var form = AUI.$(document.<portlet:namespace />fm);

		form.attr('method', 'post');

		submitForm(form, '<portlet:actionURL name="markNotificationsAsUnread"><portlet:param name="redirect" value="<%= currentURL %>" /></portlet:actionURL>');
	}
</aui:script>

<aui:script use="aui-base,liferay-notice">
	var form = A.one('#<portlet:namespace />fm');

	form.delegate(
		'click',
		function(event) {
			event.preventDefault();

			var currentTarget = event.currentTarget;

			A.io.request(
				currentTarget.attr('href'),
				{
					dataType: 'JSON',
					on: {
						success: function() {
							var responseData = this.get('responseData');

							if (responseData.success) {
								var notificationContainer = currentTarget.ancestor('li.list-group-item');

								if (notificationContainer) {
									var markAsReadURL = notificationContainer.one('a').attr('href');

									A.io.request(markAsReadURL);

									notificationContainer.remove();
								}
							}
							else {
								getNotice().show();
							}
						}
					}
				}
			);
		},
		'.user-notification-action'
	);

	var notice;

	function getNotice() {
		if (!notice) {
			notice = new Liferay.Notice(
				{
					closeText: false,
					content: '<liferay-ui:message key="an-unexpected-error-occurred"/><button class="close" type="button">&times;</button>',
					timeout: 5000,
					toggleText: false,
					type: 'warning',
					useAnimation: false
				}
			);
		}

		return notice;
	}
</aui:script>

<%!
private void _resetUserNoticationEventsCount(long userId) {
	PortalPreferences portalPreferences =
		PortletPreferencesFactoryUtil.getPortalPreferences(userId, true);

	portalPreferences.setValue(
		UserNotificationEvent.class.getName(),
		"useLegacyUserNotificationEventsCount", "false");

	portalPreferences.setValue(
		UserNotificationEvent.class.getName(),
		"userNotificationEventsCount", "0");
}
%>