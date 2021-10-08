package example_10_08_exception;

import java.io.FileWriter;
import java.io.IOException;

public class ExceptionSample2 {

	//throws는 수행문에서 발생한 예외를 직접 처리하지 않고, 이 메소드를 호출한 측에게 예외처리를 떠넘기는 키워드다.
	public static void main(String[] args) throws IOException {
		
		FileWriter writer = new FileWriter("test.txt");//FileWriter(String fileName) throws IOException을 하고 있다. 
		//파일에 기록할 수 있는 객체 
		writer.write("중앙HTA 2106기 화이팅!!!");//write에서도 IOException이 발생한다. 1개로 처리한다.
		writer.flush();//버퍼에 가득차지 않은 데이터들을 파일에 전부 보내도록하는 method
		writer.close();//종료
		System.out.println("### 정상실행 : 파일에 기록되었습니다. ");
	}
}
