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
		$.ajax({
			url: 'person.jsp',
			datatype: 'json',
			success: function(data) {
				console.log(typeof data)
				memberList=eval(data) // 배열로 인식하게 만들어줌
				console.log(memberList)
				//memberList=JSON.parse(data)
			}, error: function(error) {
				alert('오류상태코드 : '+error.status)
			}
		})
	})
</script>
</head>
<body>

</body>
</html>