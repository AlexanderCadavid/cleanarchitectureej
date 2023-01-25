package com.ias.cleanarchitecture.cleanarchitectureej.infrastructure.adapters.jpa;

import com.ias.cleanarchitecture.cleanarchitectureej.infrastructure.adapters.jpa.entity.SubjectDBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubjectAdapterRepository extends JpaRepository<SubjectDBO, Long> {
}
