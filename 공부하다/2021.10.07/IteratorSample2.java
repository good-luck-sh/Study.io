package example_10_06_01_collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorSample2 {

	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee(100,"이순신","영업팀", false));
		employeeList.add(new Employee(101,"김유신","총무팀", false));
		employeeList.add(new Employee(102,"감강찬","총무팀", true));
		employeeList.add(new Employee(103,"이성계","영업팀", false));
		employeeList.add(new Employee(104,"을지문덕","홍보팀", true));
		employeeList.add(new Employee(105,"권률","홍보팀", false));
		employeeList.add(new Employee(106,"임경업","영업팀", true));
	
		System.out.println("### 계약기간이 만료된 직원정보 삭제하기 ");
		
		Iterator<Employee> iter = employeeList.iterator();
		while(iter.hasNext()) {//hasNext()iter에 검사할 사람이 있는 동안 
			Employee emp = iter.next();//true면 다음자료를 꺼내옴
			if(emp.isExpired()) { //이것자체로만, true, false로 따로 조건 만들지 않아도됨
				iter.remove();//삭제하는 메소드
				//Iterator를 사용하면 자료구조내에 저장된 객체를 삭제할 수 있다. 
				//어디에나 있어서 HashSet에서도 사용가능함 
			}
		}
		//Iterator<E>는 1회용 객체이다. 
		//위에서 반복작업에 사용했던 Iterator를 재사용할 수 없다. 
		//이 코드에서 iter.hasNext()무조건 false라서 
		//새롭게 만들어서 사용하지 않으면 사용할 수 없다. 
//		System.out.println("###계약기간이 남아있는 직원정보 출력하기");
//		//Iterator의 경우 1회용이기 때문에 출력이 나오지 않는다. 
//		//다시 만들어서 사용해야함
//		Iterator<Employee> iter1 = employeeList.iterator();
//		while(iter1.hasNext()) {
//			Employee emp = iter1.next();
//			System.out.println(emp.getName());
//		}
//		
		System.out.println("### 계약기간이 남아있는 직원정보 출력하기 ");
		for(Employee emp : employeeList) {
			System.out.println(emp.getName() +", "+emp.getDept()+", "+ emp.isExpired());
		}
	}
	
	public static class Employee{
		private int id;
		private String name;
		private String dept;
		private boolean isExpired;//퇴사했는지
		
		public Employee(int id, String name, String dept, boolean isExpired) {
			this.id = id;
			this.name = name;
			this.dept = dept;
			this.isExpired = isExpired;
		}

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public String getDept() {
			return dept;
		}

		public boolean isExpired() {
			return isExpired;
		}
		
	}
}
