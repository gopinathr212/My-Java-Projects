package com.advento.teacher.service;


import java.util.Map;
import java.util.SortedSet;

import com.advento.teacher.dto.TeachermsDTO;


public interface TeachermsService {

	public SortedSet <TeachermsDTO> getAllTeacher(int height,int salary);
	
	
	public void CreateTeacher(TeachermsDTO teacherDTO);
	
	public TeachermsDTO getTeacher(int teacherid) ;
	
	public void DeleteTeacher(int tecaherid) ;
	
	public void UpdateTeacher(TeachermsDTO teacherDTO,int teacherid) ;
}
