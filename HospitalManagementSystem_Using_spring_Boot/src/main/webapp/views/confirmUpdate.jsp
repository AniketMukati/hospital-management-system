<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">

	<%@ page import="com.springSecurity.entity.Patient" %>
<%@page import="com.springSecurity.entity.Doctor" %>
<%@page import="java.util.ArrayList" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>update</title>
</head>
<%@ page import="java.util.Date" %>
<body>
<h3>plz! update the values </h3><br>
	
	
	<% 
		Patient  patient = (Patient) request.getAttribute("patient");
		
		%>
	
<form action="afterUpdate" method="post">
    <h2></h2>

	<div>
        <label for="Id"> <!--Patient id : --></label>
        <input type="hidden" id="id" name="Id" value="${patient.id}" required/>
    </div>
	
	
	<div>
        <label for="name">Patient name :</label>
        <input type="name" id="name" name="name" value=${patient.name} required/>
    </div>
    <div>
        <label for="email">email:</label>
        <input type="email" id="name" name="email" value=${patient.email} required/>
    </div>
	
	    <div>
        <label for="disease">disease:</label>
        <input type="text" id="name" name="disease" value=${patient.disease} required/>
    </div>

	
	<div>
        <label for="date">date:</label>
        <input type="date" id="date" name="addmitted_Date" value=${patient.addmitted_Date} required/>
    </div>
	
	    <div>
        <label for="address">address:</label>
        <input type="address" id="address" name="address" value=${patient.address} required/>
    </div>
	
	
    <div>
        <label for="number"> Number:</label>
        <input type="Number" id="Number" name="Number" value="${patient.number}"  required/>
    </div>
	
	
	
	<%
		ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
	
		doctorList = (ArrayList) request.getAttribute("doctorList");
		
	%>

	
	
	    <div>
			
        <label for="doctor">select Doctor:</label>
	
	<select name="doctor"  placeholder = "select" type="Doctor">
	<%  for(Doctor doctor: doctorList) { %>

	   <option name="check" type="Doctor" > <% Doctor doctorVar = doctor;   %>   <%=   doctor.Id %> </option>
	  <% } %>
	</select>
		</div>
		
		
				
    <div>
        <input type="submit" value="Login"/>
    </div>
</form>
	
	
	
Today's date: <%= (new java.util.Date()).toLocaleString()%>
</body>


</body>
</html>