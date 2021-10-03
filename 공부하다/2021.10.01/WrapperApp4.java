package example_10_01_wrapper;

public class WrapperApp4 {

	public static void main(String[] args) {
		//Wrapper클래스의 parseXXX(문자열) 메소드
		/*
		 * 문자열을 기본자료형 타입의 값으로 변환하는 정적 메소드 
		 * 		int 		Integer.parseInt(String text)
		 * 		long		Long.parseLong(String text)
		 *	    double 		Double.parseDouble(String text)
		 * 		boolean 	Boolean.parseBoolean(String text)
		 * 		//boolean은 글자 true와 false을 boolean값으로 변경해줌 
		 */
		
		System.out.println("### 문자열을 int타입의 정수값으로 변환하기");
		int value1 = Integer.parseInt("12345");
		int value2 = Integer.parseInt("12345");		//	"12_345" 	  오류 발생, 자리수를 나타내는 _문자를 허용하지 않음
		//정수 작성할 때는 _를 써도 되지만, 문자열을 작성할 때는 하이픈을 넣을 수 없다.
		//NumberFormatException 은 많이보게 될 오류
		//int value3 = Integer.parseInt("12345.6"); //"12345.6" 	오류 발생, 정수변환하기 때문에 소숫점값을 허용하지 않음
		//숫자외에 어떤 문자도 있어서는 안된다. 
		//int value4 = Integer.parseInt(" 12345");//" 12345" 		오류 발생, 공백문자를 허용하지 않음
		//int value5 = Integer.parseInt("12,345")// 12,345			오류 발생, 자리수를 나타내는 , 문자를 허용하지 않음
		//long이나 double이나 마찬가지다. 
		
		
		
		System.out.println(value1); // 1번째 경우만 숫자로 변환가능한 유효한 문자열이다. 
		//그렇기 때문에 사용자가 입력한 것에서 공백을 없애고, 숫자외의 값이 들어가지 않도록 조절해야한다. 
		//사용자의 입력을 최소화 하고, 고를 수 있도록 조정하는 것이 중요하다. 
		//System.out.println(value2);
		//System.out.println(value3);
		
		System.out.println("### 문자열을 double 타입의 실수값으로 변환하기 ");
		double value6 = Double.parseDouble("123.15"); //실수로 변환하기 때문에 소숫점 값을 허용한다. 
		double value7 = Double.parseDouble("123.");		//123.0		소숫점만 표시하고, 소수점이하 값이 없어도 상관없다.
		double value8 = Double.parseDouble("123");		//123.0		정수형의 문자열도 상관없다.
		
		System.out.println(value6);
		System.out.println(value7);
		System.out.println(value8);
		
		
		
		/*
		 * java.lang.NumberFormatException
		 * 		숫자형식의 문자열이 아닌 값을 숫자로 변환할 때 발생하는 오류다.
		 */
		
 	}
}
