package example_09_23_interface;

public class CompanyApp {

	public static void main(String[] args) {
		
		//영업이익 Data
		String title =  "영업1팀 영업이익 현황";
		String[] columns = {"부서명" , "총매출액","영업이익"};
		String[] data = {"영업1팀" , "100억원" , "20억원"};
		
		//Reporter인터페이스 구현 객체 생성하기 
		ExcelReporter excel = new ExcelReporter(title, columns, data);
		
		//Company 객체 생성하기 
		Company company = new Company();
		
		//Company 객체가 사용할 Reporter인터페이스 구현객체를 전달하기 
		company.setReporter(excel);
		
		//영업이익을 리포트로 출력하기 
		company.displayCompanyEarning();
	}
}
