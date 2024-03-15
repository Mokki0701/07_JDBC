<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <table border="1">
		
		<thead>
			<tr>
				<th>순차</th>
				<th>번호</th>
				<th>이름</th>
				<th>전화번호</th>
                <th>부서명</th>
                <th>층</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${person}" var="dept" varStatus="vs">
				
				<tr>
					<%-- vs.count : 현재 반복 횟수 (1부터 시작) --%>
					<td>${vs.count}</td>
					<td>${dept.empId}</td>					
					<td>${dept.empName}</td>
					<td>${dept.phone}</td>
					<td>${dept.deptTitle}</td>
					<td>${dept.locationId}</td>
					
				</tr>
				
			</c:forEach>
		</tbody>
		
	
	
	</table>


</body>
</html>