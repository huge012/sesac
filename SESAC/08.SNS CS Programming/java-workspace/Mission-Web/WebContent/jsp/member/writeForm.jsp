<%--
	회원가입 창
	입력받아야 할 정보
	- 아이디, 이름, 패스워드, 이메일, 도메인, 폰1, 폰2, 폰3, 우편번호, 기본 주소, 상세 주소

 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Mission-Web/css/layout.css">
<link rel="stylesheet" href="/Mission-Web/css/board.css">
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	function doWrite(){
		let f = document.inputForm
		
		if (f.id.value == "") {
			alert("아이디를 입력해주세요")
			f.id.focus()
			return false
		}
		if (f.password.value == "") {
			alert("비밀번호를 입력해주세요")
			f.password.focus()
			return false
		}
		if (f.name.value == "") {
			alert("이름을 입력해주세요")
			f.name.focus()
			return false
		}
		
		return true
	}
	
	$(document).ready(function(){
		$('#check').click(function() {
			$.ajax({
				type: "get",
				url: "checkId.jsp",
				data: "id=" + $('#id').val(),
				success: function(data){
					if (data.trim() == 'true')
						alert('이미 존재하는 아이디입니다.')
					else
						alert('사용할 수 있는 아이디입니다.')
				}, error: function() {
					alert('실패')
				}
			})
		})
	})
	
</script>
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp" />
	</header>
	
	<section>
		<div align="center">
		<hr>
		<h2>회원가입</h2>
		<hr>
		<form action="write.jsp" method="post" name="inputForm" onsubmit="return doWrite()">
			<table border="1">
				<tr>
					<th width="25%">* ID</th>
					<td width="75%"><input type="text" id="id" name="id">  <button type="button" id="check">중복확인</button></td>
				</tr>
				<tr>
					<th>* PASSWORD</th>
					<td><input type="text" name="password"></td>
				</tr>
				<tr>
					<th>* 이 름 </th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" class="email" name="email_id">@<input type="text" class="email" name="email_domain"></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text" class="tel" name="tel1">-<input type="text" class="tel" name="tel2">-<input type="text" class="tel" name="tel3"></td>
				</tr>
				<tr>
					<th>우편번호</th>
					<td><input type="text" name="post"></td>
				</tr>
				<tr>
					<th>기본 주소</th>
					<td><input type="text" name="basic_addr"></td>
				</tr>
				<tr>
					<th>상세 주소</th>
					<td><input type="text" name="detail_addr"></td>
				</tr>
			
			</table>
			<br>
			<input type="submit" value="등록" id="submit">
		</form>
	</div>
	</section>
	
	<footer>
		<%@include file="/jsp/include/footer.jsp" %>
	</footer>
</body>
</html>