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
		
		$('h1').click(function(event,) {
			$(this)[0].innerText += ' * '
		})
		
		/*$('h1').click(function(){
			let cnt = document.getElementById('per')
			cnt.innerHTML += ' *'
		})*/
		
		/*
		setInterval(function(){
			let cnt = document.getElementById('per')
			cnt.innerHTML += '*'
		}, 1000)*/
		setInterval(function() {
			//$('h1').click()
			$('h1').trigger('click')
		}, 1000)
		
		setTimeout(function(){
			
		})
	})
</script>
</head>
<body>
	<h1 id="per">수행률 : </h1>
</body>
</html>