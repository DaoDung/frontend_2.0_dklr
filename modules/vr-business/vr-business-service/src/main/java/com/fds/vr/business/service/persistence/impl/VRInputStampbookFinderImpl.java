package com.fds.vr.business.service.persistence.impl;

import com.fds.vr.business.action.util.ActionUtil;
import com.fds.vr.business.model.VRInputStampbook;
import com.fds.vr.business.model.impl.VRInputStampbookModelImpl;
import com.fds.vr.business.service.persistence.VRInputStampbookFinder;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Iterator;
import java.util.List;

public class VRInputStampbookFinderImpl extends VRInputStampbookFinderBaseImpl implements VRInputStampbookFinder {

	Log log = LogFactoryUtil.getLog(VRInputStampbookFinderImpl.class);

	public long validateInputStampBook(long mtCore, String stampShortNo, long serialStartNo, long serialEndNo) {
		Session session = null;
		try {
			session = openSession();

			String sql = "SELECT COUNT(*) AS total FROM vr_inputstampbook WHERE mtCore = " + mtCore
					+ " AND stampShortNo = '" + stampShortNo + "'";
			sql += " AND ((serialStartNo <= " + serialStartNo + " AND " + serialStartNo
					+ " <= serialEndNo) OR (serialStartNo <= " + serialEndNo + " AND " + serialEndNo
					+ " <= serialEndNo))";

			log.info("===>>>VRInputStampbook Validate Input: " + sql);

			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addScalar("total", Type.LONG);

			Iterator<Long> itr = q.list().iterator();

			if (itr.hasNext()) {
				Long count = itr.next();
				if (count != null) {
					return count.intValue();
				}
			}
			return 0;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}

	}

	public JSONArray findData(String sql, List<String> columnNames, List<String> dataTypes, Class<?> modelClazz,
			String modelClassName, int start, int end) throws SystemException {

		Session session = null;
		JSONArray results = JSONFactoryUtil.createJSONArray();
		try {
			session = openSession();

			log.info("===>>>VRInputStampbookFinder " + sql + "|" + start + "|" + end);

			SQLQuery q = session.createSQLQuery(sql);

			q.setCacheable(false);

			if (Validator.isNotNull(modelClassName) && modelClazz != null) {
				q.addEntity(modelClassName, modelClazz);
				List<VRInputStampbook> vrInputStampbooks = (List<VRInputStampbook>) QueryUtil.list(q, getDialect(),
						start, end);
				if (vrInputStampbooks != null) {
					for (VRInputStampbook vrInputStampbook : vrInputStampbooks) {
						JSONObject json = ActionUtil.object2Json(vrInputStampbook, VRInputStampbookModelImpl.class, "");
						results.put(json);
					}
				}
			} else {

				if (columnNames.size() > 1) {
					Iterator<Object[]> itr = (Iterator<Object[]>) QueryUtil.iterate(q, getDialect(), start, end);

					if (itr.hasNext()) {
						while (itr.hasNext()) {
							Object[] objects = itr.next();
							JSONObject json = ActionUtil.array2Json(objects, columnNames, dataTypes);
							results.put(json);
						}

					}
				} else if (columnNames.size() == 1) {
					Iterator itr = QueryUtil.iterate(q, getDialect(), start, end);

					if (itr.hasNext()) {
						while (itr.hasNext()) {

							JSONObject json = JSONFactoryUtil.createJSONObject();
							json.put(columnNames.get(0), itr.next());
							results.put(json);
						}

					}
				}
			}

			return results;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public long countData(String sql) throws SystemException {

		Session session = null;

		try {
			session = openSession();

			log.info("===>>>VRInputStampbookFinder " + sql);

			SQLQuery q = session.createSQLQuery(sql);

			q.setCacheable(false);

			q.addScalar("total", Type.LONG);

			Iterator<Long> itr = q.list().iterator();

			if (itr.hasNext()) {
				Long count = itr.next();
				if (count != null) {
					return count.intValue();
				}
			}
			return 0;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
}
