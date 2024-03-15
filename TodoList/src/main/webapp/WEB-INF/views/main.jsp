<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Todo List</title>
</head>
<body>
    <h1>Todo List</h1> 
    <hr>

    <%-- 
        1. input태그랑 버튼 추가하고 input 태그 값을 받을 name값 설정
        2. POST방식으로 Servlet 만들어서 보내고,
        3. 거기서 받아서 INSERT를 해야하니까 int를 반환 받는 메서드를 서비스에서 만들고, (DML이기 때문에 트랜잭션 처리 해주고),
        4. DAO 메서드를 이용해서 DB에 데이터 INSERT 해준다.
        5. 그리고 다시 Servlet으로 int 값 반환 받아서 뭐 이건 이제 수업 내용대로
     --%>

    <form action="/todo/add" method="POST">
        <h4>할 일 추가</h4>

        <div>
            제목 : <input type="text" name="todoTitle">
        </div>

        <div>
            <textarea name="todoContent" cols="50" rows="5" placeholder="상세 내용"></textarea>
        </div>

        <div>
            <button>추가 하기</button>
        </div>

    </form>

    <hr>

    <%-- ${fn:length(문자열|컬렉션)} : 문자열, 컬렉션 길이 반환 --%>
    <h3>전체 Todo 개수 : ${fn:length(todoList)}개 / 완료된 Todo 개수 : ${completeCount}개</h3>

    <table border="1" style="border-collapse: collapse">

        <thead>
            <th>번호</th>
            <th>할 일 제목</th>
            <th>완료 여부</th>
            <th>등록 날짜</th>
        </thead>

        <tbody>
            <c:forEach items="${todoList}" var="todo">
                <tr>
                    <td>${todo.todoNo}</td> 
                    <td>
                        <a href="/todo/detail?todoNo=${todo.todoNo}">${todo.todoTitle}</a>
                    </td>
                    <td>${todo.complete}</td> 
                    <td>${todo.regDate}</td>  
                </tr>
            </c:forEach>
            <%-- DB 조회 결과를 이용해서 화면 출력 --%>

        </tbody>
    
    </table>

    <c:if test="${not empty message}" >
        <script>
            alert("${message}")
        </script>

        <c:remove var="message"/>
    </c:if>
    
























































</body>
</html>