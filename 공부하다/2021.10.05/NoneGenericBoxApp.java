package example_10_05_1_generic;

import java.util.Arrays;

public class NoneGenericBoxApp {

	public static void main(String[] args) {
		//Food객체를 여러 개 저장하는 NoneGenericBox 객체 생성
		NoneGenericBox foodBox = new NoneGenericBox();
		
		//생성된 NoneGenericBox 객체에 Food객체 저장한다.
		Food food1 = new Food("토마토",5000);
		Food food2 = new Food("복숭아", 13000 );
		Food food3 = new Food("고등어",12000);
		
		//void addItem(Object item) {...}이 실행된다
		foodBox.addItem(food1);	//저장될 때 Object타입으로 클래스 형변환 된다. 
		foodBox.addItem(food2); //저장될 때 Object타입으로 클래스 형변환 된다.
		foodBox.addItem(food3); //저장될 때 Object타입으로 클래스 형변환 된다.
		
		//NoneGenericBox에 다른 타입을 입력하기 에러가 나지 않음
		Contact contact = new Contact("홍길동","020-4154-4111","기업은행");
		foodBox.addItem(contact);//생성된 Box객체에 Food객체와 다른 객체가 저장해도 오류가 발생하지 않는다.(타입안정성이 보장되지 않음)
		//정상동작함, Food객체가 아닌 객체도 저장이 된다. 

		//NoneGenericBox객체에 저장된 Food객체 가져오기 
		//Object의 객체의 주소값이 반환된다.
		//Object getItem(int index) {...}가 실행됨
		Object obj1 = foodBox.getItem(0);
		Object obj2 = foodBox.getItem(1);
		Object obj3 = foodBox.getItem(2);
		Object obj4 = foodBox.getItem(3);
		
		//Food 타입으로 강제 형변환한다. 형변환연산자를 꼭 사용해야한다. 
		Food saveFood1 = (Food)obj1;
		Food saveFood2 = (Food)obj2;
		Food saveFood3 = (Food)obj3;
		
		
		System.out.println(saveFood1.getName() + "," + saveFood1.getPrice());
		System.out.println(saveFood2.getName() + "," + saveFood2.getPrice());
		System.out.println(saveFood3.getName() + "," + saveFood3.getPrice());
		
	}
}
