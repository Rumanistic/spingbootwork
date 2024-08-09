<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="writeBoardForm" method="post">
		<label for="writer">작성자</label>
		<input id="writer" name="writer">
		<br><br>
		<label for="title">제목</label>
		<input id="title" name="title">
		<br><br>
		<label for="content">내용</label>
		<textarea id="content" name="content"></textarea>
		<br><br>
		<button>등록</button> &emsp;&emsp;&emsp; <a href="list"><button type="button">목록보기</button></a>
	</form>
</body>
</html>