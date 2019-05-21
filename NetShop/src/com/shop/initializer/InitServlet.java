package com.shop.initializer;

import com.shop.dao.implamentation.hibernate.GoodDaoHibImpl;
import com.shop.dao.implamentation.hibernate.RoleDaoHibImpl;
import com.shop.dao.implamentation.hibernate.UserDaoHibImpl;
import com.shop.model.Good;
import com.shop.model.Role;
import com.shop.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "InitServlet", urlPatterns = "/init", loadOnStartup = 1)
public class InitServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        RoleDaoHibImpl roleDaoHib = new RoleDaoHibImpl();
        Role adminRole = new Role("ADMIN");
        Role userRole = new Role("USER");

        roleDaoHib.addRole(adminRole);
        roleDaoHib.addRole(userRole);

        UserDaoHibImpl userDaoHib = new UserDaoHibImpl();
        User admin = new User("AlexStrog", "Alex", "Strog", "gaymar26@gmail.com", "123", adminRole, userRole);
        User user = new User("Vitold", "Vi", "Strog", "strogushalex@gmail.com", "123", userRole);

        userDaoHib.addUser(admin);
        userDaoHib.addUser(user);

        GoodDaoHibImpl goodDaoHib = new GoodDaoHibImpl();
        Good good = new Good("Xiaomi Redmi Note 7 Pro", "Топ за свои деньги", 252.99);

        goodDaoHib.addGood(good);
    }
}
