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

	<h1>Welcome ! </h1>
	<h2><c:out value ="${sessionScope.user.login }"/> !</h2>
	
	<form action="../Controller" method="get">
	
	<input type="hidden" name="command" value="show_books" />
	<input type="submit" name="show books" value="Show books"/>
	
	</form>
	
</body>
</html>