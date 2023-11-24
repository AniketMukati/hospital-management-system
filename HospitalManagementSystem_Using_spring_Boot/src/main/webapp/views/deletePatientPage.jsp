<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>delete JSP</title>
</head>
<%@ page import="java.util.Date" %>
<body>
<h2> deleting the patient : </h1><br>

<h2> ${msg} </h2>

<h2> ${msg2} </h2>


<%-- <h3> Enter the id you want to delete the patient </h3>  --%>

<form action="confirmDeletePatient" method="post">

    <div>
        <label for="id">Patient Id :</label>
        <input type="text" id="Id" name="Id" required/>
    </div>
	
	
	
	<div>
        <input type="submit" value="delete"/>
    </div>
	
	
	
</form>
</body>


</body>
</html>