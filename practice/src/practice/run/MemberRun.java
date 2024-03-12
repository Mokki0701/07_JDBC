package practice.run;

import java.util.Scanner;

import practice.model.dao.GameMemberDAO;
import practice.model.dto.GameMember;

public class MemberRun {
	

	
	public static void main(String[] args) {
		GameMemberDAO gmd = new GameMemberDAO();
		try {
			
			int i = 100;
			Scanner sc = new Scanner(System.in);
			
			do {
				System.out.print("번호 입력");
				i = sc.nextInt();
				
				switch(i) {
				
				// 추가
				case 1:
					System.out.print("아이디 입력 : ");
					String id = sc.next();
					System.out.print("비밀번호 입력 : ");
					String pw = sc.next();
					System.out.print("이름 입력 : ");
					String name = sc.next();
					System.out.print("전화번호 입력 : ");
					int num = sc.nextInt();
					System.out.print("티어 코드 입력 : ");
					String tierCode = sc.next();
					System.out.print("티어 이름 입력 : ");
					String tierName = sc.next();
					
				 GameMember	gm = new GameMember(id, pw, name, num, tierCode, tierName);
				 
				 int a = gmd.insertMember(gm);
				 if(a > 0) System.out.println("삽입 성공");
				 else System.out.println("삽입 실패");
					
					break;
					// 삭제
				case 2:
					System.out.print("삭제할 아이디 입력 : ");
					id = sc.next();
					
					
					
					break;
				// 조회
				case 3: break;
				// 종료
				case 0: System.out.println("종료!"); return;
				default:
					System.out.println("1,2,3,0 만 입력해!");
				}
				
				
			}while(i != 0);
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
