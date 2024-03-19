<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>html문서 제목</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>아이디</th>
            <th>${member.boardId}</th>
        </tr>
        <tr>
            <th>패스워드</th>
            <th>${member.boardPw}</th>
        </tr>

        <tr>
            <th>이름</th>
            <td>${member.boardName}</td>
        </tr>

        <tr>
            <th>주소</th>
            <td>${member.address}</td>
        </tr>
        <tr>
            <th>전화번호</th>
            <td>${member.memberNum}</td>
        </tr>
        <tr>
            <th>닉네임</th>
            <td>${member.nickname}</td>
        </tr>
    </table>

    <form action="/board/memberBoardDetail"><button>게시글 상세 조회</button></form>
    <form action="/board/updateMember" method="POST"><button>개인 정보 수정</button></form>
    <form action="/board/logout"><button class="logout-btn">로그아웃</button></form>

<script src="/resources/js/logout.js"></script>
</body>
</html>