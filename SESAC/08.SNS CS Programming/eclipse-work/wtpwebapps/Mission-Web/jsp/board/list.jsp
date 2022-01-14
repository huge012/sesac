<%@page import="kr.co.mlec.page.vo.PageVO"%>
<%@page import="kr.co.mlec.board.dao.BoardDAO"%>
<%@page import="kr.co.mlec.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%

	/* tbl_board에서 전체 게시글(번호, 제목, 작성자, 등록일) 조회 */
	
	BoardDAO dao = new BoardDAO();
	List<BoardVO> list = dao.selectAllBoard();
	
	pageContext.setAttribute("boards", list);
	
	PageVO pageVO = new PageVO();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Mission-Web/css/board.css">
<script>
	function goWriterForm() {
		location.href = "writeForm.jsp"
	}
	
	function doAction(boardNo) {
		<c:choose>
			<c:when test="${ not empty userVO }">
				location.href = "addViewCnt.jsp?no="+boardNo
			</c:when>
			<c:otherwise>
				if (confirm("로그인이 필요한 서비스입니다.\n로그인 페이지로 이동하시겠습니까?")) {
					location.href = "/Mission-Web/jsp/login/loginForm.jsp"
				}
			</c:otherwise>
		</c:choose>
	}
	
</script>
<link rel="stylesheet" href="/Mission-Web/css/layout.css">
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
		
		<c:forEach var="board" items="${ boards }" >
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
		<div id="paging">
			<c:forEach var="i" step="1" begin="1" end="10">
			${ i }
			</c:forEach>
		</div>
		<br>
		<c:if test="${ not empty userVO }">
		<button onclick="goWriterForm()">새글등록</button>
		</c:if>
	</div>
	</section>
	
	<footer>
		<%@include file="/jsp/include/footer.jsp" %>
	</footer>
</body>
</html>