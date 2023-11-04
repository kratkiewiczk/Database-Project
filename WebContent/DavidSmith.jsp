<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>David Smith Registration</title>
</head>
<body>
    <center>
        <h1>Welcome David Smith!</h1>
    </center>
    <center>
        <h1>You have been successfully logged in.</h1>
    </center>
    <div>
        <center>
            <a href="login.jsp" target="_self">Logout</a>
        </center>
    </div>
    <div></div>
    <hr>
    <form id="clientRequestForm" action="InitialQuote.jsp" method="post">
        <table border="1">
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Address</th>
                <th>Initial Quote</th>
                <th>Actions</th>
            </tr>
            <tr>
                <td>${quote.name}</td>
                <td>${quote.email}</td>
                <td>${quote.address}</td>
                <td>
                    <input type="hidden" name="quoteId" value="${quote.id}">
                    <a href="InitialQuote.jsp?submitted=true">
                        <button type="submit" name="submit" value="respond">Submit Initial Quote to Client</button>
                    </a>
                </td>
                <td>
                    <c:if test="${param.submitted == 'true'}">
                        Your initial quote request has been submitted to this client.
                    </c:if>
                </td>
            </tr>
        </table>
    </form>
    
    <a href="Clientresponses.jsp">
        <button type="button">View all client responses</button>
    </a>
</body>
</html>






