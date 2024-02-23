<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../includes/header.jsp"></jsp:include>
  <c:set var="msg" valute="hello" />
    <p>message: <c:out value="${msg }"></c:out></p>
  <c:if test="$msg == hello">
   <p>참입니다.</p>
  </c:if>

  <c:choose>
      <c:when test="${msg == 'hello' }">
        <p>참입니다.</p>
      </c:when>
    <c:otherwise>
      <p>거짓입니다.</p>
    </c:otherwise>
  </c:choose>

  <!-- for(int i =1; i<=5; i++){} -->
  <c:forEach begin="1" end="5" var="i">
    <p>${i }</p>
  </c:forEach>
  
<jsp:include page="../includes/footer.jsp"></jsp:include>
