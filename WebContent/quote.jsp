<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Request Submitted</title>
</head>
<body>
    <h1>Request Submitted</h1>
    <%
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String description = request.getParameter("description");
    %>
    <p>Thank you, <%= name %> Your request has been submitted successfully.</p>
    <div>
	<a href="login.jsp" target="_self" class="link">Login</a>
	</div>
	<div>
	<a href="register.jsp" target="_self" class="link">Register</a>
	</div>
</body>
</html>
