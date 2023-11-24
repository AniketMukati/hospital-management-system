<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
	
	<%@ page import="java.util.Date" %>

	<%@ page import="com.springSecurity.entity.Patient" %>
	<%@ page import="com.springSecurity.entity.Doctor" %>

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
	
	<div >
			    <td>  <a href="insertpatient"> Insert_Patient</a>  </td>
    </div><br>
	
	
	<div >
			    <td>  <a href="registeredUser"> registered user</a>  </td>
    </div>

	    <td>  <a href="findPatient"> find_Patient </a>  </td>

	
<h3> Patient details</h3><br>
	
<strong>Current Time is</strong>: <%=new Date() %>	
	
	<%
		ArrayList<Patient> patientList = new ArrayList();
	
		patientList = (ArrayList ) request.getAttribute("patientList");
		
	%>
	
	
	
<table table border = "1" >
  <tr>
    <th>Patient_ID</th>
    <th>Patient_name</th>
	<th>Patient_email</th>
	<th>Patient_disease</th>
	
	<th>Patient_addmitted_Date</th>
	<th>Patient_address</th>
	<th>Patient_number</th>
	<th>treatment_doctor</th>
	<th> Edit Operation: </th>

  </tr>
	
		<%  for(Patient patient: patientList) { %>

	<tr>
			
    <td> <%=patient.Id %> </td>
    <td> <%=patient.name %> </td>
    <td> <%=patient.email %> </td>
    <td> <%=patient.disease %> </td>
    <td> <%=patient.addmitted_Date %> </td>
    <td> <%=patient.address %> </td>
    <td> <%=patient.number %> </td>
    <td>id : <%=patient.doctor.getId() %><br>
		Name : <%=patient.doctor.getName() %>
    </td>
	
    <td>  <a href="/deletepatient/<%=patient.Id %>"  > delete_patient</a>  </td>

  </tr>  
  
  <%}%>
</table>
	

<p>
	
	
	
	</p><br>
	
	<hr>
  <a href="/logout"  > logout</a>  </td> <br>
	
	
	




</body>


</body>
</html>