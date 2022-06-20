package com.springrest.springrest.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.StudentDao;
import com.springrest.springrest.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	
	@Autowired
	private StudentDao studentDao;
	
	public StudentServiceImpl() {
		
		}

	@Override
	public List<Student> getStudents() {
		return studentDao.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Student getStudent(long studentId) {
		
		return studentDao.getById(studentId);
	}

	@Override
	public Student addStudent(Student student) {
		studentDao.save(student);
		return student;
	}

	@Override
	public Student updateStudent(Student student) {
		studentDao.save(student);
		return student;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void deleteCourse(long studentId) {
		
		Student entity = studentDao.getById(studentId);
		studentDao.delete(entity);
	}

}
