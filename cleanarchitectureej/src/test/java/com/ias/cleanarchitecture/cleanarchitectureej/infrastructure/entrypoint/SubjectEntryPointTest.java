package com.ias.cleanarchitecture.cleanarchitectureej.infrastructure.entrypoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.Subject.dto.SubjectDTO;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.use_cases.SubjectUseCase;
import com.ias.cleanarchitecture.cleanarchitectureej.infrastructure.adapters.jpa.entity.SubjectDBO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(SubjectEntryPoint.class)
public class CourseEntryPointTest {

	@MockBean
	private SubjectUseCase subjectUseCase;

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("Save course ok")
	void saveCourse() {
		SubjectDTO subjectDTO = new SubjectDTO(1L, "Math");
		Mockito.when(subjectUseCase.saveSubject(Mockito.any(SubjectDTO.class)))
				.thenReturn(subjectDTO);
		ObjectMapper mapper = new ObjectMapper();
	}
}