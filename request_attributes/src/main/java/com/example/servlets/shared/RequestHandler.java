package com.example.servlets.shared;

import com.example.servlets.Attributes;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.System.err;

public class RequestHandler {
    protected static final String[] REQUEST_DESTINATIONS = new String[]{
            "/name.jsp",          // JSP
            "/other"              // another servlet
    };
    private static RequestHandler instance = null;

    private RequestHandler() {
        // Required Empty constructor
    }

    public static RequestHandler getInstance() {
        if (instance == null)
            instance = new RequestHandler();

        return instance;
    }

    /**
     * Utility function for redirecting the user to the requested page.
     *
     * @param servletContext the context of the servlet.
     * @param request        initial request object
     * @param response       response object for the initial request
     */
    public void redirect(ServletContext servletContext, HttpServletRequest request, HttpServletResponse response) {
        try {
            servletContext.getRequestDispatcher(REQUEST_DESTINATIONS[1]).forward(request, response);
        } catch (ServletException | IOException exception) {
            err.printf("An exception has occurred %s", exception);
        }
    }

    /**
     * Utility method for obtaining the GET request parameters.
     *
     * @param request the request object from which the parameters are extracted.
     * @return a String array containing the values of the request parameters.
     */
    public String[] getRequestParams(HttpServletRequest request) {
        return new String[]{
                request.getParameter(Attributes.FIRST_NAME),
                request.getParameter(Attributes.LAST_NAME),
                request.getParameter(Attributes.AGE)
        };
    }

    /**
     * Utility method for handling a get request to the NameServlet.jsp file.
     *
     * @param request the request object.
     */
    public void handleRequest(HttpServletRequest request) {
        validateRequest(request,
                getErrorMessage(getRequestParams(request)),
                getRequestParams(request)
        );
    }

    /**
     * Utility method to check for possible errors.
     *
     * @param errorMessage the message to be checked.
     * @return true if there is at least 1 error, false otherwise.
     */
    public boolean isError(StringBuilder errorMessage) {
        return errorMessage.length() > 0;
    }

    /**
     * Utility method for validating the request to the servlet.
     *
     * @param request       the request object.
     * @param errorMessage  the (possible) errors obtained from "getErrorMessage()".
     * @param requestParams the  attributes to set if the request is without errors.
     */
    public void validateRequest(HttpServletRequest request, StringBuilder errorMessage, String[] requestParams) {
        if (isError(errorMessage)) {
            request.setAttribute(Attributes.ERROR, errorMessage.toString());
        } else {
            request.setAttribute(Attributes.FIRST_NAME, requestParams[0]);
            request.setAttribute(Attributes.LAST_NAME, requestParams[1]);
            request.setAttribute(Attributes.AGE, requestParams[2]);
        }
    }

    /**
     * Utility method for building the (possible) error message.
     *
     * @param requestParams the URL parameters to be checked.
     * @return the errorMessage containing 0..* messages.
     */
    public StringBuilder getErrorMessage(String[] requestParams) {
        StringBuilder errorMessage = new StringBuilder();
        if (requestParams[0] == null) {
            errorMessage.append("A first name was not provided.");
        } else if (requestParams[1] == null) {
            errorMessage.append("A last name was not provided");
        } else if (requestParams[2] == null) {
            errorMessage.append("An age was not provided.");
        }
        return errorMessage;
    }
}
