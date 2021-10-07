package example_10_06_01_collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListSample2 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("오렌지");
		list.add("사과");
		list.add("토마토");
		list.add("사과");
		
		
		//void add(int index, E e) : 지정된 인덱스에 객체를 추가한다. 기존 객체는 뒤로 이동된다. 
		list.add(1,"파인애플"); //1번에 "파인애플"을 추가한다. 
		
		System.out.println("### List객체의 데이터를 살펴보자");
		System.out.println(list);
		
		//E set(int index, E e) : 지정된 인덱스에 저장된 객체를 새로운객체로 교체한다. 
		list.set(0, "망고");
		
		System.out.println("### List객체의 데이터를 살펴보자");
		System.out.println(list);
		
		//E remove(int index) : 지정된 인덱스에 저장된 객체를 삭제한다. 
		list.remove(3);
		
		System.out.println("### List객체의 데이터를 살펴보자");
		System.out.println(list);
		
		//HashSet과 다르게 인덱스를 이용하여, 더하거나, 삭제가 가능하다. 
		//List계열들이 이런 기능을 가지고 있다. 
		
		//E get(int index) : 지정된 인덱스 위치에 저장된 객체를 반환한다.
		String name0 = list.get(0);
		String name1 = list.get(1);
		String name2 = list.get(2);
		System.out.println(name0 + ", " + name1 + ", " + name2);
		
		//일반 for문을 이용해서 ArrayList에 저장된 모든 데이터를 가져오기 
		System.out.println("### 일반 for문을 사용해서 ArrayList객체에 저장된 값 가져오기 ");
		int length = list.size();
		for(int index = 0; index<length; index++) {
			String name = list.get(index);
			System.out.println(name);
		}
		
		//for문의 조건식에서 list.size()로 데이터의 갯수를 조회하는 것은 실행성능을 나쁘게 만든다.
//		for(int index = 0; index<list.size(); index++) {
//			String name = list.get(index);
//			System.out.println(name);
//		}
		
	}
}
