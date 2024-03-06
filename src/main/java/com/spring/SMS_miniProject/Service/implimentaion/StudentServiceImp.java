package com.spring.SMS_miniProject.Service.implimentaion;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.SMS_miniProject.Model.Student;
import com.spring.SMS_miniProject.Repository.StudentRepository;
import com.spring.SMS_miniProject.Service.StudentService;

@Service
public class StudentServiceImp implements StudentService{

	private StudentRepository studentRespo;
	
	public StudentServiceImp(StudentRepository studentRespo) {
		super();
		this.studentRespo = studentRespo;
	}

	@Override
	public List<Student> fetchAllStudents() {
		return studentRespo.findAll();
	}

	@Override
	public Student saveStd(Student student) {
		return studentRespo.save(student);
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRespo.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRespo.findById(id).get();
	}

	@Override
	public void deleteStudent(Long id) {
		studentRespo.deleteById(id);
	}

}
