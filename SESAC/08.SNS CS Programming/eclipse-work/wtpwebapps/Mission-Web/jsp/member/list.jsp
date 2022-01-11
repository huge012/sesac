<%--
	회원정보 리스트 띄워줌
	- 회원 정보 테이블
	- 회원가입 버튼
--%>

<%@page import="kr.co.mlec.util.JDBCClose"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.co.mlec.util.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Connection conn = new ConnectionFactory().getConnection();
	PreparedStatement pstmt = null;
	
	StringBuilder sql = new StringBuilder();
	sql.append(" select id, name, email_id, email_domain, tel1, tel2, tel3, basic_addr ");
	sql.append(" from tbl_member ");
	
	pstmt = conn.prepareStatement(sql.toString());
	ResultSet rs = pstmt.executeQuery();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
<style>
	hr {
		width : 80%;
	}
	table {
		width : 80%;
	}
	th, td {
		text-align : center;
	}
</style>
<script>
	function goWriteForm() {
		location.href="writeForm.jsp"	
	}
</script>
</head>
<body>
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
 		<% 
 		int cnt = 1;
 		while (rs.next()) {
 			
 			String id = rs.getString("id");
 			String name = rs.getString("name");
 			String email;
 			String tel;
 			String addr;
 			
 			if (rs.getString("email_id") == null) {
 				email = "-";
 			} else {
 				email = rs.getString("email_id")+"@"+rs.getString("email_domain");
 			}
 			
 			if (rs.getString("tel1") == null || rs.getString("tel2") == null || rs.getString("tel3") == null) {
 				tel = "-";
 			} else {
 				tel = rs.getString("tel1")+"-"+rs.getString("tel2")+"-"+rs.getString("tel3");
 			}
 			
 			if (rs.getString("basic_addr") == null) {
 				addr = "-";
 			} else {
 				addr = rs.getString("basic_addr");
 			}
 			
 		%>
			<tr>
				<td><%= cnt++ %></td>
				<td><%= id%></td>
				<td><%= name%></td>
				<td><%= email%></td>
				<td><%= tel%></td>
				<td><%= addr%></td>
			</tr>
		<% } %>
		</table>
		
		<br>
		<br>
		
		<button onclick="goWriteForm()">회원가입</button>
		
	</div>
	
</body>
</html>

<% JDBCClose.close(pstmt, conn); %>