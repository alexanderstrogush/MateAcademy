package com.shop.servlet.admin;

import com.shop.dao.GoodDao;
import com.shop.dao.implamentation.hibernate.GoodDaoHibImpl;
import com.shop.dao.implamentation.hibernate.UserDaoHibImpl;
import com.shop.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    private static final UserDao USER_DAO = new UserDaoHibImpl();
    private static final GoodDao GOOD_DAO = new GoodDaoHibImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", USER_DAO.getAllUsers());
        req.setAttribute("goods", GOOD_DAO.getAllGoods());

        req.getRequestDispatcher("/pages/admin/admin.jsp").forward(req, resp);
//        resp.getWriter().print(gson.toJson(GOOD_DAO.getAllGoods()));
    }
}
