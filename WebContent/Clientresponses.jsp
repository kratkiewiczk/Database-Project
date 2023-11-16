<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                String[][] hardcodedData = {
                    {"Don", "don@gmail.com", "68640036", "Requesting a quote for a tree"},
                    {"Angelo", "angelo@gmail.com", "90773260", "Tree removal in residential area"},
                    {"Rudy", "rudy@gmail.com", "40893246", "Help with tree removal"},
                    {"David", "david@gmail.com", "90773260", "We are not allowed to do work in your area right now"},
                    {"David", "david@gmail.com", "40893246", "We cannot work in your area at the moment"},
                    {"Margarita", "margarita@gmail.com", "22568850", "I would like a quote for my tree"},
                    {"Margarita", "margarita@gmail.com", "22568850", "Price should be lower, around 400"},
                    {"David", "david@gmail.com", "22568850", "We can allow that"},
                    {"Jo", "jo@gmail.com", "88402860", "Requesting a quote for multiple trees to be cut down"},
                    {"Wallace", "wallace@gmail.com", "18996146", "Need some very tall trees removed"},
                    {"Jog", "jog@gmail.com", "96922139", "Need a tree removed"},
                    {"Jog", "jog@gmail.com", "96922139", "Need a tree removed"},
                    {"Sophie", "sophie@gmail.com", "74311516", "Tree removal around buildings"}
                };

                for (String[] data : hardcodedData) {
                    String name = data[0];
                    String email = data[1];
                    String phone = data[2];
                    String quoteRequest = data[3];
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
            %>
    </table>

    <a href="login.jsp" target="_self">Return to Login Page</a>
    <div>
        <a href="DavidSmith.jsp" target="_self">David Smith</a><br><br> 
    </div>

</body>
</html>














