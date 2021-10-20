package example_10_20.jdbc.contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import utils.ConnectionUtil;

public class ContactDelete {

	public static void main(String[] args) throws SQLException {
		
		Scanner scan = new Scanner(System.in);
		String sql = "delete from tb_sample_contacts "
				+ "where name = ? ";
		Connection connection = ConnectionUtil.getConnection();
		
		PreparedStatement ptmt = connection.prepareStatement(sql);
		
		System.out.println("삭제할 분의 성함을 입력하세요 :");
		String name = scan.next();
		ptmt.setString(1, name);
		int rowCount = ptmt.executeUpdate();
		System.out.println(rowCount + "행을 삭제했습니다. ");
		
		ptmt.close();
		connection.close();
	}
}
