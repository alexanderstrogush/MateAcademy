package com.shop.dao.implamentation.hibernate;

import com.shop.dao.UserDao;
import com.shop.model.User;
import com.shop.utils.HibernateSessionFactoryUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoHibImpl extends GenericDaoImpl<User> implements UserDao {

    private static final Logger LOGGER = Logger.getLogger(UserDaoHibImpl.class);
    private static final SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

    public Optional<User> getUserByUsername(String username) {
        List<User> users = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("FROM User WHERE username = :username");
            query.setParameter("username", username);
            users = query.list();
            if (!users.isEmpty()) {
                LOGGER.debug("Got user with username(" + username + ") from DB");
                return Optional.of(users.get(0));
            }
            LOGGER.error("Can't got user with username(" + username + ") from DB");
            return Optional.empty();
        }
    }
}
