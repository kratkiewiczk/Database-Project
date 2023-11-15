<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.Random" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Initial Quote Request</title>
</head>
<body>

<%
    String initialName = request.getParameter("initialName");
    String initialEmail = request.getParameter("initialEmail");
    String initialPhone = request.getParameter("initialPhone");
    String initialQuote = request.getParameter("initialQuote");

    System.out.println("Initial Name from form: " + initialName);
    System.out.println("Initial Email from form: " + initialEmail);
    System.out.println("Initial Phone from form: " + initialPhone);
    System.out.println("Initial Quote request from form: " + initialQuote);

    Random random = new Random();
    int randomId = random.nextInt(1000000);

    try {
        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/quotes";
        String dbUser = "john";
        String dbPassword = "john1234";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);

        String insertQuery = "INSERT INTO davidsmith (id, name, email, phone, quote_request) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setInt(1, randomId);
            preparedStatement.setString(2, initialName != null ? initialName : "");
            preparedStatement.setString(3, initialEmail != null ? initialEmail : "");
            preparedStatement.setString(4, initialPhone != null ? initialPhone : "");
            preparedStatement.setString(5, initialQuote != null ? initialQuote : "");

            preparedStatement.executeUpdate();
        }

        connection.close();
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
%>

<h2>Initial Quote Request Submitted Successfully</h2>
<p>Name: <%= initialName %></p>
<p>Email: <%= initialEmail %></p>
<p>Phone: <%= initialPhone %></p>
<p>Quote Request: <%= initialQuote %></p>

</body>
</html>