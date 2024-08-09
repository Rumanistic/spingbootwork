<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div>세부정보</div>
		<div>${b.boardno}</div>
		<div>${b.title}</div>
		<div>${b.writer}</div>
		<div>${b.content}</div>
</body>
</html>