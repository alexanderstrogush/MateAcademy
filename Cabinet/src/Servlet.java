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

    private static final Map<String, User> users = new HashMap<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String type = request.getParameter("type");
        workType(type, request, response);
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        if (type.equals("Login")) {
//            if (checkUser(username)) {
//                if (checkPassword(users.get(username).getPassword(), password)) {
//                    out.write(getSuccessfulEntrancePage(username));
//                } else {
//                    out.write(getErrorEntrancePage());
//                }
//            } else {
//                out.write(getDontRegistrationPage());
//            }
//        } else if (type.equals("SignUp")) {
//            String firstName = request.getParameter("firstName");
//            String lastName = request.getParameter("lastName");
//            String email = request.getParameter("email");
//            String repeatPass = request.getParameter("repeatPassword");
//
//            if (checkEmail(email)) {
//                if (checkPassword(password, repeatPass)) {
//                    createNewUser(username, firstName, lastName, email, password);
//                    out.write(getSuccessfulRegistrationPage(username));
//                } else {
//                    out.write(getErrorPasswordPage());
//                }
//            } else {
//                out.write(getErrorEmailPage());
//            }
//        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.html").forward(req, resp);
    }

    private void workType(String type, HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        if (type != null) {
            if (type.equals("Login")) {
                logIn(request, out);
            } else if (type.equals("SignUp")) {
                signUp(request, out);
            }
        }
    }

    private static void logIn(HttpServletRequest request, PrintWriter out) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (checkUser(username)) {
            if (checkPassword(users.get(username).getPassword(), password)) {
                out.write(getSuccessfulEntrancePage(username));
            } else {
                out.write(getErrorEntrancePage());
            }
        } else {
            out.write(getDontRegistrationPage());
        }
    }

    private static void signUp(HttpServletRequest request, PrintWriter out) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String repeatPass = request.getParameter("repeatPassword");

        if (checkEmail(email)) {
            if (checkPassword(password, repeatPass)) {
                createNewUser(username, firstName, lastName, email, password);
                out.write(getSuccessfulRegistrationPage(username));
            } else {
                out.write(getErrorPasswordPage());
            }
        } else {
            out.write(getErrorEmailPage());
        }
    }

    private static boolean checkUser(String username) {
        if (users.containsKey(username)) {
            return true;
        }
        return false;
    }

    private static void createNewUser(String username, String firstName, String lastName, String email, String password) {
        User currentUser = new User(username, firstName, lastName, email, password);
        users.put(username, currentUser);
    }

    private static boolean checkPassword(String password, String repeatPassword) {
        if (password.equals(repeatPassword)) {
            return true;
        }
        return false;
    }

    private static boolean checkEmail(String email) {
        Pattern emailPattern = Pattern.compile("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$");
        Matcher matcher = emailPattern.matcher(email);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    private static String getSuccessfulEntrancePage(String username) {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "\t<meta charset=\"UTF-8\">\n" +
                "\t<title>Hi " + username + "</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<script>alert(\"We missed you\")</script>\n" +
                "<h3>The site is at your service, " + username + "</h3>" +
                "</body>";
    }

    private static String getSuccessfulRegistrationPage(String username) {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "\t<meta charset=\"UTF-8\">\n" +
                "\t<title>Welcome " + username + "</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<script>alert(\"We are glad that you have chosen our site\")</script>\n" +
                "<h3>The site is at your service, " + username + "</h3>" +
                "</body>\n" +
                "</html>";
    }

    private static String getDontRegistrationPage() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "\t<meta charset=\"UTF-8\">\n" +
                "\t<title>This user is not registered</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<script>alert(\"This user is not registered. If you want to use the site, please register\")</script>\n" +
                "</body>\n" +
                "</html>";
    }

    private static String getErrorEntrancePage() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "\t<meta charset=\"UTF-8\">\n" +
                "\t<title>Wrong email or password</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<script>alert(\"Wrong password\")</script>\n" +
                "</body>\n" +
                "</html>";
    }

    private static String getErrorEmailPage() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "\t<meta charset=\"UTF-8\">\n" +
                "\t<title>Wrong email</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<script>alert(\"You entered wrong email\")</script>\n" +
                "</body>\n" +
                "</html>";
    }

    private static String getErrorPasswordPage() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "\t<meta charset=\"UTF-8\">\n" +
                "\t<title>Wrong password</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<script>alert(\"Wrong Password\")</script>\n" +
                "</body>\n" +
                "</html>";
    }
}