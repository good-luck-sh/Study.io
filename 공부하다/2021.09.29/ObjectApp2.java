package example_09_29_object;

public class ObjectApp2 {
	public static void main(String[] args) {
		
		Student student1 = new Student(100,"홍길동", "컴퓨터공학과" ,3);
		Student student2 = new Student(100,"홍길동", "컴퓨터공학과" ,3);
		//설계도가 같아도, 주소값이 다르게 new연산자로 객체를 생성할 수 있다.
		Student student3 = student1; 
		//student1의 주소값을 student3에 입력함
		Student student4 = student2;
		//student2의 주소값을 student4에 입력함
		
		//Object의 int hashCode();
		//객체의 해시코드값을 정수로 반환한다. 
		//같은 객체는 해시코드값도 같다.
		//해시코드값이 같으면 같은 객체다 ( maybe다 true일 수도 있고, false일 수도 있다.)
		//같은 객체면 해시코드가 같으면 같은 객체인데, 그 역은 아니다. 
		// 해시코드값이 같다고 같은 객체는 아니다. 
		//해시코드의 값이 같다고해서 같은 주소값이 아니다.
		System.out.println("### 객체의 해시코드값을 출력해보자");
		int result1 = student1.hashCode(); //return no;으로 학번이 같으면 학번으로 반환하도록함 
		int result2 = student2.hashCode();
		int result3 = student3.hashCode();
		int result4 = student4.hashCode();
		
		System.out.println("### 해시코드" + result1); 
		System.out.println("### 해시코드" + result2);	
		System.out.println("### 해시코드" + result3);
		System.out.println("### 해시코드" + result4);
		//1번과 3번의 해쉬코드와 2번과 4번의 해시코드의 값이 동일함
		// 해시코드의 값이 주소값이 아님.강사님과 같은 해시코드의 값이 나옴
		// 어떤 연산식으로 계산된 값이라는 의미임 

	}

}
