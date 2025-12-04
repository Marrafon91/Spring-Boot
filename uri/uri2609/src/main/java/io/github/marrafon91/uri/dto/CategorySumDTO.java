package io.github.marrafon91.uri.dto;

import io.github.marrafon91.uri.projection.CategorySumProjection;

public record CategorySumDTO(String name, Long sum) {

    public CategorySumDTO {
    }

    public CategorySumDTO(CategorySumProjection projection) {
        this(
                projection.getName(),
                projection.getSum()
        );
    }

    @Override
    public String toString() {
        return "CategorySumDTO{ " +
                "name=' " + name + '\'' +
                ", sum= " + sum +
                '}';
    }
}
