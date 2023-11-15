<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Client Responses</title>
</head>
<body>
    <h1>Client Responses</h1>
    
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Quote Request</th>
            <th>Actions</th>
        </tr>

        <%
            try {
                String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/quotes";
                String dbUser = "john";
                String dbPassword = "john1234";

                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);

                String selectQuery = "SELECT * FROM quotes";
                try (Statement statement = connection.createStatement()) {
                    ResultSet resultSet = statement.executeQuery(selectQuery);
                    while (resultSet.next()) {
                        String name = resultSet.getString("name");
                        String email = resultSet.getString("email");
                        String phone = resultSet.getString("phone");
                        String quoteRequest = resultSet.getString("quote_request");

                       
                        System.out.println("Name from database: " + name);
                        System.out.println("Email from database: " + email);
                        System.out.println("Phone from database: " + phone);
                        System.out.println("Quote Request from database: " + quoteRequest);
        %>
                        <tr>
                            <td><%= (name != null) ? name : "" %></td>
                            <td><%= (email != null) ? email : "" %></td>
                            <td><%= (phone != null) ? phone : "" %></td>
                            <td><%= (quoteRequest != null) ? quoteRequest : "" %></td>
                            <td>
                                <form action="submitted.jsp" method="post">
                                    <input type="hidden" name="email" value="<%= email %>">
                                    <button type="submit" name="responseStatus" value="accepted">Accept</button>
                                </form>
                                <form action="submitted.jsp" method="post">
                                    <input type="hidden" name="email" value="<%= email %>">
                                    <button type="submit" name="responseStatus" value="denied">Deny</button>
                                </form>
                            </td>
                        </tr>
        <%
                    }
                }

                connection.close();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        %>
    </table>

    <a href="login.jsp" target="_self">Return to Login Page</a>
    <div>
        <a href="DavidSmith.jsp" target="_self">David Smith</a><br><br> 
    </div>

</body>
</html>












