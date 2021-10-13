package example_10_13_exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExampleSample4 {
	//내부클래스 거의 사용하지 않는다. 
	//일반적으로는 별도의 클래스를 만들어야한다. 지금은 강의 목적으로 내부클래스로 작성함
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		UserService service = new UserService();
		
		while(true) {
			try {
			System.out.println("-------------------------------------------");
			if(service.isLogined()) { //isLogined가 true면 로그인이 되어있는 상태
				System.out.println("3. 로그아웃  0.종료 ");

			} else {//isLogined가 false면 로그인이 안되있는 상태
				System.out.println(" 1. 로그인 2. 회원가입 0.종료 ");
			}
			
			System.out.println("-------------------------------------------");
			System.out.println("### 메뉴 선택 : ");
			int menuNo = scan.nextInt();

			if(menuNo == 1) {
				System.out.println("[로그인]");
				System.out.println("아이디를 입력하세요: ");
				String userId= scan.next();
				
				System.out.println("비밀번호를 입력하세요: ");
				String userPassword = scan.next();
				
				service.login(userId, userPassword);
				System.out.println("### 로그인이 완료되었습니다.");
				//여기서도 Exception 발생
				
			} else if(menuNo == 2) {
				System.out.println("[회원가입]");
				System.out.println("가입할 회원 아이디를 입력하세요: ");
				String userId= scan.next();
				
				System.out.println("가입할 회원 비밀번호를 입력하세요: ");
				String userPassword = scan.next();
				
				System.out.println("가입할 회원 성함를 입력하세요: ");
				String userName = scan.next();
				
				User user = new User(userId, userPassword, userName);
				service.registerUser(user); // 예외가 던져지는 메소드
				System.out.println("### 회원가입이 완료되었습니다.");
				//여기서도 Exception 발생


			} else if(menuNo == 3) {
				System.out.println("[로그아웃]");
				service.loginUser = null;
				
			} else if(menuNo == 0) {
				System.out.println("[종료]");
				break;
			}
			System.out.println();
		} catch (CustomException ex) {
			System.out.println("### 오류 : " + ex.getMessage());
			//에러 페이지를 입력함, 예외처리가 일괄처리가 됨 
			//이제 신경쓰지 않고, 로직과 사용자의 입력만 생각하면 됨
			//service에서도 사용자 정의 예외처리로 처리하면 됨
		}
			}
		
	}
	
	//사용 방법 , 활용 방법
	static class UserService {
		private List<User> users = new ArrayList<>();
		//일치하는 경우 로그인이 가능하도록 코드짬
		private User loginUser = null;
		//원래는 웹서버에서 처리하는 방법임.
		
		/**
		 * 새 사용자 정보를 등록하는 기능이다. <br />
		 * 같은 아이디를 사용하는 사용자가 존재하는 경우, 예외를 발생시킨다. 
		 * @param user 새 사용자 정보
		 */
		public void registerUser(User user) {
			/*
			 * 1. 전달받은 사용자 정보에 포함된 아이디로 이미 저장된 사용자 정보를 조회해본다. 
			 * 2. 만약, 사용자 정보가 조회되면 해당 아이디로 이미 가입한 사용자가 있으므로 예외를 발생시켜서 메소드를 종료시킨다. 
			 * 3. 조회된 사용자정보가 null이면 해당아이디로 가입된 사용자 정보가 없는 것이므로 새 사용자 정보를 List객체에 추가한다. 
			 */
		User savedUser = this.getUserById(user.getId());
		if(savedUser != null) {
			throw new CustomException("이미 사용중인 아이디 입니다. "); //예외를 발생시켜서 빠른 종료 처리함
		}
			users.add(user);  //일반적으로 예외처리는 이렇게 사용한다.
	
	
		}
		/**
		 * 아이디와 비밀번호를 전달받아서 로그인처리를 수행한다<br />
		 * 아이디 혹은 비밀번호가 올바르지 못한 경우, 예외를 발생시킨다.
		 * @param id 아이디
		 * @param password 비밀번호 
		 */
		public void login(String id, String password) {
			/*
			 * 1. 전달 받은 아이디로 이미 저장된 사용자 정보를 조회해본다. 
			 * 2. 사용자 정보가 null이면 가입한 적 없는 아이디임으로 예외를 발생시킨다. 
			 * 3. 조회된 사용자 정보의 비밀번호와 전달받은 비밀번호가 일치하지 않으면 예외를 발생시킨다. 
			 * 4. 사용자 정보가 존재하고, 비밀번호도 일치함으로 로그인 처리를 완료한다. 
			 */
			User saveduser = this.getUserById(id);
			if(saveduser == null) {
				throw new CustomException("사용자 정보가 존재하지 않습니다.");
			}
			if(!saveduser.password.equals(password)) {
				throw new CustomException("비밀번호가 일치하지 않습니다. ");
			}
			
			//로그인된 사용자 정보를 loginUser변수에 대입한다. 
			//로그인이라고 볼 수 있다. 
			loginUser = saveduser;
		}
		
		/**
		 * 현재 로그인 여부를 반환한다. 
		 * @return loginedUser가 null이 아니면 true를 반환한다. 
		 */
		public boolean isLogined() {
			return loginUser != null;
		}
		
		/**
		 * 아이디를 전달받아서 해당 사용자 정보를 반환한다.
		 * @param id 아이디 
		 * @return 사용자 정보, 사용자 정보가 존재하지 않는 경우 null을 반환한다. 
		 */
		public User getUserById(String id) {
			for(User user : users) {
				if(user.getId().equals(id)) {
					return user;
				}
			}
			return null;
		}
	}
	
	static class User{
		private String id; 
		private String password;
		private String name; 
		
		public User(String id, String password, String name) {
			this.id = id;
			this.password = password;
			this.name = name;
		}
		public String getId() {
			return id;
		}
		public String getPassword() {
			return password;
		}
		public String getName() {
			return name;
		}
	}
	//사용자 정의 예외클래스 ,한 세트에서 하기 위하여 static으로 입력하는 것임, 원래는 별도의 클래스로 진행 
	//사용자 정의 예외클래스
	//사용자 정의 예외 클래스는 RuntimeException 클래스나 Exception 클래스를 상속받아서 정의한다. 
	//사용자 정의 예외 클래스를 정의할 때는 주로 부모의 생성자 메소드를 호출하는 생성자 메소드를 정의하는 것이 일반적이다. 특별한 경우를 제외하고는..
	
	static class CustomException extends RuntimeException{ //사용자 정의 예외클래스를 만든 것임. HIAException등으로 클래스 작성가능
		//총 4가지의 상속받는 생성자 메소드를 작성하면 됨
		
		//추가적인 변수를 만들 수 있다. 
		//private String errorCode;
		
		//기본 생성자 메소드
		public CustomException() {}
		
		//오류 메세지를 인자로 전달받는 생성자 메소드
		public CustomException(String message) {//매개변수에  String errorCode을 입력 후 
			super(message);
			//this.errorCode = errorCode;
		}
		
		//오류 발생의 원인이 되는 다른 오류를 전달받는 생성자 메소드
		public CustomException(Throwable cause) {
			super(cause);
		}
		
		//오류 메세지와 오류 발생의 원인이 되는 다른 오류를 전달 받는 생성자 메소드 
		public CustomException(String message,Throwable cause) {
			super(message,cause);
		}
		
		
	}
}
