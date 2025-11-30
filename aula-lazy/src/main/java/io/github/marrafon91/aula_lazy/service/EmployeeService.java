package io.github.marrafon91.aula_lazy.service;

import io.github.marrafon91.aula_lazy.dto.EmployeeDepartmentDTO;
import io.github.marrafon91.aula_lazy.dto.EmployeeMinDTO;
import io.github.marrafon91.aula_lazy.entities.Employee;
import io.github.marrafon91.aula_lazy.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Transactional(readOnly = true)
    public EmployeeMinDTO findByIdMin(Long id) {
        Optional<Employee> result = repository.findById(id);
        return new EmployeeMinDTO(result.get());
    }

    @Transactional(readOnly = true)
    public EmployeeDepartmentDTO findByIdWithDepartment(Long id) {
        Optional<Employee> result = repository.findById(id);
        return new EmployeeDepartmentDTO(result.get());
    }

    @Transactional(readOnly = true)
    public List<EmployeeDepartmentDTO> findEmployeesWithDepartments() {
        List<Employee> result = repository.findEmployeesWithDepartments();
        return result.stream().map(x -> new EmployeeDepartmentDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<EmployeeMinDTO> findByName(String name) {
        List<Employee> result = repository.findByNameContainingIgnoreCase(name);
        return result.stream().map(x -> new EmployeeMinDTO(x)).toList();
    }
}
