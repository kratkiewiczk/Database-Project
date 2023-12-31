<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>All Users</title>
</head>
<body>
   <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>People List</h2></caption>
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
                    <td><c:out value="${users.adress_street_num} ${users.adress_street} ${users.adress_city} ${users.adress_state} ${users.adress_zip_code}" /></td>
                    <td><c:out value="${users.password}" /></td>
                    <td><c:out value="${users.creditCard}" /></td>
                    <td><c:out value="${users.phoneNumber}" /></td>
                    <td><c:out value="${users.role}" /></td>
                    <td><c:out value="${users.clientID}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
