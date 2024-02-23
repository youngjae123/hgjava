<%@page import="co.yedam.board.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>

<%
  Board board = (Board) request.getAttribute("board");
%>
  <h3>글 수정</h3>
  <form action="modifyBoard.do">
    <input type="hidden" value="<%=board.getBoardNo() %>" name="bno">
    <table class="table">
     <tr>
       <th>글번호</th>
       <td><%=board.getBoardNo() %></td>
       <th>조회수</th>
       <td><%=board.getViewCnt() %></td>
     </tr>
     <tr>
       <th >글제목</th>   
       <td colspan="3"><input class="from-control" type ="text" name="title" value="<%=board.getTitle() %>"></td>
     </tr>
     <tr>
       <th>글내용</th>
       <td colspan="4"><textarea name="content" ><%=board.getContent() %></textarea></td>
     </tr>
     <tr>
       <th>작성자</th><td><%=board.getWriter() %></td>
       <th>작성일</th><td><%=board.getCreateDate() %></td>
     </tr>
     <tr>
       <td colspan="4" align="center">
        <button type="submit" class="btn btn-primary">저장</button>
        <button type="reset" class="btn btn-secondary">취소</button>
       </td>
     </tr>
    </table>
  </form>

<jsp:include page="../includes/footer.jsp"></jsp:include>
