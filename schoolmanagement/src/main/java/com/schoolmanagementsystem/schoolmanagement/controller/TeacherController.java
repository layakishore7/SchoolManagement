package com.schoolmanagementsystem.schoolmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmanagementsystem.schoolmanagement.entities.Teacher;
import com.schoolmanagementsystem.schoolmanagement.repository.TeacherRepo;

@RestController
public class TeacherController {
	
	@Autowired
	TeacherRepo teacherRepo;


	@GetMapping("/teachers")
	public List<Teacher> getAllTeachers() {
		return teacherRepo.findAll();
	}
}
