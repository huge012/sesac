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
		//$('span').parent().css('border-color', 'blue')
		//$('span').parents().addClass('blue')
		//$('span').parents('div').addClass('blue')
		
		// 선조 중 div 만나기 전까지 모든 요소에 blue 클래스 추가
		//$('span').parentsUntil('div').addClass('blue')
		
		// 후손 전부를 다 접근하기 힘듬, 부모에서 자식으로 내려가는 건 직속 1단계만 가능
		//$('#ancester').children().addClass('blue')
		//$('#ancester').children('#div02').addClass('blue')
		//$('#ancester').children('ul').addClass('blue')
		$('#ancester').find('ul').addClass('blue')
	})
</script>
</head>
<body>
	<div id="ancester">
		<div id="div01">div
			<ul>ul
				<li>li
					<span>span</span>
				</li>
			</ul>
		</div>
		<div id="div02">div
			<p>p
				<span>span</span>
			</p>
		</div>
	</div>
</body>
</html>