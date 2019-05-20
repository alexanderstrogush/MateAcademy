package com.shop.servlet.user.payment;

import com.shop.dao.CodeDao;
import com.shop.dao.OrderDao;
import com.shop.dao.implamentation.hibernate.CodeDaoHibImpl;
import com.shop.dao.implamentation.hibernate.OrderDaoHibImpl;
import com.shop.model.Code;
import com.shop.model.Order;
import com.shop.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/user/orders/confirmation")
public class ConfirmationServlet extends HttpServlet {

    private static final CodeDao CODE_DAO = new CodeDaoHibImpl();
    private static final OrderDao ORDER_DAO = new OrderDaoHibImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String codeStr = req.getParameter("code");
        Optional<Code> optCode = CODE_DAO.getCodeByValue(user.getUserId(), codeStr);
//        if (optCode.isPresent()) {
//            Code code = optCode.get();
//            if (checkCode(user, code)) {
//                user.getOrderById(code.getOrderId()).get().setStatus(Order.STATUS.PAID);
//                ORDER_DAO.updateStatus(code.getOrderId(), "PAID");
//                CODE_DAO.deleteCodeById(code.getCodeId());
//                req.getRequestDispatcher("/user/orders").forward(req, resp);
//            }
//        } else {
//            req.getRequestDispatcher("/pages/errors/wrong-code.jsp").forward(req, resp);
//        }
    }

    private boolean checkCode(User user, Code code) {
//        List<Order> orders = user.getOrders();
//        for (Order order : orders) {
//            if (order.getOrderId() == code.getOrderId()) {
//                return true;
//            }
//        }
        return false;
    }
}
