package com.advento.teacher.utilis;

import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import com.advento.teacher.dto.TeachermsDTO;

public class UtilisForTeacherms {

	public static void addTeacherMapByHei(Map<Integer,SortedSet<TeachermsDTO>> mapofTeacher,TeachermsDTO teachermsDTO) {
		int height = teachermsDTO.getHeight();
		if (mapofTeacher.containsKey(height)) {
			SortedSet<TeachermsDTO> newValSortSet = mapofTeacher.get(height);
			newValSortSet.add(teachermsDTO);
		}
		else {
			SortedSet<TeachermsDTO> TeachetSorSet = new TreeSet<>();
			TeachetSorSet.add(teachermsDTO);
			mapofTeacher.put(height, TeachetSorSet);
		}
	}
	
	public static void addTeacherMapBySal(Map<Long,SortedSet<TeachermsDTO>> mapofTeacher,TeachermsDTO teachermsDTO) {
		long salary = teachermsDTO.getSalary();
		if (mapofTeacher.containsKey(salary)) {
			SortedSet<TeachermsDTO> newValSortSet = mapofTeacher.get(salary);
			newValSortSet.add(teachermsDTO);
		}
		else {
			SortedSet<TeachermsDTO> TeachetSorSet = new TreeSet<>();
			TeachetSorSet.add(teachermsDTO);
			mapofTeacher.put(salary, TeachetSorSet);
		}
	}
}
