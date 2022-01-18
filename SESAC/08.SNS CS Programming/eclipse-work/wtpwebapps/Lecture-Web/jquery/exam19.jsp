<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <script src="http://code.jquery.com/jquery-3.6.0.min.js"></script> -->
<script src="js/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function(){
		$('#btn01').click(function(){
			// 게시글 댓글 등록 시 가장 위로 올라오게 할 경우 사용
			$('img').before('<strong>before</strong><br>')
			$('img').after('<br><em>after</em>', '<b>맨뒤</b>')
		})
	})
</script>
</head>
<body>
	<hr>
		<img src="https://t1.daumcdn.net/daumtop_chanel/op/20200723055344399.png">
	<hr>
	<button id="btn01">추가</button>
</body>
</html>