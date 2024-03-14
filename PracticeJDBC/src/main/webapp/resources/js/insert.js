const addBtn = document.querySelector("#addBtn");

const tbody = document.querySelector("#tbody");

addBtn.addEventListener("click", ()=>{

    const tr = document.createElement("tr");

    const names = ['deptId', 'deptTitle', 'locationId'];

    for(let name of names){
        const td = document.createElement("td");

        const input = document.createElement("input");

        input.type = "text";
        input.name = name;

        td.append(input);
        tr.append(td);

    }

    const th = document.createElement("th");
    const button = document.createElement("button");

    button.type = "button";
    button.classList.add("remove-btn");
    button.innerText="삭제";

    button.addEventListener("click", removeFn);

    th.append(button);
    tr.append(th);

    tbody.append(tr);

});

function removeFn(e){

    const tr = e.target.parentElement.parentElement;
    tr.remove();

}

document.querySelector(".remove-btn").addEventListener("click",removeFn);










