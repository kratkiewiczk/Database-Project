<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Send a message</title>
</head>
<body>
    <h2>Send a message</h2>

    <form action="submit" method="post">
        <textarea name="message" rows="4" cols="50" maxlength="200" placeholder="Enter a message (200 character limit)"></textarea>
        <br>
        <button type="submit" name="submit" value="respond">Submit response</button>
    </form>
    
    <% 
        String initialQuoteResponse = request.getParameter("initialQuoteResponse");
        String quoteId = request.getParameter("quoteId");

        if (quoteId != null && !quoteId.isEmpty() && initialQuoteResponse != null && !initialQuoteResponse.isEmpty()) {
            session.setAttribute("initialQuoteResponse_" + quoteId, initialQuoteResponse);
        }
    %>
</body>
</html>


