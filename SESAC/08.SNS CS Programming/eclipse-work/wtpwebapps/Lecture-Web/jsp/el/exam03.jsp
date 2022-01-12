<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	/*
		객체 등록 : 공유영역.setAttribute("이름", "값")
		공유 영역 4가지 : pageContext, request, session, application
	*/
	pageContext.setAttribute("msg", "page영역에 객체등록");
	
	String msg = (String)pageContext.getAttribute("msg");
	
	request.setAttribute("msg", "request영역에 객체 등록");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	msg(pageContext접근) : <%= pageContext.getAttribute("msg") %><br>
	msg(접근해서 변수 저장) : <%= msg %><br>
	
	<%-- 
		EL 공유영역 4가지 표현 방식
		pageScope, requestScope, sessionScope, applicationScope
	--%>
	msg(EL 방식) : ${ msg }<br>
	msg(EL 방식, 영역 request로 지정) : ${ requestScope.msg }<br>
</body>
</html>