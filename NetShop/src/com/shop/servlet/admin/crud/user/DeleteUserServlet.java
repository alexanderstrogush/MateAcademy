package com.shop.servlet.admin.crud.user;

import com.shop.dao.UserDao;
import com.shop.dao.implamentation.hibernate.UserDaoHibImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/user/delete")
public class DeleteUserServlet extends HttpServlet {

    private static final UserDao USER_DAO = new UserDaoHibImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("user_id"));
        USER_DAO.deleteUserById(id);

        req.getRequestDispatcher("/admin").forward(req, resp);
    }
}