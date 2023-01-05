package com.advento.studentdbms.service;

import com.advento.studentdbms.dto.StudentDTO;

public interface StudentService {
      
    public StudentDTO getStudent(int studentid);
	
	public StudentDTO[] getAllStudents();
	
	public void CreateStudent(StudentDTO studentDTO);
	
	public void UpdateStudent(StudentDTO studentDTO,int studentid);
	
	public void DeleteStudent(int studentid);
	
	public void PatchStudent(StudentDTO studentDTO,int studentid);
}
