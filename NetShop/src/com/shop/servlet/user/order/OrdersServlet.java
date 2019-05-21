package com.shop.servlet.user.order;

import com.shop.dao.OrderDao;
import com.shop.dao.implamentation.hibernate.OrderDaoHibImpl;
import com.shop.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/orders")
public class OrdersServlet extends HttpServlet {

    private static final OrderDao ORDER_DAO = new OrderDaoHibImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
//        user.setOrders(ORDER_DAO.getAllOrdersForUser(user.getUserId()));
//        req.setAttribute("orders", user.getOrders());

        req.getRequestDispatcher("/pages/user/orders/orders.jsp").include(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
