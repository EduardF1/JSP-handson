package com.example.servlets;

import com.example.servlets.shared.RequestHandler;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PersonServlet", urlPatterns = "/person")
public class PersonServlet extends HttpServlet {
    private final RequestHandler requestHandler = RequestHandler.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        requestHandler.handleRequest(request);
        requestHandler.redirect(getServletContext(),request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
