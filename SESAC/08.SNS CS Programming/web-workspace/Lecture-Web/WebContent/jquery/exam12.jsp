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
		display: none;
		position: absolute;
	}
	
	#div2{
		width: 300px;
		height: 300px;
		position: relative;
	}
</style>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function(){
		$('#div1').animate({
			width: 'toggle',
			height: 'toggle',
			left: '100px',
			top: '200px'
		}, 2000)
		$('#div2').animate({
			width: 'toggle',
			height: 'toggle',
			left: '50px',
			top: '100px',
			opacity: '0.4'
		}, 2000)
		
		/*$('div').animate({
			width: '200px',
			height: '+=200px'
		}, 2000)*/
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