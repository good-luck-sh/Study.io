package example_10_20.jdbc.contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import utils.ConnectionUtil;

public class ConsertSelect2 {

	public static void main(String[] args) throws SQLException {
		Scanner scan = new Scanner(System.in);
		
		
		String sql = "select no, name, phone_number, email, company "
				+ " from tb_sample_contacts "
				+" where name "
				+ "like '%' || ? || '%' ";
		System.out.println("검색할 이름을 입력하세요 :");
		String name = scan.next(); 
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setString(1, name);
		ResultSet rs = ptmt.executeQuery();
		
		while(rs.next()) {
			int no = rs.getInt("no");
			String names = rs.getString("name");
			String phoneNumber = rs.getString("phone_number");
			String email = rs.getString("email");
			String company = rs.getString("company");
			
			System.out.println("번호 : " + no);
			System.out.println("이름 : " + names);
			System.out.println("핸드폰번호 : " + phoneNumber);
			System.out.println("이메일 : " + email);
			System.out.println("회사이름 : " + company);
			System.out.println("----------------------------------");
		}
		rs.close();
		ptmt.close();
		connection.close();
		
	}
}
