<%-- 
    Document   : index
    Created on : Jan 12, 2025, 1:12:06 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="GeoServlet" method="post">
            <table>
                <tr>
                    <td><select name="hinh">
                            <option value="Circle" <%= "Circle".equals(request.getAttribute("hinh")) ? "selected" : ""%>>Circle</option>
                            <option value="Square" <%= "Square".equals(request.getAttribute("hinh")) ? "selected" : ""%>>Square</option>
                            <option value="Triangular" <%= "Triangular".equals(request.getAttribute("hinh")) ? "selected" : ""%>>Triangular</option>
                            <option value="Rectangle" <%= "Rectangle".equals(request.getAttribute("hinh")) ? "selected" : ""%>>Rectangle</option>
                        </select>   </td>

                </tr>
                <tr>
                    <td><input type="submit" value="Choose" /> </td>
                </tr>
            </table>
        </form>
        <div>
            <h2><%= request.getAttribute("hinh") != null ? request.getAttribute("hinh") : ""%></h2>
            <%
                String img = (String) request.getAttribute("base64img");
                if (img != null && !img.equals("Error encoding image.")) {
            %>
            <img src="data:img/png;base64,<%= img%>" alt="Shape Image" />
            <%
                }
            %>
        </div>
    </body>
</html>
