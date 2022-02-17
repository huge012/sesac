<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<style>
body, th {
	text-align: center;
}

#new {
	float: right;
}

img {
	width : 20px;
}
</style>
</head>
<body>
	<hr>
	<h1>게시글 목록</h1>
	<hr>
	<c:set var="path" value="${pageContext.request.contextPath }"/>
	<a href="insert" id="new"><img alt="등록이미지이다" src="${ path }/images/pen.png">신규등록</a>
	<!-- <a href="insert" id="new"><img alt="등록이미지이다" src="../images/pen.png">신규등록</a> -->
	<table class="table  table-striped table-bordered table-hover ">
		<tr>
			<th width="7%">순서</th>
			<th width="7%">번호</th>
			<th>제목</th>
			<th width="10%">글쓴이</th>
			<th width="15%">등록일</th>
			<th width="15%">수정일</th>
			<th width="7%">삭제</th>
		</tr>

		<c:forEach items="${ blist.result.content }" var="board"
			varStatus="bstatus">
			<tr>
				<td>${ bstatus.count }</td>
				<td>${ board.bno }</td>
				<td><a href="detail?bno=${ board.bno }"> <c:out
							value="${ board.title }" /> <span class="badge">${board.replies.size()}</span>
				</a></td>
				<td>${ board.writer }</td>
				<td>${ board.regdate }</td>
				<td>${ board.updatedate }</td>
				<td><button class="delButton" data-bno="${board.bno}">삭제</button></td>
			</tr>
		</c:forEach>
	</table>

	<!-- paging -->
	<nav>
		<div>
			<ul class="pagination">
				<c:if test="${blist.prevPage}">
					<li class="page-item"><a href="${blist.prevPage.pageNumber+1}">PREV
							${blist.prevPage.pageNumber+1}</a></li>
				</c:if>
				<c:forEach items="${blist.pageList}" var="p">
					<li class="page-item ${p.pageNumber==blist.currentPageNum-2 ? 'active' : ''}">
						<a href="${p.pageNumber+1}">${p.pageNumber+1}</a>
					</li>
				</c:forEach>
				<c:if test="${blist.nextPage}">
					<li class="page-item"><a href="${blist.nextPage.pageNumber+1}">NEXT
							${blist.nextPage.pageNumber+1}</a></li>
				</c:if>
			</ul>
		</div>
	</nav>

	<form id="f1" action="list" method="get">
		<input type="hidden" name="page" value="${blist.currentPageNum}">
		<input type="hidden" name="size" value="${blist.currentPage.pageSize}">
	</form>


	<script>
		$(function() {
			$('.delButton').click(function() {
				if (confirm("삭제하시겠습니까?"))
					location.href = "delete?bno=" + $(this).attr("data-bno");
			});

			$(".pagination a").click(function(e) {
				//alert($(this).attr('href'));
				e.preventDefault(); // 링크 이동하는 본래 기능을 취소

				$('#f1').find("[name='page']").val($(this).attr('href'));
				$('#f1').submit();
			});

		});
	</script>
</body>
</html>