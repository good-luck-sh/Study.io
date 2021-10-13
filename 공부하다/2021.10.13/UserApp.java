package example_10_13_custom_exception.app;

import java.util.Scanner;

import example_10_13_custom_exception.exception.HtaException;
import example_10_13_custom_exception.service.UserService;
import example_10_13_custom_exception.vo.User;

public class UserApp {
	//사용자의 키보드 입력을 읽어오는 객체
	Scanner scan = new Scanner(System.in);
	//사용자와 관련된 업무로직이 구현되어 있는 객체
	UserService userService = new UserService();

	public void displayMenu() { //계속 main안에 만들었지만, 이제는 밖에 작성함, display내부에 예외 일괄처리 완성함
		try {
		System.out.println("-------------------------------------------");
		if(userService.isLogined()) {
			System.out.println("3.내정보보기 4.로그아웃 0.종료");
		} else {
			System.out.println("1.로그인 2.회원가입 0.종료");
		}
		System.out.println("-------------------------------------------");
		System.out.println("### 메뉴를 선택하세요 ");
		int menuNo = scan.nextInt();
		if(menuNo == 1) {
			로그인하기(); //메소드를 각기 호출함
		} else if(menuNo == 2) {
			회원가입하기();//메소드를 각기 호출함
		} else if(menuNo == 3) {
			내정보보기();//메소드를 각기 호출함
		} else if(menuNo == 4) {
			로그아웃하기();//메소드를 각기 호출함
		} else if(menuNo == 0) {
			종료하기();//메소드를 각기 호출함
		}
	} catch (HtaException ex) {
		System.out.println("### 오류발생 : " + ex.getMessage());
		ex.printStackTrace();
	}
		System.out.println();
		displayMenu(); //while문이 없어도 다시 호출함, 재귀호출
		//while문이 없어도 계속 본인을 호출하기 때문에 계속 반복적으로 출력이 가능함
	}
	
	private void 로그인하기() {
		System.out.println("[로그인하기 ]");
		System.out.println("### 아이디와 비밀번호를 입력하세요 ");
		System.out.println("### 아이디 입력 : ");
		String id = scan.next();
		System.out.println("### 비밀번호 입력 :");
		String password = scan.next();
		
		userService.login(id, password);
		System.out.println("###  [처리 성공] 로그인 처리가 완료되었습니다. ");

		
	}
	private void 회원가입하기() {
		System.out.println("[회원가입하기 ]");
		System.out.println("### 아이디와 비밀번호를 입력하세요 ");
		System.out.println("### 아이디 입력 : ");
		String id = scan.next();
		System.out.println("### 비밀번호 입력 :");
		String password = scan.next();
		System.out.println("### 이름 입력 :");
		String name = scan.next();

		
		User user = new User(id, password, name);
		userService.registerUser(user);
		System.out.println("###  [처리 성공] 회원가입처리가 완료되었습니다. ");

		//메소드를 빼버림으로 인하여, 코드의 가독성과 복잡성이 높아짐
		//로그인과 회원가입이 응집력이 높아지게 작성된다 --> 연관있는 모듈끼리 함께 모여있다. 
		//결합도가 낮아져있다. 
		}
	private void 내정보보기() {
			System.out.println("[내 정보 보기]");
			
		}
	private void 로그아웃하기() {
		System.out.println("[로그아웃 하기]");
		
		userService.logout();
		System.out.println("###[처리 성공] 로그아웃이 완료되었습니다.");

	}
	private void 종료하기() {
		System.out.println("[프로그램 종료]");
		System.out.println("### 프로그램을 종료합니다. ");
		System.exit(0); //while문이 없기 때문에 break문이 아닌system.exit를 이용하여 프로그램을 종료하게 됨
	}
	//메소드를 분리해놓은 것임 ,if문이 길어지기 때문에 , 상호작용하는 개별 입력이 가능하게 됨
	public static void main(String[] args) {
		UserApp app = new UserApp();
		app.displayMenu(); //메소드 호출로 실행됨
		//여러개의 클래스가 모여서 시스템을 만듦, 각기 클래스들이 특정계증에 속해있다. 
		//예외, VO는 제외하고 정보를 담는 놈, 
		//기능을 담당,메소드를 담당하는 놈들은 각기 다른 기능을 구현하고있다. 
		
	}
}
