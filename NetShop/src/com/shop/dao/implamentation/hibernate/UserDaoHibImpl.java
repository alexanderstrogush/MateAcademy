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

public class UserDaoHibImpl implements UserDao {

    private static final Logger LOGGER = Logger.getLogger(UserDaoHibImpl.class);
    private static final SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

    public long addUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            long id = (long) session.save(user);
            LOGGER.debug("New user with username (" + user.getUsername() + ") created");
            session.getTransaction().commit();
            return id;
        }
    }

    public Optional<User> getUserById(long userId) {
        User user;
        try (Session session = sessionFactory.openSession()) {
            user = session.get(User.class, userId);
            if (user != null) {
                LOGGER.debug("Got user with id (" + userId + ") from DB");
                return Optional.of(user);
            }
            LOGGER.debug("Can't got user with id (" + userId + ") from DB");
            return Optional.empty();
        }
    }

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

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            LOGGER.debug("Got all users from DB");
            users = session.createQuery("FROM User").list();
        }
        return users;
    }

    public int deleteUserById(long userId) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("delete from User where user_id = :user_id");
            query.setParameter("user_id", userId);
            int rows = query.executeUpdate();
            session.getTransaction().commit();
            if (rows == 1) {
                LOGGER.debug("User deleted successfully");
            } else {
                LOGGER.debug("User deleting failed");
            }
            return rows;
        }
    }

    public int updateUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
            return 1;
        }
    }
}
