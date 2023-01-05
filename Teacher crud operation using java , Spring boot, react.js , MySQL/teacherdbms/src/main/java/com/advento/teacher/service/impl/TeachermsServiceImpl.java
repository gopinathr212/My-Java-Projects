package com.advento.teacher.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.advento.teacher.dto.TeachermsDTO;
import com.advento.teacher.exception.InvalidException;
import com.advento.teacher.service.TeachermsService;

@Service(value = "teachermsServiceImpl")
public class TeachermsServiceImpl implements TeachermsService {

	private Logger LOGGER = LogManager.getLogger(TeachermsServiceImpl.class);

	@Override
	public SortedSet<TeachermsDTO> getAllTeacher(int heightVal, int salaryVal) {
		SortedSet<TeachermsDTO> teachermsDTO = new TreeSet<TeachermsDTO>();
		try {
			Connection conn = connnectionObj();
			// Create Statement
			Statement stmt = conn.createStatement();
			String getTeacherQry = "select * from teacher_details where 1=1";
			if(heightVal > 0) {
				getTeacherQry = getTeacherQry + " and height ="+heightVal;
			}
			if(salaryVal > 0) {
				getTeacherQry = getTeacherQry + " and salary ="+salaryVal;
			}
			// Execute Query
			ResultSet rs = stmt.executeQuery(getTeacherQry);
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
				LOGGER.info("teacherDTO obj=" + teacherDTO);
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return teachermsDTO;
	}

	@Override
	public void CreateTeacher(TeachermsDTO teacherDTO) {
		try {
			// Load the Driver
			Connection conn = connnectionObj();
			// Create Statement
			PreparedStatement pStmt = conn.prepareStatement
					("insert into teacher_details (name, age, height, salary, email) values (?, ?, ?, ?, ?)");
			pStmt.setString(1, teacherDTO.getName());
			pStmt.setInt(2, teacherDTO.getAge());
			pStmt.setInt(3, teacherDTO.getHeight());
			pStmt.setLong(4, teacherDTO.getSalary());
			pStmt.setString(5, teacherDTO.getEmail());
			// Execute Query
			boolean insertStatus = pStmt.execute();
			System.out.println("insertStatus--->" + insertStatus);
//			int i = 0;
		} catch (SQLException sqlEx) {
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

	@Override
	public TeachermsDTO getTeacher(int teacherid) {
		if (teacherid > 0) {
			TeachermsDTO teacherDTO = null;
			try {
				Connection conn = connnectionObj();
				// Create Statement
				Statement stmt = conn.createStatement();
				// Execute Query
				ResultSet rs = stmt.executeQuery("select * from teacher_details where id=" + teacherid);
				// iterate the Resultset
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					int age = rs.getInt("age");
					int height = rs.getInt("height");
					long salary = rs.getLong("salary");
					String email = rs.getString("email");
					teacherDTO = createEmployeeObj(id, name, age, height, salary, email);
				}
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			if (teacherDTO == null) {
				throw new InvalidException("No Matching records found. Please check the employeeid", "TRMS102");
			}
			return teacherDTO;
		} else {
			throw new InvalidException("Your input is invalid", "TRMS101");
		}
	}
	
	@Override
	public void DeleteTeacher(int teacherid) {
		try {
			//Load the Driver
			Connection conn = connnectionObj();
			//Create Statement
			PreparedStatement pStmt = conn.prepareStatement("Delete from teacher_details  where id="+teacherid);
			boolean insertStatus = pStmt.execute();
			System.out.println("insertStatus--->"+insertStatus);
		} 
		catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	@Override
	public void UpdateTeacher(TeachermsDTO teacherDTO,int teacherid) {
		try {
			//Load the Driver
			Connection conn = connnectionObj();
			//Create Statement
			PreparedStatement pStmt = conn.prepareStatement
					("update teacher_details set name=?,age=?,height=?,salary=?,email=? where id="+teacherid);
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
}
