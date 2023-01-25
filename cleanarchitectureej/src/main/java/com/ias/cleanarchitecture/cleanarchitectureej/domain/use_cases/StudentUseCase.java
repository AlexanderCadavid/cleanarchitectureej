package com.ias.cleanarchitecture.cleanarchitectureej.domain.use_cases;

import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.gateways.IStudentRepository;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.student.Student;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.student.dto.StudentDTO;

import java.util.List;
import java.util.Optional;

public class StudentUseCase {

	private final IStudentRepository iStudentRepository;

	public StudentUseCase(IStudentRepository iStudentRepository) {
		this.iStudentRepository = iStudentRepository;
	}

	public StudentDTO findById(Long id) {
		StudentDTO studentDTO = new StudentDTO().studentToStudentDTO(iStudentRepository.findById(id));
		return studentDTO;
	}

	public StudentDTO saveStudent(StudentDTO studentDTO) {
		Student student = studentDTO.studentDTOToDomain(studentDTO);
		return studentDTO.studentToStudentDTO(iStudentRepository.saveStudent(student));
	}

	public List<StudentDTO> getStudents(StudentDTO studentDTO) {

		return ; //se debe retornar la lisa de estudiantes encontrados
	}

	//validar logica
}
