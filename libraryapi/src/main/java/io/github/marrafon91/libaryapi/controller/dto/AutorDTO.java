package io.github.marrafon91.libaryapi.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

@Schema(name = "Autor")
public record AutorDTO(
        UUID id,
        @NotBlank(message = "Campo obrigatorio")
        @Size(min = 2, max = 100, message = "Campo fora do tamanho padrao")
        @Schema(name = "nome")
        String nome,
        @NotNull(message = "Campo obrigatorio")
        @Past(message = "Não pode ser uma data futura")
        @Schema(name = "dataNascimento")
        LocalDate dataNascimento,
        @Size(min = 2,max = 50, message = "Campo fora do tamanho padrao")
        @NotBlank(message = "Campo obrigatorio")
        @Schema(name = "nacionalidade")
        String nacionalidade) {

}
