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
		$('#btn01').click(function(){
			// 매개변수가 없으면 getter 역할, 매개변수가 있으면 setter 역할
			$('#p01').text('<mark>문장이 변환되었습니다</mark>')
		})
		
		$('#btn02').click(function(){
			$('#p02').html('<mark>문장이 변환되었습니다</mark>')
		})
		
		$('#btn03').click(function(){
			$('a').attr('href', 'http://www.daum.net')
		})
		
		
		$('#btn04').click(function(){
			/*
			let data = [10, 20, 30, 40]
			data.forEach(function(element, index){
				$('p').html('문장변환')
			})*/
			
			// html() 함수 매개변수 안 적으면 p 태그 갯수만큼 호출, 매개변수는 index, element 의미
			$('p').html(function(index, element){ 
				alert('!')
				return index+' : <strong>문장변환</strong>'
			})
		})
	})
</script>
</head>
<body>
	<a href="http://www.naver.com" target="_blank">사이트 이동</a>
	<p id="p01">첫번째 문장입니다</p>
	<p id="p02">두번째 문장입니다</p>
	<button id="btn01">TEXT변환</button>
	<button id="btn02">HTML변환</button>
	<button id="btn03">주소변환</button>
	<button id="btn04">문장변환</button>
</body>
</html>