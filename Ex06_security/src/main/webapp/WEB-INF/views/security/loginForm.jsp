<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${param.error != null}">
		<h1>!!! 로그인 실패 !!!</h1>
		<span style="color: red; background-color: yellow">${errormsg}</span>
	</c:if>
	<form action="loginCheck" method="post">
		ID: <input name="username"><br>
		PW: <input name="pwd">
		<input type="submit" value="LOGIN">
	</form>
</body>
</html>