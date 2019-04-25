package servlet;

import dao.UserDao;
import model.User;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OptionalDataException;
import java.util.Optional;

@WebServlet("/SignIn")
public class SignInServlet extends HttpServlet {

    private static final UserDao userDao = new UserDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        signIn(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    private static void signIn(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

            Optional<User> optionalUser = userDao.getUser(username);
            if (optionalUser.isPresent()) {
                User tempUser = optionalUser.get();
                if (tempUser.getPassword().equals(password)) {
                    try {
                        req.getRequestDispatcher("StartPage.jsp").forward(req, resp);
                    } catch (ServletException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        req.getRequestDispatcher("ErrorPage/ErrorEntrancePage.jsp").forward(req, resp);
                    } catch (ServletException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                try {
                    req.getRequestDispatcher("ErrorPage/UnregisteredUserPage.jsp").forward(req, resp);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

    }

}
