package com.clamaa.gallery.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * @author Clark Ma
 *         created at 11/8/12
 */
public class HibernateUtils {

    private static SessionFactory sessionFactory;

    static {
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().buildServiceRegistry();
        sessionFactory = new Configuration().configure().buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static void shutDown(){
        getSessionFactory().close();
    }

}
