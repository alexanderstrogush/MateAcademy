package servlet;

import dao.UserDao;
import model.Cart;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/registration")
public class SignUpServlet extends HttpServlet {

    private static final UserDao USER_DAO = new UserDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String href = checkUser(username, req);

        req.getRequestDispatcher(href).forward(req, resp);
    }

    private String checkUser(String username, HttpServletRequest req) {
        if (USER_DAO.getUserByUsername(username).equals(Optional.empty())) {
            return checkEmail(req);
        }
        return "ErrorPage/user_is_already_registred.jsp";
    }

    private String checkEmail(HttpServletRequest req) {
        String email = req.getParameter("email");
        Pattern emailPattern = Pattern.compile("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$");
        Matcher matcher = emailPattern.matcher(email);
        if (matcher.find()) {
            return checkPassword(req);
        }
        return "ErrorPage/wrong_email.jsp";
    }

    private static String checkPassword(HttpServletRequest req) {
        String password = req.getParameter("password");
        String repeatPass = req.getParameter("repeatPassword");

        if (password.equals(repeatPass)) {
            String username = req.getParameter("username");
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String email = req.getParameter("email");

            User user = new User(username, firstName, lastName, email, password, "USER");
            long id = USER_DAO.addUser(user);
            user.setUser_id(id);
            req.getSession().setAttribute("user", user);

            return "/user";
        }
        return "ErrorPage/invalid_repeated_password.jsp";
    }
}
