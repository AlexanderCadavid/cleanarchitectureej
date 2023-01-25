package com.ias.cleanarchitecture.cleanarchitectureej.infrastructure.entrypoint;

import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.Subject.dto.SubjectDTO;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.use_cases.SubjectUseCase;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/subject")
@AllArgsConstructor
public class SubjectEntryPoint {

	private final SubjectUseCase subjectUseCase;

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public SubjectDTO saveSubject(@RequestBody SubjectDTO subjectDTO) {
		return subjectUseCase.saveSubject(subjectDTO);

	}

}
