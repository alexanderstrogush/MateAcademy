package com.shop.dao;

import com.shop.model.Role;

import java.util.Optional;

public interface RoleDao extends GenericDao<Role> {

    Optional<Role> getByName(String roleName);
}
