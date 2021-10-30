package com.example.making_servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("the GET request has been made to /hello");

        response.setContentType("text/html");

        response.getWriter().println("<h1>Hello!</h1>");
        response.getWriter().println("<p>Welcome to my website</p>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("the POST request has been made to /hello");
    }
}