package com.ias.cleanarchitecture.cleanarchitectureej.domain.use_cases;

import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.Subject.Subject;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.Subject.dto.SubjectDTO;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.gateways.ISubjectRepository;

public class SubjectUseCase {

	private final ISubjectRepository iSubjectRepository;

	public SubjectUseCase(ISubjectRepository iSubjectRepository) {
		this.iSubjectRepository = iSubjectRepository;
	}

	public SubjectDTO saveSubject(SubjectDTO subjectDTO) {
		Subject subject = subjectDTO.subjectDTOToDomain(subjectDTO);
		return subjectDTO.subjectDTOFromDomain(iSubjectRepository.saveSubject(subject));
	}
}
