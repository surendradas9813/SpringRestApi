package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entity.Student;
import com.springrest.springrest.services.StudentService;

@RestController
public class MyController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to the application";
	}
	
	//get students
	@GetMapping("/students")
	public List<Student> getStudents(){
	  return this.studentService.getStudents();
	}
	
	//get particular student
	@GetMapping("/students/{studentId}")
	public Student getCourse(@PathVariable String studentId) {
		return this.studentService.getStudent(Long.parseLong(studentId));
	}
	
	
	//adding Student
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		return this.studentService.addStudent(student);
	}
	
	//updating student
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student student) {
		return this.studentService.updateStudent(student);
	}
	
	@DeleteMapping("/students/{studentId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String studentId){
		try {
			this.studentService.deleteCourse(Long.parseLong(studentId));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
