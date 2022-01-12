<%--
	회원정보 리스트 띄워줌
	- 회원 정보 테이블
	- 회원가입 버튼
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.mlec.user.vo.UserVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.mlec.util.JDBCClose"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.co.mlec.util.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	Connection conn = new ConnectionFactory().getConnection();
	PreparedStatement pstmt = null;
	
	StringBuilder sql = new StringBuilder();
	sql.append(" select id, name, email_id, email_domain, tel1, tel2, tel3, basic_addr ");
	sql.append(" from tbl_member ");
	
	pstmt = conn.prepareStatement(sql.toString());
	ResultSet rs = pstmt.executeQuery();
	
	List<UserVO> list = new ArrayList<>();
	
	while (rs.next())
	{
		String id = rs.getString("id");
		String name = rs.getString("name");
		String emailId = rs.getString("email_id");
		String emailDomain = rs.getString("email_domain");
		String tel1 = rs.getString("tel1");
		String tel2 = rs.getString("tel2");
		String tel3 = rs.getString("tel3");
		String basicAddr = rs.getString("basic_addr");
		UserVO user = new UserVO(id, name, emailId, emailDomain, tel1, tel2, tel3, basicAddr);
		list.add(user);
	}
	
	JDBCClose.close(pstmt, conn);
	
	pageContext.setAttribute("users", list);
	
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
		<c:set var="cnt" value="1" />
		<c:forEach var="user" items="${users}" >
			<tr>
				<td>${ cnt }</td>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${ user.emailId }@${ user.emailDomain }</td>
				<td>${user.tel1}-${user.tel2 }-${user.tel3}</td>
				<td>${ user.basicAddr }</td>
			</tr>
		</c:forEach>
			</table>
		
		<br>
		<br>
		
		<button onclick="goWriteForm()">회원가입</button>
		
	</div>
	
</body>
</html>