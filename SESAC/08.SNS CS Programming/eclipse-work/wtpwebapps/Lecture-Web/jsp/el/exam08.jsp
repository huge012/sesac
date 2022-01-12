<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="kr.co.mlec.board.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. 자바빈즈클래스 + 콜렉션
	List<BoardVO> boardList = new ArrayList<>();
	BoardVO board= new BoardVO();
	board.setTitle("성공");
	boardList.add(board);
	pageContext.setAttribute("boardList1", boardList);
	
	
	// 2. 자바빈즈클래스 + 배열
	BoardVO[] boardArr = new BoardVO[1];
	boardArr[0] = new BoardVO(1, "성공");
	pageContext.setAttribute("boardList2", boardArr);
	
	
	// 3. Map 객체 + 배열
	Map<String, String> mm = new HashMap<>();
	mm.put("title", "성공");
	Map[] boardList3 = {mm};
	pageContext.setAttribute("boardList3", boardList3);
	
	
	// 4. Map 객체 + 콜렉션
	Map<String, String> mmm = new HashMap<>();
	mmm.put("title", "성공");
	List<Map<String, String>> boardList4 = new ArrayList<>();
	boardList4.add(mmm);
	pageContext.setAttribute("boardList4", boardList4);
	
	
	// 5. 자바빈즈클래스 + Map ??? Integer때문에 애매해짐! -> 차라리 배열을 쓰는게 나음!
	BoardVO bd = new BoardVO(0, "성공");
	Map<Integer, BoardVO> m = new HashMap<>();
	m.put(0, bd);
	System.out.println(m.get(0).getTitle());
	pageContext.setAttribute("boardList5", m);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	성공/실패? ${ boardList1[0].title }<br>
	성공/실패? ${ boardList2[0].title }<br>
	성공/실패? ${ boardList3[0].title }<br>
	성공/실패? ${ boardList4[0].title }<br>
	성공/실패? ${ boardList4['0'].title }<br>
</body>
</html>