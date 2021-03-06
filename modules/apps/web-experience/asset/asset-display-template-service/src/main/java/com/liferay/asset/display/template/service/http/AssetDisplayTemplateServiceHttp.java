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

package com.liferay.asset.display.template.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.asset.display.template.service.AssetDisplayTemplateServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * {@link AssetDisplayTemplateServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * {@link HttpPrincipal} parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssetDisplayTemplateServiceSoap
 * @see HttpPrincipal
 * @see AssetDisplayTemplateServiceUtil
 * @generated
 */
@ProviderType
public class AssetDisplayTemplateServiceHttp {
	public static com.liferay.asset.display.template.model.AssetDisplayTemplate addAssetDisplayTemplate(
		HttpPrincipal httpPrincipal, long groupId, long userId,
		java.lang.String name, long classNameId, java.lang.String language,
		java.lang.String scriptContent, boolean main,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(AssetDisplayTemplateServiceUtil.class,
					"addAssetDisplayTemplate",
					_addAssetDisplayTemplateParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					userId, name, classNameId, language, scriptContent, main,
					serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.asset.display.template.model.AssetDisplayTemplate)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.asset.display.template.model.AssetDisplayTemplate deleteAssetDisplayTemplate(
		HttpPrincipal httpPrincipal, long assetDisplayTemplateId)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(AssetDisplayTemplateServiceUtil.class,
					"deleteAssetDisplayTemplate",
					_deleteAssetDisplayTemplateParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					assetDisplayTemplateId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.asset.display.template.model.AssetDisplayTemplate)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.asset.display.template.model.AssetDisplayTemplate updateAssetDisplayTemplate(
		HttpPrincipal httpPrincipal, long assetDisplayTemplateId,
		java.lang.String name, long classNameId, java.lang.String language,
		java.lang.String scriptContent, boolean main,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(AssetDisplayTemplateServiceUtil.class,
					"updateAssetDisplayTemplate",
					_updateAssetDisplayTemplateParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					assetDisplayTemplateId, name, classNameId, language,
					scriptContent, main, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.asset.display.template.model.AssetDisplayTemplate)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(AssetDisplayTemplateServiceHttp.class);
	private static final Class<?>[] _addAssetDisplayTemplateParameterTypes0 = new Class[] {
			long.class, long.class, java.lang.String.class, long.class,
			java.lang.String.class, java.lang.String.class, boolean.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deleteAssetDisplayTemplateParameterTypes1 = new Class[] {
			long.class
		};
	private static final Class<?>[] _updateAssetDisplayTemplateParameterTypes2 = new Class[] {
			long.class, java.lang.String.class, long.class,
			java.lang.String.class, java.lang.String.class, boolean.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
}