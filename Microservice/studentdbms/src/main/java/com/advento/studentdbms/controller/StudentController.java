package com.advento.studentdbms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.advento.studentdbms.dto.StudentDTO;
import com.advento.studentdbms.service.StudentService;



@RestController
public class StudentController {

	@Autowired
	@Qualifier(value = "studentServiceImpl")
	private StudentService studentService;
     
	@GetMapping(value  = "/getallstudent/{studentid}")
	public ResponseEntity<StudentDTO> getStudent(@PathVariable(value="studentid") int studentid) {
		StudentDTO studentDTO = studentService.getStudent(studentid);
		ResponseEntity<StudentDTO> response = new ResponseEntity<StudentDTO>(studentDTO,HttpStatus.OK);
		return response;
	}
	
	@GetMapping(value = "/getallstudent")
	public ResponseEntity<StudentDTO[]> getAllStudent() {
		StudentDTO[] studentDTO = studentService.getAllStudents();
		ResponseEntity<StudentDTO[]> responseEntity = new ResponseEntity<StudentDTO[]>(studentDTO, HttpStatus.OK);
		return responseEntity;
	}
	
	@PostMapping(value  = "/getallstudent")
	public ResponseEntity<Void> CreateStudent(@RequestBody StudentDTO studentDTO) {
		studentService.CreateStudent(studentDTO);
		ResponseEntity<Void> response = new ResponseEntity<Void>(HttpStatus.CREATED);
		return response;
	}
	
	@PutMapping(value  = "/getallstudent/{studentid}")
	public ResponseEntity<Void> UpdateStudent(@RequestBody StudentDTO studentDTO,@PathVariable(value="studentid") int studentid) {
		studentService.UpdateStudent(studentDTO,studentid);
		ResponseEntity<Void> response = new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		return response;
	}
	
	@PatchMapping(value  = "/getallstudent/{studentid}")
	public ResponseEntity<Void> PatchStudent(@RequestBody StudentDTO studentDTO,@PathVariable(value="studentid") int studentid) {
		studentService.PatchStudent(studentDTO,studentid);
		ResponseEntity<Void> response = new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		return response;
	}
	
	@DeleteMapping(value  = "/getallstudent/{studentid}")
	public ResponseEntity<Void> DeleteStudent(@PathVariable(value="studentid") int studentid) {
		studentService.DeleteStudent(studentid);
		ResponseEntity<Void> response = new ResponseEntity<Void>(HttpStatus.OK);
		return response;
	}
}
