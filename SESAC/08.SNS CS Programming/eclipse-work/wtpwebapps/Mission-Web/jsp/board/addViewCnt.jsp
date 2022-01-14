<%@page import="kr.co.mlec.board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String boardNo = request.getParameter("no");

	BoardDAO dao = new BoardDAO();
	dao.addViewCnt(Integer.parseInt(boardNo));
%>

<script>
location.href="detail.jsp?no=${param.no}"
</script>