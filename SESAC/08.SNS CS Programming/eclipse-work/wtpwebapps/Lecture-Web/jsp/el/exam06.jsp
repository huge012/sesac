<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String[] nameArr = {"홍길동", "강길동", "윤길동"};
	
	pageContext.setAttribute("names", nameArr);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	------------표현식 사용------------<br>
	첫번째 이름 : <%= nameArr[0] %><br>
	두번째 이름 : <%= nameArr[1] %><br>
	세번째 이름 : <%= nameArr[2] %><br>
	<br>
	-------------EL 사용-------------<br>
	첫번째 이름 : ${ names[0] }<br>
	두번째 이름 : ${ names[1] }<br>
	세번째 이름 : ${ names[2] }<br>
	네번째 이름 : ${ names[3] }<br> <%-- 에러 발생 x --%>
	<br>
	
</body>
</html>