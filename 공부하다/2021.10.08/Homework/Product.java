package example_10_05_4_generic_sample;

import java.util.Objects;

public class Product {

	private int no;			//제품번호
	private String name;	//제품명
	private int price;		//제품가격
	private int stock;		//재고량
	
	public Product() {}
	public Product(int no, String name, int price) {
		this.no = no;
		this.name = name;
		this.price = price;
		this.stock = 10;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
}

