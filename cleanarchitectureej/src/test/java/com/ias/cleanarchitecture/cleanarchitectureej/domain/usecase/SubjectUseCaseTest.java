package com.ias.cleanarchitecture.cleanarchitectureej.domain.usecase;

import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.Subject.Subject;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.Subject.dto.SubjectDTO;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.gateways.ISubjectRepository;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.use_cases.SubjectUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

@SpringBootTest
public class SubjectUseCaseTest {

	@Mock
	private ISubjectRepository iSubjectRepository;
	@InjectMocks
	private SubjectUseCase subjectUseCase;

	@Test
	void saveSubject() {
		SubjectDTO subjectDTO = new SubjectDTO(1L, "Math");
		Subject subject = SubjectDTO.toSubject(subjectDTO);
		when(iSubjectRepository.saveSubject(any(Subject.class))).thenReturn(subject);

		SubjectDTO answer = subjectUseCase.saveSubject(subjectDTO);

		assertNotNull(answer);
		assertEquals(answer.getName(), subjectDTO.getName());
	}
}
