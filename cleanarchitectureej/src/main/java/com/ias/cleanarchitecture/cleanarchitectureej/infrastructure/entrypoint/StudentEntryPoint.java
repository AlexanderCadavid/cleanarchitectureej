package com.ias.cleanarchitecture.cleanarchitectureej.infrastructure.entrypoint;

import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.student.dto.StudentDTO;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.use_cases.StudentUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentEntryPoint {

	private final StudentUseCase studentUseCase;

	@PostMapping("/save")
	@ResponseStatus(value = HttpStatus.CREATED)
	public StudentDTO saveStudent(@RequestBody StudentDTO studentDTO){
		return studentUseCase.saveStudent(studentDTO);
	}

	@GetMapping("/{id}")
	public StudentDTO findById(@PathVariable Long id) {
		return studentUseCase.findById(id);
	}

}
