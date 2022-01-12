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
		exam03.jsp?type=S or exam03.jsp?type=U
	--%>
	
	<c:if test="${ empty param.type }">
		(if)type파라미터가 전송되지 않았습니다<br>
	</c:if>
	<c:if test="${ param.type == 'S' }">
		(if)환영합니다 관리자님<br>
	</c:if>
	<c:if test="${ param.type == 'U' }">
		(if)환영합니다 회원님<br>
	</c:if>
	
	<c:choose>
		<c:when test="${ param.type == 'S' }">
			(choose)환영합니다, 관리자님<br>
		</c:when>
		<c:when test="${ param.type =='U' }">
			(choose)환영합니다, 회원님<br>
		</c:when>
		<c:otherwise>
			(choose)다시 입력해주세요.
		</c:otherwise>
	</c:choose>
</body>
</html>