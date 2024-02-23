<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../includes/header.jsp"></jsp:include>
  <h3>상세조회</h3>
  <form action="updateForm.do">
    <input type="hidden" value="${board.boardNo }" name="bno">
    <table class="table">
     <tr>
       <th>글번호</th>
       <td>${board.boardNo }</td>
       <th>조회수</th>
       <td>${board.viewCnt }%></td>
     </tr>
     <tr>
       <th colspan="2">글제목</th>   
       <td colspan="2">${board.title }</td>
     </tr>
     <tr>
       <td colspan="4">${board.content }</td>
     </tr>
     <tr>
       <th>작성자</th><td>${board.writer }</td>
       <th>작성일</th><td>${board.createDate }</td>
     </tr>
     <tr>
       <td colspan="4" align="center">
        <button type="submit" class="btn btn-primary">수정</button>
        <button type="button" class="btn btn-warning" onclick="removeFunc()">삭제</button>
       </td>
     </tr>
    </table>
  </form>
<jsp:include page="../includes/footer.jsp"></jsp:include>

  <script>
    function removeFunc(){
    	let form = document.querySelector('form');
    	console.log(form.action);
    	form.action = 'removeForm.do';
    	form.submit();
    }
  </script>
