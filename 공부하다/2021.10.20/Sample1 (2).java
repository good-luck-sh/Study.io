package example_10_20.jdbc.select;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import utils.ConnectionUtil;

public class Sample1 {

	public static void main(String[] args) throws SQLException {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("### 책 검색 프로그램");
		System.out.println("### 책 검색할 키워드를 입력하세요  ");
		System.out.println("### 키워드: ");
		//도서관 검색프로그램의 코드작성
		
		String keyword = scan.next();
		
		// 1.SQL작성하기 
		String sql =" select book_no, book_title, book_writer, book_publisher, book_price, "
				+ "    book_discount_price, book_stock, book_on_sale "
				+"from tb_sample_books "
				+ "where book_title like '%' || ? || '%' " //오라클에서는 % + ? + %를 ||으로 연결됨, 글자연결은 ||를 사용함
				+"order by book_no desc ";
		// 2. Connection객체 생성하기 
		Connection connetion = ConnectionUtil.getConnection();
		
		// 3. PreparedStatement 객체 획득하기
		PreparedStatement pstmt = connetion.prepareStatement(sql);
		// 4. ?에 값 바인딩하기 
		//SQL에 ? 가 없어서 생략 -- >검색프로그램 구현함 
		pstmt.setString(1, keyword);
		
		// 5. SQL을 RDBMS로 전송해서 실행시키고, 조회결과가 포함한 ResultSet객체를 획득한다. 
		ResultSet rs = pstmt.executeQuery();
		
		// 6. ResultSet의 API를 사용해서 조회결과를 추출해서 화면에 출력한다. 
		
		while(rs.next()) { //내용에 없으면 false를 반환함
			int no = rs.getInt("book_no");
			String title = rs.getString("book_title");
			String writer = rs.getString("book_writer");
			String publisher = rs.getString("book_publisher");
			int price = rs.getInt("book_price");
			int discountPrice = rs.getInt("book_discount_price");
			int stock = rs.getInt("book_stock");
			String onSale = rs.getString("book_on_sale");
			
			System.out.println("책의 번호 : " + no);
			System.out.println("책의 제목 : " + title);
			System.out.println("책의 저자 : " + writer);
			System.out.println("책의 출판사 : " + publisher);
			System.out.println("책의 실제가격 : " + price);
			System.out.println("책의 판매가격 : " + discountPrice);
			System.out.println("책 재고 : " + stock);
			System.out.println("책 판매여부 : " + onSale);
			
			System.out.println("-------------------------------------");
		
		}

		
		
		
		
		// 7. 사용했던 자원을 해제한다. 
		rs.close();
		pstmt.close();
		connetion.close();
		//항상 역순으로 닫아줘야한다.
	}
}
