package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<Student>();
		studentRepository.findAll().forEach(students::add);
		return students;
	}
	
	public Optional<Student> getStudent(long id) {
		return studentRepository.findById(id);
	}
	
	public void addStudent(Student student) {
		studentRepository.save(student);
	}
	
	public Optional<Student> deleteStudent(long id) {
		Optional<Student> student = studentRepository.findById(id);
		studentRepository.deleteById(id);
		return student;
	}
	
}
