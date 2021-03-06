package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entity.Student;

public interface StudentService {

	public List<Student> getStudents();
	
	public Student getStudent(long studentId);
	
	public Student addStudent(Student student);
	
	public Student updateStudent(Student student);
	
	public void deleteCourse(long studentId);
	
	public void softDeleteCourse(long studentId);
}
