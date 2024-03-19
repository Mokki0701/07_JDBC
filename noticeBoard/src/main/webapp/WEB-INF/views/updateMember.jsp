<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>html문서 제목</title>
</head>
<body>
    <form action="/board/updateMember">
        <div>
            ID : <input type="text" name="boardId" placeholder="${member.boardId}">
            PW : <input type="text" name="boardPw" placeholder="${member.boardPw}">
            이름 : <input type="text" name="boardName" placeholder="${member.boardName}">
            주민번호 : <input type="text" name="securityNum" placeholder="${member.securityNum}">
            주소 : <input type="text" name="address" placeholder="${member.address}">
            전화번호 : <input type="number" name="memberNum" placeholder="${member.memberNum}">
        </div>

        <button>정보 수정</button>
    
    </form>
</body>
</html>