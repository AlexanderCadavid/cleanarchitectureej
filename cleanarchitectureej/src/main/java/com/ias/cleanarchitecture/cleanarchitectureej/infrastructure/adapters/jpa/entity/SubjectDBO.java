package com.ias.cleanarchitecture.cleanarchitectureej.infrastructure.adapters.jpa.entity;

import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.Subject.Subject;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.Subject.SubjectId;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.Subject.SubjectName;
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
@Table(name = "subject")
@Entity
public class SubjectDBO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@NotNull
	private String name;

	public static SubjectDBO subjectDBOfromDomain(Subject subject){
		return new SubjectDBO(
				subject.getId().getValue(),
				subject.getName().getValue()
		);
	}

	public  Subject subjectDBOToDomain (SubjectDBO subjectDBO){
		return  new Subject(
				new SubjectId(subjectDBO.getId()),
				new SubjectName(subjectDBO.getName())
		);
	}
}
