package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentService {
	
	List<Student> getAllStudents();

	void saveStudent(Student student);
	Student getStudentById(long id);
	void deleteStudentById(long id);
}
