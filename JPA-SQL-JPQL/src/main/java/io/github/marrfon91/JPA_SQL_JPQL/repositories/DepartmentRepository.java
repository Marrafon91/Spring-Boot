package io.github.marrfon91.JPA_SQL_JPQL.repositories;

import io.github.marrfon91.JPA_SQL_JPQL.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
