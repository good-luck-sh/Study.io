package com.sample.dao;

import java.util.List;

import com.sample.vo.Job;

public interface JobDao {
	
	/**
	 * 입력받은 직업을 추가한다.
	 * @param job
	 */
	void inserJob(Job job);
	/**
	 * 입력받은 직업을 수정한다.
	 * @param job
	 */
	void updateJob(Job job);
	/**
	 * 직업에 대해서 전체적으로 조회한다.
	 * @return 직업 목록 전체
	 */
	List<Job> selectAllJobs();
	
	/**
	 * 조회를 원하는 직업 아이디를 입력받고, 해당하는 직업에 대한 상세정보를 제공한다.
	 * @param id 직업 아이디
	 * @return 해당하는 직업의 상세정보
	 */
	Job getJobById(String id);
	
	/**
	 * 직업의 최소급여와 최대급여를 입력받아 해당하는 직업에 대한 상세정보를 출력한다.
	 * @param minSalary 최소급여보다 큰 금액
	 * @param maxSalary 최대급여보다 큰 금액
	 * @return 해당하는 직업의 상세정보
	 */
	List<Job> getJobsBySalary(int minSalary, int maxSalary);
}
