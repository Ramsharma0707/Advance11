<%@page errorPage="Error.jsp" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<%@include file="Header.jsp"%>
	<form action="UserListCtl.do" method="post">				

		<tr>
			<td><input type="text" name="firstName"></td>

			<td><input type="date" name="dob"></td>

			<td><input type="submit" name="operation" value="search">
			
			<td><input type="submit" name="operation" value="delete"> 
			
			</td>
		</tr>

		<br>



		<%
			List list = (List) request.getAttribute("List");
			
		    int pageNo = (int) request.getAttribute("pageNo");
		
		    int index = ((pageNo - 1) * 5) + 1; 
			
		

			List nextList = (List) request.getAttribute("nextList");//

			Iterator it = list.iterator();
		%>






		<table border="1">
			<tr>
				<th>Select</th>
				<th>S.No</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>LoginId</th>
				<th>Password</th>
				<th>Dob</th>
				<th>Address</th>
				<th>Edit</th>


			</tr>
			<%
				while (it.hasNext()) {
					UserBean bean = (UserBean) it.next();
			%>

			<tr>
				<td><input type="checkbox" name="ids" value=<%=bean.getId() %>></td>

				<td><%=index++ %></td>				
				
				<td><%=bean.getFirstName()%></td>
				<td><%=bean.getLasName()%></td>
				<td><%=bean.getLoginId()%></td>
				<td><%=bean.getPassword()%></td>
				<td><%=bean.getDob()%></td>
				<td><%=bean.getAddress()%></td>

				<td><a href="UserCtl.do?id=<%=bean.getId()%>">edit</a></td>


				<%
					}
				%>

			</tr>

		</table>

		<table>
			<tr>


				<td><input type="submit" name="operation" value="previous"
					<%=(pageNo != 1) ? "" : "disabled"%>></td>


				<td><input type="submit" name="operation" value="next"
					<%=(nextList.size() != 0) ? "" : "disabled"%>></td>



			</tr>


		</table>
		<input type="hidden" name="pageNo" value=<%="pageNo"%>>


	</form>


</body>
</html>