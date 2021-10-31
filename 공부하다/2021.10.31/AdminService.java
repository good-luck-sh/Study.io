package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CategoryDao;
import dao.CustomerDao;
import dao.FoodDao;
import dao.OrderDao;
import vo.Category;
import vo.Customer;
import vo.Food;
import vo.Order;
import vo.OrderItem;

public class AdminService {

	private final CategoryDao categoryDao = new CategoryDao();
	private final CustomerDao customerDao = new CustomerDao();
	private final FoodDao foodDao = new FoodDao();
	private final OrderDao orderDao = new OrderDao();
	
	/**
	 * 모든 식품카테고리정보를 반환한다.
	 * @return 식품 카테고리 정보 목록
	 * @throws SQLException 데이터베이스 오류 발생
	 */
	public List<Category> getAllCategories() throws SQLException {
		List<Category> category = categoryDao.selectAllCategories();
		
		return category;
	}
	
	/**
	 * 모든 식품정보를 반환한다.
	 * @return 식품정보 목록
	 * @throws SQLException 데이터베이스 오류 발생
	 */
	public List<Food> getAllFoods() throws SQLException {
		// TODO [식품 리스트 조회] 메뉴 선택시 실행되는 서비스 메소드다.
		// 모든 식품 목록을 제공한다.
		List<Food> foods = foodDao.selectAllFoods();
		return foods;
	}
	
	/**
	 * 지정된 카테고리번호에 해당하는 모든 식품정보를 반환한다.
	 * @param categoryNo 조회할 카테고리번호
	 * @return 식품정보 목록
	 * @throws SQLException 데이터베이스 오류 발생
	 */
	public List<Food> getFoodsByCategory(int categoryNo) throws SQLException {
		// TODO [카테고리별 식품 리스트 조회] 메뉴 선택시 실행되는 서비스 메소드다.
		// 전달받은 카테고리번호에 해당하는 식품목록을 제공한다.
		List<Food> foods = foodDao.selectFoodsByCategory(categoryNo);
		return foods;
	}
	
	/**
	 * 지정된 식품번호에 해당하는 식품상세정보를 반환한다.
	 * @param foodNo 조회할 식품번호
	 * @return 식품정보
	 * @throws SQLException 데이터베이스 오류 발생
	 */
	public Food getFoodDetail(int foodNo) throws SQLException {
		// TODO [식품상세 정보 조회] 메뉴 선택시 실행되는 서비스 메소드다.
		// 전달받는 식품번호에 해당하는 식품상세정보를 제공한다.
		Food food = foodDao.selectFoodByNo(foodNo);
		return food;
	}
	
	/**
	 * 지정된 식품정보를 전달받아서 식품정보를 저장한다.
	 * @param food 식품정보
	 * @throws SQLException 데이터베이스 오류 발생
	 */
	public void addNewFood(Food food) throws SQLException {
		// TODO [식품 등록] 메뉴 선택시 실행되는 서비스 메소드다.
		// 전달받는 식품정보를 저장한다.(식품정보에는 카테고리가 포함되어 있다)
		// 1. 동일한 이름의 식품정보가 존재하는 경우 해당 식품의 재고를 증가시킨다.
		// 2. 동일한 이름의 식품정보가 존재하지 않으면 신규 등록한다.
		Food findFood = foodDao.selectFoodByName(food.getName());
		if(findFood == null) {
			foodDao.insertFood(food);
		} else {
			foodDao.updateFood(findFood);
		}
	}
	
	/**
	 * 지정된 고객번호와 주문식품정보를 전달받아서 주문정보와 주문상품정보를 저장한다.
	 * @param userNo 주문하는 고객번호
	 * @param orderItems 고객이 주문한 식품번호와 식품수량이 포함된 주문식품정보 목록
	 * @throws SQLException
	 */
	public void addNewOrder(int userNo, List<OrderItem> orderItems) throws SQLException {
		// TODO [주문하기] 메뉴 선택시 실행되는 서비스 메소드다.
		// 고객번호, 주문식품리스트를 전달받아서 테이블에 저장한다.
		// 1. 새로운 주문번호를 조회한다.
		// 2. 주문정보 객체를 생성한다. 주문번호, 고객번호, 총구매금액을 객체에 저장한다.
		// 3. 주문정보를 테이블에 저장한다.
		// 4. 주문식품리스트를 반복처리한다.
		//		5. 주문상품객체에 주문번호를 저장한다.
		//		6. 주문상품정보를 테이블에 저장한다.
		// 7. 고객번호로 고객정보를 조회한다.
		// 8. 총구매금액의 1%만큼 고객의 포인트를 증가시킨다.
		// 9. 변경된 고객정보를 테이블에 저장한다.
		int orderNumber = orderDao.getOrderNo();
		Order order = new Order();
		order.setNo(orderNumber);
		Customer customer = new Customer();
		customer.setNo(userNo);
		order.setCustomer(customer);
		int totalprice = 0;
		order.setItems(orderItems);
		List<OrderItem> items = order.getItems();
		for(OrderItem item : items) {
			int amount = item.getAmount();
			int price = item.getFood().getPrice();
			totalprice = amount + price;
			
		}
		order.setTotalPrice(totalprice);
		orderDao.insertOrder(order);
		for(OrderItem orderItem : orderItems) {
			OrderItem saveOrder = new OrderItem();
			saveOrder.setOrderNo(orderItem.getOrderNo());
			orderDao.insertOrderItem(orderItem);
		}
		Customer findcustomer = customerDao.selectCustomerByNo(userNo);
		int savePoint = (int)(order.getTotalPrice() *0.01);
		findcustomer.setPoint(savePoint);
		customerDao.updateCustomer(findcustomer);
	}
	/**
	 * 모든 주문정보를 반환한다.
	 * @return 주문정보 리스트
	 * @throws SQLException 데이터베이스 오류 발생
	 */
	public List<Order> getAllOrders() throws SQLException {
		// TODO [전체 주문내역 조회] 메뉴 선택시 실행되는 서비스 메소드다.
		// 전체 주문정보 목록를 반환한다.
		List<Order> orders = orderDao.getAllPrint();
		return orders;
	}
	
