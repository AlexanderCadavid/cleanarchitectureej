package com.ias.cleanarchitecture.cleanarchitectureej.domain.use_cases;

import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.gateways.IStudentRepository;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.student.Student;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.student.dto.StudentDTO;
import java.util.List;
import java.util.stream.Collectors;

public class StudentUseCase {

	private final IStudentRepository iStudentRepository;

	public StudentUseCase(IStudentRepository iStudentRepository) {
		this.iStudentRepository = iStudentRepository;
	}

	public StudentDTO saveStudent(StudentDTO studentDTO) {
		Student student = studentDTO.studentDTOToDomain(studentDTO);
		return studentDTO.studentToStudentDTO(iStudentRepository.saveStudent(student));
	}

	public List<StudentDTO> getALL(StudentDTO studentDTO) {
		List<StudentDTO> list = iStudentRepository.getALL().stream().map(StudentDTO->new StudentDTO()).collect(Collectors.toList());
		return list;
	}

	public StudentDTO getById(Long id) {
		StudentDTO studentDTO = new StudentDTO().studentToStudentDTO(iStudentRepository.getById(id));
		return studentDTO;
	}

	//validar logica
}
