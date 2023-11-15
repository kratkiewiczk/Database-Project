<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <button type="submit" name="submit" value="respond">View responses of clients to your initial quote response </button>
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
            String[][] tableData = {
                {"1", "Requesting a quote for a tree", "68640036", "don@gmail.com"},
                {"10", "Tree removal in residential area", "90773260", "angelo@gmail.com"},
                {"11", "Help with tree removal", "40893246", "rudy@gmail.com"},
                {"12", "We are not allowed to do work in your area right now", "90773260", "david@gmail.com"},
                {"13", "We cannot work in your area at the moment", "40893246", "david@gmail.com"},
                {"2", "I would like a quote for my tree", "22568850", "margarita@gmail.com"},
                {"3", "Price should be lower, around 400", "22568850", "margarita@gmail.com"},
                {"4", "We can allow that", "22568850", "david@gmail.com"},
                {"5", "Requesting a quote for multiple trees to be cut down", "88402860", "jo@gmail.com"},
                {"6", "Need some very tall trees removed", "18996146", "wallace@gmail.com"},
                {"7", "Need a tree removed", "96922139", "jog@gmail.com"},
                {"8", "Would like some help with this tree", "85329432", "amelia@gmail.com"},
                {"9", "Tree removal around buildings", "74311516", "sophie@gmail.com"}
            };

            for (String[] row : tableData) {
                String initialQuoteResponse = (String) session.getAttribute("initialQuoteResponse_" + row[2]);
        %>
            <tr>
                <td><%= row[0] %></td>
                <td><%= row[1] %></td>
                <td><%= row[2] %></td>
                <td><%= row[3] %></td>
                <td>
                    <form action="InitialQuote.jsp" method="post">
                        <input type="hidden" name="quoteId" value="<%= row[2] %>">
                        <input type="hidden" name="email" value="<%= row[3] %>">
                        <button type="submit" name="submit" value="respond">Submit initial quote to client</button>
                    </form>
                </td>
                <td>
                    <p><%= (initialQuoteResponse != null) ? initialQuoteResponse : "" %></p>
                </td>
            </tr>
        <%
        }
        %>
        
   
        <c:if test="${not empty submittedQuote}">
            <tr>
                <td>Generated ID</td>
                <td>${generatedId}</td>
                <td>${submittedQuote}</td>
                <td>${email}</td>
            </tr>
        </c:if>
    </table>


</body>
</html>





