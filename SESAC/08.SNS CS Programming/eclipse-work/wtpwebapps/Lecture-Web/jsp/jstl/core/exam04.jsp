<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		exam04.jsp?type=S or exam04.jsp?type=U
	--%>
	
	<c:choose>
		<c:when test="${ param.type eq 'S' }">
			환영합니다, 관리자님<br>
		</c:when>
		<c:when test="${ param.type =='U' }">
			환영합니다, 회원님<br>
		</c:when>
		<c:otherwise>
			type이 잘못되었습니다. 다시 입력해주세요.<br>
		</c:otherwise>
	</c:choose>
	
</body>
</html>