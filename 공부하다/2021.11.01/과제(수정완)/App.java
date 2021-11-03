package app;

import static utils.KeyboardUtil.close;
import static utils.KeyboardUtil.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.AdminService;
import vo.Category;
import vo.Customer;
import vo.Food;
import vo.Order;
import vo.OrderItem;

public class App {
	
	private AdminService service = new AdminService();

	public App() {
		System.out.println("[식품 판매 프로그램]");
		menu();
	}
	
	private void menu() {
		try {
			System.out.println("[메인 메뉴 목록]");
			System.out.println("====================================================================================================");
			System.out.println("1.조회  2.등록  3.주문  0.종료");
			System.out.println("====================================================================================================");
			
			System.out.print("메인 메뉴 선택: ");
			int menuNo = readInt();
			
			if (menuNo == 1) {
				searchMenu();
			} else if (menuNo == 2) {
				registerMenu();
			} else if (menuNo == 3) {
				orderMenu();
			} else if (menuNo == 0) {
				System.out.println("[프로그램 종료]");
				System.out.println("### 프로그램을 종료합니다.");
				close();
				System.exit(0);
			}
			
			System.out.println();
			System.out.println();
			menu();
		} catch (Exception ex) {
			ex.printStackTrace();
			
			System.out.println();
			System.out.println();
		} 
	}
	
	private void searchMenu() throws SQLException {
		while (true) {
			System.out.println();
			System.out.println();
			System.out.println("[조회 메뉴 목록]");
			System.out.println("====================================================================================================");
			System.out.println("1.카테고리 2.식품목록 3.카테고리별 식품목록  4.식품정보  5.고객리스트 6.고객상세정보 0.종료");
			System.out.println("====================================================================================================");
			
			System.out.print("조회 메뉴 선택: ");
			int menuNo = readInt();
			System.out.println();
			
			if (menuNo == 1) {
				searchCategories();
			} else if (menuNo == 2) {
				searchFoodList();
			} else if (menuNo == 3) {
				searchFoodListByCategory();
			} else if (menuNo == 4) {
				searchFoodInfo();
			} else if (menuNo == 5) {
				searchCustomerList();
			} else if (menuNo == 6) {
				searchCustomerInfo();
			} else if (menuNo == 0) {
				System.out.println("[조회 작업 종료]");
				System.out.println("### [안내] 조회작업을 종료하고 메인 메뉴로 돌아갑니다.");
				return;
			}
		}		
	}
	
	private void searchCategories() throws SQLException {
		System.out.println("[식품 카테고리 리스트 조회]");
		System.out.println("### 등록된 모든 식품카테고리를 출력합니다.");
		List<Category> category = service.getAllCategories();
		// TODO 모든 카테고리정보를 조회한다.
		if(category == null ) {
			System.out.println("### 에러 : 입력데이터가 없습니다. ");
		} else {
			for(Category findCategory : category) {
		System.out.println("[식품 카테고리 리스트]");
		System.out.println("----------------------------------------------------------------------------------------------------");
		System.out.println("카테고리번호\t카테고리이름");
		System.out.print("카테고리 번호 : " + findCategory.getNo() + "\t ");
		System.out.println("카테고리 이름 : " + findCategory.getName());
		System.out.println("----------------------------------------------------------------------------------------------------");
		// TODO 모든 카테고리 목록을 출력합니다.
			}
		}
		System.out.println("----------------------------------------------------------------------------------------------------");
	}
	
	private void searchFoodList() throws SQLException {
		System.out.println("[식품 리스트 조회]");
		System.out.println("### 등록된 모든 식품들을 출력합니다.");
		List<Food> foods = service.getAllFoods();
		// TODO 모든 식품정보를 조회한다.
		for(Food food : foods) {
			// TODO 모든 식품목록을 출력합니다.
			System.out.println("[식품 리스트]");
			System.out.println("----------------------------------------------------------------------------------------------------");
			System.out.println("식품번호\t카테고리\t식품이름\t식품가격\t판매여부");
			System.out.println(food.getNo() + "\t" + food.getCategory().getName() + "\t" +food.getName() + "\t" +food.getPrice() + "\t" +food.getOnSale());
			System.out.println("----------------------------------------------------------------------------------------------------");
		}
		
		
		System.out.println("----------------------------------------------------------------------------------------------------");
	}
	
