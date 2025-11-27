package io.github.marrafon91.aula_lazy.dto;

import io.github.marrafon91.aula_lazy.entities.Department;

public record DepartmentDTO(Long id,
                            String name
) {
    public DepartmentDTO(Department entity) {
        this (
                entity.getId(),
                entity.getName()
        );
    }
}
