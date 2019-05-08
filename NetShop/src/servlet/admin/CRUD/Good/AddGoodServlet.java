package servlet.admin.CRUD.Good;

import dao.GoodDao;
import model.Good;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addGood")
public class AddGoodServlet extends HttpServlet {

    private static final GoodDao GOOD_DAO = new GoodDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String name = req.getParameter("name");
        String description = req.getParameter("description");
        Long price = Long.valueOf(req.getParameter("price"));

        Good good = new Good(name, description, price);

        GOOD_DAO.addGood(good);
        req.getRequestDispatcher("/admin").forward(req, resp);
    }
}
