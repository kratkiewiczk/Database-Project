<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
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
    <table border="1">
        <tr>
            <th>MessageID</th>
            <th>Note</th>
            <th>Associated QuoteID</th>
            <th>Email</th>
            <th>Actions </th>
        </tr>

        <%
            String[][] tableData = {
                {"1", "Requesting a quote for a tree", "68640036", "don@gmail.com"},
                {"2", "Tree removal in residential area", "90773260", "angelo@gmail.com"},
                {"3", "Help with tree removal", "40893246", "rudy@gmail.com"},
                {"4", "We are not allowed to do work in your area right now", "90773260", "david@gmail.com"},
                {"5", "We cannot work in your area at the moment", "40893246", "david@gmail.com"},
                {"6", "I would like a quote for my tree", "22568850", "margarita@gmail.com"},
                {"7", "Price should be lower, around 400", "22568850", "margarita@gmail.com"},
                {"8", "We can allow that", "22568850", "david@gmail.com"},
                {"9", "Requesting a quote for multiple trees to be cut down", "88402860", "jo@gmail.com"},
                {"10", "Need some very tall trees removed", "18996146", "wallace@gmail.com"},
                {"11", "Need a tree removed", "96922139", "jog@gmail.com"},
                {"12", "Would like some help with this tree", "85329432", "amelia@gmail.com"},
                {"13", "Tree removal around buildings", "74311516", "sophie@gmail.com"}
            };

            for (String[] data : tableData) {
        %>

        <tr>
            <td><%= data[0] %></td>
            <td><%= data[1] %></td>
            <td><%= data[2] %></td>
            <td><%= data[3] %></td>
            <td>
                <form action="initialquoteresponse.jsp" method="post">
                    <input type="hidden" name="email" value="<%= data[3] %>">
                    <button type="submit" name="responseStatus" value="respond">Respond</button>
                </form>
            </td>
        </tr>

        <%
            }
        %>
    </table>

</body>
</html>






