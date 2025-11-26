package io.github.marrfon91.JPA_SQL_JPQL.dto;

import io.github.marrfon91.JPA_SQL_JPQL.entities.Department;

public record DepartmentDTO(Long id,
                            String name
) {

    public DepartmentDTO(Department entity) {
        this(
                entity.getId(),
                entity.getName()
        );
    }
}