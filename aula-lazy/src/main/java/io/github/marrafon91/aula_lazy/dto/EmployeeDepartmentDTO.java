package io.github.marrafon91.aula_lazy.dto;

import io.github.marrafon91.aula_lazy.entities.Employee;

public record EmployeeDepartmentDTO(Long id,
                                    String name,
                                    String email,
                                    DepartmentDTO department
) {
    public EmployeeDepartmentDTO(Employee entity) {
        this(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                new DepartmentDTO(entity.getDepartment())
        );
    }
}
