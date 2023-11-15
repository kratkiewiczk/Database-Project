<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Respond to initial quote</title>
</head>
<body>
<h2> Respond to initial quote</h2>
    <%
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String submittedQuote = request.getParameter("description");

        String initialName = request.getParameter("initialName");
        String initialEmail = request.getParameter("initialEmail");
        String initialPhone = request.getParameter("initialPhone");
        String initialQuote = request.getParameter("initialQuote");

        try {
            
            String jdbcUrlQuote = "jdbc:mysql://127.0.0.1:3306/quotes";
            String dbUserQuote = "john";
            String dbPasswordQuote = "john1234";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connectionQuote = DriverManager.getConnection(jdbcUrlQuote, dbUserQuote, dbPasswordQuote);

            String insertQuoteQuery = "INSERT INTO quotes (name, email, phone, quote_request) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatementQuote = connectionQuote.prepareStatement(insertQuoteQuery)) {
                preparedStatementQuote.setString(1, name != null ? name : "");
                preparedStatementQuote.setString(2, email != null ? email : "");
                preparedStatementQuote.setString(3, phone != null ? phone : "");
                preparedStatementQuote.setString(4, submittedQuote != null ? submittedQuote : "");

                preparedStatementQuote.executeUpdate();
            }

            connectionQuote.close();

         
            String jdbcUrlSmith = "jdbc:mysql://127.0.0.1:3306/davidsmith";
            String dbUserSmith = "john";
            String dbPasswordSmith = "john1234";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connectionSmith = DriverManager.getConnection(jdbcUrlSmith, dbUserSmith, dbPasswordSmith);

            String insertSmithQuery = "INSERT INTO davidsmith (name, email, phone, quote_request) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatementSmith = connectionSmith.prepareStatement(insertSmithQuery)) {
                preparedStatementSmith.setString(1, initialName != null ? initialName : "");
                preparedStatementSmith.setString(2, initialEmail != null ? initialEmail : "");
                preparedStatementSmith.setString(3, initialPhone != null ? initialPhone : "");
                preparedStatementSmith.setString(4, initialQuote != null ? initialQuote : "");

                preparedStatementSmith.executeUpdate();
            }

            connectionSmith.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    %>

    <h2>Response Status for <%= email %>:</h2>

    <form action="submitted.jsp" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required value="<%= (name != null) ? name : "" %>"><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required value="<%= (email != null) ? email : "" %>"><br>
        <label for="phone">Phone:</label>
        <input type="tel" id="phone" name="phone" value="<%= (phone != null) ? phone : "" %>"><br>
        <label for="description">Quote Request:</label>
        <textarea id="description" name="description" required><%= (submittedQuote != null) ? submittedQuote : "" %></textarea><br>
        <input type="submit" value="Submit response">
    </form>
    <h2>Submit initial quote request</h2>
      <button class="big-button" onclick="location.href='form1.jsp';">Submit Quote Request</button>

    <div>
        <a href="login.jsp" target="_self" class="link">Login</a>
    </div>
    <div>
        <a href="register.jsp" target="_self" class="link">Register</a>
    </div>
        <a
href="login.jsp" target="_self" class="link">Login</a>
<div>
<a href="register.jsp" target="_self" class="link">Register</a>
</div>

</body>
</html>







