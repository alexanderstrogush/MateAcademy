package servlet.admin.CRUD.Good;

import dao.GoodDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteGood")
public class DeleteGoodServlet extends HttpServlet {

    private static final GoodDao GOOD_DAO = new GoodDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("good_id"));
        GOOD_DAO.removeGoodById(id);

        req.getRequestDispatcher("/admin").forward(req, resp);
    }
}
