package com.shop.dao.implamentation.hibernate;

import com.shop.dao.OrderDao;
import com.shop.model.Order;

import java.util.List;
import java.util.Optional;

public class OrderDaoHibImpl implements OrderDao {
    @Override
    public long addOrder(Order order) {
        return 0;
    }

    @Override
    public Optional<Order> getOrderById(long orderId) {
        return Optional.empty();
    }

    @Override
    public List<Order> getAllOrdersForUser(long userId) {
        return null;
    }

    @Override
    public int updateStatus(long orderId, String status) {
        return 0;
    }

    @Override
    public int deleteOrder(long orderId) {
        return 0;
    }
}
