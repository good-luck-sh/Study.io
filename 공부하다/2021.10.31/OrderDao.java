package dao;

import static utils.ConnectionUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Category;
import vo.Customer;
import vo.Food;
import vo.Order;
import vo.OrderItem;

public class OrderDao {

	public List<Order> selectOrdersByUserNo(int userNo) throws SQLException {
		// TODO TB_SAMPLE_FOOD_ORDERS 테이블에 지정된 고객번호에 해당하는 주문정보를 조회해서 반환한다.
		// 주문번호, 고객번호, 고객이름, 총주문금액, 주문상태, 주문날짜를 조회한다. (TB_SAMPLE_FOOD_ORDERS, TB_SAMPLE_CUSTOMER 조인)
		List<Order> orders = new ArrayList<>();
		String sql = "select o.order_no, o.customer_no, c.customer_name, o.order_total_price, o.order_status, o.order_created_date "
				+" from tb_sample_food_orders o , tb_sample_customer c "
				+"where o.customer_no = c.customer_no "
				+"and o.customer_no = ? ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1, userNo);
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()) {
			Order order = new Order();
			order.setNo(rs.getInt("o.order_no"));
			Customer customer = new Customer();
			customer.setNo(rs.getInt("o.customer_no"));
			customer.setName(rs.getString("c.customer_name"));
			order.setCustomer(customer);
			order.setTotalPrice(rs.getInt("o.order_total_price"));
			order.setStatus(rs.getString("o.order_status"));
			order.setCreatedDate(rs.getDate("o.order_created_date"));
			orders.add(order);
		}
		rs.close();
		ptmt.close();
		connection.close();
		return orders;
	}
	
	public Order selectOrderByNo(int orderNo) throws SQLException {
		// TODO TB_SAMPLE_FOOD_ORDERS 테이블에서 지정된 주문번호에 대한하는 주문정보를 조회해서 반환한다.
		// 주문번호, 고객번호, 고객이름, 총주문금액, 주문상태, 주문날짜를 조회한다. (TB_SAMPLE_FOOD_ORDERS, TB_SAMPLE_CUSTOMER 조인)
		Order order = null;
		String sql = "select o.order_no, o.customer_no, c.customer_name, o.order_total_price, o.order_status, o.order_created_date "
				+" from tb_sample_food_orders o , tb_sample_customer c "
				+"where o.customer_no = c.customer_no "
				+"and o.order_no = ? ";
			Connection connection = getConnection();
			PreparedStatement ptmt = connection.prepareStatement(sql);
			ptmt.setInt(1, orderNo);
			ResultSet rs = ptmt.executeQuery();
			if(rs.next()) {
				order = new Order();
				order.setNo(rs.getInt("o.order_no"));
				Customer customer = new Customer();
				customer.setNo(rs.getInt("o.customer_no"));
				customer.setName(rs.getString("c.customer_name"));
				order.setCustomer(customer);
				order.setTotalPrice(rs.getInt("o.order_total_price"));
				order.setStatus(rs.getString("o.order_status"));
				order.setCreatedDate(rs.getDate("o.order_created_date"));
			} else {
				System.out.println("### 오류 : 해당하는 주문번호가 없습니다.");
			}
			rs.close();
			ptmt.close();
			connection.close();
			return order;
	}
	
	public List<OrderItem> selectOrderItemsByOrderNo(int orderNo) throws SQLException {
		// TODO TB_SAMPLE_FOOD_ORDER_ITEMS 테이블에서 지정된 주문번호에 대한 모든 주문상품정보를 조회해서 반환한다.
		// 주문번호, 식품번호, 식품명, 식품가격, 카테고리명을 조회한다.(TB_SAMPLE_FOOD_CATEGORIES, TB_SAMPLE_FOODS, TB_SAMPLE_FOOD_ORDER_ITEMS 조인)
		List<OrderItem> orderItem = new ArrayList<>();
		String sql = "select o.order_no, o.food_no, f.food_name, f.food_price, c.category_name "
				+"from tb_sample_foods f, tb_sample_food_categoties c, tb_sample_food_order_items o "
				+"where o.food_no = f.food_no "
				+"and f.category_no = c.category_no"
				+"and o.order_no = ? ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1, orderNo);
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()) {
			OrderItem item = new OrderItem();
			item.setOrderNo(rs.getInt("o.order_no"));
			Food food = new Food();
			food.setNo(rs.getInt("o.food_no"));
			food.setName(rs.getString("f.food_name"));
			food.setPrice(rs.getInt("f.food_price"));
			Category category = new Category();
			category.setName(rs.getString("c.category_name"));
			food.setCategory(category);
			item.setFood(food);
			orderItem.add(item);
		}
		rs.close();
		ptmt.close();
		connection.close();
		return orderItem;
	}
	
	public int getOrderNo() throws SQLException {
		// TODO SELECT ORDER_SEQ.NEXTVAL FROM DUAL 쿼리를 실행해서 새 주문번호를 반환한다.
		int number = -1;
		String sql = "select order_seq.nextval"
				+ "from dual ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery();
		if(rs.next()) {
			number = rs.getInt("order_seq.nextval");
		}else {
			System.out.println("### 에러 ");
		}
		return number;
	}
	
	public void insertOrder(Order order) throws SQLException {
		// TODO TB_SAMPLE_FOOD_ORDERS 테이블에 새 주문정보를 저장한다.
		// 주문번호, 고객번호, 총주문금액를 포함하고 있는 주문정보를 전달받아서 저장한다.
		String sql = "insert into tb_sample_food_orders "
					+"(order_no, customer_no, order_total_price) " 
					+"values "
					+"(?, ?, ? )";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1,order.getNo());
		ptmt.setInt(2, order.getCustomer().getNo());
		ptmt.setInt(3, order.getTotalPrice());
		ptmt.executeUpdate();
		
		ptmt.close();
		connection.close();
					
	}
	
	public void insertOrderItem(OrderItem item) throws SQLException {
		// TODO TB_SAMPLE_FOOD_ORDER_ITEMS 테이블에 새 주문식품정보를 저장한다.7
		// 주문번호, 식품번호, 주문수량을 저장한다.
			String sql = "insert into tb_sample_food_order_items "
					+"(order_no, food_no, food_amount) " 
					+"values "
					+"(?, ?, ? )";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1,item.getOrderNo());
		ptmt.setInt(2, item.getFood().getNo());
		ptmt.setInt(3, item.getAmount());
		ptmt.executeUpdate();
		
		ptmt.close();
		connection.close();
		}
		
	public void updateOrder(Order order) throws SQLException {
		// TODO TB_SAMPLE_FOODS_ORDERS 테이블에 저장된 주문정보를 전달받은 주문정보로 변경한다.
		// 고객번호, 총주문금액, 주문상태를 변경할 수 있다.
		String sql = "update tb_sample_food_orders "
				+"set "
				+ " customer_no = ? ,"
				+ " order_total_price = ? ,"
				+ " order_status = ? "
				+" where "
				+ " order = ?";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1,order.getCustomer().getNo());
		ptmt.setInt(2,order.getTotalPrice());
		ptmt.setString(3, order.getStatus());
		ptmt.setInt(4, order.getNo());
		ptmt.executeUpdate();
		ptmt.close();
		connection.close();
		}
	
	public List<Order> getAllPrint() throws SQLException{
		List<Order> orders = new ArrayList<>();
		String sql = "select o.order_no, o.customer_no, c.customer_name, o.order_total_price, o.order_status, o.order_created_date "
				+" from tb_sample_food_orders o , tb_sample_customer c "
				+"where o.customer_no = c.customer_no ";
				Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()) {
			Order order = new Order();
			order.setNo(rs.getInt("o.order_no"));
			Customer customer = new Customer();
			customer.setNo(rs.getInt("o.customer_no"));
			customer.setName(rs.getString("c.customer_name"));
			order.setCustomer(customer);
			order.setTotalPrice(rs.getInt("o.order_total_price"));
			order.setStatus(rs.getString("o.order_status"));
			order.setCreatedDate(rs.getDate("o.order_created_date"));
			orders.add(order);
		}
		rs.close();
		ptmt.close();
		connection.close();
		return orders;
	}
	
}
