<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div{
		width: 100px;
		height: 100px;
		background-color: red;
		position: absolute;
	}
</style>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.min.js" integrity="sha256-eGE6blurk5sHj+rmkfsGYeKyZx3M4bG+ZlFyA7Kns7E=" crossorigin="anonymous"></script>
<script>
	$(document).ready(function(){
		$('div').animate({
			width: '200px'
		}, 1000)
		
		$('div').animate({
			width: '100px',
			left: '100px'
		}, 2000)
		
		$('div').animate({
			height: '200px',
			top: '100px'
		}, 1000)
		
		$('div').animate({
			height: '100px',
			top : '+=100px',
			left: '0px',
			'backgroundColor' : 'purple'
		}, 2000, function(){
			$(this).css('background-color', 'pink')
		})
	})
</script>
</head>
<body>
	<div id="div1">
	</div>
	<div id="div2">
	</div>
</body>
</html>