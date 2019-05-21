package com.shop.utils;

import com.shop.model.Cart;
import com.shop.model.Code;
import com.shop.model.Good;
import com.shop.model.Items;
import com.shop.model.Order;
import com.shop.model.Role;
import com.shop.model.User;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {

    String name;
    private static final Logger logger = Logger.getLogger(HibernateSessionFactoryUtil.class);
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Role.class);
                configuration.addAnnotatedClass(Cart.class);
                configuration.addAnnotatedClass(Good.class);
                configuration.addAnnotatedClass(Items.class);
                configuration.addAnnotatedClass(Order.class);
                configuration.addAnnotatedClass(Code.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                logger.error("Error in HibernateSessionFactory", e);
            }
        }
        return sessionFactory;
    }
}