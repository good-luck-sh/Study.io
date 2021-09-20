package example_09_17_polymorphism;
/**
 * 학생, 교수, 교직원에 대한 등록, 조회, 통계 정보를 제공하는 클래스다. 
 * @author 김승희
 *
 */
public class PersonService {
	/**
	 * 학생, 교수, 교직원 정보가 저장되는 배열이다. 
	 */
	private Person[] database = new Person[100]; 
	/**
	 * database 가 참조하는 배열에서 새로운 정보가 저장되는 위치정보를 가지고 있는 변수다.
	 */
	private int position = 0; // 몇번째에 저장되는 지 확인하기 위한 변수 
	//person에 대한 저장할 데이터 베이스를 구축
	/**
	 * PersonService의 기본 생성자 메소드다. <br/>
	 * 테스트를 위해서 위의 datavase참조변수가 참조하는 배열에 테스트용 정보를 미리 저장한다. 
	 */
	//</br>줄바꿈배열
	
	public PersonService() {
		database[position++] = new Employee(position,"직원", "김한탄", "010-853-9510", "교육팀", "과장",4_500_000);
		database[position++] = new Employee(position,"직원", "김쨔쪼", "010-111-9510", "총무팀", "사원",1_800_000);
		database[position++] = new Employee(position,"직원", "삒우", "010-853-111", "청소팀", "청소원",3_00_000);
		database[position++] = new Student( position,"학생", "김쫑글", "010-5468-7878", 3,"전자공학과 ");
		database[position++] = new Professor(position, "교수", "김교수", "010-5468-7878","전자공학과 ","부교수","신 재생에너지 개발 프로젝트");
		database[position++] = new  Student( position,"학생", "김또띠아", "010-4545-4687", 2,"토목공학과 ");
		database[position++] = new  Student( position,"학생", "김찌쭝", "010-1111-4687", 5,"사회복지학 ");
		database[position++] = new  Student( position,"학생", "놀라", "010-4545-1111", 3,"컴퓨터공학과");
		database[position++] = new  Student( position,"학생", "김삐아", "010-1212-4687", 4,"수학학과 ");
		database[position++] = new Professor(position, "교수", "김뽀찌", "010-5468-0000","토목공학과 ","교수","토목공학 발전 프로젝트");
	}
	/**
	 * 지정된 사람을 데이터 베이스에 저장한다.
	 * @param person 학생, 교수 혹은 교직원 정보 
	 */
	public void addNewPerson(Person person) {//매개변수의 다형성이 적용되었다. Person타입의 변수는Student/Professor/Employee객체를 전달받을 수 있다.
		//학생, 교수, 교직원중에 어떤 사람들이 들어올지
		//몰라서 Person으로 설정함. 부모는 자식객체를 형변환 할 수 있기 때문
		database[position] = person;
		position++;
		
	}
	/**
	 * 모든 사람정보를 화면에 출력한다.
	 */
	public void printAllPerson() {
		for(Person person : database) {
			if(person == null) {
				break;
			}//person 참조변수는 Student/Professor/Employee객체의 상위객체인 Person객체를 참조하고잇다.
			// person 참조변수는 print()를실행하면, person참조변수가 참조하는 Person객체의 print가 실행되는 것이 아니라 
			//Student/professor/Employee객체에 재정의된 print()메소드가 실행된다.
			person.print();
			System.out.println();
		}
	}
	/**
	 * 지정된 번호로 사람을 찾아서 반환한다
	 * @param no 일련번호
	 * @return 사람정보, null일 수 있음
	 */
	public Person searchPerson(int no) {// 반환타입의 다형성이 적용되었다. 어떤 객체가 들어올지 몰라서 전체 객체의 부모타입으로 지정했다.
		//Person 타입의 반환타입은 Student/professor/Employee객체를 모두 반환할 수 있다. 
		Person foundPerson = null;
		for(Person person : database) {
			if(person != null) { //(person != null && person.getNo() == no)으로 대체가능 순서는 null확인이 우선이어야함
				if(person.getNo() ==no) {
					foundPerson = person;
					break;
				}
			}
		}
		return foundPerson;//person도 반환이 되고, Student/professor/Employee객체를 모두 반환할 수 있다. 
	}
	//숫자랑 이름으로 찾기 때문에 메소드 중복정의로 가능하다. 매개변수타입과 매개변수 타입갯수, 타입순서가 다른상태로 같은 메소드를 만드는 것.
	/**
	 * 지정된 이름으로 사람을 찾아서 반환한다.
	 * @param name 검색할 이름
	 * @return 사람정보, null일 수 있음
	 */
	public Person searchPerson(String name) {// 반환타입의 다형성이 적용되었다. 어떤 객체가 들어올지 몰라서 전체 객체의 부모타입으로 지정했다.
		//좀 다르게 코딩 
		for(Person person : database) {
			if(person != null && person.getName().equals(name)) {//조건식이 참이 되어야지 반환이 됨. 한번도 참이아니면 반환이 안일어남.
				//빨간줄이 감.
				return person;//찾은거 그냥 줘버려도 되니까 그냥 return으로 작성
			}
		}	return null;//여기까지 왔다는 것은 못 찾았다. 그냥 null을 줘버림 , 특정조건에서만 return이라 저조건문이 아닌 해답도 출력해야함.
		//검색을하면 항상 결과가 null일 수 있다는 것을 염두해야함.
	}
	
}
