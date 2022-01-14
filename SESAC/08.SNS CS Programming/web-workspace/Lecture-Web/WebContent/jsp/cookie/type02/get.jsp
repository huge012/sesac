<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 쿠키 추출
	Cookie[] cookies = request.getCookies();
	
	StringBuilder sb = new StringBuilder();
	for (Cookie c : cookies) {
		String cName = c.getName();
		String cValue = c.getValue();
		
		// 복호화 decoding
		cName = URLDecoder.decode(cName, "utf-8");
		cValue = URLDecoder.decode(cValue, "utf-8");
				
		sb.append("쿠키 이름 : "+cName+", 쿠키 값 : "+cValue+"<br>");
	}
	
	pageContext.setAttribute("cookie_data", sb.toString());
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>type02 설정된 쿠키 확인</h2>
	<%-- <%= sb.toString() --%>
	쿠키값 ${ cookie_data }
	
	<a href="makeForm.jsp">쿠키설정</a>
</body>
</html>