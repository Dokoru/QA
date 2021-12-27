package servlet;

import service.AppService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    public final static AppService appService = new AppService();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        final HttpSession session = request.getSession();
        int user_id = appService.getCurrID();
        session.setAttribute("UID", user_id);

        final String login = request.getParameter("login");
        final String password = request.getParameter("password");
        if (request.getParameter("login-btn") != null) {
            if (appService.authorization(login, password)) {
                request.getRequestDispatcher("main.jsp").forward(request, response);
            } else {
                response.sendRedirect("login.jsp");
            }
        }
        if (request.getParameter("reg-btn") != null) {
            if (appService.registration(login, password)) {
                request.getRequestDispatcher("main.jsp").forward(request, response);
            } else {
                response.sendRedirect("login.jsp");
            }
        }
    }
}
