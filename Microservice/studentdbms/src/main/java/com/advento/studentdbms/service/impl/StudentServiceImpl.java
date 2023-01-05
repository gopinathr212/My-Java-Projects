package com.advento.studentdbms.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Service;

import com.advento.studentdbms.dto.StudentDTO;
import com.advento.studentdbms.service.StudentService;


@Service(value="studentServiceImpl")
public class StudentServiceImpl implements StudentService{

	@Override
	public StudentDTO[] getAllStudents() {
		StudentDTO[] studentarrDTO = new StudentDTO[10];
//		EmployeeDTO employeerDTOs = new EmployeeDTO();
		try {
			//Load the Driver
			Class.forName("com.mysql.jdbc.Driver");
			//Establish the connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentms", "root", "root");
			//Create Statement
			Statement stmt = conn.createStatement();
			//Execute Query
			ResultSet rs = stmt.executeQuery("select * from student_details ");
			//iterate the Resultset
			int i = 0;
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String sClass = rs.getString("class");
				String gender=rs.getString("gender");
				String scName=rs.getString("school_name");
				String sAddress=rs.getString("student_address");
				StudentDTO studentDTO = createStudentObj(id, name, age, sClass, gender, scName, sAddress);
				studentarrDTO[i++] = studentDTO;
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return studentarrDTO;
	}
	
	@Override
	public StudentDTO getStudent(int studentid) {
		StudentDTO studentDTORe = new StudentDTO();
//		EmployeeDTO employeerDTOs = new EmployeeDTO();
		try {
			//Load the Driver
			Class.forName("com.mysql.jdbc.Driver");
			//Establish the connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentms", "root", "root");
			//Create Statement
			Statement stmt = conn.createStatement();
			//Execute Query
			ResultSet rs = stmt.executeQuery("select * from student_details where id="+studentid);
			//iterate the Resultset
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String sClass = rs.getString("class");
				String gender=rs.getString("gender");
				String scName=rs.getString("school_name");
				String sAddress=rs.getString("student_address");
				StudentDTO studentDTO = createStudentObj(id, name, age, sClass, gender, scName, sAddress);
				studentDTORe= studentDTO;
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return studentDTORe;
	}

	@Override
	public void CreateStudent(StudentDTO studentDTO) {
		try {
			//Load the Driver
			Class.forName("com.mysql.jdbc.Driver");
			//Establish the connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentms", "root", "root");
			//Create Statement
			PreparedStatement pStmt = conn.prepareStatement
					("insert into student_details (name, age, class, gender, school_name, student_address) values (?, ?, ?, ?, ?, ?)");
			pStmt.setString(1, studentDTO.getName());
			pStmt.setInt(2, studentDTO.getAge());
			pStmt.setString(3, studentDTO.getsClass());
			pStmt.setString(4, studentDTO.getGender());
			pStmt.setString(5, studentDTO.getScName());
			pStmt.setString(6, studentDTO.getsAddress());
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

	@Override
	public void UpdateStudent(StudentDTO studentDTO, int studentid) {
		try {
			//Load the Driver
			Class.forName("com.mysql.jdbc.Driver");
			//Establish the connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentms", "root", "root");
			//Create Statement
			PreparedStatement pStmt = conn.prepareStatement
					("update student_details set name=?,age=?,class=?,gender=?,school_name=?,student_address=? where id="+studentid);
			pStmt.setString(1, studentDTO.getName());
			pStmt.setInt(2, studentDTO.getAge());
			pStmt.setString(3, studentDTO.getsClass());
			pStmt.setString(4, studentDTO.getGender());
			pStmt.setString(5, studentDTO.getScName());
			pStmt.setString(6, studentDTO.getsAddress());
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

	@Override
	public void DeleteStudent(int studentid) {
		try {
			//Load the Driver
			Class.forName("com.mysql.jdbc.Driver");
			//Establish the connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentms", "root", "root");
			//Create Statement
			PreparedStatement pStmt = conn.prepareStatement("Delete from student_details  where id="+studentid);
//			pStmt.setString(1, employeeDTO.getName());
//			pStmt.setInt(2, employeeDTO.getAge());
//			pStmt.setString(3, employeeDTO.getEmail());
//			//Execute Query
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

	@Override
	public void PatchStudent(StudentDTO studentDTO, int studentid) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Establish the connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentms", "root", "root");

			StudentDTO patchstudentDTO = getStudent(studentid);
			if (studentDTO.getName() != null && !studentDTO.getName().trim().equals("")) {
				patchstudentDTO.setName(studentDTO.getName());
			}
			if (studentDTO.getAge() != 0) {
				patchstudentDTO.setAge(studentDTO.getAge());
			}
			if (studentDTO.getGender() != null && !studentDTO.getGender().trim().equals("")) {
				patchstudentDTO.setGender(studentDTO.getGender());
			}
			if (studentDTO.getsClass() != null && !studentDTO.getsClass().trim().equals("")) {
				patchstudentDTO.setsClass(studentDTO.getsClass());
			}
			if (studentDTO.getScName() != null && !studentDTO.getScName().trim().equals("")) {
				patchstudentDTO.setScName(studentDTO.getScName());
			}
			if (studentDTO.getsAddress() != null && !studentDTO.getsAddress().trim().equals("")) {
				patchstudentDTO.setsAddress(studentDTO.getsAddress());
			}
			//Update Query			
			PreparedStatement pStmt = conn.prepareStatement
					(("update student_details set name=?,age=?,class=?,gender=?,school_name=?,student_address=? where id="+studentid));
			pStmt.setString(1, studentDTO.getName());
			pStmt.setInt(2, studentDTO.getAge());
			pStmt.setString(3, studentDTO.getsClass());
			pStmt.setString(4, studentDTO.getGender());
			pStmt.setString(5, studentDTO.getScName());
			pStmt.setString(6, studentDTO.getsAddress());
			//Execute Query
			int updStatus = pStmt.executeUpdate();
			System.out.println("updateStatus--->"+updStatus);
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private StudentDTO createStudentObj(int id, String name, int age, String sClass,String gender,String scName,String sAddress) {
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(id);
		studentDTO.setName(name);
		studentDTO.setAge(age);
		studentDTO.setsClass(sClass);
		studentDTO.setGender(gender);
		studentDTO.setScName(scName);
		studentDTO.setsAddress(sAddress);
		return studentDTO;
	}

}
