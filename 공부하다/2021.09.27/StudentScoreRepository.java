package example_09_27_inner_class_example;

public class StudentScoreRepository {

	private StudentScore[] database;
	
	
	public StudentScoreRepository() {
		database = new StudentScore[] {
				//생성자 메소드에 입력해서 database에 많은 데이터를 저장하려고함.
		new StudentScore("홍길동",100,80,70),		
		new StudentScore("김유신",80,90,70),		
		new StudentScore("강감찬",80,40,70),		
		new StudentScore("이순신",50,60,60),		
		new StudentScore("류관순",70,70,70),		
		new StudentScore("안중근",90,80,50),		
		new StudentScore("윤봉길",30,50,30),		
		new StudentScore("이봉창",60,30,30),		
		new StudentScore("민영환",90,20,20),		
		new StudentScore("김좌진",60,60,7),		
		new StudentScore("김구",40,50,1),		
		new StudentScore("김쩡동",90,90,14),		
		new StudentScore("이준",70,50,50),		
		new StudentScore("한용운",40,40,60),		
		new StudentScore("이성계",70,10,80),		
		new StudentScore("류성룡",40,30,90),		
		new StudentScore("김만중",70,40,100),		
		};
	}
	/**
	 * 새 성적 추가기능
	 * @param score 성적정보
	 */
	public void addNewStudentScore(StudentScore score) {
		
	}
	/**
	 * 지정된 이름으로 성적정보를 찾아서 반환하는 기능
	 * @param name 학생이름
	 * @return 성적정보
	 */
	public StudentScore getStudentScore(String name) {
		return null;
	}
	/**
	 * 합격점 이상의 평균점수를 얻은 학생들의 성적정보를 반환하는 기능
	 * @return 성적정보들
	 */
	public StudentScore[] getPassedStudentScore() {
		return null;	
	}
	/**
	 * 합격점 미만의 평균점수를 얻은 학생들의 성적정보를 반환하는 기능
	 * @return 성적정보들
	 */
	public StudentScore[] getUnPassedStudentScore() { // 기본적인 기능 
		return null;
	}
	/**
	 *  성적통계정보를 제공하는 객체를 반환하는 기능
	 * @return 성적통계정보를 제공하는 객체
	 */
	public ScoreStats getStats() { //이 메소드를 호출하면 객체가 호출됨
		return new ScoreStats();
	}
	//학생성적정보에 대한 통계정보를 제공하는 멤버내부클래스 구현하기 
	//학생들의 정보가 어떻게 되어있는지 모르지만 평균이 몇인지, 총점이 몇인지에 대해서 알고싶음. 그래서 내부클래스를 입력함
	//클래스안에서만 사용할 것이기 때문에 별도로 클래스를 만들지 않고, 멤버내부클래스로 입력원함
	/**
	 * 학생성적에 대한 통계정보를 제공하는 클래스다. 
	 * @author 김승희
	 *
	 */
	class ScoreStats { //내부클래스기 때문에 전체적으로 접근할 수 있음
		
		/**
		 * 전과목에 대한 평균점수를 반환한다. 
		 * @return 전 과목 평균점수
		 */
		public int average() { //평균점수
			int allTotal = 0;
			for(StudentScore score : database) {
				allTotal += score.getTotal();
			}
			return allTotal/(database.length*3);
			
		}
		/**
		 * 국어과목에 대한 평균점수를 반환한다.
		 * @return 국어과목 평균점수
		 */
		public int korAverage() { //국어점수평균
			int korTotal = 0;
			for(StudentScore score : database) {
				korTotal += score.getKor();
			}
			return korTotal/database.length;
		}
		/**
		 * 영어과목에 대한 평균점수를 반환한다. 
		 * @return 영어과목 평균점수
		 */
		public int engAverage() { //영어점수평균
			int engTotal = 0;
			for(StudentScore score : database) {
				engTotal += score.getEng();
			}
			return engTotal/database.length;
		}
		/**
		 * 수학과목에 대한 평균점수를 반환한다.
		 * @return 수학과목 평균점수
		 */
		public int mathAverage() {//수학점수평균
			int mathTotal = 0;
			for(int i = 0; i <database.length; i++) {
				mathTotal += i;
			}
			return mathTotal/database.length;
		}
		
	}
}
