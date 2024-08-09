<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="mEnroll" method="post">
		ID: <input name="id"> <br>
		NAME: <input name="name"> <br>
		PASSWORD: <input type="password" name="password">
		<button>회원가입</button>
	</form>
	
	<form action="bInsert">
		TITLE: <input name="title"> <br>
		CONTENT: <input name="content">
		<button>게시글 작성</button>
	</form>
</body>
</html>