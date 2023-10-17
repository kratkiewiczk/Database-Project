<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head><title>Registration</title></head>
<body>
	<div align="center">
		<p>${errorOne }</p>
		<p>${errorTwo }</p>
		<form action="register">
			<table border="1" cellpadding="5">
				<tr>
					<th>Username: </th>
					<td align="center" colspan="3">
						<input type="text" name="email" size="45" value="example@gmail.com" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>First Name: </th>
					<td align="center" colspan="3">
						<input type="text" name="firstName" size="45" value="FirstName" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Last Name: </th>
					<td align="center" colspan="3">
						<input type="text" name="lastName" size="45" value="LastName" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Address: </th>
					<td align="center" colspan="3">
						<input type="text" name="birthday" size="45" value="YYYY-MM-DD" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Credit Card: </th>
					<td align="center" colspan="3">
						<input type="text" name="creditCard" size="45" value="Credit Card Number" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Phone Number: </th>
					<td align="center" colspan="3">
						<input type="text" name="phoneNumber" size="45" value="Phone Number" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Role: </th>
					<td align="center" colspan="3">
						<input type="text" name="role" size="45" value="User Role" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Password: </th>
					<td align="center" colspan="3">
						<input type="password" name="password" size="45" value="password" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Password Confirmation: </th>
					<td align="center" colspan="3">
						<input type="password" name="confirmation" size="45" value="password" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<td align="center" colspan="5">
						<input type="submit" value="Register"/>
					</td>
				</tr>
			</table>
			<a href="login.jsp" target="_self">Return to Login Page</a>
		</form>
	</div>
</body>

