package com.example.utils;

import com.example.dao.BoardDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionUtil {

	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "hr";
	private static final String PASSWORD = "zxcv1234";

	/**
	 * 오라클 JDBC 드라이버를 메모리에 로딩시킨다.
	 * 게시글 테이블의 모든 샘플 데이터를 삭제한다.
	 * 게시글 테이블에 샘플 데이터를 추가한다.
	 */
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			deleteTestData();
			insertTestData();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		} 
	}

	/**
	 * 데이터베이스와 연결된 커넥션 객체를 반환한다.
	 * @return 커넥션 객체
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}

	/**
	 * 게시글 테이블의 모든 샘플데이터를 삭제한다.
	 * @throws SQLException
	 */
	private static void deleteTestData() throws SQLException {
		BoardDao.getInstance().deleteAllBoards();
	}

	/**
	 * 게시글 테이블에 샘플데이터를 추가한다.
	 * @throws SQLException
	 */
	private static void insertTestData() throws SQLException {
		String sql = "insert into sample_search_boards  (board_id, board_title, board_writer, board_content)  values  (sample_search_boards_seq.nextval, ?, ?, '테스트내용입니다.') ";
		String[] titles = {"글 작성 연습 ", "페이징처리 연습", "검색 기능 연습", "게시글 상세보기 연습", "삭제하기 연습", "조회수 증가 체크", "최종 수정일자 변경 확인", "이전 다음 버튼 활성화/비활성화 체크", "페이지번호 active 확인"};
		String[] writers = {"김유신", "이순신", "강감찬", "홍길동", "류관순"};
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		for (int index = 1; index <= 200; index++) {
			pstmt.setString(1, index + "000 " + titles[index% titles.length]);
			pstmt.setString(2, writers[index% writers.length]);
			pstmt.addBatch();
			pstmt.clearParameters();
		}
		pstmt.executeBatch();
		pstmt.close();
		connection.close();
	}

}
