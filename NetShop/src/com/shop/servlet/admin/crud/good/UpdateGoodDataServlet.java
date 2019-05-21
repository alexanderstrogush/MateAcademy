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

@WebServlet("/admin/good/update")
public class UpdateGoodDataServlet extends HttpServlet {

    private static final GoodDao GOOD_DAO = new GoodDaoHibImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long goodId = Long.parseLong(req.getParameter("good_id"));
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        double price = Double.parseDouble(req.getParameter("price"));

        Good good = new Good(goodId, name, description, price);

        GOOD_DAO.updateGoodById(good);

        req.getRequestDispatcher("/admin").forward(req, resp);
    }
}
