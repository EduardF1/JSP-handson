package com.example.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import static java.lang.System.err;

@WebServlet(name = "CalculatorServlet", urlPatterns = {"", "/"})
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    private boolean areFormValuesInvalid(String years, String principalAmount, String compoundingPeriod, String interestPercentage) {
        return  (years == null || years.equals("")) ||
                (principalAmount == null || principalAmount.equals("")) ||
                (compoundingPeriod == null || compoundingPeriod.equals("")) ||
                (interestPercentage == null || interestPercentage.equals(""));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String error;
        String years = request.getParameter("years");
        String principalAmount = request.getParameter("principal-amount");
        String compoundingPeriod = request.getParameter("compounding-period");
        String interestPercentage = request.getParameter("interest-percentage");

        if (areFormValuesInvalid(years, principalAmount, compoundingPeriod, interestPercentage)) {
            error = "One or more of the required values are blank. Please try again.";
            request.setAttribute("error", error);
        } else {
            double result = 0.0;
            try {
                result = Utils.calculateCompoundInterest(
                        Double.parseDouble(principalAmount),
                        (Double.parseDouble(interestPercentage) / 100),
                        Integer.parseInt(years),
                        Integer.parseInt(compoundingPeriod)
                );
            } catch (NumberFormatException exception) {
                err.printf("An exception has occurred, %s", exception);
            }
            request.setAttribute("result", result);

        }
        request.setAttribute("years", years);
        request.setAttribute("principal", principalAmount);
        request.setAttribute("interest", interestPercentage);
        request.setAttribute("compounding", compoundingPeriod);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
