package servlet.admin;

import dao.GoodDao;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    private static final UserDao USER_DAO = new UserDao();
    private static final GoodDao GOOD_DAO = new GoodDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", USER_DAO.getAllUsers());
        req.setAttribute("goods", GOOD_DAO.getAllGoods());

        req.getRequestDispatcher("AdminPage/adminStartPage.jsp").forward(req, resp);
    }
}
