package com.ty.bootcarwaleapp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	StudentRepository studentRepository;

	@PostMapping("/saveStudent")
	public Student saveStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}

	@PostMapping("/allstudent")
	public List<Student> allStudent() {
		return studentRepository.findAll();
	}

	@PostMapping("/getstudentbyid/{id}")
	public Student getStudentById(@PathVariable int id) {
		Optional<Student> optional = studentRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return optional.get();
		}
	}

	@PostMapping("/deletestudent")
	public Student deleteStudent(@RequestParam int id) {
		Optional<Student> optional = studentRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			Student student = studentRepository.getById(id);
			studentRepository.delete(student);
			return student;
		}

	}

	@PostMapping("/updatestudent/{id}")
	public Student updateStudent(@RequestBody Student student, @PathVariable int id) {
		Optional<Student> optional = studentRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return studentRepository.save(student);

		}
	}

}
