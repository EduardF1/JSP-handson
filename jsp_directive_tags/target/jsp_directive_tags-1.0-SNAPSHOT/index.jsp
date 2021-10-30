<%@ page import="com.example.jsp_directive_tags.Utility" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP - Hello World</title>
    </head>
    <body>

        <%@ include file="header.jsp"%>

        <h1><%= Utility.kaboom() %>
        </h1>
        <br/>
        <a href="hello-servlet">Hello Servlet</a>

        <%@ include file="footer.jsp"%>
    </body>
</html>