package com.shop.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T> {

    long add(T entity);

    Optional<T> getById(Class<T> entityClass, long id);

    List<T> getAll(Class<T> entityClass);

    void update(T entity);

    void delete(T entity);
}
