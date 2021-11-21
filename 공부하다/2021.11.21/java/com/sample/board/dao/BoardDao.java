package com.sample.board.dao;

import static utils.ConnectionUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.board.vo.Board;
import com.sample.board.vo.BoardLiker;
import com.sample.board.vo.User;

/**
 * 게시글 등록, 게시글 목록조회, 게시글 수정, 게시글 삭제, 추천 추가, 추천인 조회 기능을 제공하는 클래스다.
 * @author lee_e
 *
 */
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
		pstmt.setInt(2, board.getWriter().getNo());
		pstmt.setString(3, board.getContent());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	/**
	 * 수정된 정보가 포함된 게시글 정보를 테이블에 반영한다.
	 * @param board
	 * @throws SQLException
	 */
	public void updateBoard(Board board) throws SQLException {
		String sql = "update tb_comm_boards "
				   + "set "
				   + "	board_title = ?, "
				   + "	board_content = ?, "
				   + "	board_like_count = ?, "
				   + "	board_view_count = ?, "
				   + "	board_updated_date = sysdate "
				   + "where board_no = ? ";
		
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getContent());
		pstmt.setInt(3, board.getLikeCount());
		pstmt.setInt(4, board.getViewCount());
		pstmt.setInt(5, board.getNo());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	/**
	 * 지정된 번호의 게시글을 삭제처리한다.
	 * @param no 글번호
	 * @throws SQLException
	 */
	public void deleteBoard(int no) throws SQLException {
		String sql = "update tb_comm_boards "
				   + "set "
				   + "	board_deleted = 'Y', "
				   + "	board_deleted_date = sysdate, "
				   + "	board_updated_date = sysdate "
				   + "where board_no = ? ";
		
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, no);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	/**
	 * 테이블에 저장된 게시글정보의 갯수를 반환한다.
	 * @return 게시글 정보 갯수
	 * @throws SQLException
	 */
	public int getTotalRecords() throws SQLException {
		String sql = "select count(*) cnt "
				   + "from tb_comm_boards";
		
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
	
	/**
	 * 지정된 범위에 속하는 게시글 정보를 반환한다.
	 * @param begin 시작 순번번호
	 * @param end 끝 순번번호
	 * @return 게시글 목록
	 * @throws SQLException
	 */
	public List<Board> getBoardList(int begin, int end) throws SQLException {
		String sql = "select board_no, board_title, user_no, user_id, user_name, board_content, "
				   + "       board_view_count, board_like_count, board_deleted, "
				   + "		 board_deleted_date, board_updated_date, board_created_date "
				   + "from (select row_number() over (order by B.board_no desc) rn, "
				   + "             B.board_no, B.board_title, U.user_no, U.user_id, U.user_name, B.board_content,  "
				   + "             B.board_view_count, B.board_like_count, B.board_deleted, "
				   + "			   B.board_deleted_date, B.board_updated_date, B.board_created_date "
				   + "      from tb_comm_boards B, tb_comm_users U "
				   + "      where B.board_writer_no = U.user_no) "
				   + "where rn >= ? and rn <= ? ";
		
		List<Board> boardList = new ArrayList<>();
		
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, begin);
		pstmt.setInt(2, end);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Board board = new Board();
			User user = new User();
			
			board.setNo(rs.getInt("board_no"));
			board.setTitle(rs.getString("board_title"));
			board.setContent(rs.getString("board_content"));
			board.setLikeCount(rs.getInt("board_like_count"));
			board.setViewCount(rs.getInt("board_view_count"));
			board.setDeleted(rs.getString("board_deleted"));
			board.setDeletedDate(rs.getDate("board_deleted_date"));
			board.setUpdatedDate(rs.getDate("board_updated_date"));
			board.setCreatedDate(rs.getDate("board_created_date"));
			
			user.setNo(rs.getInt("user_no"));
			user.setId(rs.getString("user_id"));
			user.setName(rs.getString("user_name"));
			
			board.setWriter(user);
			
			boardList.add(board);
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return boardList;
	}
	
	/**
	 * 지정된 번호의 게시글 정보를 반영한다.
	 * @param no 게시긃ㄴ호
	 * @return 게시글 정보
	 * @throws SQLException
	 */
	public Board getBoardDetail(int no) throws SQLException {
		String sql = "select B.board_no, B.board_title, U.user_no, U.user_id, U.user_name, B.board_content, "
				   + "       B.board_view_count, B.board_like_count, B.board_deleted, "
				   + "		 B.board_deleted_date, B.board_updated_date, B.board_created_date "
				   + "from tb_comm_boards B, tb_comm_users U "
				   + "where B.board_writer_no = U.user_no "
				   + "and B.board_no = ? ";
		
		Board board = null;
		
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			board = new Board();
			User user = new User();
			
			board.setNo(rs.getInt("board_no"));
			board.setTitle(rs.getString("board_title"));
			board.setContent(rs.getString("board_content"));
			board.setLikeCount(rs.getInt("board_like_count"));
			board.setViewCount(rs.getInt("board_view_count"));
			board.setDeleted(rs.getString("board_deleted"));
			board.setDeletedDate(rs.getDate("board_deleted_date"));
			board.setUpdatedDate(rs.getDate("board_updated_date"));
			board.setCreatedDate(rs.getDate("board_created_date"));
			
			user.setNo(rs.getInt("user_no"));
			user.setId(rs.getString("user_id"));
			user.setName(rs.getString("user_name"));
			
			board.setWriter(user);
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return board;
	}
	
	/**
	 * 게시글 추천 정보를 저장한다.
	 * @param boardLiker 게시글 추천정보(게시글번호, 로그인한 사용자번호 포함)
	 * @throws SQLException
	 */
	public void insertBoardLiker(BoardLiker boardLiker) throws SQLException {
		String sql = "insert into tb_comm_board_like_users (board_no, user_no) "
				   + "values (?, ?)";
		
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, boardLiker.getBoardNo());
		pstmt.setInt(2, boardLiker.getUserNo());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	/**
	 * 지정된 글번호와 사용자번호로 추천정보를 조회해서 반환한다.
	 * @param boardNo 글번호
	 * @param userNo 사용자번호
	 * @return 추천정보
	 * @throws SQLException
	 */
	public BoardLiker getBoardLiker(int boardNo, int userNo) throws SQLException {
		String sql = "select board_no, user_no "
				   + "from tb_comm_board_like_users "
				   + "where board_no = ? and user_no = ?";
		
		BoardLiker boardLiker = null;
		
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, boardNo);
		pstmt.setInt(2, userNo);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			boardLiker = new BoardLiker();
			boardLiker.setBoardNo(rs.getInt("board_no"));
			boardLiker.setUserNo(rs.getInt("user_no"));	
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return boardLiker;
	}
	
	/**
	 * 지정된 번호의 글에 추천한 사용자의 목록을 반환한다.
	 * @param boardNo 글번호
	 * @return 사용자 목록
	 * @throws SQLException
	 */
	public List<User> getLikeUsers(int boardNo) throws SQLException {
		String sql = "select U.user_no, U.user_id, U.user_name "
				   + "from tb_comm_board_like_users L, tb_comm_users U "
				   + "where L.user_no = U.user_no "
				   + "and L.board_no = ? ";
		
		List<User> userList = new ArrayList<>();
		
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, boardNo);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			User user = new User();
			
			user.setNo(rs.getInt("user_no"));
			user.setId(rs.getString("user_id"));
			user.setName(rs.getString("user_name"));
			
			userList.add(user);
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return userList;
	}
}










