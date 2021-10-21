package example_10_21_store.dao;

import static utils.ConnectionUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import example_10_21_store.vo.Product;
import utils.ConnectionUtil;

public class ProductJdbcDao implements ProductDao {

	@Override
	public List<Product> selectAllProducts() throws SQLException {
		List<Product> products = new ArrayList<>(); //먼저 list 변수를 선언한다음
		
		String sql = "select product_no, product_price, product_discount_price, product_name "
				+ "from tb_sample_products "
				+ "order by product_no desc ";
		
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery();

		while(rs.next()) {
			//ResultSet에서 현재 커서가 가르키는 행에서 상품정보 조회
//			int no = rs.getInt("product_no");
//			int price = rs.getInt("product_price");
//			int discountPrice = rs.getInt("product_discount_price");
//			String name = rs.getString("product_name");
			//조회된 상품정보를 Product객체를 생성후 담기 
			
			//ResultSet객체에서 커서가 현재 위치한 행의 값을 조회해서 Product객체에 담는다.
			Product product = new Product();
			product.setNo(rs.getInt("product_no")); //
			product.setPrice(rs.getInt("product_price"));
			product.setDiscountPrice(rs.getInt("product_discount_price"));
			product.setName(rs.getString("product_name"));
			
			//상품정보가 담긴 Product 객체를 List객체에 저장
			products.add(product);
		}
		rs.close();
		ptmt.close();
		connection.close();
		return products;//return에 변수명을 입력하세요
	}

	@Override
	public void insertProduct(Product product) throws SQLException {
		String sql = "insert into tb_sample_products "
					+" (product_no, product_category, product_name, product_maker,product_price, product_discount_price) "
					+"values "
					+" ( product_seq.nextval , ?, ?, ?, ?, ?) ";
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		
		ptmt.setString(1, product.getCategory());//순수하게 물음표의 순서로 입력하면 됨
		ptmt.setString(2, product.getName()); //product로 받을 것이기 떄문에 product의 get을 입력하면됨
		ptmt.setString(3, product.getMaker());
		ptmt.setInt(4, product.getPrice());
		ptmt.setInt(5, product.getDiscountPrice());
		
		int rowCount = ptmt.executeUpdate();
		System.out.println(rowCount + "행이 추가 되었습니다. ");
		
		ptmt.close();
		connection.close();
		
	}

	@Override
	public void updateProduct(Product product) throws SQLException {
		String sql = "update table tb_smaple_products "
					+"set "
					+	"product_category = ? , "
					+ 	"product_name = ? , "
					+	"product_maker = ?,  "
					+	"product_price = ?,  "
					+	"product_discount_price = ? "
					+ "where product_no = ? ";

					
					
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setString(1, product.getCategory());
		ptmt.setString(2, product.getName());
		ptmt.setString(3, product.getMaker());
		ptmt.setInt(4, product.getPrice());
		ptmt.setInt(5, product.getDiscountPrice());
		ptmt.setInt(6, product.getNo());
		
		int rowCount = ptmt.executeUpdate();
		System.out.println(rowCount + "행이 수정되었습니다.");
		
		ptmt.close();
		connection.close();
	}

	@Override
	public Product selectProductByNo(int productNo) throws SQLException {
		Product product = null;
		String sql = "select product_no, product_category, product_name, product_maker, "
					+" product_price, product_discount_price, product_stock, product_on_sale, product_created_date "
					+" from tb_sample_products"
					+"where = product_no ";
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1, productNo);
		ResultSet rs = ptmt.executeQuery();
		if(rs.next()) {//없으면 false가 출력됨
			product = new Product();
			product.setNo(rs.getInt("productNo"));
			product.setCategory(rs.getString("product_category"));
			product.setName(rs.getString("product_name"));
			product.setMaker(rs.getString("product_maker"));
			product.setPrice(rs.getInt("prouct_price"));
			product.setDiscountPrice(rs.getInt("product_discount_price"));
			product.setStock(rs.getInt("product_stock"));
			product.setOnSale(rs.getString("product_on_sale"));
			product.setCreatedDate(rs.getDate("product_created_date"));

		}
		
		rs.close();
		ptmt.close();
		connection.close();
		
		return product;
	}
	
	
	
	
	
	
}
