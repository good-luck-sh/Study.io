package example_10_08_exception;

import java.io.FileWriter;
import java.io.IOException;

public class ExceptionSample3 {

	//예외처리를 위임하기 
	// 1. new FileWriter(), write(), flush(), close() 메소드가 IOException의 처리를 writeText()에게 위임함
	// 2. writeText()메소드는 IOException의 처리를 main()에게 위임함.
	// 3. main()메소드는 IOException의 처리를 JVM에게 위임함
	// * JVM에게 예외처리를 위임하는 것은 예외처리를 하지 않은 것과 동일하다. 
	// 	마지막 처리는 꼭 해야한다. 프론트컨트롤러에서는 꼭 해야하는 것이다. 안그러면 JVM에게 넘어가서 파일이 죽어버림.
	public static void main(String[] args) throws IOException {
		
		FileUtils.writeText("c:/temp/java/abc.text","예외 떠넘기기 연습입니다.");
		//또 에러 메서지가 뜸.
	}
	
	static class FileUtils{
		
		//writeText() 메소드를 호출하는 측에서는 IOException 예외를 처리해야 한다. 
		public static void writeText(String path, String text) throws IOException {
			//throws으로 예외처리를 위임함으로써 여기 메소드에서는 책임질 필요가 없어진다.
			
			FileWriter writer = new FileWriter(path); 
			writer.write(text);
			writer.flush();
			writer.close();
		}
	}
	
}
