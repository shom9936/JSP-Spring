import java.util.List;
import java.util.Scanner;

import schoolDAO.SchoolDAO;
import schoolDTO.SchoolDTO;

public class SchoolManager {
	
	private final Scanner scan = new Scanner(System.in);
	
	public SchoolManager() {
		menu();
	}
	
	public void menu() {
		boolean run = true;
		
		while(run) {
			System.out.println("--------- 관리--------");
			System.out.println("1.추가   2.수정   3.삭제   4.목록   5.검색");
			System.out.print("선택 : ");
			int num = scan.nextInt();
			
			switch(num) {
			case 1: 
				insert(); break;
			case 2: 
				update(); break;
			case 3:
				delete(); break;
			case 4:
				list(); break;
			case 5:
				search(); break;
			case 0:
				exit(); break;
			default:
				System.out.println("입력 오류 ~ ");
			}
		}
	}
	
	private int codeInput() {
		System.out.println("1.학생   2.교수   3.관리자");
		System.out.print("선택 : ");
		int code = scan.nextInt();
		return code;
	}
	
	private String valueInput(int code) {
		if(code == 1) System.out.print("학번 입력 : ");
		else if(code == 2) System.out.print("과목 입력 : ");
		else if(code == 3) System.out.print("부서 입력 : ");
		String value = scan.next();
		return value;
	}
	
	private void insert() {
		System.out.println("--- DB 추가 ---");
		int code = codeInput();
		if(code < 1 || code > 3) {
			System.out.println("이전 메뉴로 이동합니다.");
			return;
		}
		System.out.print("이름 입력 : ");
		String name = scan.next();
		String value = valueInput(code);
		
		SchoolDTO dto = new SchoolDTO(name, value, code);
		SchoolDAO dao = new SchoolDAO();
		
		boolean result = dao.insert(dto);
		if(result) System.out.println(name + "이(가) 추가 되었습니다.");
		else System.out.println("추가 실패~");
	}
	
	private void exit() {
		System.out.println("- Program end -");
		scan.close();
		System.exit(0);
	}
	
	private void list() {
		SchoolDAO dao = new SchoolDAO();
		List schoolList = dao.getList();
		String title = String.format("%-10s %-10s %-10s", "NAME", "VALUE", "CODE");
		System.out.println(title);
		for(int i = 0 ; i<schoolList.size(); i++) {
			SchoolDTO man = (SchoolDTO)schoolList.get(i);
			String data = String.format("%-10s %-10s %-10d", man.getName(), man.getValue(), man.getCode());
			System.out.println(data);
		}
	}
	
	private void update() {
		System.out.println("--- DB 수정 ---");
		System.out.print("이름 입력 : ");
		String name = scan.next();
		int code = codeInput();
		String value = valueInput(code);
		
		SchoolDTO dto = new SchoolDTO(name, value, code);
		SchoolDAO dao = new SchoolDAO();
		
		boolean result = dao.update(dto);
		if(result) System.out.println(name + "이(가) 수정 되었습니다.");
		else System.out.println("수정 실패~");
	}
	
	public void delete() {
		System.out.println("--- DB 삭제 ---");
		System.out.print("이름 입력 : ");
		String name = scan.next();

		SchoolDAO dao = new SchoolDAO();
		
		boolean result = dao.delete(name);
		if(result) System.out.println(name + "이(가) 삭제 되었습니다.");
		else System.out.println("삭제 실패~");
	}
	
	private void search() {
		System.out.println("----- 검색 -----");
		System.out.println("1.이름     2.code  3.전체");
		System.out.print("선택 : ");
		int num = scan.nextInt();
		if(num < 1 || num > 3) return;
		
		SchoolDTO dto = null;
		
		if(num == 1) {
			dto = new SchoolDTO();
			System.out.print("이름 입력 : ");
			dto.setName(scan.next());
		}
		else if(num == 2) {
			int code = codeInput();
			if(code < 1 || code >3) return;
			dto = new SchoolDTO();;
			dto.setCode(code);
		}
		
		SchoolDAO dao = new SchoolDAO();
		dao.select(dto);
	}
	
}
