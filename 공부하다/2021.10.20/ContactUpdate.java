package example_10_20.jdbc.contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import utils.ConnectionUtil;

public class ContactUpdate {

	public static void main(String[] args) throws SQLException {
		
		Scanner scan = new Scanner(System.in);
		String sql = "update tb_sample_contacts "
				+ "set "
				+" 	no = ? ,"
				+"	phone_number = ? ,"
				+"	email = ? ,"
				+" 	company = ? "
				+" where name = ? ";
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		
		System.out.println("수정할 분의 이름을 입력하세요 ");
		String name = scan.next();
		System.out.println("수정할 분의 순번을 입력하세요 ");
		int no = scan.nextInt();
		System.out.println("수정할 분의 핸드폰번호를 입력하세요 ");
		String phoneNumber = scan.next();
		System.out.println("수정할 분의 이메일을 입력하세요 ");
		String email = scan.next();
		System.out.println("수정할 분의 회사명칭을 입력하세요 ");
		String company = scan.next();
		
		
		ptmt.setInt(1, no);
		ptmt.setString(2,phoneNumber);
		ptmt.setString(3, email);
		ptmt.setString(4, company);
		ptmt.setString(5, name);
		
		int rowCount = ptmt.executeUpdate();
		System.out.println(rowCount + "행을 수정했습니다. ");
		
		ptmt.close();
		connection.close();
	
	
	}
}
