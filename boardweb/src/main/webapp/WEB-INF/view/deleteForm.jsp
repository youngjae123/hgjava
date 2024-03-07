<%@page import="co.yedam.board.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <h3>글 삭제</h3>
  <%
    Board board = (Board) request.getAttribute("board");
  %>
  <form action="removeBoard.do">
    <input type="hidden" value="<%=board.getBoardNo() %>" name="bno">
    <table class="table">
      <tr>
        <th>글번호</th>
        <td><%=board.getBoardNo() %></td>
      </tr>
      <tr>
        <th>제목</th>
        <td><%=board.getTitle() %></td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <button type="submit" class="btn btn-danger">삭제</button>
          <button type="reset" class="btn btn-secondary">취소</button>
        </td>
      </tr>
    </table>
  </form>
