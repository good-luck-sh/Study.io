package dao;

import static utils.ConnectionUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Customer;

public class CustomerDao {

	public List<Customer> selectAllCustomers() throws SQLException {
		// TODO TB_SAMPLE_FOOD_CUSTOMERS 테이블에 저장된 모든 고객정보를 조회해서 반환한다.
		// 고객번호, 고객이름, 전화번호, 적립포인트, 입실퇴실, 등록일을 조회한다.
		List<Customer> customers = new ArrayList<>();
		String sql = "select customer_no, customer_name, customer_tel, customer_point, customer_in_out,customer_created_date "
				+"from tb_sample_food_customers ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery();
		
		while(rs.next()) {
			Customer customer = new Customer();
			customer.setNo(rs.getInt("customer_no"));
			customer.setName(rs.getString("customer_name"));
			customer.setTel(rs.getString("customer_tel"));
			customer.setPoint(rs.getInt("customer_point"));
			customer.setInOut(rs.getString("customer_in_out"));
			customer.setCreatedDate(rs.getDate("customer_created_date"));
			customers.add(customer);	
		}
		rs.close();
		ptmt.close();
		connection.close();
		
		return customers;
		
	}
	
	public Customer selectCustomerByNo(int customerNo) throws SQLException {
		// TODO TB_SAMPLE_FOODS_CUSTOMERS 테이블에서 지정된 고객번호에 해당하는 고객정보를 조회해서 반환한다.
		// 고객번호, 고객이름, 전화번호, 적립포인트, 입실퇴실, 등록일을 조회한다.
		Customer customer = null;
		String sql = "select customer_no, customer_name, customer_tel, customer_point, customer_in_out,customer_created_date "
				+"from tb_sample_food_customers "
				+"where customer_no = ? ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1,customerNo);
		ResultSet rs = ptmt.executeQuery();
		if(rs.next()) {
			customer = new Customer();
			customer.setNo(rs.getInt("customer_no"));
			customer.setName(rs.getString("customer_name"));
			customer.setTel(rs.getString("customer_tel"));
			customer.setPoint(rs.getInt("customer_point"));
			customer.setInOut(rs.getString("customer_in_out"));
			customer.setCreatedDate(rs.getDate("customer_created_date"));
			
		} else {
			System.out.println("### 오류 고객번호를 잘 못 입력하셨습니다.");
		}
		rs.close();
		ptmt.close();
		connection.close();
		return customer;
	}
	
	public Customer selectCustomerByTel(String customerTel) throws SQLException {
		// TODO TB_SAMPLE_FOODS_CUSTOMERS 테이블에서 지정된 전화번호에 해당하는 고객정보를 조회해서 반환한다.
		// 고객번호, 고객이름, 전화번호, 적립포인트, 입실퇴실, 등록일을 조회한다.
		Customer customer = null;
		String sql = "select customer_no, customer_name, customer_tel, customer_point, customer_in_out,customer_created_date "
				+"from tb_sample_food_customers "
				+"where customer_tel = ? ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setString(1,customerTel);
		ResultSet rs = ptmt.executeQuery();
		if(rs.next()) {
			customer = new Customer();
			customer.setNo(rs.getInt("customer_no"));
			customer.setName(rs.getString("customer_name"));
			customer.setTel(rs.getString("customer_tel"));
			customer.setPoint(rs.getInt("customer_point"));
			customer.setInOut(rs.getString("customer_in_out"));
			customer.setCreatedDate(rs.getDate("customer_created_date"));
			
		} else {
			System.out.println("### 오류 해당하는 전화번호가 존재하지 않습니다.");
		}
		rs.close();
		ptmt.close();
		connection.close();
		return customer;
	}
	
	public void insertCustomer(Customer customer) throws SQLException {
		// TODO TB_SAMPLE_FOOD_CUSTOMERS 테이블에 고객정보를 저장한다.
		// 고객이름, 전화번호가 저장된 Customer객체를 전달받아서 저장한다.
		
		String sql = "insert into tb_sample_food_customers(customer_no, customer_name, customer_tel )"
				+"values "
				+"(customer_seq.nextval ,? ,? ) ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setString(1, customer.getName());
		ptmt.setString(2, customer.getTel());
		ptmt.executeUpdate();
		
		ptmt.close();
		connection.close();
		
	}
	
	public void updateCustomer(Customer customer) throws SQLException {
		// TODO TB_SAMPLE_FOOD_CUSTOMER 테이블에 저장된 고객정보를 전달받은 고객정보로 변경한다.
		// 고객이름, 전화번호, 적립포인트, 입실퇴실 정보를 변경할 수 있다. 
		String sql = "update tb_sample_food_customers "
					+"set "
					+"customer_name = ? ,"
					+"customer_tel = ? ,"
					+"customer_point = ? ,"
					+"customer_in_out = ? "
					+"where "
					+"customer_no = ?";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setString(1, customer.getName());
		ptmt.setString(2, customer.getTel());
		ptmt.setInt(3, customer.getPoint());
		ptmt.setString(4, customer.getInOut());
		ptmt.setInt(5, customer.getNo());
		
		ptmt.executeUpdate();
		
		ptmt.close();
		connection.close();
	}
}
