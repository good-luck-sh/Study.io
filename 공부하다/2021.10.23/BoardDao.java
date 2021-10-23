package example_10_23_board.dao;

import java.sql.SQLException;
import java.util.List;

import example_10_23_board.vo.Board;

public interface BoardDao{
	/**
	 * 게시물을 전체 조회하는 기능이다. 
	 * @return 게시물 전체 기능
	 * @throws SQLException DB Access 예외가 발생시 출력한다. 
	 */
	List<Board> getAllPrint() throws SQLException;
	/**
	 * 게시물을 번호로 입력받아서 상세 정보를 출력하는 기능이다.
	 * @param no 게시물 번호
	 * @return 조회된 게시물
	 * @throws SQLException DB Access 예외가 발생시 출력한다.
	 */
	
	Board getDetailPrintByNo(int no) throws SQLException;
	/**
	 * 게시물을 제목으로 입력받아서 상세 정보를 출력하는 기능이다. 
	 * @param title 게시물 제목
	 * @return 조회된 게시물
	 * @throws SQLException DB Access 예외가 발생시 출력한다.
	 */
	
	List<Board> getDetailPrintByTitle(String title) throws SQLException;
	/**
	 * 게시물을 입력하는 기능이다.
	 * @param title 게시물 제목
	 * @param writer 게시물 작성자
	 * @param content 게시물 내용
	 * @param password 게시물 비밀번호 
	 * @throws SQLException DB Access 예외가 발생시 출력한다.
	 */
	void insertBoard(String title, String writer, String content, int password) throws SQLException;
	/**
	 * 게시물을 수정하는 기능이다.
	 * @param board 게시물 객체
	 * @throws SQLException DB Access 예외가 발생시 출력한다.
	 */
	void updateBoard(Board board) throws SQLException;
	/**
	 * 게시물을 제거하는 기능이다. 
	 * @param no 게시물 번호
	 * @param password 게시물 비밀번호
	 * @throws SQLException DB Access 예외가 발생시 출력한다.
	 */
	void removeBoard(int no, int password) throws SQLException;



}
