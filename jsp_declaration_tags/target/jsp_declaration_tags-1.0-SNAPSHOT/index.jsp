<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP - Hello World</title>
    </head>
    <body>
        <%!
            int value = 150;

            int add(int num1, int num2) {
                return num1 + num2;
            }

            int subtract(int num1, int num2) {
                return num1 - num2;
            }
        %>
        <br>
        <h3>Result of 34 + 5 : <%= add(34, 5)%>
        </h3>
        <h3>Result of 56 - 18 : <%= subtract(34, 5)%>
        </h3>

        <%!
            String name = "Obi-wan";
            int age = 99;

            String getFavoritePadawan(){
                return "Anakin Skywalker";
            }
        %>
        <h3>My name is <%= name %> and I am <%= age%> years old. My favorite padawan is <%= getFavoritePadawan()%></h3>

    </body>
</html>