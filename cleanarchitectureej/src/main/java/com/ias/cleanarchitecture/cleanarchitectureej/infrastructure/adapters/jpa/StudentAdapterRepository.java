package com.ias.cleanarchitecture.cleanarchitectureej.infrastructure.adapters.jpa;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.gateways.IStudentRepository;
import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.student.Student;
import com.ias.cleanarchitecture.cleanarchitectureej.infrastructure.adapters.jpa.entity.StudentDBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
@AllArgsConstructor
public class StudentAdapterRepository implements IStudentRepository {

	private final IStudentAdapterRepository iStudentAdapterRepository;

	@Override
	public Student getById(Long id) {
		Optional<StudentDBO> studentDBO = iStudentAdapterRepository.findById(id);
		if (studentDBO.isEmpty()) throw new NoSuchElementException("El estudiante con " + id + "no existe");
		return StudentDBO.studentDBOToDomain(studentDBO.get());
		}

	@Override
	public Student saveStudent(Student student) {
		StudentDBO studentDBO = StudentDBO.studentDBOformDomain(student);
		StudentDBO savedStudent = iStudentAdapterRepository.save(studentDBO);
		Student studentConverted = savedStudent.studentDBOToDomain(savedStudent);

		return studentConverted;
	}

	@Override
	public List<Student> getALL() {
		List<Student> studentslist = iStudentAdapterRepository.findAll().stream().map(StudentDBO::studentDBOToDomain).collect(Collectors.toList());
		return studentslist;
	}

//	@Override
//	public Student getStudents(Student student) {
//		return null;
//	}

}
