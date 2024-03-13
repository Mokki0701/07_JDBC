package practice.dept.exception;

public class PracticeInsertException extends RuntimeException {
	
	public PracticeInsertException() {
	
		super("제약 조건 위반");
		
	}
	
	public PracticeInsertException(String message) {
		super(message);
	}
	
}
