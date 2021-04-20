<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h3>${companyName}</h3>
	<h4>${phones[0]}, ${phones[1]}, ${phones[2] }</h4>
	<hr />
	<ul>
		<c:forEach var="phone" items="${phones}">
			<li>${phone}</li>
		</c:forEach>	
	</ul>
	<hr />
	<c:set var="a" value="100" />
	<c:out value="${a}" />
	${a}
	<c:set var="b" value="${param.num }" />
	${b }
	<c:if test="${param.num %2==0}">
		${param.num } is even
	</c:if>
	<c:if test="${param.num %2!=0}">
		${param.num } is odd
	</c:if>
	
	
	
</body>
</html>