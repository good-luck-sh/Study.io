package example_09_30_stringApp;

import java.util.Arrays;
//중간중간 Arrays.toString으로 배열의 위치를 확인하여 import가 된 java.util.Arrays; package이다.

public class ScoreService {

	private Score[] database = new Score[100];
	private int position = 0;
	public ScoreService() {
		database[position++] = new Score("홍길동",100,50,100);
		database[position++] = new Score("김쭝찌",80,70,20);
		database[position++] = new Score("김쩡글",70,70,80);
		database[position++] = new Score("김메롱",50,80,90);
		database[position++] = new Score("김정남",80,40,60);
	}//생성자 안에다가 입력을 해야함
	//같은 name이면 출력하기 위한 방법의 메소드를 제작한다.
	private Score getPrintName (String score){
		//클래스 내에서만 진행할 것이기 때문에 접근제한자를 private으로 설정한다. 
		//이름을 매개변수로 확인하여 Score타입으로 반환할 예정이다.
		Score foundData = null;
		// Score의 타입의 참조변수를 null로 설정한다. 
		for(Score databases : database) {
			//향상된 for문을 이용하여 database의 정보를 반환한다. 
			if(databases == null) {
				//nullPointerException의 예외처리를 위하여 입력한 값이다.  만약 databases의 값이 null이면 
				break;
				//멈춘다.
			}
			if(score != null && databases.getName().equals(score)) {
				//이름이 null이 아니고 data의 이름과 입력받은 score의 name이 동일하다면
				foundData = databases;
				//데이터를 Score참조변수인 foundData에 입력한다. 
				break;
				//종료한다.
			}
		}return foundData;
		//foundData의 주소값을 반환한다. 
	}

	// 새 성적정보를 전달받아서 배열에 추가하는 기능(추가구현? 새 성적이 입력될 때마다 성적이 가장 좋은 학생이 0번째 위치하도록 하기)
	public void addNewScore(Score score) {
		if(score == null) {
			//만약 입력받는 값이 null값인 경우 
			System.out.println("잘 못 입력하셨습니다. ");
			return;//빠른 종료 
		}
		if(database[position]==null) {
			//database가 position이 null이면
			database[position] = score;
			//score객체를 빈 배열에 입력한다. 
			//그리고 position의 값을 1증가 시킨다.
			System.out.println("입력이 완료 되었습니다.");
		
		}
		// 새 성적이 입력될 때마다 성적이 가장 좋은 학생이 0번째 위치하도록 하기 
		//거품 정렬로 입력해보자
		Score temp = null;
		//값을 담아둘 Score객체의 참조변수 temp를 설정한다.
		for(int i = 0; i<database.length-1; i++) {
			//바깥쪽은 일반 for문으로 0부터 시작한다. 그리고 i는 database.길이에서 -1까지의 크기를 갖는다. 그리고 i의 값은 1씩증가한다.
			for(int j = 0;j<database.length-1-i; j++) {
				//안쪽도 일반 for문을 설정한다. 0부터 시작하고, j의 길이는 바깥for문 돌때마다 크기가 줄어들게 만들기 위하여 database길이-1에서 i의 값을 빼도록 길이를 설정하였다.
				if(database[j+1] == null) {
					// nullPoinerException처리를 위하여 입력하였다. 만약 database[j+1]이 null이라면 
					break;
					// 멈춘다.
				}
				
				if(database[j].getTotal()<database[j+1].getTotal()) {
					//만약 database[j]의 총점이 database[j+1]의 총점보다 작은 경우 
					temp = database[j];
					//빈 객체에 database[j] 를 넣고 
					database[j] = database[j+1];
					//database[j]에 database[j+1]의 값을 넣는다. 
					database[j+1]= temp;
					//database[j+1]에 빈 객체에 넣은 database[j]의 값을 입력한다.  
				}
				}
			
		}
	}
	// 모든 학생의 성적을 출력하는 기능
	public void printAllScore() {
		 
		for(Score databases : database) {
			//향상된 for문을 이용하여 database의 정보를 출력한다. 
			if(databases == null) {
				//nullPointerException 예외 처리를 위하여 입력했다. 만약 databases의 값이 null이면 
				break;
				//멈춘다
			}
			System.out.println("학생 이름 : "+databases.getName());
			//databases의 등록되어 있는 학생의 이름을 출력한다. 
			System.out.println("국어점수: "+databases.getKor());
			//databases의 등록되어 있는 국어 점수를 출력한다. 
			System.out.println("수학점수: "+databases.getMath());
			//databases의 등록되어 있는 수학 점수를 출력한다. 
			System.out.println("영어점수: "+databases.getEng());
			//databases의 등록되어 있는 영어 점수를 출력한다.
			System.out.println("총 점: "+databases.getTotal());
			//databases의 등록되어 있는 총 점수를 출력한다. 
			System.out.println("평균점수 :"+databases.getAverage());
			//databases의 등록되어 있는 평균 점수를 출력한다.
		}
		}

