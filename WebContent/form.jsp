<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Request a Quote</title>
</head>
<body>
    <h1>Request a Quote</h1>
    <form action="quote.jsp" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>
        <label for="phone">Phone:</label>
        <input type="tel" id="phone" name="phone"><br>
        <label for="description">Quote Request:</label>
        <textarea id="description" name="description" required></textarea><br>
        <input type="submit" value="Submit Quote Request">
    </form>
    <div>
	<a href="login.jsp" target="_self" class="link">Login</a>
	</div>
	<div>
	<a href="register.jsp" target="_self" class="link">Registration</a>
	</div>
</body>
</html>
