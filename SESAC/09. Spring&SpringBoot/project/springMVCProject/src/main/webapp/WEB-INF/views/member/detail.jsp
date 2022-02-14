<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href="${ pageContext.request.contextPath }/resources/css/layout.css" >
<link rel = "stylesheet" href="${ pageContext.request.contextPath }/resources/css/board.css" >
<script src="${ pageContext.request.contextPath }/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	function doAction(type){
		
		switch(type){
		case 'U':
			location.href = "update.do?id=${ param.no }";
			break;
		case 'D':
			if (confirm('정말 탈퇴하시겠습니까?')) {
				location.href = "delete.do?no=${ param.no }";
			}
			break;
		case 'L':
			location.href = "list.do"
			break;
		}
	}
</script>
</head>
<body>
	<header>
		<%--<jsp:include page="/view/include/topMenu.jsp" /> --%>
	</header>
	<section>
		<div align="center">
		<hr>
		<h2>내정보</h2>
		<hr>
		<br>
		<table border="1">
			<tr>
				<th width="25%">아이디</th>
				<td>${ user.id }</td>
			</tr>
			<tr>
				<th width="25%">이름</th>
				<td>${ user.name }</td>
			</tr>
			<tr>
				<th width="25%">전화번호</th>
				<td>${ user.tel1 }-${ user.tel2 }-${ user.tel3 }</td>
			</tr>
			<tr>
				<th width="25%">이메일</th>
				<td>${ user.email_id }@${ user.email_domain }</td>
			</tr>
			<tr>
				<th width="25%">가입일</th>
				<td>${ user.reg_date }</td>
			</tr>
		</table>
		<br>
		<button onclick="doAction('U')">수정</button>
		<button onclick="doAction('D')">삭제</button>
		<button onclick="doAction('L')">목록</button>
	</div>
	</section>
	<footer>
		<%--<%@ include file="/jsp/include/footer.jsp" %> --%>
	</footer>
</body>
</html>
