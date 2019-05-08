package servlet.buy;

import dao.CodeDao;
import model.Code;
import model.User;
import service.MailService;
import utils.RandomHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pay")
public class PayServlet extends HttpServlet {

    private static final CodeDao CODE_DAO = new CodeDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        Long orderId = Long.valueOf(req.getParameter("order_id"));
        String value = RandomHelper.getRandomString();
        Code code = new Code(user.getUser_id(), orderId, value);
        CODE_DAO.addCode(code);
        MailService.sendMail(code);
        req.getRequestDispatcher("buyConfirmation.jsp").forward(req, resp);
    }
}
