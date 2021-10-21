package example_10_21_store.service;

import java.sql.SQLException;
import java.util.List;

import example_10_21_store.dao.ProductDao;
import example_10_21_store.dao.ProductJdbcDao;
import example_10_21_store.vo.Product;

public class ProductServiceImpl implements ProductService{

	
	//SQL이 어디에 구현되어있는지 확인후 연결해준다.연결객체는 인터페이스로 연결한다. 
	private ProductDao productDao = new ProductJdbcDao();
	
	@Override
	public List<Product> getAllProducts() throws SQLException {
		List<Product> productList = productDao.selectAllProducts();
		return productList;
	}

	@Override
	public Product getProductDetail(int productNo) throws SQLException {
		Product product = null;
		product = productDao.selectProductByNo(productNo);
		if(product == null) {
			System.out.println("입력된 번호가 없습니다.");
			return product;
		}

		return product;
	}

	@Override
	public void addNewProduct(Product product) throws SQLException {
		// TODO 등록기능만 구현, 추후 동일한 상품 존재할 때 재고량 증가기능 추가
		productDao.insertProduct(product);
		
	}

	@Override
	public void modifyProduct(Product product) throws SQLException {
	
		productDao.updateProduct(product);
		
	}

	@Override
	public void removeProduct(int productNo) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> searchProductByCategory(String category) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> searchProductByName(String keyword) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> searchProductByPrice(int minPrice, int maxPrice) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> serchLowerStockkProducts(int minStock) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
