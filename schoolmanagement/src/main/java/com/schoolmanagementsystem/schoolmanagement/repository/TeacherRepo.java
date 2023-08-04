package com.schoolmanagementsystem.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoolmanagementsystem.schoolmanagement.entities.Teacher;

public interface TeacherRepo extends JpaRepository<Teacher,Integer>{

}
