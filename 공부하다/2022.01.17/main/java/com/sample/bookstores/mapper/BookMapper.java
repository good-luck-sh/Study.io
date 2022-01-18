package com.sample.bookstores.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sample.bookstores.vo.Book;
import com.sample.bookstores.web.form.Criteria;

/**
 * 도서 정보에 대한 CRUD 작업이 정의된 인터페이스이다.
 * @author 김승희
 *
 */
@Mapper
public interface BookMapper {
	
	/**
	 * 신규 책정보를 전달받아서 테이블에 추가한다.
	 * @param book 책정보
	 */
	void insertBook(Book book);
	/**
	 * 변경된 책정보를 전달받아서 테이블에 반영한다.
	 * @param book 책정보
	 */
	void updateBook(Book book);
	/**
	 * 책번호를 전달받아서 책정보를 삭제한다.
	 * @param no
	 */
	void deletedBook(int no);
	/**
	 * 검색조건을 전달받아서 검색된 책정보를 반환한다.
	 * @return 책점보
	 */
	List<Book> getAllBook(Criteria criteria);
	/**
	 * 검색조건을 전달받아서 조건에 맞는 데이터 갯수를 반환한다.
	 * @param criteria
	 * @return
	 */
	int getCiriteria(Criteria criteria);
	/**
	 * 책번호를 전달받아서 해당하는 책정보를 반환한다.
	 * @param no
	 * @return
	 */
	Book getBookByNo(int no);
}
