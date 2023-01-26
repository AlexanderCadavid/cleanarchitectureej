package com.ias.cleanarchitecture.cleanarchitectureej.infrastructure.adapters;

import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.Subject.Subject;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.Subject.SubjectId;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.Subject.SubjectName;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.gateways.ISubjectRepository;
import com.ias.cleanarchitecture.cleanarchitectureej.infrastructure.adapters.jpa.SubjectAdapterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SubjectRepositoryAdapterTest {

	@Autowired
	ISubjectRepository iSubjectRepository;
	@InjectMocks
	SubjectAdapterRepository subjectAdapterRepository;

	@BeforeAll
	void init(){
		subjectAdapterRepository = new SubjectAdapterRepository(iSubjectRepository);
	}

	@Test
	void saveSubject(){
		Subject subject = new Subject(new SubjectId(1l), new SubjectName("Name"));

		Subject subjectDBO =subjectAdapterRepository.saveSubject(subject);

		Assertions.assertEquals("Name", subjectDBO.getName().getValue());
	}

}
