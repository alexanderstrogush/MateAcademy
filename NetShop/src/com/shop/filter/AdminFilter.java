package com.shop.filter;

import com.shop.dao.UserDao;
import com.shop.dao.implamentation.hibernate.RoleDaoHibImpl;
import com.shop.dao.implamentation.hibernate.UserDaoHibImpl;
import com.shop.model.Role;
import com.shop.model.User;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = {"/admin/", "/admin/*", "/pages/admin/*"})
public class AdminFilter implements Filter {

    private static final RoleDaoHibImpl ROLE_DAO_HIB = new RoleDaoHibImpl();

    private static final UserDao USER_DAO = new UserDaoHibImpl();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        User user = (User) request.getSession().getAttribute("user");
        Role adminRole = ROLE_DAO_HIB.getByName("ADMIN").get();
        if (user.getRoles().contains(adminRole)) {
            filterChain.doFilter(request, servletResponse);
        } else {
//            request.getRequestDispatcher("/ErrorPage/AccessDeniedPage.jsp").forward(request, servletResponse);
            request.getRequestDispatcher("/user").forward(request, servletResponse);
        }
    }

    @Override
    public void destroy() {
    }
}