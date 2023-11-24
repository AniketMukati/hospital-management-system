<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
	
	<%@ page import="java.util.Date" %>

	<%@ page import="com.springSecurity.payload.User" %>


<%@ page import="java.util.ArrayList" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
<style>

</style>
	
	
	
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>First JSP</title>
</head>
<%@ page import="java.util.Date" %>
<body>
	


	
<h3> User details</h3><br>
	
<strong>Current Time is</strong>: <%=new Date() %>	
	
	<%
		ArrayList<User> userList = new ArrayList();
	
		userList = (ArrayList ) request.getAttribute("userList");
		out.println(userList);
	%>
	
	
<table table border = "1" >
  <tr>
    <th>your_ID :</th>
    <th>name  :</th>
	<th>username_email:</th>
	<th>password :</th>
  </tr>
	
	<%  for(User user : userList) { %>
<tr>
    <td> <%= user.getId() %> </td>
    <td> <%= user.getName() %> </td>
    <td> <%= user.getEmail() %> </td>
    <td> <%= user.getPassword() %> </td>
</tr>
<% } %>

</table>
	

<p>
	
	
	
	</p><br>
	
	<hr>
	
	
	




</body>


</body>
</html>