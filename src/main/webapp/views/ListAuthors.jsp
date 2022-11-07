<%@page import="org.java.models.Author"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>	
	<h2>Liste des auteurs</h2>
	<table border = "solid">
		<tr><th>Id</th><th>Name</th><th>Year Born</th><tr>
		<% List<Author> authors = (List<Author>)request.getAttribute("model"); %>
		<% for(Author a: authors){%>
		<tr>
			<td><%= a.getId() %></td>
			<td><%= a.getName() %></td>
			<td><%= a.getYearBorn()%></td>
		</tr>
		<% }%>
	</table>
</body>
</html>