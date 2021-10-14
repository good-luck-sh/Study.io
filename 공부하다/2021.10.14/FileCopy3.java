package example_10_14_copy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy3 {

	public static void main(String[] args) throws IOException {
		
		long beginUnixTime = System.currentTimeMillis();
		
		FileInputStream fis = new FileInputStream("c:/temp/doc/샘플.pdf");
		FileOutputStream fos = new FileOutputStream("c:/temp/doc/샘플복사본1.pdf");
		
		//InputStream과 Output스트임의 읽기 쓰기 속도를 향상 시키는 스트림이다. 
		BufferedInputStream in = new BufferedInputStream(fis);
		BufferedOutputStream out = new BufferedOutputStream(fos);
		
		int value = 0;
		while((value = in.read()) != -1) {
			out.write(value);
		}
		fis.close();
		fos.close();
		
		
		long endUnixTime = System.currentTimeMillis();
		System.out.println("소요시간 :" + (endUnixTime - beginUnixTime) + "밀리초");
	}
}
