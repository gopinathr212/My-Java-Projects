package com.advento.teacher.controller;


import java.util.Map;
import java.util.SortedSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.advento.teacher.dto.TeachermsDTO;
import com.advento.teacher.service.TeachermsService;


@RestController
public class TeacherController {
	private Logger LOGGER = LogManager.getLogger(TeacherController.class);


	@Autowired
	@Qualifier(value = "teachermsServiceImpl")
	private TeachermsService teacherService;
	
	@GetMapping(value = "/teachers")
	public ResponseEntity<SortedSet<TeachermsDTO>> getAllTeacher(
			@RequestParam(value="heightval", required=false) Integer heightVal,
			@RequestParam(value="salaryval", required=false) Integer salaryVal) {
		int height = (heightVal != null) ? heightVal:0;
		int salary = (salaryVal != null) ? salaryVal:0;
		SortedSet<TeachermsDTO> teacherDTOs = teacherService.getAllTeacher(height,salary);
		ResponseEntity<SortedSet<TeachermsDTO>> response = new ResponseEntity<SortedSet<TeachermsDTO>>(teacherDTOs, HttpStatus.OK);
		LOGGER.info(response);
		return response;
	}
	
	
	
	@GetMapping(value  = "/teachers/{teacherid}")
	public ResponseEntity<TeachermsDTO> getTeacherById(@PathVariable(value="teacherid") int teacherid) {
		TeachermsDTO teacherDTOs = teacherService.getTeacher(teacherid);
		ResponseEntity<TeachermsDTO>  response = new ResponseEntity<TeachermsDTO> (teacherDTOs,HttpStatus.OK);
		LOGGER.info(response);
		return response;
	}
	

	
	@PostMapping(value  = "/createteacher")
	public ResponseEntity<Void> createTeacher(@RequestBody TeachermsDTO teacherDTO) {
		teacherService.CreateTeacher(teacherDTO);
		ResponseEntity<Void> response = new ResponseEntity<Void>(HttpStatus.CREATED);
		LOGGER.info(response);
		return response;
	}
	
	@DeleteMapping(value  = "/teachers/{teacherid}")
	public ResponseEntity<Void> DeleteTeacher(@PathVariable(value="teacherid") int teacherid) {
		teacherService.DeleteTeacher(teacherid);
		ResponseEntity<Void> response = new ResponseEntity<Void>(HttpStatus.OK);
		LOGGER.info(response);
		return response;
	}
	
	@PutMapping(value  = "/teachers/{teacherid}")
	public ResponseEntity<Void> UpdateTeacher(@RequestBody TeachermsDTO teacherDTO,@PathVariable(value="teacherid") int teacherid) {
		teacherService.UpdateTeacher(teacherDTO,teacherid);
		ResponseEntity<Void> response = new ResponseEntity<Void>(HttpStatus.CREATED);
		LOGGER.info(response);
		return response;
	}
}
