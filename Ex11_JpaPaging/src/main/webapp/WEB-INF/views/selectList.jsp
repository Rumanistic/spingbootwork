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
	<h1>JPA Paging - Name Like Paging</h1>
	<!--
		model.addAttribute("members", members);
		model.addAttribute("records", records);
		model.addAttribute("pages", pages);
		model.addAttribute("size", size);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("numberOfElements", numberOfElements); 
	 -->
	총 게시글의 갯수 : ${records}
	총 페이지 수 : ${pages}
	한페이지당 항목 수 : ${size}
	현재 페이지 : ${nowPage}
	현재 페이지의 항목 수 : ${numberOfElements}
	
	<hr>
	<table>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>이메일</th>
		</tr>
	<c:forEach items="${members}" var="m">
		<tr>
			<td>${m.id}</td>
			<td>${m.name}</td>
			<td>${m.email}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>