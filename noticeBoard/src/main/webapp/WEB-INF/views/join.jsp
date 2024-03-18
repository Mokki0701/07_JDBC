<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 가입</title>
</head>
<body>

    <form action="/board/join" method="POST">
        <div>
            ID : <input type="text" name="boardId">
            PW : <input type="text" name="boardPw">
            이름 : <input type="text" name="boardName">
            주민번호 : <input type="text" name="securityNum">
            주소 : <input type="text" name="address">
            전화번호 : <input type="number" name="memberNum">
            닉네임 : <input type="text" name="nickname">
        </div>

        <button>회원 가입</button>
    
    </form>


    <c:if test="${not empty message}" >
        <script>
            alert("${message}")
        </script>

        <c:remove var="message"/>
    </c:if>
    




</body>
</html>