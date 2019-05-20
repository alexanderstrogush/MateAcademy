package com.shop.dao.implamentation.hibernate;

import com.shop.model.Role;
import com.shop.utils.HibernateSessionFactoryUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class RoleDaoHibImpl {

    private static final Logger LOGGER = Logger.getLogger(RoleDaoHibImpl.class);
    private final SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

    public void addRole(Role role) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(role);
            LOGGER.debug("New role with name (" + role.getName() + ") created");
            session.getTransaction().commit();
        }
    }

    public Optional<Role> getById(long roleId) {
        Role role;
        try (Session session = sessionFactory.openSession()) {
            role = session.get(Role.class, roleId);
            if (role != null) {
                LOGGER.debug("Got role with id (" + roleId + ") from DB");
                return Optional.of(role);
            }
            LOGGER.debug("Can't got role with id (" + role + ") from DB");
            return Optional.empty();
        }
    }

    public Optional<Role> getRoleByName(String roleName) {
        List<Role> roles;
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("FROM Role WHERE name = :name");
            query.setParameter("name", roleName);
            roles = query.list();
            if (!roles.isEmpty()) {
                LOGGER.debug("Got role with name(" + roleName +") from DB");
                return Optional.of(roles.get(0));
            }
            LOGGER.error("Can't got role with name(" + roleName +") from DB");
            return Optional.empty();
        }
    }

    public List<Role> getAllRoles() {
        try (Session session = sessionFactory.openSession()) {
            LOGGER.debug("Got all roles from DB");
            return session.createQuery("FROM Role").list();
        }
    }

    public int deleteRoleById(long roleId) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("delete from Role where role_id = :role_id");
            query.setParameter("role_id", roleId);
            int rows = query.executeUpdate();
            session.getTransaction().commit();
            if (rows == 1) {
                LOGGER.debug("Role deleted successfully");
            } else {
                LOGGER.debug("Role deleting failed");
            }
            return rows;
        }
    }
}
