<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Database Login</title>
</head>
<body>
 <center>	<h1> Request a quote by logging in </h1> </center>
	<div align="center">
		<p> ${loginFailedStr} </p>
		<form action="login" method="post">
			<table border="1" cellpadding="5">
				<tr>
					<th>Username: </th>
					<td>
						<input type="text" name="email" size="45" autofocus>
					</td>
				</tr>
				<tr>
					<th>Password: </th>
					<td> 
						<input type="password" name="password" size="45">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="Login"/>
					</td>
				</tr>
			</table>
			<div>
			<a href="register.jsp" target="_self" class="link">Registration</a>
			</div>
			<div>
			<a href="DavidSmith.jsp" target="_self" class="link">David Smith</a>
			</div>
			<div>
			<a href="form.jsp" target="_self" class="link">Request a quote</a>
			</div>
		</form>
	</div>
</body>
</html>