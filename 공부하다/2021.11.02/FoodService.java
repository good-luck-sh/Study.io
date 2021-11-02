package example_11_2_transaction.service;

import java.sql.Connection;
import java.sql.SQLException;

import example_11_2_transaction.dao.CustomerDao;
import example_11_2_transaction.dao.FoodDao;
import example_11_2_transaction.dao.OrderDao;
import example_11_2_transaction.vo.Customer;
import example_11_2_transaction.vo.Food;
import example_11_2_transaction.vo.Order;
import example_11_2_transaction.vo.OrderItem;
import parkingProject.util.ConnectionUtil;

public class FoodService {

	private FoodDao foodDao = new FoodDao();
	private OrderDao orderDao = new OrderDao();
	private CustomerDao customerDao = new CustomerDao();
	public void order(int customerNo, int foodNo, int amount) {
		
		Connection connection = null;
		try {
			connection = ConnectionUtil.getConnection(); //자바의 커넥션은 기본커넥션, 자동커밋이다.
			connection.setAutoCommit(false);//자동커밋을 종료시킴			새로운 트랜잭션 시작
			
			//1. food_seq 시퀀스에서 주문번호 획득하기 
			int orderNo = orderDao.getOrderNo(connection);
			System.out.println("### 새로운 주문번호가 획득되었습니다.");
			System.out.println("### 새 주문번호: " + orderNo);				//트랜잭션안에서 조회작업실행
			//2. 식품번호에 해당하는 식품정보를 조회한다. 
			Food food = foodDao.selectFood(foodNo, connection);
			System.out.println("### 주문할 식품번호에 대한 식품정보가 획득되었습니다.");	//트랜잭션안에서 조회작업실행
			
			//2.고객번호에 해당하는 고객정보를 조회한다. 
			Customer customer = customerDao.selectCustomer(customerNo, connection);//트랜잭션안에서 조회작업실행
			System.out.println("### 주문하는 고객의 상세정보가 획득되었습니다. ");
			//3. Order객체를 생성하고, 주문정보(주문번호, 주문자, 총구매금액)을 저장하고, 
			//tb_sample_food_orders 테이블에 저장시킨다. 
			Order order = new Order();
			order.setNo(orderNo);		//주문번호 저장
			order.setCustomer(customer);	//고객정보가 포함된 Customer객체 저장
			order.setTotalPrice(food.getPrice()*amount);		//총 구매가격 저장
			orderDao.insertOrder(connection, order);			//주문정보 테이블에 저장
			System.out.println("### 주문정보(주문번호, 고객번호, 총주문금액)를 저장하였습니다.");//*트랜잭션안에서 저장작업실행
			//4.OrderItem객체를 생성하고, 주문식품정보 (주문번호, 식품번호, 구매수량)을 저장하고, 테이블에 저장시킨다. 
			OrderItem orderItem = new OrderItem();
			orderItem.setOrderNo(orderNo);					//주문번호 저장
			orderItem.setFood(food);						//주문식품번호를 포함하고 있는 Food객체 저장
			orderItem.setAmount(amount);					//주문 수량 저장 
			orderDao.insertOrderItem(connection, orderItem);//주문정보 테이블에 저장
			System.out.println("### 주문식품정보(주문번호, 식품번호, 구매수량)를 저장하였습니다.");//*트랜잭션안에서 저장작업실행

			//5. 총 구매금액의 1%에 해당하는 포인트를 계산한다. 
			int depositPoint = (int)(food.getPrice()*amount* 0.01);
			System.out.println("적립포인트 : " + depositPoint);
			//7.조회된 고객정보의 포인트를 변경하고 테이블에 저장시킨다.
			customer.setPoint(customer.getPoint() + depositPoint);
			customerDao.updateCustomer(customer, connection);	//포인트가 변경된 고객정보를 업데이트 한다. //*트랜잭션안에서 변경작업실행
			System.out.println("### 적립포인트(고객포인트, 고객번호)를 저장하였습니다. ");
			//8.식품정보의 재고를 구매수량만큼 감소시키고, 테이블에 저장시킨다.
			food.setStock(food.getStock()-amount);
			foodDao.updateFood(food, connection);		//구매수량이 변경된 식품정보를 업데이트 한다. //*트랜잭션안에서 변경작업실행
			System.out.println("### 상품의 재고수량을 변경하였습니다. ");
			//9.모든 데이터베이스 엑세스 작업이 오류없이 완료되면 수행했던 모든 작업을 데이터베이스 반영시킨다. 
			connection.commit();
			System.out.println("### 모든 작업의 실행결과를 데이터베이스에 반영시켰습니다. ");//*트랜잭션안에서 변경작업실행
			//전체 이뤄지면 commit, 아니면 rollback이 될 수 있도록 만들 것이다. 				트랜잭션안에서 실행했던 작업을 DB에 반영
			//전부 동일한 connection에서 이뤄져야한다.										트랜잭션 종료
		} catch(Exception e) {
			//10. 데이터베이스 엑세스 작업중 오류가 발생하면 수행했던 모든작업의 데이터베이스 반영을 취소시킨다. 
			try {
			connection.rollback();											//트랜잭션안에서 실행했던 작업을 전부취소
			System.out.println("### 오류가 발생해서 모든 작업의 데이터베이스 반영을 취소했습니다.");//트랜잭션 종료
			} catch (SQLException ex) {
				
			} 
			throw new RuntimeException("데이터베이스 엑세스 작업 오류", e);
		} finally { //오류가 나던, 정상적으로 실행이 되던지 실행되는 항목 : finally
			// 정상종료/ 오류 발생과 상관없이 무조건 실행해야 하는 코드를 작성하는 곳이다. 
			//주로, 사용했던 리소스를 반환하는 코드가 위치한다. 
			try {
				//11. 데이터베이스와 연결된 커넥션을 닫는다. 
				if(connection != null) {
					connection.close();
				} // 오류가 나도 반납을 진행해주어야한다. 
			} catch (SQLException e) {
				
			}
		}
		
	}
	
}
