package example_10_07_01_Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapSample1 {

	public static void main(String[] args) {
		Map<Integer, Product> productMap = new HashMap<>(); 
		//Integer을 key로 Product를 value로 사용하겠다는 의미.
		
		//V put(K key,V value) : Map형식의 자료구조 객체에 새로운 key, value쌍으로 객체가 저장된다. 
		productMap.put(101, new Product(101,"맥북프로 M1",1_690_000));
		productMap.put(102, new Product(102,"애플워치 7",690_000));
		productMap.put(103, new Product(103,"갤럭시플립3",2_000_000));
		productMap.put(104, new Product(104,"아마존 킨들",200_000));
		productMap.put(105, new Product(105,"아이패드프로",1_500_000));
		
		//V get(Object key) : Map형식의 자료구조 객체에서 지정된 key로 저장된 Value객체를 조회한다. 
		//가장 일반적인 방법으로 꺼내는 방법이다. 
		System.out.println("### Map 객체에서 key로 저장된 value 찾기 ");
		Product product1 = productMap.get(105);
		
		System.out.println(product1.getNo());
		System.out.println(product1.getName());
		System.out.println(product1.getPrice());
		System.out.println();
		
		//boolean isEmpty() : Map형식의 자료구조 객체에 저장된 데이터가 하나도 없으면 true를 반환한다. 
		//int size() : Map형식의 자료구조 객체에 저장된 key,value 쌍의 갯수를 반환한다. 
		//void clear() : Map형식의 자료구조 객체에 저장된 모든 정보를 삭제한다.
		
		//boolean containsKey(Object key)
		boolean isExist = productMap.containsKey(100);
		System.out.println("### HashMap에 100이 Key로 포함되어 있는가? " + isExist);
		//101번부터 존재하기 때문에 false을 출력함 
		
		//Map을 꺼낼 때에는 반복문을 사용하지 않는다. Map에 담았다는 것은 Key을 알고있기 때문에 
		//반복문으로 꺼내지 않고 key로 꺼낸다. key를 전체적으로 알고있다는 가정하에 사용한다. 
		
		// Set<Map.Entry<K, V>> entrySet() : Map을 구성하고 있는 Map.Entry를 꺼낸다.
		//Map형식의 자료구조 객체에 저장된 Entry를 Set객체 담아서 반환한다. 
		System.out.println("### HashMap에 저장된 모든 Entry를 조회해서 출력하기 ");
		Set<Entry<Integer, Product>> entries = productMap.entrySet();
		for(Entry<Integer, Product> entry : entries) {
			int key = entry.getKey();//오토언박싱으로 인하여 int로 타입을 적는다
			Product value = entry.getValue();
			System.out.println("[" + key + "] name : " + value.getName() + " , price:" + value.getPrice());
		
		
		}
	}
	
	static class Product{
		private int no;
		private String name; 
		private int price;
		
		public Product(int no, String name, int price) {
			this.no = no;
			this.name = name; 
			this.price = price;
		}

		public int getNo() {
			return no;
		}

		public void setNo(int no) {
			this.no = no;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

	}
}
