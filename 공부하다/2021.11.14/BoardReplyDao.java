package com.sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.sample.utils.ConnectionUtils.getConnection;

import com.sample.vo.Board;
import com.sample.vo.BoardReply;

public class BoardReplyDao {
	/**
	 * 입력받은 댓글 객체를 테이블에 저장한다. 
	 * @param boardReply 입력받은 댓글 객체 
	 * @throws SQLException  데이터 베이스 엑세스 작업중 오류가 발생했을 때
	 */
	public void insertBoardReply(BoardReply boardReply) throws SQLException {
		String sql = "insert into tb_web_board_reply"
				+ "(reply_no, reply_writer, reply_content,reply_created_date, board_no ) "
				+ "values (web_reply_seq.nextval , ?, ?, sysdate, ? ) ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setString(1, boardReply.getReplayWriter());
		ptmt.setString(2, boardReply.getReplayContent() );
		ptmt.setInt(3, boardReply.getBoard().getBoardNo());
	
		ptmt.executeUpdate();
		
		ptmt.close();
		connection.close();
	}
	/**
	 * 해당하는 board의 번호의 댓글을 전부 출력한다. 
	 * @param boardId 해당하는 게시글
	 * @return 해당하는 게시글의 댓글
	 * @throws SQLException  데이터 베이스 엑세스 작업중 오류가 발생했을 때
	 */
	public List<BoardReply> getAllReply (int boardId) throws SQLException {
		System.out.println(boardId);
		List<BoardReply> replys = new ArrayList<BoardReply>();
		String sql = "select reply_no, reply_writer, reply_content, reply_created_date, board_no "
				+ "from tb_web_board_reply "
				+ "where board_no = ? ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1, boardId);
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()) {
			BoardReply reply = new BoardReply();
			reply.setReplayNo(rs.getInt("reply_no"));
			reply.setReplayWriter(rs.getString("reply_writer"));
			reply.setReplayContent(rs.getString("reply_content"));
			reply.setReplayCreatedDate(rs.getDate("reply_created_date"));
			Board board = new Board();
			board.setBoardNo(rs.getInt("board_no"));			
			reply.setBoard(board);			
			replys.add(reply);
			System.out.println(reply);
		}
	
		rs.close();
		ptmt.close();
		connection.close();
		return replys;
				
	}
	/**
	 * 댓글의 번호를 입력받아서 해당하는 댓글을 삭제한다. 
	 * @param replyNo 삭제할 댓글 번호 
	 * @throws SQLException 데이터 베이스 엑세스 작업중 오류가 발생했을 때
	 */
	public void deleteReply(int replyNo) throws SQLException {
		String sql = "delete from tb_web_board_reply "
				+ " where reply_no = ? ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1, replyNo);
		ptmt.executeUpdate();
		
		ptmt.close();
		connection.close();
	}
	/**
	 * 해당하는 게시물의 번호를 입력받아서 게시글에 작성한 댓글을 조회한다. 
	 * @param boardNo 댓글을 조회할 버노
	 * @return
	 * @throws SQLException
	 */
	public List<BoardReply> getAllBoardReply(int boardNo) throws SQLException {
		List<BoardReply> boardreplys = new ArrayList<>();
		String sql = "select W.board_no, W.board_title, W.board_view_counT, W.board_like_count, W.board_content, "
				+ " W.board_deleted, W.board_created_date, R.reply_no, R.reply_writer, R.reply_content, R.reply_created_date "
				+ " FROM tb_web_board W, tb_web_board_reply R "
				+ " where W.board_no = ? "
				+ " and W.board_no = R.board_no ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1, boardNo);
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()) {
			BoardReply boardreply = new BoardReply();
			Board board = new Board();
			boardreply.setReplayNo(rs.getInt("reply_no"));
			boardreply.setReplayWriter(rs.getString("reply_writer"));
			boardreply.setReplayContent(rs.getString("reply_content"));
			boardreply.setReplayCreatedDate(rs.getDate("reply_created_date"));
			board.setBoardNo(rs.getInt("board_no"));
			board.setBoradTitle(rs.getString("board_title"));
			board.setBoradView(rs.getInt("board_view_count"));
			board.setBoardLike(rs.getInt("board_like_count"));
			board.setBoardContent(rs.getString("board_content"));
			board.setBoardDelete(rs.getString("board_deleted"));
			board.setBoardCreatedDate(rs.getDate("board_created_date"));
			boardreply.setBoard(board);
			boardreplys.add(boardreply);

		}
		rs.close();
		ptmt.close();
		connection.close();
		return boardreplys;
	}
}
