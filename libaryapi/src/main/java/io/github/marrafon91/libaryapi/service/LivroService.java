package io.github.marrafon91.libaryapi.service;

import io.github.marrafon91.libaryapi.model.GeneroLivro;
import io.github.marrafon91.libaryapi.model.Livro;
import io.github.marrafon91.libaryapi.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static io.github.marrafon91.libaryapi.repository.specs.LivroSpecs.*;

@Service
@RequiredArgsConstructor
public class LivroService {

    private  final LivroRepository repository;

    public Livro salvar(Livro livro) {
       return repository.save(livro);
    }

    public Optional<Livro> obeterPorId(UUID id) {
        return repository.findById(id);
    }

    public void deletar(Livro livro) {
        repository.delete(livro);
    }

    public List<Livro> pesquisa(String isbn, String titulo, String nomeAutor, GeneroLivro genero, Integer anoPublicacao) {

//        Specification<Livro> specs = Specification
//                .where(LivroSpecs.isbnEqual(isbn))
//                .and(LivroSpecs.tituloLike(titulo))
//                .and(LivroSpecs.generoEqual(genero))git
        Specification<Livro> specs = Specification.where((root, query, cb) -> cb.conjunction());

        if (isbn != null && !isbn.isBlank()) {
            specs = specs.and(isbnEqual(isbn));
        }
        if (titulo != null && !titulo.isBlank()) {
            specs = specs.and(tituloLike(titulo));
        }
        if (genero != null) {
            specs = specs.and(generoEqual(genero));
        }
        if (nomeAutor != null && !nomeAutor.isBlank()) {
            specs = specs.and(nomeAutorLike(nomeAutor));
        }
        if (anoPublicacao != null) {
            specs = specs.and(anoPublicacaoEqual(anoPublicacao));
        }
        return  repository.findAll(specs);
    }
}
