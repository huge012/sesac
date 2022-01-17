<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	// {} 객체를 갖겠다는 의미, 자바스크립트 객체(JSON)
	let person = {
			// 변수명 : 값, 변수명 : 값
			// 변수명에는 '' 안붙여도 됨, 특수문자 들어갈 때에는 붙여야함
			'name':'홍길동',
			'phone':'010-1111-2222',
			info : function() {
				alert(this.name+' : '+this.phone)
			}
	}
	
	document.write('이름 : '+person.name+', 번호 : '+person.phone)
	person.info()
</script>
</head>
<body>

</body>
</html>