	private void searchFoodListByCategory() throws SQLException {
		System.out.println("[카테고리별 식품 리스트 조회]");
		System.out.println("### 카테고리번호를 입력받아서 해당 카테고리의 식품들을 출력합니다.");
		
		System.out.print("### 카테고리번호 입력: ");
		int CategoryNumber = readInt();
		// TODO 카테고리번호를 입력받아서 해당 카테고리의 식품리스트를 조회한다.
		List<Food> foods = service.getFoodsByCategory(CategoryNumber);
		for(Food food : foods) {
			System.out.println("[카테고리별 식품 리스트]");
			System.out.println("----------------------------------------------------------------------------------------------------");
			System.out.println("식품번호\t카테고리\t식품이름\t식품가격\t판매여부");
			System.out.println("----------------------------------------------------------------------------------------------------");
			// TODO 식품목록을 출력합니다.
			System.out.print(food.getNo() + "\t");
			System.out.print(food.getCategory().getName() + "\t");
			System.out.print(food.getName() + "\t");
			System.out.print(food.getPrice() + "\t");
			System.out.println(food.getOnSale() + "\t");
		}
		System.out.println("----------------------------------------------------------------------------------------------------");
	}
	
	private void searchFoodInfo() throws SQLException {
		System.out.println("[식품상세 정보 조회]");
		System.out.println("### 식품번호를 입력받아서 해당 식품의 상세정보를 출력합니다.");
		
		System.out.print("### 식품번호 입력: ");
		// TODO 식품번호를 입력받아서 해당 식품의 상세정보를 조회한다.
		int foodNumber = readInt();
		Food food = service.getFoodDetail(foodNumber);
		System.out.println("[식품상세 정보]");
		System.out.println("----------------------------------------------------------------------------------------------------");
		// TODO 식품정보을 출력합니다.
		System.out.println("식품번호: " + food.getNo());
		System.out.println("카테고리 이름: " + food.getCategory().getName());
		System.out.println("식품명: " + food.getName());
		System.out.println("식품가격: "+ food.getPrice());
		System.out.println("식품재고: " + food.getStock());
		System.out.println("판매상태: " + food.getOnSale());
		System.out.println("----------------------------------------------------------------------------------------------------");
	}
	
	private void searchCustomerList() throws SQLException {
		System.out.println("[고객 리스트 조회]");
		System.out.println("### 등록된 모든 고객들을 출력합니다.");
		List<Customer> customers = service.getAllCustomers();
		// TODO 모든 고객정보를 조회한다.
		for(Customer customer : customers ) {
			System.out.println("[고객 리스트]");
			System.out.println("----------------------------------------------------------------------------------------------------");
			System.out.println("고객번호\t고객명\t전화번호\t입실/퇴실");
			System.out.println("----------------------------------------------------------------------------------------------------");
			// TODO 모든 고객목록을 출력합니다.
			System.out.print(customer.getNo() + "\t");
			System.out.print(customer.getName() + "\t");
			System.out.print(customer.getTel() + "\t");
			System.out.println(customer.getInOut());
		}
		
		System.out.println("----------------------------------------------------------------------------------------------------");
	}
	
	private void searchCustomerInfo() throws SQLException {
		System.out.println("[고객상세 정보 및 주문내역 조회]");
		System.out.println("### 고객번호를 입력받아서 해당 고객의 상세정보와 주문내역를 출력합니다.");
		
		System.out.print("### 고객번호 입력: ");
		// TODO 고객번호를 입력받아서 해당 고객의 상세정보를 조회한다.
		// TODO 고객번호를 입력받아서 해당 고객의 주문내역정보를 조회한다.
		int customerNumber = readInt();
		Customer customer = service.getCustomer(customerNumber);
		List<Order> orders = service.getOrdersByUserNo(customerNumber);
		
		System.out.println("[고객정보]");
		System.out.println("----------------------------------------------------------------------------------------------------");
		// TODO 고객정보을 출력합니다.
		System.out.println("고객번호: " + customer.getNo());
		System.out.println("고객이름: " + customer.getName());
		System.out.println("전화번호: " + customer.getTel());
		System.out.println("포인트: " + customer.getPoint());
		System.out.println("입실/퇴실: " + customer.getInOut());
		System.out.println("가입일자: " + customer.getCreatedDate());
		System.out.println("----------------------------------------------------------------------------------------------------");
		
		for(Order order : orders) {
			System.out.println("[주문내역]");
			System.out.println("----------------------------------------------------------------------------------------------------");
			System.out.println("주문번호\t고객명\t총주문금액\t주문상태\t주문날짜");
			System.out.print(order.getNo());
			System.out.print(order.getCustomer().getName());
			System.out.print(order.getTotalPrice());
			System.out.print(order.getStatus());
			System.out.println(order.getCreatedDate());
			System.out.println("----------------------------------------------------------------------------------------------------");
			// TODO 고객의 주문내역을 출력한다.
		}
		
		System.out.println("----------------------------------------------------------------------------------------------------");
	}
	
