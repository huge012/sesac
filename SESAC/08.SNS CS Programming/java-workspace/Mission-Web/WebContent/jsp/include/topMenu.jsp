<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<table border="1" style="width:100%">
	<tr>
		<td rowspan="2" align="center">
			<a href="/Mission-Web"><img src="/Mission-Web/image/logo.png" style="height: 50px;"></a>
		</td>
		<td align="right">
		즐겨찾기
		<c:if test="${not empty userVO}">
			[ ${ userVO.id }님 로그인 중... ]
		</c:if>
		</td>
	</tr>
	<tr>
		<td>
			<nav>
				<a href="/Mission-Web/jsp/board/list.jsp?page=1">게시판</a> 
				<c:if test="${ userVO.type eq 'S' }">
				| <a href="/Mission-Web/jsp/member/list.jsp">회원관리</a> 
				</c:if>
				<c:choose>
					<c:when test="${ empty userVO }">
					| <a href="/Mission-Web/jsp/member/writeForm.jsp">회원가입</a> 
					| <a href="/Mission-Web/jsp/login/loginForm.jsp">로그인</a> 
					</c:when>
					<c:otherwise>
					| 마이페이지 
					| <a href="/Mission-Web/jsp/login/logout.jsp">로그아웃</a> 
					</c:otherwise>
				</c:choose>
			</nav>
		</td>
	</tr>
</table>