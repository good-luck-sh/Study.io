package com.sample.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.service.JobService;
import com.sample.vo.Job;

public class JobSelectAllApplication {

	public static void main(String[] args) {
		String resource = "classpath:/spring/context-jdbc.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(resource);
		
		JobService service = ctx.getBean(JobService.class);
		List<Job> jobs = service.getAllJobs();
		for(Job job : jobs) {
			System.out.println("아이디 : " + job.getId());
			System.out.println("이름 : " + job.getTitle());
			System.out.println("최소급여 : " + job.getMin_salary());
			System.out.println("최대급여 : " + job.getMax_salary());
		}
	}
}
