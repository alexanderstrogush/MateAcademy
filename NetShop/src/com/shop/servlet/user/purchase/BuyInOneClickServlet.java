package com.shop.servlet.user.purchase;

import com.shop.dao.GoodDao;
import com.shop.dao.implamentation.hibernate.GoodDaoHibImpl;
import com.shop.dao.implamentation.hibernate.OrderDaoHibImpl;
import com.shop.dao.implamentation.hibernate.UserDaoHibImpl;
import com.shop.dao.OrderDao;
import com.shop.dao.UserDao;
import com.shop.model.Cart;
import com.shop.model.Good;
import com.shop.model.Order;
import com.shop.model.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/buy-in-one-click")
public class BuyInOneClickServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(BuyInOneClickServlet.class);
    private static final OrderDao ORDER_DAO = new OrderDaoHibImpl();
    private static final UserDao USER_DAO = new UserDaoHibImpl();
    private static final GoodDao GOOD_DAO = new GoodDaoHibImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        long goodId = Long.parseLong(req.getParameter("good_id"));
        int amount = Integer.parseInt(req.getParameter("amount"));

        Cart cart = new Cart();
        Good good = GOOD_DAO.getGoodById(goodId).get();
//        cart.addGood(good, amount);

        Order order = new Order(user, cart);
        long id = ORDER_DAO.addOrder(order);
        order.setOrderId(id);
//        user.getOrders().add(order);
        logger.debug("New order: id " + id + " created");
        req.getRequestDispatcher("/orders").forward(req, resp);
    }
}