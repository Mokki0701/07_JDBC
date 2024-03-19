<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판 메인</title>
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

        <form action="/board/create"><button>글쓰기</button></form>
    
    </table>

    <form action="/board/search">
        <select name="selectOption">
            <option value="1">제목만</option>
            <option value="2">내용만</option>
            <option value="3">제목+내용</option>
        </select>
         : <input type="text" name="boardName">
        <button>검색</button>
    </form>

    <form action="/board/member"><button>개인 정보 조회</button></form>

    <c:if test="${not empty message}" >
        <script>
            alert("${message}")
        </script>

        <c:remove var="message"/>
    </c:if>
    <form action="/board/logout"><button class="logout-btn">로그아웃</button></form>



<script src="/resources/js/logout.js"></script>
</body>
</html>