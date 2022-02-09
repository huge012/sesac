<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, tr {
	border-collapse: collapse;
	text-align: center;
	width: 90%;
}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
<c:if test="${not empty msg}">
	alert("${msg}");
</c:if>
//고전적 방법
$(function(){
	$('.del').click(function(){
		//BOM(Browser Object Model): window, document, loaction, history, screen
		if (confirm("삭제하시겠습니까?"))
		{
			location.href="delete?//bno="+$(this).data('bno')
		}
	});
	
});

</script>
</head>
<body>
<c:set var="path" value="${ pageContext.request.contextPath }/book"/>
<a href="${ path }/insert">신규책 등록하기</a>
<hr>
<h1>책 목록</h1>
<table>
	<tr>
		<th>책 번호</th>
		<th>제목</th>
		<th>저자</th>
		<th>출판사</th>
		<th>출판일</th>
		<th>보유수</th>
		<th>삭제하기</th>
	</tr>
	<c:forEach items="${ bookList }" var="book">
		<tr>
			<td>${ book.bno }</td>
			<!-- <td><a href="detail?bno=${ book.bno }">${ book.title }</a></td>  상대경로 -->
			<td><a href="${ path }/detail?bno=${ book.bno }">${ book.title }</a></td> <!-- 절대경로 -->
			<td>${ book.author }</td>
			<td>${ book.pub }</td>
			<td>${ book.pubDate }</td>
			<td>${ book.status }</td>
			<td><button class="del" data-bno="${ book.bno }">삭제</button></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>