package io.github.marrafon91.libaryapi.service;

import io.github.marrafon91.libaryapi.model.GeneroLivro;
import io.github.marrafon91.libaryapi.model.Livro;
import io.github.marrafon91.libaryapi.model.Usuario;
import io.github.marrafon91.libaryapi.repository.LivroRepository;
import io.github.marrafon91.libaryapi.security.SecurityService;
import io.github.marrafon91.libaryapi.validator.LivroValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    private final LivroValidator validator;
    private final SecurityService securityService;

    public Livro salvar(Livro livro) {
        validator.validar(livro);
        Usuario usuario = securityService.obterUsuarioLogado();
        livro.setUsuario(usuario);
       return repository.save(livro);
    }

    public Optional<Livro> obeterPorId(UUID id) {
        return repository.findById(id);
    }

    public void deletar(Livro livro) {
        repository.delete(livro);
    }

    public Page<Livro> pesquisa(
            String isbn,
            String titulo,
            String nomeAutor,
            GeneroLivro genero,
            Integer anoPublicacao,
            Integer pagina,
            Integer tamanhoPagina) {

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
        if (anoPublicacao != null) {
            specs = specs.and(anoPublicacaoEqual(anoPublicacao));
        }
        if (nomeAutor != null && !nomeAutor.isBlank()) {
            specs = specs.and(nomeAutorLike(nomeAutor));
        }

        Pageable pageRequest = PageRequest.of(pagina, tamanhoPagina);

        return  repository.findAll(specs, pageRequest);
    }

    public void atualizar(Livro livro) {
        if (livro.getId() == null) {
            throw new IllegalArgumentException("Para atualizar, é necessario que o livro ja esteja salvo na base.");
        }
        validator.validar(livro);
        repository.save(livro);
    }
}
