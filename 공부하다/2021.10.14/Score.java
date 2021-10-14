package example_10_14_reader_writer;

public class Score {

	private String name; 
	private int kor; 
	private int eng;
	private int math; 
	
	public Score() {}
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
	public int getTotal() {
		return kor + eng + math;
	}
	public int getAverage() {
		return getTotal()/3;
	}
}
