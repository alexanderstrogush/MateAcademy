package com.shop.servlet.admin.crud.good;

import com.shop.dao.GoodDao;
import com.shop.dao.implamentation.hibernate.GoodDaoHibImpl;
import com.shop.model.Good;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/good/add")
public class AddGoodServlet extends HttpServlet {

    private static final GoodDao goodDao = new GoodDaoHibImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        Long price = Long.valueOf(req.getParameter("price"));

        Good good = new Good(name, description, price);
        goodDao.add(good);

        req.getRequestDispatcher("/admin").forward(req, resp);
    }
}