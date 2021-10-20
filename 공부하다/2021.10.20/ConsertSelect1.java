package example_10_20.jdbc.contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.ConnectionUtil;

public class ConsertSelect1 {

	public static void main(String[] args) throws SQLException {
		String sql = "select no, name, phone_number, email, company "
				+ " from tb_sample_contacts ";
		
		Connection connection = ConnectionUtil.getConnection();
		
		PreparedStatement ptmt = connection.prepareStatement(sql);
		
		ResultSet rs = ptmt.executeQuery();
		
		while(rs.next()) {
			int no = rs.getInt("no");
			String name = rs.getString("name");
			String phoneNumber = rs.getString("phone_number");
			String email = rs.getString("email");
			String company = rs.getString("company");
			System.out.println("번호 : " + no);
			System.out.println("이름 : " + name);
			System.out.println("핸드폰번호  : " + phoneNumber);
			System.out.println("이메일 : " + email);
			System.out.println("회사 : " + company);
			System.out.println("-----------------------------------");
		}
		
		rs.close();
		ptmt.close();
		connection.close();
				
		
		
		
		
	}
}
