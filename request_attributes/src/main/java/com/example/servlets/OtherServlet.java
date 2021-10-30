package com.example.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "OtherServlet", urlPatterns = "/other")
public class OtherServlet extends HttpServlet {
    private static final String SPACE = " ";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getAttribute(Attributes.ERROR) == null) {
            String firstName = (String) request.getAttribute(Attributes.FIRST_NAME);
            String lastName = (String) request.getAttribute(Attributes.LAST_NAME);
            String age = (String) request.getAttribute(Attributes.AGE);

            System.out.println(
                    firstName + SPACE +
                    lastName + SPACE +
                    age
            );
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
