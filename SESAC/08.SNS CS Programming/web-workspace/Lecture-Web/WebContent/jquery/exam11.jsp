<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h1 {
		display: none;
	}
</style>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function() {
		alert('!!!')
		// 3초에 걸려 Hello World 문장 화면에 보인 뒤, complate 메세지를 경고창에 띄우기
	//	$('h1').show(3000)
	//	alert('complate...')
	/*	
	$('h1').show(3000, function(){
			alert('complate')
		})
		*/
		// 3초에 걸려서 Hello World 문자를 화면에 보인 후, 글자색을 파랑으로 변경하고
		// 슬라이도 효과로 올라갔다 내려갔다 수행, 이후 배경색을 노랑으로 변경
		
		$('h1').show(3000, function(){
			$(this).css('color', 'blue')
			$(this).slideUp(1000).slideDown(1000, function(){
				$(this).css('background-color', 'yellow')
			})
		})
	})
</script>
</head>
<body>
	<h1>Hello World</h1>
</body>
</html>