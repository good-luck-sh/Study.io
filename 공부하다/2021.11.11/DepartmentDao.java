package com.sample.dao;

import static com.sample.utils.ConnectionUtils.getConnection;

import java.sql.Connection;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.vo.Department;
import com.sample.vo.Employee;
import com.sample.vo.Location;


public class DepartmentDao {
	/**
	 * 변경된 정보가 포함된 부서정보를 전달받아서 테이블에 반영한다.
	 * @param department 부서정보
	 * @throws SQLException 데이터 베이스 엑세스 작업중 오류가 발생했을 때
	 */
	public void updateDeparmtnet(Department department) throws SQLException {

		String sql="update " + " departments "
				+"set "
				+"department_name = ? ,"
				+"manager_id = ? ,"
				+"location_id = ? "
				+"where department_id = ? ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setString(1, department.getName());
		ptmt.setObject(2, department.getManager().getId(), JDBCType.NUMERIC);
		//원래는 없던 타입인데, null을 입력하는 거야라고 setObject로 작성후 JDBCType으로 타입을 지정해주어야한다.
		ptmt.setInt(3, department.getLocation().getId());
		ptmt.setInt(4, department.getId());
		ptmt.executeUpdate();
		
		ptmt.close();
		connection.close();
	
	}
	/**
	 * 지정된 부서아이디에 해당하는 부서정보를 삭제한다.
	 * @param department_id 부서아이디
	 * @throws SQLException 데이터 베이스 엑세스 작업중 오류가 발생했을 때
	 */
	public void deleteDepartment(int department_id) throws SQLException {
		String sql = "delete from departments "
				+"where department_id = ? ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1, department_id);
		
		ptmt.executeUpdate();
		
		ptmt.close();
		connection.close();
	}

	/**
	 * 지정된 부서 이름과 부서소재지 아이디를 부서정보에 추가한다.
	 * @param departmentName 부서이름
	 * @param locationId 부서소재지 아이디
	 * @throws SQLException 데이터 베이스 엑세스 작업중 오류가 발생했을 때
	 */
	public void insertDepartment(String departmentName, int locationId) throws SQLException {
		String sql ="insert into departments(department_id, department_name, location_id) "
				+"values (departments_seq.nextval, ?, ?) ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setString(1, departmentName);
		ptmt.setInt(2, locationId);
		ptmt.executeUpdate();
		
		ptmt.close();
		connection.close();
	}
	
	/**
	 * 지정된 부서아이디에 해당하는 부서의 상세정보를 반환한다.
	 * @param departmentId 부서아이디
	 * @return Department 주서정보
	 * @throws SQLException  데이터 베이스 엑세스 작업중 오류가 발생했을 때
	 */
	public Department getDepartmentById(int departmentId) throws SQLException {
		String sql = "select D.department_id, D.department_name, E.employee_id, E.first_name, E.last_name, L.location_id, L.city "
				+" from departments D, employees E, locations L "
				+" where D.manager_id = E.employee_id(+) "
				+" and D.location_id = L.location_id "
				+" and D.department_id = ? ";
		Department department = null;
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1, departmentId);
		ResultSet rs = ptmt.executeQuery();
		if(rs.next()) {
			department = new Department();
			department.setId(rs.getInt("department_id"));
			department.setName(rs.getString("department_name"));
			Employee employee = new Employee();
			employee.setId(rs.getInt("employee_id"));
			employee.setFirstName(rs.getString("first_name"));
			employee.setLastName(rs.getString("last_name"));
			department.setManager(employee);
			Location location = new Location();
			location.setId(rs.getInt("location_id"));
			location.setCity(rs.getString("city"));
			department.setLocation(location);
		
		} 
		rs.close();
		ptmt.close();
		connection.close();
		
		return department;
	}
	/**
	 * 지정된 부서아이디에 소속된 직원 수를 반환한다. 
	 * @param departmentId 부서아이디
	 * @return 직원수
	 * @throws SQLException 데이터 베이스 엑세스 작업중 오류가 발생했을 때
	 */
	public int getEmployeesCountById(int departmentId) throws SQLException {
		String sql = "select count(*) cnt"
					+ " from employees "
					+" where department_id = ? ";
					
		int employeesCount = 0;
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1, departmentId);
		ResultSet rs = ptmt.executeQuery();
		rs.next();
		employeesCount = rs.getInt("cnt");
//		반드시 행은 1개는 조회될 것이다. 
//		if(rs.next()) {
//			employeesCount = rs.getInt("cnt");
//		}
		
		rs.close();
		ptmt.close();
		connection.close();
		return employeesCount;
	}
	
	/**
	 * 전체 부서목록을 반환한다.
	 * @return 부서 정보 목록
	 * @throws SQLException 데이터 베이스 엑세스 작업중 오류가 발생했을 때
	 */
	public List<Department> getAllDepartments() throws SQLException {
		String sql = "select D.department_id, D.department_name, E.employee_id, E.first_name, E.last_name, L.location_id, L.city "
				+" from departments D, employees E, locations L "
				+" where D.manager_id = E.employee_id(+) "
				+" and D.location_id = L.location_id "
				+"order by D.department_id asc";
		List<Department> departments =  new ArrayList<>();
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery();
		
		while(rs.next()) {
			Department department = new Department();
			department.setId(rs.getInt("department_id"));
			department.setName(rs.getString("department_name"));
			//부서정보 조회해서 담기
			Employee manager = new Employee();
			manager.setId(rs.getInt("employee_id"));
			manager.setFirstName(rs.getString("first_name"));
			manager.setLastName(rs.getString("last_name"));
			department.setManager(manager);
			//부서관리자 정보 조회해서 담기
			Location location = new Location();
			location.setId(rs.getInt("location_id"));
			location.setCity(rs.getString("city"));
			department.setLocation(location);
			//부서 소재지 정보 조회해서 담기
			departments.add(department);
			//위에서 생성한 ArrayList 객체에 부서정보 저장하기
		}
		rs.close();
		ptmt.close();
		connection.close();
		
		return departments;
	
	}
	
	
}
