<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="by.htp.lib.domain.*" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hello </h1>
	<c:out value ="${sessionScope.user.login }"/> !
	
	<table>
		<tr>
			<td>Title</td>
			<td>Price</td>
			<td>Author</td>
		</tr>
		<c:forEach items="${requestScope.books }" var="book" >
			<tr>
			<td><c:out value="${book.title }" /></td>
			<td><c:out value="${book.price }" /></td>
			<td><c:out value="${book.author }" /></td>
			<td><></td>
			
			</tr>
		
		</c:forEach>	
	
	
	
	
	</table>



</body>
</html>	


