package com.project.csvupload.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.csvupload.entity.Student;
import com.project.csvupload.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	/**
	 * @param theModel
	 * @return String which redirects to html page for viewing the list of students which are store in DataBase
	 */
	@GetMapping("/list")
	public String listStudents(Model theModel) {

		List<Student> theStudent = studentService.findAll();

		theModel.addAttribute("students", theStudent);
		return "list-students";
	}

	/**
	 * @param file - csv file which is uploaded from UI. It will check the format of
	 *             file and save the file data in DB with help of student Service
	 *             method
	 * @return ResponseMessage gives message whether the file is uploaded
	 *         successfully or not
	 */
	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";

		if (CSVHelper.hasCSVFormat(file)) {
			try {
				studentService.save(file);

				message = "CSV file Uploaded successfully: " + file.getOriginalFilename();

				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message, "file"));
			} catch (Exception e) {
				message = "Could not upload the csv file: " + file.getOriginalFilename() + "!";
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message, ""));
			}
		}
		message = "Please upload a csv file!";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message, ""));
	}

}
