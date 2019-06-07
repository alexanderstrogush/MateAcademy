package com.shop.dao;

import com.shop.model.User;

import java.util.Optional;

public interface UserDao extends GenericDao<User> {

    Optional<User> getUserByUsername(String username);
}
