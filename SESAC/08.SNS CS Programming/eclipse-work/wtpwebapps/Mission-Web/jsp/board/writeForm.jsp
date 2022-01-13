<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 게시글 작성</title>
<link rel="stylesheet" href="/Mission-Web/css/layout.css">
<link rel="stylesheet" href="/Mission-Web/css/board.css">
<script>
	function doWrite() {
		let f = document.inputForm
		
		if (f.title.value == '') {
			alert('제목을 입력하세요')
			f.title.focus()
			return false
		}
		if (f.writer.value == '') {
			alert('글쓴이를 입력하세요')
			f.writer.focus()
			return false
		}
		if (f.content.value == '') {
			alert('내용을 입력하세요')
			f.content.focus()
			return false
		}
		return true
	}
</script>
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp" />
	</header>
	
	<section>
		<div align="center">
		<hr>
		<h2>새글 등록</h2>
		<hr>
		
		<br>
		
		<!-- form은 대부분 post 방식 -->
		<form action="write.jsp" method="post" name="inputForm" onsubmit="return doWrite()">
			<table border="1">
				<tr>
					<th width="23%">제목</th>
					<td><input type="text" name="title" ></td>
				</tr>
				<tr>
					<th width="23%">글쓴이</th>
					<td><input type="text" name="writer" ></td>
				</tr>
				<tr>
					<th width="23%">내용</th>
					<td><textarea name="content" rows="7" cols="60" ></textarea></td>
				</tr>
			</table>
			
			<br>
			<input type="submit" value="새글등록">
				
		</form>
		
	</div>
	</section>
	
	<footer>
		<%@include file="/jsp/include/footer.jsp" %>
	</footer>
</body>
</html>