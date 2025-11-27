package io.github.marrafon91.aula_lazy.repository;

import io.github.marrafon91.aula_lazy.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
