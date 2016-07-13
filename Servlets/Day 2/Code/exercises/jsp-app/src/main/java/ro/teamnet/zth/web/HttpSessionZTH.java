package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by user on 7/14/2016.
 */
public class HttpSessionZTH extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        if(username.equals("admin") && password.equals("admin")){
            response.getWriter().write("Welcome back! Username:"+ username);

        }
        else{
            session.setAttribute("user",username);
            session.setAttribute("session",request.getSession());
            response.sendRedirect("views/loginFail.jsp");
        }

    }
}