	/**
	 * 지정된 고객번호에 해당하는 고객의 주문정보들을 반환한다.
	 * @param userNo 고객번호
	 * @return 주문정보 리스트
	 * @throws SQLException 데이터베이스 오류 발생
	 */
	public List<Order> getOrdersByUserNo(int userNo) throws SQLException {
		// TODO [고객상세 정보 및 주문내역 조회] 메뉴 선택시 실행되는 서비스 메소드다.
		// 고객번호에 해당하는 주문정보 목록를 반환한다.
		List<Order> order = orderDao.selectOrdersByUserNo(userNo);
		return order;
	}
	
	/**
	 * 지정된 주문번호에 해당하는 주문정보를 반환한다. 
	 * @param orderNo 조회할 주문번호
	 * @return 주문정보(주문정보와 주문식품목록을 포함한다)
	 * @throws SQLException 데이터베이스 오류 발생
	 */
	public Order getOrderDetail(int orderNo) throws SQLException {
		// TODO [주문상세 조회] 메뉴 선택시 실행되는 서비스 메소드다.
		// 주문번호에 해당하는 주문상세정보를 반환한다.
		// 1. 주문번호에 해당하는 주문정보를 조회한다.
		// 2. 주문번호에 해당하는 주문식품정보목록을 모두 조회한다.
		// 3. 주문식품정보목록을 주문정보객체에 저장한다.
		// 4. 주문정보를 반환한다.
		Order order = orderDao.selectOrderByNo(orderNo);
		List<OrderItem> orderItems = orderDao.selectOrderItemsByOrderNo(orderNo);
		order.setItems(orderItems);
		return order;
	}
	
	/**
	 * 모든 고객정보를 반환한다
	 * @return 고객정보 목록
	 * @throws SQLException 데이터베이스 오류 발생
	 */
	public List<Customer> getAllCustomers() throws SQLException {
		// TODO [고객 리스트 조회] 메뉴 선택시 실행되는 서비스 메소드다.
		// 모든 고객정보를 반환한다.
		List<Customer> customers = customerDao.selectAllCustomers();
		return customers;
	}
	
	/**
	 * 지정된 고객번호에 해당하는 고객상세정보를 반환한다.
	 * @param customerNo 고객번호
	 * @return 고객정보
	 * @throws SQLException
	 */
	public Customer getCustomer(int customerNo) throws SQLException {
		// TODO [고객상세 정보 및 주문내역 조회] 메뉴 선택시 실행되는 서비스 메소드다.
		// 고객상세정보를 반환한다.
		Customer customer = null;
		customer = customerDao.selectCustomerByNo(customerNo);
		return customer;
	}
	
	/**
	 * 고객이름과 전화번호를 전달받아서 새 고객정보를 저장한다.
	 * @param name 고객이름
	 * @param tel 고객 전화번호
	 * @throws SQLException 데이터베이스 오류 발생
	 */
	public void addNewCustomer(String name, String tel) throws SQLException {
		// TODO [고객 등록] 메뉴 선택시 실행되는 서비스 메소드다.
		// 전달받은 고객정보를 저장한다.
		// 1. 전화번호로 고객정보를 조회해서 고객정보가 존재하면 RuntimeException 예외를 발생시킨다.
		// 2. 고객정보가 존재하지 않으면 고객정보를 등록시킨다.
		Customer customer = null; 
		customer = customerDao.selectCustomerByTel(tel);
		if(customer == null ) {
			throw new RuntimeException("### 오류 : 고객정보가 존재하지 않습니다.");
		} else {
			customer.setName(name);
			customer.setTel(tel);
			customerDao.insertCustomer(customer);
		}
	}
	
	
	
}
