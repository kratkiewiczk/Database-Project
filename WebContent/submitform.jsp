<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Submit Initial Quote Request</title>
</head>
<body>
    <h1>Submit Initial Quote Request</h1>

    <%
        String name = request.getParameter("initialName");
        String email = request.getParameter("initialEmail");
        String phone = request.getParameter("initialPhone");
        String submittedQuote = request.getParameter("initialQuote");

        try {
            String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/davidsmith";
            String dbUser = "john";
            String dbPassword = "john1234";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);

            String insertQuery = "INSERT INTO davidsmith (name, email, phone, quote_request) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, name != null ? name : "");
                preparedStatement.setString(2, email != null ? email : "");
                preparedStatement.setString(3, phone != null ? phone : "");
                preparedStatement.setString(4, submittedQuote != null ? submittedQuote : "");

                preparedStatement.executeUpdate();
            }

            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    %>

    <form action="davidsmith.jsp" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required value="<%= (name != null) ? name : "" %>"><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required value="<%= (email != null) ? email : "" %>"><br>
        <label for="phone">Phone:</label>
        <input type="tel" id="phone" name="phone" value="<%= (phone != null) ? phone : "" %>"><br>
        <label for="initialQuote">Quote Request:</label>
        <textarea id="initialQuote" name="initialQuote" required><%= (submittedQuote != null) ? submittedQuote : "" %></textarea><br>
        <input type="submit" value="Submit Initial Quote Request">
    </form>

    <div>
        <a href="login.jsp" target="_self" class="link">Login</a>
    </div>
    <div>
        <a href="register.jsp" target="_self" class="link">Register</a>
    </div>
</body>
</html>

