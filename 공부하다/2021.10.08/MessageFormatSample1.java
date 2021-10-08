package example_10_08_formating;

import java.text.MessageFormat;

public class MessageFormatSample1 {

	public static void main(String[] args) {
		
		//String MessageFormat.format(String pattern, Object ...arguments)는 아래와 같이 사용해도 된다.
		//String MessageFormat.format(String pattern, Object[] arguments)//동일한 값이면 배열 넣고 표시해도 된다. 
		Score score = new Score("홍길동", 100, 90, 80);
		
		String pattern = "{0} 학생의 성적은 국어:{1}점, 영어:{2}점, 수학:{3}점, 평균점수:{4}점 입니다.";
		//이렇게 표시하고 싶음 홍길동 학생의 성적은 국어:100점, 영어:90점, 수학:80점, 평균점수:90점 입니다.
		String text	= MessageFormat.format(pattern, score.getName(),score.getKor(),score.getEng(),score.getMath(),score.getAverage());
		System.out.println(text);
		//더하기로 붙이지 않고 들어갈 자리를 표시해주면 됨
		
		Object[] names = {"이순신","김유신","강감찬"};
		MessageFormat mf = new MessageFormat("참석자 명단 :{0} 부장님,{1} 차장님,{2} 차장님 ");
		String text2 = mf.format(names);
		System.out.println(text2);
		
		String text3 = MessageFormat.format("참석자 명단 :{0} 부장님,{1} 차장님,{2} 차장님", names);
		System.out.println(text3);
	}
	
	static class Score{
		private String name; 
		private int kor;
		private int eng;
		private int math;
		
		public Score(String name, int kor, int eng, int math){
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getKor() {
			return kor;
		}
		public int getEng() {
			return eng;
		}
		public int getMath() {
			return math;
		}

		public int getTotal() {
			return kor + eng + math;
		}
		public double getAverage() {
			return getTotal()/3;
		}
		
	}
}
