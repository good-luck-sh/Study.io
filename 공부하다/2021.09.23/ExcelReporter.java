package example_09_23_interface;

public class ExcelReporter implements Reporter{ //리포트를 구현한 엑셀 리포트 
	private String title;
	private String[]columns;
	private String[]data;
	
	public ExcelReporter(String title, String[] columns, String[] data) {//엑셀리포트를 만들때 이런 값을 입력할 수 있음
		this.title = title;
		this.columns = columns;
		this.data = data;
	
	}
	@Override
	public void printReport() {
		//제목표시 
		System.out.println("제목:" + title);
		//컬럼명 표시
		for(String column : columns) {
			System.out.print(column + "\t");
		}
		System.out.println();
		//데이터 표시 
		for(String value : data) {
			System.out.print(value +"\t");
		}
		System.out.println();
	}
}
