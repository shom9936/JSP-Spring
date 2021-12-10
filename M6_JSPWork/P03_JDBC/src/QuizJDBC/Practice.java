

package QuizJDBC;

import java.util.Scanner;

/* 
create table school(
name varchar2(20) NOT NULL ,  -- 이름
value varchar2(20),           -- 학생 : 학번 , 교수 : 과목 , 행정 : 부서명
code number                   -- 입력 선택 : code 1 = 학생 , code 2 = 교수, code 3 = 행정
); 
 */

public class Practice {
	
	public static void mainMenu() {
		System.out.println();
		System.out.println("--- 학 사  관  리 --");
		System.out.println("1.입력   2.검색   3.삭제   4.종료");
		System.out.print("선택 >> ");
	}
	
	public static void insertPrint() {
		System.out.println();
		System.out.println("--- 정 보  입  력 ---");
		System.out.println("1.학생   2.교수   3.관리자   4.이전");
		System.out.print("선택 >> ");
	}
	
	public static void selectPrint() {
		System.out.println();
		System.out.println("--- 검         색 ---");
		System.out.println("1.이름   2.전체   3.이전");
		System.out.print("선택 >> ");
	}
	
	public static void deletePrint() {
		System.out.println();
		System.out.println("--- 삭        제 ---");
		System.out.println("1.이름   2.이전");
		System.out.print("선택 >> ");
	}

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		boolean codeRun = true; // 프로그램 진행 ( true : 실행 , false : 종료 )
		School manager = new School();
		char sel_1;
		char sel_2;
		
		while(codeRun) {
			mainMenu();
			sel_1 = scanner.next().charAt(0);
			
			switch(sel_1) {
			case '1': // 추가
				insertPrint();
				sel_2 = scanner.next().charAt(0);
				manager.insert(sel_2);
				break;
			case '2': // 검색
				selectPrint();
				sel_2 = scanner.next().charAt(0);
				manager.select(sel_2);
				break;
			case '3': // 삭제
				deletePrint();
				sel_2 = scanner.next().charAt(0);
				manager.delete(sel_2);
				break;
			case '4':
				System.out.println("- Program end -");
				codeRun = false;
				break;
			default:
				System.out.println("선택 오류~");
			}
		}
		
	}
	
}






























