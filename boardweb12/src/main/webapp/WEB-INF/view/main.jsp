<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!-- header 파일 불러오기 -->
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>Main Page</h3>

<c:set var="msg" value="hello" />
<p>
	message:
	<c:out value="${msg }"></c:out>
</p>
<!-- msg라는 변수의 값을 읽어온다. -->

<c:if test="${msg == 'hello' }">
	<p>참 입니다</p>
</c:if>

<c:choose>
	<!-- if 조건문 -->
	<c:when test="${msg != 'hello' }">
		<!-- if -->
		<p>참입니다.</p>
	</c:when>
	<c:otherwise>
		<!-- else if -->
		<p>거짓입니다.</p>
	</c:otherwise>
</c:choose>

<!-- for반복문 -->
<c:forEach begin="1" end="5" var="i">
	<!--=int i = 1; int<=5; i++ -->
	<p>${i }</p>
</c:forEach>

<!-- footer 파일 불러오기 -->
<jsp:include page="../includes/footer.jsp"></jsp:include>
