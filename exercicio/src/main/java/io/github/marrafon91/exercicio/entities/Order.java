package io.github.marrafon91.exercicio.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Order {
    private final Integer code;
    private final Double basic;
    private final Double discount;
}
