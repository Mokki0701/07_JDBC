package edu.kh.dept.model.exception;

public class DepartmentDeleteException extends RuntimeException {
	
	public DepartmentDeleteException() {
		
		super("부서 삭제(DELETE) 중 예외 발생");
	
	}
	
	public DepartmentDeleteException(String message) {
		super(message);
	}

}
