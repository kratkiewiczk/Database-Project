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

<% int count = 1;%>

<h1>Quote #<%= request.getParameter("quoteID") %> Information</h1>

    <div align="center">
        <table border="1" cellpadding="6">
            <caption><h2>Tree(s)</h2></caption>
            <tr>
                <th>Tree #</th>
                <th>Height</th>
                <th>Near Building?</th>
            </tr>
            <c:forEach var="trees" items="${listTree}">
                <tr style="text-align:center">
                    <td><c:out value="<%= count %>" /></td>
                    <td><c:out value="${trees.height}" /></td>
                    <td><c:out value="${trees.nearBuild}" /></td>
                </tr>
                <% count++; %>
            </c:forEach>
        </table>
        
        <table border="1" cellpadding="6">
            <caption><h2>Message(s)</h2></caption>
            <tr>
                <th>Note</th>
                <th>Email</th>
            </tr>
            <c:forEach var="messages" items="${listMessage}">
                <tr style="text-align:center">
                    <td><c:out value="${messages.note}" /></td>
                    <td><c:out value="${messages.email}" /></td>
                </tr>
            </c:forEach>
        </table>
        
        <form action="initialquoteresponse.jsp" method="post">
        <button type="submit" name="submit" value="respond">Send a Message</button>
    	</form>
        
        <table border="1" cellpadding="6">
            <caption><h2>Order</h2></caption>
            <tr>
                <th>OrderID</th>
                <th>Status</th>
                <th></th>
            </tr>
            <c:forEach var="ords" items="${listOrd}">
                <tr style="text-align:center">
                    <td><c:out value="${ords.ordID}" /></td>
                    <td><c:out value="${ords.stat}" /></td>
                    <td>
                    <form action="updateOrd" method="post">
        				<button type="submit" name="submit" value="respond">Update Progress</button>
    				</form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        
        <table border="1" cellpadding="6">
            <caption><h2>Bill</h2></caption>
            <tr>
                <th>BillID</th>
                <th>Amount</th>
                <th>Status</th>
            </tr>
            <c:forEach var="bills" items="${listBill}">
                <tr style="text-align:center">
                    <td><c:out value="${bills.billID}" /></td>
                    <td><c:out value="${bills.amount}" /></td>
                    <td><c:out value="${bills.stat}" /></td>
                </tr>
            </c:forEach>
        </table>
        
    	
    	<div>
		<a href="login.jsp"target ="_self" > logout</a><br><br> 
		</div>
	</div>
</div>
</body>
</html>