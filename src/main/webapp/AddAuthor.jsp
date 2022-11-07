<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel = "stylesheet" href = "../css/style.css">
</head>
<body>
	<h1>Ajoute un auteur</h1>
	<form action = "docs/addAuthor" method = "post">
		<table class = "form">
			<tr>
				<td>Identificateur:</td>
				<td><input type = "text" name = "id"></td>
			</tr>
			<tr>
				<td>Nom:</td>
				<td><input type = "text" name = "name"></td>
			</tr>
			<tr>
				<td>Année de naissance:</td>
				<td><input type = "text" name = "yearBorn"></td>
			</tr>
			<tr>
				<td><input type = "submit" value = "envoyer" ></td>
				<td><input type = "reset" value = "annuler" ></td>
			</tr>
		</table>
	</form>
</body>
</html>