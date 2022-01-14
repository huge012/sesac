<%--
	회원정보 리스트 띄워줌
	- 회원 정보 테이블
	- 회원가입 버튼
--%>

<%@page import="kr.co.mlec.member.dao.MemberDAO"%>
<%@page import="kr.co.mlec.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	MemberDAO dao = new MemberDAO();
	List<MemberVO> list = dao.selectAllUser();
	pageContext.setAttribute("users", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
<link rel="stylesheet" href="/Mission-Web/css/layout.css">
<link rel="stylesheet" href="/Mission-Web/css/board.css">
<script>
	function goWriteForm() {
		location.href="writeForm.jsp"	
	}
</script>
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp" />
	</header>
	
	<section>
		<div align="center">
		<hr>
		<h2>회원 목록</h2>			
		<hr>
		
		<table border="1">
			<tr>
				<th width="5%">No</th>
				<th width="10%">ID</th>
				<th width="10%">이름</th>
				<th width="20%">e-mail</th>
				<th width="20%">전화번호</th>
				<th>기본 주소</th>
			</tr>
		<c:set var="cnt" value="1" />
		<c:forEach var="user" items="${users}" >
			<tr>
				<td>${ cnt }</td>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>
				<c:choose>
					<c:when test="${ user.emailId eq null }">
					-
					</c:when>
					<c:otherwise>
					${ user.emailId }@${ user.emailDomain }
					</c:otherwise>
				</c:choose>
				</td>
				<td>
				<c:choose>
					<c:when test="${ user.tel1 eq null }">
					-
					</c:when>
					<c:otherwise>
					${user.tel1}-${user.tel2 }-${user.tel3}
					</c:otherwise>
				</c:choose>
				</td>
				<td>
				<c:choose>
					<c:when test="${ user.basicAddr eq null }">
					-
					</c:when>
					<c:otherwise>
					${ user.basicAddr }
					</c:otherwise>
				</c:choose>
				</td>
			</tr>
		<c:set var="cnt" value="${ cnt + 1 }" />
		</c:forEach>
			</table>
		
		<br>
		<br>
		
		<button onclick="goWriteForm()">회원가입</button>
		
	</div>
	</section>
	
	<footer>
		<%@include file="/jsp/include/footer.jsp" %>
	</footer>
</body>
</html>