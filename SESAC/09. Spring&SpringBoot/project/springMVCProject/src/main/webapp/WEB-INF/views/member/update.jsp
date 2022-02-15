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
		<form action="update.do" method="post">
		<input type="hidden" name="id" value="${ user.id }">
		<table border="1">
			<tr>
				<th width="25%">아이디</th>
				<td>${ user.id }</td>
			</tr>
			<tr>
				<th width="25%">이름</th>
				<td><input type="text" name="name" value="${ user.name }"></td>
			</tr>
			<tr>
				<th width="25%">전화번호</th>
				<td><input type="text" name="tel1" value="${ user.tel1 }">-<input type="text" name="tel2" value="${ user.tel2 }">-<input type=text name="tel3" value="${ user.tel3 }"></td>
			</tr>
			<tr>
				<th width="25%">이메일</th>
				<td><input type="text" name="email_id" value="${ user.email_id }">@<input type="text" name="email_domain" value="${ user.email_domain }"></td>
			</tr>
			<tr>
				<th width="25%">가입일</th>
				<td><input type="text" name="reg_date" value="${ user.reg_date }" disabled="disabled"></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="수정">
		</form>
	</div>
	</section>
	<footer>
		<%--<%@ include file="/jsp/include/footer.jsp" %> --%>
	</footer>
</body>
</html>
