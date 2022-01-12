<%@page import="kr.co.mlec.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.co.mlec.util.JDBCClose"%>
<%@page import="kr.co.mlec.util.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%

	/* tbl_board에서 전체 게시글(번호, 제목, 작성자, 등록일) 조회 */
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	conn = new ConnectionFactory().getConnection();
	
	StringBuilder sql = new StringBuilder();
	sql.append("select no, title, writer, to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
	sql.append(" from tbl_board ");
	sql.append(" order by no desc ");
		
	pstmt = conn.prepareStatement(sql.toString());
	ResultSet rs = pstmt.executeQuery();
	
	List<BoardVO> list = new ArrayList<>(); 
	
	while(rs.next()) {
		int no = rs.getInt("no");
		String title = rs.getString("title");
		String writer = rs.getString("writer");
		String regDate = rs.getString("reg_date");
		BoardVO board = new BoardVO(no, title, writer, regDate);
		// System.out.println(board);	
		list.add(board);
	}
	
	JDBCClose.close(pstmt, conn);
	
	pageContext.setAttribute("boards", list);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	hr, table {
		width: 80%;
	}
	td {
		text-align: center;
	}
	a:link {
		text-decoration: none;
		color: black;
	}
	a:visited {
		color: black;
	}
	a:hover {
		text-decoration: underline;
	}
</style>
<script>
	function goWriterForm() {
		location.href = "writeForm.jsp"
	}
</script>
</head>
<body>
	<div align = "center">
		<hr>
		<h2>게시판 목록</h2>
		<hr>
		
		<table border="1">
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
					<a href="detail.jsp?no=${ board.no }">	${ board.title } </a>
				</td>
				<td>${ board.writer }</td>
				<td>${ board.regDate }</td>
			</tr>
		</c:forEach>
		
		</table>
		
		<!-- <a href="#">새글등록</a> -->
		<br>
		<br>
		<button onclick="goWriterForm()">새글등록</button>
		
	</div>
		
</body>
</html>