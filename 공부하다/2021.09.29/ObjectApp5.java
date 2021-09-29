package example_09_29_object;

public class ObjectApp5{

	public static void main(String[] args) throws CloneNotSupportedException {
		
		//원복 객체와 복제된 객체의 정보를 확인해보면, 해시코드의 값이 다르다. 
		//즉, 원본객체와 복제된 객체는 서로 다른 객체임을 알 수 있다.
		Person original = new Person("홍길동", "010-111-111","hong@gmail.com");
		//ObjectApp5 a = new ObjectApp5();
		//a.clone();
		System.out.println("원본객체 : " + original);//ObjectApp5$Person@5aaa6d82
		
		Person clonePerson = original.copy();
		System.out.println("복제된 객체 : " + clonePerson);//ObjectApp5$Person@73a28541
		
		System.out.println("복제된 객체 확인하기");
		System.out.println(clonePerson.name);
		System.out.println(clonePerson.tel);
		System.out.println(clonePerson.email);
		
		
	}
	
	//정적 내부 클래스 , 내부에서만 사용하기 위해서 작성함
	static class Person implements Cloneable {
		//클론을 복사할수 있게 마크업인터페이스를 상속받음
		String name; 
		String tel; 
		String email; 
	
	public Person(String name, String tel, String email) {
		this.name = name; 
		this.tel = tel; 
		this.email = email;
	}

	
	//객체의 복제본을 제공하는 메소드
	public Person copy() throws CloneNotSupportedException {
		 Person person  = (Person)this.clone();
		 return person; // 이상태로 끝내면 복제가 안됨
		 //내가 원한다고 아무거나 복제를 할 수 없음 정해놓았슴.
		 }
	}
}
