package com.ias.cleanarchitecture.cleanarchitectureej.infrastructure.adapters.jpa.entity;


import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.student.*;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "student")
@Entity
public class StudentDBO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String name;
	private Integer phone;
	private String mail;

	public static StudentDBO studentDBOformDomain(Student student) {
		return new StudentDBO(
				student.getId().getValue(),
				student.getName().getValue(),
				student.getPhone().getValue(),
				student.getMail().getValue()

				);
	}

	public Student studentDBOToDomain(StudentDBO studentDBO){
		return new Student(
				new StudentId(studentDBO.getId()),
				new StudentName(studentDBO.getName()),
				new StudentPhone(studentDBO.getPhone()),
				new StudentMail(studentDBO.getMail())
		);
	}

}
