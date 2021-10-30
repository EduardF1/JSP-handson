package com.example.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PresidentServlet", urlPatterns = "/presidents")
public class PresidentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // getServletContext()
        //        .getRequestDispatcher("/info.html")             // Dispatch the request to a html page.
        //        .getRequestDispatcher("/presidents.jsp")        // Dispatch the request to the presidents.jsp file (dispatcher handle).
        //        .getRequestDispatcher("/secondary")             // Dispatch the request to another servlet
        //        .forward(request, response);                    // Forward the request and response of the initial request.

        // Redirect, used for external urls (most common use-case, but the user can be redirected to another location within the current web
        // app).
        response.sendRedirect("https://dzone.com/articles/what-servlet-container");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
