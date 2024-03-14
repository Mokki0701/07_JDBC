const deleteBtnList = document.querySelectorAll(".delete-btn");

for(let btn of deleteBtnList){

    btn.addEventListener("click", e=>{

        const deptId = e.target.closest("tr").children[1].innerText;

        if(confirm(`${deptId} 부서를 정말 삭제 하시겠습니까?`)){

            const form = document.createElement("form");
            form.action = "/department/delete";
            form.method = "POST";
            console.log(form); 

            const input = document.createElement("input");
            input.type = "hidden";
            input.value = deptId; 
            input.name = "deptId"; 

            form.append(input);
            
            document.querySelector("body").append(form);
            
            form.submit();
        }else{
            alert("삭제 취소");
        }



    })





}

const updateBtnList = document.querySelectorAll(".update-btn");

updateBtnList.forEach( (btn, index) => {

    btn.addEventListener("click", e=>{

        const tr = e.target.closest("tr");

        const deptId = tr.children[1].innerText;

        location.href = "/department/update?deptId=" + deptId;

    })



} );