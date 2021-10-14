package example_10_14_writer;

import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterExample2 {

	public static void main(String[] args) {
		/*
		 * PrintWriter
		 * 		-텍스트를 출력하는 객체다. 
		 * 		-write(String text), (보통의 출력객체의 경우는 이 메소드만 가지고 있다. )
		 * 		-println(String text)등의 메소드를 가지고 있다. 
		 * 		-중복정의된 println(값) 메소드를 가지고 있다. 
		 * 		-println메소드를 줄바꿈 문자를 자동으로 추가한다.
		 * 		-csv 데이터를 기록할 때 유용하다. 
		 * 		-현재 입력한 데이터 말고는 따로 기록하는 일이 없다. 
		 *		-업무용시스템을 만들기 때문에, 무의미한 데이터는 입력하지 않는다. 
		 *		-유용한 데이터는 특별한 형식으로 기록되어있다. 
		 *		-제일 유용한 자식이다. 
		 *		writer에서는 FileWriter와 PrintWriter만 기억하자.
		 *		이제 파일을 읽어보자
		 */
		try {
		PrintWriter writer = new PrintWriter("c:/temp/doc/example2.txt");
		writer.println("홍길동,100,80,70");
		writer.println("김유신,100,50,70");
		writer.println("강감찬,100,40,50");
		writer.println("김쩡글,100,100,100");
		writer.print(" ");
		writer.close();
		//text를 기록할때는 PrintWriter를 사용한다. 이게 짱임
		//println()자동 줄바꿈을 해줌
		//한줄씩 데이터를 기록할때에는 이 객체를 사용한다. 
		}catch(IOException e) {
			e.printStackTrace();
		}
		}
}
