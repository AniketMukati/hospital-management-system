<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">

	<%@ page import="com.springSecurity.entity.Patient" %>
<%@page import="com.springSecurity.entity.Doctor" %>
<%@page import="java.util.ArrayList" %>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>succesfully</title>
</head>
<%@ page import="java.util.Date" %>
<body>
<h3>patient is updated succesfully </h3><br>

	
	
	<%   
		
				Patient patient = (Patient) request.getAttribute("patient");
		
		%>
	
	
<div>	
name    :	<%= patient.name %> <br>
email   :	<%= patient.email%> <br>
disease :	<%= patient.disease %> <br>
</div>
	
	
<strong>Current Time is</strong>: <%=new Date() %>



Today's date: <%= (new java.util.Date()).toLocaleString()%>
</body>


</body>
</html>