package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.vo.Status;

import comexample.utils.ConnectionUtil;

public class StatusDao {

	private static StatusDao self = new StatusDao();
	private StatusDao() {}
	public static StatusDao getInstance() {
		return self;
	}
	
	public List<Status> getAllStatus() throws SQLException {
		String sql = "select status_no, status_title "
				   + "from model2_todo_status "
				   + "order by status_no asc ";
		
		List<Status> statusList = new ArrayList<>();
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Status status = new Status();
			status.setNo(rs.getInt("status_no"));
			status.setTitle(rs.getString("status_title"));
			statusList.add(status);
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return statusList;
	}
}
