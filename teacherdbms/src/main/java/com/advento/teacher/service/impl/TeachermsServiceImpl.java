package com.advento.teacher.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

import com.advento.teacher.dto.TeachermsDTO;
import com.advento.teacher.service.TeachermsService;
import com.advento.teacher.utilis.UtilisForTeacherms;

@Service(value = "teachermsServiceImpl")
public class TeachermsServiceImpl implements TeachermsService {


	@Override
	public SortedSet<TeachermsDTO> getAllTeacher() {
		SortedSet<TeachermsDTO> teachermsDTO = new TreeSet<TeachermsDTO>();
		try {
			Connection conn = connnectionObj();
			// Create Statement
			Statement stmt = conn.createStatement();
			// Execute Query
			ResultSet rs = stmt.executeQuery("select * from teacher_details ");
			// iterate the Resultset
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				int height = rs.getInt("height");
				long salary = rs.getLong("salary");
				String email = rs.getString("email");
				TeachermsDTO teacherDTO = createEmployeeObj(id, name, age, height, salary, email);
				teachermsDTO.add(teacherDTO);
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return teachermsDTO;
	}

	@Override
	public Map<Integer, SortedSet<TeachermsDTO>> getAllTeacherByHeight(int heightVal) {
		Map<Integer, SortedSet<TeachermsDTO>> mapofTeacher = new HashMap<>();
		try {
			Connection conn = connnectionObj();
			// Create Statement
			Statement stmt = conn.createStatement();
			// Execute Query
			ResultSet rs = stmt.executeQuery("select * from teacher_details where height=" + heightVal);
			// iterate the Resultset
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				int height = rs.getInt("height");
				long salary = rs.getLong("salary");
				String email = rs.getString("email");
				TeachermsDTO teacherDTO = createEmployeeObj(id, name, age, height, salary, email);
				UtilisForTeacherms.addTeacherMapByHei(mapofTeacher, teacherDTO);
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return mapofTeacher;
	}
	
	@Override
	public Map<Long, SortedSet<TeachermsDTO>> getAllTeacherBySalary(int SalaryVal) {
		Map<Long, SortedSet<TeachermsDTO>> mapofTeacher = new HashMap<>();
		try {
			Connection conn = connnectionObj();
			// Create Statement
			Statement stmt = conn.createStatement();
			// Execute Query
			ResultSet rs = stmt.executeQuery("select * from teacher_details where salary=" + SalaryVal);
			// iterate the Resultset
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				int height = rs.getInt("height");
				long salary = rs.getLong("salary");
				String email = rs.getString("email");
				TeachermsDTO teacherDTO = createEmployeeObj(id, name, age, height, salary, email);
				UtilisForTeacherms.addTeacherMapBySal(mapofTeacher, teacherDTO);
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return mapofTeacher;
	}
	
	@Override
	public void CreateTeacher(TeachermsDTO teacherDTO) {
		try {
			//Load the Driver
			Connection conn = connnectionObj();
			//Create Statement
			PreparedStatement pStmt = conn.prepareStatement
					("insert into teacher_details (name, age, height, salary, email) values (?, ?, ?, ?, ?)");
			pStmt.setString(1, teacherDTO.getName());
			pStmt.setInt(2, teacherDTO.getAge());
			pStmt.setInt(3, teacherDTO.getHeight());
			pStmt.setLong(4, teacherDTO.getSalary());
			pStmt.setString(5, teacherDTO.getEmail());
			//Execute Query
			boolean insertStatus = pStmt.execute();
			System.out.println("insertStatus--->"+insertStatus);
//			int i = 0;
		} 
		catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private TeachermsDTO createEmployeeObj(int id, String name, int age, int height, long salary, String email) {
		TeachermsDTO teacherDTO = new TeachermsDTO();
		teacherDTO.setId(id);
		teacherDTO.setName(name);
		teacherDTO.setAge(age);
		teacherDTO.setHeight(height);
		teacherDTO.setSalary(salary);
		teacherDTO.setEmail(email);
		return teacherDTO;
	}

	private Connection connnectionObj() throws ClassNotFoundException, SQLException {
		// Load the Driver
		Class.forName("com.mysql.jdbc.Driver");
		// Establish the connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/teachermsdb", "root", "root");
		return conn;
	}
}
