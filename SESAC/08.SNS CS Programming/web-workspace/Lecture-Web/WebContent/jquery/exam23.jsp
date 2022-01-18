<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body * {
		display: block;
		border: 1px solid red;
		margin: 10px;
		padding: 10px;
	}
	
	.blue {
		border-color: blue
	}
</style>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function(){
		//형제노드에 클래스 추가하기
		//$('h2').siblings().addClass('blue')
		//$('h2').siblings('h3').addClass('blue')
		//$('h2').next().addClass('blue')
		//$('h2').prev().addClass('blue')
		//$('h1').nextUntil('p').addClass('blue')
		//$('h1').prevAll().addClass('blue')
		
		//$('h3').siblings()[1].style.borderColor='blue'  javascript객체
		$('h3').siblings().eq(1).addClass('blue')  // jquery객체
	})
</script>
</head>
<body>
	<div>div1
		<p>p-1</p>
		<span>span</span>
		<h1>h1</h1>
		<h3>h3<p>p2-1</p></h3>
		<p>p-3</p>
	</div>
	<div>
		<h2>h2</h2>
		<h3>h3</h3>
		<p>p2-1</p>
	</div>
</body>
</html>