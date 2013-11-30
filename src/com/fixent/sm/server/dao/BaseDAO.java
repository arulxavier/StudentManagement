package com.fixent.sm.server.dao;

import org.hibernate.Session;

import com.fixent.sm.server.service.util.SessionFactoryUtil;

public class BaseDAO {

	public static void shutdown() {
		// Close caches and connection pools
		SessionFactoryUtil.getInstance().close();
	}

	public static Session getSession() {

		return SessionFactoryUtil.getInstance().getCurrentSession();
	}

}
