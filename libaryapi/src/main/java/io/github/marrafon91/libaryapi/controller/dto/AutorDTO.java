package io.github.marrafon91.libaryapi.controller.dto;

import io.github.marrafon91.libaryapi.model.Autor;

import java.time.LocalDate;
import java.util.UUID;

public record AutorDTO(
        UUID id,
        String nome,
        LocalDate dataNascimento,
        String nacionalidade) {


    public Autor mapearParaAutor() {
        Autor autor = new Autor();
        autor.setName(this.nome);
        autor.setDataNascimento(this.dataNascimento);
        autor.setNacionalidade(this.nacionalidade);
        return autor;
    }
}
