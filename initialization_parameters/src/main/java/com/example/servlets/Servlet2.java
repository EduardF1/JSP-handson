package com.example.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet2", urlPatterns = "/hello2", initParams = {
        @WebInitParam(name="copyrightYear", value ="2022"),
        @WebInitParam(name = "M2525S", value = "Joker Faker")
})
public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String copyrightYear = getServletConfig().getInitParameter("copyrightYear");
        String m2525s = getServletConfig().getInitParameter("M2525S");
        if (copyrightYear != null && m2525s != null){
            System.out.println(copyrightYear + " --- " + m2525s);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
