<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>html문서 제목</title>
</head>
<body>
    <table border="1" style="border-collapse: collapse">

        <thead>
            <th>번호</th>
            <th>닉네임</th>
            <th>제목</th>
            <th>등록 날짜</th>
            <th>작성자 아이디</th>
        </thead>

        <tbody>
            <c:forEach items="${boardList}" var="board">
                <tr>
                    <td>${board.boardNo}</td> 
                    <td>${board.nickname}</td>
                    <td><a href="/board/detail?boardNo=${board.boardNo}">${board.boardTitle}</a></td> 
                    <td>${board.regdate}</td>
                    <td>${board.memberId}</td>  
                </tr>
            </c:forEach>
            <%-- DB 조회 결과를 이용해서 화면 출력 --%>

        </tbody>
    </table>
    <h1>${boardId}</h1>
    <form action="/board/logout"><button class="logout-btn">로그아웃</button></form>

</body>
</html>