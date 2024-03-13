package practiceProgrammers;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class run1 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이차원 배열의 크기를 입력하세요: ");
    int rows = sc.nextInt();
    
		int[][] board = new int[rows][rows];
		int[] moves = new int[8];
		
		for(int i = 0; i < rows;i++	) {
			for(int j = 0; j < rows; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < moves.length;i++) {
			moves[i] = sc.nextInt();
		}
		
		
		int count = 0;
    
    Stack<Integer> stack = new Stack<Integer>();
    
    int[] arr = new int[board.length];
    
    for(int i = 0; i < board.length; i++){
        arr[i] = Integer.parseInt((Arrays.toString(board[i])).replaceAll("[^0-9]", ""));
        System.out.println(arr[i]);
    }
    
    for(int i = 0; i < moves.length; i++){
        
        int num = arr[moves[i]-1] %10;
        arr[moves[i]-1] = arr[moves[i]-1]/10;
        
        if(num == 0) continue;
        
        if(i == 0){
            stack.push(num);
            continue;
        }
        
        if(stack.isEmpty()){
            stack.push(num);
            continue;            
        }
        
        if(num == stack.peek()){
            count++;
            stack.pop();
        }            
        
        
    }
    
    while (!stack.isEmpty()) {
      int element = stack.peek(); // 스택의 맨 위 요소 확인
      System.out.println(element);
      stack.pop(); // 스택의 맨 위 요소 제거
  }
		
    System.out.println(1);
	}
}
