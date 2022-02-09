<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table border="1" style="width:100%">
	<tr>
		<td rowspan="2">
			<a href="${ pageContext.request.contextPath }">
				<img src="${ pageContext.request.contextPath }/resources/images/logo.png" style="height: 50px; width: 100px;">
			</a>
		</td>
		<td align="right">
			즐겨찾기
			<c:if test="${ not empty userVO }"> <%--  --%>
				[${userVO.id}님으로 로그인중...]
			</c:if>
		</td>
	</tr>
	<tr>
		<td>
			<nav>
				<c:if test="${ userVO.type eq 'S' }">
				회원관리 |
				</c:if>
				<a href="${ pageContext.request.contextPath }/board/list.do">게시판</a> |  
				<c:choose>
					<c:when test="${ empty userVO }">
				
						<a href="${ pageContext.request.contextPath }/login.do">로그인</a> |
						<a href="/Mission-Web/jsp/member/signUpForm.jsp">회원가입</a> |
				
					</c:when>
					<c:otherwise>
						마이페이지 |
						<a href="${ pageContext.request.contextPath }/logout.do">로그아웃</a>
					</c:otherwise>
				</c:choose>
			</nav>
		</td>
	</tr>
</table>