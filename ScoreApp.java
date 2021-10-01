package example_09_30_stringApp;

import java.util.Scanner;

public class ScoreApp {

		public static void main(String[]args) {
			// 표준입력장치(키보드)을 입력내용을 스캔하는 Scanner객체 생성
			Scanner scan = new Scanner(System.in);
			
			// 성적정보에 대한 추가/변경/삭제/조회 기능이 구현된 ScoreService객체 생성
			ScoreService service = new ScoreService();
			
			while (true) {
				System.out.println("-----------------------------------------------------------------");
				System.out.println("1.전체조회  2.조회  3.추가  4.변경  5.삭제  0.종료");
				System.out.println("-----------------------------------------------------------------");
				
				System.out.print("메뉴를 선택하세요: ");
				int menuNo = scan.nextInt();
				
				if (menuNo == 1) {
					System.out.println("[전체 조회]");
					// 사용자로부터 입력내용 없음
					service.printAllScore();
					
				} else if (menuNo == 2) {
					System.out.println("[상세 조회]");
					System.out.println("조회하실 성함을 입력하세요 :");
					// 사용자로부터 학생이름을 입력받는다.
					String name = scan.next();
					service.printScoreDetail(name);
					
					
				} else if (menuNo == 3) {
					System.out.println("[성적정보 추가]");
					System.out.println("성적정보를 추가 할 학생이름, 국어점수, 수학점수, 영어점수를 입력하세요 :");
					String addScore = scan.next();
					String[] historys = addScore.trim().split(",");
//					for(String history : historys) {
//						if(history == null) {
//							System.out.println("잘 못 입력하셨습니다. ");
//							break;
//						}
//					}
					String name = historys[0];
					int korScore = Integer.parseInt(historys[1]);
					int EngScore = Integer.parseInt(historys[2]);
					int MathScore = Integer.parseInt(historys[3]);
					Score student = new Score(name, korScore, EngScore, MathScore);
					service.addNewScore(student);
					// 사용자로부터 성적정보를 입력받는다.
					// 성적정보는 "홍길동,100,80,70"과 같은 형식으로 입력받아서 적절히 분석한 다음 
					// Score객체에 담아서 ScoreService의 메소드에 전달한다.
					
				} else if (menuNo == 4) {
					System.out.println("[성적정보 수정]");
					System.out.println("수정할 학생의 이름, 국어점수, 수학점수, 영어점수를 입력하세요 :");
					String beforeStudent = scan.next();
					String[] historys = beforeStudent.trim().split(",");
					//비어있는 인자값을 인식을 못해 -1을 추가로 입력해주었다.
//					for(String history : historys) {
//						if(history == null) {
//							System.out.println("잘 못 입력하셨습니다. ");
//							break;
//						}
//					}
//					
					String name = historys[0];
					int korScore = Integer.parseInt(historys[1]);
					int engScore = Integer.parseInt(historys[2]);
					int mathScore = Integer.parseInt(historys[3]);
					
					Score beforeScore = new Score(name, korScore, engScore, mathScore);
					service.updateScore(beforeScore);
					
					System.out.println("수정할 학생의 이름, 국어점수, 수학점수, 영어점수를 입력하세요 :");
					String afterStudent = scan.next();
					historys = afterStudent.trim().split(",");
					//비어있는 인자값을 인식을 못해 -1을 추가로 입력해주었다.

//					for(String history : historys) {
//						if(history == null) {
//							System.out.println("잘 못 입력하셨습니다. ");
//							break;
//						}
//					}
					name = historys[0];
					korScore = Integer.parseInt(historys[1]);
					engScore = Integer.parseInt(historys[2]);
					mathScore = Integer.parseInt(historys[3]);
					
					Score afterScore = new Score(name, korScore, engScore, mathScore);
					service.updateScore(afterScore);
					
					// 사용자로부터 변경할 성적정보를 입력받는다.
					// 변경할 성적정보는 "홍길동,100,80,70"과 같은 형식으로 입력받아서 적절히 분석한 다음 
					// Score객체에 담아서 ScoreService의 메소드에 전달한다.
					
				} else if (menuNo == 5) {
					System.out.println("[성적정보 삭제]");
					System.out.println("삭제할 학생의 이름을 입력하세요 :");
					String name = scan.next();
					service.deleteScore(name);
					// 사용자로부터 삭제할 학생이름을 입력받는다.
					
				} else if (menuNo == 0) {
					System.out.println("[프로그램 종료]");
					break;
				}
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
			}
			scan.close();
		}
	}