<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Client Responses</title>
</head>
<body>
    <h1>Client Responses</h1>
    
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>Phone Number</th>
            <th>Actions</th>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td>
                <form action="form.jsp" method="post">
                    <input type="hidden" name="responseStatus" value="accepted">
                    <button type="submit" name="submit" value="accept">Accept</button>
                </form>
                <form action="form.jsp" method="post">
                    <input type="hidden" name="responseStatus" value="quit">
                    <button type="submit" name="submit" value="Decline/quit">Decline/Quit</button>
                </form>
            </td>
        </tr>
    </table>
</body>
</html>



