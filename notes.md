### JSP and Servlets
Java™ servlets and Java server pages (JSPs) are Java programs that run on a Java application server and extend the capabilities of the Web server.

Java servlets are Java classes that are designed to respond to HTTP requests in the context of a Web application.

You can look at JSPs as an extension of HTML that gives you the ability to seamlessly embed snippets of Java code within your HTML pages. These bits of Java code generate dynamic content, which is embedded within the other HTML/XML content. A JSP is translated into a Java servlet and executed on the server. JSP statements embedded in the JSP become part of the servlet generated from the JSP. The resulting servlet is executed on the server.

The HTTP Server does not run Java Web applications directly. HTTP requests for Java applications are forwarded by the HTTP Server to Java application servers. IBM® provides the following Java application servers to run Java applications:

WebSphere® Application Server
IBM's strategic Web application server and provides enterprise level support for Java servlets, JSPs, and EJBs (Enterprise Java Beans).

Integrated Web Application Server
A lightweight application server for Java applications that is integrated into the IBM i operating system.

- Read the <a href="https://www.ibm.com/docs/en/i/7.2?topic=java-jsp-servlet-programming">documentation.</a>

### Video resources
- <a href="https://www.youtube.com/watch?v=pxmWgTRETi4">How servlets work.</a>
- Watch the video <a href="https://www.youtube.com/watch?v=0FpLve7ffoY&list=PLfu_Bpi_zcDOn8ajnuLY6g1C6hc_eeDFl&index=1">guide</a> series.

### WEB-INF
- Directory for holding files/content has is intended to be hidden from the users.

### Servlets
- Primary use case, handle HTTP requests, process them and send a response in the view.
- Whenever creating a servlet, it needs to be mapped to a specific url. For example, a
servlet annotated with `@WebServlet(name = "HelloServlet", value = "/HelloServlet", urlPatterns = "/hello")`
will enable HTTP operations on `localhost:8080/hello` (assuming the base url is `localhost:8080`).
- The `HttpServlet` abstract class provides skeletons for all HTTP operations, their physical implementations is done
within a servlet.
- URLs (patterns) are matched to their respective servlet through the Servlet container. The used identifier(s)
is/are the one(s) specified in the urlPatterns string array property of the servlet.

### Conversion
- JSP files are converted under the hood of the web application to servlets when a request is made.

### Response
- Whenever the server responds to the client, the response data content type is one of <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Basics_of_HTTP/MIME_types">these.</a>
- However, usually, the response is html.
- The response data content type can be set using `.setContentType("mimeType")` on the response object.
Example:
```
        response.setContentType("text/plain");                 <---- set plaintext as content type
                        
        response.getWriter().println("Here is a line");        <---- add a text line
        response.getWriter().println("Here is another line."); <---- add another text line
```

### Unable to create new servlet
- <a href="https://www.youtube.com/watch?v=NQZSbZZvXbo">Possible fix.</a>

### webapp
- Within the `webapp` directory, the following files should be place:
    - *.css
    - *.html
    - *.jsp

### Mapping urls to servlets
Can be done in 2 ways:
<ol type="a">
  <li>Using Annotations</li>
  <li>Using a XML configuration file</li>
</ol>

Example of urlPatterns:
```
                                                     |----- wild card
urlPatterns = {"/ed", "/cheese", "/ed/fis", "/ed/fis/*"}
```

# Configure home route
- In order to access the home route ("/") within the web application, do the following:
1. Select the dropdown menu next to "Build Project" (the green hammer icon).
2. Click "Edit Configurations...".
3. In the menu tab, select the "Deployment" tab.
4. Clear/Delete all the content (defaults) of the "Application context:" tab.
5. Click on the "Apply" button.
6. Click on the "Ok" button.
- Now the web application can be run with the homepage being `localhost:8080`. Any subsequent URLs
follow this base url.

# XML configuration mappings
- Multiple URL mappings can be added for a specified servlet through xml configuration (in the `web.xml` file).
Example
```
 <servlet-mapping>
        <servlet-name>XMLServlet</servlet-name>
        <url-pattern>/food</url-pattern>
    </servlet-mapping>
    <servlet-mapping>
        <servlet-name>XMLServlet</servlet-name>
        <url-pattern>/drinks</url-pattern>
    </servlet-mapping>
    <servlet-mapping>
        <servlet-name>XMLServlet</servlet-name>
        <url-pattern>/drink/*</url-pattern>
    </servlet-mapping>
```

# Forwarding
- Reroute the request to another resource (*.jsp, *.html, another servlet).

# Servlet context
- Can be retrieved using `getServletContext()`.
- The servlet context is the object allowing interactions with the servlet container (which is the servlet manager).

# Servlet container
- Read <a href="https://dzone.com/articles/what-servlet-container">this.</a>

# Redirect
- Similar to rerouting, but the key distinction is that when the users are to be kept within our application, we reroute/forward them
to different urls. When the users should be sent to another application, they are being redirected.
- Moreover, the request object is not persisted in the case of redirecting a user whilst with forwarding, it is.

# Full-fledged web applications
- MVC as a DP.
- The model is the transaction entity, the view is represented by the `*.jsp` files and the controllers are based on the servlets.