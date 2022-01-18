<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	img{
		width: 250px;
	}
</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<script>
	$(document).ready(function(){
		$('.slider').bxSlider();
	});
</script>
</head>
<body>
	<div class="slider">
		<div><img src="/Lecture-Web/html/images/dog2.jpg"></div>
		<div><img src="/Lecture-Web/html/images/dog3.jpg"></div>
		<div><img src="/Lecture-Web/html/images/backgif.gif"></div>
		<div><img src="/Lecture-Web/html/images/dog.jpg"></div>
	</div>
</body>
</html>