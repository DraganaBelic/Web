<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="by.tr.app.bean.*" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Books</title>
</head>
<body>
<h2>Books</h2> 
	<table >
		<td><form action="jsp/add_book.jsp">
		    <input type="submit" name="Submit" value="Add book" />
		</form></td>
		<td>
		<form action="/LibraryApplication/Controller" method="post">
			<input type="hidden" name="command" value="find_book"/>
			<input type="text" name="someText" value=""/>
			<input type="submit" name="Submit"  value="Search"/>
			</form>
		</td>
		<td><form action="index.jsp">
		    <input type="submit" name="Submit" value="Log out" />
		</form></td>
	</table>


	<table style="width:100%;  border: 1px solid black; padding: 15px">
		<tr>
			<td style="border: 1px solid black">Title</td>
			<td style="border: 1px solid black">Price</td>
			<td style="border: 1px solid black">Author</td>
			<td style="border: 1px solid black">Genre</td>
		</tr>
		<c:forEach items="${requestScope.books }" var="books" >
			<tr>
			<td><c:out value="${books.title }" /></td>
			<td><c:out value="${books.price }" /></td>
			<td><c:out value="${books.author }" /></td>
			<td><c:out value="${books.genre }" /></td>
			</tr>
		</c:forEach>	
	</table>




</body>
</html>