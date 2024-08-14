<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>File upload</h1>
	<form action="fileUpLoad" method="post" enctype="multipart/form-data">
		File: <input type="file" name="files"><br>
		File: <input type="file" name="files"><br>
		<input type="submit" value="Upload">
	</form>
</body>
</html>