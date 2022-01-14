<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	// 1. post방식 인코딩
 	request.setCharacterEncoding("utf-8");
 	
 	// 2. 파라미터 받아오기
 	String cName = request.getParameter("cName");
 	String cValue = request.getParameter("cValue");
 	
 	// 3. 인코딩
 	cName = URLEncoder.encode(cName, "utf-8");
 	cValue = URLEncoder.encode(cValue, "utf-8");
 	
 	// 4. 쿠키 생성 및 전송
 	Cookie cookie = new Cookie(cName, cValue);
 	response.addCookie(cookie);
 	
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>쿠키설정 완료</h2>
	
	<a href="get.jsp">설정된 쿠키정보 보기</a>
</body>
</html>