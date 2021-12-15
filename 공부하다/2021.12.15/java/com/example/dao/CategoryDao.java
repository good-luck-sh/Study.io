package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.vo.Category;

import comexample.utils.ConnectionUtil;

public class CategoryDao {

	private static CategoryDao self = new CategoryDao();
	private CategoryDao() {}
	public static CategoryDao getInstance() {
		return self;
	}
	
	public List<Category> getAllCategories() throws SQLException {
		String sql = "select category_no, category_name "
				   + "from model2_todo_categories "
				   + "order by category_no asc ";
		
		List<Category> categoryList = new ArrayList<>();
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Category category = new Category();
			category.setNo(rs.getInt("category_no"));
			category.setName(rs.getString("category_name"));
			categoryList.add(category);
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return categoryList;
	}
}
