package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.dto.TodoDto;
import com.example.vo.Todo;

import comexample.utils.ConnectionUtil;

public class TodoDao {

	private static TodoDao self = new TodoDao();
	private TodoDao() {}
	public static TodoDao getInstance() {
		return self;
	}
	
	public void insertTodo(Todo todo) throws SQLException {
		String sql = "insert into model2_todos "
				   + "(todo_no, todo_category_no, todo_title, todo_user_no, todo_due_date, todo_content) "
				   + "values "
				   + "(todo_seq.nextval, ?, ?, ?, ?, ?)";
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, todo.getCategoryNo());
		pstmt.setString(2, todo.getTitle());
		pstmt.setInt(3, todo.getUserNo());
		pstmt.setDate(4, new java.sql.Date(todo.getDueDate().getTime()));
		pstmt.setString(5, todo.getContent());
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public int getTotalRows() throws SQLException {
		String sql = "select count(*) cnt "
				   + "from model2_todos ";
		
		int totalRows = 0;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		totalRows = rs.getInt("cnt");
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return totalRows;
	}
	
	public List<TodoDto> getTodos(int beginIndex, int endIndex) throws SQLException {
		String sql = "select rn, todo_no, todo_category_no, category_name, todo_title, todo_user_no, user_id, user_name, "
				   + "       todo_due_date, todo_content, todo_status_no, status_title, todo_updated_date, todo_created_date "
				   + "from ("
				   + "      select row_number() over (order by todo_no desc) rn, A.todo_no, A.todo_category_no, A.todo_title, A.todo_user_no, "
				   + "             A.todo_due_date, A.todo_content, A.todo_status_no, A.todo_updated_date, A.todo_created_date, "
				   + "             B.category_name, C.user_id, C.user_name, D.status_title "
				   + "       from model2_todos A, model2_todo_categories B, model2_todo_users C, model2_todo_status D "
				   + "       where A.todo_category_no = B.category_no "
				   + "       and A.todo_user_no = C.user_no "
				   + "       and A.todo_status_no = d.status_no"
				   + ")"
				   + "where rn >= ? and rn <= ? ";
		
		List<TodoDto> todoDtoList = new ArrayList<>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, beginIndex);
		pstmt.setInt(2, endIndex);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			TodoDto dto = new TodoDto();
			dto.setNo(rs.getInt("todo_no"));
			dto.setTitle(rs.getString("todo_title"));
			dto.setDueDate(rs.getDate("todo_due_date"));
			dto.setContent(rs.getString("todo_content"));
			dto.setUpdatedDate(rs.getDate("todo_updated_date"));
			dto.setCreatedDate(rs.getDate("todo_created_date"));
			dto.setCategoryNo(rs.getInt("todo_category_no"));
			dto.setCategoryName(rs.getString("category_name"));
			dto.setUserNo(rs.getInt("todo_user_no"));
			dto.setUserId(rs.getString("user_id"));
			dto.setUserName(rs.getString("user_name"));
			dto.setStatusNo(rs.getInt("todo_status_no"));
			dto.setStatusTitle(rs.getString("status_title"));
			
			todoDtoList.add(dto);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return todoDtoList;
	}
	public TodoDto getTodo(int todoNo) throws SQLException {
		TodoDto todo = null;
		String sql = " select A.todo_no, A.todo_category_no, A.todo_title, A.todo_user_no, "
				   + " A.todo_due_date, A.todo_content, A.todo_status_no, A.todo_updated_date, A.todo_created_date, "
				   + " B.category_name, C.user_id, C.user_name, D.status_title "
				   + " from model2_todos A, model2_todo_categories B, model2_todo_users C, model2_todo_status D "
				   + " where A.todo_category_no = B.category_no "
				   + " and A.todo_user_no = C.user_no "
				   + " and A.todo_status_no = d.status_no "
				   + " and A.todo_no = ? ";
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, todoNo);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			todo = new TodoDto();
			todo.setNo(rs.getInt("todo_no"));
			todo.setTitle(rs.getString("todo_title"));
			todo.setDueDate(rs.getDate("todo_due_date"));
			todo.setContent(rs.getString("todo_content"));
			todo.setUpdatedDate(rs.getDate("todo_updated_date"));
			todo.setCreatedDate(rs.getDate("todo_created_date"));
			todo.setCategoryNo(rs.getInt("todo_category_no"));
			todo.setCategoryName(rs.getString("category_name"));
			todo.setUserNo(rs.getInt("todo_user_no"));
			todo.setUserId(rs.getString("user_id"));
			todo.setUserName(rs.getString("user_name"));
			todo.setStatusNo(rs.getInt("todo_status_no"));
			todo.setStatusTitle(rs.getString("status_title"));
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		return todo;
	}
	public void updateTodo(Todo todo) throws SQLException {
		String sql = "update model2_todos "
				   + "set "
				   + "	todo_category_no = ?, "
				   + "  todo_title = ?, "
				   + "  todo_due_date = ?, "
				   + "  todo_content = ?, "
				   + "  todo_status_no = ?, "
				   + "  todo_updated_date = sysdate "
				   + "where todo_no = ?";
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, todo.getCategoryNo());
		pstmt.setString(2, todo.getTitle());
		pstmt.setDate(3, new java.sql.Date(todo.getDueDate().getTime()));
		pstmt.setString(4, todo.getContent());
		pstmt.setInt(5, todo.getStatusNo());
		pstmt.setInt(6, todo.getNo());
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
}











