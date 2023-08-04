package com.schoolmanagementsystem.schoolmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.schoolmanagementsystem.schoolmanagement.entities.Enrollment;
import com.schoolmanagementsystem.schoolmanagement.repository.EnrollmentRepo;
import com.schoolmanagementsystem.schoolmanagement.repository.StudentRepo;

@RestController
public class EnrollmentController {

	@Autowired
	EnrollmentRepo enrollmentRepo;

	@Autowired
	StudentRepo studentRepo;

//	@PostMapping("/newenrollment")
//	public void enrollCourse(@RequestParam("student_id") Integer student_id,
//			@RequestParam("course_id") Integer course_id) {
//		int enrollmentid = enrollmentRepo.max();
//        LocalDate date = LocalDate.now();
//		Enrollment enroll = new Enrollment();
//		enroll.setEnrollment_id(enrollmentid);
//		enroll.setStudent_id(student_id);
//		enroll.setCourse_id(course_id);
//		enroll.setEnrollment_date(Date.valueOf(date));
//		enrollmentRepo.save(enroll);
//	}

	@PostMapping("/newenrollment")
	public Enrollment enrollCourse(@RequestBody Enrollment enrollments) {

		var a = enrollmentRepo.findById(enrollments.getEnrollment_id());
		if (a.isPresent()) {
			throw new ResponseStatusException(HttpStatus.IM_USED, "Already present");
		} else {
			enrollmentRepo.save(enrollments);
			return enrollments;
		}

	}
	
	public void updateEnrollment(@RequestBody Enrollment enrollments) {
		 var a = enrollmentRepo.findById(enrollments.getEnrollment_id());
		 if(a.isPresent()) {
			 enrollmentRepo.save(enrollments);
		 } else {
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Enrollment id not found");
		 }
	}

}
