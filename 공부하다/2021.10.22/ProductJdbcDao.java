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
					+" (product_no, product_category, product_name, product_maker,product_price, product_discount_price, product_stock) "
					+"values "
					+" ( product_seq.nextval , ?, ?, ?, ?, ?, ?) ";
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		
		ptmt.setString(1, product.getCategory());//순수하게 물음표의 순서로 입력하면 됨
		ptmt.setString(2, product.getName()); //product로 받을 것이기 떄문에 product의 get을 입력하면됨
		ptmt.setString(3, product.getMaker());
		ptmt.setInt(4, product.getPrice());
		ptmt.setInt(5, product.getDiscountPrice());
		ptmt.setInt(6, product.getStock());
		
		int rowCount = ptmt.executeUpdate();
		System.out.println(rowCount + "행이 추가 되었습니다. ");
		
		ptmt.close();
		connection.close();
		
	}

	@Override
	public void updateProduct(Product product) throws SQLException {
	
		String sql = "update tb_sample_products "
					+"set "
					+	" product_category = ? , "
					+ 	" product_name = ? , "
					+	" product_maker = ?,  "
					+	" product_price = ?,  "
					+	" product_discount_price = ?, "
					+	" product_stock = ?, "
					+	" product_on_sale = ? "
					+ "where "
					+ " product_no = ? ";
					
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setString(1, product.getCategory());
		ptmt.setString(2, product.getName());
		ptmt.setString(3, product.getMaker());
		ptmt.setInt(4, product.getPrice());
		ptmt.setInt(5, product.getDiscountPrice());
		ptmt.setInt(6, product.getStock());
		ptmt.setString(7, product.getOnSale());
		ptmt.setInt(8, product.getNo());
		
		ptmt.executeUpdate();
		
		ptmt.close();
		connection.close();
		//변경가능한 업데이트를 통으로 입력함, 가격만 바꿀때, 수량만 바꿀때, 판매상태만 변경시에도 사용함
	}

	@Override
	public Product selectProductByNo(int productNo) throws SQLException {
		Product product = null;
		String sql = " select product_no, product_category, product_name, product_maker, "
					+" product_price, product_discount_price, product_stock, product_on_sale, product_created_date "
					+" from tb_sample_products "
					+" where product_no = ? ";
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1, productNo);
		ResultSet rs = ptmt.executeQuery();
		if(rs.next()) {//없으면 false가 출력됨
			product = rowToProduct(rs);

		}
		
		rs.close();
		ptmt.close();
		connection.close();
		
		return product;
	}

	@Override
	public void deleteProduct(int productNo) throws SQLException {
		String sql = "delete from tb_sample_products "
					+"where product_no = ? ";
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		
		ptmt.setInt(1, productNo);
		
		ptmt.executeUpdate();
		
		ptmt.close();
		connection.close();
		
	}

	@Override
	public Product getProductByProductName(String productName) throws SQLException {
		Product product = null;
		String sql ="select product_no, product_category, product_name, product_maker, product_price, product_discount_price, product_stock, "
				+" product_on_sale, product_created_date "
				+"from tb_sample_products "
				+" where product_name = ? ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setString(1, productName);
		 
		ResultSet rs = ptmt.executeQuery();
		
		if(rs.next()) {
			product = rowToProduct(rs);
			//행하나를 product로 바꾸겠다.
			//method로 지정하니 심플해짐
			
		} 
		rs.close();
		ptmt.close();
		connection.close();
		return product;
	}

	private Product rowToProduct(ResultSet rs) throws SQLException {
		Product product;
		product = new Product();
		product.setNo(rs.getInt("product_no"));
		product.setCategory(rs.getString("product_category"));
		product.setName(rs.getString("product_name"));
		product.setMaker(rs.getString("product_maker"));
		product.setPrice(rs.getInt("product_price"));
		product.setDiscountPrice(rs.getInt("product_discount_price"));
		product.setStock(rs.getInt("product_stock"));
		product.setOnSale(rs.getString("product_on_sale"));
		product.setCreatedDate(rs.getDate("product_created_date"));
		return product;
	}

	@Override
	public List<Product> searchProductByKeyword(String keyword) throws SQLException {
		List<Product> products = new ArrayList<>();
		String sql ="select product_no, product_category, product_name, product_maker, product_price, product_discount_price, product_stock, "
				+" product_on_sale, product_created_date "
				+"from tb_sample_products "
				+" where product_name like '%'|| ? ||'%'";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setString(1, keyword);
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()) {
			Product product = new Product();
			product = rowToProduct(rs);
			products.add(product);
		}
		
		return products;
	}

	@Override
	public List<Product> getProductByCategory(String category) throws SQLException {
		List<Product> products = new ArrayList<>();
		String sql ="select product_no, product_category, product_name, product_maker, product_price, product_discount_price, product_stock, "
				+" product_on_sale, product_created_date "
				+"from tb_sample_products "
				+" where product_category like '%'|| ? ||'%'";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setString(1, category);
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()) {
			Product product = new Product();
			product = rowToProduct(rs);
			products.add(product);
		}
		rs.close();
		ptmt.close();
		connection.close();
		return products;
	}

	@Override
	public List<Product> getProductByPrice(int minPrice, int maxPrice) throws SQLException {
		List<Product> products = new ArrayList<>();
		String sql = "select product_no, product_category, product_name, product_maker, product_price, product_discount_price, product_stock, "
					+" product_on_sale, product_created_date "
					+"from tb_sample_products "
					+"where product_price >= ? and product_price <= ? ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1, minPrice);
		ptmt.setInt(2, maxPrice);
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()) {
			Product product = new Product();
			product = rowToProduct(rs);
			products.add(product);
		}
		rs.close();
		ptmt.close();
		connection.close();
		
		
		return products;
	}

	@Override
	public List<Product> getProductByStock(int stock) throws SQLException {
		List<Product> products = new ArrayList<>();
		String sql = "select product_no, product_category, product_name, product_maker, product_price, product_discount_price, product_stock, "
					+" product_on_sale, product_created_date "
					+"from tb_sample_products "
					+"where product_stock < ? ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1, stock);
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()) {
			Product product = new Product();
			product = rowToProduct(rs);
			products.add(product);
		}
		rs.close();
		ptmt.close();
		connection.close();
		return products;
	}
	
	
	
	
	
	
	
}
