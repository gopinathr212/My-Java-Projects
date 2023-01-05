package com.advento.teacher.dto;

public class TeachermsDTO implements Comparable<TeachermsDTO>{
 
	private int id;
	
	private String name;
	
	private int age;
	
	private long salary;
	
	private int height;
	
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "teacher=(Teacher id= " + id +"name= " + name + ", Age= " + age + ",Salary= " + salary +",Height= "+height+
				",Email= "+email+")";
	}

	@Override
	public int compareTo(TeachermsDTO teacherDTO) {
		int result = this.email.compareTo(teacherDTO.getEmail());
		return result;
	}
}
