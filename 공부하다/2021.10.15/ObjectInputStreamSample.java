package example_10_15_object;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamSample {
	public static void main(String[] args) {
	/*
	 * ObjectInputStream
	 * 		-직렬화된 객체를 읽어서 역직렬화하는 스트림이다. 
	 * 		-역직렬화는 직렬화된 객체 정보를 읽어서 객체를 저장하고, 멤버변수 값도 복원하는 것이다. 
	 * 
	 */
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c:/temp/doc/Object.sav"));){
			
			//object.sav 파일에 직렬화된 객체정보를 읽어서 역직렬화(객체로 복원) 한다. 
			User user = (User)ois.readObject();//반환타입이 Object이다. 
			//실제로 어떤 객체가 올지 지정할 수 없기 떄문에 최고 조상인 Object로 반환타입을 입력해줘야한다.  
			
			System.out.println("아이디 :" + user.getId());
			System.out.println("이름 :" + user.getName());
			System.out.println("비밀번호 :" + user.getPassword()); //역직렬화를 제외하는 키워드를 입력했더니 null이라는 값이 출력된다. 
			System.out.println("포인트 :" + user.getPoint());
			System.out.println("자동차명 :" + user.getMyCar().getName());
			System.out.println("차량가격 :" + user.getMyCar().getPrice());
			System.out.println("제조회사 :" + user.getMyCar().getCompany());
			System.out.println("가입일 :" + user.getCreatedDate());
			
		}catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}catch(IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) { 
			//설계도를 찾을 수 없는 예외메세지
			e.printStackTrace();
		}
	}
}
