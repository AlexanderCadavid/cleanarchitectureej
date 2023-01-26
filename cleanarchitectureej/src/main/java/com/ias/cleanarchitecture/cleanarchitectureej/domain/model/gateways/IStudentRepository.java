package com.ias.cleanarchitecture.cleanarchitectureej.domain.model.gateways;

import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.student.Student;

import java.util.List;

public interface IStudentRepository {

	Student getById(Long id);

	Student saveStudent(Student student);

	List<Student> getALL();
}
