package io.github.marrafon91.libaryapi.controller.dto;

import java.time.LocalDate;

public record AutorDTO(
        String nome,
        LocalDate dataNascimento,
        String nacionalidade) {
}
