package io.github.marrfon91.JPA_SQL_JPQL.dto;

import io.github.marrfon91.JPA_SQL_JPQL.entities.Person;

public record PersonDTO(Long id,
                        String name,
                        Double salary,
                        Long departmentId
) {
    public PersonDTO(Person entity) {
        this(
                entity.getId(),
                entity.getName(),
                entity.getSalary(),
                entity.getDepartment().getId()
        );
    }
}
