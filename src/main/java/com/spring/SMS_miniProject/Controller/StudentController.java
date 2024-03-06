package com.spring.SMS_miniProject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.SMS_miniProject.Model.Student;
import com.spring.SMS_miniProject.Service.StudentService;

@Controller
public class StudentController {

	private StudentService stdService;

	public StudentController(StudentService stdService) {
		super();
		this.stdService = stdService;
	}

	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students_key", stdService.fetchAllStudents());
		return "students"; // "students" is view resolver
	}

//	In Spring MVC, a view resolver is responsible for mapping view names returned by controller methods to actual view templates or resources. When a controller method returns a view name, the view resolver interprets this name and resolves it to the corresponding view template.
//
//	There are different types of view resolvers available in Spring MVC, but the two most commonly used are:
//
//	InternalResourceViewResolver: This view resolver is typically used for resolving JSP view templates. It maps logical view names to physical JSP files in the web application's directory structure.
//
//	ThymeleafViewResolver: Thymeleaf is a modern server-side Java template engine for web and standalone environments. ThymeleafViewResolver resolves view names to Thymeleaf template files.
//	

	@GetMapping("/students/new")
	public String createStudentForm(Model model)
	{
		Student std = new Student();
		model.addAttribute("student", std);
		
		return "create_student";
	}
	
	
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student)
	{
		stdService.saveStd(student);
		return "redirect:/students" ;
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable Long id , Model model)
	{
		model.addAttribute("student", stdService.getStudentById(id));
		return "edit_student";
	} 
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("form-data") Student student) {
		
		// get student from database by id and update
		Student existingStudent = stdService.getStudentById(id);
		
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		// now save this into database
		stdService.updateStudent(existingStudent);
		
		return "redirect:/students";
	}
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id)
	{
		stdService.deleteStudent(id);
		return "redirect:/students";
	}
	
}
