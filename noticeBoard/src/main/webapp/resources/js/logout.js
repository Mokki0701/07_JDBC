const logoutBtn = document.querySelector(".logout-btn");

logoutBtn.addEventListener("click", e=>{

    if(sessionStorage.getItem("boardId") !== null){

        sessionStorage.removeItem("boardId");
        location.href="/?message=로그아웃";
    }
    
})

