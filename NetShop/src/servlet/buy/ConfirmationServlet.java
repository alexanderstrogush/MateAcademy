package servlet.buy;

import dao.CodeDao;
import dao.OrderDao;
import model.Code;
import model.Order;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@WebServlet("/confirm")
public class ConfirmationServlet extends HttpServlet {

    private static final CodeDao CODE_DAO = new CodeDao();
    private static final OrderDao ORDER_DAO = new OrderDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String codeStr = req.getParameter("code");
        Optional<Code> optCode = CODE_DAO.getCodeByUse(user.getUser_id(), codeStr);
        if (optCode.isPresent()) {
            Code code = optCode.get();
            if (checkCode(user, code)) {
                user.getOrderById(code.getOrderId()).get().setStatus(Order.STATUS.PAID);
                ORDER_DAO.updateStatus(code.getOrderId(), "PAID");
                CODE_DAO.deleteCodeById(code.getCodeId());
                req.getRequestDispatcher("/orders").forward(req, resp);
            }
        } else {
            req.getRequestDispatcher("ErrorPage/error_code.jsp").forward(req, resp);
        }
    }

    private boolean checkCode(User user, Code code) {
        ArrayList<Order> orders = user.getOrders();
        for (Order order : orders) {
            if (order.getOrderId() == code.getOrderId()) {
                return true;
            }
        }
        return false;
    }
}
