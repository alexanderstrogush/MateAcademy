package servlet.cart;

import dao.GoodDao;
import dao.UserDao;
import model.Good;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addToCart")
public class AddGoodToCartServlet extends HttpServlet {

    private static final GoodDao GOOD_DAO = new GoodDao();
    private static final UserDao USER_DAO = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long goodId = Long.parseLong(req.getParameter("good_id"));
        int amount = Integer.parseInt(req.getParameter("amount"));
        User user = (User) req.getSession().getAttribute("user");
        Good good = GOOD_DAO.getGoodById(goodId).get();

        user.getCart().addGood(good, amount);
        USER_DAO.updateUser(user.getUser_id(), user);

        req.getRequestDispatcher("/user").forward(req, resp);
    }
}
