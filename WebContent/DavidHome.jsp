<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Root page</title>
</head>
<body>

<div align = "center">
	
	<form action = "initialize">
		<input type = "submit" value = "Initialize the Database"/>
	</form>
	<div>
	<a href="login.jsp"target ="_self" > logout</a><br><br> 
	</div>
	<div>
	<a href="DavidSmith.jsp"target ="_self" > David Smith</a><br><br> 
	</div>

<h1>All Quotes</h1>
    <div align="center">
                <table border="1" cellpadding="6">
            <caption><h2>Quote</h2></caption>
            <tr>
                <th>QuoteID</th>
                <th>Price</th>
                <th>Time Window</th>
                <th>Status</th>
                <th>Email</th>
            </tr>
            <c:forEach var="quotes" items="${listQuote}">
                <tr style="text-align:center">
                    <td><c:out value="${quotes.quoteID}" /></td>
                    <td><c:out value="${quotes.price}" /></td>
                    <td><c:out value="${quotes.timeWindow}" /></td>
                    <td><c:out value="${quotes.stat}"/></td>
                    <td><c:out value="${quotes.email}" /></td>
            </c:forEach>
        </table>
        
        
        <form action="DavidSmith.jsp" method="post">
        <button type="submit" name="submit" value="respond">See Quote Info</button>
    	</form>
        
        
	</div>
	</div>
</body>
</html>