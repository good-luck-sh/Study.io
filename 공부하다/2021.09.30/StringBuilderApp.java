package example_09_30_stringbuilder;

public class StringBuilderApp {

	public static void main(String[] args) {
		
		Score score = new Score("홍길동",100,70,60);
		//홍길동과 관련된 text를 표현하고싶음
		//String text = "홍길동" + 100 + 70 + 60;
		
		//문자열을 +로 붙이는 건 좋지 않음 : 이유 ->String의 불변성때문에 
		// + 연산자로 문자열과 다른 값들을 연결시키면 연결시킬때마다 새로운 String객체가 생성된다.(String객체가 불변객체이기 때문이다.)
		//"홍길동"		  	새 String객체 생성됨
		//"홍길동100"			새 String객체 생성됨 * 위에서 생성된 "String" 에 100; 추가된 것이 아니라 완전히 새로운 객체가 생성된 것임
		//"홍길동10070"		새 String객체 생성됨 * 위에서 생성된 "String" 에 70; 추가된 것이 아니라 완전히 새로운 객체가 생성된 것임
		//"홍길동1007060"		새 String객체 생성됨 * 위에서 생성된 "String" 에 60; 추가된 것이 아니라 완전히 새로운 객체가 생성된 것임
		//최종 문자열 "홍길동1007060"이 만들기 위해서 String객체 3개가 추가로 생성되었음
		//따라서, + 연산자를 사용하는 것은 불필요한 String객체를 생성하게 되고, 메모리 낭비의 원인이 된다. 
		
		String text =  "";
		text = score.getName() +score.getKor() + score.getEng() + score.getMath();
		System.out.println(text);
		//이렇게 정의해도 String builder에 입력이 되도록 변경된다.
		
		//StringBuffer나 StringBuilder를 사용해서 문자열과 다른 값을 연결하자 
		StringBuilder builder = new StringBuilder();
		//StringBuilder객체의 내부 버퍼에 값을 추가함, 추가적인 객체생성이 발생하지 않음
		builder.append(score.getName());
		builder.append(score.getKor());
		builder.append(score.getEng());
		builder.append(score.getMath());
		
		//StringBuilder객체의 toString()은 버퍼에 저장된 값을 문자열로 반환한다.
		String result = builder.toString();
		System.out.println(result);
		
		
		
	}
	
	static class Score{//정적클래스 만듦
		String name;
		int kor;
		int eng; 
		int math;
		
		public Score(String name, int kor, int eng, int math) {
			this.name = name;
			this.kor = kor;
			this.eng = eng; 
			this.math = math;
		}
		public String getName() { //getN ->ctrl + spaceBar
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
	}
}
