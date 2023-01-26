package com.ias.cleanarchitecture.cleanarchitectureej.domain.model.Subject.dto;

import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.Subject.Subject;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.Subject.SubjectId;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.Subject.SubjectName;

public class SubjectDTO {

	private Long id;
	private String name;

	public SubjectDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	public SubjectDTO(){

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

	public Subject subjectDTOToDomain(SubjectDTO subjectDTO){
		return new Subject (
				new SubjectId(subjectDTO.getId()),
				new SubjectName(subjectDTO.getName())
		);
	}

	public SubjectDTO subjectDTOFromDomain (Subject subject){
		return new SubjectDTO(
				subject.getId().getValue(),
				subject.getName().getValue()
		);
	}
}
