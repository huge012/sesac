<%@ page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//java.util.Random r = new java.util.Random();
		Random r = new Random();
		for (int i = 0; i < 10; i ++)
		{
	%>
			<%= r.nextInt(10) + 1 %><br>
	<%
		}
	%>
</body>
</html>