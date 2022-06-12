package com.loginapplication;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(

        description = "Login Servlet testing",
        urlPatterns = {"/LoginServlet"},

        initParams = {
                @WebInitParam(name = "user", value = "Rajesh"),
                @WebInitParam(name = "password", value = "Pal")
        }

)
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        PrintWriter writer = response.getWriter();
//
//        writer.println("Login App started");

        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        String userID = getServletConfig().getInitParameter("user");
        String password = getServletConfig().getInitParameter("password");

        if (userID.equalsIgnoreCase(user) && password.equals(pwd)) {
            request.setAttribute("user", user);
            request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
        }
        else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
            PrintWriter writer = response.getWriter();
            writer.println("<font color=red>Either user name or password is wrong. </font>");
            dispatcher.include(request, response);
        }
    }
}
