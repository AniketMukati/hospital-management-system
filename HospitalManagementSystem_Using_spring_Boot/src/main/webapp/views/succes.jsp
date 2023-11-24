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
<h3>patient is inserted succesfully </h3><br>

    <div>
        <label for="id">Patient name :</label>  :  ${patient.name}
     
    </div>	
	

	
	
		
		
		<table table border = "1">
  <tr>
    <th>Patient_ID :</th>
    <th>Patient_name:</th>
	<th>Patient_email:</th>
	<th>Patient_disease:</th>
	<th>Patient_address:</th>
	<td> patient_addmitted_Date:  </td>
	<th>Patient_number:</th>
	<th>treatment_doctor_Id:</th>
  </tr>
  <tr>
    <td> ${patient.id}  </td>
    <td> ${patient.name}  </td>
    <td> ${patient.email}  </td>
    <td> ${patient.disease}  </td>
    <td> ${patient.address}  </td>
	<td> ${patient.addmitted_Date}  </td>
    <td> ${patient.number}  </td>
    <td> ${patient.doctor}  </td>
	
  </tr>
</table> <br>
	
	<p>
	<hr>
	</p>
    <td>  <a href="showpatientdetails"> Home_page</a>  </td><br>

	<p>
	<hr>
	</p>		
		<strong>Current Time is</strong>: <%=new Date() %>

		
	<!--	
			<%!   
	//	
		String patiet_name; 
		String email; 
		String disease;
		
		%>
	
	<%   		
	
				out.println("check ok");
		out.println(request.getParameter("name"));
		out.println(request.getParameter("email"));
		
		patiet_name = request.getParameter("name");
		email = request.getParameter("email");
		disease = request.getParameter("disease");
				
	%>
<div>	
name    :	<%=patiet_name %> <br>
email   :	<%= email%> <br>
disease :	<%=disease %> <br>
</div>
	-->
	



Today's date: <%= (new java.util.Date()).toLocaleString()%>
</body>


</body>
</html>