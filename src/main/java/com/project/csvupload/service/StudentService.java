package com.project.csvupload.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.csvupload.entity.Student;

public interface StudentService {

	public List<Student> findAll();
	
	public void save(MultipartFile file) ;
	
}
