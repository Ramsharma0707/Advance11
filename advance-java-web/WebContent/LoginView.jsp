<%@ page errorPage="Error.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@include file="Header.jsp" %>
	<form action="LoginCtl" method="post">
	
	<%
		String msg = (String) request.getAttribute("msg");
	
	   String uri	= (String)request.getAttribute("uri");//
	%>

	<%
		if (msg != null) {
	%>
	<%=msg %>


	<%
		}
	%>
		<table>
			<tr>
				<th>LoginID :</th>
				<td><input type="text" name="loginId"></td>

			</tr>
			<tr>
				<th>Password :</th>
				<td><input type="text" name="password"></td>

			</tr>
			<tr>
				<th></th>
				<td><input type="Submit"></td>

			</tr>

		</table>
		<input type="hidden" name="uri" value="<%=uri %>">
	</form>
</body>
</html>
<%@include file="Footer.jsp" %>