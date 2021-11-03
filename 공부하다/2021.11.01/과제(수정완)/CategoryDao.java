package dao;

import static utils.ConnectionUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Category;

public class CategoryDao {

	public List<Category> selectAllCategories() throws SQLException {
		// TODO TB_SAMPLE_FOOD_CATEGORIES 테이블에 저장된 모든 카테고리 정보를 조회해서 반환한다.
		List<Category> categorys = new ArrayList<>();
		String sql = "select category_no, category_name "
				+"from tb_sample_food_categories ";
		Connection connection = getConnection(); 
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery();
		
		while(rs.next()) {
			Category category = new Category();
			category.setNo(rs.getInt("category_no"));
			category.setName(rs.getString("category_name"));
			categorys.add(category);
		}
		return categorys;
	}
	
}
