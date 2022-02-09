<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h1 {background-color:lightgray;}
</style>
</head>
<body>
<h1>오류정보입니다.(연산오류일때 페이지입니다.)</h1>
<%=exception %>
<%=exception.getMessage() %>
</body>
</html>