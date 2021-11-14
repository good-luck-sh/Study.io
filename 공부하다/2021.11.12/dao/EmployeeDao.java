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
import com.sample.vo.Job;

import oracle.jdbc.proxy.annotation.Pre;


public class EmployeeDao {

	
	/**
	 * 입력받은 사원의 번호에 해당하는 사원의 정보를 삭제한다. 
	 * @param EmployeeId 삭제할 사원의 번호
	 * @throws SQLException 데이터 베이스 엑세스 작업중 오류가 발생했을 때
	 */
	public void deleteEmployee(int EmployeeId) throws SQLException {
		String sql = "delete from employees "
				+ "where employee_id = ? ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1, EmployeeId);
		ptmt.executeUpdate();
		
		ptmt.close();
		connection.close();
		
	}
	
	/**
	 * 입력받은 직원정보로 새로운 직원을 등록한다.
	 * @param employee 등록할 직원정보
	 * @throws SQLException 데이터 베이스 엑세스 작업중 오류가 발생했을 때
	 */
	public void insertEmployee(Employee employee) throws SQLException {
		String sql = "insert into employees (employee_id, first_name, last_name, phone_number,email, job_id, salary, commission_pct, manager_id, department_id, hire_date ) "
					+"values (employees_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ? ,sysdate) ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setString(1, employee.getFirstName());
		ptmt.setString(2, employee.getLastName());
		ptmt.setString(4, employee.getEmail());
		ptmt.setString(3, employee.getPhoneNumber());
		ptmt.setString(5, employee.getJob().getId());
		ptmt.setDouble(6, employee.getSalary());
		ptmt.setDouble(7, employee.getCommissionPct());
		ptmt.setInt(8, employee.getManager().getId());
		ptmt.setInt(9, employee.getDepartment().getId());
		ptmt.executeUpdate();
		
		ptmt.close();
		connection.close();
	}
	
	/**
	 * 직원아이디를 입력받아서 해당하는 직원정보를 반환한다. 
	 * @param employeeId 직원아이디
	 * @return 해당하는 직원정보
	 * @throws SQLException 데이터 베이스 엑세스 작업중 오류가 발생했을 때
	 */
	public Employee getEmployeeById(int employeeId) throws SQLException {
		Employee employee = null;
		String sql = "select E.employee_id, E.first_name, E.last_name, E.email, E.job_id, J.job_title, E.salary, E.commission_pct, "
				+ " E.manager_id, E.department_id, D.department_name "
				+" from employees E, departments D, Jobs J "
				+" where E.department_id = D.department_id "
				+" and J.job_id = E.job_id "
				+" and E.employee_id = ? ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1, employeeId);
		ResultSet rs = ptmt.executeQuery();
		if(rs.next()) { 
			employee = new Employee();
			employee.setId(rs.getInt("employee_id"));
			employee.setFirstName(rs.getString("first_name"));
			employee.setLastName(rs.getString("last_name"));
			employee.setEmail(rs.getString("email"));
			
			Job job = new Job();
			job.setId(rs.getString("job_id"));
			job.setTitle(rs.getString("job_title"));
			employee.setJob(job);
			
			employee.setSalary(rs.getDouble("salary"));
			employee.setCommissionPct(rs.getDouble("commission_pct"));
			Employee manager = new Employee();
			manager.setId(rs.getInt("manager_id"));
			employee.setManager(manager);
			
			Department department = new Department();
			department.setId(rs.getInt("department_id"));
			department.setName(rs.getString("department_name"));
			
			employee.setDepartment(department);
			
		}
		rs.close();
		ptmt.close();
		connection.close();
		return employee;
	}
	public Integer getDepartmentIdByEmployee(int employeeId) throws SQLException {
		Integer integer = null;
		String sql = "select department_id "
					+"from employees "
					+"where employee_id = ? ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1, employeeId);
		ResultSet rs = ptmt.executeQuery();
		if(rs.next()) {
			integer = rs.getInt("department_id");
		}
		rs.close();
		ptmt.close();
		connection.close();
		return integer;
	}
	public List<Employee> getAdministrateEmployee(int managerId) throws SQLException {
		List<Employee> employees = new ArrayList<>();
		String sql = "select E.employee_id, E.first_name, E.last_name, E.email "
					+"from employees E, employees M "
					+"where E.manager_id = M.employee_id "
					+"and E.manager_id = ? ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1, managerId);
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()) {
			Employee employee = new Employee();
			employee.setId(rs.getInt("employee_id"));
			employee.setFirstName(rs.getString("first_name"));
			employee.setLastName(rs.getString("last_name"));
			employee.setEmail(rs.getString("email"));
			employees.add(employee);
		}
		rs.close();
		ptmt.close();
		connection.close();
		
