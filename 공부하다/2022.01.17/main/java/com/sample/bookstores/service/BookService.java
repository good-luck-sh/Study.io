package com.sample.bookstores.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.bookstores.mapper.*;
import com.sample.bookstores.vo.Book;
import com.sample.bookstores.web.form.Criteria;

/**
 * 도서 정보에 대한 업무로직이 구현된 클래스다.
 * @author lee_e
 *
 */
@Service
public class BookService {

   @Autowired
   private BookMapper bookMapper;
   
   /**
    * 신규 도서 정보를 등록하는 서비스
    * @param book 신규 도서정보
    * @return 저장된 도서 정보
    */
   public Book insertNewBook(Book book) {
      bookMapper.insertBook(book);
      return bookMapper.getBookByNo(book.getNo());
   }
   
   /**
    * 도서 정보 변경 서비스
    * @param book 변경된 정보를 포함하고 있는 도서 정보
    * @return 변경된 도서정보
    */
   public Book updateBook(Book book) {
      Book savedBook = bookMapper.getBookByNo(book.getNo());
      savedBook.setPrice(book.getPrice());
      savedBook.setDiscountPrice(book.getDiscountPrice());
      savedBook.setStock(savedBook.getStock() + book.getStock());
      bookMapper.updateBook(book);
      
      return savedBook;
   }
   
   /**
    * 도서 정보를 삭제하는 서비스
    * @param no 도서 번호
    * @return 삭제된 도서 정보
    */
   public Book deleteBook(int no) {
      Book book = bookMapper.getBookByNo(no);
      bookMapper.deletedBook(no);
      return book;
   }
   
   /**
    * 도서 상세정보를 제공하는 서비스
    * @param no 도서 번호
    * @return 도서정보
    */
   public Book getBookDetail(int no) {
      return bookMapper.getBookByNo(no);
   }
   
   /**
    * 검색조건과 일치하는 도서 정보를 반환하는 서비스
    * @param criteria 검색조건
    * @return 검색된 도서정보
    */
   public List<Book> getBooks(Criteria criteria) {
      return bookMapper.getAllBook(criteria);
   }
   
   /**
    * 검색조건과 일치하는 도서정보 갯수를 반환하는 서비스
    * @param criteria 검색조건
    * @return 검색된 도서 갯수
    */
   public int getBookCount(Criteria criteria) {
      return bookMapper.getCiriteria(criteria);
   }
}