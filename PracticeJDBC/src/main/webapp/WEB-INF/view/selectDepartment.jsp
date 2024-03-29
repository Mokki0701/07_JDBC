<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%-- JSTL Core 라이브러리 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>검색 부서 조회</h1>
	
	<table border="1">
		
		<thead>
			<tr>
				<th>행 번호</th>
				<th>부서 코드(DEPT_ID)</th>
				<th>부서 명(DEPT_TITLE)</th>
				<th>지역 코드(LOCATION_ID)</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${deptList}" var="dept" varStatus="vs">
				
				<tr>
					<%-- vs.count : 현재 반복 횟수 (1부터 시작) --%>
					<td>${vs.count}</td>
					<td>${dept.deptId}</td>					
					<td>${dept.deptTitle}</td>
					<td>${dept.locationId}</td>
				</tr>
				
			</c:forEach>
		</tbody>
		
	
	
	</table>



</body>
</html>