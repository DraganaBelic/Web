<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Register : </h1>

<form action="../Controller" method="get">
	<input type="hidden" name="command" value="registration" />
	
	First name :<br>
		<input type="text" name="fname" value=""/><br/>
	Last name :<br/>
		<input type="text" name= "lname" value="" /><br/>
	User name:<br/>
		<input type="text" name="login" value=""/><br/>
	Email : <br/>
		<input type="text" name= "email" value="" /><br/>
	Password :<br/>
		<input type="password" name="pass" value=""/><br/>
	Repeat password : <br/>
		<input type="password" name="repass" value=""/><br/><br/>
		<input type="submit" name="Sign up" value="Sign up">

</form>

</body>
</html>