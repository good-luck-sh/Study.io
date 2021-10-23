package example_10_21_store.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import example_10_21_store.dao.ProductDao;
import example_10_21_store.dao.ProductJdbcDao;
import example_10_21_store.exception.StoreException;
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
	public Product getProductDetail(int productNo) throws SQLException { //runtime은 SQLException을 받아서 따로 발생시키지 않아도됨
		Product product = productDao.selectProductByNo(productNo);
		//StorewException 예외는 업무로직상의오류가 있을 때 강제 발생시키는 예외다.
		if(product == null) {
			throw new StoreException("[" + productNo + "] 상품번호에 해당하는 상품정보가 존재하지 않습니다.");
			//사용자정의 Exception으로 의도적으로 던져버리는 예외 , 사용자가 입력한 것이 없는 값, 예외를 발생시킴
		}
		return product;
	}

	@Override
	public void addNewProduct(Product product) throws SQLException {
		//새로 등록하려면 상품의 상품명과 동일한 상품이 있는지 조회한다. 
		Product savedProduct = productDao.getProductByProductName(product.getName());
		
		if(savedProduct != null) {
			//기존 상품의 재고량과 등록하려는 상품의 재고량의 합계를 계산한다. 
			int totalStock = savedProduct.getStock() + product.getStock();
			//상품정보의 재고량의 변경한다. 
			savedProduct.setStock(totalStock);
			//재고량이 변경된 상품정보를 테이블에 반영시킨다.
			productDao.updateProduct(savedProduct);
		} else {
		productDao.insertProduct(product);
		}	
	}

	@Override
	public void updateProductPrice(int productNo, int price, int discountPrice) throws SQLException {
		
		if(discountPrice > price ) {
			throw new StoreException("할인가격이 정상가격보다 크게 지정되었습니다.");
		}
		
		//수정할 정보의 수정전 정보를 조회한다. 
		Product product = getProductDetail(productNo);
		//수정할 항목의 변수값만 변경한다.
		product.setPrice(price);
		//DAO의 업데이트 메소드에게 변경된 정보가 반영된 VO객체를 전달한다.
		product.setDiscountPrice(discountPrice);
		productDao.updateProduct(product);
		
	}

	@Override
	public void removeProduct(int productNo) throws SQLException {
		Product product = productDao.selectProductByNo(productNo);
		if(product == null) {
			throw new StoreException("[" + productNo + "] 상품정보에 해당하는 상품정보가 존재하지 않아, 완료되지 못했습니다.");
		}
		productDao.deleteProduct(productNo);
		
	}

	@Override
	public List<Product> searchProductByCategory(String category) throws SQLException {
		List<Product> searchProducts = productDao.getProductByCategory(category);

		return searchProducts;
	}

	@Override
	public List<Product> searchProductByName(String keyword) throws SQLException {
		List<Product> searchProducts = productDao.searchProductByKeyword(keyword);

		return searchProducts;
	}

	@Override
	public List<Product> searchProductByPrice(int minPrice, int maxPrice) throws SQLException {
		List<Product> products = productDao.getProductByPrice(minPrice,maxPrice);
		return products;
	}

	@Override
	public List<Product> serchLowerStockkProducts(int minStock) throws SQLException {
		List<Product> products = productDao.getProductByStock(minStock);
		return products;
	}

}
