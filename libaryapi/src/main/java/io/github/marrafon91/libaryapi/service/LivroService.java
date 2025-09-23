package io.github.marrafon91.libaryapi.service;

import io.github.marrafon91.libaryapi.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class LivroService {

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    private  final LivroRepository repository;
}
