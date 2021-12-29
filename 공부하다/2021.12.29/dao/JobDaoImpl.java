package com.sample.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.sample.vo.Job;

public class JobDaoImpl implements JobDao {

	private JdbcTemplate template;
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	public void inserJob(Job job) {
		String sql = "insert into jobs"
				+ "(job_id, job_title, min_salary, max_salary) "
				+ "values "
				+ "(?,  ?, ?, ?) ";
		template.update(sql, job.getId(), job.getTitle(), job.getMin_salary(), job.getMax_salary());
		
	}

	@Override
	public void updateJob(Job job) {
		String sql ="update jobs "
				+ "set "
				+ "min_salary = ? "
				+ "max_salary = ? "
				+ "where job_id  = ?"; 
		template.update(sql, job.getMin_salary(), job.getMax_salary());
	}

	@Override
	public List<Job> selectAllJobs() {
		String sql = "select job_id, job_title, min_salary, max_salary "
				+ "from jobs ";
		return template.query(sql, new JobRowMapper());
	}
	/*
	 * return template.query(sql, new RowMapper<Job>(){
	 *	@Override
	 * public Job mapRow(ResultSet rs, int rowNum)thorws SQLException{
	 *  	//익명객체를 이용해서 작성할 수 있다.
	 *  	Job job = new Job(); 
			job.setId(rs.getString("job_id"));
			job.setTitle(rs.getString("job_title"));
			job.setMin_salary(rs.getInt("min_salary"));
			job.setMax_salary(rs.getInt("max_salary"));
			return job; 
	 * }
	 * })
	 */

	@Override
	public Job getJobById(String id) {
		String sql = "select job_id, job_title, min_salary, max_salary "
				+ "from jobs "
				+ "where job_id = ? ";
		return template.queryForObject(sql, (rs, rownum) -> {
			Job job = new Job(); 
			job.setId(rs.getString("job_id"));
			job.setTitle(rs.getString("job_title"));
			job.setMin_salary(rs.getInt("min_salary"));
			job.setMax_salary(rs.getInt("max_salary"));
			return job; 	
		} , id);
		//람다식으로 작성했다.
	}

	@Override
	public List<Job> getJobsBySalary(int minSalary, int maxSalary) {
		String sql = "select job_id, job_title, min_salary, max_salary "
				+ "from jobs "
				+ "where min_salary >= ? "
				+ "and max_salary >= ? ";
		return template.query(sql, new JobRowMapper(), minSalary, maxSalary);
	}
	
	public class JobRowMapper implements RowMapper<Job> {

		@Override
		public Job mapRow(ResultSet rs, int rowNum) throws SQLException {
			Job job = new Job(); 
			job.setId(rs.getString("job_id"));
			job.setTitle(rs.getString("job_title"));
			job.setMin_salary(rs.getInt("min_salary"));
			job.setMax_salary(rs.getInt("max_salary"));
			return job;
		}
		
	}
}
