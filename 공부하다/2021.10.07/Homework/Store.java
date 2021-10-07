package example_10_05_4_generic_sample;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Store {

	private Set<Book> books = new HashSet<>();
	private Set<Ticket> tickets = new HashSet<>();
	private Set<User> users = new HashSet<>();
	
	//loginUsers는 로그인 과정을 통과한 사용자 정보가 저장되는 Map객체다
	//loginUsers Map객체에는 로그인한 사람의 아이디(String)와 그 사람의 정보(User)가 저장된다.
	//private Map<String, User> loginUsers = new HashMap<>();
	private User loginUser = null;
	
	
	public Store() {
		books.add(new Book(101,"이것이 자바다","신용권","컴퓨터",35000));
		books.add(new Book(102,"실버산업의 미래","김상아","사회복지",39000));
		books.add(new Book(103,"재료역학","유홍균","항공기계",28000));
		books.add(new Book(104,"현대노인복지론","진석범","사회복지",40000));
		books.add(new Book(105,"유체역학","강종환","항공기계",37000));
		
		tickets.add(new Ticket(201, "콘서트뮤직", "2021-10-17", 21000));
		tickets.add(new Ticket(202, "예술의 전당", "2021-10-12", 16000));
		tickets.add(new Ticket(203, "싸이 공연", "2021-10-31", 55000));
		tickets.add(new Ticket(204, "쇼팽연주곡", "2021-10-16", 16000));
		tickets.add(new Ticket(205, "바흐 전율", "2021-10-11", 17000));
		
		users.add(new User("홍길동","hong","zxcv1234"));
		users.add(new User("김쩡글","jungle","zxcv1234"));
		users.add(new User("강아지","dog","zxcv1234"));
		users.add(new User("고라니","deer","zxcv1234"));
		
	}
	//모든 책정보를 출력하는 기능
	public void displayAllBooks() {
	for(Book book : books) {
		System.out.println(book.getNo());
		System.out.println(book.getName());
		System.out.println(book.getWriter());
		System.out.println(book.getGenre());
		System.out.println(book.getPrice());
	}
	}

	//책정보를 책의 상세정보를 출력하는 기능
	public void displayBookDetail(int bookNo) {
		for(Book book : books) {
			if(book.getNo()==bookNo) {
				System.out.println(book.getNo());
				System.out.println(book.getName());
				System.out.println(book.getWriter());
				System.out.println(book.getGenre());
				System.out.println(book.getPrice());
			}
		}
	}

	
	//모든 티켓정보를 출력하는 기능
	public void displayAllTicket() {
	for(Ticket ticket : tickets) {
		System.out.println(ticket.getNo());
		System.out.println(ticket.getName());
		System.out.println(ticket.getDate());
		System.out.println(ticket.getPrice());
	}
		
	}
	
	//티켓 상세정보를 출력하는 기능
	public void displayTicketDetail(int ticketNo) {
		for(Ticket ticket : tickets) {
			if(ticket.getNo()== ticketNo) {
				System.out.println(ticket.getNo());
				System.out.println(ticket.getName());
				System.out.println(ticket.getDate());
				System.out.println(ticket.getPrice());
			}
		}
	}
	//회원 가입 기능
	//아이디가 동일한 사용자는  가입될 수 없다. 
	public void signUp(User user) {
		User savedUser = this.findUserById(user.getUserId());
		if(savedUser!= null) {
			System.out.println("### [오류] 같은 아이디를 가진 사용자가 이미 존재합니다.");
		}
		users.add(user);
		System.out.println("### [성공] 회원가입이 완료되었습니다. ");
	}
//	boolean isExist = false; //flag변수
//	for(User savedUser : users) {
//		if(savedUser.getUserId().equals(user.getId)) {
//			isExist = true;
//			break;
//		}
//	}
//	if(isExist) {
//		System.out.println("### [오류] 같은 아이디를 가진 사용자가 이미 존재합니다.");
//		return;
//	}
//	users.add(user);
	//회원 탈퇴 기능
	// HashSet에서 사용자정보를 삭제한다. 
	public void exit(String id, String password) {
		 if(id==null||password== null) {
			 return;
		 }
		 Iterator<User> iter = users.iterator();
				while(iter.hasNext()) {
				User userRemove = iter.next();
				if(userRemove.getUserId().equals(id)&& userRemove.getPassword().equals(password)) {
					iter.remove();
				 }
				System.out.println("삭제완료되었습니다.");
		 }
}
	//주문을 하기 위해서 로그인과 로그아웃이 되어야한다.
		//로그인 기능
	public void logIn(String id, String password) {
		User user = this.findUserById(id);
		if(user == null) {
			System.out.println("아이디가 존재하지 않습니다. ");
			return;
		}
		boolean userPassword = this.findUserByPassword(password);
		if(userPassword) {
			user = loginUser;
			System.out.println("[로그인 성공]");
			return;
		} else {
			System.out.println("비밀번호가 틀렸습니다.");
		}
		
		
	}
		//로그아웃 기능
	public void logOut() {
		loginUser = null;
		System.out.println("[로그아웃 성공]");
		return;
	}

	private User findUserById(String userId) {
		for(User user : users) {
			if(user.getUserId().equals(userId)) {
				return user;
			}
		}
		return null;
	}
	private boolean findUserByPassword(String userPassword) {
		boolean isExtends = false;
		for(User user : users) {
			if(user.getPassword().equals(userPassword)) {
				isExtends = true;
				break;
			}
		}
		return isExtends;
		
	}
	
	//내 정보 보기 기능
	public void printMyInfo(String id, String password) {
		User user = this.findUserById(id);
		boolean isExtend = this.findUserByPassword(password);
		if(user == null) {
			System.out.println("아이디가 잘 못 되었습니다.");
			return;
		}
		if(isExtend) {
			System.out.println("사용자의 아이디"+user.getUserId());
			System.out.println("사용자의 이름"+user.getUsername());
			System.out.println("사용자의 포인트"+user.getPoint());
		
		} else {
			System.out.println("비밀번호가 잘 못 되었습니다. ");
		}
		
	}
	}
