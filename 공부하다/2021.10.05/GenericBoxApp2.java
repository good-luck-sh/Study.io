package example_10_05_1_generic;

public class GenericBoxApp2 {

	public static void main(String[] args) {
		
		GenericBox<Contact> contactBox = new GenericBox<>();
		
		Contact contact1 = new Contact("홍길동" , "010-1234-5678","삼성전자");
		Contact contact2 = new Contact("홍길동" , "010-1234-0001","LG전자");
		Contact contact3 = new Contact("홍길동" , "010-1234-0002","쿠팡");
		
		//void addItem(T item) {...} 이
		//void addItem(Contact item) {...}으로 실행된다.
		contactBox.addItem(contact1);
		contactBox.addItem(contact2);
		contactBox.addItem(contact3);
		
		//T getItem(int index) {...} 이
		//Contact getItem(int index) {...}으로 실행된다. 형변환 연산자 필요없다.
		Contact savedContect1 = contactBox.getItem(0);
		Contact savedContect2 = contactBox.getItem(1);
		Contact savedContect3 = contactBox.getItem(2);
		
		System.out.println(savedContect1.getName() +","+savedContect1.getTel()+","+savedContect1.getCompany());
		System.out.println(savedContect2.getName() +","+savedContect2.getTel()+","+savedContect2.getCompany());
		System.out.println(savedContect3.getName() +","+savedContect3.getTel()+","+savedContect3.getCompany());
	}
}
