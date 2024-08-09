<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
</head>
<body>
	<h1>Member JPA #01 - select${title}</h1>
	<hr>
	<c:forEach items="${mList}" var="m">
		<p>ID: ${m.id}</p>
		<p>Username: ${m.username}</p>
		<p>Email: ${m.email}</p>
		<hr>
	</c:forEach>
</body>
</html>