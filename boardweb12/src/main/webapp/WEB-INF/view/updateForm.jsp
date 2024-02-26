<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="co.yedam.board.Board"%>




<%
Board board = (Board) request.getAttribute("board");
//board라는 어트리뷰트의 값을 읽어옴.	
// req.setAttribute("board", board);
// BoardControl <
%>
<h3>글 수정</h3>
	<form action="modifyBoard.do">

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
				<th>글제목</th>
				<td colspan="3"><input class ="form-control" type = "text" name = "title" value ="<%=board.getTitle()%>"></td>
			</tr>	<!-- class ="form-control" input태그의 스타일 -->	<!-- name = "title" 바뀐 값 저장하기 위함. -->
			<tr>
				<th >내용</th>
				<td colspan="3"><textarea class ="form-control" name ="content" ><%=board.getContent()%></textarea></td>
			</tr>							<!-- name = "content" 바뀐 값 저장하기 위함. -->
			<tr>
				<th>작성자</th><td><%=board.getWriter()%></td>
				<th>작성일시</th><td><%=board.getCreateDate()%></td>
			</tr>
			
			<tr>
				<td colspan="4" align="center">
					<!-- 줄 수를 맞추기 위해 혼자 4 -->
					<button type="submit" class="btn btn-primary" ${board.writer eq logid ? '' : 'disabled' } >저장</button> <!-- submit -> 폼 데이터를 전송하기 위함. -->
					<button type="reset" class="btn btn-warning" ${board.writer eq logid ? '' : 'disabled' } >취소</button>
								<!-- 내용 초기화 -->
				</td>
			</tr>
	
	
	
		</table>
	</form>
