<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP - Hello World</title>
    </head>
    <body>
        <h1>JSP Scriptlet Tags</h1>
        <p>This is how we inject multi-line code into the JSP such as if statements, method calls, etc...</p>
        <br>

        <%-- This is how to make a JSP comment --%>
        <%
            // This is a scriptlet
            double myTestScore = 100.0;
            myTestScore = myTestScore - 10.0;
        %>

        <!-- This is a JSP expression tag -->
        <p>My real test score: <%= myTestScore%>
        </p>

        <% if (1 + 2 == 2) { %>
        <p>One plus one is indeed equal to two</p>
        <% } else { %>
        <p>Never mind...</p>
        <% }%>

        <ul>
            <% for (int i = 0; i < 25; i++) {%>
            <li>Listing #<%= i + 1 %></li>
            <% } %>
        </ul>
    </body>
</html>