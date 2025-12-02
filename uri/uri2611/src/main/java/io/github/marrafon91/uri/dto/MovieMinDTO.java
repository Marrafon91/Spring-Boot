package io.github.marrafon91.uri.dto;

import io.github.marrafon91.uri.projections.MovieMinProjection;

public record MovieMinDTO(Long id, String name) {

    public MovieMinDTO {
    }

    public MovieMinDTO(MovieMinProjection projection) {
        this (
                projection.getId(),
                projection.getName()
        );
    }

    @Override
    public String toString() {
        return "MovieMinDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
