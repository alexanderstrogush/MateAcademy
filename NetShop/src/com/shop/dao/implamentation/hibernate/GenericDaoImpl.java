package com.shop.dao.implamentation.hibernate;

import com.shop.dao.GenericDao;
import com.shop.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GenericDaoImpl<T> implements GenericDao<T> {

    private static final SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

    @Override
    public long add(T entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            long id = (long) session.save(entity);
            session.getTransaction().commit();
            return id;
        }
    }

    @Override
    public Optional<T> getById(Class<T> entityClass, long id) {
        T entity;
        try (Session session = sessionFactory.openSession()) {
            entity = session.get(entityClass, id);
            if (entity != null) {
                return Optional.of(entity);
            }
            return Optional.empty();
        }
    }

    @Override
    public List<T> getAll(Class<T> entityClass) {
        List<T> entities = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            entities = session.createCriteria(entityClass).list();
        }
        return entities;
    }

    @Override
    public void update(T entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(T entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        }
    }
}
