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
<script src="${ pageContext.request.contextPath }/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
   
   $(document).ready(function() {
      $('button').click(function() {
         location.href = "${pageContext.request.contextPath}/member/signup.do"
      })
   })
   
</script>
</head>
<body>
   <header>
     <%--  <jsp:include page="/jsp/include/topMenu.jsp" />  --%>
   </header>
   <section>
      <div align="center">
      <c:if test="${ empty user }">
      <a href="${ pageContext.request.contextPath }/login/login.do" id="login">로그인하기</a>
      </c:if>
      <c:if test="${ not empty user }">
      <a href="${ pageContext.request.contextPath }/member/detail.do?id=${user.id}" id="login">내 정보</a>
      </c:if>
      <a href="${ pageContext.request.contextPath }/board/list.do" id="boardList">게시글 목록</a>
      <hr>
      <h2>회원 목록 ${ msg }</h2>
      <hr>
      <br>
      <table border = "1" class="list">
         <tr>
            <th width = "15%">아이디</th>
            <th width = "15%">이름</th>
            <th width = "20%">전화번호</th>
            <th width = "20%">이메일</th>
            <th width = "15%">가입일</th>
         </tr>
       
      <c:forEach items="${ list }" var="user">
       <tr>
          <td>${ user.id }</td>
          <td>${ user.name }</td>
          <c:if test='${not empty user.tel1}'>
          	<td>${ user.tel1 }-${ user.tel2 }-${ user.tel3 }</td>
          </c:if>
          <c:if test='${empty user.tel1}'>
          	<td>-</td>
          </c:if>
          <c:if test="${ not empty user.email_id }">
          	<td>${ user.email_id }@${ user.email_domain }</td>
          </c:if>
          <c:if test="${ empty user.email_id }">
          	<td>-</td>
          </c:if>
          <td>${ user.reg_date }</td>
       </tr>
      </c:forEach>
      </table>
      <br>
      <%--<c:if test="${ not empty userVO }"> --%>

      <button>회원가입</button>
      
      <%--</c:if> --%>
   </div>   
   </section>    
   <footer>
     <%-- <%@ include file="/jsp/include/footer.jsp" %> --%>
   </footer>   
</body>
</html>

