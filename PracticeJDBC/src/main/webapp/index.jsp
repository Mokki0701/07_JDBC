<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>html문서 제목</title>
</head>
<body>
    <ul>
        <li>

            <a href="/department/selectAll">부서 전체 조회</a>

        </li>

        <li>

            <a href="/department/insert">부서 추가</a>

        </li>

    </ul>
    
    <hr>

    <h3>부서명으로 검색(검색어가 포함된 부서 모두 조회)</h3>

    <form action="/department/search" method="GET">
        검색어 입력 :
        <input type="text" name="keyword" >
        
        <button>검색</button>
    </form>

    <h1>${message}</h1>

    <h3>부서명으로 검색하여 직원 조회</h3>

    <form action="/deaprtment/employee" method="GET">
        검색어 입력 :
        <input type="text" name="employee">

        <button>조회</button>
    
    </form>
</body>
</html>