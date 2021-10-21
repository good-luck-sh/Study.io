package example_10_21_store.app;

//static import. 지정된 클래스의 모든 static메소드를 import시킨다.정적 import
import static utils.KeyboardUtil.close;
import static utils.KeyboardUtil.*;

import java.sql.SQLException;
import java.util.List;

import example_10_21_store.service.ProductService;
import example_10_21_store.service.ProductServiceImpl;
import example_10_21_store.vo.Product;



public class StoreApp {
	
	//상품관리 업무로직이 구현된 ProductService의 구현 객체(ProductServiceImpl객체)를 생성한다. 
	private ProductService service = new ProductServiceImpl(); 

	public void displayMenu() {
		try {
		System.out.println("### 상품 관리 프로그램 ###");
		System.out.println("=======================================================");
		System.out.println("1.전체조회 2.상세정보  3.검색  4.신규등록 5.수정  6.삭제  0.종료");
		System.out.println("=======================================================");
		
		System.out.println("메뉴 선택: ");
		int menuNo = readInt();
		
		if(menuNo == 1) {
			전체조회();
		} else if (menuNo == 2) {
			상세정보조회();
		} else if (menuNo == 3) {
			검색();
		} else if (menuNo == 4) {
			신규등록();
		} else if (menuNo == 5) {
			정보수정();
		} else if (menuNo == 6) {
			삭제();
		} else if (menuNo == 0) {
			종료();
			
		}
		} catch(SQLException ex) {
			System.out.println("###[오류 발생] " + ex.getMessage());
			ex.printStackTrace(); //나중에 개발끝나면 주석처리 후 삭제하면 됨
		}
		System.out.println();
		displayMenu();
		
	} 
	
	private void 전체조회() throws SQLException {
		System.out.println("[상품 정보 전체 조회]");
		System.out.println("### 전체 상품목록을 표시합니다. ");
		
		//업무로직이 구현된 ProductService 구현객체의 getAllProducts()실행시켜서 상품정보(Product객체)가 여러개 저장된 List<Product>를 획득한다.
		List<Product> productList = service.getAllProducts();
		
		//List객체가 비어있는지 확인해서 (~~if문으로 확인함) 상품리스트를 표시하거나 안내메세지를 표시한다. 
		if(!productList.isEmpty()) { //isEmpty = false면 데이터가 있음 true면 데이터가 없음
			System.out.println("### 상품리스트 ");
			System.out.println("-------------------------------------------------------");
			System.out.println("번호\t가격\t할인가격\t상품명 ");
			System.out.println("-------------------------------------------------------");
			for(Product product : productList) {
				System.out.print(product.getNo() + "\t");
				System.out.print(product.getPrice() + "\t");
				System.out.print(product.getDiscountPrice() + "\t");
				System.out.println(product.getName() + "\t");
			}
			System.out.println("-------------------------------------------------------");

		} else {
			System.out.println("###[안내] 등록된 상품정보가 존재하지 않습니다.");
		}
		
	}
	private void 상세정보조회() throws SQLException {
		
	}
	private void 검색() throws SQLException {
			
		}
	private void 신규등록() throws SQLException {
		System.out.println("[신규등록]");
		System.out.println("### 카테고리, 상품명, 제조회사, 가격, 할인가격을 입력해주세요");
		System.out.println("제품의 카테고리를 입력하세요 : ");
		String category = readString();
		System.out.println("제품의 이름을 입력하세요 : ");
		String name = readString();
		System.out.println("제품을 만든 회사를 입력하세요 : ");
		String maker = readString();
		System.out.println("제품의 실제가격을 입력하세요 : ");
		int price = readInt();
		System.out.println("제품의 할인가격을 입력하세요 : ");
		int discountPrice = readInt();
		
		Product product = new Product();
		product.setCategory(category);
		product.setName(name);
		product.setMaker(maker);
		product.setPrice(price);
		product.setDiscountPrice(discountPrice);
		service.addNewProduct(product);
		
		System.out.println("### [안내] 상품등록이 완료되었습니다.");
				
		
	}
	private void 정보수정() throws SQLException {
		System.out.println("[상품정보수정]");
		System.out.println("상품수정할 번호를 입력하세요 : ");
		int no = readInt();
		
		System.out.println("상품수정 카테고리를 입력하세요 : ");
		String category = readString();
		System.out.println("상품수정 이름을 입력하세요 : ");
		String name = readString();
		System.out.println("상품수정 회사명을 입력하세요 : ");
		String maker = readString();
		System.out.println("상품수정 실제가격을 입력하세요 : ");
		int price = readInt();
		System.out.println("상품수정 할인가격을 입력하세요 : ");
		int discountPrice = readInt();
		
	}	
	private void 삭제() throws SQLException {
		
	}	
	private void 종료() throws SQLException {
		System.out.println("[프로그램종료]");
		System.out.println("### 프로그램을 종료합니다. ");
		
		close();	//keyboardUtil의 close()메소드 실행 : 입출력관련 리소스 닫기 
		System.exit(0);		//System.exit(정수) :프로그램을 종료시킨다. 정수값이 음수면 오류로 인한 종료이다. 
	}
	
	public static void main(String[] args) {
		new StoreApp().displayMenu();
	}
}
