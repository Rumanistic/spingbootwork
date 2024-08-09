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
	<h1>Member JPA #01 - SELECTALL</h1>
	<c:forEach items="${mList}" var="member">
	아이디: ${member.id} <br>
	이름: ${member.username} <br>
	생성일자: ${member.createDate} <br><br>
	</c:forEach>
	
	<a href="/">메인으로 돌아가기</a>
</body>
</html>