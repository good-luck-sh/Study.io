package dao;

import static utils.ConnectionUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Category;
import vo.Food;

public class FoodDao {

	public List<Food> selectAllFoods() throws SQLException {
		// TODO TB_SAMPLE_FOODS 테이블에 저장된 모든 식품정보를 조회해서 반환한다.
		// 식품번호, 식품이름, 식품가격, 판매여부, 카테고리번호, 카테고리명을 조회한다. (TB_SAMPLE_FOODS와 TB_SAMPLE_FOOD_CATEGORIES 조인 필요)
		List<Food> foods = new ArrayList<>();
		String sql = " select f.food_no, f.food_name, f.food_price, f.food_on_sale, f.category_no, c.category_name "
					+" from tb_sample_foods f , tb_sample_food_categories c "
					+" where f.category_no  = c.category_no ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery();
		repeatFood(foods, rs);

		rs.close();
		ptmt.close();
		connection.close();
		return foods;
	}

	private void repeatFood(List<Food> foods, ResultSet rs) throws SQLException {
		while(rs.next()) {
			Food food = new Food();
			Category category = new Category();
			food.setNo(rs.getInt("food_no"));
			food.setName(rs.getString("food_name"));
			food.setPrice(rs.getInt("food_price"));
			food.setOnSale(rs.getString("food_on_sale"));
			category.setNo(rs.getInt("category_no"));
			category.setName(rs.getString("category_name"));
			food.setCategory(category);
			foods.add(food);
		}
	}
	
	public List<Food> selectFoodsByCategory(int categoryNo) throws SQLException {
		// TODO TB_SAMPLE_FOODS 테이블에서 지정된 카테고리번호에 해당하는 모든 식품정보를 조회해서 반환한다.
		// 식품번호, 식품이름, 식품가격, 판매여부, 카테고리번호, 카테고리명을 조회한다. (TB_SAMPLE_FOODS와 TB_SAMPLE_FOOD_CATEGORIES 조인 필요)
		List<Food> foods = new ArrayList<>();
	
		String sql = "select f.food_no, f.food_name, f.food_price, f.food_on_sale, f.category_no, c.category_name "
				+"from tb_sample_foods f, tb_sample_food_categories c "
				+"where c.category_no = f.category_no "
				+ " and c.category_no = ? ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1, categoryNo);
		
		ResultSet rs = ptmt.executeQuery();
		repeatFood(foods, rs);
		rs.close();
		ptmt.close();
		connection.close();
		
		return foods;
	}
	
	public Food selectFoodByNo(int foodNo) throws SQLException {
		// TODO TB_SAMPLE_FOODS 테이블에서 지정된 식품번호에 해당하는 식품정보를 조회해서 반환한다.
		// 식품번호, 식품이름, 식품가격, 식품재고, 판매여부, 카테고리번호, 카테고리명을 조회한다. (TB_SAMPLE_FOODS와 TB_SAMPLE_FOOD_CATEGORIES 조인 필요)
		Food food = null;
		String sql = "select f.food_no, f.food_name, f.food_price, f.food_on_sale, f.category_no, c.category_name "
				+"from tb_sample_foods f, tb_sample_food_categories c "
				+"where f.food_no = ? "
				+"and c.category_no = f.category_no ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1,foodNo);
		
		ResultSet rs = ptmt.executeQuery();
		if(rs.next()) {
			food = new Food();
			Category category = new Category();
			food.setNo(rs.getInt("food_no"));
			food.setName(rs.getString("food_name"));
			food.setPrice(rs.getInt("food_price"));
			food.setOnSale(rs.getString("food_on_sale"));
			category.setNo(rs.getInt("category_no"));
			category.setName(rs.getString("category_name"));
			food.setCategory(category);
		} 
		return food;
	}
	
	public Food selectFoodByName(String foodName) throws SQLException {
		// TODO TB_SAMPLE_FOODS 테이블에서 지정된 식품이름에 해당하는 식품정보를 조회해서 반환한다.
		// 식품번호, 식품이름, 식품가격, 식품재고, 판매여부, 카테고리번호, 카테고리명을 조회한다. (TB_SAMPLE_FOODS와 TB_SAMPLE_FOOD_CATEGORIES 조인 필요)
		Food food = null;
		String sql = "select f.food_no, f.food_name, f.food_price, f.food_on_sale, f.category_no, c.category_name "
				+"from tb_sample_foods f, tb_sample_food_categories c "
				+"where f.food_name = ? "
				+ "and c.category_no = f.category_no ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setString(1,foodName);
		ResultSet rs = ptmt.executeQuery();
		
		if(rs.next()) {
			food = new Food();
			Category category = new Category();
			food.setNo(rs.getInt("food_no"));
			food.setName(rs.getString("food_name"));
			food.setPrice(rs.getInt("food_price"));
			food.setOnSale(rs.getString("food_on_sale"));
			category.setNo(rs.getInt("category_no"));
			category.setName(rs.getString("category_name"));
			food.setCategory(category);
		} else {
			System.out.println("### 오류 입력이 잘 못 되었습니다. ");
		}
		
		return food;
	}
	
	public void insertFood(Food food) throws SQLException {
		// TODO TB_SAMPLE_FOODS 테이블에 지정된 상품정보를 추가한다.
		// 식품이름, 식품가격, 식품입고량, 판매여부, 카테고리번호를 저장한다.
		String sql = "insert into tb_sample_foods "
				+"(food_no, food_name, food_price, food_stock, food_on_sale, category_no )"
				+"values "
				+"(food_seq.nextval, ?, ? ,? ,? ,? ) ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setString(1, food.getName());
		ptmt.setInt(2, food.getPrice());
		ptmt.setInt(3, food.getStock());
		ptmt.setString(4, food.getOnSale());
		Category category = food.getCategory();
		ptmt.setInt(5, category.getNo());
		
		ptmt.executeUpdate();
		
		ptmt.close();
		connection.close();
	}
	
	public void updateFood(Food food) throws SQLException {
		// TODO TB_SAMPLE_FOODS 테이블에 저장된 식품정보를 전달받은 식품정보로 변경한다.
		// 식품명, 식품가격, 식품재고, 판매여부를 변경할 수 있다.
		String sql = "update tb_sample_foods "
				+"set "
				+"food_name = ? ,"
				+"food_price = ? ,"
				+"food_stock = ? ,"
				+"food_on_sale = ? "
				+"where food_no = ? ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setString(1, food.getName());
		ptmt.setInt(2, food.getPrice());
		ptmt.setInt(3, food.getStock());
		ptmt.setString(4, food.getOnSale());
		ptmt.setInt(5, food.getNo());
		
		ptmt.executeUpdate();
		
		ptmt.close();
		connection.close();
		
		
	}
}
