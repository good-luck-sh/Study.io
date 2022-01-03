package com.sample.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sample.form.JobInsertModifyForm;
import com.sample.service.JobService;
import com.sample.vo.Job;

@Controller
@RequestMapping("/job")
public class JobController {
	
	@Autowired
	JobService jobService;

	@GetMapping("/list.do")
	public String list(Model model) {
		List<Job> jobs = jobService.getAllJobs();
		model.addAttribute("job", jobs);
		return "job/list.jsp";
	}
	
	@GetMapping("/insert.do")
	public String form(Model model) {
		List<Job> jobs = jobService.getAllJobs();
		model.addAttribute("job", jobs);
		return "job/form.jsp";
	}
	
	@PostMapping("/insert.do")
	public String insert(JobInsertModifyForm jobForm) {
		Job job = new Job();
		BeanUtils.copyProperties(jobForm, job);
		jobService.insertJob(job);
		return "redirect:list.do";
	}
	
	@GetMapping("/modify.do")
	public String formForm(RedirectAttributes ra) {
		List<Job> minJobs = jobService.getJobByMinSalary();
		List<Job> maxJobs = jobService.getJobByMaxSalary();
		ra.addAttribute("minJobs",minJobs);
		ra.addAttribute("maxJobs", maxJobs);
		return "job/modifyform.jsp";
	}
	
	@PostMapping("/modify.do")
	public String modify(JobInsertModifyForm jobForm) {
		Job job = new Job();
		BeanUtils.copyProperties(jobForm, job);
		jobService.updateJob(job);
		return "redirect:list.do";
	}
	
}
