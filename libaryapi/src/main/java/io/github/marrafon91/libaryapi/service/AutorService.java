package io.github.marrafon91.libaryapi.service;

import io.github.marrafon91.libaryapi.exceptions.OperacaoNaoPermitidaException;
import io.github.marrafon91.libaryapi.model.Autor;
import io.github.marrafon91.libaryapi.repository.AutorRepository;
import io.github.marrafon91.libaryapi.repository.LivroRepository;
import io.github.marrafon91.libaryapi.validator.AutorValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

public class AutorService {

    private final AutorRepository repository;
    private final AutorValidator validator;
    private final LivroRepository livroRepository;

    public AutorService(AutorRepository repository, AutorValidator validator, LivroRepository livroRepository){
        this.repository = repository;
        this.validator = validator;
        this.livroRepository = livroRepository;
    }

    public Autor salvar(Autor autor) {
        validator.validar(autor);
        return repository.save(autor);
    }

    @Transactional
    public void atualizar(Autor autor) {
        if (autor.getId() == null) {
            throw new IllegalArgumentException("Para atualizar, é necessario que o autor ja esteja salvo na base.");
        }
        validator.validar(autor);
         repository.save(autor);
    }

    public Optional<Autor> obterPorId(UUID id) {
        return repository.findById(id);
    }

    public void deletar(Autor autor) {
        if (possuiLivro(autor)) {
            throw new OperacaoNaoPermitidaException("Não é permitido excluir um Autor que possui livros cadastrados!");
        }
        repository.delete(autor);
    }

    public List<Autor> pesquisa(String nome, String nacionalidade) {
        if (nome != null && nacionalidade != null) {
            return repository.findByNomeAndNacionalidade(nome, nacionalidade);
        }

        if (nome != null) {
            return repository.findByNome(nome);
        }

        if (nacionalidade != null) {
            return repository.findByNacionalidade(nacionalidade);
        }

        return repository.findAll();
    }

    public boolean possuiLivro(Autor autor) {
        return livroRepository.existsByAutor(autor);
    }
}

