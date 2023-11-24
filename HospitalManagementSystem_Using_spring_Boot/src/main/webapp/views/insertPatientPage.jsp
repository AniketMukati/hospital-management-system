<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.springSecurity.entity.Doctor" %>

<%@page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>please Insert patient</title>
</head>
<body>
<form action="afterInserting" method="post">
    <h2>Login</h2>
    <div>
        <label for="name">Patient name :</label>
        <input type="name" id="name" name="name" required/>
    </div>
    <div>
        <label for="email">email:</label>
        <input type="email" id="name" name="email" required/>
    </div>
	
	    <div>
        <label for="disease">disease:</label>
        <input type="text" id="name" name="disease" required/>
    </div>

	
	<div>
        <label for="date">date:</label>
        <input type="date" id="date" name="addmitted_Date" required/>
    </div>
	
	    <div>
        <label for="address">address:</label>
        <input type="address" id="address" name="address" required/>
    </div>
	

		    <div>
        <label for="number"> Number:</label>
        <input type="number" id="Number" name="Number" size="10" maxlength="10" minlength="10"" required/>
    </div>
	
	
	
	<%
		ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
	
		doctorList = (ArrayList) request.getAttribute("doctorList");
		
	%>

	
	
	    <div>
			
        <label for="address">select Doctor:</label>
	
	<select name="item"  placeholder = "select" type="Doctor">
	<%  for(Doctor doctor: doctorList) { %>

	   <option name="check" type="Doctor" > <% Doctor doctorVar = doctor;   %>   <%=   doctor.Id %> </option>
	  <% } %>
	</select>
 
	
		</div>
		
	
	    <div> 
			<a href="showpatientdetails"> Home_page</a>  
		</div>
	
	
	
		
	
    <div>
        <input type="submit" value="Insert"/>
    </div>
</form>
</body>
</html>