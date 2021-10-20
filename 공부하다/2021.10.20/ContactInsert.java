package example_10_20.jdbc.contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import javax.net.ssl.CertPathTrustManagerParameters;

import utils.ConnectionUtil;

public class ContactInsert {
	public static void main(String[] args) throws SQLException {
		//순번, 이름, 전화번호, 이메일, 소속회사 정보를 입력받아서 tb_sample_contacts에 추가하기
		//insert into tb_sample_contacts(no, name, phone_number, email, company)
		//values(?, ?, ?, ?, ?)
		
		Scanner scan = new Scanner(System.in);
		String sql = "insert into tb_sample_contacts (no, name, phone_number, email, company) "
				+ "values(?, ?, ?, ?, ?) ";
		
		Connection connection = ConnectionUtil.getConnection();
		
		PreparedStatement ptmt = connection.prepareStatement(sql);
	
			
			
			System.out.println("tb_sample_contacts에 입력하실 순번을 입력하세요 :");
			int no = scan.nextInt();
			
			System.out.println("tb_sample_contacts에 입력하실 이름을 입력하세요 :");
			String name = scan.next();
			
			System.out.println("tb_sample_contacts에 입력하실 전화번호를 입력하세요 :");
			String phoneNumber = scan.next();
			
			System.out.println("tb_sample_contacts에 입력하실 이메일을 입력하세요 :");
			String email = scan.next();
			
			System.out.println("tb_sample_contacts에 입력하실 회사를 입력하세요 :");
			String company = scan.next();
			
			ptmt.setInt(1, no);
			ptmt.setString(2, name);
			ptmt.setString(3, phoneNumber);
			ptmt.setString(4, email);
			ptmt.setString(5, company);
		
		int rs = ptmt.executeUpdate();
		System.out.println(rs + "행이 추가 되었습니다. ");
		
		
		ptmt.close();
		connection.close();
		
		
		
	}
}
