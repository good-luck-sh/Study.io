package com.sample.bookstore.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.bookstore.service.BookService;
import com.sample.bookstore.vo.Book;
import com.sample.bookstore.web.form.BookForm;

import lombok.extern.slf4j.Slf4j;

@Slf4j //로고를 나타내는 어노테이션
@CrossOrigin(origins = "*")//전체를 선택한다. "http://localhost:8080"이렇게 허용해놓아도 된다.
@RestController //전부 restController이다.JSON데이터로 보내기 때문
@RequestMapping("/api/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	 //서버로 요청보내기
    //요청방식 : GET
    //요청 URL : http://localhost/api/book 
    //요청데이터 :없음
    //응답데이터 :[{"no":1},{"title":"자바연습"},{"author":"홍길동"},{"no":1},{"title":"자바연습"},{"author":"홍길동"}]
	@GetMapping
	public List<Book> books() {
		return bookService.getAllBooks();
	}
	 //요청방식:POST
    //요청URL :http://localhost/api/book
    //요청데이터 : '{"title":"이것이 자바다","author":"홍길동","publisher":"한빛미디어"..}'
    //응답데이터 :'{"no":401,"title":"이것이 자바다","author":"홍길동","publisher":"한빛미디어"..}'
	@PostMapping
	public Book save(@RequestBody BookForm form) {
		log.info("폼 입력값:" +form); //@slf4j를 사용해서 로고를 사용한다.
		Book book = Book.builder().title(form.getTitle())
				.author(form.getAuthor())
				.publisher(form.getPublisher())
				.price(form.getPrice())
				.discountPrice(form.getDiscountPrice())
				.stock(form.getStock())
				.build(); //빌드패턴으로 만들어서 전달한다 
		Book savedBook = bookService.insertNewBook(book);
		return savedBook; //return으로 값을 보내준다.
	}
	 //요청방식:DELETE
    //요청URL :http://localhost/api/book/10    //URL에 no를 붙여서 보낸다.   
    //요청데이터 : 없음
    //응답데이터:'{"no":401,"title":"이것이 자바다","author":"홍길동","publisher":"한빛미디어"..}'
	@DeleteMapping("/{no}")  //요청으로 오는 번호는 감싸준다 {} 보내던 형식처럼
	public Book delete(@PathVariable(name="no") int no) { //no라는 이름으로값을 가져온다.delete때 사용하는게 pathvariable이다.
		log.info("삭제할 책번호" + no);
		Book deletedBook = bookService.deleteBook(no);
		return deletedBook;
	}
}
