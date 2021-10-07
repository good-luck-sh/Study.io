package example_10_06_01_collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorSample1 {

	public static void main(String[] args) {
		
		List<String> names = new ArrayList<>();
		names.add("홍길동");
		names.add("이순신");
		names.add("홍길동");
		names.add("김유신");
		names.add("홍길동");
		names.add("강감찬");
		names.add("홍길동");
		
		System.out.println("### Iterator을 이용한 반복처리");
		//ArrayList가 구현한 Iterator구현객체를 획득한다.
		Iterator<String> iter = names.iterator();
		 
		System.out.println(iter);
		
		//while문을 사용해서 반복처리를 수행한다. 
		//hasNext()는 반복처리할 데이터가 남아있으면 true를 반환한다.
		while(iter.hasNext()) {
			//next()는 남아있는 데이터중에서 하나를 반환한다. 
			String name = iter.next();
			System.out.println(name);
		}//출력의 경우 향상된 for문을 사용해도되고, while문을 사용해도됨
		
		System.out.println("### Enhanced for문을 이용해서 반복처리");
		for(String name : names) {
			System.out.println(name);
		}//출력만 할 것이라면 Enhanced for문을 사용한다. 
		
		
		
		//이안에 있는 홍길동을 전부 지우고 싶다. 
		//names.remove("홍길동");//이걸 사용하면 1개만 삭제됨 데이터에 얼마나 있는지 모름
		//여러번 반복은 효율이 좋지 않음

		////java.util.ConcurrentModificationException 오류 발생
		//향상된 for문을 사용해서 Collection<E>의 구현객체에 저장된 값을 반복처리중에 저장된 값을 삭제할 수 없다. 
		//추가는 되지만 삭제는 안됨
//		for(String name : names) {
//			if(name.equals("홍길동")) {
//				names.remove(name);
//			}
//		} 
		System.out.println(names);
	}
}
