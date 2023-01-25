package com.ias.cleanarchitecture.cleanarchitectureej.domain.model.Subject;

public class Subject {

	private final SubjectId id;
	private final SubjectName name;

	public Subject(SubjectId id, SubjectName name) {
		this.id = id;
		this.name = name;
	}

	public SubjectId getId() {
		return id;
	}

	public SubjectName getName() {
		return name;
	}
}
