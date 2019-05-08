package filter;

import dao.GoodDao;
import model.Good;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/AdminPage/CRUD/updateGoodDataPage.jsp")
public class UpdateGoodFilter implements Filter {

    private static final GoodDao GOOD_DAO = new GoodDao();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        long id = Long.parseLong(request.getParameter("good_id"));
        Good good = GOOD_DAO.getGoodById(id).get();
        request.setAttribute("name", good.getName());
        request.setAttribute("description", good.getDescription());
        request.setAttribute("price", good.getPrice());
        filterChain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
