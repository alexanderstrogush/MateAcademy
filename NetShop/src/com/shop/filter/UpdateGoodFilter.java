package com.shop.filter;

import com.shop.dao.GoodDao;
import com.shop.dao.implamentation.hibernate.GoodDaoHibImpl;
import com.shop.model.Good;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/pages/admin/crud/good/update-good-data.jsp")
public class UpdateGoodFilter implements Filter {

    private static final GoodDao goodDao = new GoodDaoHibImpl();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        long goodId = Long.parseLong(request.getParameter("good_id"));
        Good good = goodDao.getById(Good.class, goodId).get();
        request.setAttribute("good", good);
        filterChain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
