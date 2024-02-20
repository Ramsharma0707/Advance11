<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<body>
	<jsp:useBean id="bean" class="in.co.rays.bean.UserBean" scope="request"></jsp:useBean>
	<%
		List list = (List) request.getAttribute("list");
		Iterator it = list.iterator();

		int pageNo = (int) request.getAttribute("pageNo");
		int index = ((pageNo - 1) * 5) + 1;

		List nextList = (List) request.getAttribute("nextList");
	%>
	<%@ include file="Header.jsp"%>
	<form action="UserListCtl.do" method="post">
		<table>
			<tr>
				<td><input type="text" name="firstName">
				<td><input type="date" name="dob">
				<td><input type="submit" name="operation" value="search"></td>
				<td><input type="submit" name="operation" value="delete"></td>
			</tr>
		</table>
		<table border="1">
			<tr>
				<th>Select</th>
				<th>S No.</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>LoginId</th>
				<th>Password</th>
				<th>DOB</th>
				<th>Address</th>
				<th>Edit</th>
			</tr>
			<%
				while (it.hasNext()) {
					bean = (UserBean) it.next();
			%>
			<tr>
				<td><input type="checkbox" name="ids" value="<%=bean.getId()%>"></td>
				<td><%=index++%></td>
				<td><%=bean.getFirstName()%></td>
				<td><%=bean.getLasName()%></td>
				<td><%=bean.getLoginId()%></td>
				<td><%=bean.getPassword()%></td>
				<td><%=bean.getDob()%></td>
				<td><%=bean.getAddress()%></td>
				<td><a href="UserCtl.do?id=<%=bean.getId()%>">edit</a></td>
			</tr>
			<%
				}
			%>
		</table>
		<table>
			<tr>
				<td><input type="submit" name="operation" value="previous"
					<%=(pageNo != 1) ? "" : "disabled"%>>
				<td><input type="submit" name="operation" value="next"
					<%=(nextList.size() != 0) ? "" : "disabled"%>></td>
			</tr>
		</table>
		 <input type="hidden" name="pageNo" value="<%=pageNo%>"> 

	</form>

</body>
</html>