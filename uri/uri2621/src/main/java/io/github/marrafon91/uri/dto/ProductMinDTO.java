package io.github.marrafon91.uri.dto;

import io.github.marrafon91.uri.projection.ProductMinProjection;

public record ProductMinDTO(String name) {

    public ProductMinDTO {
    }

    public ProductMinDTO(ProductMinProjection projection) {
        this (
                projection.getName()
        );
    }

    @Override
    public String toString() {
        return "ProductMinDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
