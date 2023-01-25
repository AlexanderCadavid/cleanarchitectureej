package com.ias.cleanarchitecture.cleanarchitectureej.domain.model.gateways;

import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.Subject.Subject;

public interface ISubjectRepository {

	Subject saveSubject (Subject subject);
}
