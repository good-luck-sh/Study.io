package com.sample.controller;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.form.BookInsertForm;
import com.sample.form.Criteria;
import com.sample.pagination.Pagination;
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
	 * 요청파라미터 : page, opt, value, sort, rows, ..여러가지 요소가 올 수 있다.
	 * 이동할 뷰페이지 : /WEB-INF/jsp/book/list.jsp
	 * 뷰페이지에 전달되는 데이터 : List<Book>
	 * 
	 * @RequestParam(name ="요청파라미터이름", required=필수요청파라미터 여부, defaultValue = "기본값");
	 * 			name : 요청파라미터의 이름이다. 
	 * 			required : 필수요청파라미터인지 여부, true/false 값만 가능. 기본값은 true다.
	 * 					* @RequestParam 설정없이 사용한 요청 파라미터용 매개변수는 전부 required가 true상태이다.
	 * 			defaultValue : required가 false로 설정되어있고, name에서 지정한 이름의 요청파라미터가 존재하지 않을 때 변수에 대입한 기본값이다. 
	 */
	@GetMapping("/list.do")
	public String list(@RequestParam(name = "page", defaultValue = "1", required = false) String page,
			Criteria criteria ,Model model) {
		//criteria에 검색조건이 null일수도 아닐 수 도있다. 검색조건에 따라서 어디서 결과를 출력할지 정해진다. 
		logger.debug("요청페이지 번호 :" + page);
		logger.info("검색 조건 및 값 : " + criteria);
		// 검색조건에 해당하는 총 데이터 갯수 조회
		int totalRecords = bookService.getTotalRows(criteria);
		//그래서 책의 조건의 총갯수를 찾을 때에도 opt&value의 값을 찾으러 들어간다. 
		// 현재 페이지 번호와 총 데이터 갯수를 전달해서 페이징 처리에 필요한 정보를 제공하는 pagination객체를 생성한다. 
		Pagination pagination = new Pagination(page, totalRecords);
		
		//요청한 페이지에 대한 조회범위를 criteria에 저장
		criteria.setBeginIndex(pagination.getBegin());
		criteria.setEndIndex(pagination.getEnd());
		//검색조건(opt, value)와 조회범위(beginIndex, endIndex)가 포함된 criteria를 서비스에 전달해서 데이터 조회
		List<Book> books = bookService.searchBook(criteria);
		
		model.addAttribute("books",books);
		model.addAttribute("pagination", pagination);
		
		return "book/list.jsp";
	}
	@GetMapping("/delete.do")
	public String delete(int no) {
		bookService.deleteBook(no);
		return "redirect:list.do";
	}
	
}
