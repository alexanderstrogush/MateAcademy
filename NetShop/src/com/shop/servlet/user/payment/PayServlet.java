package com.shop.servlet.user.payment;

import com.shop.dao.CodeDao;
import com.shop.dao.implamentation.hibernate.CodeDaoHibImpl;
import com.shop.model.Code;
import com.shop.model.User;
import com.shop.service.MailService;
import com.shop.utils.RandomHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/orders/pay")
public class PayServlet extends HttpServlet {

    private static final CodeDao codeDao = new CodeDaoHibImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        Long orderId = Long.valueOf(req.getParameter("order_id"));
        String value = RandomHelper.getRandomString();
        Code code = new Code(user.getUserId(), orderId, value);
        codeDao.add(code);
        MailService.sendMail(code);
        req.getRequestDispatcher("/pages/user/payment/purchase-confirmation.jsp").forward(req, resp);
    }
}
