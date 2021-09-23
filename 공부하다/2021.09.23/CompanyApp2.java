package example_09_23_interface;

public class CompanyApp2 {

	public static void main(String[] args) {
		String title = "영업1팀 영업이익 현황";
		String[] columnLabels = {"총매출액","영업이익"};
		int[] values = {350_000_000,120_000_000};
		
		ChartReporter chart = new ChartReporter(title, columnLabels, values);
		Company company = new Company();
		company.setReporter(chart);
		
		company.displayCompanyEarning();
	
	
	
	}
}
