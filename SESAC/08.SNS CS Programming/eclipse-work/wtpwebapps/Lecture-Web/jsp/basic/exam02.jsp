<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- 
		기존 표현식
		<%
			out.println(msg);
		%>
		
		표현식 ( ; 사용하면 안 됨) - scriptlet에선 사용 불가
		<%= msg %> 
	--%>
	
	<h2>1~10 사이의 정수 출력</h2>
	
	<% 
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
				sum += i;
	%>
		<%= i %><br>
	<%
		}
	%>
	1~10 사이의 총합 : <%= sum %><br>
	

</body>
</html>