package servlet.user;

import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        req.setAttribute("goodsMap", user.getCart().getGoods());
        req.setAttribute("goods", user.getCart().getGoods().keySet());
        req.setAttribute("price", user.getCart().getPrice());

        req.getRequestDispatcher("Cart/cartPage.jsp").forward(req, resp);
    }
}
