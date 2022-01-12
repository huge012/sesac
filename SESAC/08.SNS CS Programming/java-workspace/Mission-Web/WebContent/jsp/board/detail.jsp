<%--
	http://localhost:9999/Mission-Web/jsp/board/detail.jsp?no=3
	
	작업순서
	1. 요청 URL의 파라미터(no=3)를 풀어서 상세 게시글 번호 추출
	2. DB tbl_board에서 추출딘 게시글번호의 게시물을 조회
	3. HTML에 조회된 게시물 연결
 --%>
<%@page import="kr.co.mlec.util.JDBCClose"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.co.mlec.util.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%
	// 1.
	int boardNo = Integer.parseInt(request.getParameter("no"));
	
	// 2.
	Connection conn = new ConnectionFactory().getConnection();
	
	StringBuilder sql = new StringBuilder();
	sql.append("select no, title, writer, content, view_cnt ");
	sql.append(" , to_char(reg_date, 'yyyy-mm-dd') reg_date ");
	sql.append(" from tbl_board ");
	sql.append(" where no = ? ");
	
	PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	pstmt.setInt(1, boardNo);
	
	ResultSet rs = pstmt.executeQuery();
	
	rs.next();
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 상세페이지</title>
<style>
	hr, table {
		width: 80%;
	}
	td {
		text-align: center;
	}
</style>
<script>

	function doAction(type) {
		switch (type) {
		case 'U':
			location.href = ""
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
	<div align="center">
		<hr>
		<h2>게시판 상세</h2>
		<hr>
		<br>
		
		<table border="1">
			<tr>
				<th width="20%">번호</th>
				<td><%= rs.getInt("no") %></td>
			</tr>
			<tr>
				<th width="20%">제목</th>
				<td><%= rs.getString("title") %></td>
			</tr>
			<tr>
				<th width="20%">작성자</th>
				<td><%= rs.getString("writer") %></td>
			</tr>
			<tr>
				<th width="20%" height="500px">내용</th>
				<td><%= rs.getString("content") %></td>
			</tr>
			<tr>
				<th width="20%">조회수</th>
				<td><%= rs.getInt("view_cnt") %></td>
			</tr>
			<tr>
				<th width="20%">등록일</th>
				<td><%= rs.getString("reg_date") %></td>
			</tr>
		</table>
		
		<br><br>
		
		<button onclick="doAction('U')">수정</button>
		<button onclick="doAction('D')">삭제</button>
		<button onclick="doAction('L')">목록</button>
		
		<br><br>
	</div>
</body>
</html>

<% JDBCClose.close(pstmt, conn); %>