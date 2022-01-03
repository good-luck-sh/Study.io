package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dao.JobDao;
import com.sample.vo.Job;

@Service
public class JobService {

	@Autowired
	JobDao jobDao;
	
	public List<Job> getAllJobs(){
		List<Job> jobList = jobDao.getAllJobs();
		return jobList;
	}
	public void insertJob(Job job) {
		jobDao.insertJob(job);
	} 
	public void updateJob(Job job) {
		jobDao.updateJob(job);
	}
	public List<Job> getJobByMinSalary(){
		List<Job> jobs = jobDao.getJobByMinSalary();
		return jobs;
	}
	public List<Job> getJobByMaxSalary(){
		List<Job> jobs = jobDao.getJobByMaxSalary();
		return jobs;
 	}
}
