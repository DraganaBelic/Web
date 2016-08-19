<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var="message" value="${requestScope.error }"/>
	<c:if test="${message !=null }">
		<c:out value="${requestScope.error }"/>
	</c:if>
	
 	<h1 style="color: red" >Welcome to library application</h1>
 	<h2><a href="jsp/login.jsp">Login</a></h2>
 	<h2><a href="jsp/register.jsp">Register</a></h2>
 	
 	
</body>
</html>