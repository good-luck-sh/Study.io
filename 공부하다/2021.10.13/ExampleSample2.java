package example_10_13_exception;

import java.util.ArrayList;
import java.util.List;

public class ExampleSample2 {
	/* 예외 강제 발생시키기 
	 * 			-애플리케이션을 개발할 때 예외를 강제로 발생시킬 수 있다. 
	 * 			-예외 강제 발생 상황
	 * 				* 업무로직에 위배되는 경우 
	 * 					(동일한 아이디를 가진 사용자가 등록되는 것, 로그인처리할 때 비밀번호가 맞지 않는 것, 출금 금액보다 잔액이 부족한 것)
	 * 				* 유효한 입력값이 아닌 경우 
	 * 					(아이디가 빈 문자열인 것, 이메일 형식이 아닌 이메일 주소, 값의 범위를 넘어가는 값, 제시된 항목이 아닌 항목의 값-성별에 짐승, 항목이 아닌 값으로 입력시)
	 * 			-예외 강제 발생시키기 
	 * 			throw new 예외클래스 ();	
	 * 			throw new 예외클래스 (오류 메세지);
	 * 			throw new 예외클래스 (오류 메세지, 예외원인);	 예외원인은 다른 예외 객체다.
	 */
	public static void main(String[] args) {
		User user1 = new User("hong","홍길동");
		User user2 = new User("kim","김유신");
		User user3 = new User("hong","홍길동");
		
		
		UserManager userManager = new UserManager();
		
		try {
		userManager.addNewUser(user1);
		userManager.addNewUser(user2);
		userManager.addNewUser(user3);// 오류 발생, RunTimeException이 발생하였음, 아이디 중복으로 인한 오류임을 확인할 수 있음 
		
		} catch (RuntimeException ex) {
			/*
			 * catch 블록이 실행됨 
			 * 		-addNewUser(user) 실행이 실패하였음
			 * 		-오류 메세지가 포함된 예외 객체를 잡았다.  
			 * 		+오류에 대한 상세한 정보를 획득할 수 있다. 예외객체의 String getMessage(); 는 오류메세지를 반환한다. 
			 * 		+오류가 발생한 수행문을 확인 할 수 있다.  예외객체의 void printStackTrace()는 예외가 발생한 수행문 정보를 출력한다.
			 */
			System.out.println("오류메세지 : " + ex.getMessage()); //오류의 원인도 알아차릴 수 있고,어디에서 오류가 난건지 확인 가능함
			ex.printStackTrace();
		}
	}


	/**
	 * 사용자 정보 저장/ 조회/ 변경/삭제 기능을 지원하는 클래스 
	 * @author 김승희
	 */
	static class UserManager{
		private List<User> userList = new ArrayList<>();
		
		
		/**
		 * 새로운 사용자 정보를 전달받아서 저장하는 기능을 제공한다. <br />
		 * 아이디와 이름이 중복되는 사용자는 저장할 수 없다.<br />
		 * 만약 중복이 발생했다면, 이 메소드를 호출한 측에게 아이디/이름 중복으로 저장할 수 없었다는 내용을 알리고 싶다.
		 * @param user 새로운 사용자 정보 
		 */
		public void addNewUser(User user) {
//			boolean isExist = false;
//			String errorMessage = null;
//			userList.add(user);
//			
			for(User savedUser : userList) {
				if(savedUser.getId().equals(user.getId())) {
					//아이디 중복상황 확인, 예외 강제 발생, 예외가 발생하면 해당 메소드는 즉시 실행이 중단된다. 빠른 종료에 해당된다. return
					throw new RuntimeException("["+user.getId()+"] 아이디 중복");
				}
				if(savedUser.getName().equals(user.getName())) {
					//이름 중복상황 확인, 예외 강제 발생, 예외가 발생하면 해당 메소드는 즉시 실행이 중단된다. 빠른 종료에 해당된다. return
					throw new RuntimeException("["+user.getName()+"] 이름 중복");
				}
			}
			//userList객체에 User객체를 저장하는 이 수행문이 실행되기 위해서는 for문의 예외 강제로 발생시키는 수행문이 절대로 수행되지 않아야 한다. 
			userList.add(user);
			System.out.println("###사용자정보 ["+user.getId()+"]가 저장되었습니다.");
//				if(savedUser.getId().equals(user.getId())) {
//					isExist = true; 
//					errorMessage = "["+user.getId() +"] 아이디 중복";
//					break; // 중복이 되면 break로 빠져 나옴
//				}
//				if(savedUser.getName().equals(user.getName())) {
//					isExist = true;
//					errorMessage = "["+user.getName() +"] 이름 중복";
//					break; // 중복이 되면 break로 빠져 나옴
//
//				}
			
//			if(!isExist) {					 //!isExist가 true라면 
//											//아이디와 이름이 중복되는 사용자가 존재하지 않음
//				userList.add(user);			 // 새로운 사용자를 저장해도 되는 경우 
//			} else {
//												//!isExist가 false라면 
//												// 아이디 혹은 이름이 중복되는 사용자가 존재함
//				throw new RuntimeException(errorMessage); // 우리가 목표로 하는 업무내용에 위배되는 상황(오류상황)
//				//중복저장되지 않는 것이 우리의 목표 , 강제 오류 발생 throw new로 날려줌 
//			}
		//복잡한 코드로 간단하게 만들기 위하여 주석처리 함 			
		}
	}
	static class User{
		private String id;
		private String name;
		public User(String id, String name) {
			this.id = id;
			this.name = name;
		}
		public String getId() {
			return id;
		}
		public String getName() {
			return name;
		}
		}
	
}


