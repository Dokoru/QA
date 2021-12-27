package servlet;

import model.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static servlet.LoginServlet.appService;

public class MainPageServlet extends HttpServlet {

        public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            final HttpSession session = request.getSession();
            final int uid = (int) session.getAttribute("UID");
            if(uid > -1) {
                request.getRequestDispatcher("main.jsp").forward(request, response);
                List<Question> qList = appService.getAllQuestion();

                request.setAttribute("qlist", qList);
            }
            else {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }

        public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws IOException {

        }
    }
