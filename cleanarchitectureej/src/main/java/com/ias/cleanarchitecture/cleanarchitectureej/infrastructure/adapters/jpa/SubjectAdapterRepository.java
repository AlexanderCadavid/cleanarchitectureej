package com.ias.cleanarchitecture.cleanarchitectureej.infrastructure.adapters.jpa;

import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.Subject.Subject;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.gateways.ISubjectRepository;
import com.ias.cleanarchitecture.cleanarchitectureej.infrastructure.adapters.jpa.entity.SubjectDBO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
@ResponseStatus(HttpStatus.CREATED)
public class SubjectAdapterRepository implements ISubjectRepository {

	private final ISubjectAdapterRepository iSubjectAdapterRepository;

	@Override
	@ResponseStatus(value = HttpStatus.CREATED)
	public Subject saveSubject(Subject subject) {
		SubjectDBO subjectDBO =  SubjectDBO.subjectDBOfromDomain(subject);
		SubjectDBO savedSubject = iSubjectAdapterRepository.save(subjectDBO);
		Subject subjectConverted =savedSubject.subjectDBOToDomain(savedSubject);
		return subjectConverted;
	}

	@Override
	public Subject getById(Long id) {
		Optional<SubjectDBO> subjectDBO = iSubjectAdapterRepository.findById(id);
		if (subjectDBO.isEmpty()) throw new NoSuchElementException("La materia con " + id + "no existe");
		return SubjectDBO.subjectDBOToDomain(subjectDBO.get());
	}

	@Override
	public List<Subject> subjectGetAll() {
		List<Subject> subjectList = iSubjectAdapterRepository.findAll().stream().map(SubjectDBO::subjectDBOToDomain).collect(Collectors.toList());
		return subjectList;
	}
}


