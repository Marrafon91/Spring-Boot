package io.github.marrafon91.salvarParaMuitos.dto;

import io.github.marrafon91.salvarParaMuitos.entities.Product;

import java.util.List;

public record ProductDTO(Long id,
                         String name,
                         Double price,
                         List<CategoryDTO> categories
) {
    public ProductDTO(Product entity) {
        this(
                entity.getId(),
                entity.getName(),
                entity.getPrice(),
                entity.getCategories()
                        .stream()
                        .map(CategoryDTO::new)
                        .toList()
        );

    }
}
