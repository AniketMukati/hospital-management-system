<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">

	<%@ page import="com.springSecurity.entity.Patient" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>succesfully</title>
</head>
<%@ page import="java.util.Date" %>
<body>
<h3>patient is succesfully  deleted</h3><br>

		
			
	
	<%   
		
	Patient patient = (Patient) request.getAttribute("patient");
	
	
//				out.println("check ok");
//		out.println(request.getParameter("name"));
//		out.println(request.getParameter("email"));
//		
//		patiet_name = request.getParameter("name");
//	email = request.getParameter("email");
//		disease = request.getParameter("disease");
				
	%>
<div>
Id    :	<%= patient.Id %> <br>

name    :	<%= patient.name %> <br>
email   :	<%= patient.email%> <br>
disease :	<%= patient.disease %> <br>
</div>
	
	
<strong>Current Time is</strong>: <%=new Date() %>



Today's date: <%= (new java.util.Date()).toLocaleString()%>
</body>


</body>
</html>