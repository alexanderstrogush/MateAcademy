package com.shop.dao.implamentation.hibernate;

import com.shop.dao.RoleDao;
import com.shop.model.Role;
import com.shop.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class RoleDaoHibImpl extends GenericDaoImpl<Role> implements RoleDao {

    @Override
    public Optional<Role> getByName(String roleName) {
        List<Role> roles;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Role WHERE name = :name");
            query.setParameter("name", roleName);
            roles = query.list();
            if (!roles.isEmpty()) {
                return Optional.of(roles.get(0));
            }
            return Optional.empty();
        }
    }
}
