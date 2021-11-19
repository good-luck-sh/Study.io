package com.sample.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sample.board.vo.User;
import static utils.ConnectionUtil.*;

public class UserDao {
	
	/**
	 * 싱글턴 객체로 사용하기 
	 * 1. 객체를 생성해서 정적변수를 저장한다. 
	 * 2. 생성자의 접근제한을 private로 설정한다. 
	 * 3. 1번에서 생성한 객체를 반환하는 정적메소드를 제공한다.
	 */
	private static UserDao self = new UserDao();
	//싱글턴패턴 만들기 자기자신을 담는 static변수를 만든다.
	//메모리에 올라가는 순간 self 정적변수에 담는다.
	private UserDao() {}
	//자기자신을 담는 private으로 생성자를 만든다. 생성이 여기안에서만 가능하도록 
	public static UserDao getInstance() {
	//싱글턴의 메소드의 이름은 getInstance()로 정한다.
	//공개되게 정적메소드로 만든다. 
	//객체 생성없이도 생성될 메소드를 생성한다.
	//정적변수로 계속 사용할 수 있게 만든다. 
		return self;
	}
	/**
	    * 지정된 사용자 번호에 해당하는 사용자 정보를 반환한다.
	    * @param no 사용자번호
	    * @return 사용자정보
	    * @throws SQLException
	    */
	public User getUserByNo(int no) throws SQLException {
		String sql = "select * from tb_comm_users where user_no = ?";
		User user = null;
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			user = new User();
			user.setNo(rs.getInt("user_no"));
			user.setId(rs.getString("user_id"));
			user.setPassword(rs.getString("user_password"));
			user.setName(rs.getString("user_name"));
			user.setTel(rs.getString("user_tel"));
			user.setEmail(rs.getString("user_email"));
			user.setDeleted(rs.getString("user_deleted"));
			user.setDeletedDate(rs.getDate("user_deleted_date"));
			user.setUpdatedDate(rs.getDate("user_updated_date"));
			user.setCreatedDate(rs.getDate("user_created_date"));
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return user;
	}
	   /**
	    * 지정된 사용자 아이디에 해당하는 사용자 정보를 반환한다.
	    * @param id 사용자 아이디
	    * @return 사용자정보
	    * @throws SQLException
	    */
	public User getUserById(String id) throws SQLException {
		String sql = "select * from tb_comm_users where user_id = ?";
		User user = null;
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			user = new User();
			user.setNo(rs.getInt("user_no"));
			user.setId(rs.getString("user_id"));
			user.setPassword(rs.getString("user_password"));
			user.setName(rs.getString("user_name"));
			user.setTel(rs.getString("user_tel"));
			user.setEmail(rs.getString("user_email"));
			user.setDeleted(rs.getString("user_deleted"));
			user.setDeletedDate(rs.getDate("user_deleted_date"));
			user.setUpdatedDate(rs.getDate("user_updated_date"));
			user.setCreatedDate(rs.getDate("user_created_date"));
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return user;
	}
	/**
	    * 지정된 사용자 이메일에 해당하는 사용자 정보를 반환한다.
	    * @param email 사용자 이메일
	    * @return 사용자정보
	    * @throws SQLException
	    */
	public User getUserByEmail(String email) throws SQLException {
		String sql = "select * from tb_comm_users where user_email = ?";
		User user = null;
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, email);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			user = new User();
			user.setNo(rs.getInt("user_no"));
			user.setId(rs.getString("user_id"));
			user.setPassword(rs.getString("user_password"));
			user.setName(rs.getString("user_name"));
			user.setTel(rs.getString("user_tel"));
			user.setEmail(rs.getString("user_email"));
			user.setDeleted(rs.getString("user_deleted"));
			user.setDeletedDate(rs.getDate("user_deleted_date"));
			user.setUpdatedDate(rs.getDate("user_updated_date"));
			user.setCreatedDate(rs.getDate("user_created_date"));
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return user;
	}
	/**
	    * 수정된 정보가 포함된 사용자정보를 테이블에 반영한다.
	    * @param user 사용자정보
	    * @throws SQLException
	    */
	public void updateUser(User user) throws SQLException {
		String sql = "update tb_comm_users "
				   + "set "
				   + "	user_password = ?, "
				   + "	user_tel = ?, "
				   + "	user_email = ?, "
				   + "	user_deleted = ?, "
				   + "	user_deleted_date = ?, "
				   + "	user_updated_date = sysdate "
				   + "where"
				   + "	user_no = ? ";
		
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, user.getPassword());
		pstmt.setString(2, user.getTel());
		pstmt.setString(3, user.getEmail());
		pstmt.setString(4, user.getDeleted());
		pstmt.setDate(5, new java.sql.Date(new java.util.Date().getTime()));
		pstmt.setInt(6, user.getNo());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public void insertUser(User user) throws SQLException {
		String sql = "insert into tb_comm_users(user_no, user_id, user_password, user_name, user_tel, user_email) "
				   + "values(comm_user_seq.nextval, ?,?,?,?,?)";
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getName());
		pstmt.setString(4, user.getTel());
		pstmt.setString(5, user.getEmail());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
}
