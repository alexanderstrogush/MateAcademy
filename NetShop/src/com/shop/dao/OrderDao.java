package com.shop.dao;

import com.shop.model.Order;

import java.util.List;

public interface OrderDao extends GenericDao<Order> {

    public List<Order> getAllOrdersForUser(long userId);
}
