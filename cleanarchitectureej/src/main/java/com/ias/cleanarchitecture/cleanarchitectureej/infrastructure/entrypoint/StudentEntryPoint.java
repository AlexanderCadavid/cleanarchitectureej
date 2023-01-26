package com.ias.cleanarchitecture.cleanarchitectureej.infrastructure.entrypoint;

import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.student.dto.StudentDTO;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.use_cases.StudentUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	public ResponseEntity<?> getById(@PathVariable(name = "id") Long id) {
		StudentDTO student = studentUseCase.getById(id);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}

	@GetMapping("/list")
	public ResponseEntity<?> getALL() {
		List<StudentDTO> studentDTOS = new ArrayList<>() {
		};
		if(studentDTOS.isEmpty()){
			return ResponseEntity.status(404).body("No hay estudiantes en la base de datos");
		}
		return ResponseEntity.status(200).body(studentDTOS);
	}

}
