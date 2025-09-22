package io.github.marrafon91.libaryapi.controller;

import io.github.marrafon91.libaryapi.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("livros")
//@RequiredArgsConstructor
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }
}
