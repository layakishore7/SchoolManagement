package com.schoolmanagementsystem.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.schoolmanagementsystem.schoolmanagement.entities.Enrollment;

public interface EnrollmentRepo extends JpaRepository<Enrollment,Integer> {
	

	@Query("select max(e.enrollment_id) from Enrollment e")
	int max();

}
