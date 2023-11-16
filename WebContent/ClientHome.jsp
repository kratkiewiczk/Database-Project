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
<h2>Select a Quote or Request a New One</h2>

    <div align="center">
        <table border="1" cellpadding="6">
            <caption><h2>Your Quote(s)</h2></caption>
            <tr>
                <th>QuoteID</th>
                <th>Price</th>
                <th>Time Window</th>
                <th>Status</th>
                <th></th>
            </tr>
            <c:forEach var="quotes" items="${listTempQuote}">
                <tr style="text-align:center">
                    <td><c:out value="${quotes.quoteID}" /></td>
                    <td><c:out value="${quotes.price}" /></td>
                    <td><c:out value="${quotes.timeWindow}" /></td>
                    <td><c:out value="${quotes.stat}"/></td>
                    <td>
                    <form action="temp" method="post">
                            <input type="hidden" name="quoteID" value="<%= idList[count] %>" />
                            <input type="submit" value="Visit this Quote" />
                        </form>
                    </td>
                    <% count++; %>
                    
                </tr>
            </c:forEach>
        </table>
        
<form action="treenumber.jsp" method="post">
    <button type="submit" name="submit" value="respond">Request a Quote</button>
</form>

<form action="form1.jsp" method="post">
    <button type="submit" name="submit" value="respond">Respond to initial quote</button>
</form>

    	
    	<div>
		<a href="login.jsp"target ="_self" > logout</a><br><br> 
		</div>
	</div>
</div>
</body>
</html>