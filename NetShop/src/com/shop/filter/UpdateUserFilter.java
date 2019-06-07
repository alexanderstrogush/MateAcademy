package com.shop.filter;

import com.shop.dao.UserDao;
import com.shop.dao.implamentation.hibernate.UserDaoHibImpl;
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

@WebFilter("/pages/admin/crud/user/update-user-data.jsp")
public class UpdateUserFilter implements Filter {

    private static final UserDao USER_DAO = new UserDaoHibImpl();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        long userId = Long.parseLong(request.getParameter("user_id"));
        User user = USER_DAO.getById(User.class, userId).get();
        request.setAttribute("user", user);
        filterChain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
