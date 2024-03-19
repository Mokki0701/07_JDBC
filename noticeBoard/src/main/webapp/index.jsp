<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메인 로그인 페이지</title>
</head>
<body>

    <form action="/board/main" method="GET">
        <div>
            ID : <input type="text" name="boardId">
            PW : <input type="password" name="boardPw">
            <button>로그인</button>
        </div>
    </form>

    <form action="/board/join" method="GET">
        <button>회원가입</button>
    </form>

    <c:if test="${not empty message}" >
        <script>
            alert("${message}")
        </script>

        <c:remove var="message"/>
    </c:if>

    <c:if test="${not empty logoutMessage}" >
        <script>
            alert("${logoutMessage}")
        </script>

        <c:remove var="logoutMessage"/>
    </c:if>

    
</body>
</html>