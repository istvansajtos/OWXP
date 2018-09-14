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

<%@ include file="/wiki/init.jsp" %>

<%= LanguageUtil.get(request, "you-are-moving-wiki-pages-to-the-recycle-bin-please-choose-what-happens-with-the-child-pages") %>

<liferay-ui:message key="you-are-moving-wiki-pages-to-the-recycle-bin-please-choose-what-happens-with-the-child-pages" />

<aui:button-row>
	<aui:button id="moveToTrashPopup" value="move-to-trash" />

	<aui:button id="moveUnderRootPage" value="move-under-the-root-page" />
</aui:button-row>

<aui:script position="inline" use="aui-base">
	var moveToTrashButton = A.one('#<portlet:namespace />moveToTrashPopup');
	moveToTrashButton.on('click',
		function() {
			alert("start");
			var form = AUI.$(document.<portlet:namespace />fm);

			form.attr('method', 'post');
			form.fm('<%= Constants.CMD %>').val('<%= Constants.MOVE_TO_TRASH %>');

			submitForm(form, '<portlet:actionURL name="/wiki/edit_page" />');
		}
	);
</aui:script>