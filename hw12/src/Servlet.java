import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/start")
public class Servlet extends HttpServlet {

    private Map<String, User> users = new HashMap<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String type = request.getParameter("type");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (type != null) {
            if (type.equals("Login")) {
                if (username != null && password != null) {
                    if (users.containsKey(username)) {
                        User currentUser = users.get(username);
                        if (currentUser.getPassword().equals(password)) {
                            out.write("<!DOCTYPE html>\n" +
                                    "<html lang=\"en\">\n" +
                                    "<head>\n" +
                                    "\t<meta charset=\"UTF-8\">\n" +
                                    "\t<title>Hi " + username + "</title>\n" +
                                    "</head>\n" +
                                    "<body>\n" +
                                    "\t<script>alert(\"We missed you\")</script>\n" +
                                    "<h3>The site is at your service, " + username + "</h3>" +
                                    "</body>");
                        } else  {
                            out.write("<!DOCTYPE html>\n" +
                                    "<html lang=\"en\">\n" +
                                    "<head>\n" +
                                    "\t<meta charset=\"UTF-8\">\n" +
                                    "\t<title>Wrong email or password</title>\n" +
                                    "</head>\n" +
                                    "<body>\n" +
                                    "\t<script>alert(\"Wrong email or password\")</script>\n" +
                                    "</body>\n" +
                                    "</html>");
                        }
                    } else {
                        out.write("<!DOCTYPE html>\n" +
                                "<html lang=\"en\">\n" +
                                "<head>\n" +
                                "\t<meta charset=\"UTF-8\">\n" +
                                "\t<title>This user is not registered</title>\n" +
                                "</head>\n" +
                                "<body>\n" +
                                "\t<script>alert(\"This user is not registered. If you want to use the site, please register\")</script>\n" +
                                "</body>\n" +
                                "</html>");
                    }
                }
            } else if (type.equals("SignUp")) {
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String email = request.getParameter("email");
                String repeatPass = request.getParameter("repeatPassword");

                Pattern emailPattern = Pattern.compile("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$");
                Matcher matcher = emailPattern.matcher(email);
                if (!matcher.find()) {
                    out.write("<!DOCTYPE html>\n" +
                            "<html lang=\"en\">\n" +
                            "<head>\n" +
                            "\t<meta charset=\"UTF-8\">\n" +
                            "\t<title>Wrong email</title>\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "\t<script>alert(\"You entered wrong email\")</script>\n" +
                            "</body>\n" +
                            "</html>");
                } else if (password.equals(repeatPass)) {
                    User currentUser = new User(username, firstName, lastName, email, password);
                    users.put(username, currentUser);
                    out.write("<!DOCTYPE html>\n" +
                            "<html lang=\"en\">\n" +
                            "<head>\n" +
                            "\t<meta charset=\"UTF-8\">\n" +
                            "\t<title>Welcome " + username + "</title>\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "\t<script>alert(\"We are glad that you have chosen our site\")</script>\n" +
                            "<h3>The site is at your service, " + username + "</h3>" +
                            "</body>\n" +
                            "</html>");
                } else {
                    out.write("<!DOCTYPE html>\n" +
                            "<html lang=\"en\">\n" +
                            "<head>\n" +
                            "\t<meta charset=\"UTF-8\">\n" +
                            "\t<title>Wrong password</title>\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "\t<script>alert(\"Wrong Password\")</script>\n" +
                            "</body>\n" +
                            "</html>");
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.html").forward(req, resp);
    }
}