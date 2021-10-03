package example_10_01_system;

import java.io.IOException;

public class SystemApp {

	public static void main(String[] args) throws IOException {
		System.out.println(System.err);//java.io.PrintStream@7d6f77cc
		System.out.println(System.in);//java.io.BufferedInputStream@5aaa6d82
		System.out.println(System.out);//java.io.PrintStream@73a28541
		
		// 아래의 수행문을 실행하면 출력결과가 매번 다르게 출력된다. 
		// System.err가 사용하는 출력객체와 System.out이 사용하는 출력객체가 서로 다른 객체기 때문에 
		// 각각 다른 전송통로로 메세지를 보낸다.
		// 따라서, 어떤 메세지가 먼저 출력될지 매번 변하게 된다. 
		System.err.println("표준 에러출력장치로 오류 메세지를 출력하자 ");//이클립스에서는 err를 빨간색으로 표시한다 
		System.err.println("표준 에러출력장치로 오류 메세지를 출력하자 ");//이클립스에서는 err를 빨간색으로 표시한다 
		System.out.println("표준 출력장치로 메세지를 출력하자 ");// 얘 혼자서 엄청 돌아다님
		System.err.println("표준 에러출력장치로 오류 메세지를 출력하자 ");//이클립스에서는 err를 빨간색으로 표시한다 
		System.err.println("표준 에러출력장치로 오류 메세지를 출력하자 ");//이클립스에서는 err를 빨간색으로 표시한다 
		System.err.println("표준 에러출력장치로 오류 메세지를 출력하자 ");//이클립스에서는 err를 빨간색으로 표시한다 
		
		//
		System.out.println();
		System.out.println();
		System.out.println();

		System.out.println("표준 입력장치로부터 입력을 읽어보자");
		//한글자랑 영어만 입력해야한다. 
		System.out.println("입력해보세요: ");
		int value = System.in.read();
		//오류메세지가 난다. throws로 예외처리를 해준다. 
		//반환타입은 정수값이다. 
		System.out.println(value);
		System.out.println((char)value);
		//유니코드의 값이 출력된다. 
		//char으로 형변환하면 어떤단어인지 알 수 있음
		
		
	}
}
