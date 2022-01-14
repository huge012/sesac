<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	세션 id : ${ id }<br>
	세션 password : ${ sessionScope.password } <br>
	<a href="remove.jsp">세션정보 삭제</a>
</body>
</html>