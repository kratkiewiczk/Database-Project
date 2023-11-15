<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Submit Initial Quote Request to Client</title>
</head>
<body>
    <h2>Submit Initial Quote Request to Client</h2>

    <%
        String email = request.getParameter("email");
      
        session.setAttribute("initialQuoteEmail", email);
    %>

    <form action="submitted.jsp" method="post">
        <p>Email: <%= email %></p>
        <p>Please enter your initial quote:</p>
        <textarea name="initialQuote" rows="4" cols="50"></textarea>
        <br>
        <button type="submit" name="submit" value="respond">Submit Initial Quote to Client</button>
    </form>
</body>
</html>







