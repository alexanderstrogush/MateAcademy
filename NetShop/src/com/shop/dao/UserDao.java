package com.shop.dao;

import com.shop.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    public long addUser(User user);

    public Optional<User> getUserById(long userId);

    public Optional<User> getUserByUsername(String username);

    public List<User> getAllUsers();

    public int deleteUserById(long userId);

    public int updateUser(User user);
}
