<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Statistics</title>
</head>
<body>

<%
	int[] paid = (int[]) session.getAttribute("paid");
	int[] total = (int[]) session.getAttribute("total");
	int count = 0;
%>

<div align = "center">

<h1>Statistics Page</h1>

	<h2>Big Clients</h2>
	
	<div align="center">
        <table border="1" cellpadding="6">
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
            <c:forEach var="users" items="${big}">
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
	
	<h2>Easy Clients</h2>
	
	 <table border="1" cellpadding="6">
            <tr>
                <th>QuoteID</th>
                <th>Price</th>
                <th>Time Window</th>
                <th>Status</th>
                <th>Email</th>
            </tr>
            <c:forEach var="quotes" items="${easy}">
                <tr style="text-align:center">
                    <td><c:out value="${quotes.quoteID}" /></td>
                    <td><c:out value="${quotes.price}" /></td>
                    <td><c:out value="${quotes.timeWindow}" /></td>
                    <td><c:out value="${quotes.stat}"/></td>
                    <td><c:out value="${quotes.email}" /></td>
            </c:forEach>
        </table>
	
	<h2>One Tree Quotes</h2>
	
	<table border="1" cellpadding="6">
            <tr>
                <th>QuoteID</th>
                <th>Price</th>
                <th>Time Window</th>
                <th>Status</th>
                <th>Email</th>
            </tr>
            <c:forEach var="quotes" items="${oneTree}">
                <tr style="text-align:center">
                    <td><c:out value="${quotes.quoteID}" /></td>
                    <td><c:out value="${quotes.price}" /></td>
                    <td><c:out value="${quotes.timeWindow}" /></td>
                    <td><c:out value="${quotes.stat}"/></td>
                    <td><c:out value="${quotes.email}" /></td>
            </c:forEach>
        </table>
	
	<h2>Prospective Clients</h2>
	
        <table border="1" cellpadding="6">
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
            <c:forEach var="users" items="${prospective}">
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
	
	<h2>Highest Tree</h2>
	
	    <table border="1" cellpadding="6">
            <tr>
                <th>TreeID</th>
                <th>Height</th>
                <th>Near Building?</th>
                <th>Associated QuoteID</th>
                <th>Email</th>
            </tr>
            <c:forEach var="trees" items="${highest}">
                <tr style="text-align:center">
                    <td><c:out value="${trees.treeID}" /></td>
                    <td><c:out value="${trees.height}" /></td>
                    <td><c:out value="${trees.nearBuild}" /></td>
                    <td><c:out value="${trees.quoteID}" /></td>
                    <td><c:out value="${trees.email}" /></td>
            </c:forEach>
        </table>
	
	<h2>Overdue Bills</h2>
	
	<table border="1" cellpadding="6">
            <tr>
                <th>BillID</th>
                <th>Amount</th>
                <th>Status</th>
                <th>Associated QuoteID</th>
                <th>Email</th>
            </tr>
            <c:forEach var="bills" items="${overdue}">
                <tr style="text-align:center">
                    <td><c:out value="${bills.billID}" /></td>
                    <td><c:out value="${bills.amount}" /></td>
                    <td><c:out value="${bills.stat}" /></td>
                    <td><c:out value="${bills.quoteID}" /></td>
                    <td><c:out value="${bills.email}" /></td>
            </c:forEach>
        </table>
	
	<h2>Bad Clients</h2>
	
	<table border="1" cellpadding="6">
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
            <c:forEach var="users" items="${bad}">
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
	
	<h2>Good Clients</h2>
	
	<table border="1" cellpadding="6">
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
            <c:forEach var="users" items="${good}">
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
	
	<h2>Client Statistics</h2>
	
	<table border="1" cellpadding="6">
            <tr>
                <th>Email</th>
                <th>TreeID</th>
                <th>Date</th>
            </tr>
            <c:forEach var="stats" items="${statistics}">
                <tr style="text-align:center">
                    <td><c:out value="${stats.email}" /></td>
                    <td><c:out value="${stats.trees}" /></td>
                    <td><c:out value="${stats.date}" /></td>
            </c:forEach>
        </table>
        <br>
        <table border="1" cellpadding="6">
            <tr>
                <th>Email</th>
                <th>Total Paid</th>
                <th>Total Due</th>
            </tr>
            <c:forEach var="users" items="${users}">
                <tr style="text-align:center">
                    <td><c:out value="${users.email}" /></td>
                    <td><%= paid[count] %></td>
                    <td><%= total[count] %></td>
                    <% count++; %>
                </tr>
            </c:forEach>
        </table>

</div>
</body>
</html>