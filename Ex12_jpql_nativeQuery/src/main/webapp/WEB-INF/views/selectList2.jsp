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
	<h1>JPQL - name like</h1>
	총 레코드 수: ${tRecord}
	현재 페이지: ${nPage}
	<c:forEach items="${members}" var="m">
		아이디: 	${m.id}
		이름:		${m.name}
		이메일: 	${m.email}
		<br>
	</c:forEach>
</body>
</html>