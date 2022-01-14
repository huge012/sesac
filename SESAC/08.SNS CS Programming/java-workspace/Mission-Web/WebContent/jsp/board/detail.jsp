<%--
	http://localhost:9999/Mission-Web/jsp/board/detail.jsp?no=3
	
	작업순서
	1. 요청 URL의 파라미터(no=3)를 풀어서 상세 게시글 번호 추출
	2. DB tbl_board에서 추출딘 게시글번호의 게시물을 조회
	3. HTML에 조회된 게시물 연결
 --%>
<%@page import="kr.co.mlec.board.dao.BoardDAO"%>
<%@page import="kr.co.mlec.board.vo.BoardVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	// 1. 번호 추출
	int boardNo = Integer.parseInt(request.getParameter("no"));
	
	// 2. 게시물 조회
	BoardDAO dao = new BoardDAO();
	BoardVO board = dao.selectBoardByNo(boardNo);
	
	// 3. 공유영역에 넘겨줌 (JSP에서 EL, JSTL 접근하기 위해)
	pageContext.setAttribute("board", board);
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 상세페이지</title>
<link rel="stylesheet" href="/Mission-Web/css/layout.css">
<link rel="stylesheet" href="/Mission-Web/css/board.css">
<script>

	function doAction(type) {
		switch (type) {
		case 'U':
			location.href = "updateForm.jsp?no=${ param.no }"
			break;
		case 'D':
			location.href = ""
			break;
		case 'L':
			location.href = "list.jsp"
			break;
		}
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
		<h2>게시판 상세</h2>
		<hr>
		<br>
		
		<table border="1">
			<tr>
				<th width="20%">번호</th>
				<td>${ board.no }</td>
			</tr>
			<tr>
				<th width="20%">제목</th>
				<td>${ board.title }</td>
			</tr>
			<tr>
				<th width="20%">작성자</th>
				<td>${ board.writer }</td>
			</tr>
			<tr>
				<th width="20%" height="500px">내용</th>
				<td>${ board.content }</td>
			</tr>
			<tr>
				<th width="20%">조회수</th>
				<td>${ board.viewCnt }</td>
			</tr>
			<tr>
				<th width="20%">등록일</th>
				<td>${ board.regDate }</td>
			</tr>
		</table>
		
		<br><br>
		<c:if test="${ board.writer eq userVO.id }">
			<button onclick="doAction('U')">수정</button>
			<button onclick="doAction('D')">삭제</button>
		</c:if>
		<button onclick="doAction('L')">목록</button>
		
		<br><br>
	</div>
	</section>
	
	<footer>
		<%@include file="/jsp/include/footer.jsp" %>
	</footer>
</body>
</html>