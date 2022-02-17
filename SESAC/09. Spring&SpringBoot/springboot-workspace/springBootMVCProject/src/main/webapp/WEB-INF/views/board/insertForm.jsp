<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<style>
h1 {
	text-align: center;
}
</style>
</head>
<body>
	<hr>
	<h1>게시글 등록하기</h1>
	<hr>
	<form action="insert" method="post">

		<div class="form-group">
			<label for="title">TITLE:</label> <input type="text"
				class="form-control" id="title" name="title" placeholder="제목을 입력하세요"
				required="required">
		</div>
		<div class="form-group">
			<label for="writer">Writer:</label> <input type="text"
				class="form-control" id="writer" name="writer"
				placeholder="글쓴이를 입력하세요" required="required">
		</div>
		<div class="form-group">
			<label for="content">Content:</label> <input type="text"
				class="form-control" id="content" name="content"
				placeholder="내용을 입력하세요" required="required">
		</div>
		<div class="form-group">
			<input type="submit" value="등록하기">
		</div>
	</form>
</body>
</html>