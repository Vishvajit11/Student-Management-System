package com.spring.SMS_miniProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.SMS_miniProject.Model.Student;
import com.spring.SMS_miniProject.Repository.StudentRepository;

@SpringBootApplication
public class SmsMiniProjectApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SmsMiniProjectApplication.class, args);
	}

	@Autowired
	private StudentRepository stdRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
//		Student std1 = new Student("Gaurav","Telu","gt1001@gamil.com");
//		stdRepo.save(std1);
//		
//		Student std2 = new Student("Shiv","Nikam","nikam@gamil.com");		
//		stdRepo.save(std2);
//		
//		Student std3 = new Student("yash","Kale","kale007@gamil.com");		
//		stdRepo.save(std3);

		
		 

	}

}
