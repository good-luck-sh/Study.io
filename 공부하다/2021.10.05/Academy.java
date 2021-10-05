package example_10_05_3_generic_wildcard;

public class Academy {

	//모든과정등록하기 
	//Course<?>는
	//		Course<T>의 T가 무엇이든 상관없다.
	public void 모든과정등록(Course<?> course) { //타입이 상관없다는 의미임
		
	}
	//전공과정등록하기 
	//전공과정은 Course<Student>, Course<PostGraduatedStudent>객체다.
	//Course<? extends Student>는
	//		Course<T>의 T가 Student, PostGraduatedSudent로 지정된 객체만 허용한다.
	public void 전공과정등록(Course<? extends Student> course) {
		
	}
	//대학원과정등록하기 
	//대학원과정은 Course<PostGraduatedStudent>객체다.
	//Course<? extends Student>는
	//		Course<T>의 T가 PostGraduatedStudent로 지정된 객체만 허용한다. 
	public void 대학원과정등록(Course<? extends PostGraduatedStudent> course) {
		
	}
	//직장인및일반인과정등록하기 
	//직장인및일반인과정은 Course<Worker>,Course<Person>객체다.
	//Course<? super Worker>는 
	//		Course<T>의 T가 Worker,Person으로 지정된 객체만 허용한다. 
	public void 직장인및일반인과정등록(Course<? super Worker> course) {
		
	}
	
	
}
