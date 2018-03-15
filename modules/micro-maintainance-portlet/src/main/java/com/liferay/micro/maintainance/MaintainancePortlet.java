package com.liferay.micro.maintainance;

import javax.portlet.GenericPortlet;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author Rimi Saadou
 * @author Laszlo Hudak
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=micro-maintainance-portlet Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MaintainancePortlet extends GenericPortlet {
}