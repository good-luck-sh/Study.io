package com.sample.dao;
import static com.sample.utils.ConnectionUtils.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.vo.Employee;


public class EmployeeDao {
	/**
	 * 지정된 부서아이디에 소속된 사원정보를 반환한다.
	 * @param departmentId 부서아이디
	 * @return 해당 부서에 소속된 사원 정보 목록
	 * @throws SQLException  데이터 베이스 엑세스 작업중 오류가 발생했을 때
	 */
	public List<Employee> getEmployeesByDepartmentId(int departmentId) throws SQLException{
		
		List<Employee> employees = new ArrayList<>();

		String sql = "select employee_id, first_name, last_name, email, phone_number, hire_date "
				+"from employees "
				+"where department_id = ? "
				+"order by first_name asc ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1, departmentId);
		ResultSet rs = ptmt.executeQuery();
		
		while(rs.next()) {
			Employee employee = new Employee();
			employee.setId(rs.getInt("employee_id"));
			employee.setFirstName(rs.getString("first_name"));
			employee.setLastName(rs.getString("last_name"));
			employee.setEmail(rs.getString("email"));
			employee.setPhoneNumber(rs.getString("phone_number"));
			employee.setHireDate(rs.getDate("hire_date"));
			employees.add(employee);
		}
		rs.close();
		ptmt.close();
		connection.close();
		return employees;
	}
}
