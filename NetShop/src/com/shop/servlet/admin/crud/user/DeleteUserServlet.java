package com.shop.servlet.admin.crud.user;

import com.shop.dao.UserDao;
import com.shop.dao.implamentation.hibernate.UserDaoHibImpl;
import com.shop.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/admin/user/delete")
public class DeleteUserServlet extends HttpServlet {

    private static final UserDao userDao = new UserDaoHibImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long userId = Long.parseLong(req.getParameter("user_id"));
        Optional<User> userOptional = userDao.getById(User.class, userId);
        userOptional.ifPresent(userDao::delete);

        req.getRequestDispatcher("/admin").forward(req, resp);
    }
}