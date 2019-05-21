package com.shop.servlet;

import com.shop.dao.UserDao;
import com.shop.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/SignIn")
public class SignInServlet extends HttpServlet {

    private static final UserDao USER_DAO = new UserDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        signIn(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    private static void signIn(HttpServletRequest req, HttpServletResponse resp) {
        req.getSession().setAttribute("admin", null);
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            Optional<User> optionalUser = USER_DAO.getUserByUsername(username);
            if (optionalUser.isPresent()) {
                User tempUser = optionalUser.get();
                if (tempUser.getPassword().equals(password)) {
                    req.setAttribute("username", username);
                    if (tempUser.getRole().equals(User.ROLE.ADMIN)) {
                        req.getSession().setAttribute("admin", "x64");
                        req.getRequestDispatcher("/admin").forward(req, resp);
                    } else if (tempUser.getRole().equals(User.ROLE.USER)) {
                        req.getRequestDispatcher("UserStartPage.jsp").forward(req, resp);
                    }
                } else {
                    req.getRequestDispatcher("ErrorPage/ErrorEntrancePage.jsp").forward(req, resp);
                }
            } else {
                req.getRequestDispatcher("ErrorPage/UnregisteredUserPage.jsp").forward(req, resp);
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
