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
public class TeacherController {

	@Autowired
	TeacherRepository teacherRepository;

	@PostMapping("/saveteacher")
	public Teacher saveTeacher(@RequestBody Teacher teacher) {
		return teacherRepository.save(teacher);
	}

	@PostMapping("/allteacher")
	public List<Teacher> allTeacher() {
		return teacherRepository.findAll();
	}

	@PostMapping("/getteacherbyid/{id}")
	public Teacher getTeacherById(@PathVariable int id) {
		Optional<Teacher> optional = teacherRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return optional.get();
		}
	}

	@PostMapping("/deleteteacher")
	public Teacher deleteTeacher(@RequestParam int id) {
		Optional<Teacher> optional = teacherRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			Teacher teacher = teacherRepository.getById(id);
			teacherRepository.delete(teacher);
			return teacher;
		}

	}

	@PostMapping("/updateteacher/{id}")
	public Teacher updateTeacher(@RequestBody Teacher teacher, @PathVariable int id) {
		Optional<Teacher> optional = teacherRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return teacherRepository.save(teacher);

		}
	}
}
