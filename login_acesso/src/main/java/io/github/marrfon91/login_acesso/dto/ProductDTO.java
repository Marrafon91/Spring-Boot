package io.github.marrfon91.login_acesso.dto;

import io.github.marrfon91.login_acesso.entities.Product;

public record ProductDTO(
        Long id,
        String name
) {

    public ProductDTO(Product entity){
        this (
                entity.getId(),
                entity.getName()
        );
    }
}
