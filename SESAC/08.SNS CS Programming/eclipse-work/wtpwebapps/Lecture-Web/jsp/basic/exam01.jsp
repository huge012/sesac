<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>1~10 사이의 정수 출력</h1>
	<% 
	out.println("정수<br>");
	for (int i = 1; i <= 10; i++)
		out.println(i+"<br>");
	%>
	<%-- 
	기존 표현식
	<%
		out.println(msg);
	%>
	
	표현식 ( ; 사용하면 안 됨)
	<%= msg %> 
	
	
	--%>
	<!-- html 코드 
	1<br>
	2<br>
	3<br>
	4<br>
	5<br>
	6<br>
	7<br>
	8<br>
	9<br>
	10<br>
	-->
</body>
</html>