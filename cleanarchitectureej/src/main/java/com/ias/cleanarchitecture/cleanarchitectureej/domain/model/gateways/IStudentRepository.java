package com.ias.cleanarchitecture.cleanarchitectureej.domain.model.gateways;

import com.ias.cleanarchitecture.cleanarchitectureej.domain.model.student.Student;

public interface IStudentRepository {

	Student findById(Long id);

	Student saveStudent(Student student);


}
