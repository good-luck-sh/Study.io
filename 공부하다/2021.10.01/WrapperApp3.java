package example_10_01_wrapper;

public class WrapperApp3 {

	public static void main(String[] args) {
		
		//10진수를 여러 진법의 숫자로 표현할 수 있다.
		String value1 = Integer.toBinaryString(123456);
		String value2 = Integer.toOctalString(123456);
		String value3 = Integer.toHexString(123456);
		
		System.out.println("123456에 대한 2진수 값 :" + value1);//11110001001000000
		System.out.println("123456에 대한 8진수 값 :" + value2);//361100
		System.out.println("123456에 대한 16진수 값 :" + value3);//1e240

		//여러 진법의 숫자를 10진수로 변환하기 
		int number1 = Integer.parseInt("123456");
		int number2 = Integer.parseInt("11110001001000000",2);
		int number3 = Integer.parseInt("361100",8);
		int number4 = Integer.parseInt("1e240",16);
		
		System.out.println("123456을 10진법으로 변환한 숫자" + number1);
		System.out.println("11110001001000000을 2진법으로 환산해서 10진법으로 변환한 숫자" + number2);
		System.out.println("361100을 8진법으로 환산해서 10진법으로 변환한 숫자" + number3);
		System.out.println("1e240을 16진법으로 환산해서 10진법으로 변환한 숫자" + number4);
		
	}
}
