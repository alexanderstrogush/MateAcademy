package com.shop.initializer;

import com.shop.dao.GoodDao;
import com.shop.dao.UserDao;
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

        roleDaoHib.add(adminRole);
        roleDaoHib.add(userRole);

        UserDao userDaoHib = new UserDaoHibImpl();
        User admin = new User("AlexStrog", "Alex", "Strog", "gaymar26@gmail.com", "123", adminRole, userRole);
        User user = new User("Vitold", "Vi", "Strog", "strogushalex@gmail.com", "123", userRole);

        userDaoHib.add(admin);
        userDaoHib.add(user);

        GoodDao goodDaoHib = new GoodDaoHibImpl();
        Good good1 = new Good("Xiaomi Redmi Note 7 Pro", "Топ за свои деньги", 252.99);
        Good good2 = new Good("One Plus 7 Pro", "Flagman's killer", 999);

        goodDaoHib.add(good1);
        goodDaoHib.add(good2);
    }
}
