<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.min.js" integrity="sha256-eGE6blurk5sHj+rmkfsGYeKyZx3M4bG+ZlFyA7Kns7E=" crossorigin="anonymous"></script>
<script>
	$(document).ready(function(){
		alert("!!")
		//$('a').hide()
		
		// [target]속성이 있는 a태그를 숨겨라
		//$('a[target]').hide()
		
		//$('a[href="http://www.naver.com"]').hide()
		
		//$('input[type=text]').hide()
		//$('input:text').hide() // input 태그만 이와 같이 줄여서 표현 가능
		//$('input:button').hide()
		//$('button').hide()
		//$(':text').hide() // 타입이 텍스트인 걸 숨김
		//$(':button').hide() // input:button, button태그 둘 다 적용됨
		
		// 버튼 클릭 시 콜백함수 호출
		$(':button').click(function(){
			//$('hr').hide()
			//console.log($('this'))
			$(this).hide("drop", {direction: "down"})
		})
	})
</script>
</head>
<body>
	<h2>a Tag전</h2>
	<a href="http://www.naver.com">네이버</a>
	<a href="http://www.daum.net" target="_blank">다음</a>
	<h2>a Tag후</h2>
	<hr>
		<input type="text">
		<input type="button" value="버튼1">
		<button>버튼2</button>
	<hr>
</body>
</html>