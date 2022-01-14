package com.sample.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.bookstore.mapper.BookMapper;
import com.sample.bookstore.vo.Book;

@Service
public class BookService {

	@Autowired
	private BookMapper bookmapper;
	
	public Book insertNewBook(Book book) {
		bookmapper.insertBook(book);
		return bookmapper.getBookByNo(book.getNo());//insert한 책정보를 리턴한다. 
	}
	public Book updateBook(Book book) {
		Book saveBook = bookmapper.getBookByNo(book.getNo());
		saveBook.setPrice(book.getPrice());
		saveBook.setDiscountPrice(book.getDiscountPrice());
		saveBook.setStock(saveBook.getStock() + book.getStock());
		bookmapper.updateBook(book);
		return saveBook;
	}
	public Book deleteBook(int no) {
		Book savebook = bookmapper.getBookByNo(no);
		bookmapper.deleteBook(no);
		return savebook;
	}
	public Book getBookDetail(int no) {
		return bookmapper.getBookByNo(no);
	}
	public List<Book> getAllBooks(){
		return bookmapper.getAllBooks();
	}
}
