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
import java.util.Optional;

@WebServlet("/admin/good/update")
public class UpdateGoodDataServlet extends HttpServlet {

    private static final GoodDao goodDao = new GoodDaoHibImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long goodId = Long.parseLong(req.getParameter("good_id"));
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        double price = Double.parseDouble(req.getParameter("price"));

        Optional<Good> goodOptional = goodDao.getById(Good.class, goodId);
        if (goodOptional.isPresent()) {
            Good good = goodOptional.get();
            good.setName(name);
            good.setDescription(description);
            good.setPrice(price);
            goodDao.update(good);
        }

        req.getRequestDispatcher("/admin").forward(req, resp);
    }
}
