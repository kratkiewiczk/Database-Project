<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Respond to Initial Quote</title>
</head>
<body>
    <h1>Respond to Initial Quote</h1>
    
    <%
        String responseText = request.getParameter("responseText");
        if (responseText == null) {
    %>
    <form action="" method="post">
        <label for="responseText">Enter your response:</label>
        <br>
        <textarea id="responseText" name="responseText" rows="4" cols="50" placeholder="Enter your response here"></textarea>
        <br>
        <input type="submit" value="Submit" class="button">
    </form>
    <%
        } else {
    %>
        <p>Response Submitted: <%= responseText %></p>
    <%
        }
    %>
</body>
</html>



