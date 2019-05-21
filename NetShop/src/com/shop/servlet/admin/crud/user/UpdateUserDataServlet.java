package com.shop.servlet.admin.crud.user;

import com.shop.dao.RoleDao;
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
import java.util.Optional;
import java.util.Set;

@WebServlet("/admin/user/update")
public class UpdateUserDataServlet extends HttpServlet {

    private static final UserDao userDao = new UserDaoHibImpl();
    private static final RoleDao roleDao = new RoleDaoHibImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long userId = Long.valueOf(req.getParameter("user_id"));
        String username = req.getParameter("username");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String isAdmin = req.getParameter("is_admin");
        String isUser = req.getParameter("is_user");

        Role adminRole = roleDao.getByName("ADMIN").get();
        Role userRole = roleDao.getByName("USER").get();
        Set<Role> roles = new HashSet<>();

        if (isAdmin != null && isAdmin.equals("true")) {
            roles.add(adminRole);
        }
        roles.add(userRole);

        Optional<User> userOptional = userDao.getById(User.class, userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setUsername(username);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setRoles(roles);
            userDao.update(user);
        }

        req.getRequestDispatcher("/admin").forward(req, resp);
    }
}
