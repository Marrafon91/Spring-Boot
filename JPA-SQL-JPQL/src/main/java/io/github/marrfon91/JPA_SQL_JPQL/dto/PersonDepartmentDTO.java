package io.github.marrfon91.JPA_SQL_JPQL.dto;

import io.github.marrfon91.JPA_SQL_JPQL.entities.Person;

public record PersonDepartmentDTO(
        Long id,
        String name,
        Double salary,
        DepartmentDTO department
) {

    public PersonDepartmentDTO(Person entity) {
        this(
                entity.getId(),
                entity.getName(),
                entity.getSalary(),
                new DepartmentDTO(entity.getDepartment())
        );
    }
}