package example_11_2_transaction.app;

import static utils.KeyboardUtil.*;

import example_11_2_transaction.service.FoodService;

public class App {
	
	private FoodService foodservice = new FoodService();
	
	public void 주문하기() {
		// 고객번호, 상품번호, 고객수량을 입력받아서 음식 주문 처리하기 
		System.out.println("고객 번호 입력 : ");
		int customerNo = readInt();
		
		System.out.println("식품 번호 입력 : ");
		int foodNo = readInt();
		
		System.out.println("구매 수량 입력 : ");
		int amount = readInt();
		
		foodservice.order(customerNo, foodNo, amount);
		
		System.out.println("### 주문이 완료되었습니다.");
	}
	
	
	public static void main(String[] args) {
		App app = new App();
		app.주문하기();
		
		
		
	}
}
