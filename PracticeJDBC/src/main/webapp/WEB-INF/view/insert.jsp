<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	
		<form action="/department/insert" method="POST">
		
		<div>
			부서 코드 : <input type = "text" name = "deptId">
		</div>
		<div>
			부서 명 : <input type = "text" name = "deptTitle">
		</div>
		<div>
			지역 코드 : <input type = "text" name = "locationId">
		</div>	
		
		<button>추가</button>
	
	</form>


</body>
</html>