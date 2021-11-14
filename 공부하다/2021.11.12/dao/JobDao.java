package com.sample.dao;

import static com.sample.utils.ConnectionUtils.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.vo.Employee;
import com.sample.vo.Job;

public class JobDao {
	/**
	 * 등록된 직종리스트를 반환하는 메소드
	 * @return 등록된 직종리스트 
	 * @throws SQLException 데이터 베이스 엑세스 작업중 오류가 발생했을 때
	 */
	public List<Job> getJobsList() throws SQLException {
		List<Job> jobs = new ArrayList<>();
		String sql = "select job_id, job_title, min_salary, max_salary "
				+"from jobs";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()) {
			Job job = new Job();
			job.setId(rs.getString("job_id"));
			job.setTitle(rs.getString("job_title"));
			job.setMinSalary(rs.getInt("min_salary"));
			job.setMaxSalaty(rs.getInt("max_salary"));
			jobs.add(job);
			
		}
		rs.close();
		ptmt.close();
		connection.close();
		return jobs;
	}
	/**
	 * 직종의 아이디를 입력 받아서 해당하는 객체를 반환한다. 
	 * @param jobId 직종의 아이디
	 * @return 해당하는 직원의 정보
	 * @throws SQLException 데이터 베이스 엑세스 작업중 오류가 발생했을 때
	 */
	public Job getJobListById(String jobId) throws SQLException {
		Job job = null;
		String sql = "select job_id, job_title, min_salary, max_salary "
				+"from jobs "
				+"where job_id = ? ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setString(1, jobId);
		ResultSet rs = ptmt.executeQuery();
		if(rs.next()) {
			job = new Job();
			job.setId(rs.getString("job_id"));
			job.setTitle(rs.getString("job_title"));
			job.setMinSalary(rs.getInt("min_salary"));
			job.setMaxSalaty(rs.getInt("max_salary"));
		}
		rs.close();
		ptmt.close();
		connection.close();
		return job;
	}
	/**
	 * 직종의 아이디를 입력받아서 해당하는 직종에 종사하는 사람의 수를 반환한다. 
	 * @param jobId 직종의 아이디
	 * @return 해당하는 직종의 종사하는 사람의 수 
	 * @throws SQLException 데이터 베이스 엑세스 작업중 오류가 발생했을 때
	 */

	public int getJobsCount(String jobId) throws SQLException {
		int countJobEmployees = 0;
		String sql = " select count(*) cnt " 
					+" from jobs J, employees E "
					+" where J.job_id = E.job_id "
					+" and J.job_id = ? ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setString(1, jobId);
		ResultSet rs = ptmt.executeQuery();
		rs.next();
		countJobEmployees = rs.getInt("cnt");
		return countJobEmployees;
	}
	/**
	 * 직종의 아이디를 입력받아서 해당하는 직종에 종사하는 사람의 정보를 반환한다.
	 * @param jobId 직종의 아이디
	 * @return 해당하는 직종에 종사하는 사람의 정보
	 * @throws SQLException 데이터 베이스 엑세스 작업중 오류가 발생했을 때
	 */
	public List<Employee> getEmployeesListById(String jobId) throws SQLException {
		List<Employee> employees = new ArrayList<>();
		String sql = "select E.employee_id, E.first_name, E.Last_name, E.email, E.phone_number,E.hire_date, "
				+"j.job_id, j.job_title, j.min_salary, j.max_salary "
				+"from employees E, jobs j "
				+"where E.job_id = j.job_id "
				+"and j.job_id = ? ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setString(1, jobId);
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()) {
			Employee employee = new Employee();
			employee.setId(rs.getInt("employee_id"));
			employee.setFirstName(rs.getString("first_name"));
			employee.setLastName(rs.getString("Last_name"));
			employee.setEmail(rs.getString("email"));
			employee.setPhoneNumber(rs.getString("phone_number"));
			employee.setHireDate(rs.getDate("hire_date"));
			Job job = new Job();
			job.setId(rs.getString("job_id"));
			job.setTitle(rs.getString("job_title"));
			job.setMinSalary(rs.getInt("min_salary"));
			job.setMaxSalaty(rs.getInt("max_salary"));
			employee.setJob(job);
			employees.add(employee);
		}
		return employees;
	}
	
	public void insertJob (Job job) throws SQLException {
		String sql = "insert into jobs (job_id, job_title, min_salary, max_salary) "
				+"values "
				+"(?, ?, ?, ?) ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setString(1,job.getId());
		ptmt.setString(2, job.getTitle());
		ptmt.setInt(3, job.getMinSalary());
		ptmt.setInt(4, job.getMaxSalaty());
		ptmt.executeUpdate();
		
		ptmt.close();
		connection.close();

	}
}
