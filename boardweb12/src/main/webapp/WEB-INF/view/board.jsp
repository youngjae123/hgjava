<%@page import="co.yedam.board.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<!-- jspl을 사용하기 위함. -> 을 사용가능하게 함. -->
<!-- boardControl의 req.setAttribute("board", board); 의 값을 넘겨움.-->
<!-- board객체의 값을 "board"에 담은 것을 "board"(이름). board(값)-->

<jsp:include page="../includes/header.jsp"></jsp:include>

<h3>상세조회</h3>
	<form action="updateForm.do">
	<input type="hidden" value="${board.boardNo}" name="bno">
	<!-- "hidden" 안보이게.  -->
	<!-- action -> 누르면 해당되는 곳으로 이동 = updateForm.do -->
	<!-- 값들을 넘기기 위한 목적. -->

		<table class="table">
			<tr>
				<th>글번호</th>
				<td>${board.boardNo}</td>
				<th>조회수</th>
				<td>${board.viewCnt}></td>
			</tr>
			<tr>
				<th colspan="2">글제목</th>
				<td colspan="2">${board.title}></td>
			</tr>
			<tr>
				<td colspan="4">${board.content}></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${board.writer}</td>
				<th>작성일시</th>
				<td>${board.createDate}</td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<!-- 줄 수를 맞추기 위해 혼자 4 -->
					<!-- 작성자와 로그인 아이디와 같으면 수정,삭제.. x= > 비활성화 (disabled) -->
					<c:choose>  
					<c:when test="${board.writer eq logid } ">
					<button type="submit" class="btn btn-outline-dark">수정</button> <!-- submit -> 폼 데이터를 전송하기 위함. -->
					<button type="button" class="btn btn-outline-dark" onclick = "removeFunc()">삭제</button>
					</c:when>
					<c:otherwise>
					<button type="submit" class="btn btn-outline-dark" disabled>수정</button> <!-- submit -> 폼 데이터를 전송하기 위함. -->
					<button type="button" class="btn btn-outline-dark" disabled onclick = "removeFunc()">삭제</button>
					</c:otherwise>
					</c:choose>
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