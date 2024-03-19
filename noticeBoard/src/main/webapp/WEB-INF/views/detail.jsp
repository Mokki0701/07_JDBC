<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>html문서 제목</title>
</head>
<style>
    table{
        border-collapse : collapse;
    }

    .todo-content{
        /* pre태그 처럼 처리 == HTML에 작성된 모양 그대로 화면에 출력 */
        while-space : pre-wrap;
    }
</style>
<body>

    <table border="1">
        <tr>
            <th>번호</th>
            <th>${board.boardNo}</th>
        </tr>
        <tr>
            <th>등록 날짜</th>
            <th>${board.regdate}</th>
        </tr>

        <tr>
            <th>등록자</th>
            <td>${board.nickname}</td>
        </tr>

        <tr>
            <th>내용</th>
            <td>${board.boardText}</td>
        </tr>
    </table>

     <c:if test="${not empty message}" >
        <script>
            alert("${message}")
        </script>

        <c:remove var="message"/>
    </c:if>

    <form action="/board/logout"><button class="logout-btn">로그아웃</button></form>
    
</body>
</html>