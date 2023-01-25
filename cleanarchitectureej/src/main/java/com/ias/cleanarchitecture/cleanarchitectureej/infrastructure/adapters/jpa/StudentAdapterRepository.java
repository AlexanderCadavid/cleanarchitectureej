package com.ias.cleanarchitecture.cleanarchitectureej.infrastructure.adapters.jpa;

import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.gateways.IStudentRepository;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.student.Student;

import com.ias.cleanarchitecture.cleanarchitectureej.infrastructure.adapters.jpa.entity.StudentDBO;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Repository;



@Repository
@AllArgsConstructor
public class StudentAdapterRepository implements IStudentRepository {
	private final IStudentAdapterRepository iStudentAdapterRepository;

	@Override
	public Student findById(Long id) {
		StudentDBO studentDBO = StudentDBO.studentDBOformDomain(student);
		StudentDBO findStudent = iStudentAdapterRepository.findById();
		Student studentConverted = findStudent.studentDBOToDomain(findStudent);
		return studentConverted;
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

	@Override
	public Student getStudents(Student student) {
		return null;
	}

}
