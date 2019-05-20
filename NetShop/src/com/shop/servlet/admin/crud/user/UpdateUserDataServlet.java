package com.shop.servlet.admin.crud.user;

import com.shop.dao.UserDao;
import com.shop.dao.implamentation.hibernate.RoleDaoHibImpl;
import com.shop.dao.implamentation.hibernate.UserDaoHibImpl;
import com.shop.model.Role;
import com.shop.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet("/admin/user/update")
public class UpdateUserDataServlet extends HttpServlet {

    private static final UserDao USER_DAO = new UserDaoHibImpl();
    private static final RoleDaoHibImpl ROLE_DAO_HIB = new RoleDaoHibImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long userId = Long.valueOf(req.getParameter("user_id"));
        String username = req.getParameter("username");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String isAdmin = req.getParameter("is_admin");
        String isUser = req.getParameter("is_user");

        Role adminRole = ROLE_DAO_HIB.getRoleByName("ADMIN").get();
        Role userRole = ROLE_DAO_HIB.getRoleByName("USER").get();
        Set<Role> roles = new HashSet<>();

        if (isAdmin != null && isAdmin.equals("true")) {
            roles.add(adminRole);
        }
        roles.add(userRole);

        User user = new User(username, firstName, lastName, email);
        user.setUserId(userId);
        user.setRoles(roles);

        USER_DAO.updateUser(user);

        req.getRequestDispatcher("/admin").forward(req, resp);
    }
}
