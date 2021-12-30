package com.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.service.BookService;
import com.sample.vo.Book;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookService bookService;
	/*
	 * 요청 방식 : GET
	 * 요청 URL : /book/list.do
	 * 이동할 뷰페이지 : /WEB-INF/jsp/book/list.jsp
	 * 뷰페이지에 전달되는 데이터 : List<Book>
	 */
	@GetMapping("/list.do")
	public String list(Model model) {
		List<Book> books = bookService.getAllBookList();
		model.addAttribute("books",books);
		return "book/list.jsp";
	}
	
}
