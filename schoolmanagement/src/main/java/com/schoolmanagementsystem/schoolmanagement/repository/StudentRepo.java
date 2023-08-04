package com.schoolmanagementsystem.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoolmanagementsystem.schoolmanagement.entities.Student;

public interface StudentRepo extends JpaRepository<Student,Integer>{
	

}
