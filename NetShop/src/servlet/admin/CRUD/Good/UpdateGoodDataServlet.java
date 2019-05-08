package servlet.admin.CRUD.Good;

import dao.GoodDao;
import model.Good;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/goodUpdate")
public class UpdateGoodDataServlet extends HttpServlet {

    private static final GoodDao GOOD_DAO = new GoodDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        long id = Long.parseLong(req.getParameter("good_id"));
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        double price = Double.parseDouble(req.getParameter("price"));

        Good good = new Good(id, name, description, price);

        GOOD_DAO.updateGoodById(good);

        req.getRequestDispatcher("/admin").forward(req, resp);
    }
}
