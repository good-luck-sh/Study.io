package example_10_06_01_collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListSample1 {

	public static void main(String[] args) {
		
		//ArrayList<E>의 주요 API
		//순서가 보장된다는게 중요한 class
		
		ArrayList<String> list = new ArrayList<>();
		
		//boolean add(E e) : ArrayList객체에 객체를 저장한다. 
		//					 맨 마지막 객체 다음에 객체가 저장된다. 
		list.add("홍길동");
		list.add("김유신");
		list.add("홍길동");
		list.add("이순신");
		list.add("홍길동");
		list.add("홍길동");
		
		//HashSet<E>과 사용방법은 동일하다.
		//void clear() : ArrayList객체에 저장된 모든 객체를 삭제한다. 
		//list.clear();
		
		//boolean isEmpty() : ArrayList객체에 저장된 객체가 하나도 없으면 true를 반환한다. 
		System.out.println("###저장된 객체가 하나도 없는가? " + list.isEmpty());
		
		//int size() : ArrayList객체에 저장된 객체의 갯수를 반환한다. 
		System.out.println("### 저장된 객체의 갯수 : " + list.size());
		
		//boolean contains(Object e) : ArrayList객체에 지정된 객체가 존재하면 true를 반환한다. 
		System.out.println("### \"김유신 \"이 포함되어 있는가? " + list.contains("김유신"));
		
		//boolean remove(Object e) : ArrayList객체에서 지정된 객체를 삭제한다. 
		list.remove("홍길동");//맨 처음 발견된 객체만 삭제한다. 
		
		//ArrayList에 저장된 데이터를 출력하자 
		//향상된 for문을 이용해서 출력하기 
		for(String name : list) {//담을수 있는 변수 : 데이터를 꺼낼 배열의 이름
			System.out.println("저장된 이름 :" + name);
		}
		
		System.out.println("### ArrayList에 저장된 객체를 간단히 출력해보자");
		System.out.println(list);
		
	}
}
