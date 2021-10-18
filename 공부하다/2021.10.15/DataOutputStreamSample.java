package example_10_15_data;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamSample {

	public static void main(String[] args) {
		/*
		 * DataOutputStream
		 * 		기본자료형 및 문자열들을 타입과 값 그대로 출력하는 스트림이다. 
		 * 
		 */
		
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("c:/temp/doc/data.sav"));){
			
			//알아서 close가 됨 
			dos.writeInt(100);				//번호
			dos.writeUTF("자바의 정석");		//제목
			dos.writeInt(35000);			//가격
			dos.writeDouble(0.03);			//할인율
			dos.writeBoolean(false);		//절판유무 
			
			//이렇게 사용할 수 있다는 것을 알려주는 것임
			//정수, 실수 ,불린 값을 출력함. data.sav에 저장되게 할 예정
			//   d ?먮컮???뺤꽍  댏?왆Q?? 기록은 완료됨
			
		}catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
	}
}
