package com.advento.teacher.controller;


import java.util.Map;
import java.util.SortedSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.advento.teacher.dto.TeachermsDTO;
import com.advento.teacher.service.TeachermsService;


@RestController
public class TeacherController {

	@Autowired
	@Qualifier(value = "teachermsServiceImpl")
	private TeachermsService teacherService;
	
	@GetMapping(value = "/teachers")
	public ResponseEntity<SortedSet<TeachermsDTO>> getAllTeacher() {
		SortedSet<TeachermsDTO> teacherDTOs = teacherService.getAllTeacher();
		ResponseEntity<SortedSet<TeachermsDTO>> response = new ResponseEntity<SortedSet<TeachermsDTO>>(teacherDTOs, HttpStatus.OK);
		return response;
	}
	
	@GetMapping(value  = "/teachersbyhei/{heightVal}")
	public ResponseEntity<Map<Integer,SortedSet<TeachermsDTO>>> getTeacherByHeight(@PathVariable(value="heightVal") int heightVal) {
		Map<Integer,SortedSet<TeachermsDTO>> teacherDTOs = teacherService.getAllTeacherByHeight(heightVal);
		ResponseEntity<Map<Integer,SortedSet<TeachermsDTO>>> response = new ResponseEntity<Map<Integer,SortedSet<TeachermsDTO>>>(teacherDTOs,HttpStatus.OK);
		return response;
	}
	
	@GetMapping(value  = "/teachersbysal/{salaryVal}")
	public ResponseEntity<Map<Long,SortedSet<TeachermsDTO>>> getTeacherBySalary(@PathVariable(value="salaryVal") int salaryVal) {
		Map<Long,SortedSet<TeachermsDTO>> teacherDTOs = teacherService.getAllTeacherBySalary(salaryVal);
		ResponseEntity<Map<Long,SortedSet<TeachermsDTO>>> response = new ResponseEntity<Map<Long,SortedSet<TeachermsDTO>>>(teacherDTOs,HttpStatus.OK);
		return response;
	}
	
	@PostMapping(value  = "/teachers")
	public ResponseEntity<Void> CreateStudent(@RequestBody TeachermsDTO teacherDTO) {
		teacherService.CreateTeacher(teacherDTO);
		ResponseEntity<Void> response = new ResponseEntity<Void>(HttpStatus.CREATED);
		return response;
	}
}
