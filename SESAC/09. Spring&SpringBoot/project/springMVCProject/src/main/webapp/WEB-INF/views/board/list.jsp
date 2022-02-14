<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href="${ pageContext.request.contextPath }/resources/css/layout.css" >
<link rel = "stylesheet" href="${ pageContext.request.contextPath }/resources/css/board.css" >
<style>
	h6#boardCnt {
		float : right;
		margin : 2px;
		padding : 0;
	}
</style>
<script src="${ pageContext.request.contextPath }/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
   
   $(document).ready(function() {
		$('#insertBtn').click(function() {
			location.href = "${pageContext.request.contextPath}/board/writeForm.do"
		})
      
		// 이벤트핸들러 - click과 그 뒤 함수를 연결시켜줌
		$('#search').on('click', function(){
			var mydata = {
    			  "keyword":$('#keyword').val(),
    			  "contents":$('#contents').val()
    		};
			console.log(mydata);
			//alert("keyword : "+mydata.keyword+"\ncontents : "+mydata.contents)
			
			// 서버에 다녀오기 (화면 이동 없이 이 자리로 돌아온다)
			// list.do?keyword=title&contents=aa
			$.ajax({
				url:"list.do", // 이동할 url
				data:mydata, // 이동할 때 가져갈 데이터
				success: function(responseData){
					alert("다녀옴" + responseData)
					$('#here').html(responseData);
				} // 성공하면 해당 함수 실행
			});
		});
	})
   
	function doAction(boardNo){
		location.href = '${ pageContext.request.contextPath }/board/detail.do?no='+boardNo
		/* <c:choose>
			<c:when test="${ not empty userVO }">
				location.href = '${ pageContext.request.contextPath }/board/detail.do?no='+boardNo
                     
		</c:when>
			<c:otherwise>
				if(confirm('로그인 서비스가 필요합니다\n로그인페이지로 이동하시겠습니까?')){
					location.href = '${ pageContext.request.contextPath }/login.do'
				}
			</c:otherwise>
		</c:choose> */
	}
</script>
</head>
<body>
   <header>
     <%--  <jsp:include page="/jsp/include/topMenu.jsp" />  --%>
   </header>
   <section>
      <div align="center">
      <a href="${ pageContext.request.contextPath }/login/login.do" id="login">로그인하기</a>
      <a href="${ pageContext.request.contextPath }/member/list.do" id="memberList">회원 목록</a>
      <hr>
      <h6></h6>
      <h2>게시판 목록 ${ msg }</h2>
      <h6 id="boardCnt">전체 게시글 : ${ boardCnt }</h6>
      <hr>
      검색조건 : 
      <select id="keyword">
      	<option value="title" selected="selected">타이틀</option>
      	<option value="writer">글쓴이</option>
      </select>
      <input type="text" id="contents" placeholder="입력하세요">
      <button type="button" id="search">검색</button>
      <hr>
      <br>
      <div id="here">
	      <table border = "1" class="list">
	         <tr>
	            <th width="7%">번호</th>
	            <th>제목</th>
	            <th width = "16%">글쓴이</th>
	            <th width = "10%">조회수</th>
	            <th width = "20%">등록일</th>
	         </tr>
	       
	      <c:forEach items="${ list }" var="board" varStatus="bstatus">
	       <tr>
	          <td>${ boardCnt-bstatus.count+1 }</td>
	          <td>
	             <a href="javascript:doAction(${ board.no })">
	                <c:out value="${ board.title }" />
	             </a>
	             
	          </td>
	          <td>${ board.writer }</td>
	          <td>${ board.viewCnt }</td>
	          <td>${ board.regDate }</td>
	       </tr>
	      </c:forEach>
	      </table>
      </div>
      <br>
      <%--<c:if test="${ not empty userVO }"> --%>

      <button id="insertBtn">새글등록</button>
      
      <%--</c:if> --%>
   </div>   
   </section>    
   <footer>
     <%-- <%@ include file="/jsp/include/footer.jsp" %> --%>
   </footer>   
</body>
</html>

