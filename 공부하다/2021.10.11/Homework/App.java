package homework;

import java.util.Date;
import java.util.List;

public class App {

	public static void main(String[] args) {
		TodoService service = new TodoService();
		
		while (true) {
			System.out.println("[일정 관리 프로그램]");
			List<Todo> recentTodos = service.getRecentTodos();
			if (!recentTodos.isEmpty()) {
				System.out.println("=============================================================================================");
				System.out.println("번호\t작성자\t상태\t예정일\t\t\t제목");
				System.out.println("---------------------------------------------------------------------------------------------");
				for (Todo item : recentTodos) {
					item.printSimpleTodo();
				}
			}
			System.out.println("=============================================================================================");
			System.out.println("1.전체보기 2.검색 3.상세보기 4.신규등록 5.변경 6.삭제 7.저장 0.종료 ");
			System.out.println("=============================================================================================");
			
			System.out.print("메뉴번호 입력: ");
			int menuNo = KeyboardUtil.readInt();
			
			if (menuNo == 1) {
				System.out.println("[전체보기]");
				service.printAllTodos();
				
			} else if (menuNo == 2) {
				System.out.println("[일정 검색]");
				System.out.println("---------------------------------------------------------------------------------------------");
				System.out.println("1.제목으로 찾기  2.작성자로 찾기  3.상태로 찾기");
				System.out.println("---------------------------------------------------------------------------------------------");
				
				System.out.print("검색방법을 입력: ");
				int searchTypeNo = KeyboardUtil.readInt();
				
				if (searchTypeNo == 1) {
					System.out.println("### 일정제목으로 일정을 검색합니다.");
					System.out.println("### 검색어 입력: ");
					String keyword = KeyboardUtil.readString();
					
					service.printTodosByTitle(keyword);
					
				} else if (searchTypeNo == 2) {
					System.out.println("### 작성자로 일정을 검색합니다.");
					System.out.println("### 작성자 입력 : ");
					String writer = KeyboardUtil.readString();
					
					service.printTodosByWriter(writer);
					
				} else if (searchTypeNo == 3) {
					System.out.println("### 상태로 일정을 검색합니다.");
					System.out.println("### 상태 입력 : ");
					String status = KeyboardUtil.readString();
					
					service.printTodosByStatus(status);
				}
				System.out.println();
				
			} else if (menuNo == 3) {
				System.out.println("[일정 상세 조회]");
				System.out.println("### 상세조회 할 일정번호를 입력하세요");
				int no = KeyboardUtil.readInt();
				
				service.printTodoDetail(no);
				
				
			} else if (menuNo == 4) {
				System.out.println("[신규 일정등록]");
				System.out.println("### 신규일정을 등록하세요");
				
				System.out.print("### 제목 입력: ");
				String title = KeyboardUtil.readString();
				
				System.out.print("### 작성자 입력: ");
				String writer = KeyboardUtil.readString();
				
				System.out.print("### 예정일 입력(입력예시:2000년 10월 8일 14시): ");
				Date dueDate = KeyboardUtil.readDate();
				
				System.out.print("### 내용 입력: ");
				String text = KeyboardUtil.readString();
				
				Todo todo = new Todo(title, writer, text, dueDate);
				service.addNewTodo(todo);						
				
			} else if (menuNo == 5) {
				
				System.out.println("[일정정보 변경]");
				System.out.println("-----------------------------------");
				System.out.println("1.제목과 내용 변경  2. 일정 상태 변경");
				System.out.println("-----------------------------------");
				
				int searchTypeNo = KeyboardUtil.readInt();
				if(searchTypeNo == 1) {
				System.out.println("### 일정의 제목과 내용을 변경하시겠습니까?");
				
				System.out.println("### 일정 번호 입력: ");
				int no = KeyboardUtil.readInt();
				
				System.out.println("### 변경할 제목 입력: ");
				String title = KeyboardUtil.readString();
				
				System.out.println("### 변경할 내용 입력: ");
				String text = KeyboardUtil.readString();
				
				service.updateTodo(no,title,text);	
				}
				if(searchTypeNo == 2) {
					System.out.println("### 일정의 상태를 등록합니다.");
					
					System.out.println("### 일정 번호 입력");
					int no = KeyboardUtil.readInt();
					
					System.out.println("### 일정 상태 입력");
					String status = KeyboardUtil.readString();
					
					service.updateTodoStatus(no,status);
				}
			} else if (menuNo == 6) {
				System.out.println("[일정정보 삭제]");
				System.out.println("### 삭제할 일정의 번호를 등록하세요 ");
				int no = KeyboardUtil.readInt();
				
				service.deleteTodo(no);
				
				
			} else if (menuNo == 7) {
				System.out.println("[일정정보 저장]");
				service.saveTodos();
				
			} else if (menuNo == 0) {
				System.out.println("[프로그램 종료]");
				System.out.println("### [안내] 일정관리 프로그램을 종료합니다.");
				break;
			}
			System.out.println();
		}
	}
}