	//학생이름을 전달받아서 해당 학생의 성적정보를 출력하는 기능
	public void printScoreDetail(String name) {
		
		Score check = this.getPrintName(name);
		//이름 메소드를 진행하여 같은 이름의 값을 Score 참조 변수 check에 데이터 주소를 등록한다.  
		if(check == null) {
			//만약 check가 null이면 
			return;
			//빠른 종료한다. 
		
		}
		System.out.println("학생 이름 : "+check.getName());
		//check의 등록되어 있는 학생의 이름을 출력한다. 
		System.out.println("국어점수: "+check.getKor());
		//check의 등록되어 있는 국어 점수를 출력한다. 
		System.out.println("수학점수: "+check.getMath());
		//check의 등록되어 있는 수학 점수를 출력한다. 
		System.out.println("영어점수: "+check.getEng());
		//check의 등록되어 있는 영어 점수를 출력한다.
		System.out.println("총 점: "+check.getTotal());
		//check의 등록되어 있는 총 점수를 출력한다. 
		System.out.println("평균점수 :"+check.getAverage());
		//check의 등록되어 있는 평균 점수를 출력한다.
		}

	// 변경된 성적정보를 전달받아서 해당 학생의 성적정보를 변경하는 기능(추가구현? 성적정보 수정하기)
	public void updateScore(Score score) {
		
		for(int i = 0; i<database.length-1; i++) {
			//일반 for문을 사용하여 database를 출력한다. 
			if(database[i] == null) {
				// 만약 database값이 null이면 반복문을 탈출한다. nullPointerException 예외 처리를 위해서 입력했다.
				break;
			}
			if(score == null || !database[i].getName().equals(score.getName()) || database[i].getKor() != score.getKor() || database[i].getEng() != score.getEng() || database[i].getMath() != score.getMath()) {
				//만약 입력받는 데이터를 담고있는 참조변수 score가 null이 아니거나 또는 데이터의 정보가 다를 경우 
				System.out.println("입력정보가 잘 못 되었습니다. ");
				// 표준출력문을 출력한다. 
				return;
				//수정값에 도달하지 않도록 빠른 종료한다. 
			}
			if(database[i].getName().equals(score.getName()) && database[i].getKor() == score.getKor() && database[i].getEng() == score.getEng() && database[i].getMath() == score.getMath()) {
				//만약 database의 이름과 정보의 이름 database의 국어점수와 정보의 국어점수가 동일하고,  database의 영어점수와 정보의 영어점수가 동일하고,  database의 수학점수와 정보의 수학점수가 동일하면
				database[i] = database[position-1];
				//현재 database값에 database의 데이터빈칸 바로전, 즉, 마지막 데이터가 존재하는 값을 입력한다. 
				database[position-1] = null;
				//마지막 데이터가 존재하는 곳에 null값을 입력한다.
				position--;
				//데이터가 줄어들었기 때문에 데이터의 위치를 표시하는 position의 숫자값을 -1한다.
				System.out.println("삭제가 완료되었습니다. ");
				//표준출력문에 입력된 문자열을 출력한다.
				return;
				//수정값에 도달하지 않도록 빠른 종료한다. 
			} 
		}
			//수정이 이뤄질 if문을 작성한다.
			if(database[position] == null) {
				//만약 database[위치]가 null값이라면
				database[position] = score;
				//database에 2번째로 입력받은 정보를 database값이 null인 위치에 score가 가지고 있는 주소값을 저장한다.
				position++;
				//데이터가 1개 생성되었기 때문에 위치를 표시하는 정수 변수에 +1한다.
				System.out.println("수정이 완료되었습니다. ");
				//표준출력문에 입력된 문자열을 출력한다.
			}}
	// 학생이름을 전달받아서 해당 학생의 성적정보를 배열에서 삭제하는 기능(추가구현? 성적정보가 삭제되면 해당 성적 이후의 모든 값들을 이동시키기)
	public void deleteScore(String name) {
		
		//위치를 지정할 정수변수를 초기화시키면서 생성한다.
		int point = 0;	
			

		for(int i = 0; i<database.length-1; i++) {
			//일반 for문을 사용하여, 성적정보를 배열에서 삭제하고, 다음 순번을 빈칸에서 한칸씩 이동시킨다.
			if(database[i] == null) {
				//만약 database가 null이면 멈춘다. nullPointerException예외처리를 위해 작성한다.
				break;
			}
			if(name != null && database[i].getName().equals(name)) {	
				//만약 전달받은 문자열객체의 주소값을 가지고 있는 참조변수 name이 null아니고 database의 정보와 입력받은 객체의 동등성의 비교로 동등한 경우, 동등성 비교를 위하여equals를 사용하였다. 
				point += 1;
				//위치를 지정한 정수변수를 +1씩 증가하여 인덱스 값을 확인한다.
				database[i] = database[i+1];
				//해당 database에 다음 순번의 인덱스 값을 입력한다.		
				for(int j = point; j < database.length-1; j++) {
					//안쪽에 일반 for문을 이용하여, 자리이동이 된 해당 인덱스 값부터 데이터 마지막까지의 반복을 사용한다.
					if(database[j+1] == null) {
						//nullPointerException 예외처리를 위해 j+1이 null이면 멈추도록 설정하였다.
						break;
					}
					database[j] = database[j+1];
					//삭제가 일어난 database 인덱스부터 그다음에 올 인덱스 값을 넣는다.
					}		// for문을 벗어나면
				database[position-1] = null;
				//database마지막에 있는 값을 null화 시킨다.
				position--;
				//데이터 삭제가 일어났기 때문에 위치를 나타내는 정수변수position을 -1시킨다
				System.out.println("삭제가 완료되었습니다.");
				//표준 출력장치에 적힌 문자열을 출력한다
				return;
				//빠른 종료 시킨다.
				}
					}
					
				}
			}
