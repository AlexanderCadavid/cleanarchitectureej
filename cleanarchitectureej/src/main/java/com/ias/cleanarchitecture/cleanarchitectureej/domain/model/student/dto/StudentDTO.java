package com.ias.cleanarchitecture.cleanarchitectureej.domain.model.student.dto;

import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.student.*;


public class StudentDTO {

	private Long id;
	private String name;
	private Integer phone;
	private String mail;

	public StudentDTO(Long id, String name, Integer phone, String mail) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.mail = mail;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Student studentDTOToDomain(StudentDTO studentDTO){
		return new Student(
				new StudentId(studentDTO.getId()),
				new StudentName(studentDTO.getName()),
				new StudentPhone(studentDTO.getPhone()),
				new StudentMail(studentDTO.getMail())
		);
	}

	public StudentDTO studentToStudentDTO(Student student){
		return new StudentDTO (
				student.getId().getValue(),
				student.getName().getValue(),
				student.getPhone().getValue(),
				student.getMail().getValue()
		);
	}
}
