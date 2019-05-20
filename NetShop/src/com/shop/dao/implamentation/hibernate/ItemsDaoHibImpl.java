package com.shop.dao.implamentation.hibernate;

import com.shop.model.Items;
import com.shop.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ItemsDaoHibImpl {

    private static final SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

    public long addItem(Items items) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            long itemId = (long) session.save(items);
            session.getTransaction().commit();
            return itemId;
        }
    }
}
