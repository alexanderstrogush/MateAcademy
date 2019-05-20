package com.shop.dao;

import com.shop.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderDao {

    public long addOrder(Order order);

    public Optional<Order> getOrderById(long orderId);

    public List<Order> getAllOrdersForUser(long userId);

    public int updateStatus(long orderId, String status);

    public int deleteOrder(long orderId);
}