	private void registerMenu() throws SQLException {
		while (true) {
			System.out.println();
			System.out.println();
			System.out.println("[등록 메뉴 목록]");
			System.out.println("====================================================================================================");
			System.out.println("1.식품등록 2.고객등록 0.종료");
			System.out.println("====================================================================================================");
			
			System.out.print("등록 메뉴 선택: ");
			int menuNo = readInt();
			System.out.println();
			
			if (menuNo == 1) {
				registerFood();
			} else if (menuNo == 2) {
				registerCustomer();
			} else if (menuNo == 0) {
				System.out.println("[등록 작업 종료]");
				System.out.println("### [안내] 등록작업을 종료하고 메인 메뉴로 돌아갑니다.");
				return;
			}
		}
	}
	
	private void registerFood() throws SQLException {
		System.out.println("[식품 등록]");
		System.out.println("### 식품정보를 입력받아서 등록합니다.");
		
		System.out.print("### 식품이름 입력: ");
		String foodName = readString();
		System.out.print("### 식품가격 입력: ");
		int foodPrice = readInt();
		System.out.print("### 식품입고량 입력: ");
		int foodPutOnNumber = readInt();
		System.out.print("### 식품카테고리번호 입력: ");
		int foodCategoryNumber = readInt();
		// TODO 신규 식품정보와 가테고리번호를 입력받아서 등록시킨다.
		// Food객체와 Category객체를 생성해서 식품정보 가테고리번호를 저장하고, Category객체를 Food객체에 저장한다.
		Food food = new Food();
		Category category = new Category();
		food.setName(foodName);
		food.setPrice(foodPrice);
		food.setStock(foodPutOnNumber);
		category.setNo(foodCategoryNumber);
		category.setName(foodName);
		food.setCategory(category);
		service.addNewFood(food);
		
		System.out.println("### [안내] 식품정보가 등록되었습니다.");
	}
	

	private void registerCustomer() throws SQLException {
		System.out.println("[고객 등록]");
		System.out.println("### 고객정보를 입력받아서 등록합니다.");
		
		System.out.print("### 고객이름 입력: ");
		String userName = readString();
		System.out.print("### 고객전화번호 입력: ");
		String userTel = readString();
		// TODO 신규 고객정보를 입력받아서 등록시킨다.
		service.addNewCustomer(userName, userTel);
		System.out.println("### [안내] 고객정보가 등록되었습니다.");
	}
	
	private void orderMenu() throws SQLException {
		while (true) {
			System.out.println();
			System.out.println();
			System.out.println("[주문 메뉴 목록]");
			System.out.println("====================================================================================================");
			System.out.println("1.주문하기 2.전체 주문내역 조회 3.주문 상세정보 0.종료");
			System.out.println("====================================================================================================");
			
			System.out.print("주문 메뉴 선택: ");
			int menuNo = readInt();
			System.out.println();
			
			if (menuNo == 1) {
				order();
			} else if (menuNo == 2) {
				orderList();
			}else if (menuNo == 3) {
				orderDetail();
			} else if (menuNo == 0) {
				System.out.println("[주문 작업 종료]");
				System.out.println("### [안내] 주문작업을 종료하고 메인 메뉴로 돌아갑니다.");
				return;
			}
		}
	}
	
