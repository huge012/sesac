<%--
	DB연동해서 등록하는 코드
	-
 --%>

<%@page import="kr.co.mlec.util.JDBCClose"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.co.mlec.util.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String email_id = request.getParameter("email_id");
	String email_domain = request.getParameter("email_domain");
	String tel1 = request.getParameter("tel1");
	String tel2 = request.getParameter("tel2");
	String tel3 = request.getParameter("tel3");
	String post = request.getParameter("post");
	String basic_addr = request.getParameter("basic_addr");
	String detail_addr = request.getParameter("detail_addr");
	
	Connection conn = new ConnectionFactory().getConnection();
	PreparedStatement pstmt = null;
	
	StringBuilder sql = new StringBuilder();
	sql.append(" insert into tbl_member(name, id, password, email_id, email_domain, tel1, tel2, tel3, post, basic_addr, detail_addr) ");
	sql.append(" values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
	
	pstmt = conn.prepareStatement(sql.toString());
	pstmt.setString(1, name);
	pstmt.setString(2, id);
	pstmt.setString(3, password);
	pstmt.setString(4, email_id);
	pstmt.setString(5, email_domain);
	pstmt.setString(6, tel1);
	pstmt.setString(7, tel2);
	pstmt.setString(8, tel3);
	pstmt.setString(9, post);
	pstmt.setString(10, basic_addr);
	pstmt.setString(11, detail_addr);
	
	int rs = pstmt.executeUpdate();
%>

 <script>
 	<% if (rs != 0) { %>
 		alert('회원 가입이 완료되었습니다')
 	<% } else { %>
 		alert('회원 가입에 실패했습니다')
 	<% } %>
 	location.href = 'list.jsp'
 </script>
 <%
 	JDBCClose.close(pstmt, conn);
 %>