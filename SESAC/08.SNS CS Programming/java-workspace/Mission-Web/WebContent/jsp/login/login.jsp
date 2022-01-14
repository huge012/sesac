<%@page import="kr.co.mlec.member.vo.LoginVO"%>
<%@page import="kr.co.mlec.member.dao.LoginDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String password =request.getParameter("password");
	
	// 객체 초기화
	LoginVO loginVO = new LoginVO();
	loginVO.setId(id);
	loginVO.setPassword(password);
	
	// DB에서 사용자 조회
	LoginDAO dao = new LoginDAO();
	loginVO = dao.login(loginVO);
	
	/*
		반환값	null이면		로그인 실패
				null아니면	로그인 성공
	*/
	
	String msg = "";
	String url = "";
	if(loginVO == null) {
		msg = "아이디 또는 패스워드를 잘못 입력하셨습니다";
		url = "loginForm.jsp";
	} else {
		switch(loginVO.getType()){
		case "S" :
			msg = "관리자님 환영합니다";
			break;
		case "U" :
			msg = loginVO.getId()+"님 환영합니다";
			break;
		}
		url = "/Mission-Web";
		
		// 로그인 정보 세션에 등록
		session.setAttribute("userVO", loginVO);
	}
	
	// 로그인 성공 여부 page에 등록
	pageContext.setAttribute("msg", msg);
	pageContext.setAttribute("url", url);
%>

<script>

	alert('${ msg }')
	location.href = '${ url }'

</script>