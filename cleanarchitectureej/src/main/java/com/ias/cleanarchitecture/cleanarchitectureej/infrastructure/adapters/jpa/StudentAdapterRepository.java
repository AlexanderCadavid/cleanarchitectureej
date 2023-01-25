package com.ias.cleanarchitecture.cleanarchitectureej.infrastructure.adapters.jpa;

import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.gateways.IStudentRepository;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.student.Student;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.student.dto.StudentDTO;
import com.ias.cleanarchitecture.cleanarchitectureej.infrastructure.adapters.jpa.entity.StudentDBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor

public class StudentAdapterRepository implements IStudentRepository {
	private final IStudentAdapterRepository iStudentAdapterRepository;

	@Override
	public Student findById(Long id) {
			return null;
		}

	@Override
	public Student saveStudent(Student student) {
		StudentDBO studentDBO = StudentDBO.studentDBOformDomain(student);
		StudentDBO savedStudent = iStudentAdapterRepository.save(studentDBO);
		Student studentConverted = savedStudent.studentDBOToDomain(savedStudent);
//		Optional<StudentDBO> aaa = iStudentAdapterRepository.findById(student.getId().getValue());
//		aaa.isPresent() return
		return studentConverted;
	}

}
