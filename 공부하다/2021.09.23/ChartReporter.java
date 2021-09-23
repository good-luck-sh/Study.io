package example_09_23_interface;

public class ChartReporter implements Reporter {

	private String title;
	private String[] columnLabels;
	private int[] values;
	
	public ChartReporter(String title, String[] columnLabels, int[] values) {
		this.title = title;
		this.columnLabels = columnLabels;
		this.values = values;
	}
	
	@Override
	public void printReport() {
		System.out.println("[" + title + "]\n");
		
		for(int index = 0; index <columnLabels.length; index++) {
			System.out.print(columnLabels[index] + "\t");
			
			int value = values[index];
			int startCount = value/10_000_000;
			
			for(int i = 1 ; i <= startCount; i++) {
				System.out.print("*");
			}
			System.out.println("");
			
		}
		
	}
	
}
