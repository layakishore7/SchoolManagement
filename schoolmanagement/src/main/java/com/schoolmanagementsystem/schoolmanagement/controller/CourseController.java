package com.schoolmanagementsystem.schoolmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmanagementsystem.schoolmanagement.entities.Course;
import com.schoolmanagementsystem.schoolmanagement.repository.CourseRepo;

@RestController
public class CourseController {

	@Autowired
	CourseRepo courseRepo;

	@GetMapping("/getshedule")
	public List<Course> viewShedule(@RequestParam("teacher_id") Integer teacher_id) {
		return courseRepo.getShedule(teacher_id);
	}

}
