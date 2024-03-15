// 목록으로 버튼 동작
const goToList = document.querySelector("#goToList");

goToList.addEventListener("click",()=>{
    location.href="/"; // 메인 페이지 요청
});

// 완료 여부 변경 버튼 클릭 시
const completeBtn = document.querySelector(".complete-btn");

completeBtn.addEventListener("click",e=>{

    // 요소.dataset : data-* 속성에 저장된 값 반환(객체)
    // data-todo-set 속성의 속성 값을 얻어오기
    const todoNo = e.target.dataset.todoNo;

    let complete = e.target.innerText; // 기존 완료 여부 값 얻어오기

    // Y <-> N 변경
    complete = (complete === 'Y') ? 'N' : 'Y';

    // 완료 여부 수정 요청하기
    location.href = `/todo/changeComplete?todoNo=${todoNo}&complete=${complete}`;
});

// ----------------------------------------------------------------

const updateBtn = document.querySelector("#updateBtn");

updateBtn.addEventListener("click", e=>{

    // data-todo-no="${todo.todoNo}" 얻어오기
    const todoNo = e.target.dataset.todoNo;

    location.href=`/todo/update?todoNo=${todoNo}`;
});

// --------------------------------------------------------------

const deleteBtn = document.querySelector("#deleteBtn");

deleteBtn.addEventListener("click", e=>{

    const todoNo = e.target.dataset.todoNo;

    if(confirm("삭제 하시겠습니까?")){
        const form = document.createElement("form");
        form.action = "/todo/delete";
        form.method = "POST";
        console.log(form); 

        const input = document.createElement("input");
        input.type = "hidden";
        input.value = todoNo; 
        input.name = "todoNo"; 

        form.append(input);

        document.querySelector("body").append(form);
        
        form.submit();
    
    }else{
        alert("삭제 취소");
    }




});










