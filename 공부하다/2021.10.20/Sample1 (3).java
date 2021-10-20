package example_10_20.jdbc.update;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utils.ConnectionUtil;

public class Sample1 {

	public static void main(String[] args) throws SQLException {
		//1.SQL 작성하기 
		String sql = "update tb_sample_books "
					+ "set "
					+ "book_stock = ?, "
					+ "book_on_sale = ? "
					+ "where "
					+ "book_publisher = ?";
				
				
		//2.Connection획득하기 
		Connection connection = ConnectionUtil.getConnection();
		
		//3. PreparedStatement획득하기 
		PreparedStatement ptmp = connection.prepareStatement(sql);
		
		//4. ?값에 바인딩하기 
		ptmp.setInt(1, 0);
		ptmp.setString(2, "재고없음");
		ptmp.setString(3, "대원사");
		//5. SQL전송 및 실행결과 받기 
		int rowCount = ptmp.executeUpdate();
		System.out.println(rowCount + "가 수정되었습니다. ");
		//6. 종료
		ptmp.close();
		connection.close();
	}
}
