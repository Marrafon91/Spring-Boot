package io.github.marrafon91.libaryapi.service;

import io.github.marrafon91.libaryapi.model.Livro;
import io.github.marrafon91.libaryapi.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LivroService {

    private  final LivroRepository repository;

    public Livro salvar(Livro livro) {
       return repository.save(livro);
    }
}
