<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function(){
		/*
		let pTags = document.getElementsByTagName("p");
		let html = pTags[0].innerHTML
		let text = pTags[0].innerText
		*/
		let html = $('p#p01').html() // 추출된 html 1개 가져옴
		let text = $('p#p01').text() // 추출된 모든 text 다 가져옴
		alert('추출된 html : '+html+'\n추출된 text : '+text)
		
		let aTag = document.getElementsByTagName("a")[0]
		
		// a태그 속성값 가져오기 - javascript
		//let href = aTag.href
		//let href = aTag.getAttribute('href')
		
		// 속성값 가져오기 - jquery
		let href = $('a').attr('href')
		alert('추출된 href : '+href)
		
		$('button').click(function() {
			
			// input 값 받아오기 - javascript
			//let inputTag = document.getElementById("name")
			//let name = intputTag.value
			
			// input태그 입력된 값 가져오기 - jquery
			let name = $('#name').val()
			alert('입력된 이름 : '+name)
		})
	})
</script>
</head>
<body>
	<p id="p01">내 이름은 <b>홍길동</b>이고, 별명은 <i>의적</i>입니다</p>
	<p>내 이름은 <strong>홍길순</strong>이고, 별명은 <em>의적2</em>입니다</p>
	<a href="http://www.naver.com">네이버</a><br>
	이름 : <input type="text" name="name" id="name">
	<button>입력완료</button>
</body>
</html>