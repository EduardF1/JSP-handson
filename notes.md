# JSP and Servlets
Java™ servlets and Java server pages (JSPs) are Java programs that run on a Java application server and extend the capabilities of the Web server.

Java servlets are Java classes that are designed to respond to HTTP requests in the context of a Web application.

You can look at JSPs as an extension of HTML that gives you the ability to seamlessly embed snippets of Java code within your HTML pages. These bits of Java code generate dynamic content, which is embedded within the other HTML/XML content. A JSP is translated into a Java servlet and executed on the server. JSP statements embedded in the JSP become part of the servlet generated from the JSP. The resulting servlet is executed on the server.

The HTTP Server does not run Java Web applications directly. HTTP requests for Java applications are forwarded by the HTTP Server to Java application servers. IBM® provides the following Java application servers to run Java applications:

WebSphere® Application Server
IBM's strategic Web application server and provides enterprise level support for Java servlets, JSPs, and EJBs (Enterprise Java Beans).

Integrated Web Application Server
A lightweight application server for Java applications that is integrated into the IBM i operating system.

- Source: https://www.ibm.com/docs/en/i/7.2?topic=java-jsp-servlet-programming

#WEB-INF
- Directory for holding files/content has is intended to be hidden from the users.

#Servlets
- Primary use case, handle HTTP requests, process them and send a response in the view.
- Whenever creating a servlet, it needs to be mapped to a specific url. For example, a
servlet annotated with `@WebServlet(name = "HelloServlet", value = "/HelloServlet", urlPatterns = "/hello")`
will enable HTTP operations on `localhost:8080/hello` (assuming the base url is `localhost:8080`).
- The `HttpServlet` abstract class provides skeletons for all HTTP operations, their physical implementations is done
within a servlet.

#Conversion
- JSP files are converted under the hood of the web application to servlets when a request is made.

#Response
- Whenever the server responds to the client, the response data content type is one of <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Basics_of_HTTP/MIME_types">these.</a>
- However, usually, the response is html (the requested page).
- The response data content type can be set using `.setContentType("mimeType")` on the response object.
Example:
```
        response.setContentType("text/plain");                 <---- set plaintext as content type
                        
        response.getWriter().println("Here is a line");        <---- add a text line
        response.getWriter().println("Here is another line."); <---- add another text line
```