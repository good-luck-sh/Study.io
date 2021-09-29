package example_09_29_object;

public class ObjectApp3 {

	public static void main(String[] args) {
		Student student1 = new Student(100,"홍길동", "컴퓨터공학과" ,3);
		Student student2 = new Student(200,"김유신", "전자공학과" ,2);
		Student student3 = new Student(300,"강감찬", "소프트웨어공학과" ,1);
		
		//Object의 String toString();
		// 객체의 정보("클래스의 전체이름 @해시코드 ")를 문자열로 반환한다.
		//클래스의 전체이름 : 클래스를 포함한 패키지의 이름
		System.out.println("### 객체의 정보를 조회해보자");
		String result1 = student1.toString();
		String result2 = student2.toString();
		String result3 = student3.toString();
		
		System.out.println("### 객체의 정보 : "+ result1); //example_09_29_object.Student@64 ,16진수로 표현됨
		System.out.println("### 객체의 정보 : "+ result2); //example_09_29_object.Student@c8 ,16진수로 표현됨
		System.out.println("### 객체의 정보 : "+ result3); //example_09_29_object.Student@12c ,16진수로 표현됨
		
		//System.out.println(참조변수)는 참조변수에 저장된 참조값(주소값)을 출력하지 않는다.
		//System.out.println(참조변수)는 System.out.println(참조변수.toString())과 동일한 코드다.
		
		System.out.println("###참조변수를 콘솔화면에 출력한 경우 ");
		System.out.println(student1);//참조변수 student1의 주소값이 아니라, student1이 참조하는 객체의 toString()의 반환값이 출력된다. 
		System.out.println(student2);//참조변수 student2의 주소값이 아니라, student2이 참조하는 객체의 toString()의 반환값이 출력된다. 
		System.out.println(student3);//참조변수 student3의 주소값이 아니라, student3이 참조하는 객체의 toString()의 반환값이 출력된다.
		System.out.println("###참조변수로 참조되는 객체의 toString()이 반환하는 값을 출력하는 경우  ");
		System.out.println(student1.toString());
		System.out.println(student2.toString());
		System.out.println(student3.toString());
		//새롭게 정의한 반환값이 출력되는 것을 알 수 있다. 
		//값에 뭐가 들어있는지 파악하는 것이 훨씬 편하다
		
		System.out.println("배열에 저장된 Student객체의 정보를 출력하기 ");
		Student[] students = new Student[3];
		students[0] = student1;
		students[1] = student2;
		students[2] = student3;
		
		System.out.println(students.toString());
		//쓰레기 값이 출력됨
		//java.util.Arrays(배열에 관련한 유용한 위치)을 사용해서 배열인 toString의 메소드 재정의가 실행이된다.
		System.out.println(java.util.Arrays.toString(students));

		
	}
}
