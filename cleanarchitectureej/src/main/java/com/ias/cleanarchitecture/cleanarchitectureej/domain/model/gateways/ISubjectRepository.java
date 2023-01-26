package com.ias.cleanarchitecture.cleanarchitectureej.domain.model.gateways;

import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.Subject.Subject;

import java.util.Collection;
import java.util.List;

public interface ISubjectRepository {

	Subject saveSubject (Subject subject);

	Subject getById(Long id);

	List <Subject> subjectGetAll();
}
