package io.github.marrafon91.libaryapi.repository;

import io.github.marrafon91.libaryapi.model.Autor;
import io.github.marrafon91.libaryapi.model.GeneroLivro;
import io.github.marrafon91.libaryapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    AutorRepository repository;

    @Autowired
    LivroRepository livroRepository;

    @Test
    public void salvarTest() {
        Autor autor = new Autor();
        autor.setNome("Maria");
        autor.setNacionalidade("Brasileira");
        autor.setDataNascimento(LocalDate.of(1960, 7, 19));

        var autorSalvo = repository.save(autor);
        System.out.println("Autor Salvo: " + autorSalvo);
    }

    @Test
    public void atualizarTest() {
       var id = UUID.fromString("c4351ef2-c8c1-4a9d-aa6c-f0207f8c5900");

       Optional<Autor> possivelAutor = repository.findById(id);

       if (possivelAutor.isPresent()) {

           Autor autorEncontrado = possivelAutor.get();
           System.out.println("Dados do Autor:");
           System.out.println(autorEncontrado);

           autorEncontrado.setDataNascimento(LocalDate.of(1960, 11, 7));

           repository.save(autorEncontrado);
       }
    }

    @Test
    public void listarTest() {
        List<Autor> lista = repository.findAll();
        lista.forEach(System.out::println);
    }

    @Test
    public void countTest() {
        System.out.println("Contagem de autores: " + repository.count());
    }

    @Test
    public void deletePorIdTest() {
        var id = UUID.fromString("804e511f-c719-4411-b0d9-dd0525e977b4");
        repository.deleteById(id);
    }

    @Test
    public void deleteTest() {
        var id = UUID.fromString("c4351ef2-c8c1-4a9d-aa6c-f0207f8c5900");
        var maria = repository.findById(id).get();
        repository.delete(maria);
    }

    @Test
    void atualizarAutorDoLivro() {
        UUID id = UUID.fromString("804e511f-c719-4411-b0d9-dd0525e977b4");
        var livroParaAutalizar = repository.findById(id).orElse(null);
    }

    @Test
    void salvarAutorComLivrosTest() {
        Autor autor = new Autor();
        autor.setNome("Antonio");
        autor.setNacionalidade("Americano");
        autor.setDataNascimento(LocalDate.of(1970, 8, 5));

        Livro livro = new Livro();
        livro.setIsbn("76533-87114");
        livro.setPreco(BigDecimal.valueOf(204));
        livro.setGenero(GeneroLivro.MISTERIO);
        livro.setTitulo("O roubo a casa assombrada");
        livro.setDataPublicacao(LocalDate.of(1999, 7, 12));
        livro.setAutor(autor);

        Livro livro2 = new Livro();
        livro2.setIsbn("41320-77389");
        livro2.setPreco(BigDecimal.valueOf(159));
        livro2.setGenero(GeneroLivro.ROMANCE);
        livro2.setTitulo("A verdade nua e crua");
        livro2.setDataPublicacao(LocalDate.of(2009, 11, 25));
        livro2.setAutor(autor);

        autor.setLivros(new ArrayList<>());
        autor.getLivros().add(livro);
        autor.getLivros().add(livro2);

        repository.save(autor);
        livroRepository.saveAll(autor.getLivros());
    }

    @Test
    void listarLivrosAutor() {
        var id = UUID.fromString("4e2764db-274c-40c8-9c11-87b4de8443ee");
        var autor = repository.findById(id).get();

        //buscara os livros do autor
        List<Livro> livrosLista = livroRepository.findByAutor(autor);
        autor.setLivros(livrosLista);

        autor.getLivros().forEach(System.out::println);
    }
}
