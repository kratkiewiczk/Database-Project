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

<h1>List all users</h1>
    <div align="center">
        <table border="1" cellpadding="6">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>Email</th>
                <th>First name</th>
                <th>Last name</th>
                <th>Address</th>
                <th>Password</th>
                <th>Credit Card</th>
                <th>Phone Number</th>
                <th>Role</th>
                <th>Client ID</th>
            </tr>
            <c:forEach var="users" items="${listUser}">
                <tr style="text-align:center">
                    <td><c:out value="${users.email}" /></td>
                    <td><c:out value="${users.firstName}" /></td>
                    <td><c:out value="${users.lastName}" /></td>
                    <td><c:out value= "${users.adress_street_num} ${users.adress_street} ${users.adress_city} ${users.adress_state} ${users.adress_zip_code}" /></td>
                    <td><c:out value="${users.password}" /></td>
                    <td><c:out value="${users.creditCard}" /></td>
                    <td><c:out value="${users.phoneNumber}"/></td>
                    <td><c:out value="${users.role}"/></td>
                    <td><c:out value="${users.clientID}" /></td>
            </c:forEach>
        </table>
                <table border="1" cellpadding="6">
            <caption><h2>Message</h2></caption>
            <tr>
                <th>MessageID</th>
                <th>Note</th>
                <th>Associated QuoteID</th>
                <th>Email</th>
            </tr>
            <c:forEach var="messages" items="${listMessage}">
                <tr style="text-align:center">
                    <td><c:out value="${messages.messageID}" /></td>
                    <td><c:out value="${messages.note}" /></td>
                    <td><c:out value="${messages.quoteID}" /></td>
                    <td><c:out value="${messages.email}" /></td>
            </c:forEach>
        </table>
                <table border="1" cellpadding="6">
            <caption><h2>Tree</h2></caption>
            <tr>
                <th>TreeID</th>
                <th>Height</th>
                <th>Near Building?</th>
                <th>Associated QuoteID</th>
            </tr>
            <c:forEach var="trees" items="${listTree}">
                <tr style="text-align:center">
                    <td><c:out value="${trees.treeID}" /></td>
                    <td><c:out value="${trees.height}" /></td>
                    <td><c:out value="${trees.nearBuild}" /></td>
                    <td><c:out value="${trees.quoteID}" /></td>
            </c:forEach>
        </table>
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
                <table border="1" cellpadding="6">
            <caption><h2>Order</h2></caption>
            <tr>
                <th>OrderID</th>
                <th>Status</th>
                <th>Associated QuoteID</th>
                <th>Email</th>
            </tr>
            <c:forEach var="ords" items="${listOrd}">
                <tr style="text-align:center">
                    <td><c:out value="${ords.ordID}" /></td>
                    <td><c:out value="${ords.stat}" /></td>
                    <td><c:out value="${ords.quoteID}" /></td>
                    <td><c:out value="${ords.email}" /></td>
            </c:forEach>
        </table>
                <table border="1" cellpadding="6">
            <caption><h2>Bill</h2></caption>
            <tr>
                <th>BillID</th>
                <th>Amount</th>
                <th>Status</th>
                <th>Associated QuoteID</th>
                <th>Email</th>
            </tr>
            <c:forEach var="bills" items="${listBill}">
                <tr style="text-align:center">
                    <td><c:out value="${bills.billID}" /></td>
                    <td><c:out value="${bills.amount}" /></td>
                    <td><c:out value="${bills.stat}" /></td>
                    <td><c:out value="${bills.quoteID}" /></td>
                    <td><c:out value="${bills.email}" /></td>
            </c:forEach>
        </table>
	</div>
	</div>
</body>
</html>