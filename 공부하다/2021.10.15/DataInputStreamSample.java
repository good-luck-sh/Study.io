package example_10_15_data;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamSample {

	public static void main(String[] args) {
		/*
		 * DataInputStream 
		 * 
		 * 			-DataOutputStream을 사용해서 타입과 값 그대로 출력시킨 값을 읽어서 원래 값으로 복원시키는 스트림
		 * 			//순서가 중요하다. 입력된 Int,UTF순서대로 불러와야한다. 
		 */
		
		try(DataInputStream dis = new DataInputStream(new FileInputStream("c:/temp/doc/data.sav"));){
			int no = dis.readInt();
			String title = dis.readUTF();
			int price = dis.readInt();
			double discountRate = dis.readDouble();
			boolean soldOut = dis.readBoolean();
			
			System.out.println("번호 : " + no);
			System.out.println("제목 : " + title);
			System.out.println("가격 " + price);
			System.out.println("할인여부 : " + discountRate);
			System.out.println("매진여부 : " + soldOut);
			
			//DataOutputStream  --> DataInputStream (원래의 데이타 그대로 출력됨)
			//순서를 바꿀 경우 error가 나거나, 이상한 값이 출력된다.
			//순서 그대로 read해야지 볼 수 있다. 
		}catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
