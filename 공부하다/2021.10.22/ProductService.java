package example_10_21_store.service;

import java.sql.SQLException;
import java.util.List;

import example_10_21_store.vo.Product;

/**
 * 상품관리 기능을 제공하는 서비스 인터페이스이다. 
 * @author 김승희
 *
 */
public interface ProductService { //인터페이스기 때문에 추상메소드로 만든다. 

	/**
	 * 모든 상품 정보를 반환한다. 
	 * @return 상품정보 리스트
	 * @throws SQLException DB Access 오류시 예외가 발생한다. 
	 */
	List<Product> getAllProducts() throws SQLException;
	/**
	 * 지정된 상품번호에 대한 상품상세정보를 반환한다. 
	 * @param productNo 상품번호
	 * @return 상품상세정보
	 * @throws SQLException DB Access 오류시 예외가 발생한다. 
	 */
	Product getProductDetail(int productNo) throws SQLException;
	/**
	 * 지정된 상품정보를 반환한다<br\>
	 * 동일한 이름의 상품정보가 존재하면 해당 상품의 재고량을 증가시킨다.
	 * @param product 등록할 상품정보
	 * @throws SQLException DB Access 오류시 예외가 발생한다. 
	 */
	void addNewProduct(Product product) throws SQLException;
	/**
	 * 지정된 정보로 상품의 가격을 수정한다
	 * @param productNo 상품번호
	 * @param price 수정된 상품가격
	 * @param discountPrice 수정된 할인가격
	 * @throws SQLException DB Access 오류시 예외가 발생한다. 
	 */
	void  updateProductPrice(int productNo, int price, int discountPrice) throws SQLException;
	/**
	 * 지정된 상품번호로 상품번호를 삭제한다.
	 * @param productNo 삭제할 상품의 번호
	 * @throws SQLException DB Access 오류시 예외가 발생한다. 
	 */
	void removeProduct(int productNo) throws SQLException;

	/**
	 * 지정된 카테코리에 해당하는 상품정보들을 반환한다. 
	 * @param category 조회할 상품의 카테고리
	 * @return 지정된 카테고리의 상품정보 목록
	 * @throws SQLException DB Access 오류시 예외가 발생한다. 
	 */
	List<Product>searchProductByCategory(String category) throws SQLException;
	/**
	 * 지정된 키워드가 상품명에 포함된 상품정보들을 반환한다. 
	 * @param keyword 검색어
	 * @return 상품정보 목록 
	 * @throws SQLException DB Access 오류시 예외가 발생한다. 
	 */
	List<Product>searchProductByName(String keyword) throws SQLException;
	/**
	 * 지정된 가격범위에 해당하는 상품정보들을 반환한다. 
	 * @param minPrice 최소가격
	 * @param maxPrice  최대가격
	 * @return 상품정보 목록
	 * @throws SQLException DB Access 오류시 예외가 발생한다. 
	 */
	List<Product>searchProductByPrice(int minPrice, int maxPrice) throws SQLException;
	/**
	 * 지정된 재고량보다 재고량이 적은 상품정보들을 반환한다. 
	 * @param minStock 최소 재고량
	 * @return 상품정보 목록
	 * @throws SQLException DB Access 오류시 예외가 발생한다. 
	 */
	List<Product>serchLowerStockkProducts(int minStock) throws SQLException;
	//상품서비스에 대해서 인터페이스에서 구현한 것임.

}
