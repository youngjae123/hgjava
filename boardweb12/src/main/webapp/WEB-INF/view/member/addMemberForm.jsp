<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="../../includes/header.jsp"></jsp:include>
<form action="addMember.do" method="post" enctype="multipart/form-data"></form>
  <table class = "table">
    <tr>
      <th>아이디</th>
      <td><input type="text" name="id" class="form-control" required></td>
    </tr>
    <tr>
      <th>비밀번호</th>
      <td><input type="text" name="pw" class="form-control" required></td>
    </tr>
    <tr>
      <th>이름</th>
      <td><input type="text" name="name" class="form-control" required></td>
    </tr>
    <tr>
      <th>이미지</th>
      <td><input type="file" name="image" class="form-control" required></td>
    </tr>
    <tr>
      <td clspan="2">
        <button type="submit">저장</button>
      </td>
    </tr>
  </table>
</form>

<jsp:include page="../../includes/footer.jsp"></jsp:include>