package com.ias.cleanarchitecture.cleanarchitectureej.infrastructure.adapters.jpa;

import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.Subject.Subject;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.gateways.ISubjectRepository;
import com.ias.cleanarchitecture.cleanarchitectureej.infrastructure.adapters.jpa.entity.SubjectDBO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

@Repository
@AllArgsConstructor
@ResponseStatus(HttpStatus.CREATED)
public class SubjectAdapterRepository implements ISubjectRepository {

	private final ISubjectAdapterRepository iSubjectAdapterRepository;

	@Override
	@ResponseStatus(value = HttpStatus.CREATED)
	public Subject saveSubject(Subject subject) {
		SubjectDBO subjectDBO = SubjectDBO.subjectDBOfromDomain(subject);
		SubjectDBO savedSubject = iSubjectAdapterRepository.save(subjectDBO);
		Subject subjectConverted =savedSubject.subjectDBOToDomain(savedSubject);
		return subjectConverted;
	}
}
