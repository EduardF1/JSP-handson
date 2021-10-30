package com.example.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import static java.lang.System.err;
import static java.lang.System.out;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/register")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // processing post from form request
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        if (areAllParametersValid(email, name, age, password, confirmPassword)) {
            request.setAttribute("error", "One the required values is missing.");
            try {
                doGet(request, response);
            } catch (ServletException | IOException exception) {
                err.printf("An exception has occurred %s", exception);
            }
        } else {
            if (!password.equals(confirmPassword)) {
                request.setAttribute("error", "The passwords do not match.");
                try {
                    doGet(request, response);
                } catch (ServletException | IOException exception) {
                    err.printf("An exception has occurred %s", exception);
                }
            } else {
                out.println("The account has been created.");
            }
        }
    }

    private boolean areAllParametersValid(String email, String name, String age, String password, String confirmPassword) {
        return  isAgeValid(age) ||
                isNameValid(name) ||
                isEmailValid(email) ||
                isPasswordValid(password) ||
                isConfirmPasswordValid(confirmPassword);
    }

    private boolean isConfirmPasswordValid(String confirmPassword) {
        return confirmPassword == null || confirmPassword.equals("");
    }

    private boolean isPasswordValid(String password) {
        return password == null || password.equals("");
    }

    private boolean isAgeValid(String age) {
        return age == null || age.equals("");
    }

    private boolean isEmailValid(String email) {
        return email == null || email.equals("");
    }

    private boolean isNameValid(String name) {
        return name == null || name.equals("");
    }
}
