package com.liferay.wiki.customizer.portlet.action.portlet;

import com.liferay.portal.kernel.model.TrashedModel;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.sanitizer.SanitizerException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.trash.kernel.util.TrashUtil;
import com.liferay.wiki.constants.WikiPortletKeys;
import com.liferay.wiki.customizer.service.WikiPageCustomService;
import com.liferay.wiki.customizer.service.WikiPageCustomServiceUtil;
import com.liferay.wiki.model.WikiPage;
import com.liferay.wiki.service.WikiPageService;
import com.test.service.FooServiceUtil;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Liferay
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + WikiPortletKeys.WIKI,
		"javax.portlet.name=" + WikiPortletKeys.WIKI_ADMIN,
		"javax.portlet.name=" + WikiPortletKeys.WIKI_DISPLAY,
		"mvc.command.name=/wiki/custom_edit_page"
	},
	service = MVCActionCommand.class
)
public class CustomEditPageMVCActionCommand extends BaseMVCActionCommand  {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		System.out.println(">>> In CustomEditPageMVCActionCommandPortlet");

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.MOVE_TO_TRASH)) {
				deletePage(actionRequest);
			}
			/*else if (cmd.equals(Constants.RESTORE)) {
				restorePage(actionRequest);
			}*/

			if (Validator.isNotNull(cmd)) {
				String redirect = ParamUtil.getString(
					actionRequest, "redirect");

				sendRedirect(actionRequest, actionResponse, redirect);
			}
		}
		catch (Exception e) {
			if (e instanceof PrincipalException) {
				SessionErrors.add(actionRequest, e.getClass());
			}
			else {
				Throwable cause = e.getCause();

				if (cause instanceof SanitizerException) {
					SessionErrors.add(actionRequest, SanitizerException.class);
				}
				else {
					throw e;
				}
			}
		}
	}

	protected void deletePage(ActionRequest actionRequest) throws Exception {
		long nodeId = ParamUtil.getLong(actionRequest, "nodeId");
		String title = ParamUtil.getString(actionRequest, "title");
		double version = ParamUtil.getDouble(actionRequest, "version");

		String[] deletePageTitles = null;

		if (Validator.isNotNull(title)) {
			deletePageTitles = new String[] {title};
		}
		else {
			deletePageTitles = ParamUtil.getStringValues(
				actionRequest, "rowIdsWikiPage");
		}

		List<TrashedModel> trashedModels = new ArrayList<>();

		for (String deletePageTitle : deletePageTitles) {
			WikiPage trashedWikiPage = null;

			if (version > 0) {
				FooServiceUtil.print();
//				trashedWikiPage = _wikiPageCustomService.movePageToTrash(
				trashedWikiPage = _wikiPageService.movePageToTrash(
					nodeId, deletePageTitle, version);
			}
			else {
				FooServiceUtil.print();
//				trashedWikiPage = _wikiPageCustomService.movePageToTrash(
				trashedWikiPage = FooServiceUtil.movePageToTrash(
					nodeId, deletePageTitle);
				trashedWikiPage = _wikiPageService.movePageToTrash(
					nodeId, deletePageTitle);
			}

			trashedModels.add(trashedWikiPage);
		}

		if (!trashedModels.isEmpty()) {
			TrashUtil.addTrashSessionMessages(actionRequest, trashedModels);

			hideDefaultSuccessMessage(actionRequest);
		}
	}

/*	protected void restorePage(ActionRequest actionRequest) throws Exception {
		long[] restoreEntryIds = StringUtil.split(
			ParamUtil.getString(actionRequest, "restoreTrashEntryIds"), 0L);

		for (long restoreEntryId : restoreEntryIds) {
			long overridePageResourcePrimKey = 0;

			TrashEntry trashEntry = _trashEntryLocalService.getTrashEntry(
				restoreEntryId);

			WikiPageResource pageResource =
				_wikiPageResourceLocalService.getPageResource(
					trashEntry.getClassPK());

			String title = TrashUtil.getOriginalTitle(pageResource.getTitle());

			WikiWebComponentProvider wikiWebComponentProvider =
				WikiWebComponentProvider.getWikiWebComponentProvider();

			WikiGroupServiceConfiguration wikiGroupServiceConfiguration =
				wikiWebComponentProvider.getWikiGroupServiceConfiguration();

			if (title.equals(wikiGroupServiceConfiguration.frontPageName())) {
				WikiPage overridePage = _wikiPageLocalService.fetchPage(
					pageResource.getNodeId(),
					wikiGroupServiceConfiguration.frontPageName());

				if (overridePage != null) {
					overridePageResourcePrimKey =
						overridePage.getResourcePrimKey();
				}
			}

			_trashEntryService.restoreEntry(
				restoreEntryId, overridePageResourcePrimKey, null);
		}
	}*/

/*	@Reference(unbind = "-")
	protected void setTrashEntryLocalService(
		TrashEntryLocalService trashEntryLocalService) {

		_trashEntryLocalService = trashEntryLocalService;
	}

	@Reference(unbind = "-")
	protected void setTrashEntryService(TrashEntryService trashEntryService) {
		_trashEntryService = trashEntryService;
	}
*/
/*	@Reference(unbind = "-")
	protected void setWikiPageCustomService(
		WikiPageCustomService wikiPageCustomService) {

		_wikiPageCustomService = wikiPageCustomService;
	}*/
/*
	@Reference(unbind = "-")
	protected void setWikiPageLocalService(
		WikiPageLocalService wikiPageLocalService) {

		_wikiPageLocalService = wikiPageLocalService;
	}

	@Reference(unbind = "-")
	protected void setWikiPageResourceLocalService(
		WikiPageResourceLocalService wikiPageResourceLocalService) {

		_wikiPageResourceLocalService = wikiPageResourceLocalService;
	}
*/
	@Reference(unbind = "-")
	protected void setWikiPageService(WikiPageService wikiPageService) {
		_wikiPageService = wikiPageService;
	}

/*	private TrashEntryLocalService _trashEntryLocalService;
	private TrashEntryService _trashEntryService;*/
//	@Reference
//	private WikiPageCustomService _wikiPageCustomService;
/*	private WikiPageLocalService _wikiPageLocalService;
	private WikiPageResourceLocalService _wikiPageResourceLocalService;*/
	private WikiPageService _wikiPageService;
}