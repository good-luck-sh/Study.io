package example_10_05_4_generic_sample;

public class Ticket extends Product {

	private String date;	//공연날짜
	//예약 매수
	
	public Ticket() {}
	public Ticket(int no, String name, String date, int price) {
		super(no, name,price);
		this.date = date;
		
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
