package com.example.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mapper.BookMapper;
import com.example.vo.Book;
import com.example.web.form.BookForm;
import com.example.web.response.ListResponseData;
import com.example.web.response.ResponseData;
import com.example.web.response.ResponseService;
import com.example.web.response.SingleResponseData;

@CrossOrigin(origins = "*")
@RestController
public class BookController {
	
	@Autowired
	BookMapper bookMapper;
	
	@Autowired
	ResponseService responseService;

	@PostMapping("/books")
	public ResponseData insert(@RequestBody BookForm form) {
		Book book = Book.builder()
				.title(form.getTitle())
				.author(form.getAuthor())
				.publisher(form.getPublisher())
				.description(form.getDescription())
				.price(form.getPrice())
				.discountPrice(form.getDiscountPrice())
				.stock(form.getAmount())
				.build();
		bookMapper.insertBook(book);
		
		return responseService.getSuccessResponse();
	}
	
	@GetMapping("/books")
	public ListResponseData<Book> books() {
		List<Book> books = bookMapper.getBooks();
		
		return responseService.getResponseData(books);
	}
	
	@GetMapping("/books/{no}")
	public SingleResponseData<Book> book(@PathVariable(name = "no") int no) {
		Book book = bookMapper.getBooByNo(no);
		
		return responseService.getResponseData(book);
	}
	
	@DeleteMapping("/books/{no}")
	public ResponseData delete(@PathVariable(name = "no") int no) {
		bookMapper.deleteBook(no);
		
		return responseService.getSuccessResponse();
	}
	
	@PutMapping("/books/{no}")
	public ResponseData update(@PathVariable(name = "no") int no, BookForm form) {
		Book book = bookMapper.getBooByNo(no);
		book.setTitle(form.getTitle());
		book.setAuthor(form.getAuthor());
		book.setPublisher(form.getPublisher());
		book.setDescription(form.getDescription());
		book.setPrice(form.getPrice());
		book.setDiscountPrice(form.getDiscountPrice());
		book.setStock(book.getStock() + form.getAmount());
		
		bookMapper.updateBook(book);
		
		return responseService.getSuccessResponse();
	}
}
