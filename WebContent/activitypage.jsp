<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Activity page</title>
</head>
<body>
    <center><h1>Welcome! You have been successfully logged in</h1></center>
 
    <center>
        <a href="login.jsp" target="_self">logout</a><br><br> 
        <p>You can show all the transactions or other attributes here like balance, name of the user, and others.</p>
    </center>

    <div>
        <form action="form.jsp" method="post">
            <input type="submit" value="Request a quote" class="button">
        </form>
    </div>
    
    <form action="initialquoteresponse.jsp" method="post">
        <input type="submit" value="View initial quote response" class="button">
    </form>
</body>
</html>
