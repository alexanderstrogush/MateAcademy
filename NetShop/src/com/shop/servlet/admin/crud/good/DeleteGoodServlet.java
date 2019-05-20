package com.shop.servlet.admin.crud.good;

import com.shop.dao.GoodDao;
import com.shop.dao.implamentation.hibernate.GoodDaoHibImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/good/delete")
public class DeleteGoodServlet extends HttpServlet {

    private static final GoodDao GOOD_DAO = new GoodDaoHibImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long goodId = Long.valueOf(req.getParameter("good_id"));
        GOOD_DAO.deleteGoodById(goodId);

        req.getRequestDispatcher("/admin").forward(req, resp);
    }
}