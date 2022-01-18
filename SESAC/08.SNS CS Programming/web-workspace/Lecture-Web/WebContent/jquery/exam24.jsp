<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	img {
		width: 150px;
	}
	div, button {
		position: relative;
		float: left;
	}
	button {
		height : 100px;
		margin: 5px;
	}
</style>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function(){
		$('#prev').click(function(){
			//$('img').eq(0)
			//$('img').first().appendTo('body')
			$('img').last().prependTo('div')
		})
		
		$('#next').click(function(){
			$('img').first().appendTo('div')
		})
		setInterval(function(){
			$('#next').trigger('click')
		}, 2000)
	})
</script>
</head>
<body>
	<button id="prev">prev</button>
	<div>
		<img src="/Lecture-Web/html/images/dog2.jpg">
		<img src="/Lecture-Web/html/images/dog3.jpg">
		<img src="/Lecture-Web/html/images/backgif.gif">
		<img src="/Lecture-Web/html/images/dog.jpg">
	</div>
	<button id="next">next</button>
</body>
</html>