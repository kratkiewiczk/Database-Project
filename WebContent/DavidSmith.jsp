<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.sql.*, java.util.List, java.util.ArrayList" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>David Smith Registration</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            text-align: left;
            padding: 8px;
            border-bottom: 1px solid #ddd;
        }
    </style>
</head>
<body>
    <center>
        <h1>Welcome David Smith!</h1>
    </center>
    <center>
        <h1>You have been successfully logged in.</h1>
    </center>
    <div>
        <center>
            <a href="login.jsp" target="_self">Logout</a>
        </center>
    </div>
    <div></div>
    <hr>
    <form action="Clientresponses.jsp" method="post">
        <button type="submit" name="submit" value="respond">View responses of clients to your initial quote response</button>
    </form>
    <h1>Tree Removal Requests</h1>
    <table>
        <tr>
            <th>MessageID</th>
            <th>Note</th>
            <th>Associated QuoteID</th>
            <th>Email</th>
            <th>Actions </th>
        </tr>


        <%
    


       
        %>
    <%
        try {
      
            String jdbcUrlSmith = "jdbc:mysql://127.0.0.1:3306/davidsmith";
            String dbUserSmith = "john";
            String dbPasswordSmith = "john1234";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connectionSmith = DriverManager.getConnection(jdbcUrlSmith, dbUserSmith, dbPasswordSmith);

  
            String selectSmithQuery = "SELECT * FROM davidsmith";
            try (Statement statement = connectionSmith.createStatement();
                 ResultSet resultSet = statement.executeQuery(selectSmithQuery)) {

                out.println("<table border='1'>");
                out.println("<tr><th>Name</th><th>Email</th><th>Phone</th><th>Quote Request</th></tr>");

                while (resultSet.next()) {
                    out.println("<tr>");
                    out.println("<td>" + resultSet.getString("name") + "</td>");
                    out.println("<td>" + resultSet.getString("email") + "</td>");
                    out.println("<td>" + resultSet.getString("phone") + "</td>");
                    out.println("<td>" + resultSet.getString("submittedQuote") + "</td>");
                    out.println("</tr>");
                }

                out.println("</table>");
            }

            connectionSmith.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    %>

</body>
</html>
     
        <%
            try {
                InitialContext context = new InitialContext();
                DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mysql");

                try (Connection connection = dataSource.getConnection()) {
                    String selectQuery = "SELECT * FROM davidsmith";
                    try (Statement statement = connection.createStatement();
                         ResultSet resultSet = statement.executeQuery(selectQuery)) {

                        while (resultSet.next()) {
        %>
                            <tr>
                              
                                <td><%= resultSet.getString("name") %></td>
                                <td><%= resultSet.getString("email") %></td>
                                <td><%= resultSet.getString("phone") %></td>
                                <td><%= resultSet.getString("submittedQuote") %></td>
                            </tr>
        <%
                        }
                    }
                }
            } catch (SQLException | NamingException e) {
                e.printStackTrace();
            }
        %>
    </table>
</body>
</html>





