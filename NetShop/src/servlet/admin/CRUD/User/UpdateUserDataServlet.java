package servlet.admin.CRUD.User;

import dao.UserDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateUser")
public class UpdateUserDataServlet extends HttpServlet {

    private static final UserDao USER_DAO = new UserDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        Long id = Long.valueOf(req.getParameter("user_id"));
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String repeatPass = req.getParameter("repeatPassword");
        String role = req.getParameter("role");

        User user = new User(username, firstName, lastName, email, password, role);

        USER_DAO.updateUser(id, user);

        req.getRequestDispatcher("/admin").forward(req, resp);
    }
}
