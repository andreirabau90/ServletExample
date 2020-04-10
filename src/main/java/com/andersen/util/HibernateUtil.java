package com.andersen.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    public final static SessionFactory sessionFactory = getSessionFactory();

    private static SessionFactory getSessionFactory() {

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        return new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();

    }


}
