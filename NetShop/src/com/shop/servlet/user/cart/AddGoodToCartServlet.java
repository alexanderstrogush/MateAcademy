package com.shop.servlet.user.cart;

import com.shop.dao.ItemsDao;
import com.shop.dao.GoodDao;
import com.shop.dao.implamentation.hibernate.GoodDaoHibImpl;
import com.shop.dao.implamentation.hibernate.ItemsDaoHibImpl;
import com.shop.dao.implamentation.hibernate.UserDaoHibImpl;
import com.shop.dao.UserDao;
import com.shop.model.Good;
import com.shop.model.Items;
import com.shop.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/cart/add-good")
public class AddGoodToCartServlet extends HttpServlet {

    private static final GoodDao goodDao = new GoodDaoHibImpl();
    private static final UserDao userDao = new UserDaoHibImpl();
    private static final ItemsDao itemsDao = new ItemsDaoHibImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long goodId = Long.valueOf(req.getParameter("good_id"));
        Integer amount = Integer.valueOf(req.getParameter("amount"));
        User user = (User) req.getSession().getAttribute("user");
        Good good = goodDao.getById(Good.class, goodId).get();

        Items items = new Items(user.getCart(), good, amount);
        user.getCart()
                .addItem(items);
        itemsDao.add(items);

        req.getRequestDispatcher("/user").forward(req, resp);
    }
}