	private void order() throws SQLException {
		System.out.println("[주문하기]");
		System.out.println("### 주문정보를 입력받아서 등록합니다.");
		
		System.out.print("### 고객번호 입력: ");
		int userNo = readInt();
		System.out.print("### 식품번호와 구매수량 입력(입력예시-5001:3,5003:1): ");// 상품번호:수량,상품번호:수량,상품번호:수량 형식으로 입력한다.
		String order = readString();
		List<OrderItem> orderItems = new ArrayList<>();
		// TODO 고객번호와 구매식품정보를 입력받아서 등록시킨다.
		// 문자열을 분석해서 식품번호와 구매수량을 조회하고, OrderItem객체를 생성해서 저장하고, orderItems에 저장한다.
		String text = null;
		String[] texts = order.split(",");
		for(String searchOrder : texts) {
			text = searchOrder;
		}
		String[] findtexts = text.split(":");
		String foodText = null;
		String amountText = null;
		int foodNumber = 0;
		int foodAmount = 0;
		OrderItem putOrder = new OrderItem();
	
		for(int i = 0; i<findtexts.length; i+=2) {
			Food food = new Food();
			foodText = findtexts[i];
			amountText = findtexts[i+1];
			foodNumber = Integer.parseInt(foodText);
			foodAmount = Integer.parseInt(amountText);
			food.setNo(foodNumber);
			putOrder.setFood(food);
			putOrder.setAmount(foodAmount);
			
			orderItems.add(putOrder);
		}
		
		service.addNewOrder(userNo, orderItems);
		System.out.println("### [안내] 주문정보가 등록되었습니다.");
	}
	
	private void orderList() throws SQLException {
		System.out.println("[전체 주문내역 조회]");
		System.out.println("### 전체 주문내역을 출력합니다.");
		List<Order> orders = service.getAllOrders();
		// TODO 전체 주문내역정보를 조회한다.
		for(Order order : orders) {
			System.out.println("[전체 주문내역]");
			System.out.println("----------------------------------------------------------------------------------------------------");
			System.out.println("주문번호\t고객명\t총주문금액\t주문상태\t주문날짜");
			System.out.print(order.getNo()+"\t");
			System.out.print(order.getCustomer().getName()+"\t");
			System.out.print(order.getTotalPrice()+"\t");
			System.out.print(order.getStatus()+"\t");
			System.out.println(order.getCreatedDate());
			System.out.println("----------------------------------------------------------------------------------------------------");
			// TODO 주문내역을 출력한다.
		}
		
		System.out.println("----------------------------------------------------------------------------------------------------");
	}
	
	private void orderDetail() throws SQLException {
		System.out.println("[주문 상세정보]");
		System.out.println("### 주문번호를 입력받아서 해당 주문의 상세정보를 출력합니다.");
		
		System.out.print("### 주문번호 입력: ");
		int orderNumber = readInt();
		// TODO 주문번호를 입력받아서 해당 주문의 상세정보를 조회한다.
		// 주문상세정보에는 주문정보와 주문식품리스트가 포함되어 있다.
		List<Order> orders = service.getOrdersByUserNo(orderNumber);
		Order order = service.getOrderDetail(orderNumber);
		System.out.println("[주문상세 정보]");
		System.out.println("----------------------------------------------------------------------------------------------------");
		// TODO 주문정보을 출력합니다.
		System.out.println("주문번호: " + order.getNo());
		System.out.println("고객이름: " + order.getCustomer().getName());
		System.out.println("총주문가격: " + order.getTotalPrice());
		System.out.println("주문상태: " + order.getStatus());
		System.out.println("주문날짜: " + order.getCreatedDate());
		System.out.println("----------------------------------------------------------------------------------------------------");
		for(Order findOrder : orders) {
			List<OrderItem> orderitems = findOrder.getItems();
			for(OrderItem orderitem : orderitems) {
				System.out.println("[주문식품 리스트]");
				System.out.println("----------------------------------------------------------------------------------------------------");
				System.out.println("상품번호\t상품이름\t상품가격\t구매수량\t구매가격");
				System.out.print(orderitem.getOrderNo()+"\t");
				System.out.print(orderitem.getFood().getName()+"\t");
				System.out.print(orderitem.getFood().getPrice()+"\t");
				System.out.print(orderitem.getAmount()+"\t");
				int price = orderitem.getFood().getPrice() * orderitem.getAmount();
				System.out.println(price);
				System.out.println("----------------------------------------------------------------------------------------------------");
				// TODO 구매식품리스트를 출력한다.
 			
		}
		System.out.println("----------------------------------------------------------------------------------------------------");
	}
	}
	public static void main(String[] args) {
		new App();
	}
	
}
