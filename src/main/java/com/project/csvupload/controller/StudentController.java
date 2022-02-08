package com.project.csvupload.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.project.csvupload.entity.Student;
import com.project.csvupload.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	// load employee data
	
	private StudentService studentService;
	
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	// add mapping for "/list"

	@GetMapping("/list")
	public String listStudents(Model theModel) {
		
		List<Student> theStudent = studentService.findAll();
		
		// add to the spring model
		theModel.addAttribute("students", theStudent);
		return "list-students";
	}
}









