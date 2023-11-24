<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.springSecurity.payLoad.User" %>

<%@page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register</title>
</head>
<body>
<form action="register" method="post">
    <h2>registration</h2>
	
	<%
		
		
		%>
	
	
    <h3> ${msg} </h3>
	
    <div>
        <label for="name">user name :</label>
        <input type="name" id="name" name="name" required/>
    </div>
    <div>
        <label for="email">email:</label>
        <input type="email" id="name" name="email" required/>
    </div>
	
	    <div>
        <label for="password">Password:</label>
        <input type="text" id="password" name="password" maxlength="20" minlength="3" required/>
    </div>

	

	    <div>
        <label for="role">Role:</label>
        <input type="text" id="role" name="role" required/>
    </div>
	
	
	
		
	
    <div>
        <input type="submit" value="submit"/>
    </div>
</form>
</body>
</html>