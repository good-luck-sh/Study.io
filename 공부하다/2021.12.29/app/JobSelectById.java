package com.sample.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.service.JobService;
import com.sample.vo.Job;

public class JobSelectById {

	public static void main(String[] args) {
		String resource = "classpath:/spring/context-jdbc.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(resource);
		
		JobService service = ctx.getBean(JobService.class);
		Job job = service.getJobDetail("PU_CLERK");
		System.out.println("아이디 : " + job.getId());
		System.out.println("이름 : " + job.getTitle());
		System.out.println("최소급여 : " + job.getMin_salary());
		System.out.println("최대급여 : " + job.getMax_salary());
	}
}
