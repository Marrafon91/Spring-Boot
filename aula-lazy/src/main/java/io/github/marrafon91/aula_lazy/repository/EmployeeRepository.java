package io.github.marrafon91.aula_lazy.repository;

import io.github.marrafon91.aula_lazy.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT obj FROM Employee obj JOIN FETCH obj.department")
    List<Employee> findEmployeesWithDepartments();

    List<Employee> findByNameContainingIgnoreCase(String name);
}

// site para consultas de Query Methods em JPA
// https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html#jpa.query-methods.at-query
