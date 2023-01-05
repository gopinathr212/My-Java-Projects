package com.advento.teacher.service;


import java.util.Map;
import java.util.SortedSet;

import com.advento.teacher.dto.TeachermsDTO;


public interface TeachermsService {

	public SortedSet <TeachermsDTO> getAllTeacher();
	
	public Map<Integer,SortedSet<TeachermsDTO>> getAllTeacherByHeight(int height);
	
	public Map<Long, SortedSet<TeachermsDTO>> getAllTeacherBySalary(int Salary) ;
	
	public void CreateTeacher(TeachermsDTO TeacherDTO);
}
