package com.schoolmanagementsystem.schoolmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.schoolmanagementsystem.schoolmanagement.entities.Student;
import com.schoolmanagementsystem.schoolmanagement.repository.StudentRepo;

@RestController
//@CrossOrigin
public class StudentController {

	@Autowired
	StudentRepo studentRepo;

	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	@PostMapping("/newstudent")
	public Student newStudent(@RequestBody Student students) {
		var a = studentRepo.findById(students.getStudent_id());
		if (a.isPresent()) {
			throw new ResponseStatusException(HttpStatus.IM_USED, "Already present");
		} else {
			studentRepo.save(students);
			return students;
		}
	}

	@PutMapping("/updatestudent")
	public void updateStudent(@RequestBody Student students) {
		var a = studentRepo.findById(students.getStudent_id());
		if (a.isPresent()) {
			studentRepo.save(students);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
		}
	}

	@DeleteMapping("/deletestudent")
	public void DeleteStudentById(@RequestParam("student_id") Integer student_id) {
		var a = studentRepo.findById(student_id);
		if (a.isPresent()) {
			studentRepo.deleteById(student_id);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
		}
	}

}
