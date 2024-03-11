<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>

<body>
	<!-- 2024년 3월 달력 출력. 테이블 형식으로 달력보여주기 -->
	<div id="show"></div>
	<table border=1>
		<thead>
			<tr>
				<th>일</th>
				<th>월</th>
				<th>화</th>
				<th>수</th>
				<th>목</th>
				<th>금</th>
				<th>토</th>
			</tr>
		</thead>
		<tbody>

		</tbody>
	</table>
	<script>
    const calendar = {
      show() {
    	  let date = new Date();
    	  
    	  let year = date.getFullYear();
    	  let month = date.getMonth();
    	  console.log(year);
    	  console.log(month);
    	  
    	  // 시작 요일
    	  let fday = new Date(year, month, 1);
    	  console.log(fday);
    	  // 달 일수
    	  let lday = new Date(year, month+1, 0);
    	  console.log(lday);
    	  
    	  let tr = $('<tr />');
    	  for(let i = 0; i < fday.getDay(); ++i){
    		  tr.append($('<td />'));

    		  for(let i = 1; i<= lday.getDay(); ++i){
    		    let td = $('<td />').text(i)
    		    tr.append(td)
    		  
    	  }
    	  }
    	  
    	  
    	  
    	  
      }
    }
    calendar.show();
    
  </script>
</body>

</html>