		return employees;
	}
	
	public int getCountManager(int managerId) throws SQLException {
		int integer = 0;
		String sql =  "select count(*) cnt "
				+"from employees E, employees M "
				+"where E.manager_id = ? "
				+"and E.manager_id = M.employee_id ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1, managerId);
		ResultSet rs = ptmt.executeQuery();
		rs.next();
		
		integer = rs.getInt("cnt");
		return integer;
	}
	public List<Employee> getManager() throws SQLException {
		List<Employee> managers = new ArrayList<>();
		String sql = "select E.employee_id, E.first_name, E.last_name, E.department_id, D.department_name "
				+ "from employees E, departments D "
				+ "where E.department_id = D.department_id "
				+ "and E.employee_id in (select distinct manager_id "
				+ "from employees "
				+ "where manager_id is not null) ";
				
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()) {
			Employee employee = new Employee();
			Department department = new Department();
			employee.setId(rs.getInt("employee_id"));
			employee.setFirstName(rs.getString("first_name"));
			employee.setLastName(rs.getString("last_name"));
			department.setId(rs.getInt("department_id"));
			department.setName(rs.getString("department_name"));
			employee.setDepartment(department);
			
			managers.add(employee);
		}
		
		rs.close();
		ptmt.close();
		connection.close();
		return managers;
	}
	
	
	/**
	 * 전체 소속된 사원정보를 반환한다.
	 * @return 전체 사원정보
	 * @throws SQLException 데이터 베이스 엑세스 작업중 오류가 발생했을 때
	 */
	public List<Employee> getAllEmployee() throws SQLException {
		List<Employee> employees = new ArrayList<>();
		String sql = "select employee_id, first_name, last_name, email,phone_number, manager_id, job_id "
					+"from employees ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery();
		
		while(rs.next()) {
			Employee employee = new Employee();
			employee.setId(rs.getInt("employee_id"));
			employee.setFirstName(rs.getString("first_name"));
			employee.setLastName(rs.getString("last_name"));
			employee.setEmail(rs.getString("email"));
			employee.setPhoneNumber(rs.getString("phone_number"));
			Employee manager = new Employee();
			manager.setId(rs.getInt("manager_id"));
			employee.setManager(manager);
			Job job = new Job();
			job.setId(rs.getString("job_id"));
			employees.add(employee);
		}
		rs.close();
		ptmt.close();
		connection.close();
				
		
		return employees;
	}
	/**
	 * 지정된 부서아이디에 소속된 사원정보를 반환한다.
	 * @param departmentId 부서아이디
	 * @return 해당 부서에 소속된 사원 정보 목록
	 * @throws SQLException  데이터 베이스 엑세스 작업중 오류가 발생했을 때
	 */
	public List<Employee> getEmployeesByDepartmentId(int departmentId) throws SQLException{
		
		List<Employee> employees = new ArrayList<>();

		String sql = "select employee_id, first_name, last_name, email, phone_number, hire_date , manager_id "
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
			Employee manager = new Employee();
			manager.setId(rs.getInt("manager_id"));
			employee.setManager(manager);
			employees.add(employee);
		}
		rs.close();
		ptmt.close();
		connection.close();
		return employees;
	}
	
	public List<Employee> getCountPageEmployee (int begin, int end) throws SQLException {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT rn, employee_id, first_name, last_name, phone_number, email, job_id, department_id, department_name "
	               + "FROM  (select row_number() over (order by e.employee_id desc) rn, "
	                + "       E.employee_id, E.first_name, E.last_name, E.phone_number, E.email, "
	                + "       E.job_id, D.department_id, D.department_name "
	                + "       from employees E, departments D "
	                + "       where E.department_id = D.department_id(+)) "
	                + "where rn >= ? and rn <= ? ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1, begin);
		ptmt.setInt(2, end);
		
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()) {
			Employee employee = new Employee();
			Department department = new Department();
			Job job = new Job();
			
			employee.setId(rs.getInt("employee_id"));
			employee.setFirstName(rs.getString("first_name"));
			employee.setLastName(rs.getString("last_name"));
			employee.setPhoneNumber(rs.getString("phone_number"));
			employee.setEmail(rs.getString("email"));
			job.setId(rs.getString("job_id"));
			employee.setJob(job);
			department.setId(rs.getInt("department_id"));
			department.setName(rs.getString("department_name"));
			employee.setDepartment(department);
			employees.add(employee);
		}
		return employees;
	}
	
	/**
	 * 전체 사원수를 반환한다. 
	 * @return 사원수
	 * @throws SQLException  데이터 베이스 엑세스 작업중 오류가 발생했을 때
	 */
	public int getEmployeesCount() throws SQLException {
		int countEmployees = 0;
		String sql =" select count(*) cnt "
				+ "from employees ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ResultSet rs= ptmt.executeQuery();
		rs.next();
		countEmployees = rs.getInt("cnt");
		
		rs.close();
		ptmt.close();
		connection.close();
		
		return countEmployees;
	}
}