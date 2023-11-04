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
                <p>Client's Initial Quote Request</p>
                <button type="button" onclick="updateStatus('accepted')">Accept</button>
                <button type="button" onclick="updateStatus('Quit')">Quit</button>
            </td>
        </tr>
    </table>

    <script>
        function updateStatus(status) {
            var statusCell = document.querySelector("td p");
            statusCell.innerHTML = "Client's Initial Quote Request - " + status.charAt(0).toUpperCase() + status.slice(1);
        }
    </script>
</body>
</html>

