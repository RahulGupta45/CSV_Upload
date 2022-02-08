package com.project.csvupload.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.csvupload.entity.Student;
import com.project.csvupload.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private StudentService studentService;
	
	@Autowired
	public StudentRestController(StudentService theStudentService) {
		studentService = theStudentService;
	}
	
	// expose "/employees" and return list of employees
	@GetMapping("/students")
	public List<Student> findAll() {
		return studentService.findAll();
	}

	// add mapping for GET /employees/{employeeId}
	
	/*
	 * @GetMapping("/employees/{employeeId}") public Student
	 * getEmployee(@PathVariable int employeeId) {
	 * 
	 * Student theEmployee = employeeService.findById(employeeId);
	 * 
	 * if (theEmployee == null) { throw new
	 * RuntimeException("Employee id not found - " + employeeId); }
	 * 
	 * return theEmployee; }
	 */

}










