package com.project.csvupload.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.csvupload.controller.CSVHelper;
import com.project.csvupload.dao.StudentRepository;
import com.project.csvupload.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;

	@Autowired
	public StudentServiceImpl(StudentRepository theStudentRepository) {
		studentRepository = theStudentRepository;
	}

	/**
	 * This method will help us to show the result in UI from DataBase
	 */
	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	/**
	 * This method will help us to save the file data into DataBase
	 */
	@Override
	public void save(MultipartFile file) {
		try {
			List<Student> tutorials = CSVHelper.csvToList(file.getInputStream());
			studentRepository.saveAll(tutorials);
		} catch (IOException e) {
			throw new RuntimeException("fail to store csv data: " + e.getMessage());
		}
	}

}
