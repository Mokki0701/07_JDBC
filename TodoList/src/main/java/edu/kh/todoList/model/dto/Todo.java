package edu.kh.todoList.model.dto;

public class Todo {
	
	private int todoNo;
	private String todoTitle;
	private String todoContent;
	private String complete;
	private String regDate;
	
	public Todo() {}
	
	// 매개변수 생성자 (할 일 목록 조회)
	public Todo(int todoNo, String todoTitle, String complete, String regDate) {
		super();
		this.todoNo = todoNo;
		this.todoTitle = todoTitle;
		this.complete = complete;
		this.regDate = regDate;
	}



	public int getTodoNo() {
		return todoNo;
	}

	public void setTodoNo(int todoNo) {
		this.todoNo = todoNo;
	}

	public String getTodoTitle() {
		return todoTitle;
	}

	public void setTodoTitle(String todoTitle) {
		this.todoTitle = todoTitle;
	}

	public String getTodoContent() {
		return todoContent;
	}

	public void setTodoContent(String todoContent) {
		this.todoContent = todoContent;
	}

	public String getComplete() {
		return complete;
	}

	public void setComplete(String complete) {
		this.complete = complete;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Todo [todoNo=" + todoNo + ", todoTitle=" + todoTitle + ", todoContent=" + todoContent + ", complete="
				+ complete + ", regDate=" + regDate + "]";
	}
	

}
