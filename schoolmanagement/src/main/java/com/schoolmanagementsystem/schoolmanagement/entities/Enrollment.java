package com.schoolmanagementsystem.schoolmanagement.entities;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Enrollment")
public class Enrollment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Enrollmentid")
	private int enrollment_id;

	@Column(name = "Studentid")
	private Integer student_id;

	@Column(name = "Courseid")
	private Integer course_id;

	@Column(name = "Enrollmentdate")
	private Date enrollment_date;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "Studentid", referencedColumnName = "Studentid", updatable = false, insertable = false)
	private Student student;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "Courseid", referencedColumnName = "Courseid", updatable = false, insertable = false)
	private Course course;

	public int getEnrollment_id() {
		return enrollment_id;
	}

	public void setEnrollment_id(int enrollment_id) {
		this.enrollment_id = enrollment_id;
	}

	public Integer getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}

	public Integer getCourse_id() {
		return course_id;
	}

	public void setCourse_id(Integer course_id) {
		this.course_id = course_id;
	}

	public Date getEnrollment_date() {
		return enrollment_date;
	}

	public void setEnrollment_date(Date enrollment_date) {
		this.enrollment_date = enrollment_date;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}


}
