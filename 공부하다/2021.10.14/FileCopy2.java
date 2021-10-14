package example_10_14_copy;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class FileCopy2 {

	public static void main(String[] args) throws IOException {
		
		URL url = new URL("https://search.naver.com/search.naver?where=image&query=%EC%A0%95%EC%9A%B0%EC%84%B1&sm=tab_txc#");
		InputStream in = url.openStream();//어떤 자원과 연결된 inputStream
		
		//복사본 파일로 1byte씩 출력하는 스트림 객체 생성
		FileOutputStream out = new FileOutputStream("c:/temp/doc/정우성사진.jpg");//이미지를 긁어옴
		//다른 컴퓨터로 보낼수 있음FileOutPut말고 다른 객체로 사용한다고 하면

		int value = 0;
		while((value = in.read())!= -1) {
			out.write(value);
		}
		in.close();
		out.close();
	}
}
