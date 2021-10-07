package example_10_06_01_collection;

import java.util.TreeSet;

public class TreeSetSample1 {

	public static void main(String[] args) {
		
		TreeSet<String> names = new TreeSet<>();
		
		//TreeSet<E>는 저장되는 객체를 오름차순으로 정렬해서 저장한다. 
		//저장되는 방식에 차이가 있다. 메소드는 동일하다. 
		//TreeSet에만 사용되는 method가 존재한다. 
		//java에서 정렬은 잘 사용하지 않는다. 우리가 사용하는 DB에서는 정렬이 완료된 데이터를 가져오기 때문에 많이 사용하지는 않음
		names.add("이순신");
		names.add("김유신");
		names.add("안중근");
		names.add("류관순");
		names.add("안창호");
		names.add("김구");
		names.add("최제우");
		names.add("한용운");
		names.add("이봉창");
		for(String name : names) {
			System.out.print(name + "\t");
			//오름차순으로 정렬이 됨
		} System.out.println();
}}
