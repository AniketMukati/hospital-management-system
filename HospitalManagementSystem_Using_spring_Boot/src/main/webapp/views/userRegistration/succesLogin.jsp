<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">

	<%@ page import="com.springSecurity.entity.Patient" %>

	<%@ page import="com.springSecurity.payload.User" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>succesfully</title>
</head>
<%@ page import="java.util.Date" %>
<body>
<h3>registration is succesfull ! </h3><br>
				
		<table table border = "1">
  <tr>
    <th>your_ID :</th>
    <th>name  :</th>
	<th>username_email:</th>
	<th>password :</th>
  </tr>
  <tr>
    <td> ${user.id}  </td>
    <td> ${user.name}  </td>
    <td> ${user.email}  </td>
    <td> ${user.password}  </td>	
  </tr>
</table> <br>
	
	<p>
	<hr>
	</p>
      <a href="/home/showpatientdetails"> Home_page</a>  <br>

	<p>
	<hr>
	</p>		
		<strong>Current Time is</strong>: <%=new Date() %>

	



Today's date: <%= (new java.util.Date()).toLocaleString()%>
</body>


</body>
</html>