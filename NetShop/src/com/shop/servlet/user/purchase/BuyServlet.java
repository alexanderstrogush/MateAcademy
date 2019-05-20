package com.shop.servlet.user.purchase;

import com.shop.dao.OrderDao;
import com.shop.dao.implamentation.hibernate.OrderDaoHibImpl;
import com.shop.dao.implamentation.hibernate.UserDaoHibImpl;
import com.shop.dao.UserDao;
import com.shop.model.Cart;
import com.shop.model.Order;
import com.shop.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cart/buy")
public class BuyServlet extends HttpServlet {

    private static final OrderDao ORDER_DAO = new OrderDaoHibImpl();
    private static final UserDao USER_DAO = new UserDaoHibImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        User user = (User) request.getSession().getAttribute("user");
//        Cart cart = user.getCart();
//
//        Order order = new Order(user, cart);
//        long id = ORDER_DAO.addOrder(order);
//        order.setOrderId(id);
//        user.getOrders().add(order);
//
//        user.getCart().cleanCart();
//        USER_DAO.updateUserById(user.getUserId(), user);

        request.getRequestDispatcher("/user/orders").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
