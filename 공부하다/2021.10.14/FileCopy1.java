package example_10_14_copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy1 {

	public static void main(String[] args) throws IOException {
		
		//원본파일을 1byte씩 읽어오는 스트림 객체 생성
		FileInputStream in = new FileInputStream("c:/temp/doc/샘플.jpg");
		//복사본 파일을 생성하고 1byte씩 출력하는 스트림 객체 생성
		FileOutputStream out = new FileOutputStream("c:/temp/doc/샘플복사본.jpg");
		
		//파일이 얼마나 큰지 모름, 그러나 파일의 끝은 -1이다. 
		//1byte씩 읽은 값을 저장하는 변수
		int value = 0;
		//1byte씩 읽어서 value에 저장하고, value에 저장된 값이 -1이 나올때까지 수행문 반복
		while((value = in.read()) != -1) {
			//value에 저장된 값을 복사본파일에 저장
			out.write(value);
		}
		//copy코드는 이게 끝임 
		
		//읽어서 기록하고 읽어서 기록하는 형태로 만듦
//		int value1 = in.read(); //byte로 읽는데 4byte를 읽음 
//		out.write(value1);
//
//		int value2 = in.read(); 
//		out.write(value2);
//		
//		int value3 = in.read(); 
//		out.write(value3);
//		//in으로 읽어서 out으로 기록, 이게 복사임
	 
		
		
		in.close();
		out.close();
	}
}
