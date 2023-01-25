package com.ias.cleanarchitecture.cleanarchitectureej.domain.use_cases;

import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.gateways.IStudentRepository;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.student.Student;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.student.dto.StudentDTO;

public class StudentUseCase {

	private final IStudentRepository iStudentRepository;

	public StudentUseCase(IStudentRepository iStudentRepository) {
		this.iStudentRepository = iStudentRepository;
	}

	public StudentDTO findById(Long id) {
		StudentDTO studentDTO = new StudentDTO.studentToStudentDTO(IStudentRepository.findById(id));
		return studentDTO;
	}

	public StudentDTO saveStudent(StudentDTO studentDTO) {
		Student student = studentDTO.studentDTOToDomain(studentDTO);
		return studentDTO.studentToStudentDTO(iStudentRepository.saveStudent(student));
	}

	//validar logica
}
