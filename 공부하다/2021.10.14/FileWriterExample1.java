package example_10_14_writer;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample1 {

	public static void main(String[] args) {
		
		/*
		 * FileWriter 
		 * 		파일에 텍스트를 기록(출력)한다. 
		 */
		try {
			//example1.txt 파일에 텍스트를 기록하는 FileWriter객체를 생성함.
			//example1.txt 파일이 존재하지 않으면 example1.txt 파일을 생성한 다음 텍스트를 기록한다. 
			//example1.txt 파일이 존재하면 새로 example1.txt 파일을 생성하지 않고, 기존 데이터에 덮어쓴다.
			//경로를 입력하고 싶은 경우 경로를 그대로 입력하면 된다. 
		FileWriter writer = new FileWriter("c:/temp/doc/example1.txt");
		
		//기록하는 방법
		writer.write("정보처리기사 실기시험 미치겠다." + System.lineSeparator());
		writer.write("정보처리기사 실기시험 미치겠다." + System.lineSeparator());
		writer.write("정보처리기사 실기시험 미치겠다." + System.lineSeparator());
		writer.write("정보처리기사 실기시험 미치겠다." + System.lineSeparator());
		writer.write("정보처리기사 실기시험 미치겠다." + System.lineSeparator());
		writer.write("정보처리기사 실기시험 미치겠다." + System.lineSeparator());
		writer.write("정보처리기사 실기시험 미치겠다." + System.lineSeparator());
		// + System.lineSeparator();이 시스템의 컴퓨터 운영체제에 줄바꿈문자를 입력하는 메소드
		//여러번 작성하면 줄바꿈없이 입력된다. 
		//text만 입력되기 때문에 줄바꿈문자는 따로 입력해줘야한다. 
		//write가 중복정의 되어있다. String의 반환타입을 사용하면 된다.
		//자원 누수가 발생하기 때문에 참조변수에 노란선이 간다. 
		//꼭 close를 해줘야한다. 
		writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
