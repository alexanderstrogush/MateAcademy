package filter;

import dao.UserDao;
import model.User;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/AdminPage/CRUD/updateUserDataPage.jsp")
public class UpdateUserFilter implements Filter {

    private static final UserDao USER_DAO = new UserDao();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        long id = Long.parseLong(request.getParameter("user_id"));
        User user = USER_DAO.getUserByUserID(id).get();
        request.setAttribute("username", user.getUsername());
        request.setAttribute("first_name", user.getFirstName());
        request.setAttribute("last_name", user.getLastName());
        request.setAttribute("email", user.getEmail());
        request.setAttribute("password", user.getPassword());
        filterChain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
