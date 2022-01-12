<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="kr.co.mlec.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%
	BoardVO b = new BoardVO();
	b.setNo(10);
	b.setTitle("제목입니다");
	
	// pageContext영역에 객체 등록
	// 이름 : board, 값 : 생성된 BoardVO 객체
	pageContext.setAttribute("board", b);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	----- 표현식으로 불러오기 ----- <br>
	no : <%= b.getNo() %><br>
	no : <%= ((BoardVO)pageContext.getAttribute("board")).getNo() %><br>
	title : <%= b.getTitle() %><br>
	title : <%= ((BoardVO)pageContext.getAttribute("board")).getTitle() %><br>
	
	<br>
	
	------ EL로 불러오기- ----- <br>
	no : ${ board.no }<br>
	title : ${ board.title }<br>
	title2 : ${ board['title'] }<br>
	
	<%-- aaa : ${ board.aaa }<br>   자바빈즈 클래스에 getAaa가 없어서 500에러가 남 --%>
</body>
</html>