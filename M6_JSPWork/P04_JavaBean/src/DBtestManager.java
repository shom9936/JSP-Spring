import java.util.Scanner;

import dbtestDAO.DBtestDAO;
import dbtestDTO.DBtestDTO;

public class DBtestManager {

	private final Scanner scan = new Scanner(System.in);
	
	public DBtestManager() {
		menu();
	}
	
	public void menu() {
		boolean run = true;
		while(run) {
			System.out.println("1.추가   2.수정   3.삭제   4.목록");
			System.out.print("선택 : ");
			int num = scan.nextInt();
			
			switch(num) {
			case 1: // 추가
				insert(); break;
			case 2: // 수정
				update(); break;
			case 3: // 삭제
				delete(); break;
			case 4:
				list(); break;
			case 0:
				System.out.println("- Program end -");
				run = false;
				break;
			default:
				System.out.println("선택 오류~");
			}
		}
	} // menu() end
	
	public void insert() {
		System.out.println("--- DB 추가 ---");
		System.out.print("이름 입력 : ");
		String name = scan.next();
		System.out.print("나이 입력 : ");
		int age = scan.nextInt();
		System.out.println("키  입력 : ");
		double height = scan.nextDouble();
		
		DBtestDTO dto = new DBtestDTO(name, age, height);
		DBtestDAO dao = new DBtestDAO();
		
		int result = dao.insert(dto);
		if(result > 0) {
			System.out.println(name + "이(가) 추가 되었습니다.");
		}
		else {
			 System.out.println("추가 실패~");
		}
	}
	
	public void list() {
		DBtestDAO dao = new DBtestDAO();
		System.out.println("--- DB 목록 ---");
		dao.select();
	}
	
	public void update() {
		System.out.println("--- DB 수정 ---");
		System.out.print("이름 입력 : ");
		String name = scan.next();
		System.out.print("나이 입력 : ");
		int age = scan.nextInt();
		System.out.println("키  입력 : ");
		double height = scan.nextDouble();
		
		DBtestDTO dto = new DBtestDTO(name, age, height);
		DBtestDAO dao = new DBtestDAO();
		
		int result = dao.update(dto);
		if(result > 0) {
			System.out.println(name + "이(가) 수정 되었습니다.");
		}
		else {
			 System.out.println("수정 실패~");
		}
	}
	
	public void delete() {
		System.out.println("--- DB 삭제 ---");
		System.out.print("이름 입력 : ");
		String name = scan.next();

		DBtestDAO dao = new DBtestDAO();
		
		int result = dao.delete(name);
		if(result > 0) {
			System.out.println(name + "이(가) 삭제 되었습니다.");
		}
		else {
			 System.out.println("삭제 실패~");
		}
	}
	
}
