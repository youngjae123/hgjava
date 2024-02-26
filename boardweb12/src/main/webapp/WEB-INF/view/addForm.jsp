<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="../includes/header.jsp"></jsp:include>

<h3>등록화면</h3>
<form action="addBoard.do" method="post">
	<table class="table">
		<tr>
			<th>제목</th>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea class="form-control" name="content"></textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer" value="${logid }" readonly></td>
		</tr>
		<tr>
			<td align="center" colspan="2">
				<button type="submit" class="btn btn-primary">등록</button>
				<button type="reset" class="btn btn-secondary">취소</button>
			</td>
		</tr>
	</table>
</form>

<jsp:include page="../includes/footer.jsp"></jsp:include>