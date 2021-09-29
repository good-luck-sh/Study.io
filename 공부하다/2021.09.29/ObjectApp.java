package example_09_29_object;

public class ObjectApp {

	public static void main(String[] args) {
		Student student1 = new Student(100,"홍길동", "컴퓨터공학과" ,3);
		Student student2 = new Student(100,"홍길동", "컴퓨터공학과" ,3);
		//설계도가 같아도, 주소값이 다르게 new연산자로 객체를 생성할 수 있다.
		Student student3 = student1; 
		//student1의 주소값을 student3에 입력함
		Student student4 = student2;
		//student2의 주소값을 student4에 입력함
		
		//object의 boolean equals(Object other)
		//boolean값을 반환하는 것을 확인할 수 있음
		//매개변수가 object인것을 확인 할 수 있다. -->어떤 객체가 오던지 가능하다를 의미함
		
		boolean result1 = student1.equals(student2);		
		boolean result2 = student2.equals(student1);
		System.out.println("###동일한 객체인가?" + result1);	//false
		System.out.println("###동일한 객체인가?" + result2);	//false
		//결과값이 둘다 false값이 출력된다. 
		// 두 객체의 참조값을 비교해서 참조값이 같은 경우에 true를 반환한다. 
		
		boolean result3 = student3.equals(student1);
		boolean result4 = student4.equals(student2);
		System.out.println("###동일한 객체인가? " + result3);	//true
		System.out.println("###동일한 객체인가? " + result4);	//true
		
		//equalse를 메소드를 재정의하고, 동일성 비교가 true가 되도록 만들었다. 
		// hashcode와 equalse 둘을 재정의하여서 동일성하게 만들 수 있다. 
		
		//객체에 대해서 비교 연산자를 사용할 수 있다. 
		//객체에 대해서 비교 연산을 실행하면 주소값 비교를 한다. 
		//이것은 동일성 원칙으로 따짐 그렇기때문에 false로 나옴 
		
		boolean result5 = student1 == student2;
		boolean result6 = student1 == student3;
		//student1과 student2가 같은 값을 가지냐 ==을 써서 물어봄
		System.out.println("----------------------------");
		System.out.println("###동일한 객체인가? " + result5);	//false
		System.out.println("###동일한 객체인가? " + result6);	//true
		
		

		
	}
	
}
