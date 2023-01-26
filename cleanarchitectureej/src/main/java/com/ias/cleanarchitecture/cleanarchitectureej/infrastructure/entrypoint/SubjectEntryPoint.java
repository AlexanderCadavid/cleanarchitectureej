package com.ias.cleanarchitecture.cleanarchitectureej.infrastructure.entrypoint;

import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.Subject.dto.SubjectDTO;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.use_cases.SubjectUseCase;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/subject")
@AllArgsConstructor
public class SubjectEntryPoint {

	private final SubjectUseCase subjectUseCase;

	@PostMapping("/save")
	@ResponseStatus(value = HttpStatus.CREATED)
	public SubjectDTO saveSubject(@RequestBody SubjectDTO subjectDTO) {
		return subjectUseCase.saveSubject(subjectDTO);

	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable(name = "id") Long id) {
		SubjectDTO subject = subjectUseCase.getById(id);
		return new ResponseEntity<>(subject, HttpStatus.OK);
	}

	@GetMapping("/list")
	public ResponseEntity<?> getALL() {
		List<SubjectDTO> subjectDTOS = subjectUseCase.getAll();
		if(subjectDTOS.isEmpty()){
			return ResponseEntity.status(404).body("No hay asignaturas en la Base de datos");
		}
		return ResponseEntity.status(200).body(subjectDTOS);
	}

}
