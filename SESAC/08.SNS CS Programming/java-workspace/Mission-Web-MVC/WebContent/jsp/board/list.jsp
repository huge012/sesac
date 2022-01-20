<%@page import="kr.co.mlec.page.vo.PageVO"%>
<%@page import="kr.co.mlec.board.dao.BoardDAO"%>
<%@page import="kr.co.mlec.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/layout.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/board.css">
<script src="${ pageContext.request.contextPath }/resources/js/jquery-3.6.0.min.js"></script>
<script>
	
	$(document).ready(function(){
		$('button').click(function() {
			location.href = "${ pageContext.request.contextPath }/board/writeForm.do"
		})
	})

	function goWriterForm() {
		location.href = "${ pageContext.request.contextPath }/board/writeForm.do"
	}
	
	function doAction(boardNo) {
		<c:choose>
			<c:when test="${ not empty userVO }">
				location.href = "${ pageContext.request.contextPath }/view.do?no="+boardNo
				//location.href = "${ pageContext.request.contextPath }/detail.do?no="+boardNo
			</c:when>
			<c:otherwise>
				if (confirm("로그인이 필요한 서비스입니다.\n로그인 페이지로 이동하시겠습니까?")) {
					location.href = "${ pageContext.request.contextPath }/login.do"
				}
			</c:otherwise>
		</c:choose>
	}
	
</script>
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp" />
	</header>
	
	<section>
		<div align = "center">
		<hr>
		<h2>게시판 목록</h2>
		<hr>
		
		<table class="list" border="1">
		<tr>
			<th width="7%">번호</th>
			<th>제목</th>
			<th width="16%">작성자</th>
			<th width="20%">등록일</th>
		</tr>
		
		<c:forEach var="board" items="${ list }" >
			<tr>
				<td>${ board.no }</td>
				<td>
					<a href="javascript:doAction(${ board.no })">
						<c:out value="${board.title }" />
					</a>
					<%-- <a href="detail.jsp?no=${ board.no }">
						<c:out value="${ board.title }" />
					</a>  --%>
				</td>
				<td>${ board.writer }</td>
				<td>${ board.regDate }</td>
			</tr>
		</c:forEach>
		
		</table>
		
		<!-- <a href="#">새글등록</a> -->
		<br>
		<br>
		<c:if test="${ not empty userVO }">
		<!-- <button onclick="goWriterForm()">새글등록</button>  -->
		<button>새글등록</button>
		</c:if>
		<br>
		<br>
		<%-- 페이징 --%>
		<div id="paging">
			<c:if test="${ paging.prev }">
				<<<a href="${ pageContext.request.contextPath }/board/list.do?page=${ paging.beginPage-1 }">이전</a>... 
			</c:if>
			<c:forEach var="i" step="1" begin="${ paging.beginPage }" end="${ paging.endPage }">
				<c:choose>
					<c:when test="${ paging.page == i }">
						<span>${ i }</span>
					</c:when>
					<c:otherwise>
						<a class="otherpage" href="${ pageContext.request.contextPath }/board/list.do?page=${ i }">${ i }</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${ paging.next }">
				... <a href="${ pageContext.request.contextPath }/board/list.do?page=${ paging.endPage+1 }">다음</a>>>
			</c:if>
		</div>
		
	</div>
	</section>
	
	<footer>
		<%@include file="/jsp/include/footer.jsp" %>
	</footer>
</body>
</html>