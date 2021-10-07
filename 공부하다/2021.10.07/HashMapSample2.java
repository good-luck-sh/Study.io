package example_10_07_01_Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapSample2 {

	public static void main(String[] args) {
		
		//상품정보를 표시하는 항목들이 화면에 따라서 매우 가변적일 때, 
		//정보를 ValueObject로 저장하기 보다는 Map으로 저장하는 것이 좋다
		
		//메인화면에서 표시되는 상품정보
		//상품정보만 필요함
		Map<String, Object> mainProduct = new HashMap<>();//object ==>값으로 뭐든지 다된다는 뜻
		mainProduct.put("name", "가을 신상 셔츠"); 
		mainProduct.put("price",35000);
		mainProduct.put("discountPrice",32500);
		
		//카테고리별 상품목록화면에 표시되는 상품정보
		//상품정보 + 리뷰정보 필요
		Map<String, Object> categoryProduct = new HashMap<>();
		categoryProduct.put("name", "가을 신상 셔츠"); 
		categoryProduct.put("price",35000);
		categoryProduct.put("discountPrice",32500);
		categoryProduct.put("reviews", 13); //리뷰
		categoryProduct.put("score",4.5); 	//평점
		categoryProduct.put("likes",100);	//좋아요한 사람
		
		//상세화면 
		//상품정보 + 리뷰정보 + 이 상품을 구매한 사람들이 산 상품정보(구매정보)
		Map<String, Object> detailProduct = new HashMap<>();
		detailProduct.put("name", "가을 신상 셔츠"); 
		detailProduct.put("price",35000);
		detailProduct.put("discountPrice",32500);
		detailProduct.put("reviews", 13); //리뷰
		detailProduct.put("score",4.5); 	//평점
		detailProduct.put("likes",100);	//좋아요한 사람
		
		//이 제품을 구매한 사람들이 구매한 상품이름
		List<String> productNames = new ArrayList<>();
		productNames.add("가을 신상 자켓");
		productNames.add("가을 신상 바지");
		productNames.add("겨울 신상 스웨터");
		
		detailProduct.put("suggestProductNames", productNames);
		
		//Map에 저장된 다양한 값 꺼내기 
		detailProduct.get("nane");//단점 1.키에 오타가 있어도 체크되지 않는다.
		String name = (String)detailProduct.get("name"); 
		int price = (Integer)detailProduct.get("price");
		//설정 데이터타입이 Object로 되어있기 때문에 강제형변환을 해주어야한다. 
		//단점 2.맵에서 값을 가져올 때 형변환이 필요하다.
		System.out.println("상품이름 : " + name);
		System.out.println("상품가격 : " + price);
		
	}
}
