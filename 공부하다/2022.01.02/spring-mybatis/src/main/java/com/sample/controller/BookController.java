package com.sample.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.form.BookInsertForm;
import com.sample.service.BookService;
import com.sample.vo.Book;

@Controller
@RequestMapping("/book")
public class BookController {
	
	static final Logger logger = LogManager.getLogger(BookController.class);

	@Autowired
	BookService bookService;
	
	@GetMapping("/insert.do")
	public String form() {
		return "book/form.jsp";
	}
	@PostMapping("/insert.do")
	public String save(BookInsertForm form) {
		Book book = new Book();
		BeanUtils.copyProperties(form, book);
		//폼에 있는 모든 프라퍼티의 값을 전부 복사하고 보낸준다. 
		bookService.addNewBook(book);
		return "redirect:list.do";
	}
	/*
	 * 요청 방식 : GET
	 * 요청 URL : /book/detail.do
	 * 요청 파라미터 : no
	 * 이동할 뷰페이지 : /WEB-INF/jsp/book/detail.jsp
	 * 뷰페이지에 전달되는 데이터 : Book
	 */
	@GetMapping("/detail.do")
	public String detail(int no, Model model) {
		Book book = bookService.getBookDetail(no);
		model.addAttribute("book",book);
		return "book/detail.jsp";
	}
	/*
	 * 요청 방식 : GET
	 * 요청 URL : /book/modify.do
	 * * 요청 파라미터 : no
	 * 이동할 뷰페이지 : /WEB-INF/jsp/book/modifyform.jsp
	 * 뷰페이지에 전달되는 데이터 : Book
	 */
	@GetMapping("/modify.do")
	public String modify(int no, Model model) {
		Book book = bookService.getBookDetail(no);
		model.addAttribute("book",book);
		return "book/modifyform.jsp";
	}
	/*
	 * 요청 방식 : POST
	 * 요청 URL : /book/updatePrice.do
	 * * 요청 파라미터 : no , discountPrice, price
	 * 이동할 뷰페이지 : /WEB-INF/jsp/book/detail.jsp
	 * 뷰페이지에 전달되는 데이터 : Book
	 */
	@GetMapping("/updatePrice.do")
	public String updatePrice(int price, int discountPrice, int no) {
		bookService.updateBookPrice(no, price, discountPrice);
		return "redirect:detail.do?no="+no;
	}
	/*
	 * 요청 방식 : POST
	 * 요청 URL : /book/updateStock.do
	 * * 요청 파라미터 : no ,stock
	 * 이동할 뷰페이지 : /WEB-INF/jsp/book/detail.jsp
	 * 뷰페이지에 전달되는 데이터 : Book
	 */
	@GetMapping("/updateStock.do")
	public String updateStock(int no, int stock) {
		bookService.updateBookStock(no, stock);
		return "redirect:detail.do?no="+no;
	}
	//길이가 너무길어지면 매개변수에 RedirextAttributes를 작성해서 addAttribute메소드를 사용해서 전송할 수 있다. return은 "redirect:detail.do"으로 작성할 수 있다.
	/*
	 * 요청 방식 : GET
	 * 요청 URL : /book/list.do
	 * 이동할 뷰페이지 : /WEB-INF/jsp/book/list.jsp
	 * 뷰페이지에 전달되는 데이터 : List<Book>
	 */
	@GetMapping("/list.do")
	public String list(Model model) {
		logger.debug("전체 도서 목록 조회 시작");
		List<Book> books = bookService.getAllBookList();
		logger.info("조회된 도서 목록 갯수 :" + books);
		model.addAttribute("books",books);
		logger.debug("전달할 도서 목록 조회");
		return "book/list.jsp";
	}
	@GetMapping("/delete.do")
	public String delete(int no) {
		bookService.deleteBook(no);
		return "redirect:list.do";
	}
	
}
