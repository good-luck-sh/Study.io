package example_10_13_exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExampleSample1 {
	static Scanner scan = new Scanner(System.in); //메인에서 전부 다 적기 위함으로 static선언
	
	//숫자를 읽어오는 별도의 메소드를 입력함
	/**
	 * 키보드 입력을 읽어서 정수값으로 반환하는 메소드 
	 * @return 키보드로 입력한 숫자
	 */
	static int readInt() {
		int number = 0;
		while(true) { //약간 억지스러운 코드 이렇게 오류를 회피할 수 있다는 것을 알려주는 것임
			
			try {
			number = scan.nextInt(); //InputMismatchException 발생, InputMismatchException은 RunTimeException자손, 예외처리 필요없음
			break;
		} catch(InputMismatchException ex) {
			//오류가 발생했으면 다시 출력문을 출력할 것
			System.out.print("숫자를 다시 입력해주세요 :");
		}
	}
		return number;
	}
	
	public static void main(String[] args) {
		//예외처리하기 
		System.out.println("### 두 수를 입력받아서 곱셈한 결과를 출력하는 프로그램 ");

		System.out.print("첫 번째 숫자 입력: ");
		int value1 = ExampleSample1.readInt();
		
		System.out.print("두 번째 숫자 입력: ");
		int value2 = ExampleSample1.readInt();

		long result = value1*value2;
		System.out.println("곱셈한 결과 : " + result);
		
	}
}
