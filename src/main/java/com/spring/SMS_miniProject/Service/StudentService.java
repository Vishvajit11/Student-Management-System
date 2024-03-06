package com.spring.SMS_miniProject.Service;

import java.util.List;

import com.spring.SMS_miniProject.Model.Student;

public interface StudentService {

	List<Student> fetchAllStudents();
	
	Student saveStd(Student student);
	
	Student updateStudent(Student student);
	
	Student getStudentById(Long id);
	
	void deleteStudent(Long id);
}
