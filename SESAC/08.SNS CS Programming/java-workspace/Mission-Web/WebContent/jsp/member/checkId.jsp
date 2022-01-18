<%@page import="kr.co.mlec.member.dao.LoginDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	
	LoginDAO dao = new LoginDAO();
	boolean check = dao.checkId(id);
	pageContext.setAttribute("check", check);
%>
${check}