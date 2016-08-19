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
	<h2><c:out value ="${sessionScope.user.login }"/>'s books</h2> 
	
	<table style="border: 10px; border-color: green; color : red">
		<tr>
			<td>Title</td>
			<td>Price</td>
			<td>Author</td>
		</tr>
		<c:forEach items="${requestScope.books }" var="books" >
			<tr>
			
			
			<td><c:out value="${books.title }" /></td>
			<td><c:out value="${books.price }" /></td>
			<td><c:out value="${books.author }" /></td>
			
			
			</tr>
		
		</c:forEach>	
	
	
	
	
	</table>

<h3><a href="index.jsp">Home</a></h3>

</body>
</html>	


