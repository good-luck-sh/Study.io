package example_10_23_board.service;

import java.sql.SQLException;
import java.util.List;

import example_10_23_board.vo.Board;

public interface BoardService {
	/**
	 * 게시글을 전체 조회하는 기능이다.
	 * @return 게시글 전체 
	 * @throws SQLException DB Access 예외가 발생시 출력한다. 
	 */
	List<Board> getAllPrint() throws SQLException;
	/**
	 * 게시글을 제목으로 입력 받아서 상세 정보를 출력하고 좋아요, 싫어요를 입력하는 부분이다. 
	 * @param title 게시물 제목
	 * @param likeCount 좋아요
	 * @param disLikeCount 싫어요 
	 * @return 조회된 게시물
	 * @throws SQLExceptionDB Access 예외가 발생시 출력한다
	 */
	List<Board> getDetatilPrintByTitle(String title,int likeCount, int disLikeCount) throws SQLException;
	/**
	 * 게시글을 번호로 입력받아서 상세 정보를 출력하고 좋아요, 싫어요를 입력하는 부분이다.
	 * @param no 게시물 번호
	 * @param likeCount  좋아요
	 * @param disLikeCount  싫어요
	 * @return 조회된 게시물
	 * @throws SQLException
	 */
	Board getDetatilPrintByNo(int no,int likeCount, int disLikeCount) throws SQLException;
	/**
	 * 게시글을 추가하는 기능이다. 
	 * @param title 게시물 제목
	 * @param writer 게시물 글쓴이
	 * @param content 게시물 내용
	 * @param password 게시물 비밀번호 
	 * @throws SQLException DB Access 예외가 발생시 출력한다
	 */
	
	void addBord(String title, String writer, String content, int password) throws SQLException;
	/**
	 * 게시물을 수정하는 기능이다.
	 * @param no 게시물 번호
	 * @param title 게시물 제목
	 * @param content 게시물 내용
	 * @param password 게시물 비밀번호 
	 * @throws SQLException DB Access 예외가 발생시 출력한다
	 */
	void reviseBoard(int no, String title, String content, int password) throws SQLException;
	/**
	 * 게시물을 지우는 기능이다. 
	 * @param no 게시물 번호
	 * @param password 게시물 비밀번호 
	 * @throws SQLException Access 예외가 발생시 출력한다
	 */
	void removeBoard(int no, int password) throws SQLException;
	/**
	 * 게시물의 좋아요, 싫어요를 입력받고 수정하는 기능이다.
	 * @param likeCount 좋아요 갯수
	 * @param disLikeCount 싫어요 갯수 
	 * @throws SQLException DB Access 예외가 발생시 출력한다
	 */
	
	void goodOrBadCount(int no, int likeCount, int disLikeCount) throws SQLException;
	
	
	
	
	 
	
}
