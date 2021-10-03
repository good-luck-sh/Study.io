package example_10_01_wrapper;

public class WrapperApp {

	public static void main(String[] args) {
		
		//Wrapper 클래스 사용하기 
		int a = 10;						// 참조변수 a에는 기본자료형 타입의 정수값 10이 저장되어 있다.
		Integer a1 = new Integer(10);	// a1는 정수 10을 포함하고 있는 Integer객체의 주소값을 가지고 있다. 
		Integer a2 = new Integer("1000");// a2는 문자열 "1000"을 1000으로 변경해서 포함하고 있는 Integer객체의 주소값을 가지고 있다.
	
		long b1 = 100000000000L; 
		Long b2 = new Long(100000000000L); 
		Long b3 = new Long("100000000000L");
		
		double c1 = 3.14;
		Double c2 = new Double(3.14); 
		Double c3 = new Double("3.14");
	
	
	}
}
