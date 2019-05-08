package servlet.buy;

import dao.OrderDao;
import dao.UserDao;
import model.Cart;
import model.Order;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/buy")
public class BuyGoodServlet extends HttpServlet {

    private static final OrderDao ORDER_DAO = new OrderDao();
    private static final UserDao USER_DAO = new UserDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        Cart cart = user.getCart();

        Order order = new Order(user, cart);
        long id = ORDER_DAO.addOrder(order);
        order.setOrderId(id);
        user.getOrders().add(order);

        user.getCart().cleanCart();
        USER_DAO.updateUser(user.getUser_id(), user);

        req.getRequestDispatcher("/orders").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
