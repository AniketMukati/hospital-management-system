<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">

	<%@ page import="com.springSecurity.entity.Patient" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>delete JSP</title>
</head>
<%@ page import="java.util.Date" %>
<body>
<h2> </h1><br>


<h3> plz! Confirm the Patient : </h3>

<form action="/home/deletesucces" method="post">
    <h2> patient Details </h2>
    <div>
        <label for="id">Patient name :</label>  :  ${patient.name}
     
    </div>
	
<table border="2" >
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
</table>



<%	
	
	Patient patient= (Patient) request.getAttribute("patient"); 

	out.println(patient);
	
//	request.setAttribute("patient", patient);

	
//	Patient patient= request.getAttribute("patient"); 
//	session.setAttribute("patient_sessi", patient);


	session.setAttribute("patient",patient); 

	
	%>
		
	
	<div>
        <input type="submit" value="delete"/>
    </div>
	
	
		<p>
		<hr>
		</p>
	
     <a href="/home/showpatientdetails"> Home_page</a>
	
	
	
	
</form>
</body>


</body>
</html>