package example_10_08_exception;

import java.io.FileWriter;
import java.io.IOException;


public class ExceptionSample1 {

	public static void main(String[] args) {
		
		try {
		FileWriter writer = new FileWriter("test.txt");//FileWriter(String fileName) throws IOException을 하고 있다. 
		//파일에 기록할 수 있는 객체 
		writer.write("중앙HTA 2106기 화이팅!!!");//write에서도 IOException이 발생한다. 1개로 처리한다.
		writer.flush();//버퍼에 가득차지 않은 데이터들을 파일에 전부 보내도록하는 method
		writer.close();//종료
		System.out.println("### 정상실행 : 파일에 기록되었습니다. ");
		//프로젝트쪽에 refresh를 사용하면 txt파일이 생성된다. 
		} catch (IOException ex) {
			System.out.println("### 오류발생 : 파일 생성 중 오류가 발생하였습니다. ");
			
			//오류 발생시 오류 수정을 위한 디버깅 정보를 화면에 출력한다. 
			ex.printStackTrace();//모든 예외클래스들이 전부 가지고 있는 메소드
		}
	}
}
