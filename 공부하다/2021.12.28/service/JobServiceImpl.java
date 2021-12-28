package com.sample.service;

import java.util.List;

import com.sample.dao.JobDao;
import com.sample.vo.Job;

public class JobServiceImpl implements JobService {

	private JobDao jobDao;
	public void setJobDao(JobDao jobDao) {
		this.jobDao = jobDao;
	}
	@Override
	public void inserNewJob(Job job) {
		Job savedJob = jobDao.getJobById(job.getId());
		if(savedJob != null) {
			throw new RuntimeException("동일한 직종아이디가 이미 등록되어 있습니다.");
		}
		if(job.getMax_salary() <= job.getMin_salary()) {
			throw new RuntimeException("최대 급여는 최소 급여보다 작거나 같을 수 없습니다.");
		}
		jobDao.inserJob(job);
		
	}

	@Override
	public List<Job> getAllJobs() {
		return jobDao.selectAllJobs();
	}

	@Override
	public List<Job> getJobsBySalary(int minSalary, int maxSalary) {
		return jobDao.getJobsBySalary(minSalary, maxSalary);
	}

	@Override
	public Job getJobDetail(String jobId) {
		return jobDao.getJobById(jobId);
	}

}
