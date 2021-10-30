package com.example.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String copyrightYear = getServletConfig().getInitParameter("copyrightYear");
        if (copyrightYear != null){
            System.out.println(copyrightYear);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
