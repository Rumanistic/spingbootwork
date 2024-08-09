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
	<a href="/selectAll">전체 데이터 검색</a><br><br>
	<a href="/selectById?id=1">개별 조회 - By Id</a><br><br>
	
	<hr>
	
	<a href="/selectByName?username=리부트">개별 조회 - By Name</a><br><br>
	<a href="/selectByEmail?email=reboot@tjoeun.co.kr">개별 조회 - By Email</a><br><br>
	<a href="/selectByNameLike?name=리">리스트 조회 - Name Like</a><br><br>
	<a href="/selectByNameLikeDesc?name=리">리스트 조회 - Name Like</a><br><br>
</body>
</html>