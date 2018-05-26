package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping(value = "/rest/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@CrossOrigin
	@RequestMapping(value = "/", method = RequestMethod.GET)
	private List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
	
	/*@RequestMapping(value = "/", method = RequestMethod.POST)
	private Student addStudent(@RequestParam(value = "name") String name, 
						@RequestParam(value = "subject", defaultValue = "unknown") String subject) {
		Student student = new Student(name, subject);
		StudentApplication.hmStudent.put(student.getId(), student);
		return student;
	}*/
	
	@CrossOrigin
	@RequestMapping(value = "/", method = RequestMethod.POST)
	private Student addStudent(@RequestBody Student student) {
		studentService.addStudent(student);
		return student;
	}
	
	/*@RequestMapping(value = "/", method = RequestMethod.PUT)
	private Student updateStudent(@RequestBody Student student) throws Exception {
		if (StudentApplication.hmStudent.containsKey(student.getId())) {
			StudentApplication.hmStudent.put(student.getId(), student);
		} else {
			throw new Exception("Student " + student.getId() + "does not exists..!!");
		}
		return student;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	private Student deleteStudent(@PathVariable long id) throws Exception {
		if (StudentApplication.hmStudent.containsKey(id)) {
			student = StudentApplication.hmStudent.get(id);
			StudentApplication.hmStudent.remove(id);
		} else {
			throw new Exception("Student " + id + "does not exists..!!");
		}
		return student;
	}*/
	
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	private Optional<Student> getStudent(@PathVariable long id) throws Exception {
		return studentService.getStudent(id);
	}
	
}
