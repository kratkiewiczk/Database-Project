<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Number of Trees</title>
</head>
<body>
    <h1>Editing Quote #<%= request.getParameter("quoteID") %> Information</h1>

    <form action="edit" method="post">
        <div align="center">
        <table border="1" cellpadding="6">
            <caption><h2>Quotes</h2></caption>
            <tr>
                <th>QuoteID</th>
                <th>Price</th>
                <th>Time Window</th>
            </tr>
                <tr style="text-align:center">
                    <td><%= request.getParameter("quoteID") %></td>
                    <td><input type="text" name="price" value="0000.00" onfocus="this.value=''"></td>
                    <td><input type="text" name="timeWindow" value="Month 00, 0000" onfocus="this.value=''"></td>
        </table>
              
        <button type="submit" name="submit" value="respond">Confirm Edits</button> 
        </div>
    </form>
</body>
</html>


