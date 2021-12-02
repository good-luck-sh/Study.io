package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.utils.ConnectionUtil;
import com.example.vo.Board;
import com.example.vo.Criteria;

public class BoardDao {

	private static BoardDao self = new BoardDao();
	private BoardDao() {}
	public static BoardDao getInstance() {
		return self;
	}

	/**
	 * 게시글 정보를 전달받아서 테이블에 저장한다.
	 * @param board 게시글 정보
	 * @throws SQLException
	 */
	public void insertBoard(Board board) throws SQLException {
		String sql = "insert into sample_search_boards "
				+ "(board_id, board_title, board_writer, board_content, board_deleted, board_created_date) "
				+ "values "
				+ "(sample_search_boards_seq.nextval, ?, ?, ?, 'N', sysdate) ";

		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getWriter());
		pstmt.setString(3, board.getContent());

		pstmt.executeUpdate();

		pstmt.close();
		connection.close();
	}

	/**
	 * 변경된 게시글 정보를 전달받아서 테이블에 반영한다.
	 * @param board 게시글 정보
	 * @throws SQLException
	 */
	public void updateBoard(Board board) throws SQLException {
		String sql = "update sample_search_boards "
				+ "set "
				+ "  board_title = ?, "
				+ "  board_content = ?, "
				+ "  board_view_count = ?, "
				+ "  board_deleted = ?, "
				+ "  board_updated_date = ? "
				+ "where board_id = ?";

		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getContent());
		pstmt.setInt(3, board.getViewCount());
		pstmt.setString(4, board.getDeleted());
		pstmt.setDate(5, new java.sql.Date(board.getUpdatedDate().getTime()));
		pstmt.setLong(6, board.getId());

		pstmt.executeUpdate();

		pstmt.close();
		connection.close();
	}

	/**
	 * 검색 조건에 해당하는 총 게시글의 갯수를 반환한다.
	 * @param criteria 검색조건
	 * @return 총 게시글 갯수
	 * @throws SQLException
	 */
	public int getTotalRows(Criteria criteria) throws SQLException {
		int totalRows = 0;
		String sql = "select count(*) cnt "
				+ "   from sample_search_boards "
				+ "   where board_deleted = 'N' ";
		if ("title".equals(criteria.getOption())) {
			sql += "  and board_title like '%' || ? || '%' ";
		} else if ("writer".equals(criteria.getOption())) {
			sql += "  and board_writer = ? ";
		} else if ("content".equals(criteria.getOption())) {
			sql += "  and board_content like '%' || ? || '%' ";
		}
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		if (criteria.getOption() != null) {
			pstmt.setString(1, criteria.getKeyword());
		} 
		
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		totalRows = rs.getInt("cnt");
		
		rs.close();
		pstmt.close();
		connection.close();

		return totalRows;
	}

	/**
	 * 검색조건에 해당하는 게시글 목록을 반환한다.
	 * @param criteria 검색조건
	 * @return 게시글 목록
	 * @throws SQLException
	 */
	public List<Board>  getBoardList(Criteria criteria) throws SQLException {
		List<Board> boardList = new ArrayList<>();
		
		String sql = "select board_id, board_title, board_writer, board_content, board_view_count, "
				+ "			 board_deleted, board_updated_date, board_created_date "
				+ "   from ("
				+ "         select row_number() over (order by board_id desc) rn, "
				+ "                board_id, board_title, board_writer, board_content, board_view_count, "
				+ "                board_deleted, board_updated_date, board_created_date "
				+ "         from sample_search_boards "
				+ "         where board_deleted = 'N'";
		if ("title".equals(criteria.getOption())) {
			sql += "        and board_title like '%' || ? || '%' ";
		} else if ("writer".equals(criteria.getOption())) {
			sql += "        and board_writer = ? ";
		} else if ("content".equals(criteria.getOption())) {
			sql += "        and board_content like '%' || ? || '%' ";
		}
		sql += "            ) "
			+  "where rn >= ? and rn <= ? ";
	

		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql.toString());
		if (criteria.getOption() != null) {
			pstmt.setString(1, criteria.getKeyword());
			pstmt.setInt(2, criteria.getBeginIndex());
			pstmt.setInt(3, criteria.getEndIndex());
		} else {
			pstmt.setInt(1, criteria.getBeginIndex());
			pstmt.setInt(2, criteria.getEndIndex());
		}
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Board board = new Board();
			board.setId(rs.getLong("board_id"));
			board.setTitle(rs.getString("board_title"));
			board.setWriter(rs.getString("board_writer"));
			board.setContent(rs.getString("board_content"));
			board.setViewCount(rs.getInt("board_view_count"));
			board.setDeleted(rs.getString("board_deleted"));
			board.setUpdatedDate(rs.getDate("board_updated_date"));
			board.setCreatedDate(rs.getDate("board_created_date"));
			
			boardList.add(board);
		}
		rs.close();
		pstmt.close();
		connection.close();

		return boardList;
	}

	/**
	 * 게시글 아이디에 해당하는 게시글 정보를 반환한다.
	 * @param id 게시글 아이디
	 * @return 게시글 정보, null일 수 있음
	 * @throws SQLException
	 */
	public Board getBoardById(long id) throws SQLException {
		Board board = null;
		String sql = "select board_id, board_title, board_writer, board_content, board_view_count, "
				+ "       board_deleted, board_updated_date, board_created_date "
				+ "   from sample_search_boards "
				+ "   where board_id = ? "
				+ "   and board_deleted = 'N' ";
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setLong(1, id);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			board = new Board();
			board.setId(rs.getLong("board_id"));
			board.setTitle(rs.getString("board_title"));
			board.setWriter(rs.getString("board_writer"));
			board.setContent(rs.getString("board_content"));
			board.setViewCount(rs.getInt("board_view_count"));
			board.setDeleted(rs.getString("board_deleted"));
			board.setUpdatedDate(rs.getDate("board_updated_date"));
			board.setCreatedDate(rs.getDate("board_created_date"));
		}
		
		rs.close();
		pstmt.close();
		connection.close();

		return board;
	}

	/**
	 * 모든 게시글 정보를 삭제한다.
	 * @throws SQLException
	 */
	public void deleteAllBoards() throws SQLException {
		String sql = "truncate table sample_search_boards";

		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
}
