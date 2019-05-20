package com.shop.filter;

import com.shop.dao.UserDao;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import javax.servlet.FilterConfig;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "AdminFilter", urlPatterns = {"/CRUDPage/*", "/CRUD/*", "/admin"})
public class AdminFilter implements Filter {
    public static final UserDao USER_DAO = new UserDao();

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        String isAdmin = (String) request.getSession().getAttribute("admin");
        if (isAdmin != null && isAdmin.equals("x64")) {
            chain.doFilter(req, resp);
        } else {
            req.getRequestDispatcher("/ErrorPage/AccessDeniedPage.jsp").forward(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {
    }
}
