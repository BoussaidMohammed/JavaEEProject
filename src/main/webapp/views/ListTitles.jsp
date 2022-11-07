<%@page import="org.java.models.Author"%>
<%@page import="org.java.models.Title"%>
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
	<% List<Title> titles = (List<Title>)request.getAttribute("model"); %>
	
	<table border = "1" style = "width: 100%; border-collapse: collapse">
		<% for(Title t: titles) { %>
			<tr>
				<td><%= t.getIsbn() %></td>
				<td><%= t.getTitle() %></td>
				<td><%= t.getYearPublished() %></td>
				<td><%= t.getPublisher().getName() %></td>
				<td>
					<table>
					<%for(Author a: t.getAuthors()){ %>
						<tr>
							<td><%=a.getId() %></td>
							<td><%=a.getName() %></td>
							<td><%=a.getYearBorn() %></td>
						</tr>
					<% } %>
					</table>
				</td>
			</tr>
		<% } %>
	</table>
</body>
</html>