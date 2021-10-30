<%@ page import="java.util.Date" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Test JSP</title>
    </head>
    <body>
        <h1>JSP Expressions</h1>
        <p>JSP Expression tags allow you to directly put Java expressions into an HTML file. This includes math expressions, boolean expression, and calling methods that return values to be displayed on the page.</p>
        <p>Here are a few examples:</p>
        <br>

        <p>Calling a method: <%= Math.addExact(2, 3)%></p>
        <p>Evaluating a boolean: <%= "bob".length() < 3 %></p>
        <p>Math expression: <%= (500.6 * 7) - 50 %></p>
        <p>Java object: <%= new Date() %></p>

        <p>In each of the examples, they are implicitly being converted into String before being added to the HTML.</p>
    </body>
</html>


