package io.github.marrafon91.libaryapi.controller;

import io.github.marrafon91.libaryapi.controller.dto.AutorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("autores")
public class AutorController {

    @PostMapping
    public ResponseEntity<AutorDTO> salvar(@RequestBody AutorDTO autor) {

        return new  ResponseEntity("Autor salvo com sucesso! " + autor, HttpStatus.CREATED);
    }
}
