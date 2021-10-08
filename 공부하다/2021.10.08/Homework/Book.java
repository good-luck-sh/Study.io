package example_10_05_4_generic_sample;

public class Book extends Product {

	private String writer;
	private String genre;
	
	public Book() {}
	public Book(int no, String name, String writer, String genre, int price) {
		super(no, name, price);
		this.writer = writer;
		this.genre = genre;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
}
