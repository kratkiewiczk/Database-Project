<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>

<div align="center">
<%
	String user = (String) session.getAttribute("username");
	int[] idList = (int[]) session.getAttribute("idList");
	int count = 0;
%>

<h1>Welcome <%= user %>, to Your Home Page </h1>
<h2>View All Quotes and Set Up the Info</h2>

    <div align="center">
        <table border="1" cellpadding="6">
            <caption><h2>Quotes</h2></caption>
            <tr>
                <th>QuoteID</th>
                <th>Price</th>
                <th>Time Window</th>
                <th>Status</th>
                <th>Email</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="quotes" items="${listQuote}">
                <tr style="text-align:center">
                    <td><c:out value="${quotes.quoteID}" /></td>
                    <td><c:out value="${quotes.price}" /></td>
                    <td><c:out value="${quotes.timeWindow}" /></td>
                    <td><c:out value="${quotes.stat}"/></td>
                    <td><c:out value="${quotes.email}" /></td>
                    <td>
                    <form action="tempDavid" method="post">
                            <input type="hidden" name="quoteID" value="<%= idList[count] %>" />
                            <input type="submit" value="Visit this Quote" />
                        </form>
                    </td>
                    <td>
                    <form action="edit" method="post">
                            <input type="hidden" name="quoteID" value="<%= idList[count] %>" />
                            <input type="submit" value="Edit this Quote" />
                        </form>
                    </td>
                    <% count++; %>
            </c:forEach>
        </table>
               
        <div>
		<a href="Statistics.jsp"target ="_self" >View Statistics</a><br><br> 
		</div> 
                
        <div>
		<a href="DavidSmith.jsp"target ="_self" >Other Page</a><br><br> 
		</div>    
    	
    	<div>
		<a href="login.jsp"target ="_self" > logout</a><br><br> 
		</div>
	</div>
</div>
</body>
</html>