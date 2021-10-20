package example_10_20.jdbc.delete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utils.ConnectionUtil;

public class Sample1 {

	public static void main(String[] args) throws SQLException{
		
		//1. SQL쿼리 작성하기 
		String sql ="delete from tb_sample_books " 
				+ "where book_no = ?";
		//2.Connection 획득하기 
		Connection connection = ConnectionUtil.getConnection();
		
		//3.PreparedStatement 획득하기 
		PreparedStatement pstmt = connection.prepareStatement(sql);
		
		//4.?값에 바인딩하기 
		pstmt.setInt(1, 400);
		
		//5.SQL 전송 및 실행결과 받기 
		int rowCount = pstmt.executeUpdate();
		System.out.println(rowCount + "개의 행이 삭제되었습니다. ");
		
		//6.SQL닫기 
	
		pstmt.close();
		connection.close();
	}
}
