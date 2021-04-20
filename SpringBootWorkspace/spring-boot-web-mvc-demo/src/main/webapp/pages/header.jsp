<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
	import="java.time.LocalDate"    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Header</title>
</head>
<body>
	<header>
		<h3><%= LocalDate.now() %></h3>
		<h3>${ot}</h3>
		<hr />
	</header>
	
	<nav>
		<a href="home">Home</a>
		<a href="greet">Greet</a>
		<a href="emp">Employee</a>
		<a href="task">Task</a>
	</nav>
