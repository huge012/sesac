<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function(){
		$('button').click(function(){
			let spanTag = $('#cnt')[0]
			spanTag.innerHTML = parseInt(spanTag.innerHTML) + 1
			
			/*
			let cnt = document.getElementById('cnt')
			cnt.innerHTML = parseInt(cnt.innerHTML)+1
			*/
		})
	})
</script>
</head>
<body>
	<span id="cnt">0</span>번 클릭<button>클릭</button>
</body>
</html>