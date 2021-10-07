package example_10_05_4_generic_sample;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StoreApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//도서목록 출력, 도서 상세정보출력, 모든 티켓정보출력, 티켓상세정보출력기능을 제공하는 객체 생성
		Store store = new Store();
		
		while(true) {
			System.out.println("--------------------------------------------------");
			System.out.println("1.도서메뉴  2.티켓메뉴  3.사용자메뉴  0.종료");
			System.out.println("--------------------------------------------------");
			System.out.println("번호를 선택하세요 :");
			
			int topLevelMenuNo = scan.nextInt();
			
			if(topLevelMenuNo == 1) {
				System.out.println("[도서메뉴]");
				System.out.println("---------------------------------------------");
				System.out.println("1.도서목록  2.도서상세정보  3.주문하기  0.종료");
				System.out.println("---------------------------------------------");
				int bookMenuNo = scan.nextInt();
				if(bookMenuNo == 1) {
					System.out.println("[도서목록]");
					store.displayAllBooks();
					
				} else if(bookMenuNo == 2) {
					System.out.println("[도서상세정보]");
					System.out.println("찾고싶은 책번호를 적으세요 ");
					int bookNumber = scan.nextInt();
					store.displayBookDetail(bookNumber);
				} else if(bookMenuNo == 3) {
					System.out.println("[도서주문하기]");
					
				} else if(bookMenuNo == 0) {
					System.out.println("[종료]");
					break;
				}
				
			} else if(topLevelMenuNo == 2) {
				System.out.println("[티켓메뉴]");
				System.out.println("---------------------------------------------");
				System.out.println("1.전체출력  2.상세정보  3.티켓예매  0.종료");
				System.out.println("---------------------------------------------");
				int ticketMenuNo = scan.nextInt();
				if(ticketMenuNo == 1) {
					System.out.println("[전체출력]");
					store.displayAllTicket();
					
				} else if(ticketMenuNo == 2) {
					System.out.println("[상세정보]");
					System.out.println("찾고싶은 티켓번호를 적으세요");
					int ticketNumber = scan.nextInt();
					store.displayTicketDetail(ticketNumber);
					
				} else if(ticketMenuNo == 3) {
					System.out.println("[티켓예매]");
					
				} else if(ticketMenuNo == 0) {
					System.out.println("[종료]");
					break;
				}
				
			} else if(topLevelMenuNo == 3) {
				System.out.println("[사용자메뉴]");
				System.out.println("--------------------------------------------------------------");
				System.out.println("1.로그인 2.회원가입 3.로그아웃 4.탈퇴하기 5.주문내역조회 6.내정보보기 0.종료");
				System.out.println("--------------------------------------------------------------");
				int userMenuNo = scan.nextInt();
				if(userMenuNo == 1) {
					System.out.println("[사용자메뉴]");
					System.out.println("[ 로그인 ]");
					System.out.println("아이디를 입력하세요 : ");
					String id = scan.next();
					
					System.out.println("비밀번호를 입력하세요 : ");
					String password = scan.next();
					
					store.logIn(id, password);
					
					
				} else if(userMenuNo == 2) {
					System.out.println("[회원가입]");
					System.out.println("이름을 입력하세요 : ");
					String name = scan.next();

					System.out.println("아이디를 입력하세요 : ");
					String id = scan.next();
					
					System.out.println("비밀번호를 입력하세요 : ");
					String password = scan.next();
					
					User user = new User(name,id,password);
					store.signUp(user);
					
				} else if(userMenuNo == 3) {
					System.out.println("[로그아웃]");
					store.logOut();
					
				} else if(userMenuNo == 4) {
					System.out.println("[탈퇴하기]");
					
					System.out.println("아이디를 입력하세요 : ");
					String id = scan.next();
					
					System.out.println("비밀번호를 입력하세요 : ");
					String password = scan.next();
					
					store.exit(id, password);
					
				} else if(userMenuNo == 5) {
					System.out.println("[주문내역보기]");
					
				}else if(userMenuNo == 6) {
					System.out.println("[내 정보 보기]");
					System.out.println("아이디를 입력하세요 : ");
					String id = scan.next();
					
					System.out.println("비밀번호를 입력하세요 : ");
					String password = scan.next();
					
					store.printMyInfo(id, password);
					
				} else if(userMenuNo == 0) {
					System.out.println("[탈퇴하기 ]");
					break;
				}
			} else if(topLevelMenuNo == 0) {
				System.out.println("[종료]");
				break;
			}
			System.out.println();
			System.out.println();
			System.out.println();
		}
		scan.close();
	}
}
