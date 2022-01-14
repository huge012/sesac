<%--
	DB연동해서 등록하는 코드
	-
 --%>

<%@page import="kr.co.mlec.member.dao.MemberDAO"%>
<%@page import="kr.co.mlec.member.vo.MemberVO"%>
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
	String emailId = request.getParameter("email_id");
	String emailDomain = request.getParameter("email_domain");
	String tel1 = request.getParameter("tel1");
	String tel2 = request.getParameter("tel2");
	String tel3 = request.getParameter("tel3");
	String post = request.getParameter("post");
	String basicAddr = request.getParameter("basic_addr");
	String detailAddr = request.getParameter("detail_addr");
	
	MemberVO user = new MemberVO();
	user.setName(name);
	user.setId(id);
	user.setPassword(password);
	user.setEmailId(emailId);
	user.setemailDomain(emailDomain);
	user.setTel1(tel1);
	user.setTel2(tel2);
	user.setTel3(tel3);
	user.setPost(post);
	user.setBasicAddr(basicAddr);
	user.setDetailAddr(detailAddr);
	
	MemberDAO dao = new MemberDAO();
	int rs = dao.insertUser(user);
	pageContext.setAttribute("rs", rs);
%>

 <script>
 	alert("${ rs > 0 ? '회원가입이 완료되었습니다' : '회원가입에 실패했습니다' }")
 	location.href = 'list.jsp'
 </script>