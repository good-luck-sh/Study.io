package com.sample.dao;

import static com.sample.utils.ConnectionUtils.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.vo.Board;

import oracle.jdbc.proxy.annotation.Pre;

public class BoardDao {
	/**
	 * 입력받은 board의 객체를 테이블에 저장한다.
	 * @param board 저장할 객체
	 * @throws SQLException 데이터 베이스 엑세스 작업중 오류가 발생했을 때
	 */
	public void insertBoard(Board board) throws SQLException {
		String sql = "insert into tb_web_board (board_no, board_title, board_writer, board_view_count, board_like_count, board_content, board_deleted, board_created_date ) "
				+ "values(web_board_seq.nextval, ?, ?, ?, ?, ?, ?, sysdate ) ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setString(1, board.getBoradTitle());
		ptmt.setString(2, board.getBoardWrite());
		ptmt.setInt(3, board.getBoradView());
		ptmt.setInt(4, board.getBoardLike());
		ptmt.setString(5, board.getBoardContent());
		ptmt.setString(6, board.getBoardDelete());
		
		ptmt.executeUpdate();
		
		ptmt.close();
		connection.close();
		
	}
	/**
	 * 입력받은 board의 번호에 해당하는 객체를 삭제한다.
	 * @param boardNo 해당하는 board의 번호
	 * @throws SQLException 데이터 베이스 엑세스 작업중 오류가 발생했을 때
	 */
	public void deleteBoard(int boardNo) throws SQLException {
		String sql = "delete from tb_web_board "
				+ "where board_no = ? ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1, boardNo);
		ptmt.executeUpdate();
		
		ptmt.close();
		connection.close();
		
	}
	/**
	 * 저장된 board를 전체 출력한다. 
	 * @return 저장된 board의 전체적인 정보
	 * @throws SQLException 데이터 베이스 엑세스 작업중 오류가 발생했을 때
	 */
	public List<Board> getAllWebBoard() throws SQLException {
		String sql = "select board_no, board_title, board_writer, board_view_count, board_like_count, board_content, board_deleted, board_created_date "
				+ "from tb_web_board ";
		List<Board> boards = new ArrayList<Board>();
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()) {
			Board board = new Board();
			board.setBoardNo(rs.getInt("board_no"));
			board.setBoradTitle(rs.getString("board_title"));
			board.setBoardWrite(rs.getString("board_writer"));
			board.setBoradView(rs.getInt("board_view_count"));
			board.setBoardLike(rs.getInt("board_like_count"));
			board.setBoardContent(rs.getString("board_content"));
			board.setBoardDelete(rs.getString("board_deleted"));
			board.setBoardCreatedDate(rs.getDate("board_created_date"));
			boards.add(board);
		}
		rs.close();
		ptmt.close();
		connection.close();
		return boards;
}
	/**
	 * board에 저장된 테이블의 값을 출력한다.
	 * @return 저장된 테이블의 값
	 * @throws SQLException 데이터 베이스 엑세스 작업중 오류가 발생했을 때
	 */
	public int getAllCountBoard() throws SQLException {
		int countNumber = 0;
		String sql = "select count(*) cnt "
				+ "from tb_web_board ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery();
		
		rs.next();
		countNumber = rs.getInt("cnt");
		
		rs.close();
		ptmt.close();
		connection.close();
		return countNumber;
	}
	/**
	 * 수정할 board의 정보를 입력받아서 테이블의 내용을 수정한다. 
	 * @param board 수정할 정보
	 * @throws SQLException 데이터 베이스 엑세스 작업중 오류가 발생했을 때
	 */
	public void updateBoard (Board board) throws SQLException {
		String sql = "update tb_web_board "
				+ " set "
				+ " board_title = ? , "
				+ " board_writer = ?, "
				+ " board_view_count = ?, "
				+ " board_like_count = ?, "
				+ " board_content = ?, "
				+ " board_deleted = ? "
				+ " where board_no = ? ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setString(1, board.getBoradTitle());
		ptmt.setString(2, board.getBoardWrite());
		ptmt.setInt(3,board.getBoradView());
		ptmt.setInt(4,board.getBoardLike());
		ptmt.setString(5,board.getBoardContent());
		ptmt.setString(6,board.getBoardDelete());
		ptmt.setInt(7,board.getBoardNo());
		ptmt.executeUpdate();
		ptmt.close();
		connection.close();				
	}
	/**
	 * 시작과 끝을 나타내는 숫자를 입력받아서 해당하는 게시글을 출력한다. 
	 * @param begin 출력할 시작 번호
	 * @param end 마지막으로 출력할 끝 번호 
	 * @return 해당하는 게시글
	 * @throws SQLException 데이터 베이스 엑세스 작업중 오류가 발생했을 때
	 */
	public List<Board> getAllWebBoard(int begin, int end) throws SQLException {
		String sql = "select RS, board_no, board_title, board_writer, board_view_count, board_like_count, board_content, board_deleted, board_created_date "
				+ "from ((select row_number()over (order by board_no desc) RS,"
				+ "board_no, board_title, board_writer, board_view_count, board_like_count, board_content, board_deleted, board_created_date "
				+ " from tb_web_board)) "
				+ "where RS >= ? and RS <= ? ";
		List<Board> boards = new ArrayList<Board>();
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1, begin);
		ptmt.setInt(2, end);
		
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()) {
			Board board = new Board();
			board.setBoardNo(rs.getInt("board_no"));
			board.setBoradTitle(rs.getString("board_title"));
			board.setBoardWrite(rs.getString("board_writer"));
			board.setBoradView(rs.getInt("board_view_count"));
			board.setBoardLike(rs.getInt("board_like_count"));
			board.setBoardContent(rs.getString("board_content"));
			board.setBoardDelete(rs.getString("board_deleted"));
			board.setBoardCreatedDate(rs.getDate("board_created_date"));
			boards.add(board);
		}
		rs.close();
		ptmt.close();
		connection.close();
		return boards;
		
}
	/**
	 * 게시물의 번호를 입력받아서 해당하는 게시물의 전체 정보를 출력한다. 
	 * @param boardNo 출력할 게시물의 번호 
	 * @return 해당하는 게시물의 전체 정보 
	 * @throws SQLException  데이터 베이스 엑세스 작업중 오류가 발생했을 때
	 */
	 public Board getAllWebBoardByNo(int boardNo) throws SQLException {
		 Board board = null;
			 String sql = "select board_no, board_title, board_writer, board_view_count, board_like_count, board_content, board_deleted, board_created_date "
			 		+ "from tb_web_board "
			 		+ "where board_no = ? ";
		 Connection connection = getConnection();
		 PreparedStatement ptmt = connection.prepareStatement(sql);
		 ptmt.setInt(1, boardNo);
		 ResultSet rs = ptmt.executeQuery();
		 if(rs.next()) {
			 board = new Board();
			 board.setBoardNo(rs.getInt("board_no"));
			 board.setBoradTitle(rs.getString("board_title"));
			 board.setBoardWrite(rs.getString("board_writer"));
			 board.setBoradView(rs.getInt("board_view_count"));
			 board.setBoardLike(rs.getInt("board_like_count"));
			 board.setBoardContent(rs.getString("board_content"));
			 board.setBoardDelete(rs.getString("board_deleted"));
			 board.setBoardCreatedDate(rs.getDate("board_created_date"));
		 }
		 rs.close();
		 ptmt.close();
		 connection.close();
		 return board;
	 }
}
