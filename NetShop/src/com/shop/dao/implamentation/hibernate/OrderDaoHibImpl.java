package com.shop.dao.implamentation.hibernate;

import com.shop.dao.OrderDao;
import com.shop.model.Order;

import java.util.List;

public class OrderDaoHibImpl extends GenericDaoImpl<Order> implements OrderDao {

    @Override
    public List<Order> getAllOrdersForUser(long userId) {
        return null;
    }
}
