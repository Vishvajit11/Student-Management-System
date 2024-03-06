package com.spring.SMS_miniProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.SMS_miniProject.Model.Student;

public interface StudentRepository extends JpaRepository<Student , Long>{

}
