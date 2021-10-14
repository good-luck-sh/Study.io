package example_10_14_reader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;



public class BufferedReaderExample2 {

	public static void main(String[] args) throws Exception{
		
		//엑셀 Data를 CSV로 가져와서 리소스로 입력했다 
		//리소스 경로 (파일이 리소스가 아니다. )
		//주소만 있다면 전부 다 가져올 수 있다. 
		String path ="https://raw.githubusercontent.com/choosunsick/Korea_Stocks/master/Korea_Stocks_since_2021/000020.csv";
		//쿠키가 있어야한다. 
		//프로토콜, 호스트number,경로, 포트번호등이 들어가 있음 
		//이것을 분석해서 갖고 있는 객체가 URL이다.
		
		//java.net의 url
		URL url = new URL(path);
		//자원이 있는 주소 
		//URL주소가 가르키는 리소스를 1byte씩 읽어오는 스트림 객체를 획득함
		//InputStream inputStream = url.openStream();//File, jpeg,pnp를 얻을 수 있다. 지금은 text를 다운받는다.
		//바이트스트림과 연결되는 Reader객체 생성하기 
//		InputStreamReader isr = new InputStreamReader(inputStream);
		//한 라인씩 읽어오는 BufferedReader와 InputStreamReader객체를 연결한다. 
//		BufferedReader reader = new BufferedReader(isr);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		//이렇게 한꺼번에 적어서 완성할 수 있다.
		//한 줄씩 읽어올 수 있다. 
		//데이터에 대한 컬럼명 획득하기 
		
		//첫번째 줄 읽어서 버림
		reader.readLine();
		//총거래량 계산하기 
		
		long totalAmount = 0;
		
		//단방향이기 때문에 이미 지나간 것은 다시 읽을 수 없다. 그렇기 떄문에 첫번째줄 이후로 출력이 된다
		String text = null;
		while((text = reader.readLine()) != null) {
			System.out.println(text);
			String[] values = text.split(",");
			int amount = Integer.parseInt(values[5]);
			totalAmount += amount;
			
		}
		System.out.println("기간 내 총 거래금액 : " + totalAmount + "만(원)");
		//데이터를 읽어서 획득할 수 있다. 
		//
		reader.close();
		//4줄만 입력하면서 전체가 출력이 가능하다. 
		
//		String value1 = reader.readLine();
//		String value2 = reader.readLine();
//		String value3 = reader.readLine();
//		String value4 = reader.readLine();
//		String value5 = reader.readLine();
//		
//		System.out.println(value1);
//		System.out.println(value2);
//		System.out.println(value3);
//		System.out.println(value4);
//		System.out.println(value5);
		
		
	}
}
