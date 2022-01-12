<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String[] names = {"홍길동", "강길동", "윤길동", "송길동", "김길동"};
	pageContext.setAttribute("names", names);
	pageContext.setAttribute("namesLength", names.length);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>1~10 사이의 정수 출력</h3>
	<%--
	<% 
		for(int i = 1; i <= 10; i++) {
	%>
		<%= i %><br>
	<% } %>
	--%>
	
	<c:forEach begin="1" end="10" var="i">
		${ i }<br>
	</c:forEach>
	<hr>
	<h3>foreach 반복</h3><br>
	연도 선택 : 
	<select>
		<c:forEach begin="1990" end="2050" var="year">
			<option>${ year }</option>
		</c:forEach>
	</select>
	<hr>
	<h3>foreach 배열 길이만큼 반복</h3><br>
	<c:forEach var="i" begin="0" end="${ namesLength - 1 }">
		${names[i]}<c:if test="${ namesLength-1-i ne 0 }">,</c:if>
	</c:forEach>
	<hr>
	<h3>foreach 배열 아이템 요소만큼 반복</h3><br>
	<c:set var="cnt" value="0" />
	<c:forEach var="name" items="${ names }">
		<c:set var="cnt" value="${ cnt+1 }"/>
		${ name }<c:if test="${ cnt != namesLength }">,</c:if>
	</c:forEach>
	
</body>
</html>

