package example_10_05_1_generic;

public class GenericBoxApp3 {

	public static void main(String[] args) {
		
		//제네릭 크랠스로 객체를 생성할 때, 타입파라미터를 지정하지 않았음<T>생략함
		GenericBox box = new GenericBox();
		//노란색으로 줄이가고, 타입지정을 안하면 Object로 타입이된다.
		
		//타입파라미터에 타입을 지정하지 않으면 타입파미터자리는 전부 Object가 된다.
		
		//타입 안정성이 보장되지 않음
		//void addItem(T item) {...}이
		//void addItem(Object item){...}으로 실행된다. 
		
		box.addItem(new Food("토마토", 5000));
		box.addItem(1000); 	//정수 1000은 오토박싱된다. box.addItem(new Integer(1000))
		box.addItem(new Contact("홍길동","010-1211-1111","배민"));
		box.addItem("강감찬");
		
		//저장된 객체를 사용할 때 형변환 연산자를 사용해야 함
		//T getItem(int index) {...}이
		//Object getItem(int index){...}으로 실행된다.
		Food savedItem1 = (Food)box.getItem(0);
		Integer savedItem2 = (Integer)box.getItem(1);
		Contact savedItem3 = (Contact)box.getItem(2);
		String savedItem4 = (String)box.getItem(3);
	}
}
