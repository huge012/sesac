<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function(){
		$('button').click(function(){
			let name = $('#name').val()
			let age = $('#age').val()
			// param.jsp?name=hong&age=25
			
			/*
			$.get('param.jsp', "name=hong&age=25", function(){
				alert('성공')
			})*/
			
			$.post('param.jsp', {name:name, age:age}, function(data){
				$('#debug').val(data.trim())
			})
				
			$.ajax({
				type: "get",
				url: 'param.jsp',
				//data: 'name='+$('#name').val()+'&age='+$('#age').val(),
				//data: 'name=' + name + '&age=' + age,
				//data: `name=${name}&age=${age}`, - ``은 2015년 이후, ajax는 더 전ㅇ에 나옴
				data: {
					name: name,
					age: age
				},
				success: function(data){
					$('#debug').val(data.trim())
				}, error: function(error){
					alert('오류상태코드 : '+error.status)
				}
		
			})
		})
	})
</script>
</head>
<body>
	<textarea rows="10" cols="80" id="debug"></textarea><br>
	<!-- 입력한 이름, 나이를 param.jsp로 전달 -->
	이름 : <input type="text" name="name" id="name"><br>
	나이 : <input type="text" name="age" id="age"><br>
	<button>호출</button>
</body>
</html>