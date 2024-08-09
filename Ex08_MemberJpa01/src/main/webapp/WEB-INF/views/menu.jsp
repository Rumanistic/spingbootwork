<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
</head>
<body>
	<h1>Member JPA #01</h1>
	<input name="username" id="username">
	<a href="/insert?username=name">데이터 추가</a><br><br>
	<a href="/select?id=1">데이터 검색</a><br><br>
	<a href="/selectAll">전체 데이터 검색</a><br><br>
	<a href="/update?id=1&username=신창섭">데이터 변경</a><br><br>
	<a href="/delete?id=2">데이터 삭제</a><br><br>
</body>
</html>