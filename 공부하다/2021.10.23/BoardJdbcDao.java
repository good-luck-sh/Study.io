package example_10_23_board.dao;

import static utils.ConnectionUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import example_10_23_board.vo.Board;


public class BoardJdbcDao implements BoardDao {

	@Override
	public List<Board> getAllPrint() throws SQLException {
		 List<Board> boards = new ArrayList<>();
		 String sql ="select board_no, board_title, board_writer, board_content, "
				 	+"board_like_count, board_dislike_count, board_created_date "
				 	+"from tb_sample_boards "
				 	+"order by board_no desc ";
		 Connection connection = getConnection();
		 PreparedStatement ptmt = connection.prepareStatement(sql);
		 ResultSet rs = ptmt.executeQuery();
		 
		 while(rs.next()) {
			 Board borad = new Board();
			 borad.setNo(rs.getInt("board_no"));
			 borad.setTitle(rs.getString("board_title"));
			 borad.setWriter(rs.getString("board_writer"));
			 borad.setContent(rs.getString("board_content"));
			 borad.setLikeCount(rs.getInt("board_like_count"));
			 borad.setDisLikeCount(rs.getInt("board_disLike_count"));
			 borad.setCreatedDate(rs.getDate("board_created_date"));
			 boards.add(borad);
		 }
			 rs.close();
			 ptmt.close();
			 connection.close();
			return boards;
		}

	@Override
	public Board getDetailPrintByNo(int no) throws SQLException {
		 Board board = null;
		 String sql = "select board_no, board_title, board_writer, board_content, "
				 	+"board_like_count, board_disLike_count, board_created_date, board_password "
				 	+"from tb_sample_boards "
				 	+"where board_no = ?"
				 	+"order by board_no desc ";
		 Connection connection = getConnection();
		 PreparedStatement ptmt = connection.prepareStatement(sql);
		 ptmt.setInt(1, no);
		 ResultSet rs = ptmt.executeQuery();
		 if(rs.next()) {
			 board = new Board();
			 board.setNo(rs.getInt("board_no"));
			 board.setTitle(rs.getString("board_title"));
			 board.setWriter(rs.getString("board_writer"));
			 board.setContent(rs.getString("board_content"));
			 board.setLikeCount(rs.getInt("board_like_count"));
			 board.setDisLikeCount(rs.getInt("board_disLike_count"));
			 board.setCreatedDate(rs.getDate("board_created_date"));
			 board.setPassword(rs.getInt("board_password"));
			 
		 } 
			rs.close();
			ptmt.close();
			connection.close();
			return board;
		}

	@Override
	public List<Board> getDetailPrintByTitle(String title) throws SQLException {
		 List<Board> boards = new ArrayList<>();
		 String sql = "select board_no, board_title, board_writer, board_content, "
				 	+"board_like_count, board_disLike_count, board_created_date "
				 	+"from tb_sample_boards "
				 	+"where board_title = '%' || ? || '%' "
				 	+"order by board_no desc ";
		 Connection connection = getConnection();
		 PreparedStatement ptmt = connection.prepareStatement(sql);
		 ptmt.setString(1, title);
		 ResultSet rs = ptmt.executeQuery();
		 if(rs.next()) {
			 Board borad = new Board();
			 borad.setNo(rs.getInt("board_no"));
			 borad.setTitle(rs.getString("board_title"));
			 borad.setWriter(rs.getString("board_writer"));
			 borad.setContent(rs.getString("board_content"));
			 borad.setLikeCount(rs.getInt("board_like_count"));
			 borad.setDisLikeCount(rs.getInt("board_disLike_count"));
			 borad.setCreatedDate(rs.getDate("board_created_date"));
			 boards.add(borad);
		 } 
			rs.close();
			ptmt.close();
			connection.close();
			return boards;
	}

	@Override
	public void insertBoard(String title, String writer, String content, int password) throws SQLException {
		String sql = "insert into tb_sample_boards (board_no, board_title, board_writer, board_content, board_password) "
				+ "values(board_seq.nextval,? ,? ,? ,? ) ";
		
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		
		ptmt.setString(1, title);
		ptmt.setString(2, writer);
		ptmt.setString(3, content);
		ptmt.setInt(4,password);

		ptmt.executeUpdate();
		
		ptmt.close();
		connection.close();
		
	}

	

	@Override
	public void removeBoard(int no, int password) throws SQLException {
		String sql = "delete from tb_sample_boards "
					+ "where board_no = ? and board_password = ? ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		
		ptmt.setInt(1, no);
		ptmt.setInt(2,password);
		
		ptmt.executeUpdate();
		
		ptmt.close();
		connection.close();
		
	}

	@Override
	public void updateBoard(Board board) throws SQLException {
		String sql ="update tb_sample_boards "
					+"set "
					+"board_title = ?, "
					+"board_writer = ?, "
					+"board_content = ?, "
					+"board_like_count = ?, "
					+"board_disLike_count = ? "
					+" where "
					+ " board_no = ? ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setString(1,board.getTitle());
		ptmt.setString(2, board.getWriter());
		ptmt.setString(3, board.getContent());
		ptmt.setInt(4, board.getLikeCount());
		ptmt.setInt(5, board.getDisLikeCount());
		ptmt.setInt(6, board.getNo());

		ptmt.executeUpdate();
		
		ptmt.close();
		connection.close();
	}



	
}
