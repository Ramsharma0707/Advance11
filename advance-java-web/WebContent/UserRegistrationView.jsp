<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
</style>

</head>

<body>
	<form action="UserRegistrationCtl" method="post">


		<table align="center">
			<h1 align="center">User Registration</h1>


			<tr>
				<th>FirstName:</th>
				<td><input type="text" name=firstName placeholder=" "></td>

			</tr>

			<tr>
				<th>LastName:</th>
				<td><input type="text" name=lastName></td>

			</tr>
			<tr>
				<th>Login Id</th>
				<td><input type="text" name=loginId></td>

			</tr>
			<tr>
				<th>Password</th>
				<td><input type="text" name=password></td>

			</tr>
			<tr>
				<th>Dob</th>
				<td><input type="date" name=dob></td>

			</tr>
			<tr>
				<th>Address</th>
				<td><input type="text" name=address></td>

			</tr>
			<tr>
				<th></th>
				<td><input type="Submit"></td>

			</tr>


		</table>




	</form>




</body>
</html>