<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<form action="login.jsp" method="post">
    <h2>Login</h2>
    <div>
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required/>
    </div>
    <div>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required/>
    </div>
    <div>
        <input type="submit" value="Login"/>
    </div>
</form>
</body>
</html>