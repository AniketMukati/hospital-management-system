<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">

	<%@ page import="com.springSecurity.entity.Patient" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>single patient </title>
</head>
<%@ page import="java.util.Date" %>
<body>
<h2> </h1><br>


    <h2> patient Details </h2>
	
<table border="2">
  <tr>
    <th>Patient_ID :</th>
    <th>Patient_name:</th>
	<th>Patient_email:</th>
	<th>Patient_disease:</th>
	<th>Patient_address:</th>
	<td> patient_addmitted_Date:  </td>
	<th>Patient_number:</th>
	<th>treatment_doctor_Id:</th>
	<th>Edit:</th>
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
    <td>  <a href="/deletepatient/${patient.id}"  > delete_patient</a>  </td>
    <td>  <a href="loginpageuser"> login_page_user</a>  </td>
 	
  </tr>
</table><br>

	
	<p>
		<hr>
		</p>



	
    <td>  <a href="showpatientdetails"> Home_page</a>  </td>
	

	<!--
	<% 
		Patient patient = (Patient) request.getAttribute("patient");
		
		out.println(patient);
	session.setAttribute("patient_sessi",patient);  
//		request.setAttribute("patient_sessi", patient);
		%>
	
-->
</body>


</body>
</html>