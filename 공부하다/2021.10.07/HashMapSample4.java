package example_10_07_01_Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapSample4 {

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
		
		//장르가 몇개인지 알고 싶다. 근데 장르가 몇개인지 모름
		
		//Key는 장르명, Value는 장르명 도서갯수로 하는 Map객체를 생성한다.
		Map<String,Integer> genreSummary = new HashMap<>();
		//Map<Key, value> key에 String, 값에 정수값을 담는 hashmap을 생성하였다. 
		for(Book book : books) {
			//향상된 for문으로 만들어둔 list배열을 반복한다. 
			String genre = book.getGenre();
			//book의 장르 데이터를 꺼내고, String타입의 참조변수 genre에 담는다. 
			//장르명을 조회
			if(genreSummary.containsKey(genre)) { //이미 해당 장르가 존재하는 경우
				//Map객체에 조회된 장르면이 포함되있는지 체크
				//만약 생성한 hashmap의 참조변수에 해당하는 키와 참조변수 genre가 동일하다면
				int count = genreSummary.get(genre);
				//hashmap에서 가져온다 genre를 그리고 value를 오토언박싱으로 정수타입의 count변수에 입력한다. 
				genreSummary.put(genre, count+1);
				//Map객체에 해당하는 장르명과 1증가된 도서개수를 다시 저장한다. 
				 
			} else { 								//해당 장르가 존재하지 않는 경우 
				//Map객체에 장르명이 존재하지 않는 경우 
				//해당 장르를 Key,1을 value로 map에 저장한다. 
				genreSummary.put(genre, 1);
			}
		}System.out.println(genreSummary);
		
		
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

		@Override
		public String toString() {
			return "Book [genre=" + genre + ", title=" + title + "]";
		}
		
	}
}
