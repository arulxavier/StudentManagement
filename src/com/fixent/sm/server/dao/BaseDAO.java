package com.fixent.sm.server.dao;

import org.hibernate.Session;

import com.fixent.sm.server.service.util.SessionFactoryUtil;

public class BaseDAO {
	
//	private static final SessionFactory sessionFactory = buildSessionFactory();

	/*private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}*/

	/*public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}*/

	public static void shutdown() {
		// Close caches and connection pools
		SessionFactoryUtil.getInstance().close();
	}
	
	public static Session getSession() {
		
		return SessionFactoryUtil.getInstance().getCurrentSession();
//		return BaseDAO.getSessionFactory().openSession();
	}



}
