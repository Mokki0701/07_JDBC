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
    
    <form action="/board/create" method="POST">
        <div>
            제목 : <input type="text" name="boardTitle">
        </div>
        <div>
            작성자 : <input type="text" name="boardId" value="${boardId}" readonly>
        </div>
        <div>
            <textarea name="boardText" cols="50" rows="5" placeholder="상세 내용"></textarea>
        </div>

        <input type="hidden" name="todoNo" value="${param.todoNo}">

        <div>
            <button>글 생성</button>
        </div>

    </form>

     <c:if test="${not empty message}">
        <script>
            alert("${message}")
        </script>

        <c:remove var="message"/>
    </c:if>
</body>
</html>