package example_10_07_02_comparable;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ListSample3 {

	public static void main(String[] args) {
		List<Score> scoreList = Arrays.asList(new Score("김유신",80,80,80),
				new Score("강감찬",100,90,100),
				new Score("이순신",70,40,70),
				new Score("류관순",20,80,90),
				new Score("한창호",90,80,90),
				new Score("김쩡글",70,80,70),
				new Score("쩡글공",80,20,90),
				new Score("왈왈이",90,80,90),
				new Score("봉창맨",10,20,40),
				new Score("두둑",90,80,90),
				new Score("와다다",90,80,90),
				new Score("류관순",90,80,90),
				new Score("안중근",85,65,55));
		
		//총점을 비교해서 내림차순으로 정렬시키는 Comparator 구현 객체
		System.out.println("### 총점을 비교해서 내림차순으로 정렬해서 출력하기 ");
		Comparator<Score> totalComparator = new Comparator<>() {
			public int compare(Score score1, Score score2) {
				return score2.getTotal() - score1.getTotal();
			}
		};
		Collections.sort(scoreList, totalComparator);//아직 익명클래스를 만들지 않아서 에러가 난다.
		//익명클래스를 만들고 내림차순 정렬이 완료되었다. 
		
		for(Score score : scoreList) {
			System.out.println(score.getName() + " : " + score.getTotal());
		}
		
		//학생이름을 비교해서 이름의 오름차순으로 정렬시키는 Comparator구현객체 
		System.out.println("### 이름에 대한 오름차순으로 정렬해서 출력하기 ");
		Comparator<Score> nameComparator = new Comparator<>() {
			public int compare(Score score1, Score score2) {
				return score1.getName().compareTo(score2.getName());
				//name으로 하게 되면 숫자가 아니기 때문에 -연산이 진행되지 않음 
			}
		};
		Collections.sort(scoreList, nameComparator);//아직 익명클래스를 만들지 않아서 에러가 난다.
		for(Score score : scoreList) {
			System.out.println(score.getName() + " : " + score.getTotal());
		}
		
		//국어점수를 비교해서 국어점수를 오름차순으로 정렬시키기 
		Collections.sort(scoreList, new Comparator<Score>() {
			@Override
			public int compare(Score score1, Score score2) {
				return score1.getKor() - score2.getKor();
			}
		});
		System.out.println("###국어점수에 대한 오름차순으로 정렬해서 출력하기 ");
		for(Score score : scoreList) {
			System.out.println(score.getName()+" : "+score.getKor());
		}
		
		//영어점수를 비교해서 영어점수로 오름차순으로 정렬하기 
		System.out.println("###영어점수에 대한 오름차순으로 정렬해서 출력하기");
		Collections.sort(scoreList,(Score s1, Score s2) -> s1.getEng() - s2.getEng());//람다표현식
		for(Score score : scoreList) {
			System.out.println(score.getName()+":"+score.getEng());
		}
	}
	
	static class Score{
		private String name;
		private int kor; 
		private int eng;
		private int math;
		
		public Score(String name, int kor, int eng, int math) {
			this.name = name; 
			this.kor = kor; 
			this.eng = eng;
			this.math = math;
		}
		public String getName() {
			return name;
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
		public void setMath(int math) {
			this.math = math;
		}
		public int getTotal() { //변수가 없어도 메소드 만드는 건 문제없다.
			return kor + eng + math;
		}
		public int getAverage() {
			return getTotal()/3;
		}
		
	}
}
