<%@page import="co.yedam.board.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<c:set var = "msg" value ="hello" />
<p> message: <c:out value = "${msg }"></c:out></p> <!-- msg라는 변수의 값을 읽어온다. -->

<c:if test = "${msg == 'hello' }">
<p>참 입니다</p>
</c:if>

<c:choose>
<c:when test="${msg == 'hello' }">
<p>참입니다.</p>
</c:when>
</c:choose>

<jsp:include page="../includes/header.jsp"></jsp:include>



<%
Board board = (Board) request.getAttribute("board");
//board라는 어트리뷰트의 값을 읽어옴.	
// req.setAttribute("board", board);
// BoardControl <
%>
<h3>상세조회</h3>
	<form action="updateForm.do">
	<input type="hidden" value="<%=board.getBoardNo()%>" name="bno">
	<!-- "hidden" 안보이게.  -->
		<!-- action -> 누르면 해당되는 곳으로 이동 = updateForm.do -->
		<!-- 값들을 넘기기 위한 목적. -->
	
		<table class="table">
			<tr>
				<th>글번호</th>
				<td><%=board.getBoardNo()%></td>
				<th>조회수</th>
				<td><%=board.getViewCnt()%></td>
			</tr>
			<tr>
				<th colspan="2">글제목</th>
				<td colspan="2"><%=board.getTitle()%></td>
			</tr>
			<tr>
				<td colspan="4"><%=board.getContent()%></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%=board.getWriter()%></td>
				<th>작성일시</th>
				<td><%=board.getCreateDate()%></td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<!-- 줄 수를 맞추기 위해 혼자 4 -->
					<button type="submit" class="btn btn-outline-dark">수정</button> <!-- submit -> 폼 데이터를 전송하기 위함. -->
					<button type="button" class="btn btn-outline-dark" onclick = "removeFunc()">삭제</button>
					
				</td>
			</tr>
		</table>
	</form>
<jsp:include page="../includes/footer.jsp"></jsp:include>

<!-- action은 하나인데 버튼은 두개라서 각각 만듦. -->
<script>
	function removeFunc() {
		//let dom > 변수
		let form = document.querySelector('form'); // document 영역 querySelector() 선택 ('form') -> form을 찾아옴
		console.log(form.action); 
		form.action = 'removeForm.do';
		form.submit() ; // submit() 을 호출.
		form.action = 'updateForm.do';
	}
</script>