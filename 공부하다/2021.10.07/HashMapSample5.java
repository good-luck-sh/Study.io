package example_10_07_01_Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapSample5 {
	
	public static void main(String[] args) {
		
		List<Book> books = new ArrayList<>();	
		
		books.add(new Book("소설" , "남한산성"));
		books.add(new Book("소설" , "칼의 노래"));
		books.add(new Book("외국어" , "englishBook."));
		books.add(new Book("외국어" , "토익보카"));
		books.add(new Book("소설" , "레터의 연가"));
		books.add(new Book("공포" , "이것이 공포다"));
		books.add(new Book("컴퓨터" , "이것이 자바다"));
		books.add(new Book("컴퓨터" , "자바의 정석"));
		books.add(new Book("공포" , "고양이"));
		books.add(new Book("공포" , "까마귀"));
		books.add(new Book("대학교재" , "토익 기출문제"));
		books.add(new Book("대학교재" , "토익 기출문제"));
		books.add(new Book("인문" , "토익 기출문제"));
		
		//도서를 장르별로 구분해서 관리하는 Map객체 생성하기 
		Map<String, List<Book>> bookMap = new HashMap<>();
		//Map에 장르를 입력받을 Key와 book의 주소값을 입력받을 List배열<Book>을 value로 입력하였다. 
		for(Book book : books) {
			// 향상된 for문으로 books의 배열을 book에 담아 하나씩 꺼낸다. 
			String genre = book.getGenre();
			// book에 입력된 genre의 값을 꺼낸 후, 어떤 genre인지 이름을 입력받을 문자열로 반환한다. 
			if(bookMap.containsKey(genre)) {
				//만약 bookMap과 동일한 Key를 갖고있으면 true의 값을 반환하여, if문으로 들어온다. 
				List<Book> list = bookMap.get(genre);
				//List<Book>객체는 else문에서 생성했기 때문에 호출을하고,
				//Book객체를 갖고있는 List데이터배열을 참조변수 list에 bookMap에서 꺼내온다. genre의 키를 꺼내서  list의 값을 꺼내온다.
				list.add(book);
				//list에add메소드를 이용하여 더한다. 
				
				
			} else {
				//만약, containsKey와 동일한 genre의 값이 false인 경우 
				List<Book> list = new ArrayList<>();
				// Book객체를 갖고있는 ArrayList배열의 조상타입의 List배열의 데이터타입을 가지고 있는 참조변수list에
				list.add(book);
				//add메소드를 이용하여 book을 list참조변수에 주소값을 대입한다. 
				bookMap.put(genre, list);
				//bookMap에도 put 메소드를 이용하여 입력한다. (genre와 List데이터타입의 참조변수 list를 입력한다. )
				// 입력했기 때문에 list의 값은 add(book)을 가지고 있다. 
			}
		}
		System.out.println("### 집계 결과 간단히 출력해보기");
		System.out.println(bookMap);
		
		//컴퓨터 서적만 출력하기 
		List<Book> computerBooks = bookMap.get("컴퓨터");
		for(Book book : computerBooks) {
			System.out.println(book.getGenre() + " : " + book.getTitle());
		}
	}

	static class Book{
		private String genre;
		private String title;
		
		public Book(String genre, String title){
			this.genre = genre;
			this.title = title;
		}

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}
		public String toString() {
			return "[" + genre + " : " + title + "]";
		}
	}
		
}