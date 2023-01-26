package com.ias.cleanarchitecture.cleanarchitectureej.domain.use_cases;

import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.Subject.Subject;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.Subject.dto.SubjectDTO;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.gateways.ISubjectRepository;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.student.dto.StudentDTO;

import java.util.List;
import java.util.stream.Collectors;


public class SubjectUseCase {

	private final ISubjectRepository iSubjectRepository;

	public SubjectUseCase(ISubjectRepository iSubjectRepository) {
		this.iSubjectRepository = iSubjectRepository;
	}

	public SubjectDTO saveSubject(SubjectDTO subjectDTO) {
		Subject subject = subjectDTO.subjectDTOToDomain(subjectDTO);
		return subjectDTO.subjectDTOFromDomain(iSubjectRepository.saveSubject(subject));
	}
		public SubjectDTO getById(Long id) {
			SubjectDTO subjectDTO = new SubjectDTO().subjectDTOFromDomain(iSubjectRepository.getById(id));
			return subjectDTO;
	}

	public List<SubjectDTO> getAll() {
		List<SubjectDTO> list = iSubjectRepository.subjectGetAll().stream().map(SubjectDTO->new SubjectDTO()).collect(Collectors.toList());
		return list;
	}
}
