package com.sample.board.dao;

import static utils.ConnectionUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.board.dto.BoardDetailDto;
import com.sample.board.dto.BoardLikerListDto;
import com.sample.board.dto.BoardListDto;
import com.sample.board.vo.Board;

public class BoardDao {
	
	private static BoardDao self = new BoardDao();
	private BoardDao() {}
	public static BoardDao getInstance() {
		return self;
	}

	/**
	 * 지정된 게시글 정보를 테이블에 저장한다.
	 * @param board 게시글 정보
	 * @throws SQLException
	 */
	public void insertBoard(Board board) throws SQLException {
		String sql = "insert into tb_comm_boards (board_no, board_title, board_writer_no, board_content) "
				   + "values (comm_board_seq.nextval, ?, ?, ?)";
		
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, board.getTitle());
		pstmt.setInt(2, board.getWriterNo());
		pstmt.setString(3, board.getContent());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public void updateBoard(Board board) throws SQLException {
		String sql = "update tb_comm_boards "
				   + "set "
				   + "	board_title = ?, "
				   + "	board_content = ?, "
				   + "	board_like_count = ?, "
				   + "	board_view_count = ?, "
				   + "	board_deleted = ?, "
				   + "	board_updated_date = sysdate "
				   + "where board_no = ? ";
		
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getContent());
		pstmt.setInt(3, board.getLikeCount());
		pstmt.setInt(4, board.getViewCount());
		pstmt.setString(5, board.getDeleted());
		pstmt.setInt(6, board.getNo());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public int getTotalRecords() throws SQLException {
		String sql = "select count(*) cnt from tb_comm_boards";
		int totalRecords = 0;
		
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		totalRecords = rs.getInt("cnt");
		rs.close();
		pstmt.close();
		connection.close();
		
		return totalRecords;
	}
	
	public List<BoardListDto> getBoardList(int begin, int end) throws SQLException {
		String sql = "select board_no, board_title, user_name, board_content, board_view_count, board_like_count, board_created_date "
				   + "from (select row_number() over (order by B.board_no desc) rn, "
				   + "             B.board_no, B.board_title, U.user_name, B.board_content, "
				   + "             B.board_view_count, B.board_like_count, B.board_created_date "
				   + "      from tb_comm_boards B, tb_comm_users U "
				   + "      where B.board_writer_no = U.user_no) "
				   + "where rn >= ? and rn <= ? ";
		List<BoardListDto> boardListDtos = new ArrayList<>();
		
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, begin);
		pstmt.setInt(2, end);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			BoardListDto dto = new BoardListDto();
			dto.setNo(rs.getInt("board_no"));
			dto.setTitle(rs.getString("board_title"));
			dto.setWriter(rs.getString("user_name"));
			dto.setContent(rs.getString("board_content"));
			dto.setLikeCount(rs.getInt("board_like_count"));
			dto.setViewCount(rs.getInt("board_view_count"));
			dto.setCreatedDate(rs.getDate("board_created_date"));
			
			boardListDtos.add(dto);
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return boardListDtos;
	}
	
	public BoardDetailDto getBoardDetail(int no) throws SQLException {
		String sql = "select B.board_no, B.board_title, U.user_no, U.user_name, B.board_content, "
				   + "       B.board_view_count, B.board_like_count, B.board_deleted, "
				   + "		 B.board_deleted_date, B.board_updated_date, B.board_created_date "
				   + "      from tb_comm_boards B, tb_comm_users U "
				   + "      where B.board_writer_no = U.user_no "
				   + "	    and B.board_no = ? ";
		BoardDetailDto dto = null;
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			dto = new BoardDetailDto();
			dto.setNo(rs.getInt("board_no"));
			dto.setTitle(rs.getString("board_title"));
			dto.setWriterNo(rs.getInt("user_no"));
			dto.setWriterName(rs.getString("user_name"));
			dto.setContent(rs.getString("board_content"));
			dto.setLikeCount(rs.getInt("board_like_count"));
			dto.setViewCount(rs.getInt("board_view_count"));
			dto.setDeleted(rs.getString("board_deleted"));
			dto.setDeletedDate(rs.getDate("board_deleted_date"));
			dto.setUpdatedDate(rs.getDate("board_updated_date"));
			dto.setCreatedDate(rs.getDate("board_created_date"));
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return dto;
	}
	
	public List<BoardLikerListDto> getBoardLikerList(int boardNo) throws SQLException {
		String sql = "select user_no, user_id, user_name "
				   + "from tb_comm_board_like_users L, tb_comm_users U "
				   + "where L.user_no = U.user_no "
				   + "and L.board_no = ? ";
		
		List<BoardLikerListDto> boardLikerListDtos = new ArrayList<>();
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, boardNo);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			BoardLikerListDto dto = new BoardLikerListDto();
			dto.setUserNo(rs.getInt("user_no"));
			dto.setUserId(rs.getString("user_id"));
			dto.setUserName(rs.getString("user_name"));
			
			boardLikerListDtos.add(dto);
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return boardLikerListDtos;
	}
}










