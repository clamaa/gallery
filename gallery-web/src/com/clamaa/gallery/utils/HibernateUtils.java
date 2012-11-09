package com.clamaa.gallery.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Clark Ma
 *         created at 11/8/12
 */
public class HibernateUtils {

    private static SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static void shutDown(){
        getSessionFactory().close();
    }

}
