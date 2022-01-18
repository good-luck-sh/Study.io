package com.sample.bookstores.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.bookstores.dto.Pagination;
import com.sample.bookstores.service.BookService;
import com.sample.bookstores.vo.Book;
import com.sample.bookstores.web.form.BookForm;
import com.sample.bookstores.web.form.Criteria;
import com.sample.bookstores.web.model.ResponseService;
import com.sample.bookstores.web.model.SingleResponseData;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
public class BookController {

	/**
	 * 도서정보를 제공하는 서비스 객체를 주입받는다.
	 */
	@Autowired
	private BookService bookService;
	/**
	 * 다양한 응답메세지를 제공하는 서비스 객체를 주입받는다.
	 */
	@Autowired
	private ResponseService responseService;
	// 요청방식 : POST
    // 요청URL : http://localhost/api/book
    // 요청데이터 : '{"title":"이것이 자바다", "author":"홍길동", "publisher":"한빛미디어", "pubDate":"2022-01-14", "price":35000, "discountPrice":32000, "stock":10}'
    // 응답데이터 : {success:true, message:null, item:{no:100, "title":"이것이 자바다", "author":"홍길동",... }}
   @PostMapping("/api/book")
   public SingleResponseData<Book> save(@RequestBody BookForm form) {
      log.info("폼 입력값: " + form);
      
      Book book = Book.builder()
            .title(form.getTitle())
            .author(form.getAuthor())
            .publisher(form.getPublisher())
            .pubDate(form.getPubDate())
            .price(form.getPrice())
            .discountPrice(form.getDiscountPrice())
            .stock(form.getStock())
            .build();
      
      Book savedBook = bookService.insertNewBook(book);
      
      return responseService.getResponseData(savedBook);
   }
	
	// 요청방식 : GET
    // 요청URL  : http://localhost/api/book
    // 요청데이터 : 없음
    // 응답데이터 : {success:true, message:null, items:[{"no":1, "tile":"자바연습", "author":"홍길동", "publisher":"한빛미디어", ...}, {"no":1, "tile":"자바연습", "author":"홍길동", "publisher":"한빛미디어", ...}, ...]}
   @GetMapping("/api/book")
   public SingleResponseData<Map<String, Object>> books(Criteria criteria) { //page가 없으면 0으로 나간다.
      if (criteria.getPage() < 1) { //1보다 작을 경우
         criteria.setPage(1); //1로 설정한다.
      }
      if (!StringUtils.hasText(criteria.getOpt()) || !StringUtils.hasText(criteria.getValue()) ) { //opt에 글자값이 없으면 
         criteria.setOpt(null); //null로 설정한다.
      }
      //if (!StringUtils.hasText(criteria.getValue())) { //value가 값이 없으면
     //    criteria.setValue(null); //null을 입력한다.
     // } //값이 null이여야지 검색을 할 수 있다.
      int bookCount = bookService.getBookCount(criteria);
      Pagination pagination = new Pagination(criteria.getPage(), bookCount);
      
      criteria.setBeginIndex(pagination.getBegin());
      criteria.setEndIndex(pagination.getEnd());
      log.info("리스트 검색조건: " + criteria);
      List<Book> books = bookService.getBooks(criteria);
 
      return responseService.getResponseData(Map.of("pagination", pagination, "books", books));
   }
   // 요청방식 : GET
   // 요청URL : http://localhost/api/book/100
   // 요청데이터 : 없음
   // 응답데이터 : {success:true, message:null, item:{"no":1, "tile":"자바연습", "author":"홍길동", "publisher":"한빛미디어", ...}}
   @GetMapping("/api/book/{no}")
   public SingleResponseData<Book> detail(@PathVariable(name = "no") int no) {
      log.info("조회할 책번호: " + no);
      Book book = bookService.getBookDetail(no);

      return responseService.getResponseData(book);
   }

   // 요청방식 : DELETE
    // 요청URL  : http://localhost/api/book/10
    // 요청데이터 : 없음
    // 응답데이터 : {"success":true, message:null, item:{no:100, "title":"이것이 자바다", "author":"홍길동",... } }
   @DeleteMapping("/api/book/{no}")
   public SingleResponseData<Book> delete(@PathVariable(name = "no") int no) {
      log.info("삭제할 책번호: " + no);
      Book deletedBook = bookService.deleteBook(no);

      return responseService.getResponseData(deletedBook);
   }
}
