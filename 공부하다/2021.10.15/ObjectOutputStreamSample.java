package example_10_15_object;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class ObjectOutputStreamSample {

	public static void main(String[] args) {
		/*
		 * ObjectOutpurStream 
		 * 		-객체를 직렬화 시켜고 출력하는 스트림이다. 
		 * 		-직렬화는 객체를 스트림으로 출력가능한 상태로 변환하는 것을 말한다.
		 * 		-직렬화는 생성된 객체의 클래스명, 멤버변수의 이름과 타입, 멤버변수에 저장된 값을 Stream으로 출력하는 것이다. 
		 * 		
		 */
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c:/temp/doc/object.sav"));){
			//네트워크 전송도 당연히 가능하다. 
			
			User user = new User();//기본생성자 불러옴
			user.setId("hong");
			user.setPassword("zxcv1234"); //역직렬화 제외 transient키워드를 사용하면 직렬화에서 제외된다. 
			user.setPoint(35000);
			user.setName("홍길동");
			user.setCreatedDate(new Date());
			user.setMyCar(new Car("제네시스 GV80", "현대자동차 ",800000L));
			//Car를 추가했다. 또 오류가 난다. 
			//매개변수 모두 직렬화를 해줘야 가능하다.  --> 한개라도 직렬화가 포함되어 있지않다면 직렬화가 되지 않는다. 
			//Date, String도 직렬화가 되었던 것이다.
			//Car에 직렬화 마크업인터페이스 입력 후 직렬화가 됫다. 
			
			
			//생성된 User객체를 직렬화해서 Stream으로 출력하기 
			oos.writeObject(user);
			//java.io.NotSerializableException 에러가 나옴
			//모든 객체는 직렬화가 안되는 것이 기본적임. 
			//직렬화, 복제를 허락해야 가능하다. 
			//직렬화하려는 VO에 마크업인터페이스 구현해야함
			//ы sr example_10_15_object.User*꾙굘 I pointL createdDatet Ljava/util/Date;L idt Ljava/lang/String;
			//클래스명, Date타입, 변수타입들, 내용이 전달됨
			//L nameq ~ L passwordq ~ xp  댏sr java.util.Datehj?KYt  xpw  |걽?xt hongt 	?띻만?셳 zxcv1234
			
		}catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
	}
}
