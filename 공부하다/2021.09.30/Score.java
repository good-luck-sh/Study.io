package example_09_30_stringApp;

public class Score {

	// 학생명, 국어, 영어, 수학, 총점, 평균
	//getter/setter메소드 정의하기 
	// 성적정보를 반환하도록 toString재정의 
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private int average;
	
	public Score() {}

	public Score(String name, int kor, int eng, int math ) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor + eng + math;
		this.average = total/3;
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

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(int average) {
		this.average = average;
	}


	@Override
	public String toString() {
		return "Score [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", total=" + total
				+ ", average=" + average + "]";
	}

	}
	

