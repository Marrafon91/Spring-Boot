package io.github.marrafon91.uri.dto;

import io.github.marrafon91.uri.projections.CustomerMinProjection;

public record CustomerMinDTO(String name) {

    public CustomerMinDTO {
    }

    public CustomerMinDTO(CustomerMinProjection projection) {
        this(
                projection.getName()
        );
    }

    @Override
    public String toString() {
        return "CustomerMinDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
