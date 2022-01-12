<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 맵 만들어줌
	Map<String, String> b = new HashMap<>();
	b.put("no", "10");
	b.put("title", "제목입니다");
	
	// pageContext 공유영역에 board라는 키값으로 넣음
	pageContext.setAttribute("board", b);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	------- map 객체에서 가져오기 -------<br>
	no : <%= b.get("no") %><br>
	title : <%= b.get("title") %><br>
	---------- EL로 가져오기 ----------<br>
	no : ${ board.no }<br>
	title : ${ board.title }<br>
	
	el aaa : ${ board.aaa }<br>
</body>
</html>