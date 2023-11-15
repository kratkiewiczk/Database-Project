<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Submit your quote request</title>
</head>
<body>
    <h2>Submit your quote request</h2>

    <%
        String initialName = request.getParameter("initialName");
        String initialEmail = request.getParameter("initialEmail");
        String initialPhone = request.getParameter("initialPhone");
        String initialQuote = request.getParameter("initialQuote");

        try {
            String jdbcUrlSmith = "jdbc:mysql://127.0.0.1:3306/davidsmith";
            String dbUserSmith = "john";
            String dbPasswordSmith = "john1234";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connectionSmith = DriverManager.getConnection(jdbcUrlSmith, dbUserSmith, dbPasswordSmith);

            String insertSmithQuery = "INSERT INTO davidsmith (name, email, phone, submittedQuote) VALUES (?, ?, ?, ?)";
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

    <h2>Response Status for <%= initialEmail %>:</h2>

    <form action="submitted.jsp" method="post">
        <label for="initialName">Name:</label>
        <input type="text" id="initialName" name="initialName" required value="<%= (initialName != null) ? initialName : "" %>"><br>
        <label for="initialEmail">Email:</label>
        <input type="email" id="initialEmail" name="initialEmail" required value="<%= (initialEmail != null) ? initialEmail : "" %>"><br>
        <label for="initialPhone">Phone:</label>
        <input type="tel" id="initialPhone" name="initialPhone" required value="<%= (initialPhone != null) ? initialPhone : "" %>"><br>
        <label for="initialQuote">Quote Request:</label>
        <textarea id="initialQuote" name="initialQuote" required><%= (initialQuote != null) ? initialQuote : "" %></textarea><br>
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

