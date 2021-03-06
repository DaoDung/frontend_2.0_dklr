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

package org.opencps.jasper.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import org.opencps.jasper.model.jasper;
import org.opencps.jasper.model.jasperModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the jasper service. Represents a row in the &quot;temp_jasper&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link jasperModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link jasperImpl}.
 * </p>
 *
 * @author Binhth
 * @see jasperImpl
 * @see jasper
 * @see jasperModel
 * @generated
 */
@ProviderType
public class jasperModelImpl extends BaseModelImpl<jasper>
	implements jasperModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a jasper model instance should use the {@link jasper} interface instead.
	 */
	public static final String TABLE_NAME = "temp_jasper";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "jasperId", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("jasperId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table temp_jasper (uuid_ VARCHAR(75) null,jasperId LONG not null primary key)";
	public static final String TABLE_SQL_DROP = "drop table temp_jasper";
	public static final String ORDER_BY_JPQL = " ORDER BY jasper.jasperId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY temp_jasper.jasperId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(backend.jasper.process.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.org.opencps.jasper.model.jasper"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(backend.jasper.process.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.org.opencps.jasper.model.jasper"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(backend.jasper.process.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.opencps.jasper.model.jasper"),
			true);
	public static final long UUID_COLUMN_BITMASK = 1L;
	public static final long JASPERID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(backend.jasper.process.service.util.ServiceProps.get(
				"lock.expiration.time.org.opencps.jasper.model.jasper"));

	public jasperModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _jasperId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setJasperId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _jasperId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return jasper.class;
	}

	@Override
	public String getModelClassName() {
		return jasper.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("jasperId", getJasperId());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long jasperId = (Long)attributes.get("jasperId");

		if (jasperId != null) {
			setJasperId(jasperId);
		}
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getJasperId() {
		return _jasperId;
	}

	@Override
	public void setJasperId(long jasperId) {
		_jasperId = jasperId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			jasper.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public jasper toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (jasper)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		jasperImpl jasperImpl = new jasperImpl();

		jasperImpl.setUuid(getUuid());
		jasperImpl.setJasperId(getJasperId());

		jasperImpl.resetOriginalValues();

		return jasperImpl;
	}

	@Override
	public int compareTo(jasper jasper) {
		long primaryKey = jasper.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof jasper)) {
			return false;
		}

		jasper jasper = (jasper)obj;

		long primaryKey = jasper.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		jasperModelImpl jasperModelImpl = this;

		jasperModelImpl._originalUuid = jasperModelImpl._uuid;

		jasperModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<jasper> toCacheModel() {
		jasperCacheModel jasperCacheModel = new jasperCacheModel();

		jasperCacheModel.uuid = getUuid();

		String uuid = jasperCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			jasperCacheModel.uuid = null;
		}

		jasperCacheModel.jasperId = getJasperId();

		return jasperCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", jasperId=");
		sb.append(getJasperId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("org.opencps.jasper.model.jasper");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jasperId</column-name><column-value><![CDATA[");
		sb.append(getJasperId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = jasper.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			jasper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _jasperId;
	private long _columnBitmask;
	private jasper _escapedModel;
}