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
	<!-- data/data.json -> object변경. 20건 중에서 Female, 4000이상.. -->
	<!-- targetAry 에 담고 출력. -->
	<script>

fetch("data/data.json")
.then((object)=> object.json())
.then((data) =>{
  const targetAry = Array.from(data);
  targetAry.filter(item => {
	  let ary = (item.gender == 'Female'&& item.salary > 4000);
	  if(ary){
		  console.log('first_name= ' + item.first_name);
	  }
  })
	 })


</script>
</body>
</html>