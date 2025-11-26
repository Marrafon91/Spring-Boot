package io.github.marrafon91.salvarParaMuitos.dto;

import io.github.marrafon91.salvarParaMuitos.entities.Category;

public record CategoryDTO(Long id,
                          String name
) {
    public CategoryDTO(Category entity) {
        this (
                entity.getId(),
                entity.getName()
        );
    }
}
