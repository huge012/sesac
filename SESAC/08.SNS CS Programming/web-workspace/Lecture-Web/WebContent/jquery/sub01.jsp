<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div {
		width: 50px;
		height: 50px;
		top : 200px;
		left: 200px;
		position: relative;
		float: left;
		text-align: center;
		display:table-cell;
		vertical-align:middle;
		color: white;  
	}
	
	#day1{
		background-color:red;
	}
	#day2{
		background-color:orange;
	}
	#day3{
		background-color:yellow;
	}
	#day4{
		background-color:green;
	}
	#day5{
		background-color:blue;
	}
	#day6{
		background-color:darkblue;
	}
	#day7{
	background-color:purple;
	}
	#day1{
		background-color:red;
	}
</style>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.min.js" integrity="sha256-eGE6blurk5sHj+rmkfsGYeKyZx3M4bG+ZlFyA7Kns7E=" crossorigin="anonymous"></script>
<script>
	let flag = false;
	$(document).ready(function(){
			$('div').hover(function() {
					$(this).animate({
						width: '+=50px',
						height: '+=50px',
					}, 1000, function(){
						flag = true;
					})
					let dayname = $(this).text() + '요일'
					$(this).text(dayname)
		}, function(){
				$(this).animate({
					width: '-=50px',
					height: '-=50px',
				}, 1000, function(){
					flag = false;
				})
				let dayname = $(this).text().substr(0,1)
				$(this).text(dayname)
		})
	})
</script>
</head>
<body>
		<div id="day1">월</div>
		<div id="day2">화</div>
		<div id="day3">수</div>
		<div id="day4">목</div>
		<div id="day5">금</div>
		<div id="day6">토</div>
		<div id="day7">일</div>
</body>
</html>
