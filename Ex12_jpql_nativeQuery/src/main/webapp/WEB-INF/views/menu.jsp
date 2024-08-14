<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
</head>
<body>
	<h1>JPQL / NativeQuery</h1>
	
	<a href="selectByNameLike1?name=user">NameLike1 조회 : JPQL_1</a> <br>
	<a href="selectByNameLike2?name=user">NameLike2 조회 : JPQL_2</a> <br>
	<a href="selectByNameLike3?name=user&page=2">NameLike3 조회 : JPQL_3 - 2page</a> <br>
		
	<a href="selectByNameLike4?name=user">NameLike4 조회 : NativeQuery</a> <br>
</body>
</html>