package servlet.CRUD;

import dao.UserDao;
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

@WebServlet(value = "/addUser")
public class AddUserServlet extends HttpServlet {

    private static final UserDao USER_DAO = new UserDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        add(req, resp);
    }

    private static void add(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String repeatPass = req.getParameter("repeatPassword");
        String role = req.getParameter("role");

        User user = new User(username, firstName, lastName, email, password, role);
        try {
            if (USER_DAO.getUserByUsername(username).equals(Optional.empty())) {
                checkEmail(email, password, repeatPass, user, req, resp);
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    private static void checkPassword(String password, String repeatPassword, User user, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (password.equals(repeatPassword)) {
            USER_DAO.addUser(user);
            req.getRequestDispatcher("/admin").forward(req, resp);
        }
        req.getRequestDispatcher("ErrorPage/ErrorPasswordPage.jsp").forward(req, resp);
    }

    private static void checkEmail(String email, String password, String repeatPassword, User user, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Pattern emailPattern = Pattern.compile("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$");
        Matcher matcher = emailPattern.matcher(email);
        if (matcher.find()) {
            checkPassword(password, repeatPassword, user, req, resp);
        }
        req.getRequestDispatcher("ErrorPage/ErrorEmailPage.jsp").forward(req, resp);
    }
}
