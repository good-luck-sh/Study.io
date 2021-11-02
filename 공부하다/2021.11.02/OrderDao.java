package example_11_2_transaction.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import example_11_2_transaction.vo.Order;
import example_11_2_transaction.vo.OrderItem;

public class OrderDao {
	
	/**
	 * 주문번호로 사용될 시퀀스 값을 반환한다. 
	 * @param connection 커넥션 객체
	 * @return 주문번호
	 * @throws SQLException 
	 */
	public int getOrderNo(Connection connection) throws SQLException {
		int orderNo = 0;
		String sql = "select FOODORDER_SEQ.nextval as order_no from dual";
		
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		orderNo = rs.getInt("order_no");
		
		rs.close();
		pstmt.close();
		
		return orderNo;
	}
	/**
	 * 주문정보를 전달받아서 저장한다. 
	 * @param connection 커넥션 객체
	 * @param order 주문정보
	 * @throws SQLException
	 */
	public void insertOrder(Connection connection, Order order) throws SQLException {
		String sql = "insert into tb_sample_food_orders "
					+"(order_no, customer_no, order_total_price) "
					+"values "
					+"(?, ?, ?) ";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, order.getNo());
		pstmt.setInt(2, order.getCustomer().getNo());
		pstmt.setInt(3, order.getTotalPrice());
		pstmt.executeUpdate();
		
		pstmt.close();

	}
	
	/**
	 * 지정된 주문식품정보를 테이블에 저장한다. 
	 * @param connection 커넥션객체
	 * @param orderItem 주문식품정보
	 * @throws SQLException
	 */
	public void insertOrderItem(Connection connection, OrderItem orderItem) throws SQLException {
		String sql = "insert into tb_sample_food_order_items "
				+"(order_no, food_no, food_amount) "
				+" values "
				+"(?, ?, ?) ";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, orderItem.getOrderNo());
		pstmt.setInt(2, orderItem.getFood().getNo());
		pstmt.setInt(3, orderItem.getAmount());
		pstmt.executeUpdate();
		
		pstmt.close();
		
	}//service내의 하나의 커넥션으로 조절하기 위하여 매개변수를 connection을 작성한다. 개별적으로 connection을 만들면 하나씩 트랜잭션이된다.
}
