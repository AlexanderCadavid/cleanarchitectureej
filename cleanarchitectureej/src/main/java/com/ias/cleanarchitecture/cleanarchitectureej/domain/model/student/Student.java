package com.ias.cleanarchitecture.cleanarchitectureej.domain.model.student;

public class Student {

	private final StudentId id;
	private final StudentName name;
	private final StudentPhone phone;
	private final StudentMail mail;

	public Student(StudentId id, StudentName name, StudentPhone phone, StudentMail mail) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.mail = mail;
	}

	public StudentId getId() {
		return id;
	}

	public StudentName getName() {
		return name;
	}

	public StudentPhone getPhone() {
		return phone;
	}

	public StudentMail getMail() {
		return mail;
	}
}
