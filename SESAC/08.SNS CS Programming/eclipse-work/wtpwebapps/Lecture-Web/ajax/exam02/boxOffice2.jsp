<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#searchResult {
		width: 70%;
		height: 600px;
		border: 1px solid red;
	}
</style>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function(){
		$('#searchBtn').click(function(){
			$.ajax({
				type: "get", // 기본값이 get
				url: 'http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json',
				data: {
					key : 'd839e693bcdd8ed3b727a1fa2165754c',
					//targetDt: $('#searchDate').val().replace(/\-/g,''),
					targetDt: $('#searchDate').val().split('-').join(''),
					itemPerPage: '5'
				},
				success: callback,
				error: function(){
					alert('실패')
				}
			})
		})
		
		$('#detailBtn').click(function() {
			$.ajax({
				type: "get",
				url: "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json",
				data: {
					key: 'd839e693bcdd8ed3b727a1fa2165754c',
					movieCd: ''					
				},
				success: showDetail,
				error: function(){
					alert('실패')
				}
			})
		}
	})
	
	function showDetail(result){
		alert("showDetal 호출...")
	}
	
	function callback(result){
		$('#searchResult').empty()
		console.log(result.boxOfficeResult.dailyBoxOfficeList)
		let list = result.boxOfficeResult.dailyBoxOfficeList
		for(let movie of list){
			console.log(movie)
			// 순위
			let rank = movie.rank
			// 영화제목
			let title = movie.movieNm
			// 관객수
			let audiCnt = movie.audiCnt
			$('#searchResult').append('<h4>' + rank + '위</h4>')
			$('#searchResult').append('<strong>' + title + '</strong>(' + audiCnt + '명)<br>')
			$('#searchResult').append('<button id="detailBtn">상세보기</button>')
			$('#searchResult').append('<hr>')
			
		}
	}
</script>
</head>
<body>
	<h2>일별 박스오피스 조회서지브</h2>
	검색일 : <input type="date" id="searchDate">
	<button id="searchBtn">조회</button>
	<h3>검색결과</h3>
	<div id="searchResult"></div>
</body>
</html>