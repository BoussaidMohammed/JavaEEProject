<%@page import="org.java.models.Author"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% Author author = (Author) request.getAttribute("model"); %>
	<h2>Auteur info:</h2>
	<p> ${model.id } ${model.name } ${model.yearBorn } </p>
</body>
</html>