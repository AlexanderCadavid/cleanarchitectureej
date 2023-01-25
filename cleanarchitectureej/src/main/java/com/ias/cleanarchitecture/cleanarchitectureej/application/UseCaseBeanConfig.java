package com.ias.cleanarchitecture.cleanarchitectureej.application;

import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.gateways.IStudentRepository;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.gateways.ISubjectRepository;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.use_cases.StudentUseCase;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.use_cases.SubjectUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfig {

	@Bean
	public StudentUseCase studentUseCase(IStudentRepository iStudentRepository) {
		return new StudentUseCase(iStudentRepository);
	}

	@Bean
	public SubjectUseCase subjectUseCase(ISubjectRepository iSubjectRepository){
		return new SubjectUseCase(iSubjectRepository);
	}
}
