package example_10_21_store.dao;

import java.sql.SQLException;
import java.util.List;

import example_10_21_store.vo.Product;

/**
 * TB_SAMPLE_PRODUCTS 테이블에 대한 CRUD 작업이 정의된 인터페이스다.
 * @author 김승희
 *
 */
public interface ProductDao {

	/**
	 * TB_SAMPLE_PRODUCTS 테이블의 모든 상품정보를 조회해서 반환한다. 
	 * @return 모든상품정보 
	 * @throws SQLException DB Access 오류시 예외가 발생한다. 
	 */
	List<Product> selectAllProducts() throws SQLException; //그떄그때 하나씩 추가하는 걸로 
	// 지정된 상품정보를 반환한다<br\>
	
	/**
	 * 지정된 상품정보를 TB_SAMPLE_PRODUCTS 테이블에 추가한다. 
	 * @param product 새 상품정보
	 * @throws SQLException DB Access 오류시 예외가 발생한다. 
	 */
	void insertProduct(Product product) throws SQLException;
	//select외에는 전부 반환타입은 void로 진행
	/**
	 * 지정된 상품정보를 TB_SAMPLE_PRODUCTS 테이블에서 찾아서 수정한다. 
	 * @param product 변경할 상품정보
	 * @throws SQLException DB Access 오류시 예외가 발생한다. 
	 */
	void updateProduct(Product product) throws SQLException;
	/**
	 * 지정된 번호에 해당하는 상품정보를 TB_SAMPLE_PRODUCTS 테이블에 조회해서 반환한다.
	 * @param productNo 조회할 상품의 상품번호
	 * @return 상품정보, 틀린상품번호일 경우 null이 반환된다. 
	 * @throws SQLException DB Access 오류시 예외가 발생한다. 
	 */
	Product selectProductByNo(int productNo) throws SQLException;


}
