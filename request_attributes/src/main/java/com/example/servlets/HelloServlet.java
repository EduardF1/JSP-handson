package com.example.servlets;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import static java.lang.System.err;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    @Override
    public void init() {
        message = "Hello World!";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        try {
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>" + message + "</h1>");
            out.println("</body></html>");
        }catch (IOException exception){
            err.printf("An exception has occurred %s", exception);
        }

    }

    @Override
    public void destroy() {
        // Empty method body
    }
}