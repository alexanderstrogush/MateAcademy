package com.shop.dao.implamentation.hibernate;

import com.shop.dao.GoodDao;
import com.shop.model.Good;
import com.shop.utils.HibernateSessionFactoryUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GoodDaoHibImpl implements GoodDao {

    private static final Logger LOGGER = Logger.getLogger(GoodDaoHibImpl.class);
    private static final SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

    @Override
    public long addGood(Good good) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            long id = (long) session.save(good);
            LOGGER.debug("New good with name (" + good.getName() + ") created");
            session.getTransaction().commit();
            return id;
        }
    }

    @Override
    public Optional<Good> getGoodById(long goodId) {
        Good good;
        try (Session session = sessionFactory.openSession()) {
            good = session.get(Good.class, goodId);
            if (good != null) {
                LOGGER.debug("Got good with id (" + goodId + ") from DB");
                return Optional.of(good);
            }
            LOGGER.debug("Can't got good with id (" + goodId + ") from DB");
            return Optional.empty();
        }
    }

    @Override
    public List<Good> getAllGoods() {
        List<Good> goods = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            LOGGER.debug("Got all users from DB");
            goods = session.createQuery("FROM Good").list();
        }
        return goods;
    }

    @Override
    public int deleteGoodById(long goodId) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("delete from Good where good_id = :good_id");
            query.setParameter("good_id", goodId);
            int rows = query.executeUpdate();
            session.getTransaction().commit();
            if (rows == 1) {
                LOGGER.debug("Good deleted successfully");
            } else {
                LOGGER.debug("Good deleting failed");
            }
            return rows;
        }
    }

    @Override
    public int updateGoodById(Good good) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("update Good set name = :name, description = :description, price = :price where good_id = :good_id");
            query.setParameter("name", good.getName());
            query.setParameter("description", good.getDescription());
            query.setParameter("price", good.getPrice());
            query.setParameter("good_id", good.getGoodId());
            int rows = query.executeUpdate();
            session.getTransaction().commit();
            if (rows == 1) {
                LOGGER.debug("Good updated successfully");
            } else {
                LOGGER.debug("Good updating failed");
            }
            return rows;
        }
    }
}
