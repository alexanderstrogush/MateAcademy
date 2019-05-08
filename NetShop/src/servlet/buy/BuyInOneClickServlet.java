package servlet.buy;

import dao.GoodDao;
import dao.OrderDao;
import dao.UserDao;
import model.Cart;
import model.Good;
import model.Order;
import model.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/buyInOneClick")
public class BuyInOneClickServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(BuyInOneClickServlet.class);
    private static final OrderDao ORDER_DAO = new OrderDao();
    private static final UserDao USER_DAO = new UserDao();
    private static final GoodDao GOOD_DAO = new GoodDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        long goodId = Long.parseLong(req.getParameter("good_id"));
        int amount = Integer.parseInt(req.getParameter("amount"));

        Cart cart = new Cart();
        Good good = GOOD_DAO.getGoodById(goodId).get();
        cart.addGood(good, amount);

        Order order = new Order(user, cart);
        long id = ORDER_DAO.addOrder(order);
        order.setOrderId(id);
        user.getOrders().add(order);
        logger.debug("New order: id " + id + " created");
        req.getRequestDispatcher("/orders").forward(req, resp);
    }
}
