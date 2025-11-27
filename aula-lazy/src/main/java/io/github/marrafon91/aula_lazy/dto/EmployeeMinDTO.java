package io.github.marrafon91.aula_lazy.dto;

import io.github.marrafon91.aula_lazy.entities.Employee;

public record EmployeeMinDTO(Long id,
                             String name,
                             String email
) {
    public EmployeeMinDTO(Employee entity) {
        this (
                entity.getId(),
                entity.getName(),
                entity.getEmail()
        );
    }
}
