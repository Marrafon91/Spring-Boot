package io.github.marrafon91.uri.dto;

import io.github.marrafon91.uri.projection.LawyerMinProjection;

public record LawyerMinDTO(String name, Integer customersNumber) {

    public LawyerMinDTO {
    }

    public LawyerMinDTO(LawyerMinProjection projection) {
        this(
                projection.getName(),
                projection.getCustomersNumber()
        );
    }

    @Override
    public String toString() {
        return "LawyerMinDTO{" +
                "name='" + name + '\'' +
                ", customersNumber=" + customersNumber +
                '}';
    }
}
