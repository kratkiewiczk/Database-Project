<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.*, java.math.BigDecimal, java.util.Random" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Client Responses</title>
</head>
<body>
    <h1>Client Responses</h1>
    
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Phone Number</th>
            <th>Quote Request</th>
            <th>Actions</th>
        </tr>
        <tr>
            <td><%= request.getParameter("name") %></td>
            <td><%= request.getParameter("email") %></td>
            <td><%= request.getParameter("phone") %></td>
            <td><%= request.getParameter("description") %></td>
            <td>
                <form action="submitted.jsp" method="post">
                    <input type="hidden" name="responseStatus" value="accepted">
                    <button type="submit" name="submit" value="accept">Accept</button>
                </form>
                <form action="submitted.jsp" method="post">
                    <input type="hidden" name="responseStatus" value="quit">
                    <button type="submit" name="submit" value="Decline/quit">Decline/Quit</button>
                </form>
            </td>
        </tr>
    </table>
    <a href="login.jsp" target="_self">Return to Login Page</a>
    </div>
    <div>
        <a href="DavidSmith.jsp" target="_self">David Smith</a><br><br> 
    </div>

    <%
    
        Random random = new Random();
        BigDecimal randomBillAmount = new BigDecimal(random.nextDouble() * 100); 

        session.setAttribute("Bill", randomBillAmount);
    %>
</body>
</html>






